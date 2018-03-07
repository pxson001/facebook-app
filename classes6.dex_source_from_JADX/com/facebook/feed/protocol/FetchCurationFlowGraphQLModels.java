package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLParsers.FetchCurationFlowParser;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLParsers.FetchCurationFlowParser.FeedCurationFlowStepParser;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLParsers.FetchCurationFlowParser.FeedCurationFlowStepParser.ActionsParser;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLParsers.FetchCurationFlowParser.FeedCurationFlowStepParser.ActionsParser.TitleParser;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLParsers.FetchCurationFlowParser.FeedCurationFlowStepParser.CurrentActionParser;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLParsers.FetchCurationFlowParser.FeedCurationFlowStepParser.FeedbackTextParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackTargetType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
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

/* compiled from: movie_list */
public class FetchCurationFlowGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -38614404)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: movie_list */
    public final class FetchCurationFlowModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10196d;
        @Nullable
        private FeedCurationFlowStepModel f10197e;

        /* compiled from: movie_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchCurationFlowModel.class, new Deserializer());
            }

            public Object m15874a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchCurationFlowParser.m15924a(jsonParser);
                Object fetchCurationFlowModel = new FetchCurationFlowModel();
                ((BaseModel) fetchCurationFlowModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchCurationFlowModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchCurationFlowModel).a();
                }
                return fetchCurationFlowModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1431768565)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: movie_list */
        public final class FeedCurationFlowStepModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ActionsModel> f10192d;
            @Nullable
            private CurrentActionModel f10193e;
            @Nullable
            private FeedbackTextModel f10194f;
            private boolean f10195g;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -163174734)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: movie_list */
            public final class ActionsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f10186d;
                @Nullable
                private GraphQLNegativeFeedbackActionType f10187e;
                @Nullable
                private GraphQLNegativeFeedbackTargetType f10188f;
                @Nullable
                private TitleModel f10189g;

                /* compiled from: movie_list */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActionsModel.class, new Deserializer());
                    }

                    public Object m15875a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActionsParser.m15916b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actionsModel = new ActionsModel();
                        ((BaseModel) actionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actionsModel instanceof Postprocessable) {
                            return ((Postprocessable) actionsModel).a();
                        }
                        return actionsModel;
                    }
                }

                /* compiled from: movie_list */
                public class Serializer extends JsonSerializer<ActionsModel> {
                    public final void m15876a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActionsModel actionsModel = (ActionsModel) obj;
                        if (actionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actionsModel.m15883a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActionsParser.m15917b(actionsModel.w_(), actionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ActionsModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: movie_list */
                public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f10185d;

                    /* compiled from: movie_list */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                        }

                        public Object m15877a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TitleParser.m15914a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: movie_list */
                    public class Serializer extends JsonSerializer<TitleModel> {
                        public final void m15878a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TitleModel titleModel = (TitleModel) obj;
                            if (titleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(titleModel.m15879a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TitleParser.m15915a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TitleModel.class, new Serializer());
                        }
                    }

                    public TitleModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m15881a() {
                        this.f10185d = super.a(this.f10185d, 0);
                        return this.f10185d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m15880a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15879a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15881a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public ActionsModel() {
                    super(4);
                }

                @Nullable
                private String m15882m() {
                    this.f10186d = super.a(this.f10186d, 0);
                    return this.f10186d;
                }

                @Nullable
                public final GraphQLNegativeFeedbackActionType m15886j() {
                    this.f10187e = (GraphQLNegativeFeedbackActionType) super.b(this.f10187e, 1, GraphQLNegativeFeedbackActionType.class, GraphQLNegativeFeedbackActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f10187e;
                }

                @Nullable
                public final GraphQLNegativeFeedbackTargetType m15887k() {
                    this.f10188f = (GraphQLNegativeFeedbackTargetType) super.b(this.f10188f, 2, GraphQLNegativeFeedbackTargetType.class, GraphQLNegativeFeedbackTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f10188f;
                }

                @Nullable
                public final TitleModel m15888l() {
                    this.f10189g = (TitleModel) super.a(this.f10189g, 3, TitleModel.class);
                    return this.f10189g;
                }

                @Nullable
                public final String m15885a() {
                    return m15882m();
                }

                public final int jK_() {
                    return 654926288;
                }

                public final GraphQLVisitableModel m15884a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15888l() != null) {
                        TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m15888l());
                        if (m15888l() != titleModel) {
                            graphQLVisitableModel = (ActionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10189g = titleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15883a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15882m());
                    int a = flatBufferBuilder.a(m15886j());
                    int a2 = flatBufferBuilder.a(m15887k());
                    int a3 = ModelHelper.a(flatBufferBuilder, m15888l());
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
            @ModelWithFlatBufferFormatHash(a = -1060108179)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: movie_list */
            public final class CurrentActionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLNegativeFeedbackActionType f10190d;

                /* compiled from: movie_list */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CurrentActionModel.class, new Deserializer());
                    }

                    public Object m15889a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CurrentActionParser.m15918a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object currentActionModel = new CurrentActionModel();
                        ((BaseModel) currentActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (currentActionModel instanceof Postprocessable) {
                            return ((Postprocessable) currentActionModel).a();
                        }
                        return currentActionModel;
                    }
                }

                /* compiled from: movie_list */
                public class Serializer extends JsonSerializer<CurrentActionModel> {
                    public final void m15890a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CurrentActionModel currentActionModel = (CurrentActionModel) obj;
                        if (currentActionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(currentActionModel.m15891a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            currentActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CurrentActionParser.m15919a(currentActionModel.w_(), currentActionModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CurrentActionModel.class, new Serializer());
                    }
                }

                public CurrentActionModel() {
                    super(1);
                }

                @Nullable
                public final GraphQLNegativeFeedbackActionType m15892a() {
                    this.f10190d = (GraphQLNegativeFeedbackActionType) super.b(this.f10190d, 0, GraphQLNegativeFeedbackActionType.class, GraphQLNegativeFeedbackActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f10190d;
                }

                public final int jK_() {
                    return 654926288;
                }

                public final GraphQLVisitableModel m15893a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15891a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m15892a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: movie_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedCurationFlowStepModel.class, new Deserializer());
                }

                public Object m15894a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedCurationFlowStepParser.m15922a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedCurationFlowStepModel = new FeedCurationFlowStepModel();
                    ((BaseModel) feedCurationFlowStepModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedCurationFlowStepModel instanceof Postprocessable) {
                        return ((Postprocessable) feedCurationFlowStepModel).a();
                    }
                    return feedCurationFlowStepModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: movie_list */
            public final class FeedbackTextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f10191d;

                /* compiled from: movie_list */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FeedbackTextModel.class, new Deserializer());
                    }

                    public Object m15895a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeedbackTextParser.m15920a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object feedbackTextModel = new FeedbackTextModel();
                        ((BaseModel) feedbackTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (feedbackTextModel instanceof Postprocessable) {
                            return ((Postprocessable) feedbackTextModel).a();
                        }
                        return feedbackTextModel;
                    }
                }

                /* compiled from: movie_list */
                public class Serializer extends JsonSerializer<FeedbackTextModel> {
                    public final void m15896a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FeedbackTextModel feedbackTextModel = (FeedbackTextModel) obj;
                        if (feedbackTextModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(feedbackTextModel.m15897a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            feedbackTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeedbackTextParser.m15921a(feedbackTextModel.w_(), feedbackTextModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FeedbackTextModel.class, new Serializer());
                    }
                }

                public FeedbackTextModel() {
                    super(1);
                }

                @Nullable
                public final String m15899a() {
                    this.f10191d = super.a(this.f10191d, 0);
                    return this.f10191d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m15898a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15897a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15899a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: movie_list */
            public class Serializer extends JsonSerializer<FeedCurationFlowStepModel> {
                public final void m15900a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedCurationFlowStepModel feedCurationFlowStepModel = (FeedCurationFlowStepModel) obj;
                    if (feedCurationFlowStepModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedCurationFlowStepModel.m15901a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedCurationFlowStepModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedCurationFlowStepParser.m15923a(feedCurationFlowStepModel.w_(), feedCurationFlowStepModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedCurationFlowStepModel.class, new Serializer());
                }
            }

            public FeedCurationFlowStepModel() {
                super(4);
            }

            @Nonnull
            public final ImmutableList<ActionsModel> m15903a() {
                this.f10192d = super.a(this.f10192d, 0, ActionsModel.class);
                return (ImmutableList) this.f10192d;
            }

            @Nullable
            public final CurrentActionModel m15905j() {
                this.f10193e = (CurrentActionModel) super.a(this.f10193e, 1, CurrentActionModel.class);
                return this.f10193e;
            }

            @Nullable
            public final FeedbackTextModel m15906k() {
                this.f10194f = (FeedbackTextModel) super.a(this.f10194f, 2, FeedbackTextModel.class);
                return this.f10194f;
            }

            public final int jK_() {
                return 1167955661;
            }

            public final GraphQLVisitableModel m15902a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                CurrentActionModel currentActionModel;
                FeedbackTextModel feedbackTextModel;
                h();
                if (m15903a() != null) {
                    Builder a = ModelHelper.a(m15903a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FeedCurationFlowStepModel feedCurationFlowStepModel = (FeedCurationFlowStepModel) ModelHelper.a(null, this);
                        feedCurationFlowStepModel.f10192d = a.b();
                        graphQLVisitableModel = feedCurationFlowStepModel;
                        if (m15905j() != null) {
                            currentActionModel = (CurrentActionModel) graphQLModelMutatingVisitor.b(m15905j());
                            if (m15905j() != currentActionModel) {
                                graphQLVisitableModel = (FeedCurationFlowStepModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10193e = currentActionModel;
                            }
                        }
                        if (m15906k() != null) {
                            feedbackTextModel = (FeedbackTextModel) graphQLModelMutatingVisitor.b(m15906k());
                            if (m15906k() != feedbackTextModel) {
                                graphQLVisitableModel = (FeedCurationFlowStepModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10194f = feedbackTextModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m15905j() != null) {
                    currentActionModel = (CurrentActionModel) graphQLModelMutatingVisitor.b(m15905j());
                    if (m15905j() != currentActionModel) {
                        graphQLVisitableModel = (FeedCurationFlowStepModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10193e = currentActionModel;
                    }
                }
                if (m15906k() != null) {
                    feedbackTextModel = (FeedbackTextModel) graphQLModelMutatingVisitor.b(m15906k());
                    if (m15906k() != feedbackTextModel) {
                        graphQLVisitableModel = (FeedCurationFlowStepModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10194f = feedbackTextModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m15901a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15903a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15905j());
                int a3 = ModelHelper.a(flatBufferBuilder, m15906k());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.a(3, this.f10195g);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15904a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10195g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: movie_list */
        public class Serializer extends JsonSerializer<FetchCurationFlowModel> {
            public final void m15907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchCurationFlowModel fetchCurationFlowModel = (FetchCurationFlowModel) obj;
                if (fetchCurationFlowModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchCurationFlowModel.m15909a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchCurationFlowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchCurationFlowModel.w_();
                int u_ = fetchCurationFlowModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feed_curation_flow_step");
                    FeedCurationFlowStepParser.m15923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchCurationFlowModel.class, new Serializer());
            }
        }

        public FetchCurationFlowModel() {
            super(2);
        }

        public final void m15912a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m15913a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m15908j() {
            if (this.b != null && this.f10196d == null) {
                this.f10196d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10196d;
        }

        @Nullable
        public final FeedCurationFlowStepModel m15910a() {
            this.f10197e = (FeedCurationFlowStepModel) super.a(this.f10197e, 1, FeedCurationFlowStepModel.class);
            return this.f10197e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m15911a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15910a() != null) {
                FeedCurationFlowStepModel feedCurationFlowStepModel = (FeedCurationFlowStepModel) graphQLModelMutatingVisitor.b(m15910a());
                if (m15910a() != feedCurationFlowStepModel) {
                    graphQLVisitableModel = (FetchCurationFlowModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10197e = feedCurationFlowStepModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15909a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15908j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15910a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
