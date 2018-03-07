package com.facebook.notifications.protocol;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLParsers.FetchNotificationsLikeCountParser;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLParsers.FetchNotificationsLikeCountParser.AttachedStoryParser;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLParsers.FetchNotificationsLikeCountParser.AttachedStoryParser.FeedbackParser;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLParsers.FetchNotificationsLikeCountParser.AttachedStoryParser.FeedbackParser.LikersParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: navigation_source */
public class FetchNotificationsLikeCountGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -644510413)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: navigation_source */
    public final class FetchNotificationsLikeCountModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8551d;
        @Nullable
        private AttachedStoryModel f8552e;
        @Nullable
        private FeedbackModel f8553f;
        @Nullable
        private String f8554g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 458382660)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: navigation_source */
        public final class AttachedStoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private FeedbackModel f8548d;

            /* compiled from: navigation_source */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachedStoryModel.class, new Deserializer());
                }

                public Object m10316a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachedStoryParser.m10366a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attachedStoryModel = new AttachedStoryModel();
                    ((BaseModel) attachedStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attachedStoryModel instanceof Postprocessable) {
                        return ((Postprocessable) attachedStoryModel).a();
                    }
                    return attachedStoryModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1618679958)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: navigation_source */
            public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private LikersModel f8547d;

                /* compiled from: navigation_source */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                    }

                    public Object m10317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeedbackParser.m10364a(jsonParser, flatBufferBuilder));
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
                /* compiled from: navigation_source */
                public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
                    private int f8546d;

                    /* compiled from: navigation_source */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                        }

                        public Object m10318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LikersParser.m10362a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: navigation_source */
                    public class Serializer extends JsonSerializer<LikersModel> {
                        public final void m10319a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LikersModel likersModel = (LikersModel) obj;
                            if (likersModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(likersModel.m10321a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LikersParser.m10363a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LikersModel.class, new Serializer());
                        }
                    }

                    public LikersModel() {
                        super(1);
                    }

                    public final int m10320a() {
                        a(0, 0);
                        return this.f8546d;
                    }

                    public final void m10323a(int i) {
                        this.f8546d = i;
                        if (this.b != null && this.b.d) {
                            this.b.b(this.c, 0, i);
                        }
                    }

                    public final int jK_() {
                        return 733369288;
                    }

                    public final GraphQLVisitableModel m10322a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m10321a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f8546d, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m10324a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f8546d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                /* compiled from: navigation_source */
                public class Serializer extends JsonSerializer<FeedbackModel> {
                    public final void m10325a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FeedbackModel feedbackModel = (FeedbackModel) obj;
                        if (feedbackModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(feedbackModel.m10326a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeedbackParser.m10365a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                    }
                }

                public FeedbackModel() {
                    super(1);
                }

                public final void m10329a(String str, ConsistencyTuple consistencyTuple) {
                    if ("likers.count".equals(str)) {
                        LikersModel a = m10328a();
                        if (a != null) {
                            consistencyTuple.a = Integer.valueOf(a.m10320a());
                            consistencyTuple.b = a.u_();
                            consistencyTuple.c = 0;
                            return;
                        }
                    }
                    consistencyTuple.a();
                }

                public final void m10330a(String str, Object obj, boolean z) {
                    if ("likers.count".equals(str)) {
                        LikersModel a = m10328a();
                        if (a == null) {
                            return;
                        }
                        if (z) {
                            a = (LikersModel) a.clone();
                            a.m10323a(((Integer) obj).intValue());
                            this.f8547d = a;
                            return;
                        }
                        a.m10323a(((Integer) obj).intValue());
                    }
                }

                @Nullable
                public final LikersModel m10328a() {
                    this.f8547d = (LikersModel) super.a(this.f8547d, 0, LikersModel.class);
                    return this.f8547d;
                }

                public final int jK_() {
                    return -126857307;
                }

                public final GraphQLVisitableModel m10327a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10328a() != null) {
                        LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m10328a());
                        if (m10328a() != likersModel) {
                            graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8547d = likersModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10326a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10328a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: navigation_source */
            public class Serializer extends JsonSerializer<AttachedStoryModel> {
                public final void m10331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachedStoryModel attachedStoryModel = (AttachedStoryModel) obj;
                    if (attachedStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachedStoryModel.m10332a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachedStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachedStoryParser.m10367a(attachedStoryModel.w_(), attachedStoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachedStoryModel.class, new Serializer());
                }
            }

            public AttachedStoryModel() {
                super(1);
            }

            public final void m10335a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m10336a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final FeedbackModel m10334a() {
                this.f8548d = (FeedbackModel) super.a(this.f8548d, 0, FeedbackModel.class);
                return this.f8548d;
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m10333a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10334a() != null) {
                    FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m10334a());
                    if (m10334a() != feedbackModel) {
                        graphQLVisitableModel = (AttachedStoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8548d = feedbackModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10332a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10334a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: navigation_source */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchNotificationsLikeCountModel.class, new Deserializer());
            }

            public Object m10337a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchNotificationsLikeCountParser.m10372a(jsonParser);
                Object fetchNotificationsLikeCountModel = new FetchNotificationsLikeCountModel();
                ((BaseModel) fetchNotificationsLikeCountModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchNotificationsLikeCountModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchNotificationsLikeCountModel).a();
                }
                return fetchNotificationsLikeCountModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2116658845)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: navigation_source */
        public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private LikersModel f8550d;

            /* compiled from: navigation_source */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m10338a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchNotificationsLikeCountParser.FeedbackParser.m10370a(jsonParser, flatBufferBuilder));
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
            /* compiled from: navigation_source */
            public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
                private int f8549d;

                /* compiled from: navigation_source */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                    }

                    public Object m10339a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchNotificationsLikeCountParser.FeedbackParser.LikersParser.m10368a(jsonParser, flatBufferBuilder));
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

                /* compiled from: navigation_source */
                public class Serializer extends JsonSerializer<LikersModel> {
                    public final void m10340a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LikersModel likersModel = (LikersModel) obj;
                        if (likersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(likersModel.m10342a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchNotificationsLikeCountParser.FeedbackParser.LikersParser.m10369a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LikersModel.class, new Serializer());
                    }
                }

                public LikersModel() {
                    super(1);
                }

                public final int m10341a() {
                    a(0, 0);
                    return this.f8549d;
                }

                public final void m10344a(int i) {
                    this.f8549d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int jK_() {
                    return 733369288;
                }

                public final GraphQLVisitableModel m10343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10342a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f8549d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m10345a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8549d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: navigation_source */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m10346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m10347a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchNotificationsLikeCountParser.FeedbackParser.m10371a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(1);
            }

            public final void m10350a(String str, ConsistencyTuple consistencyTuple) {
                if ("likers.count".equals(str)) {
                    LikersModel a = m10349a();
                    if (a != null) {
                        consistencyTuple.a = Integer.valueOf(a.m10341a());
                        consistencyTuple.b = a.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                }
                consistencyTuple.a();
            }

            public final void m10351a(String str, Object obj, boolean z) {
                if ("likers.count".equals(str)) {
                    LikersModel a = m10349a();
                    if (a == null) {
                        return;
                    }
                    if (z) {
                        a = (LikersModel) a.clone();
                        a.m10344a(((Integer) obj).intValue());
                        this.f8550d = a;
                        return;
                    }
                    a.m10344a(((Integer) obj).intValue());
                }
            }

            @Nullable
            public final LikersModel m10349a() {
                this.f8550d = (LikersModel) super.a(this.f8550d, 0, LikersModel.class);
                return this.f8550d;
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m10348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10349a() != null) {
                    LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m10349a());
                    if (m10349a() != likersModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8550d = likersModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10347a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10349a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: navigation_source */
        public class Serializer extends JsonSerializer<FetchNotificationsLikeCountModel> {
            public final void m10352a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchNotificationsLikeCountModel fetchNotificationsLikeCountModel = (FetchNotificationsLikeCountModel) obj;
                if (fetchNotificationsLikeCountModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchNotificationsLikeCountModel.m10355a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchNotificationsLikeCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchNotificationsLikeCountModel.w_();
                int u_ = fetchNotificationsLikeCountModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("attached_story");
                    AttachedStoryParser.m10367a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FetchNotificationsLikeCountParser.FeedbackParser.m10371a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchNotificationsLikeCountModel.class, new Serializer());
            }
        }

        public FetchNotificationsLikeCountModel() {
            super(4);
        }

        public final void m10358a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10359a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m10353l() {
            if (this.b != null && this.f8551d == null) {
                this.f8551d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8551d;
        }

        @Nullable
        public final AttachedStoryModel m10360j() {
            this.f8552e = (AttachedStoryModel) super.a(this.f8552e, 1, AttachedStoryModel.class);
            return this.f8552e;
        }

        @Nullable
        public final FeedbackModel m10361k() {
            this.f8553f = (FeedbackModel) super.a(this.f8553f, 2, FeedbackModel.class);
            return this.f8553f;
        }

        @Nullable
        private String m10354m() {
            this.f8554g = super.a(this.f8554g, 3);
            return this.f8554g;
        }

        @Nullable
        public final String m10357a() {
            return m10354m();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m10356a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10360j() != null) {
                AttachedStoryModel attachedStoryModel = (AttachedStoryModel) graphQLModelMutatingVisitor.b(m10360j());
                if (m10360j() != attachedStoryModel) {
                    graphQLVisitableModel = (FetchNotificationsLikeCountModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8552e = attachedStoryModel;
                }
            }
            if (m10361k() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m10361k());
                if (m10361k() != feedbackModel) {
                    graphQLVisitableModel = (FetchNotificationsLikeCountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8553f = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10355a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10353l());
            int a2 = ModelHelper.a(flatBufferBuilder, m10360j());
            int a3 = ModelHelper.a(flatBufferBuilder, m10361k());
            int b = flatBufferBuilder.b(m10354m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
