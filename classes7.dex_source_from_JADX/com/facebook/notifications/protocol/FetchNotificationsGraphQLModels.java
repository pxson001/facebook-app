package com.facebook.notifications.protocol;

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
import com.facebook.graphql.enums.GraphQLNotifOptionClientActionType;
import com.facebook.graphql.enums.GraphQLNotifOptionRenderType;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.DeltaNotificationsQueryParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.DeltaNotificationsQueryParser.NotificationStoriesParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.DeltaNotificationsQueryParser.NotificationStoriesParser.PageInfoParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.GenericInlineActionNotifOptionRowDisplayFragmentParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotifInlineActionOptionFragmentParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotifInlineActionOptionFragmentParser.ClientInfoParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationHighlightOperationFragmentParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationHighlightOperationFragmentParser.CriteriaParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationHighlightOperationFragmentParser.HideTextParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationHighlightOperationFragmentParser.ShowTextParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationOptionRowParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationOptionRowParser.TextParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationOptionRowParser.UndoTextParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationStorySeenStateMutationFieldsConnectionParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationStorySeenStateMutationFieldsConnectionParser.EdgesParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationStorySeenStateMutationFieldsParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsDeltaFieldsParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionSetFragmentModel;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLInterfaces.SubmenuOptionSetFragment;
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

