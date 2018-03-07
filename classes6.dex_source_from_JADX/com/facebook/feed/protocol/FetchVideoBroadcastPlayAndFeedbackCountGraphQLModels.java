package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLParsers.FetchVideoBroadcastPlayAndFeedbackCountQueryParser;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLParsers.FetchVideoBroadcastPlayAndFeedbackCountQueryParser.FeedbackParser;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLParsers.FetchVideoBroadcastPlayAndFeedbackCountQueryParser.FeedbackParser.CommentsParser;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLParsers.FetchVideoBroadcastPlayAndFeedbackCountQueryParser.FeedbackParser.LikersParser;
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

/* compiled from: milliseconds_since_start */
public class FetchVideoBroadcastPlayAndFeedbackCountGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1606412748)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: milliseconds_since_start */
    public final class FetchVideoBroadcastPlayAndFeedbackCountQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10348d;
        @Nullable
        private FeedbackModel f10349e;
        private int f10350f;

        /* compiled from: milliseconds_since_start */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchVideoBroadcastPlayAndFeedbackCountQueryModel.class, new Deserializer());
            }

            public Object m16352a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchVideoBroadcastPlayAndFeedbackCountQueryParser.m16390a(jsonParser);
                Object fetchVideoBroadcastPlayAndFeedbackCountQueryModel = new FetchVideoBroadcastPlayAndFeedbackCountQueryModel();
                ((BaseModel) fetchVideoBroadcastPlayAndFeedbackCountQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchVideoBroadcastPlayAndFeedbackCountQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchVideoBroadcastPlayAndFeedbackCountQueryModel).a();
                }
                return fetchVideoBroadcastPlayAndFeedbackCountQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 276427691)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: milliseconds_since_start */
        public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private CommentsModel f10346d;
            @Nullable
            private LikersModel f10347e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: milliseconds_since_start */
            public final class CommentsModel extends BaseModel implements GraphQLVisitableModel {
                private int f10344d;

                /* compiled from: milliseconds_since_start */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommentsModel.class, new Deserializer());
                    }

                    public Object m16353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommentsParser.m16384a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object commentsModel = new CommentsModel();
                        ((BaseModel) commentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (commentsModel instanceof Postprocessable) {
                            return ((Postprocessable) commentsModel).a();
                        }
                        return commentsModel;
                    }
                }

                /* compiled from: milliseconds_since_start */
                public class Serializer extends JsonSerializer<CommentsModel> {
                    public final void m16354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommentsModel commentsModel = (CommentsModel) obj;
                        if (commentsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(commentsModel.m16356a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            commentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommentsParser.m16385a(commentsModel.w_(), commentsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CommentsModel.class, new Serializer());
                    }
                }

                public CommentsModel() {
                    super(1);
                }

                public final int m16355a() {
                    a(0, 0);
                    return this.f10344d;
                }

                public final void m16358a(int i) {
                    this.f10344d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int jK_() {
                    return -100920302;
                }

                public final GraphQLVisitableModel m16357a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16356a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f10344d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16359a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10344d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: milliseconds_since_start */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m16360a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m16388a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: milliseconds_since_start */
            public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
                private int f10345d;

                /* compiled from: milliseconds_since_start */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                    }

                    public Object m16361a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LikersParser.m16386a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object likersModel = new LikersModel();
                        ((BaseModel) likersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (likersModel instanceof Postprocessable) {
                            return ((Postprocessable) likersModel).a();
                        }
                        return likersModel;
                    }
                }

                /* compiled from: milliseconds_since_start */
                public class Serializer extends JsonSerializer<LikersModel> {
                    public final void m16362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LikersModel likersModel = (LikersModel) obj;
                        if (likersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(likersModel.m16364a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LikersParser.m16387a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LikersModel.class, new Serializer());
                    }
                }

                public LikersModel() {
                    super(1);
                }

                public final int m16363a() {
                    a(0, 0);
                    return this.f10345d;
                }

                public final void m16366a(int i) {
                    this.f10345d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int jK_() {
                    return 733369288;
                }

                public final GraphQLVisitableModel m16365a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16364a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f10345d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16367a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10345d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: milliseconds_since_start */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m16368a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m16369a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m16389a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(2);
            }

            public final void m16372a(String str, ConsistencyTuple consistencyTuple) {
                if ("comments.count".equals(str)) {
                    CommentsModel a = m16370a();
                    if (a != null) {
                        consistencyTuple.a = Integer.valueOf(a.m16355a());
                        consistencyTuple.b = a.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("likers.count".equals(str)) {
                    LikersModel j = m16374j();
                    if (j != null) {
                        consistencyTuple.a = Integer.valueOf(j.m16363a());
                        consistencyTuple.b = j.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                }
                consistencyTuple.a();
            }

            public final void m16373a(String str, Object obj, boolean z) {
                if ("comments.count".equals(str)) {
                    CommentsModel a = m16370a();
                    if (a == null) {
                        return;
                    }
                    if (z) {
                        a = (CommentsModel) a.clone();
                        a.m16358a(((Integer) obj).intValue());
                        this.f10346d = a;
                        return;
                    }
                    a.m16358a(((Integer) obj).intValue());
                } else if ("likers.count".equals(str)) {
                    LikersModel j = m16374j();
                    if (j == null) {
                        return;
                    }
                    if (z) {
                        j = (LikersModel) j.clone();
                        j.m16366a(((Integer) obj).intValue());
                        this.f10347e = j;
                        return;
                    }
                    j.m16366a(((Integer) obj).intValue());
                }
            }

            @Nullable
            public final CommentsModel m16370a() {
                this.f10346d = (CommentsModel) super.a(this.f10346d, 0, CommentsModel.class);
                return this.f10346d;
            }

            @Nullable
            public final LikersModel m16374j() {
                this.f10347e = (LikersModel) super.a(this.f10347e, 1, LikersModel.class);
                return this.f10347e;
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m16371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16370a() != null) {
                    CommentsModel commentsModel = (CommentsModel) graphQLModelMutatingVisitor.b(m16370a());
                    if (m16370a() != commentsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10346d = commentsModel;
                    }
                }
                if (m16374j() != null) {
                    LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m16374j());
                    if (m16374j() != likersModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10347e = likersModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16369a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16370a());
                int a2 = ModelHelper.a(flatBufferBuilder, m16374j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: milliseconds_since_start */
        public class Serializer extends JsonSerializer<FetchVideoBroadcastPlayAndFeedbackCountQueryModel> {
            public final void m16375a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchVideoBroadcastPlayAndFeedbackCountQueryModel fetchVideoBroadcastPlayAndFeedbackCountQueryModel = (FetchVideoBroadcastPlayAndFeedbackCountQueryModel) obj;
                if (fetchVideoBroadcastPlayAndFeedbackCountQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchVideoBroadcastPlayAndFeedbackCountQueryModel.m16377a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchVideoBroadcastPlayAndFeedbackCountQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchVideoBroadcastPlayAndFeedbackCountQueryModel.w_();
                int u_ = fetchVideoBroadcastPlayAndFeedbackCountQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m16389a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(u_, 2, 0);
                if (g != 0) {
                    jsonGenerator.a("play_count");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchVideoBroadcastPlayAndFeedbackCountQueryModel.class, new Serializer());
            }
        }

        public FetchVideoBroadcastPlayAndFeedbackCountQueryModel() {
            super(3);
        }

        public final void m16381a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16382a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16376k() {
            if (this.b != null && this.f10348d == null) {
                this.f10348d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10348d;
        }

        @Nullable
        public final FeedbackModel m16378a() {
            this.f10349e = (FeedbackModel) super.a(this.f10349e, 1, FeedbackModel.class);
            return this.f10349e;
        }

        public final int m16383j() {
            a(0, 2);
            return this.f10350f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16379a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16378a() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m16378a());
                if (m16378a() != feedbackModel) {
                    graphQLVisitableModel = (FetchVideoBroadcastPlayAndFeedbackCountQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10349e = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16377a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16376k());
            int a2 = ModelHelper.a(flatBufferBuilder, m16378a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f10350f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16380a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10350f = mutableFlatBuffer.a(i, 2, 0);
        }
    }
}
