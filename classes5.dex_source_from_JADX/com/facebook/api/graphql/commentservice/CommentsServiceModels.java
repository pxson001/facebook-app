package com.facebook.api.graphql.commentservice;

import com.facebook.api.graphql.commentservice.CommentsServiceParsers.CommentCreateFeedbackFieldsParser;
import com.facebook.api.graphql.commentservice.CommentsServiceParsers.CommentCreateFeedbackFieldsParser.TopLevelCommentsParser;
import com.facebook.api.graphql.commentservice.CommentsServiceParsers.CommentCreateMutationFragmentParser;
import com.facebook.api.graphql.commentservice.CommentsServiceParsers.FriendsTypingSubscriptionFragmentParser;
import com.facebook.api.graphql.commentservice.CommentsServiceParsers.FriendsTypingSubscriptionFragmentParser.FeedbackTypersParser;
import com.facebook.api.graphql.commentservice.CommentsServiceParsers.FriendsTypingSubscriptionParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCommentDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLComment;
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

/* compiled from: app_id */
public class CommentsServiceModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -794013330)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_id */
    public final class CommentCreateFeedbackFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f9228d;
        @Nullable
        private String f9229e;
        @Nullable
        private TopLevelCommentsModel f9230f;

        /* compiled from: app_id */
        public final class Builder {
            @Nullable
            public String f9223a;
            @Nullable
            public String f9224b;
            @Nullable
            public TopLevelCommentsModel f9225c;
        }

        /* compiled from: app_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentCreateFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m15685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommentCreateFeedbackFieldsParser.m15736a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commentCreateFeedbackFieldsModel = new CommentCreateFeedbackFieldsModel();
                ((BaseModel) commentCreateFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commentCreateFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commentCreateFeedbackFieldsModel).a();
                }
                return commentCreateFeedbackFieldsModel;
            }
        }

        /* compiled from: app_id */
        public class Serializer extends JsonSerializer<CommentCreateFeedbackFieldsModel> {
            public final void m15686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommentCreateFeedbackFieldsModel commentCreateFeedbackFieldsModel = (CommentCreateFeedbackFieldsModel) obj;
                if (commentCreateFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentCreateFeedbackFieldsModel.m15697a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentCreateFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommentCreateFeedbackFieldsParser.m15737a(commentCreateFeedbackFieldsModel.w_(), commentCreateFeedbackFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommentCreateFeedbackFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2056444745)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_id */
        public final class TopLevelCommentsModel extends BaseModel implements GraphQLVisitableModel {
            private int f9226d;
            private int f9227e;

            /* compiled from: app_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopLevelCommentsModel.class, new Deserializer());
                }

                public Object m15687a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopLevelCommentsParser.m15734a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topLevelCommentsModel = new TopLevelCommentsModel();
                    ((BaseModel) topLevelCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topLevelCommentsModel instanceof Postprocessable) {
                        return ((Postprocessable) topLevelCommentsModel).a();
                    }
                    return topLevelCommentsModel;
                }
            }

            /* compiled from: app_id */
            public class Serializer extends JsonSerializer<TopLevelCommentsModel> {
                public final void m15688a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) obj;
                    if (topLevelCommentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topLevelCommentsModel.m15690a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topLevelCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopLevelCommentsParser.m15735a(topLevelCommentsModel.w_(), topLevelCommentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopLevelCommentsModel.class, new Serializer());
                }
            }

            public TopLevelCommentsModel() {
                super(2);
            }

            public final int m15689a() {
                a(0, 0);
                return this.f9226d;
            }

            public final void m15692a(int i) {
                this.f9226d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int m15695j() {
                a(0, 1);
                return this.f9227e;
            }

            public final void m15694b(int i) {
                this.f9227e = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 1, i);
                }
            }

            public final int jK_() {
                return 899897761;
            }

            public final GraphQLVisitableModel m15691a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15690a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f9226d, 0);
                flatBufferBuilder.a(1, this.f9227e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15693a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9226d = mutableFlatBuffer.a(i, 0, 0);
                this.f9227e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        public CommentCreateFeedbackFieldsModel() {
            super(3);
        }

        public CommentCreateFeedbackFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m15700a(String str, ConsistencyTuple consistencyTuple) {
            TopLevelCommentsModel l;
            if ("top_level_comments.count".equals(str)) {
                l = m15696l();
                if (l != null) {
                    consistencyTuple.a = Integer.valueOf(l.m15689a());
                    consistencyTuple.b = l.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("top_level_comments.total_count".equals(str)) {
                l = m15696l();
                if (l != null) {
                    consistencyTuple.a = Integer.valueOf(l.m15695j());
                    consistencyTuple.b = l.u_();
                    consistencyTuple.c = 1;
                    return;
                }
            }
            consistencyTuple.a();
        }

        public final void m15701a(String str, Object obj, boolean z) {
            TopLevelCommentsModel l;
            if ("top_level_comments.count".equals(str)) {
                l = m15696l();
                if (l == null) {
                    return;
                }
                if (z) {
                    l = (TopLevelCommentsModel) l.clone();
                    l.m15692a(((Integer) obj).intValue());
                    this.f9230f = l;
                    return;
                }
                l.m15692a(((Integer) obj).intValue());
            } else if ("top_level_comments.total_count".equals(str)) {
                l = m15696l();
                if (l == null) {
                    return;
                }
                if (z) {
                    l = (TopLevelCommentsModel) l.clone();
                    l.m15694b(((Integer) obj).intValue());
                    this.f9230f = l;
                    return;
                }
                l.m15694b(((Integer) obj).intValue());
            }
        }

        @Nullable
        public final String m15702j() {
            this.f9228d = super.a(this.f9228d, 0);
            return this.f9228d;
        }

        @Nullable
        public final String m15703k() {
            this.f9229e = super.a(this.f9229e, 1);
            return this.f9229e;
        }

        @Nullable
        private TopLevelCommentsModel m15696l() {
            this.f9230f = (TopLevelCommentsModel) super.a(this.f9230f, 2, TopLevelCommentsModel.class);
            return this.f9230f;
        }

        @Nullable
        public final String m15699a() {
            return m15703k();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m15698a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15696l() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m15696l());
                if (m15696l() != topLevelCommentsModel) {
                    graphQLVisitableModel = (CommentCreateFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9230f = topLevelCommentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15697a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15702j());
            int b2 = flatBufferBuilder.b(m15703k());
            int a = ModelHelper.a(flatBufferBuilder, m15696l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1748970008)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: app_id */
    public final class CommentCreateMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLComment f9231d;
        @Nullable
        private CommentCreateFeedbackFieldsModel f9232e;

        /* compiled from: app_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentCreateMutationFragmentModel.class, new Deserializer());
            }

            public Object m15704a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommentCreateMutationFragmentParser.m15738a(jsonParser);
                Object commentCreateMutationFragmentModel = new CommentCreateMutationFragmentModel();
                ((BaseModel) commentCreateMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commentCreateMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) commentCreateMutationFragmentModel).a();
                }
                return commentCreateMutationFragmentModel;
            }
        }

        /* compiled from: app_id */
        public class Serializer extends JsonSerializer<CommentCreateMutationFragmentModel> {
            public final void m15705a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommentCreateMutationFragmentModel commentCreateMutationFragmentModel = (CommentCreateMutationFragmentModel) obj;
                if (commentCreateMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentCreateMutationFragmentModel.m15706a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentCreateMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commentCreateMutationFragmentModel.w_();
                int u_ = commentCreateMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("comment");
                    GraphQLCommentDeserializer.m4661b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    CommentCreateFeedbackFieldsParser.m15737a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommentCreateMutationFragmentModel.class, new Serializer());
            }
        }

        public CommentCreateMutationFragmentModel() {
            super(2);
        }

        @Nullable
        public final GraphQLComment m15707a() {
            this.f9231d = (GraphQLComment) super.a(this.f9231d, 0, GraphQLComment.class);
            return this.f9231d;
        }

        @Nullable
        public final CommentCreateFeedbackFieldsModel m15709j() {
            this.f9232e = (CommentCreateFeedbackFieldsModel) super.a(this.f9232e, 1, CommentCreateFeedbackFieldsModel.class);
            return this.f9232e;
        }

        public final int jK_() {
            return -1953087374;
        }

        public final GraphQLVisitableModel m15708a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15707a() != null) {
                GraphQLComment graphQLComment = (GraphQLComment) graphQLModelMutatingVisitor.b(m15707a());
                if (m15707a() != graphQLComment) {
                    graphQLVisitableModel = (CommentCreateMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9231d = graphQLComment;
                }
            }
            if (m15709j() != null) {
                CommentCreateFeedbackFieldsModel commentCreateFeedbackFieldsModel = (CommentCreateFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m15709j());
                if (m15709j() != commentCreateFeedbackFieldsModel) {
                    graphQLVisitableModel = (CommentCreateMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9232e = commentCreateFeedbackFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15706a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15707a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15709j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1233028401)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_id */
    public final class FriendsTypingSubscriptionFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private FeedbackTypersModel f9238d;
        @Nullable
        private String f9239e;

        /* compiled from: app_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsTypingSubscriptionFragmentModel.class, new Deserializer());
            }

            public Object m15713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendsTypingSubscriptionFragmentParser.m15742a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendsTypingSubscriptionFragmentModel = new FriendsTypingSubscriptionFragmentModel();
                ((BaseModel) friendsTypingSubscriptionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendsTypingSubscriptionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsTypingSubscriptionFragmentModel).a();
                }
                return friendsTypingSubscriptionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -8824726)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_id */
        public final class FeedbackTypersModel extends BaseModel implements GraphQLVisitableModel {
            private int f9235d;
            private int f9236e;
            private int f9237f;

            /* compiled from: app_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackTypersModel.class, new Deserializer());
                }

                public Object m15714a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackTypersParser.m15740a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackTypersModel = new FeedbackTypersModel();
                    ((BaseModel) feedbackTypersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackTypersModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackTypersModel).a();
                    }
                    return feedbackTypersModel;
                }
            }

            /* compiled from: app_id */
            public class Serializer extends JsonSerializer<FeedbackTypersModel> {
                public final void m15715a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackTypersModel feedbackTypersModel = (FeedbackTypersModel) obj;
                    if (feedbackTypersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackTypersModel.m15717a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackTypersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackTypersParser.m15741a(feedbackTypersModel.w_(), feedbackTypersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackTypersModel.class, new Serializer());
                }
            }

            public FeedbackTypersModel() {
                super(3);
            }

            public final int m15716a() {
                a(0, 0);
                return this.f9235d;
            }

            public final int m15720j() {
                a(0, 1);
                return this.f9236e;
            }

            public final int jK_() {
                return -2128052738;
            }

            public final GraphQLVisitableModel m15718a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15717a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f9235d, 0);
                flatBufferBuilder.a(1, this.f9236e, 0);
                flatBufferBuilder.a(2, this.f9237f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15719a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9235d = mutableFlatBuffer.a(i, 0, 0);
                this.f9236e = mutableFlatBuffer.a(i, 1, 0);
                this.f9237f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: app_id */
        public class Serializer extends JsonSerializer<FriendsTypingSubscriptionFragmentModel> {
            public final void m15721a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendsTypingSubscriptionFragmentModel friendsTypingSubscriptionFragmentModel = (FriendsTypingSubscriptionFragmentModel) obj;
                if (friendsTypingSubscriptionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsTypingSubscriptionFragmentModel.m15722a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsTypingSubscriptionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendsTypingSubscriptionFragmentParser.m15743a(friendsTypingSubscriptionFragmentModel.w_(), friendsTypingSubscriptionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendsTypingSubscriptionFragmentModel.class, new Serializer());
            }
        }

        public FriendsTypingSubscriptionFragmentModel() {
            super(2);
        }

        public final void m15725a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m15726a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final FeedbackTypersModel m15723a() {
            this.f9238d = (FeedbackTypersModel) super.a(this.f9238d, 0, FeedbackTypersModel.class);
            return this.f9238d;
        }

        @Nullable
        public final String m15727j() {
            this.f9239e = super.a(this.f9239e, 1);
            return this.f9239e;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m15724a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15723a() != null) {
                FeedbackTypersModel feedbackTypersModel = (FeedbackTypersModel) graphQLModelMutatingVisitor.b(m15723a());
                if (m15723a() != feedbackTypersModel) {
                    graphQLVisitableModel = (FriendsTypingSubscriptionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9238d = feedbackTypersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15722a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15723a());
            int b = flatBufferBuilder.b(m15727j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1717223765)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_id */
    public final class FriendsTypingSubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f9240d;
        @Nullable
        private FriendsTypingSubscriptionFragmentModel f9241e;

        /* compiled from: app_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsTypingSubscriptionModel.class, new Deserializer());
            }

            public Object m15728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsTypingSubscriptionParser.m15744a(jsonParser);
                Object friendsTypingSubscriptionModel = new FriendsTypingSubscriptionModel();
                ((BaseModel) friendsTypingSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsTypingSubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsTypingSubscriptionModel).a();
                }
                return friendsTypingSubscriptionModel;
            }
        }

        /* compiled from: app_id */
        public class Serializer extends JsonSerializer<FriendsTypingSubscriptionModel> {
            public final void m15729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsTypingSubscriptionModel friendsTypingSubscriptionModel = (FriendsTypingSubscriptionModel) obj;
                if (friendsTypingSubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsTypingSubscriptionModel.m15731a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsTypingSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsTypingSubscriptionModel.w_();
                int u_ = friendsTypingSubscriptionModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FriendsTypingSubscriptionFragmentParser.m15743a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsTypingSubscriptionModel.class, new Serializer());
            }
        }

        public FriendsTypingSubscriptionModel() {
            super(2);
        }

        @Nullable
        private GraphQLObjectType m15730j() {
            if (this.b != null && this.f9240d == null) {
                this.f9240d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9240d;
        }

        @Nullable
        public final FriendsTypingSubscriptionFragmentModel m15732a() {
            this.f9241e = (FriendsTypingSubscriptionFragmentModel) super.a(this.f9241e, 1, FriendsTypingSubscriptionFragmentModel.class);
            return this.f9241e;
        }

        public final int jK_() {
            return -1557853953;
        }

        public final GraphQLVisitableModel m15733a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15732a() != null) {
                FriendsTypingSubscriptionFragmentModel friendsTypingSubscriptionFragmentModel = (FriendsTypingSubscriptionFragmentModel) graphQLModelMutatingVisitor.b(m15732a());
                if (m15732a() != friendsTypingSubscriptionFragmentModel) {
                    graphQLVisitableModel = (FriendsTypingSubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9241e = friendsTypingSubscriptionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15731a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15730j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15732a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
