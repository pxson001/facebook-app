package com.facebook.groups.feed.protocol;

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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.feed.protocol.FeedStoryMutationsParsers.CommentsDisabledNoticeFieldsParser;
import com.facebook.groups.feed.protocol.FeedStoryMutationsParsers.FeedbackDisableCommentingMutationParser;
import com.facebook.groups.feed.protocol.FeedStoryMutationsParsers.FeedbackEnableCommentingMutationParser;
import com.facebook.groups.feed.protocol.FeedStoryMutationsParsers.GroupReportStoryToAdminMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: reaction_key */
public class FeedStoryMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1476646601)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reaction_key */
    public final class CommentsDisabledNoticeFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f5502d;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f5503e;
        private boolean f5504f;
        @Nullable
        private String f5505g;
        @Nullable
        private String f5506h;

        /* compiled from: reaction_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentsDisabledNoticeFieldsModel.class, new Deserializer());
            }

            public Object m6200a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommentsDisabledNoticeFieldsParser.m6230a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commentsDisabledNoticeFieldsModel = new CommentsDisabledNoticeFieldsModel();
                ((BaseModel) commentsDisabledNoticeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commentsDisabledNoticeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commentsDisabledNoticeFieldsModel).a();
                }
                return commentsDisabledNoticeFieldsModel;
            }
        }

        /* compiled from: reaction_key */
        public class Serializer extends JsonSerializer<CommentsDisabledNoticeFieldsModel> {
            public final void m6201a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommentsDisabledNoticeFieldsModel commentsDisabledNoticeFieldsModel = (CommentsDisabledNoticeFieldsModel) obj;
                if (commentsDisabledNoticeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentsDisabledNoticeFieldsModel.m6206a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentsDisabledNoticeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommentsDisabledNoticeFieldsParser.m6231a(commentsDisabledNoticeFieldsModel.w_(), commentsDisabledNoticeFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommentsDisabledNoticeFieldsModel.class, new Serializer());
            }
        }

        public CommentsDisabledNoticeFieldsModel() {
            super(5);
        }

        public final void m6210a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m6212j());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
            } else if ("have_comments_been_disabled".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m6214l());
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m6211a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m6202a(((Boolean) obj).booleanValue());
            } else if ("have_comments_been_disabled".equals(str)) {
                m6203b(((Boolean) obj).booleanValue());
            }
        }

        public final boolean m6212j() {
            a(0, 0);
            return this.f5502d;
        }

        private void m6202a(boolean z) {
            this.f5502d = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, z);
            }
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m6213k() {
            this.f5503e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f5503e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f5503e;
        }

        public final boolean m6214l() {
            a(0, 2);
            return this.f5504f;
        }

        private void m6203b(boolean z) {
            this.f5504f = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, z);
            }
        }

        @Nullable
        private String m6204m() {
            this.f5505g = super.a(this.f5505g, 3);
            return this.f5505g;
        }

        @Nullable
        private String m6205n() {
            this.f5506h = super.a(this.f5506h, 4);
            return this.f5506h;
        }

        @Nullable
        public final String m6208a() {
            return m6205n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m6207a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6213k() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m6213k());
                if (m6213k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (CommentsDisabledNoticeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5503e = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6206a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6213k());
            int b = flatBufferBuilder.b(m6204m());
            int b2 = flatBufferBuilder.b(m6205n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f5502d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f5504f);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6209a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5502d = mutableFlatBuffer.a(i, 0);
            this.f5504f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1671263358)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reaction_key */
    public final class FeedbackDisableCommentingMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CommentsDisabledNoticeFieldsModel f5507d;

        /* compiled from: reaction_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackDisableCommentingMutationModel.class, new Deserializer());
            }

            public Object m6215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackDisableCommentingMutationParser.m6232a(jsonParser);
                Object feedbackDisableCommentingMutationModel = new FeedbackDisableCommentingMutationModel();
                ((BaseModel) feedbackDisableCommentingMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackDisableCommentingMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackDisableCommentingMutationModel).a();
                }
                return feedbackDisableCommentingMutationModel;
            }
        }

        /* compiled from: reaction_key */
        public class Serializer extends JsonSerializer<FeedbackDisableCommentingMutationModel> {
            public final void m6216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackDisableCommentingMutationModel feedbackDisableCommentingMutationModel = (FeedbackDisableCommentingMutationModel) obj;
                if (feedbackDisableCommentingMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackDisableCommentingMutationModel.m6217a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackDisableCommentingMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackDisableCommentingMutationModel.w_();
                int u_ = feedbackDisableCommentingMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    CommentsDisabledNoticeFieldsParser.m6231a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackDisableCommentingMutationModel.class, new Serializer());
            }
        }

        public FeedbackDisableCommentingMutationModel() {
            super(1);
        }

        @Nullable
        public final CommentsDisabledNoticeFieldsModel m6219a() {
            this.f5507d = (CommentsDisabledNoticeFieldsModel) super.a(this.f5507d, 0, CommentsDisabledNoticeFieldsModel.class);
            return this.f5507d;
        }

        public final int jK_() {
            return -443518937;
        }

        public final GraphQLVisitableModel m6218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6219a() != null) {
                CommentsDisabledNoticeFieldsModel commentsDisabledNoticeFieldsModel = (CommentsDisabledNoticeFieldsModel) graphQLModelMutatingVisitor.b(m6219a());
                if (m6219a() != commentsDisabledNoticeFieldsModel) {
                    graphQLVisitableModel = (FeedbackDisableCommentingMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5507d = commentsDisabledNoticeFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6217a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6219a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1671263358)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reaction_key */
    public final class FeedbackEnableCommentingMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CommentsDisabledNoticeFieldsModel f5508d;

        /* compiled from: reaction_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackEnableCommentingMutationModel.class, new Deserializer());
            }

            public Object m6220a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackEnableCommentingMutationParser.m6233a(jsonParser);
                Object feedbackEnableCommentingMutationModel = new FeedbackEnableCommentingMutationModel();
                ((BaseModel) feedbackEnableCommentingMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackEnableCommentingMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackEnableCommentingMutationModel).a();
                }
                return feedbackEnableCommentingMutationModel;
            }
        }

        /* compiled from: reaction_key */
        public class Serializer extends JsonSerializer<FeedbackEnableCommentingMutationModel> {
            public final void m6221a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackEnableCommentingMutationModel feedbackEnableCommentingMutationModel = (FeedbackEnableCommentingMutationModel) obj;
                if (feedbackEnableCommentingMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackEnableCommentingMutationModel.m6222a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackEnableCommentingMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackEnableCommentingMutationModel.w_();
                int u_ = feedbackEnableCommentingMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    CommentsDisabledNoticeFieldsParser.m6231a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackEnableCommentingMutationModel.class, new Serializer());
            }
        }

        public FeedbackEnableCommentingMutationModel() {
            super(1);
        }

        @Nullable
        public final CommentsDisabledNoticeFieldsModel m6224a() {
            this.f5508d = (CommentsDisabledNoticeFieldsModel) super.a(this.f5508d, 0, CommentsDisabledNoticeFieldsModel.class);
            return this.f5508d;
        }

        public final int jK_() {
            return -2122156606;
        }

        public final GraphQLVisitableModel m6223a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6224a() != null) {
                CommentsDisabledNoticeFieldsModel commentsDisabledNoticeFieldsModel = (CommentsDisabledNoticeFieldsModel) graphQLModelMutatingVisitor.b(m6224a());
                if (m6224a() != commentsDisabledNoticeFieldsModel) {
                    graphQLVisitableModel = (FeedbackEnableCommentingMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5508d = commentsDisabledNoticeFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6222a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6224a());
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
    /* compiled from: reaction_key */
    public final class GroupReportStoryToAdminMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5509d;

        /* compiled from: reaction_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupReportStoryToAdminMutationModel.class, new Deserializer());
            }

            public Object m6225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupReportStoryToAdminMutationParser.m6234a(jsonParser);
                Object groupReportStoryToAdminMutationModel = new GroupReportStoryToAdminMutationModel();
                ((BaseModel) groupReportStoryToAdminMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupReportStoryToAdminMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupReportStoryToAdminMutationModel).a();
                }
                return groupReportStoryToAdminMutationModel;
            }
        }

        /* compiled from: reaction_key */
        public class Serializer extends JsonSerializer<GroupReportStoryToAdminMutationModel> {
            public final void m6226a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupReportStoryToAdminMutationModel groupReportStoryToAdminMutationModel = (GroupReportStoryToAdminMutationModel) obj;
                if (groupReportStoryToAdminMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupReportStoryToAdminMutationModel.m6228a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupReportStoryToAdminMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupReportStoryToAdminMutationModel.w_();
                int u_ = groupReportStoryToAdminMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupReportStoryToAdminMutationModel.class, new Serializer());
            }
        }

        public GroupReportStoryToAdminMutationModel() {
            super(1);
        }

        @Nullable
        private String m6227a() {
            this.f5509d = super.a(this.f5509d, 0);
            return this.f5509d;
        }

        public final int jK_() {
            return 424513723;
        }

        public final GraphQLVisitableModel m6229a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6228a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6227a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
