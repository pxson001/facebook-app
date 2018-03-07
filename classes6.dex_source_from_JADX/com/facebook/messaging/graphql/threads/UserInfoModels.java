package com.facebook.messaging.graphql.threads;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCommercePageSetting;
import com.facebook.graphql.enums.GraphQLCommercePageType;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLMessengerCallToActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.BotInfoModels.BotInfoModel.PageMessengerBotModel;
import com.facebook.messaging.graphql.threads.UserInfoInterfaces.NameFields;
import com.facebook.messaging.graphql.threads.UserInfoParsers.CustomerDataFragParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.CustomerDataFragParser.CustomTagLinksParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.CustomerDataFragParser.CustomTagLinksParser.NodesParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.CustomerDataFragParser.CustomTagLinksParser.NodesParser.CustomTagParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.MessagingActorIdParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.MessagingActorIdParser.MessagingActorIdOnlyParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.MessagingActorInfoParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.NameFieldsParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.NameFieldsParser.PartsParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.ParticipantInfoParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.ParticipantInfoParser.MessagingActorParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.ProfilePhotoInfoParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.UserInfoParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.UserInfoParser.MessagingGeoParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.UserInfoParser.MessengerCtasParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.UserInfoParser.PhoneNumberParser;
import com.facebook.messaging.graphql.threads.UserInfoParsers.UserInfoParser.StructuredNameParser;
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

