package com.facebook.api.graphql.fetchstories;

import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesParsers.SingleNodeQueryParser;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesParsers.SingleNodeQueryParser.AttachedStoryParser;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesParsers.SingleNodeQueryParser.FeedbackParser;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesParsers.SingleNodeQueryParser.FeedbackParser.CommentersParser;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesParsers.SingleNodeQueryParser.FeedbackParser.LikersParser;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesParsers.SingleNodeQueryParser.MessageParser;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesParsers.SingleNodeQueryParser.TitleParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: android_suggest_profile_picture */
public class FetchCachedStoryUpdatesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -272552692)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_suggest_profile_picture */
    public final class SingleNodeQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9675d;
        @Nullable
        private AttachedStoryModel f9676e;
        @Nullable
        private FeedbackModel f9677f;
        @Nullable
        private String f9678g;
        @Nullable
        private MessageModel f9679h;
        @Nullable
        private TitleModel f9680i;
        private boolean f9681j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_suggest_profile_picture */
        public final class AttachedStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9668d;

            /* compiled from: android_suggest_profile_picture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachedStoryModel.class, new Deserializer());
                }

                public Object m16606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachedStoryParser.m16660a(jsonParser, flatBufferBuilder));
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

            /* compiled from: android_suggest_profile_picture */
            public class Serializer extends JsonSerializer<AttachedStoryModel> {
                public final void m16607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachedStoryModel attachedStoryModel = (AttachedStoryModel) obj;
                    if (attachedStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachedStoryModel.m16609a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachedStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachedStoryParser.m16661a(attachedStoryModel.w_(), attachedStoryModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AttachedStoryModel.class, new Serializer());
                }
            }

            public AttachedStoryModel() {
                super(1);
            }

            public final void m16612a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16613a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m16608j() {
                this.f9668d = super.a(this.f9668d, 0);
                return this.f9668d;
            }

            @Nullable
            public final String m16611a() {
                return m16608j();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m16610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16609a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16608j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_suggest_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SingleNodeQueryModel.class, new Deserializer());
            }

            public Object m16614a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SingleNodeQueryParser.m16672a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object singleNodeQueryModel = new SingleNodeQueryModel();
                ((BaseModel) singleNodeQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (singleNodeQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) singleNodeQueryModel).a();
                }
                return singleNodeQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 732434144)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_suggest_profile_picture */
        public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private CommentersModel f9671d;
            @Nullable
            private LikersModel f9672e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_suggest_profile_picture */
            public final class CommentersModel extends BaseModel implements GraphQLVisitableModel {
                private int f9669d;

                /* compiled from: android_suggest_profile_picture */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommentersModel.class, new Deserializer());
                    }

                    public Object m16615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommentersParser.m16662a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object commentersModel = new CommentersModel();
                        ((BaseModel) commentersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (commentersModel instanceof Postprocessable) {
                            return ((Postprocessable) commentersModel).a();
                        }
                        return commentersModel;
                    }
                }

                /* compiled from: android_suggest_profile_picture */
                public class Serializer extends JsonSerializer<CommentersModel> {
                    public final void m16616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommentersModel commentersModel = (CommentersModel) obj;
                        if (commentersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(commentersModel.m16618a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            commentersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommentersParser.m16663a(commentersModel.w_(), commentersModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CommentersModel.class, new Serializer());
                    }
                }

                public CommentersModel() {
                    super(1);
                }

                public final int m16617a() {
                    a(0, 0);
                    return this.f9669d;
                }

                public final int jK_() {
                    return 2082452741;
                }

                public final GraphQLVisitableModel m16619a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16618a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9669d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16620a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9669d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: android_suggest_profile_picture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m16621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m16666a(jsonParser, flatBufferBuilder));
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
            /* compiled from: android_suggest_profile_picture */
            public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
                private int f9670d;

                /* compiled from: android_suggest_profile_picture */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                    }

                    public Object m16622a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LikersParser.m16664a(jsonParser, flatBufferBuilder));
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

                /* compiled from: android_suggest_profile_picture */
                public class Serializer extends JsonSerializer<LikersModel> {
                    public final void m16623a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LikersModel likersModel = (LikersModel) obj;
                        if (likersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(likersModel.m16625a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LikersParser.m16665a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LikersModel.class, new Serializer());
                    }
                }

                public LikersModel() {
                    super(1);
                }

                public final int m16624a() {
                    a(0, 0);
                    return this.f9670d;
                }

                public final void m16627a(int i) {
                    this.f9670d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int jK_() {
                    return 733369288;
                }

                public final GraphQLVisitableModel m16626a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16625a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9670d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16628a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9670d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: android_suggest_profile_picture */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m16629a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m16630a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m16667a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(2);
            }

            public final void m16633a(String str, ConsistencyTuple consistencyTuple) {
                if ("likers.count".equals(str)) {
                    LikersModel j = m16635j();
                    if (j != null) {
                        consistencyTuple.a = Integer.valueOf(j.m16624a());
                        consistencyTuple.b = j.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                }
                consistencyTuple.a();
            }

            public final void m16634a(String str, Object obj, boolean z) {
                if ("likers.count".equals(str)) {
                    LikersModel j = m16635j();
                    if (j == null) {
                        return;
                    }
                    if (z) {
                        j = (LikersModel) j.clone();
                        j.m16627a(((Integer) obj).intValue());
                        this.f9672e = j;
                        return;
                    }
                    j.m16627a(((Integer) obj).intValue());
                }
            }

            @Nullable
            public final CommentersModel m16631a() {
                this.f9671d = (CommentersModel) super.a(this.f9671d, 0, CommentersModel.class);
                return this.f9671d;
            }

            @Nullable
            public final LikersModel m16635j() {
                this.f9672e = (LikersModel) super.a(this.f9672e, 1, LikersModel.class);
                return this.f9672e;
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m16632a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16631a() != null) {
                    CommentersModel commentersModel = (CommentersModel) graphQLModelMutatingVisitor.b(m16631a());
                    if (m16631a() != commentersModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9671d = commentersModel;
                    }
                }
                if (m16635j() != null) {
                    LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m16635j());
                    if (m16635j() != likersModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9672e = likersModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16630a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16631a());
                int a2 = ModelHelper.a(flatBufferBuilder, m16635j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_suggest_profile_picture */
        public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9673d;

            /* compiled from: android_suggest_profile_picture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                }

                public Object m16636a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageParser.m16668a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageModel = new MessageModel();
                    ((BaseModel) messageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageModel instanceof Postprocessable) {
                        return ((Postprocessable) messageModel).a();
                    }
                    return messageModel;
                }
            }

            /* compiled from: android_suggest_profile_picture */
            public class Serializer extends JsonSerializer<MessageModel> {
                public final void m16637a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageModel messageModel = (MessageModel) obj;
                    if (messageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageModel.m16638a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageParser.m16669a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessageModel.class, new Serializer());
                }
            }

            public MessageModel() {
                super(1);
            }

            @Nullable
            public final String m16640a() {
                this.f9673d = super.a(this.f9673d, 0);
                return this.f9673d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m16639a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16638a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16640a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_suggest_profile_picture */
        public class Serializer extends JsonSerializer<SingleNodeQueryModel> {
            public final void m16641a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SingleNodeQueryModel singleNodeQueryModel = (SingleNodeQueryModel) obj;
                if (singleNodeQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(singleNodeQueryModel.m16648a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    singleNodeQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = singleNodeQueryModel.w_();
                int u_ = singleNodeQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("attached_story");
                    AttachedStoryParser.m16661a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m16667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("message");
                    MessageParser.m16669a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m16671a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 6);
                if (a) {
                    jsonGenerator.a("viewer_readstate");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SingleNodeQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_suggest_profile_picture */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9674d;

            /* compiled from: android_suggest_profile_picture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m16642a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m16670a(jsonParser, flatBufferBuilder));
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

            /* compiled from: android_suggest_profile_picture */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m16643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m16644a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m16671a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m16646a() {
                this.f9674d = super.a(this.f9674d, 0);
                return this.f9674d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m16645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16644a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16646a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public SingleNodeQueryModel() {
            super(7);
        }

        public final void m16652a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16653a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16647p() {
            if (this.b != null && this.f9675d == null) {
                this.f9675d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9675d;
        }

        @Nullable
        public final AttachedStoryModel m16654j() {
            this.f9676e = (AttachedStoryModel) super.a(this.f9676e, 1, AttachedStoryModel.class);
            return this.f9676e;
        }

        @Nullable
        public final FeedbackModel m16655k() {
            this.f9677f = (FeedbackModel) super.a(this.f9677f, 2, FeedbackModel.class);
            return this.f9677f;
        }

        @Nullable
        public final String m16656l() {
            this.f9678g = super.a(this.f9678g, 3);
            return this.f9678g;
        }

        @Nullable
        public final MessageModel m16657m() {
            this.f9679h = (MessageModel) super.a(this.f9679h, 4, MessageModel.class);
            return this.f9679h;
        }

        @Nullable
        public final TitleModel m16658n() {
            this.f9680i = (TitleModel) super.a(this.f9680i, 5, TitleModel.class);
            return this.f9680i;
        }

        public final boolean m16659o() {
            a(0, 6);
            return this.f9681j;
        }

        @Nullable
        public final String m16650a() {
            return m16656l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16649a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16654j() != null) {
                AttachedStoryModel attachedStoryModel = (AttachedStoryModel) graphQLModelMutatingVisitor.b(m16654j());
                if (m16654j() != attachedStoryModel) {
                    graphQLVisitableModel = (SingleNodeQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9676e = attachedStoryModel;
                }
            }
            if (m16655k() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m16655k());
                if (m16655k() != feedbackModel) {
                    graphQLVisitableModel = (SingleNodeQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9677f = feedbackModel;
                }
            }
            if (m16657m() != null) {
                MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m16657m());
                if (m16657m() != messageModel) {
                    graphQLVisitableModel = (SingleNodeQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9679h = messageModel;
                }
            }
            if (m16658n() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m16658n());
                if (m16658n() != titleModel) {
                    graphQLVisitableModel = (SingleNodeQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9680i = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16648a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16647p());
            int a2 = ModelHelper.a(flatBufferBuilder, m16654j());
            int a3 = ModelHelper.a(flatBufferBuilder, m16655k());
            int b = flatBufferBuilder.b(m16656l());
            int a4 = ModelHelper.a(flatBufferBuilder, m16657m());
            int a5 = ModelHelper.a(flatBufferBuilder, m16658n());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.a(6, this.f9681j);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16651a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9681j = mutableFlatBuffer.a(i, 6);
        }
    }
}
