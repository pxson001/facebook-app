package com.facebook.pages.data.graphql.notificationcounts;

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
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.AdminInfoParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.AdminInfoParser.ViewerParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.AdminInfoParser.ViewerParser.MessageThreadsParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.AdminInfoParser.ViewerParser.NotificationStoriesParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.PageLikersParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -231566005)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: reactionStories' feedUnitFragment's title is null */
public final class FetchNotificationCountsGraphQLModels$PageNotificationCountsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private AdminInfoModel f2748d;
    @Nullable
    private String f2749e;
    @Nullable
    private PageLikersModel f2750f;

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1967580613)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reactionStories' feedUnitFragment's title is null */
    public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f2746d;

        /* compiled from: reactionStories' feedUnitFragment's title is null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
            }

            public Object m3683a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdminInfoParser.m3731a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object adminInfoModel = new AdminInfoModel();
                ((BaseModel) adminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (adminInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) adminInfoModel).a();
                }
                return adminInfoModel;
            }
        }

        /* compiled from: reactionStories' feedUnitFragment's title is null */
        public class Serializer extends JsonSerializer<AdminInfoModel> {
            public final void m3684a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                if (adminInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adminInfoModel.m3703a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdminInfoParser.m3732a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 364165109)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: reactionStories' feedUnitFragment's title is null */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MessageThreadsModel f2744d;
            @Nullable
            private NotificationStoriesModel f2745e;

            /* compiled from: reactionStories' feedUnitFragment's title is null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m3685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m3729a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1805368280)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: reactionStories' feedUnitFragment's title is null */
            public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
                private int f2741d;
                private int f2742e;

                /* compiled from: reactionStories' feedUnitFragment's title is null */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                    }

                    public Object m3686a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MessageThreadsParser.m3725a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object messageThreadsModel = new MessageThreadsModel();
                        ((BaseModel) messageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (messageThreadsModel instanceof Postprocessable) {
                            return ((Postprocessable) messageThreadsModel).a();
                        }
                        return messageThreadsModel;
                    }
                }

                /* compiled from: reactionStories' feedUnitFragment's title is null */
                public class Serializer extends JsonSerializer<MessageThreadsModel> {
                    public final void m3687a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                        if (messageThreadsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(messageThreadsModel.m3689a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MessageThreadsParser.m3726a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                    }
                }

                public MessageThreadsModel() {
                    super(2);
                }

                public final int m3688a() {
                    a(0, 1);
                    return this.f2742e;
                }

                public final int jK_() {
                    return 1828653682;
                }

                public final GraphQLVisitableModel m3690a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m3689a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2741d, 0);
                    flatBufferBuilder.a(1, this.f2742e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m3691a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f2741d = mutableFlatBuffer.a(i, 0, 0);
                    this.f2742e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 179261320)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: reactionStories' feedUnitFragment's title is null */
            public final class NotificationStoriesModel extends BaseModel implements GraphQLVisitableModel {
                private int f2743d;

                /* compiled from: reactionStories' feedUnitFragment's title is null */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NotificationStoriesModel.class, new Deserializer());
                    }

                    public Object m3692a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NotificationStoriesParser.m3727a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object notificationStoriesModel = new NotificationStoriesModel();
                        ((BaseModel) notificationStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (notificationStoriesModel instanceof Postprocessable) {
                            return ((Postprocessable) notificationStoriesModel).a();
                        }
                        return notificationStoriesModel;
                    }
                }

                /* compiled from: reactionStories' feedUnitFragment's title is null */
                public class Serializer extends JsonSerializer<NotificationStoriesModel> {
                    public final void m3693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NotificationStoriesModel notificationStoriesModel = (NotificationStoriesModel) obj;
                        if (notificationStoriesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(notificationStoriesModel.m3695a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            notificationStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NotificationStoriesParser.m3728a(notificationStoriesModel.w_(), notificationStoriesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NotificationStoriesModel.class, new Serializer());
                    }
                }

                public NotificationStoriesModel() {
                    super(1);
                }

                public final int m3694a() {
                    a(0, 0);
                    return this.f2743d;
                }

                public final int jK_() {
                    return -1207080506;
                }

                public final GraphQLVisitableModel m3696a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m3695a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f2743d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m3697a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f2743d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: reactionStories' feedUnitFragment's title is null */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m3698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m3699a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m3730a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(2);
            }

            @Nullable
            public final MessageThreadsModel m3701a() {
                this.f2744d = (MessageThreadsModel) super.a(this.f2744d, 0, MessageThreadsModel.class);
                return this.f2744d;
            }

            @Nullable
            public final NotificationStoriesModel m3702j() {
                this.f2745e = (NotificationStoriesModel) super.a(this.f2745e, 1, NotificationStoriesModel.class);
                return this.f2745e;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m3700a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3701a() != null) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m3701a());
                    if (m3701a() != messageThreadsModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2744d = messageThreadsModel;
                    }
                }
                if (m3702j() != null) {
                    NotificationStoriesModel notificationStoriesModel = (NotificationStoriesModel) graphQLModelMutatingVisitor.b(m3702j());
                    if (m3702j() != notificationStoriesModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2745e = notificationStoriesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3699a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3701a());
                int a2 = ModelHelper.a(flatBufferBuilder, m3702j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AdminInfoModel() {
            super(1);
        }

        @Nullable
        public final ViewerModel m3705a() {
            this.f2746d = (ViewerModel) super.a(this.f2746d, 0, ViewerModel.class);
            return this.f2746d;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m3704a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3705a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m3705a());
                if (m3705a() != viewerModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2746d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3703a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3705a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: reactionStories' feedUnitFragment's title is null */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(FetchNotificationCountsGraphQLModels$PageNotificationCountsModel.class, new Deserializer());
        }

        public Object m3706a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(PageNotificationCountsParser.m3735b(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object fetchNotificationCountsGraphQLModels$PageNotificationCountsModel = new FetchNotificationCountsGraphQLModels$PageNotificationCountsModel();
            ((BaseModel) fetchNotificationCountsGraphQLModels$PageNotificationCountsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (fetchNotificationCountsGraphQLModels$PageNotificationCountsModel instanceof Postprocessable) {
                return ((Postprocessable) fetchNotificationCountsGraphQLModels$PageNotificationCountsModel).a();
            }
            return fetchNotificationCountsGraphQLModels$PageNotificationCountsModel;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 325533782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reactionStories' feedUnitFragment's title is null */
    public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
        private int f2747d;

        /* compiled from: reactionStories' feedUnitFragment's title is null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
            }

            public Object m3707a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageLikersParser.m3733a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageLikersModel = new PageLikersModel();
                ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageLikersModel instanceof Postprocessable) {
                    return ((Postprocessable) pageLikersModel).a();
                }
                return pageLikersModel;
            }
        }

        /* compiled from: reactionStories' feedUnitFragment's title is null */
        public class Serializer extends JsonSerializer<PageLikersModel> {
            public final void m3708a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageLikersModel pageLikersModel = (PageLikersModel) obj;
                if (pageLikersModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageLikersModel.m3710a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageLikersParser.m3734a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PageLikersModel.class, new Serializer());
            }
        }

        public PageLikersModel() {
            super(1);
        }

        public final int m3709a() {
            a(0, 0);
            return this.f2747d;
        }

        public final int jK_() {
            return 637021669;
        }

        public final GraphQLVisitableModel m3711a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3710a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f2747d, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3712a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2747d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    /* compiled from: reactionStories' feedUnitFragment's title is null */
    public class Serializer extends JsonSerializer<FetchNotificationCountsGraphQLModels$PageNotificationCountsModel> {
        public final void m3713a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            FetchNotificationCountsGraphQLModels$PageNotificationCountsModel fetchNotificationCountsGraphQLModels$PageNotificationCountsModel = (FetchNotificationCountsGraphQLModels$PageNotificationCountsModel) obj;
            if (fetchNotificationCountsGraphQLModels$PageNotificationCountsModel.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(fetchNotificationCountsGraphQLModels$PageNotificationCountsModel.m3716a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                fetchNotificationCountsGraphQLModels$PageNotificationCountsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            PageNotificationCountsParser.m3736b(fetchNotificationCountsGraphQLModels$PageNotificationCountsModel.w_(), fetchNotificationCountsGraphQLModels$PageNotificationCountsModel.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(FetchNotificationCountsGraphQLModels$PageNotificationCountsModel.class, new Serializer());
        }
    }

    public FetchNotificationCountsGraphQLModels$PageNotificationCountsModel() {
        super(3);
    }

    public final void m3719a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m3720a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final AdminInfoModel m3721j() {
        this.f2748d = (AdminInfoModel) super.a(this.f2748d, 0, AdminInfoModel.class);
        return this.f2748d;
    }

    @Nullable
    private String m3714k() {
        this.f2749e = super.a(this.f2749e, 1);
        return this.f2749e;
    }

    @Nullable
    private PageLikersModel m3715l() {
        this.f2750f = (PageLikersModel) super.a(this.f2750f, 2, PageLikersModel.class);
        return this.f2750f;
    }

    @Nullable
    public final String m3718a() {
        return m3714k();
    }

    public final int jK_() {
        return 2479791;
    }

    public final GraphQLVisitableModel m3717a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3721j() != null) {
            AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m3721j());
            if (m3721j() != adminInfoModel) {
                graphQLVisitableModel = (FetchNotificationCountsGraphQLModels$PageNotificationCountsModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f2748d = adminInfoModel;
            }
        }
        if (m3715l() != null) {
            PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m3715l());
            if (m3715l() != pageLikersModel) {
                graphQLVisitableModel = (FetchNotificationCountsGraphQLModels$PageNotificationCountsModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2750f = pageLikersModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3716a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3721j());
        int b = flatBufferBuilder.b(m3714k());
        int a2 = ModelHelper.a(flatBufferBuilder, m3715l());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        i();
        return flatBufferBuilder.d();
    }
}