/* compiled from: video-publishers(%s) */
public class UserInfoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1200054700)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video-publishers(%s) */
    public final class CustomerDataFragModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CustomTagLinksModel f1662d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1231105769)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class CustomTagLinksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1661d;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CustomTagLinksModel.class, new Deserializer());
                }

                public Object m2787a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CustomTagLinksParser.m2937a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object customTagLinksModel = new CustomTagLinksModel();
                    ((BaseModel) customTagLinksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (customTagLinksModel instanceof Postprocessable) {
                        return ((Postprocessable) customTagLinksModel).a();
                    }
                    return customTagLinksModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 127570862)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video-publishers(%s) */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CustomTagModel f1660d;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 685646730)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: video-publishers(%s) */
                public final class CustomTagModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f1655d;
                    @Nullable
                    private String f1656e;
                    @Nullable
                    private String f1657f;
                    @Nullable
                    private String f1658g;
                    @Nullable
                    private String f1659h;

                    /* compiled from: video-publishers(%s) */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(CustomTagModel.class, new Deserializer());
                        }

                        public Object m2788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(CustomTagParser.m2933a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object customTagModel = new CustomTagModel();
                            ((BaseModel) customTagModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (customTagModel instanceof Postprocessable) {
                                return ((Postprocessable) customTagModel).a();
                            }
                            return customTagModel;
                        }
                    }

                    /* compiled from: video-publishers(%s) */
                    public class Serializer extends JsonSerializer<CustomTagModel> {
                        public final void m2789a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            CustomTagModel customTagModel = (CustomTagModel) obj;
                            if (customTagModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(customTagModel.m2793a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                customTagModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            CustomTagParser.m2934a(customTagModel.w_(), customTagModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(CustomTagModel.class, new Serializer());
                        }
                    }

                    public CustomTagModel() {
                        super(5);
                    }

                    public final void m2796a(String str, ConsistencyTuple consistencyTuple) {
                        if ("border_color".equals(str)) {
                            consistencyTuple.a = m2798j();
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 0;
                        } else if ("color".equals(str)) {
                            consistencyTuple.a = m2799k();
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 1;
                        } else if ("fill_color".equals(str)) {
                            consistencyTuple.a = m2800l();
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 2;
                        } else {
                            consistencyTuple.a();
                        }
                    }

                    public final void m2797a(String str, Object obj, boolean z) {
                        if ("border_color".equals(str)) {
                            m2790a((String) obj);
                        } else if ("color".equals(str)) {
                            m2791b((String) obj);
                        } else if ("fill_color".equals(str)) {
                            m2792c((String) obj);
                        }
                    }

                    @Nullable
                    public final String m2798j() {
                        this.f1655d = super.a(this.f1655d, 0);
                        return this.f1655d;
                    }

                    private void m2790a(@Nullable String str) {
                        this.f1655d = str;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 0, str);
                        }
                    }

                    @Nullable
                    public final String m2799k() {
                        this.f1656e = super.a(this.f1656e, 1);
                        return this.f1656e;
                    }

                    private void m2791b(@Nullable String str) {
                        this.f1656e = str;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 1, str);
                        }
                    }

                    @Nullable
                    public final String m2800l() {
                        this.f1657f = super.a(this.f1657f, 2);
                        return this.f1657f;
                    }

                    private void m2792c(@Nullable String str) {
                        this.f1657f = str;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 2, str);
                        }
                    }

                    @Nullable
                    public final String m2801m() {
                        this.f1658g = super.a(this.f1658g, 3);
                        return this.f1658g;
                    }

                    @Nullable
                    public final String m2802n() {
                        this.f1659h = super.a(this.f1659h, 4);
                        return this.f1659h;
                    }

                    @Nullable
                    public final String m2795a() {
                        return m2801m();
                    }

                    public final int jK_() {
                        return -1816160134;
                    }

                    public final GraphQLVisitableModel m2794a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m2793a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m2798j());
                        int b2 = flatBufferBuilder.b(m2799k());
                        int b3 = flatBufferBuilder.b(m2800l());
                        int b4 = flatBufferBuilder.b(m2801m());
                        int b5 = flatBufferBuilder.b(m2802n());
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, b3);
                        flatBufferBuilder.b(3, b4);
                        flatBufferBuilder.b(4, b5);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: video-publishers(%s) */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m2803a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m2935b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: video-publishers(%s) */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m2804a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m2805a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m2936b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                public final CustomTagModel m2807a() {
                    this.f1660d = (CustomTagModel) super.a(this.f1660d, 0, CustomTagModel.class);
                    return this.f1660d;
                }

                public final int jK_() {
                    return -1560376686;
                }

                public final GraphQLVisitableModel m2806a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2807a() != null) {
                        CustomTagModel customTagModel = (CustomTagModel) graphQLModelMutatingVisitor.b(m2807a());
                        if (m2807a() != customTagModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1660d = customTagModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2805a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2807a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<CustomTagLinksModel> {
                public final void m2808a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CustomTagLinksModel customTagLinksModel = (CustomTagLinksModel) obj;
                    if (customTagLinksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(customTagLinksModel.m2809a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        customTagLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CustomTagLinksParser.m2938a(customTagLinksModel.w_(), customTagLinksModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CustomTagLinksModel.class, new Serializer());
                }
            }

            public CustomTagLinksModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m2811a() {
                this.f1661d = super.a(this.f1661d, 0, NodesModel.class);
                return (ImmutableList) this.f1661d;
            }

            public final int jK_() {
                return -724289291;
            }

            public final GraphQLVisitableModel m2810a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2811a() != null) {
                    Builder a = ModelHelper.a(m2811a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CustomTagLinksModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1661d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2809a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2811a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CustomerDataFragModel.class, new Deserializer());
            }

            public Object m2812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CustomerDataFragParser.m2939a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object customerDataFragModel = new CustomerDataFragModel();
                ((BaseModel) customerDataFragModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (customerDataFragModel instanceof Postprocessable) {
                    return ((Postprocessable) customerDataFragModel).a();
                }
                return customerDataFragModel;
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Serializer extends JsonSerializer<CustomerDataFragModel> {
            public final void m2813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CustomerDataFragModel customerDataFragModel = (CustomerDataFragModel) obj;
                if (customerDataFragModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(customerDataFragModel.m2814a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    customerDataFragModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CustomerDataFragParser.m2940a(customerDataFragModel.w_(), customerDataFragModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CustomerDataFragModel.class, new Serializer());
            }
        }

        public CustomerDataFragModel() {
            super(1);
        }

        @Nullable
        public final CustomTagLinksModel m2816a() {
            this.f1662d = (CustomTagLinksModel) super.a(this.f1662d, 0, CustomTagLinksModel.class);
            return this.f1662d;
        }

        public final int jK_() {
            return -1028416595;
        }

        public final GraphQLVisitableModel m2815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2816a() != null) {
                CustomTagLinksModel customTagLinksModel = (CustomTagLinksModel) graphQLModelMutatingVisitor.b(m2816a());
                if (m2816a() != customTagLinksModel) {
                    graphQLVisitableModel = (CustomerDataFragModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1662d = customTagLinksModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2814a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2816a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -754618842)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video-publishers(%s) */
    public final class MessagingActorIdModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessagingActorIdOnlyModel f1665d;

        /* compiled from: video-publishers(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessagingActorIdModel.class, new Deserializer());
            }

            public Object m2817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessagingActorIdParser.m2945b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messagingActorIdModel = new MessagingActorIdModel();
                ((BaseModel) messagingActorIdModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messagingActorIdModel instanceof Postprocessable) {
                    return ((Postprocessable) messagingActorIdModel).a();
                }
                return messagingActorIdModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class MessagingActorIdOnlyModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f1663d;
            @Nullable
            private String f1664e;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessagingActorIdOnlyModel.class, new Deserializer());
                }

                public Object m2818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessagingActorIdOnlyParser.m2941a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messagingActorIdOnlyModel = new MessagingActorIdOnlyModel();
                    ((BaseModel) messagingActorIdOnlyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messagingActorIdOnlyModel instanceof Postprocessable) {
                        return ((Postprocessable) messagingActorIdOnlyModel).a();
                    }
                    return messagingActorIdOnlyModel;
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<MessagingActorIdOnlyModel> {
                public final void m2819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessagingActorIdOnlyModel messagingActorIdOnlyModel = (MessagingActorIdOnlyModel) obj;
                    if (messagingActorIdOnlyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messagingActorIdOnlyModel.m2821a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messagingActorIdOnlyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessagingActorIdOnlyParser.m2942a(messagingActorIdOnlyModel.w_(), messagingActorIdOnlyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessagingActorIdOnlyModel.class, new Serializer());
                }
            }

            public MessagingActorIdOnlyModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m2820k() {
                if (this.b != null && this.f1663d == null) {
                    this.f1663d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1663d;
            }

            @Nullable
            public final String m2824j() {
                this.f1664e = super.a(this.f1664e, 1);
                return this.f1664e;
            }

            @Nullable
            public final String m2823a() {
                return m2824j();
            }

            public final int jK_() {
                return -1575218831;
            }

            public final GraphQLVisitableModel m2822a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2821a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2820k());
                int b = flatBufferBuilder.b(m2824j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Serializer extends JsonSerializer<MessagingActorIdModel> {
            public final void m2825a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MessagingActorIdModel messagingActorIdModel = (MessagingActorIdModel) obj;
                if (messagingActorIdModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messagingActorIdModel.m2826a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messagingActorIdModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MessagingActorIdParser.m2946b(messagingActorIdModel.w_(), messagingActorIdModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MessagingActorIdModel.class, new Serializer());
            }
        }

        public MessagingActorIdModel() {
            super(1);
        }

        @Nullable
        public final MessagingActorIdOnlyModel m2828a() {
            this.f1665d = (MessagingActorIdOnlyModel) super.a(this.f1665d, 0, MessagingActorIdOnlyModel.class);
            return this.f1665d;
        }

        public final int jK_() {
            return -1020278353;
        }

        public final GraphQLVisitableModel m2827a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2828a() != null) {
                MessagingActorIdOnlyModel messagingActorIdOnlyModel = (MessagingActorIdOnlyModel) graphQLModelMutatingVisitor.b(m2828a());
                if (m2828a() != messagingActorIdOnlyModel) {
                    graphQLVisitableModel = (MessagingActorIdModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1665d = messagingActorIdOnlyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2826a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2828a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -890332492)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video-publishers(%s) */
    public final class MessagingActorInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserInfoModel f1666d;

        /* compiled from: video-publishers(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessagingActorInfoModel.class, new Deserializer());
            }

            public Object m2829a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessagingActorInfoParser.m2949b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messagingActorInfoModel = new MessagingActorInfoModel();
                ((BaseModel) messagingActorInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messagingActorInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) messagingActorInfoModel).a();
                }
                return messagingActorInfoModel;
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Serializer extends JsonSerializer<MessagingActorInfoModel> {
            public final void m2830a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MessagingActorInfoModel messagingActorInfoModel = (MessagingActorInfoModel) obj;
                if (messagingActorInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messagingActorInfoModel.m2831a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messagingActorInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MessagingActorInfoParser.m2950b(messagingActorInfoModel.w_(), messagingActorInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MessagingActorInfoModel.class, new Serializer());
            }
        }

        public MessagingActorInfoModel() {
            super(1);
        }

        @Nullable
        public final UserInfoModel m2833a() {
            this.f1666d = (UserInfoModel) super.a(this.f1666d, 0, UserInfoModel.class);
            return this.f1666d;
        }

        public final int jK_() {
            return -1020278353;
        }

        public final GraphQLVisitableModel m2832a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2833a() != null) {
                UserInfoModel userInfoModel = (UserInfoModel) graphQLModelMutatingVisitor.b(m2833a());
                if (m2833a() != userInfoModel) {
                    graphQLVisitableModel = (MessagingActorInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1666d = userInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2831a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2833a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1803460325)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video-publishers(%s) */
    public final class NameFieldsModel extends BaseModel implements GraphQLVisitableModel, NameFields {
        @Nullable
        private List<PartsModel> f1670d;
        @Nullable
        private String f1671e;

        /* compiled from: video-publishers(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NameFieldsModel.class, new Deserializer());
            }

            public Object m2834a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NameFieldsParser.m2955a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nameFieldsModel = new NameFieldsModel();
                ((BaseModel) nameFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nameFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) nameFieldsModel).a();
                }
                return nameFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1501120714)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class PartsModel extends BaseModel implements GraphQLVisitableModel {
            private int f1667d;
            private int f1668e;
            @Nullable
            private GraphQLStructuredNamePart f1669f;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PartsModel.class, new Deserializer());
                }

                public Object m2835a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PartsParser.m2954b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object partsModel = new PartsModel();
                    ((BaseModel) partsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (partsModel instanceof Postprocessable) {
                        return ((Postprocessable) partsModel).a();
                    }
                    return partsModel;
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<PartsModel> {
                public final void m2836a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PartsModel partsModel = (PartsModel) obj;
                    if (partsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(partsModel.m2838a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        partsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PartsParser.m2952a(partsModel.w_(), partsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PartsModel.class, new Serializer());
                }
            }

            public PartsModel() {
                super(3);
            }

            public final int m2837a() {
                a(0, 0);
                return this.f1667d;
            }

            public final int m2841b() {
                a(0, 1);
                return this.f1668e;
            }

            @Nullable
            public final GraphQLStructuredNamePart m2842c() {
                this.f1669f = (GraphQLStructuredNamePart) super.b(this.f1669f, 2, GraphQLStructuredNamePart.class, GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1669f;
            }

            public final int jK_() {
                return 1905097022;
            }

            public final GraphQLVisitableModel m2839a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2838a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m2842c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f1667d, 0);
                flatBufferBuilder.a(1, this.f1668e, 0);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2840a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1667d = mutableFlatBuffer.a(i, 0, 0);
                this.f1668e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Serializer extends JsonSerializer<NameFieldsModel> {
            public final void m2843a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NameFieldsModel nameFieldsModel = (NameFieldsModel) obj;
                if (nameFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nameFieldsModel.m2844a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nameFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NameFieldsParser.m2956a(nameFieldsModel.w_(), nameFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NameFieldsModel.class, new Serializer());
            }
        }

        public NameFieldsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<PartsModel> mo147a() {
            this.f1670d = super.a(this.f1670d, 0, PartsModel.class);
            return (ImmutableList) this.f1670d;
        }

        @Nullable
        public final String mo148b() {
            this.f1671e = super.a(this.f1671e, 1);
            return this.f1671e;
        }

        public final int jK_() {
            return 2420395;
        }

        public final GraphQLVisitableModel m2845a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo147a() != null) {
                Builder a = ModelHelper.a(mo147a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (NameFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1670d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2844a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo147a());
            int b = flatBufferBuilder.b(mo148b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1973238515)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video-publishers(%s) */
    public final class ParticipantInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessagingActorModel f1675d;

        /* compiled from: video-publishers(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ParticipantInfoModel.class, new Deserializer());
            }

            public Object m2848a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ParticipantInfoParser.m2959a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object participantInfoModel = new ParticipantInfoModel();
                ((BaseModel) participantInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (participantInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) participantInfoModel).a();
                }
                return participantInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f1672d;
            @Nullable
            private String f1673e;
            @Nullable
            private String f1674f;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                }

                public Object m2849a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessagingActorParser.m2957a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messagingActorModel = new MessagingActorModel();
                    ((BaseModel) messagingActorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messagingActorModel instanceof Postprocessable) {
                        return ((Postprocessable) messagingActorModel).a();
                    }
                    return messagingActorModel;
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<MessagingActorModel> {
                public final void m2850a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                    if (messagingActorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messagingActorModel.m2852a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessagingActorParser.m2958a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                }
            }

            public MessagingActorModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m2851j() {
                if (this.b != null && this.f1672d == null) {
                    this.f1672d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1672d;
            }

            @Nullable
            public final String m2855b() {
                this.f1673e = super.a(this.f1673e, 1);
                return this.f1673e;
            }

            @Nullable
            public final String m2856c() {
                this.f1674f = super.a(this.f1674f, 2);
                return this.f1674f;
            }

            @Nullable
            public final String m2854a() {
                return m2855b();
            }

            public final int jK_() {
                return -1575218831;
            }

            public final GraphQLVisitableModel m2853a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2852a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2851j());
                int b = flatBufferBuilder.b(m2855b());
                int b2 = flatBufferBuilder.b(m2856c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Serializer extends JsonSerializer<ParticipantInfoModel> {
            public final void m2857a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ParticipantInfoModel participantInfoModel = (ParticipantInfoModel) obj;
                if (participantInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(participantInfoModel.m2858a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    participantInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ParticipantInfoParser.m2962b(participantInfoModel.w_(), participantInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ParticipantInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MessagingActorModel m2860a() {
            return m2861j();
        }

        public ParticipantInfoModel() {
            super(1);
        }

        @Nullable
        public final MessagingActorModel m2861j() {
            this.f1675d = (MessagingActorModel) super.a(this.f1675d, 0, MessagingActorModel.class);
            return this.f1675d;
        }

        public final int jK_() {
            return -1020278353;
        }

        public final GraphQLVisitableModel m2859a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2861j() != null) {
                MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m2861j());
                if (m2861j() != messagingActorModel) {
                    graphQLVisitableModel = (ParticipantInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1675d = messagingActorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2858a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2861j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -817178504)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video-publishers(%s) */
    public final class ProfilePhotoInfoModel extends BaseModel implements GraphQLVisitableModel {
        private int f1678d;
        @Nullable
        private String f1679e;

        /* compiled from: video-publishers(%s) */
        public final class Builder {
            public int f1676a;
            @Nullable
            public String f1677b;
        }

        /* compiled from: video-publishers(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfilePhotoInfoModel.class, new Deserializer());
            }

            public Object m2862a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfilePhotoInfoParser.m2963a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profilePhotoInfoModel = new ProfilePhotoInfoModel();
                ((BaseModel) profilePhotoInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profilePhotoInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) profilePhotoInfoModel).a();
                }
                return profilePhotoInfoModel;
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Serializer extends JsonSerializer<ProfilePhotoInfoModel> {
            public final void m2863a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfilePhotoInfoModel profilePhotoInfoModel = (ProfilePhotoInfoModel) obj;
                if (profilePhotoInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profilePhotoInfoModel.m2865a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profilePhotoInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfilePhotoInfoParser.m2964a(profilePhotoInfoModel.w_(), profilePhotoInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ProfilePhotoInfoModel.class, new Serializer());
            }
        }

        public ProfilePhotoInfoModel() {
            super(2);
        }

        public ProfilePhotoInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m2864a() {
            a(0, 0);
            return this.f1678d;
        }

        @Nullable
        public final String m2868j() {
            this.f1679e = super.a(this.f1679e, 1);
            return this.f1679e;
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m2866a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2865a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2868j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f1678d, 0);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2867a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1678d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1653624940)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video-publishers(%s) */
    public final class UserInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private ProfilePhotoInfoModel f1691A;
        @Nullable
        private ProfilePhotoInfoModel f1692B;
        @Nullable
        private ProfilePhotoInfoModel f1693C;
        @Nullable
        private StructuredNameModel f1694D;
        @Nullable
        private String f1695E;
        @Nullable
        private GraphQLObjectType f1696d;
        private boolean f1697e;
        private boolean f1698f;
        @Nullable
        private List<GraphQLCommercePageSetting> f1699g;
        @Nullable
        private GraphQLCommercePageType f1700h;
        private double f1701i;
        @Nullable
        private CustomerDataFragModel f1702j;
        @Nullable
        private List<String> f1703k;
        @Nullable
        private GraphQLFriendshipStatus f1704l;
        @Nullable
        private String f1705m;
        private boolean f1706n;
        private boolean f1707o;
        private boolean f1708p;
        private boolean f1709q;
        private boolean f1710r;
        private boolean f1711s;
        private boolean f1712t;
        @Nullable
        private MessagingGeoModel f1713u;
        @Nullable
        private List<MessengerCtasModel> f1714v;
        @Nullable
        private String f1715w;
        @Nullable
        private String f1716x;
        @Nullable
        private PageMessengerBotModel f1717y;
        @Nullable
        private PhoneNumberModel f1718z;

        /* compiled from: video-publishers(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserInfoModel.class, new Deserializer());
            }

            public Object m2869a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(UserInfoParser.m2974a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object userInfoModel = new UserInfoModel();
                ((BaseModel) userInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (userInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) userInfoModel).a();
                }
                return userInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 588213278)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class MessagingGeoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1680d;
            @Nullable
            private String f1681e;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessagingGeoModel.class, new Deserializer());
                }

                public Object m2870a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessagingGeoParser.m2965a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messagingGeoModel = new MessagingGeoModel();
                    ((BaseModel) messagingGeoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messagingGeoModel instanceof Postprocessable) {
                        return ((Postprocessable) messagingGeoModel).a();
                    }
                    return messagingGeoModel;
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<MessagingGeoModel> {
                public final void m2871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessagingGeoModel messagingGeoModel = (MessagingGeoModel) obj;
                    if (messagingGeoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messagingGeoModel.m2874a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messagingGeoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessagingGeoParser.m2966a(messagingGeoModel.w_(), messagingGeoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessagingGeoModel.class, new Serializer());
                }
            }

            public MessagingGeoModel() {
                super(2);
            }

            @Nullable
            private String m2872a() {
                this.f1680d = super.a(this.f1680d, 0);
                return this.f1680d;
            }

            @Nullable
            private String m2873j() {
                this.f1681e = super.a(this.f1681e, 1);
                return this.f1681e;
            }

            public final int jK_() {
                return -993810995;
            }

            public final GraphQLVisitableModel m2875a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2874a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2872a());
                int b2 = flatBufferBuilder.b(m2873j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1874197655)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class MessengerCtasModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLMessengerCallToActionType f1682d;
            @Nullable
            private String f1683e;
            @Nullable
            private String f1684f;
            @Nullable
            private String f1685g;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerCtasModel.class, new Deserializer());
                }

                public Object m2876a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerCtasParser.m2969b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerCtasModel = new MessengerCtasModel();
                    ((BaseModel) messengerCtasModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerCtasModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerCtasModel).a();
                    }
                    return messengerCtasModel;
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<MessengerCtasModel> {
                public final void m2877a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerCtasModel messengerCtasModel = (MessengerCtasModel) obj;
                    if (messengerCtasModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerCtasModel.m2878a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerCtasModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerCtasParser.m2968a(messengerCtasModel.w_(), messengerCtasModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerCtasModel.class, new Serializer());
                }
            }

            public MessengerCtasModel() {
                super(4);
            }

            @Nullable
            public final GraphQLMessengerCallToActionType m2881j() {
                this.f1682d = (GraphQLMessengerCallToActionType) super.b(this.f1682d, 0, GraphQLMessengerCallToActionType.class, GraphQLMessengerCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1682d;
            }

            @Nullable
            public final String m2882k() {
                this.f1683e = super.a(this.f1683e, 1);
                return this.f1683e;
            }

            @Nullable
            public final String m2883l() {
                this.f1684f = super.a(this.f1684f, 2);
                return this.f1684f;
            }

            @Nullable
            public final String m2884m() {
                this.f1685g = super.a(this.f1685g, 3);
                return this.f1685g;
            }

            @Nullable
            public final String m2880a() {
                return m2884m();
            }

            public final int jK_() {
                return -1676907614;
            }

            public final GraphQLVisitableModel m2879a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2878a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m2881j());
                int b = flatBufferBuilder.b(m2882k());
                int b2 = flatBufferBuilder.b(m2883l());
                int b3 = flatBufferBuilder.b(m2884m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 44074500)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1686d;
            @Nullable
            private String f1687e;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
                }

                public Object m2885a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhoneNumberParser.m2970a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object phoneNumberModel = new PhoneNumberModel();
                    ((BaseModel) phoneNumberModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (phoneNumberModel instanceof Postprocessable) {
                        return ((Postprocessable) phoneNumberModel).a();
                    }
                    return phoneNumberModel;
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<PhoneNumberModel> {
                public final void m2886a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                    if (phoneNumberModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(phoneNumberModel.m2888a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhoneNumberParser.m2971a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
                }
            }

            public PhoneNumberModel() {
                super(2);
            }

            @Nullable
            private String m2887j() {
                this.f1686d = super.a(this.f1686d, 0);
                return this.f1686d;
            }

            @Nullable
            public final String m2890a() {
                this.f1687e = super.a(this.f1687e, 1);
                return this.f1687e;
            }

            public final int jK_() {
                return 474898999;
            }

            public final GraphQLVisitableModel m2889a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2888a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2887j());
                int b2 = flatBufferBuilder.b(m2890a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video-publishers(%s) */
        public class Serializer extends JsonSerializer<UserInfoModel> {
            public final void m2891a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                UserInfoModel userInfoModel = (UserInfoModel) obj;
                if (userInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userInfoModel.m2910a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                UserInfoParser.m2975a(userInfoModel.w_(), userInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(UserInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -3558805)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video-publishers(%s) */
        public final class StructuredNameModel extends BaseModel implements GraphQLVisitableModel, NameFields {
            @Nullable
            private List<PartsModel> f1688d;
            @Nullable
            private NameFieldsModel f1689e;
            @Nullable
            private String f1690f;

            /* compiled from: video-publishers(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StructuredNameModel.class, new Deserializer());
                }

                public Object m2892a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StructuredNameParser.m2972a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object structuredNameModel = new StructuredNameModel();
                    ((BaseModel) structuredNameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (structuredNameModel instanceof Postprocessable) {
                        return ((Postprocessable) structuredNameModel).a();
                    }
                    return structuredNameModel;
                }
            }

            /* compiled from: video-publishers(%s) */
            public class Serializer extends JsonSerializer<StructuredNameModel> {
                public final void m2893a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StructuredNameModel structuredNameModel = (StructuredNameModel) obj;
                    if (structuredNameModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(structuredNameModel.m2894a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        structuredNameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StructuredNameParser.m2973a(structuredNameModel.w_(), structuredNameModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StructuredNameModel.class, new Serializer());
                }
            }

            public StructuredNameModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<PartsModel> mo147a() {
                this.f1688d = super.a(this.f1688d, 0, PartsModel.class);
                return (ImmutableList) this.f1688d;
            }

            @Nullable
            public final NameFieldsModel m2898j() {
                this.f1689e = (NameFieldsModel) super.a(this.f1689e, 1, NameFieldsModel.class);
                return this.f1689e;
            }

            @Nullable
            public final String mo148b() {
                this.f1690f = super.a(this.f1690f, 2);
                return this.f1690f;
            }

            public final int jK_() {
                return 2420395;
            }

            public final GraphQLVisitableModel m2895a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                NameFieldsModel nameFieldsModel;
                h();
                if (mo147a() != null) {
                    Builder a = ModelHelper.a(mo147a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        StructuredNameModel structuredNameModel = (StructuredNameModel) ModelHelper.a(null, this);
                        structuredNameModel.f1688d = a.b();
                        graphQLVisitableModel = structuredNameModel;
                        if (m2898j() != null) {
                            nameFieldsModel = (NameFieldsModel) graphQLModelMutatingVisitor.b(m2898j());
                            if (m2898j() != nameFieldsModel) {
                                graphQLVisitableModel = (StructuredNameModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f1689e = nameFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m2898j() != null) {
                    nameFieldsModel = (NameFieldsModel) graphQLModelMutatingVisitor.b(m2898j());
                    if (m2898j() != nameFieldsModel) {
                        graphQLVisitableModel = (StructuredNameModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1689e = nameFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m2894a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo147a());
                int a2 = ModelHelper.a(flatBufferBuilder, m2898j());
                int b = flatBufferBuilder.b(mo148b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public UserInfoModel() {
            super(28);
        }

        public final void m2914a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2915a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m2916j() {
            if (this.b != null && this.f1696d == null) {
                this.f1696d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1696d;
        }

        public final boolean m2917k() {
            a(0, 1);
            return this.f1697e;
        }

        public final boolean m2918l() {
            a(0, 2);
            return this.f1698f;
        }

        @Nonnull
        public final ImmutableList<GraphQLCommercePageSetting> m2919m() {
            this.f1699g = super.c(this.f1699g, 3, GraphQLCommercePageSetting.class);
            return (ImmutableList) this.f1699g;
        }

        @Nullable
        public final GraphQLCommercePageType m2920n() {
            this.f1700h = (GraphQLCommercePageType) super.b(this.f1700h, 4, GraphQLCommercePageType.class, GraphQLCommercePageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1700h;
        }

        public final double m2921o() {
            a(0, 5);
            return this.f1701i;
        }

        @Nullable
        public final CustomerDataFragModel m2922p() {
            this.f1702j = (CustomerDataFragModel) super.a(this.f1702j, 6, CustomerDataFragModel.class);
            return this.f1702j;
        }

        @Nonnull
        public final ImmutableList<String> m2923q() {
            this.f1703k = super.a(this.f1703k, 7);
            return (ImmutableList) this.f1703k;
        }

        @Nullable
        public final GraphQLFriendshipStatus m2924r() {
            this.f1704l = (GraphQLFriendshipStatus) super.b(this.f1704l, 8, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1704l;
        }

        @Nullable
        public final String m2925s() {
            this.f1705m = super.a(this.f1705m, 9);
            return this.f1705m;
        }

        public final boolean m2926t() {
            a(1, 2);
            return this.f1706n;
        }

        public final boolean m2927u() {
            a(1, 3);
            return this.f1707o;
        }

        public final boolean m2928v() {
            a(1, 4);
            return this.f1708p;
        }

        public final boolean m2929w() {
            a(1, 5);
            return this.f1709q;
        }

        public final boolean m2930x() {
            a(1, 6);
            return this.f1710r;
        }

        public final boolean m2931y() {
            a(1, 7);
            return this.f1711s;
        }

        public final boolean m2932z() {
            a(2, 0);
            return this.f1712t;
        }

        @Nullable
        private MessagingGeoModel m2899K() {
            this.f1713u = (MessagingGeoModel) super.a(this.f1713u, 17, MessagingGeoModel.class);
            return this.f1713u;
        }

        @Nonnull
        public final ImmutableList<MessengerCtasModel> m2900A() {
            this.f1714v = super.a(this.f1714v, 18, MessengerCtasModel.class);
            return (ImmutableList) this.f1714v;
        }

        @Nullable
        public final String m2901B() {
            this.f1715w = super.a(this.f1715w, 19);
            return this.f1715w;
        }

        @Nullable
        public final String m2902C() {
            this.f1716x = super.a(this.f1716x, 20);
            return this.f1716x;
        }

        @Nullable
        public final PageMessengerBotModel m2903D() {
            this.f1717y = (PageMessengerBotModel) super.a(this.f1717y, 21, PageMessengerBotModel.class);
            return this.f1717y;
        }

        @Nullable
        public final PhoneNumberModel m2904E() {
            this.f1718z = (PhoneNumberModel) super.a(this.f1718z, 22, PhoneNumberModel.class);
            return this.f1718z;
        }

        @Nullable
        public final ProfilePhotoInfoModel m2905F() {
            this.f1691A = (ProfilePhotoInfoModel) super.a(this.f1691A, 23, ProfilePhotoInfoModel.class);
            return this.f1691A;
        }

        @Nullable
        public final ProfilePhotoInfoModel m2906G() {
            this.f1692B = (ProfilePhotoInfoModel) super.a(this.f1692B, 24, ProfilePhotoInfoModel.class);
            return this.f1692B;
        }

        @Nullable
        public final ProfilePhotoInfoModel m2907H() {
            this.f1693C = (ProfilePhotoInfoModel) super.a(this.f1693C, 25, ProfilePhotoInfoModel.class);
            return this.f1693C;
        }

        @Nullable
        public final StructuredNameModel m2908I() {
            this.f1694D = (StructuredNameModel) super.a(this.f1694D, 26, StructuredNameModel.class);
            return this.f1694D;
        }

        @Nullable
        public final String m2909J() {
            this.f1695E = super.a(this.f1695E, 27);
            return this.f1695E;
        }

        @Nullable
        public final String m2912a() {
            return m2925s();
        }

        public final int jK_() {
            return -1575218831;
        }

        public final GraphQLVisitableModel m2911a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ProfilePhotoInfoModel profilePhotoInfoModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2922p() != null) {
                CustomerDataFragModel customerDataFragModel = (CustomerDataFragModel) graphQLModelMutatingVisitor.b(m2922p());
                if (m2922p() != customerDataFragModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1702j = customerDataFragModel;
                }
            }
            if (m2899K() != null) {
                MessagingGeoModel messagingGeoModel = (MessagingGeoModel) graphQLModelMutatingVisitor.b(m2899K());
                if (m2899K() != messagingGeoModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1713u = messagingGeoModel;
                }
            }
            if (m2900A() != null) {
                Builder a = ModelHelper.a(m2900A(), graphQLModelMutatingVisitor);
                if (a != null) {
                    UserInfoModel userInfoModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    userInfoModel.f1714v = a.b();
                    graphQLVisitableModel = userInfoModel;
                }
            }
            if (m2903D() != null) {
                PageMessengerBotModel pageMessengerBotModel = (PageMessengerBotModel) graphQLModelMutatingVisitor.b(m2903D());
                if (m2903D() != pageMessengerBotModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1717y = pageMessengerBotModel;
                }
            }
            if (m2904E() != null) {
                PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m2904E());
                if (m2904E() != phoneNumberModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1718z = phoneNumberModel;
                }
            }
            if (m2905F() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m2905F());
                if (m2905F() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1691A = profilePhotoInfoModel;
                }
            }
            if (m2906G() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m2906G());
                if (m2906G() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1692B = profilePhotoInfoModel;
                }
            }
            if (m2907H() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m2907H());
                if (m2907H() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1693C = profilePhotoInfoModel;
                }
            }
            if (m2908I() != null) {
                StructuredNameModel structuredNameModel = (StructuredNameModel) graphQLModelMutatingVisitor.b(m2908I());
                if (m2908I() != structuredNameModel) {
                    graphQLVisitableModel = (UserInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1694D = structuredNameModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2910a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2916j());
            int d = flatBufferBuilder.d(m2919m());
            int a2 = flatBufferBuilder.a(m2920n());
            int a3 = ModelHelper.a(flatBufferBuilder, m2922p());
            int c = flatBufferBuilder.c(m2923q());
            int a4 = flatBufferBuilder.a(m2924r());
            int b = flatBufferBuilder.b(m2925s());
            int a5 = ModelHelper.a(flatBufferBuilder, m2899K());
            int a6 = ModelHelper.a(flatBufferBuilder, m2900A());
            int b2 = flatBufferBuilder.b(m2901B());
            int b3 = flatBufferBuilder.b(m2902C());
            int a7 = ModelHelper.a(flatBufferBuilder, m2903D());
            int a8 = ModelHelper.a(flatBufferBuilder, m2904E());
            int a9 = ModelHelper.a(flatBufferBuilder, m2905F());
            int a10 = ModelHelper.a(flatBufferBuilder, m2906G());
            int a11 = ModelHelper.a(flatBufferBuilder, m2907H());
            int a12 = ModelHelper.a(flatBufferBuilder, m2908I());
            int b4 = flatBufferBuilder.b(m2909J());
            flatBufferBuilder.c(28);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1697e);
            flatBufferBuilder.a(2, this.f1698f);
            flatBufferBuilder.b(3, d);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.a(5, this.f1701i, 0.0d);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.b(7, c);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, b);
            flatBufferBuilder.a(10, this.f1706n);
            flatBufferBuilder.a(11, this.f1707o);
            flatBufferBuilder.a(12, this.f1708p);
            flatBufferBuilder.a(13, this.f1709q);
            flatBufferBuilder.a(14, this.f1710r);
            flatBufferBuilder.a(15, this.f1711s);
            flatBufferBuilder.a(16, this.f1712t);
            flatBufferBuilder.b(17, a5);
            flatBufferBuilder.b(18, a6);
            flatBufferBuilder.b(19, b2);
            flatBufferBuilder.b(20, b3);
            flatBufferBuilder.b(21, a7);
            flatBufferBuilder.b(22, a8);
            flatBufferBuilder.b(23, a9);
            flatBufferBuilder.b(24, a10);
            flatBufferBuilder.b(25, a11);
            flatBufferBuilder.b(26, a12);
            flatBufferBuilder.b(27, b4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2913a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1697e = mutableFlatBuffer.a(i, 1);
            this.f1698f = mutableFlatBuffer.a(i, 2);
            this.f1701i = mutableFlatBuffer.a(i, 5, 0.0d);
            this.f1706n = mutableFlatBuffer.a(i, 10);
            this.f1707o = mutableFlatBuffer.a(i, 11);
            this.f1708p = mutableFlatBuffer.a(i, 12);
            this.f1709q = mutableFlatBuffer.a(i, 13);
            this.f1710r = mutableFlatBuffer.a(i, 14);
            this.f1711s = mutableFlatBuffer.a(i, 15);
            this.f1712t = mutableFlatBuffer.a(i, 16);
        }
    }
}