/* compiled from: negativeFeedbackActionOnReportableEntity */
public class FetchNotificationsGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2093527940)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class DeltaNotificationsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NotificationStoriesModel f8448d;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DeltaNotificationsQueryModel.class, new Deserializer());
            }

            public Object m10037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DeltaNotificationsQueryParser.m10262a(jsonParser);
                Object deltaNotificationsQueryModel = new DeltaNotificationsQueryModel();
                ((BaseModel) deltaNotificationsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (deltaNotificationsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) deltaNotificationsQueryModel).a();
                }
                return deltaNotificationsQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1913957601)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class NotificationStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NotificationsDeltaConnectionFieldsModel f8445d;
            @Nullable
            private List<NotificationsEdgeFieldsModel> f8446e;
            @Nullable
            private PageInfoModel f8447f;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NotificationStoriesModel.class, new Deserializer());
                }

                public Object m10038a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NotificationStoriesParser.m10260a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1558866721)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f8444d;

                /* compiled from: negativeFeedbackActionOnReportableEntity */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m10039a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m10258a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: negativeFeedbackActionOnReportableEntity */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m10040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m10041a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m10259a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(1);
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m10042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10041a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f8444d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m10043a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8444d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<NotificationStoriesModel> {
                public final void m10044a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NotificationStoriesModel notificationStoriesModel = (NotificationStoriesModel) obj;
                    if (notificationStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(notificationStoriesModel.m10048a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        notificationStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NotificationStoriesParser.m10261a(notificationStoriesModel.w_(), notificationStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NotificationStoriesModel.class, new Serializer());
                }
            }

            public NotificationStoriesModel() {
                super(3);
            }

            @Nullable
            private NotificationsDeltaConnectionFieldsModel m10045a() {
                this.f8445d = (NotificationsDeltaConnectionFieldsModel) super.a(this.f8445d, 0, NotificationsDeltaConnectionFieldsModel.class);
                return this.f8445d;
            }

            @Nonnull
            private ImmutableList<NotificationsEdgeFieldsModel> m10046j() {
                this.f8446e = super.a(this.f8446e, 1, NotificationsEdgeFieldsModel.class);
                return (ImmutableList) this.f8446e;
            }

            @Nullable
            private PageInfoModel m10047k() {
                this.f8447f = (PageInfoModel) super.a(this.f8447f, 2, PageInfoModel.class);
                return this.f8447f;
            }

            public final int jK_() {
                return -1207080506;
            }

            public final GraphQLVisitableModel m10049a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10045a() != null) {
                    NotificationsDeltaConnectionFieldsModel notificationsDeltaConnectionFieldsModel = (NotificationsDeltaConnectionFieldsModel) graphQLModelMutatingVisitor.b(m10045a());
                    if (m10045a() != notificationsDeltaConnectionFieldsModel) {
                        graphQLVisitableModel = (NotificationStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8445d = notificationsDeltaConnectionFieldsModel;
                    }
                }
                if (m10046j() != null) {
                    Builder a = ModelHelper.a(m10046j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        NotificationStoriesModel notificationStoriesModel = (NotificationStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        notificationStoriesModel.f8446e = a.b();
                        graphQLVisitableModel = notificationStoriesModel;
                    }
                }
                if (m10047k() != null) {
                    PageInfoModel pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m10047k());
                    if (m10047k() != pageInfoModel) {
                        graphQLVisitableModel = (NotificationStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8447f = pageInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10048a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10045a());
                int a2 = ModelHelper.a(flatBufferBuilder, m10046j());
                int a3 = ModelHelper.a(flatBufferBuilder, m10047k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<DeltaNotificationsQueryModel> {
            public final void m10050a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DeltaNotificationsQueryModel deltaNotificationsQueryModel = (DeltaNotificationsQueryModel) obj;
                if (deltaNotificationsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(deltaNotificationsQueryModel.m10052a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    deltaNotificationsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = deltaNotificationsQueryModel.w_();
                int u_ = deltaNotificationsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("notification_stories");
                    NotificationStoriesParser.m10261a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DeltaNotificationsQueryModel.class, new Serializer());
            }
        }

        public DeltaNotificationsQueryModel() {
            super(1);
        }

        @Nullable
        private NotificationStoriesModel m10051a() {
            this.f8448d = (NotificationStoriesModel) super.a(this.f8448d, 0, NotificationStoriesModel.class);
            return this.f8448d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m10053a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10051a() != null) {
                NotificationStoriesModel notificationStoriesModel = (NotificationStoriesModel) graphQLModelMutatingVisitor.b(m10051a());
                if (m10051a() != notificationStoriesModel) {
                    graphQLVisitableModel = (DeltaNotificationsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8448d = notificationStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10052a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10051a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -581220583)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class GenericInlineActionNotifOptionRowDisplayFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8458d;
        @Nullable
        private String f8459e;
        @Nullable
        private GraphQLNotifOptionRowDisplayStyle f8460f;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f8461g;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f8462h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f8463i;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class Builder {
            @Nullable
            public String f8452a;
            @Nullable
            public String f8453b;
            @Nullable
            public GraphQLNotifOptionRowDisplayStyle f8454c;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f8455d;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f8456e;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f8457f;

            public final GenericInlineActionNotifOptionRowDisplayFragmentModel m10068a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f8452a);
                int b2 = flatBufferBuilder.b(this.f8453b);
                int a = flatBufferBuilder.a(this.f8454c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f8455d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f8456e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f8457f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GenericInlineActionNotifOptionRowDisplayFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GenericInlineActionNotifOptionRowDisplayFragmentModel.class, new Deserializer());
            }

            public Object m10069a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GenericInlineActionNotifOptionRowDisplayFragmentParser.m10268a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object genericInlineActionNotifOptionRowDisplayFragmentModel = new GenericInlineActionNotifOptionRowDisplayFragmentModel();
                ((BaseModel) genericInlineActionNotifOptionRowDisplayFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (genericInlineActionNotifOptionRowDisplayFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) genericInlineActionNotifOptionRowDisplayFragmentModel).a();
                }
                return genericInlineActionNotifOptionRowDisplayFragmentModel;
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<GenericInlineActionNotifOptionRowDisplayFragmentModel> {
            public final void m10070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GenericInlineActionNotifOptionRowDisplayFragmentModel genericInlineActionNotifOptionRowDisplayFragmentModel = (GenericInlineActionNotifOptionRowDisplayFragmentModel) obj;
                if (genericInlineActionNotifOptionRowDisplayFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(genericInlineActionNotifOptionRowDisplayFragmentModel.m10075a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    genericInlineActionNotifOptionRowDisplayFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GenericInlineActionNotifOptionRowDisplayFragmentParser.m10269a(genericInlineActionNotifOptionRowDisplayFragmentModel.w_(), genericInlineActionNotifOptionRowDisplayFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GenericInlineActionNotifOptionRowDisplayFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m10080d() {
            return m10072j();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m10081g() {
            return m10074l();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields gp_() {
            return m10073k();
        }

        public GenericInlineActionNotifOptionRowDisplayFragmentModel() {
            super(6);
        }

        public GenericInlineActionNotifOptionRowDisplayFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m10077a() {
            this.f8458d = super.a(this.f8458d, 0);
            return this.f8458d;
        }

        @Nullable
        public final String m10078b() {
            this.f8459e = super.a(this.f8459e, 1);
            return this.f8459e;
        }

        @Nullable
        public final GraphQLNotifOptionRowDisplayStyle m10079c() {
            this.f8460f = (GraphQLNotifOptionRowDisplayStyle) super.b(this.f8460f, 2, GraphQLNotifOptionRowDisplayStyle.class, GraphQLNotifOptionRowDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8460f;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m10072j() {
            this.f8461g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8461g, 3, DefaultTextWithEntitiesFieldsModel.class);
            return this.f8461g;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m10073k() {
            this.f8462h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8462h, 4, DefaultTextWithEntitiesFieldsModel.class);
            return this.f8462h;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m10074l() {
            this.f8463i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8463i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f8463i;
        }

        public static GenericInlineActionNotifOptionRowDisplayFragmentModel m10071a(GenericInlineActionNotifOptionRowDisplayFragmentModel genericInlineActionNotifOptionRowDisplayFragmentModel) {
            if (genericInlineActionNotifOptionRowDisplayFragmentModel == null) {
                return null;
            }
            if (genericInlineActionNotifOptionRowDisplayFragmentModel instanceof GenericInlineActionNotifOptionRowDisplayFragmentModel) {
                return genericInlineActionNotifOptionRowDisplayFragmentModel;
            }
            Builder builder = new Builder();
            builder.f8452a = genericInlineActionNotifOptionRowDisplayFragmentModel.m10077a();
            builder.f8453b = genericInlineActionNotifOptionRowDisplayFragmentModel.m10078b();
            builder.f8454c = genericInlineActionNotifOptionRowDisplayFragmentModel.m10079c();
            builder.f8455d = DefaultTextWithEntitiesFieldsModel.a(genericInlineActionNotifOptionRowDisplayFragmentModel.m10080d());
            builder.f8456e = DefaultTextWithEntitiesFieldsModel.a(genericInlineActionNotifOptionRowDisplayFragmentModel.gp_());
            builder.f8457f = DefaultTextWithEntitiesFieldsModel.a(genericInlineActionNotifOptionRowDisplayFragmentModel.m10081g());
            return builder.m10068a();
        }

        public final int jK_() {
            return 1122700726;
        }

        public final GraphQLVisitableModel m10076a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10072j() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10072j());
                if (m10072j() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (GenericInlineActionNotifOptionRowDisplayFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8461g = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m10073k() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10073k());
                if (m10073k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (GenericInlineActionNotifOptionRowDisplayFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8462h = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m10074l() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10074l());
                if (m10074l() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (GenericInlineActionNotifOptionRowDisplayFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8463i = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10075a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10077a());
            int b2 = flatBufferBuilder.b(m10078b());
            int a = flatBufferBuilder.a(m10079c());
            int a2 = ModelHelper.a(flatBufferBuilder, m10072j());
            int a3 = ModelHelper.a(flatBufferBuilder, m10073k());
            int a4 = ModelHelper.a(flatBufferBuilder, m10074l());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -408397901)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class NotifInlineActionOptionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ClientInfoModel f8475d;
        @Nullable
        private GenericInlineActionNotifOptionRowDisplayFragmentModel f8476e;
        @Nullable
        private String f8477f;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class Builder {
            @Nullable
            public ClientInfoModel f8464a;
            @Nullable
            public GenericInlineActionNotifOptionRowDisplayFragmentModel f8465b;
            @Nullable
            public String f8466c;

            public static Builder m10082a(NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel) {
                Builder builder = new Builder();
                builder.f8464a = notifInlineActionOptionFragmentModel.m10103j();
                builder.f8465b = notifInlineActionOptionFragmentModel.m10104k();
                builder.f8466c = notifInlineActionOptionFragmentModel.m10102c();
                return builder;
            }

            public final NotifInlineActionOptionFragmentModel m10083a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f8464a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f8465b);
                int b = flatBufferBuilder.b(this.f8466c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new NotifInlineActionOptionFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1756152790)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class ClientInfoModel extends BaseModel implements GraphQLVisitableModel, SubmenuOptionSetFragment {
            @Nullable
            private GraphQLObjectType f8471d;
            @Nullable
            private GraphQLNotifOptionClientActionType f8472e;
            @Nullable
            private List<NotifOptionSetFragmentModel> f8473f;
            @Nullable
            private String f8474g;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f8467a;
                @Nullable
                public GraphQLNotifOptionClientActionType f8468b;
                @Nullable
                public ImmutableList<NotifOptionSetFragmentModel> f8469c;
                @Nullable
                public String f8470d;

                public static Builder m10084a(ClientInfoModel clientInfoModel) {
                    Builder builder = new Builder();
                    builder.f8467a = clientInfoModel.m10090a();
                    builder.f8468b = clientInfoModel.m10092b();
                    builder.f8469c = clientInfoModel.mo454c();
                    builder.f8470d = clientInfoModel.m10094d();
                    return builder;
                }

                public final ClientInfoModel m10085a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8467a);
                    int a2 = flatBufferBuilder.a(this.f8468b);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f8469c);
                    int b = flatBufferBuilder.b(this.f8470d);
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ClientInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ClientInfoModel.class, new Deserializer());
                }

                public Object m10086a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ClientInfoParser.m10270a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object clientInfoModel = new ClientInfoModel();
                    ((BaseModel) clientInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (clientInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) clientInfoModel).a();
                    }
                    return clientInfoModel;
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<ClientInfoModel> {
                public final void m10087a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ClientInfoModel clientInfoModel = (ClientInfoModel) obj;
                    if (clientInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(clientInfoModel.m10089a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        clientInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ClientInfoParser.m10271a(clientInfoModel.w_(), clientInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ClientInfoModel.class, new Serializer());
                }
            }

            public ClientInfoModel() {
                super(4);
            }

            public ClientInfoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m10090a() {
                if (this.b != null && this.f8471d == null) {
                    this.f8471d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8471d;
            }

            @Nullable
            public final GraphQLNotifOptionClientActionType m10092b() {
                this.f8472e = (GraphQLNotifOptionClientActionType) super.b(this.f8472e, 1, GraphQLNotifOptionClientActionType.class, GraphQLNotifOptionClientActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8472e;
            }

            @Nonnull
            public final ImmutableList<NotifOptionSetFragmentModel> mo454c() {
                this.f8473f = super.a(this.f8473f, 2, NotifOptionSetFragmentModel.class);
                return (ImmutableList) this.f8473f;
            }

            @Nullable
            public final String m10094d() {
                this.f8474g = super.a(this.f8474g, 3);
                return this.f8474g;
            }

            public static ClientInfoModel m10088a(ClientInfoModel clientInfoModel) {
                if (clientInfoModel == null) {
                    return null;
                }
                if (clientInfoModel instanceof ClientInfoModel) {
                    return clientInfoModel;
                }
                Builder builder = new Builder();
                builder.f8467a = clientInfoModel.m10090a();
                builder.f8468b = clientInfoModel.m10092b();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < clientInfoModel.mo454c().size(); i++) {
                    builder2.c(NotifOptionSetFragmentModel.m10518a((NotifOptionSetFragment) clientInfoModel.mo454c().get(i)));
                }
                builder.f8469c = builder2.b();
                builder.f8470d = clientInfoModel.m10094d();
                return builder.m10085a();
            }

            public final int jK_() {
                return -1672387034;
            }

            public final GraphQLVisitableModel m10091a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (mo454c() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo454c(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ClientInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8473f = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10089a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10090a());
                int a2 = flatBufferBuilder.a(m10092b());
                int a3 = ModelHelper.a(flatBufferBuilder, mo454c());
                int b = flatBufferBuilder.b(m10094d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotifInlineActionOptionFragmentModel.class, new Deserializer());
            }

            public Object m10095a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NotifInlineActionOptionFragmentParser.m10272a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object notifInlineActionOptionFragmentModel = new NotifInlineActionOptionFragmentModel();
                ((BaseModel) notifInlineActionOptionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (notifInlineActionOptionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) notifInlineActionOptionFragmentModel).a();
                }
                return notifInlineActionOptionFragmentModel;
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<NotifInlineActionOptionFragmentModel> {
            public final void m10096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel = (NotifInlineActionOptionFragmentModel) obj;
                if (notifInlineActionOptionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notifInlineActionOptionFragmentModel.m10098a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notifInlineActionOptionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NotifInlineActionOptionFragmentParser.m10273a(notifInlineActionOptionFragmentModel.w_(), notifInlineActionOptionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NotifInlineActionOptionFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ClientInfoModel m10100a() {
            return m10103j();
        }

        @Nullable
        public final /* synthetic */ GenericInlineActionNotifOptionRowDisplayFragmentModel m10101b() {
            return m10104k();
        }

        public NotifInlineActionOptionFragmentModel() {
            super(3);
        }

        public NotifInlineActionOptionFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final ClientInfoModel m10103j() {
            this.f8475d = (ClientInfoModel) super.a(this.f8475d, 0, ClientInfoModel.class);
            return this.f8475d;
        }

        @Nullable
        public final GenericInlineActionNotifOptionRowDisplayFragmentModel m10104k() {
            this.f8476e = (GenericInlineActionNotifOptionRowDisplayFragmentModel) super.a(this.f8476e, 1, GenericInlineActionNotifOptionRowDisplayFragmentModel.class);
            return this.f8476e;
        }

        @Nullable
        public final String m10102c() {
            this.f8477f = super.a(this.f8477f, 2);
            return this.f8477f;
        }

        public static NotifInlineActionOptionFragmentModel m10097a(NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel) {
            if (notifInlineActionOptionFragmentModel == null) {
                return null;
            }
            if (notifInlineActionOptionFragmentModel instanceof NotifInlineActionOptionFragmentModel) {
                return notifInlineActionOptionFragmentModel;
            }
            Builder builder = new Builder();
            builder.f8464a = ClientInfoModel.m10088a(notifInlineActionOptionFragmentModel.m10100a());
            builder.f8465b = GenericInlineActionNotifOptionRowDisplayFragmentModel.m10071a(notifInlineActionOptionFragmentModel.m10101b());
            builder.f8466c = notifInlineActionOptionFragmentModel.m10102c();
            return builder.m10083a();
        }

        public final int jK_() {
            return -1261484123;
        }

        public final GraphQLVisitableModel m10099a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10103j() != null) {
                ClientInfoModel clientInfoModel = (ClientInfoModel) graphQLModelMutatingVisitor.b(m10103j());
                if (m10103j() != clientInfoModel) {
                    graphQLVisitableModel = (NotifInlineActionOptionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8475d = clientInfoModel;
                }
            }
            if (m10104k() != null) {
                GenericInlineActionNotifOptionRowDisplayFragmentModel genericInlineActionNotifOptionRowDisplayFragmentModel = (GenericInlineActionNotifOptionRowDisplayFragmentModel) graphQLModelMutatingVisitor.b(m10104k());
                if (m10104k() != genericInlineActionNotifOptionRowDisplayFragmentModel) {
                    graphQLVisitableModel = (NotifInlineActionOptionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8476e = genericInlineActionNotifOptionRowDisplayFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10098a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10103j());
            int a2 = ModelHelper.a(flatBufferBuilder, m10104k());
            int b = flatBufferBuilder.b(m10102c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -651587784)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class NotificationHighlightOperationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<CriteriaModel> f8488d;
        @Nullable
        private HideTextModel f8489e;
        private boolean f8490f;
        @Nullable
        private ShowTextModel f8491g;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class Builder {
            @Nullable
            public ImmutableList<CriteriaModel> f8478a;
            @Nullable
            public HideTextModel f8479b;
            public boolean f8480c;
            @Nullable
            public ShowTextModel f8481d;
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1274278468)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class CriteriaModel extends BaseModel implements GraphQLVisitableModel {
            private int f8483d;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                public int f8482a;
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CriteriaModel.class, new Deserializer());
                }

                public Object m10105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CriteriaParser.m10275b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object criteriaModel = new CriteriaModel();
                    ((BaseModel) criteriaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (criteriaModel instanceof Postprocessable) {
                        return ((Postprocessable) criteriaModel).a();
                    }
                    return criteriaModel;
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<CriteriaModel> {
                public final void m10106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CriteriaModel criteriaModel = (CriteriaModel) obj;
                    if (criteriaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(criteriaModel.m10109a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        criteriaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CriteriaParser.m10274a(criteriaModel.w_(), criteriaModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CriteriaModel.class, new Serializer());
                }
            }

            public CriteriaModel() {
                super(1);
            }

            public CriteriaModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m10108a() {
                a(0, 0);
                return this.f8483d;
            }

            public static CriteriaModel m10107a(CriteriaModel criteriaModel) {
                if (criteriaModel == null) {
                    return null;
                }
                if (criteriaModel instanceof CriteriaModel) {
                    return criteriaModel;
                }
                Builder builder = new Builder();
                builder.f8482a = criteriaModel.m10108a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f8482a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CriteriaModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -963757896;
            }

            public final GraphQLVisitableModel m10110a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10109a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f8483d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10111a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8483d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotificationHighlightOperationFragmentModel.class, new Deserializer());
            }

            public Object m10112a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NotificationHighlightOperationFragmentParser.m10281b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object notificationHighlightOperationFragmentModel = new NotificationHighlightOperationFragmentModel();
                ((BaseModel) notificationHighlightOperationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (notificationHighlightOperationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) notificationHighlightOperationFragmentModel).a();
                }
                return notificationHighlightOperationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class HideTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8485d;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                @Nullable
                public String f8484a;
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HideTextModel.class, new Deserializer());
                }

                public Object m10113a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HideTextParser.m10276a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object hideTextModel = new HideTextModel();
                    ((BaseModel) hideTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (hideTextModel instanceof Postprocessable) {
                        return ((Postprocessable) hideTextModel).a();
                    }
                    return hideTextModel;
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<HideTextModel> {
                public final void m10114a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HideTextModel hideTextModel = (HideTextModel) obj;
                    if (hideTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(hideTextModel.m10116a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        hideTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HideTextParser.m10277a(hideTextModel.w_(), hideTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HideTextModel.class, new Serializer());
                }
            }

            public HideTextModel() {
                super(1);
            }

            public HideTextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10118a() {
                this.f8485d = super.a(this.f8485d, 0);
                return this.f8485d;
            }

            public static HideTextModel m10115a(HideTextModel hideTextModel) {
                if (hideTextModel == null) {
                    return null;
                }
                if (hideTextModel instanceof HideTextModel) {
                    return hideTextModel;
                }
                Builder builder = new Builder();
                builder.f8484a = hideTextModel.m10118a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8484a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new HideTextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10117a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10116a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10118a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<NotificationHighlightOperationFragmentModel> {
            public final void m10119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NotificationHighlightOperationFragmentModel notificationHighlightOperationFragmentModel = (NotificationHighlightOperationFragmentModel) obj;
                if (notificationHighlightOperationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notificationHighlightOperationFragmentModel.m10129a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notificationHighlightOperationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NotificationHighlightOperationFragmentParser.m10282b(notificationHighlightOperationFragmentModel.w_(), notificationHighlightOperationFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NotificationHighlightOperationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class ShowTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8487d;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                @Nullable
                public String f8486a;
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ShowTextModel.class, new Deserializer());
                }

                public Object m10120a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ShowTextParser.m10278a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object showTextModel = new ShowTextModel();
                    ((BaseModel) showTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (showTextModel instanceof Postprocessable) {
                        return ((Postprocessable) showTextModel).a();
                    }
                    return showTextModel;
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<ShowTextModel> {
                public final void m10121a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ShowTextModel showTextModel = (ShowTextModel) obj;
                    if (showTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(showTextModel.m10123a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        showTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ShowTextParser.m10279a(showTextModel.w_(), showTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ShowTextModel.class, new Serializer());
                }
            }

            public ShowTextModel() {
                super(1);
            }

            public ShowTextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10125a() {
                this.f8487d = super.a(this.f8487d, 0);
                return this.f8487d;
            }

            public static ShowTextModel m10122a(ShowTextModel showTextModel) {
                if (showTextModel == null) {
                    return null;
                }
                if (showTextModel instanceof ShowTextModel) {
                    return showTextModel;
                }
                Builder builder = new Builder();
                builder.f8486a = showTextModel.m10125a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8486a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ShowTextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10124a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10123a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10125a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ HideTextModel m10133b() {
            return m10127j();
        }

        @Nullable
        public final /* synthetic */ ShowTextModel m10135d() {
            return m10128k();
        }

        public NotificationHighlightOperationFragmentModel() {
            super(4);
        }

        public NotificationHighlightOperationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<CriteriaModel> m10131a() {
            this.f8488d = super.a(this.f8488d, 0, CriteriaModel.class);
            return (ImmutableList) this.f8488d;
        }

        @Nullable
        private HideTextModel m10127j() {
            this.f8489e = (HideTextModel) super.a(this.f8489e, 1, HideTextModel.class);
            return this.f8489e;
        }

        public final boolean m10134c() {
            a(0, 2);
            return this.f8490f;
        }

        @Nullable
        private ShowTextModel m10128k() {
            this.f8491g = (ShowTextModel) super.a(this.f8491g, 3, ShowTextModel.class);
            return this.f8491g;
        }

        public static NotificationHighlightOperationFragmentModel m10126a(NotificationHighlightOperationFragmentModel notificationHighlightOperationFragmentModel) {
            if (notificationHighlightOperationFragmentModel == null) {
                return null;
            }
            if (notificationHighlightOperationFragmentModel instanceof NotificationHighlightOperationFragmentModel) {
                return notificationHighlightOperationFragmentModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < notificationHighlightOperationFragmentModel.m10131a().size(); i++) {
                builder2.c(CriteriaModel.m10107a((CriteriaModel) notificationHighlightOperationFragmentModel.m10131a().get(i)));
            }
            builder.f8478a = builder2.b();
            builder.f8479b = HideTextModel.m10115a(notificationHighlightOperationFragmentModel.m10133b());
            builder.f8480c = notificationHighlightOperationFragmentModel.m10134c();
            builder.f8481d = ShowTextModel.m10122a(notificationHighlightOperationFragmentModel.m10135d());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f8478a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f8479b);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f8481d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, builder.f8480c);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new NotificationHighlightOperationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 315031422;
        }

        public final GraphQLVisitableModel m10130a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            HideTextModel hideTextModel;
            ShowTextModel showTextModel;
            h();
            if (m10131a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10131a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NotificationHighlightOperationFragmentModel notificationHighlightOperationFragmentModel = (NotificationHighlightOperationFragmentModel) ModelHelper.a(null, this);
                    notificationHighlightOperationFragmentModel.f8488d = a.b();
                    graphQLVisitableModel = notificationHighlightOperationFragmentModel;
                    if (m10127j() != null) {
                        hideTextModel = (HideTextModel) graphQLModelMutatingVisitor.b(m10127j());
                        if (m10127j() != hideTextModel) {
                            graphQLVisitableModel = (NotificationHighlightOperationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8489e = hideTextModel;
                        }
                    }
                    if (m10128k() != null) {
                        showTextModel = (ShowTextModel) graphQLModelMutatingVisitor.b(m10128k());
                        if (m10128k() != showTextModel) {
                            graphQLVisitableModel = (NotificationHighlightOperationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8491g = showTextModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m10127j() != null) {
                hideTextModel = (HideTextModel) graphQLModelMutatingVisitor.b(m10127j());
                if (m10127j() != hideTextModel) {
                    graphQLVisitableModel = (NotificationHighlightOperationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8489e = hideTextModel;
                }
            }
            if (m10128k() != null) {
                showTextModel = (ShowTextModel) graphQLModelMutatingVisitor.b(m10128k());
                if (m10128k() != showTextModel) {
                    graphQLVisitableModel = (NotificationHighlightOperationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8491g = showTextModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m10129a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10131a());
            int a2 = ModelHelper.a(flatBufferBuilder, m10127j());
            int a3 = ModelHelper.a(flatBufferBuilder, m10128k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f8490f);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10132a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8490f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -617039644)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class NotificationOptionRowModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8502d;
        @Nullable
        private GraphQLNotifOptionRenderType f8503e;
        @Nullable
        private String f8504f;
        @Nullable
        private TextModel f8505g;
        @Nullable
        private String f8506h;
        @Nullable
        private UndoTextModel f8507i;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class Builder {
            @Nullable
            public String f8492a;
            @Nullable
            public GraphQLNotifOptionRenderType f8493b;
            @Nullable
            public String f8494c;
            @Nullable
            public TextModel f8495d;
            @Nullable
            public String f8496e;
            @Nullable
            public UndoTextModel f8497f;
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotificationOptionRowModel.class, new Deserializer());
            }

            public Object m10136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NotificationOptionRowParser.m10288b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object notificationOptionRowModel = new NotificationOptionRowModel();
                ((BaseModel) notificationOptionRowModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (notificationOptionRowModel instanceof Postprocessable) {
                    return ((Postprocessable) notificationOptionRowModel).a();
                }
                return notificationOptionRowModel;
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<NotificationOptionRowModel> {
            public final void m10137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NotificationOptionRowModel notificationOptionRowModel = (NotificationOptionRowModel) obj;
                if (notificationOptionRowModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notificationOptionRowModel.m10153a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notificationOptionRowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NotificationOptionRowParser.m10289b(notificationOptionRowModel.w_(), notificationOptionRowModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NotificationOptionRowModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class TextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8499d;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                @Nullable
                public String f8498a;
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TextModel.class, new Deserializer());
                }

                public Object m10138a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TextParser.m10283a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object textModel = new TextModel();
                    ((BaseModel) textModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (textModel instanceof Postprocessable) {
                        return ((Postprocessable) textModel).a();
                    }
                    return textModel;
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<TextModel> {
                public final void m10139a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TextModel textModel = (TextModel) obj;
                    if (textModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(textModel.m10141a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        textModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TextParser.m10284a(textModel.w_(), textModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TextModel.class, new Serializer());
                }
            }

            public TextModel() {
                super(1);
            }

            public TextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10143a() {
                this.f8499d = super.a(this.f8499d, 0);
                return this.f8499d;
            }

            public static TextModel m10140a(TextModel textModel) {
                if (textModel == null) {
                    return null;
                }
                if (textModel instanceof TextModel) {
                    return textModel;
                }
                Builder builder = new Builder();
                builder.f8498a = textModel.m10143a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8498a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10142a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10141a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10143a());
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
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class UndoTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8501d;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                @Nullable
                public String f8500a;
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UndoTextModel.class, new Deserializer());
                }

                public Object m10144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UndoTextParser.m10285a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object undoTextModel = new UndoTextModel();
                    ((BaseModel) undoTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (undoTextModel instanceof Postprocessable) {
                        return ((Postprocessable) undoTextModel).a();
                    }
                    return undoTextModel;
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<UndoTextModel> {
                public final void m10145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UndoTextModel undoTextModel = (UndoTextModel) obj;
                    if (undoTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(undoTextModel.m10147a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        undoTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UndoTextParser.m10286a(undoTextModel.w_(), undoTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UndoTextModel.class, new Serializer());
                }
            }

            public UndoTextModel() {
                super(1);
            }

            public UndoTextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10149a() {
                this.f8501d = super.a(this.f8501d, 0);
                return this.f8501d;
            }

            public static UndoTextModel m10146a(UndoTextModel undoTextModel) {
                if (undoTextModel == null) {
                    return null;
                }
                if (undoTextModel instanceof UndoTextModel) {
                    return undoTextModel;
                }
                Builder builder = new Builder();
                builder.f8500a = undoTextModel.m10149a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8500a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new UndoTextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10148a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10147a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10149a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ TextModel m10158d() {
            return m10151j();
        }

        @Nullable
        public final /* synthetic */ UndoTextModel m10159g() {
            return m10152k();
        }

        public NotificationOptionRowModel() {
            super(6);
        }

        public NotificationOptionRowModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m10155a() {
            this.f8502d = super.a(this.f8502d, 0);
            return this.f8502d;
        }

        @Nullable
        public final GraphQLNotifOptionRenderType m10156b() {
            this.f8503e = (GraphQLNotifOptionRenderType) super.b(this.f8503e, 1, GraphQLNotifOptionRenderType.class, GraphQLNotifOptionRenderType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8503e;
        }

        @Nullable
        public final String m10157c() {
            this.f8504f = super.a(this.f8504f, 2);
            return this.f8504f;
        }

        @Nullable
        private TextModel m10151j() {
            this.f8505g = (TextModel) super.a(this.f8505g, 3, TextModel.class);
            return this.f8505g;
        }

        @Nullable
        public final String gq_() {
            this.f8506h = super.a(this.f8506h, 4);
            return this.f8506h;
        }

        @Nullable
        private UndoTextModel m10152k() {
            this.f8507i = (UndoTextModel) super.a(this.f8507i, 5, UndoTextModel.class);
            return this.f8507i;
        }

        public static NotificationOptionRowModel m10150a(NotificationOptionRowModel notificationOptionRowModel) {
            if (notificationOptionRowModel == null) {
                return null;
            }
            if (notificationOptionRowModel instanceof NotificationOptionRowModel) {
                return notificationOptionRowModel;
            }
            Builder builder = new Builder();
            builder.f8492a = notificationOptionRowModel.m10155a();
            builder.f8493b = notificationOptionRowModel.m10156b();
            builder.f8494c = notificationOptionRowModel.m10157c();
            builder.f8495d = TextModel.m10140a(notificationOptionRowModel.m10158d());
            builder.f8496e = notificationOptionRowModel.gq_();
            builder.f8497f = UndoTextModel.m10146a(notificationOptionRowModel.m10159g());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f8492a);
            int a = flatBufferBuilder.a(builder.f8493b);
            int b2 = flatBufferBuilder.b(builder.f8494c);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f8495d);
            int b3 = flatBufferBuilder.b(builder.f8496e);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f8497f);
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new NotificationOptionRowModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 90414069;
        }

        public final GraphQLVisitableModel m10154a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10151j() != null) {
                TextModel textModel = (TextModel) graphQLModelMutatingVisitor.b(m10151j());
                if (m10151j() != textModel) {
                    graphQLVisitableModel = (NotificationOptionRowModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8505g = textModel;
                }
            }
            if (m10152k() != null) {
                UndoTextModel undoTextModel = (UndoTextModel) graphQLModelMutatingVisitor.b(m10152k());
                if (m10152k() != undoTextModel) {
                    graphQLVisitableModel = (NotificationOptionRowModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8507i = undoTextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10153a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10155a());
            int a = flatBufferBuilder.a(m10156b());
            int b2 = flatBufferBuilder.b(m10157c());
            int a2 = ModelHelper.a(flatBufferBuilder, m10151j());
            int b3 = flatBufferBuilder.b(gq_());
            int a3 = ModelHelper.a(flatBufferBuilder, m10152k());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 438225336)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class NotificationStorySeenStateMutationFieldsConnectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f8511d;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class Builder {
            @Nullable
            public ImmutableList<EdgesModel> f8508a;

            public final NotificationStorySeenStateMutationFieldsConnectionModel m10160a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f8508a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new NotificationStorySeenStateMutationFieldsConnectionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotificationStorySeenStateMutationFieldsConnectionModel.class, new Deserializer());
            }

            public Object m10161a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NotificationStorySeenStateMutationFieldsConnectionParser.m10292a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object notificationStorySeenStateMutationFieldsConnectionModel = new NotificationStorySeenStateMutationFieldsConnectionModel();
                ((BaseModel) notificationStorySeenStateMutationFieldsConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (notificationStorySeenStateMutationFieldsConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) notificationStorySeenStateMutationFieldsConnectionModel).a();
                }
                return notificationStorySeenStateMutationFieldsConnectionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 398705076)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NotificationStorySeenStateMutationFieldsModel f8510d;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                @Nullable
                public NotificationStorySeenStateMutationFieldsModel f8509a;
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m10162a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m10290b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m10163a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m10165a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m10291b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private NotificationStorySeenStateMutationFieldsModel m10164a() {
                this.f8510d = (NotificationStorySeenStateMutationFieldsModel) super.a(this.f8510d, 0, NotificationStorySeenStateMutationFieldsModel.class);
                return this.f8510d;
            }

            public final int jK_() {
                return -560159067;
            }

            public final GraphQLVisitableModel m10166a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10164a() != null) {
                    NotificationStorySeenStateMutationFieldsModel notificationStorySeenStateMutationFieldsModel = (NotificationStorySeenStateMutationFieldsModel) graphQLModelMutatingVisitor.b(m10164a());
                    if (m10164a() != notificationStorySeenStateMutationFieldsModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8510d = notificationStorySeenStateMutationFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10165a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10164a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<NotificationStorySeenStateMutationFieldsConnectionModel> {
            public final void m10167a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NotificationStorySeenStateMutationFieldsConnectionModel notificationStorySeenStateMutationFieldsConnectionModel = (NotificationStorySeenStateMutationFieldsConnectionModel) obj;
                if (notificationStorySeenStateMutationFieldsConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notificationStorySeenStateMutationFieldsConnectionModel.m10169a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notificationStorySeenStateMutationFieldsConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = notificationStorySeenStateMutationFieldsConnectionModel.w_();
                int u_ = notificationStorySeenStateMutationFieldsConnectionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        EdgesParser.m10291b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NotificationStorySeenStateMutationFieldsConnectionModel.class, new Serializer());
            }
        }

        public NotificationStorySeenStateMutationFieldsConnectionModel() {
            super(1);
        }

        public NotificationStorySeenStateMutationFieldsConnectionModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        private ImmutableList<EdgesModel> m10168a() {
            this.f8511d = super.a(this.f8511d, 0, EdgesModel.class);
            return (ImmutableList) this.f8511d;
        }

        public final int jK_() {
            return -1207080506;
        }

        public final GraphQLVisitableModel m10170a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10168a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10168a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (NotificationStorySeenStateMutationFieldsConnectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8511d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10169a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10168a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 598303605)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class NotificationStorySeenStateMutationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f8514d;
        @Nullable
        private GraphQLStorySeenState f8515e;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class Builder {
            @Nullable
            public String f8512a;
            @Nullable
            public GraphQLStorySeenState f8513b;

            public final NotificationStorySeenStateMutationFieldsModel m10171a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f8512a);
                int a = flatBufferBuilder.a(this.f8513b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new NotificationStorySeenStateMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotificationStorySeenStateMutationFieldsModel.class, new Deserializer());
            }

            public Object m10172a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NotificationStorySeenStateMutationFieldsParser.m10293a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object notificationStorySeenStateMutationFieldsModel = new NotificationStorySeenStateMutationFieldsModel();
                ((BaseModel) notificationStorySeenStateMutationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (notificationStorySeenStateMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) notificationStorySeenStateMutationFieldsModel).a();
                }
                return notificationStorySeenStateMutationFieldsModel;
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<NotificationStorySeenStateMutationFieldsModel> {
            public final void m10173a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NotificationStorySeenStateMutationFieldsModel notificationStorySeenStateMutationFieldsModel = (NotificationStorySeenStateMutationFieldsModel) obj;
                if (notificationStorySeenStateMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notificationStorySeenStateMutationFieldsModel.m10177a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notificationStorySeenStateMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NotificationStorySeenStateMutationFieldsParser.m10294a(notificationStorySeenStateMutationFieldsModel.w_(), notificationStorySeenStateMutationFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(NotificationStorySeenStateMutationFieldsModel.class, new Serializer());
            }
        }

        public NotificationStorySeenStateMutationFieldsModel() {
            super(2);
        }

        public NotificationStorySeenStateMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m10180a(String str, ConsistencyTuple consistencyTuple) {
            if ("seen_state".equals(str)) {
                consistencyTuple.a = m10176k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m10181a(String str, Object obj, boolean z) {
            if ("seen_state".equals(str)) {
                m10174a((GraphQLStorySeenState) obj);
            }
        }

        @Nullable
        private String m10175j() {
            this.f8514d = super.a(this.f8514d, 0);
            return this.f8514d;
        }

        @Nullable
        private GraphQLStorySeenState m10176k() {
            this.f8515e = (GraphQLStorySeenState) super.b(this.f8515e, 1, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8515e;
        }

        private void m10174a(GraphQLStorySeenState graphQLStorySeenState) {
            this.f8515e = graphQLStorySeenState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLStorySeenState != null ? graphQLStorySeenState.name() : null);
            }
        }

        @Nullable
        public final String m10179a() {
            return m10175j();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m10178a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10177a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10175j());
            int a = flatBufferBuilder.a(m10176k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -532147985)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class NotificationsDeltaFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NotificationsEdgeFieldsModel f8516d;
        @Nullable
        private String f8517e;
        @Nullable
        private String f8518f;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotificationsDeltaFieldsModel.class, new Deserializer());
            }

            public Object m10184a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NotificationsDeltaFieldsParser.m10297b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object notificationsDeltaFieldsModel = new NotificationsDeltaFieldsModel();
                ((BaseModel) notificationsDeltaFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (notificationsDeltaFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) notificationsDeltaFieldsModel).a();
                }
                return notificationsDeltaFieldsModel;
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<NotificationsDeltaFieldsModel> {
            public final void m10185a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NotificationsDeltaFieldsModel notificationsDeltaFieldsModel = (NotificationsDeltaFieldsModel) obj;
                if (notificationsDeltaFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notificationsDeltaFieldsModel.m10187a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notificationsDeltaFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NotificationsDeltaFieldsParser.m10298b(notificationsDeltaFieldsModel.w_(), notificationsDeltaFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NotificationsDeltaFieldsModel.class, new Serializer());
            }
        }

        public NotificationsDeltaFieldsModel() {
            super(3);
        }

        @Nullable
        public final NotificationsEdgeFieldsModel m10189a() {
            this.f8516d = (NotificationsEdgeFieldsModel) super.a(this.f8516d, 0, NotificationsEdgeFieldsModel.class);
            return this.f8516d;
        }

        @Nullable
        public final String m10190j() {
            this.f8517e = super.a(this.f8517e, 1);
            return this.f8517e;
        }

        @Nullable
        private String m10186k() {
            this.f8518f = super.a(this.f8518f, 2);
            return this.f8518f;
        }

        public final int jK_() {
            return -185950256;
        }

        public final GraphQLVisitableModel m10188a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10189a() != null) {
                NotificationsEdgeFieldsModel notificationsEdgeFieldsModel = (NotificationsEdgeFieldsModel) graphQLModelMutatingVisitor.b(m10189a());
                if (m10189a() != notificationsEdgeFieldsModel) {
                    graphQLVisitableModel = (NotificationsDeltaFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8516d = notificationsEdgeFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10187a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10189a());
            int b = flatBufferBuilder.b(m10190j());
            int b2 = flatBufferBuilder.b(m10186k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
