package com.facebook.pages.app.data.protocol.methods.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMailboxFolder;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageAdminReplyType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.LastMessageParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.LastMessageParser.LastMessageNodesParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.LastMessageParser.LastMessageNodesParser.MessageParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.LastMessageParser.LastMessageNodesParser.MessageSenderParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.LastMessageParser.LastMessageNodesParser.MessageSenderParser.MessagingActorParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.OtherParticipantsParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.OtherParticipantsParser.OtherParticipantsNodesParser;
import com.facebook.pages.app.data.protocol.methods.graphql.ContactSearchParsers.ContactSearchQueryParser.MessageThreadsParser.NodesParser.ThreadKeyParser;
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

/* compiled from: system_page_load */
public class ContactSearchModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 365216817)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: system_page_load */
    public final class ContactSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f1164d;

        /* compiled from: system_page_load */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactSearchQueryModel.class, new Deserializer());
            }

            public Object m1534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContactSearchQueryParser.m1633a(jsonParser);
                Object contactSearchQueryModel = new ContactSearchQueryModel();
                ((BaseModel) contactSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contactSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) contactSearchQueryModel).a();
                }
                return contactSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1775679785)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: system_page_load */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1163d;

            /* compiled from: system_page_load */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m1535a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageThreadsParser.m1631a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -313346810)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: system_page_load */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLMailboxFolder f1155d;
                private boolean f1156e;
                private boolean f1157f;
                @Nullable
                private LastMessageModel f1158g;
                @Nullable
                private OtherParticipantsModel f1159h;
                @Nullable
                private ThreadKeyModel f1160i;
                private int f1161j;
                @Nullable
                private String f1162k;

                /* compiled from: system_page_load */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m1536a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m1629b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1330462160)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: system_page_load */
                public final class LastMessageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<LastMessageNodesModel> f1147d;

                    /* compiled from: system_page_load */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LastMessageModel.class, new Deserializer());
                        }

                        public Object m1537a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LastMessageParser.m1619a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object lastMessageModel = new LastMessageModel();
                            ((BaseModel) lastMessageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (lastMessageModel instanceof Postprocessable) {
                                return ((Postprocessable) lastMessageModel).a();
                            }
                            return lastMessageModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1656476660)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: system_page_load */
                    public final class LastMessageNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private GraphQLObjectType f1140d;
                        private boolean f1141e;
                        private boolean f1142f;
                        @Nullable
                        private MessageModel f1143g;
                        @Nullable
                        private MessageSenderModel f1144h;
                        @Nullable
                        private GraphQLPageAdminReplyType f1145i;
                        @Nullable
                        private String f1146j;

                        /* compiled from: system_page_load */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(LastMessageNodesModel.class, new Deserializer());
                            }

                            public Object m1538a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(LastMessageNodesParser.m1617b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object lastMessageNodesModel = new LastMessageNodesModel();
                                ((BaseModel) lastMessageNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (lastMessageNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) lastMessageNodesModel).a();
                                }
                                return lastMessageNodesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1352864475)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: system_page_load */
                        public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f1135d;

                            /* compiled from: system_page_load */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                                }

                                public Object m1539a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MessageParser.m1611a(jsonParser, flatBufferBuilder));
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

                            /* compiled from: system_page_load */
                            public class Serializer extends JsonSerializer<MessageModel> {
                                public final void m1540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MessageModel messageModel = (MessageModel) obj;
                                    if (messageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(messageModel.m1542a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MessageParser.m1612a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(MessageModel.class, new Serializer());
                                }
                            }

                            public MessageModel() {
                                super(1);
                            }

                            @Nullable
                            private String m1541a() {
                                this.f1135d = super.a(this.f1135d, 0);
                                return this.f1135d;
                            }

                            public final int jK_() {
                                return -1919764332;
                            }

                            public final GraphQLVisitableModel m1543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m1542a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m1541a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -110476114)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: system_page_load */
                        public final class MessageSenderModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private MessagingActorModel f1139d;

                            /* compiled from: system_page_load */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MessageSenderModel.class, new Deserializer());
                                }

                                public Object m1544a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MessageSenderParser.m1615a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object messageSenderModel = new MessageSenderModel();
                                    ((BaseModel) messageSenderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (messageSenderModel instanceof Postprocessable) {
                                        return ((Postprocessable) messageSenderModel).a();
                                    }
                                    return messageSenderModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = 1255661007)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: system_page_load */
                            public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                                @Nullable
                                private GraphQLObjectType f1136d;
                                @Nullable
                                private String f1137e;
                                @Nullable
                                private String f1138f;

                                /* compiled from: system_page_load */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                                    }

                                    public Object m1545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(MessagingActorParser.m1613a(jsonParser, flatBufferBuilder));
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

                                /* compiled from: system_page_load */
                                public class Serializer extends JsonSerializer<MessagingActorModel> {
                                    public final void m1546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                                        if (messagingActorModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(messagingActorModel.m1550a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        MessagingActorParser.m1614a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator);
                                    }

                                    static {
                                        FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                                    }
                                }

                                public MessagingActorModel() {
                                    super(3);
                                }

                                @Nullable
                                private GraphQLObjectType m1547j() {
                                    if (this.b != null && this.f1136d == null) {
                                        this.f1136d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                    }
                                    return this.f1136d;
                                }

                                @Nullable
                                private String m1548k() {
                                    this.f1137e = super.a(this.f1137e, 1);
                                    return this.f1137e;
                                }

                                @Nullable
                                private String m1549l() {
                                    this.f1138f = super.a(this.f1138f, 2);
                                    return this.f1138f;
                                }

                                @Nullable
                                public final String m1552a() {
                                    return m1548k();
                                }

                                public final int jK_() {
                                    return -1575218831;
                                }

                                public final GraphQLVisitableModel m1551a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    h();
                                    i();
                                    return this;
                                }

                                public final int m1550a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m1547j());
                                    int b = flatBufferBuilder.b(m1548k());
                                    int b2 = flatBufferBuilder.b(m1549l());
                                    flatBufferBuilder.c(3);
                                    flatBufferBuilder.b(0, a);
                                    flatBufferBuilder.b(1, b);
                                    flatBufferBuilder.b(2, b2);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: system_page_load */
                            public class Serializer extends JsonSerializer<MessageSenderModel> {
                                public final void m1553a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MessageSenderModel messageSenderModel = (MessageSenderModel) obj;
                                    if (messageSenderModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(messageSenderModel.m1555a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        messageSenderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MessageSenderParser.m1616a(messageSenderModel.w_(), messageSenderModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(MessageSenderModel.class, new Serializer());
                                }
                            }

                            public MessageSenderModel() {
                                super(1);
                            }

                            @Nullable
                            private MessagingActorModel m1554a() {
                                this.f1139d = (MessagingActorModel) super.a(this.f1139d, 0, MessagingActorModel.class);
                                return this.f1139d;
                            }

                            public final int jK_() {
                                return -1020278353;
                            }

                            public final GraphQLVisitableModel m1556a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m1554a() != null) {
                                    MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m1554a());
                                    if (m1554a() != messagingActorModel) {
                                        graphQLVisitableModel = (MessageSenderModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f1139d = messagingActorModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m1555a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m1554a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: system_page_load */
                        public class Serializer extends JsonSerializer<LastMessageNodesModel> {
                            public final void m1557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                LastMessageNodesModel lastMessageNodesModel = (LastMessageNodesModel) obj;
                                if (lastMessageNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(lastMessageNodesModel.m1563a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    lastMessageNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                LastMessageNodesParser.m1618b(lastMessageNodesModel.w_(), lastMessageNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(LastMessageNodesModel.class, new Serializer());
                            }
                        }

                        public LastMessageNodesModel() {
                            super(7);
                        }

                        @Nullable
                        private GraphQLObjectType m1558a() {
                            if (this.b != null && this.f1140d == null) {
                                this.f1140d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f1140d;
                        }

                        @Nullable
                        private MessageModel m1559j() {
                            this.f1143g = (MessageModel) super.a(this.f1143g, 3, MessageModel.class);
                            return this.f1143g;
                        }

                        @Nullable
                        private MessageSenderModel m1560k() {
                            this.f1144h = (MessageSenderModel) super.a(this.f1144h, 4, MessageSenderModel.class);
                            return this.f1144h;
                        }

                        @Nullable
                        private GraphQLPageAdminReplyType m1561l() {
                            this.f1145i = (GraphQLPageAdminReplyType) super.b(this.f1145i, 5, GraphQLPageAdminReplyType.class, GraphQLPageAdminReplyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                            return this.f1145i;
                        }

                        @Nullable
                        private String m1562m() {
                            this.f1146j = super.a(this.f1146j, 6);
                            return this.f1146j;
                        }

                        public final int jK_() {
                            return -1675388953;
                        }

                        public final GraphQLVisitableModel m1564a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m1559j() != null) {
                                MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m1559j());
                                if (m1559j() != messageModel) {
                                    graphQLVisitableModel = (LastMessageNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1143g = messageModel;
                                }
                            }
                            if (m1560k() != null) {
                                MessageSenderModel messageSenderModel = (MessageSenderModel) graphQLModelMutatingVisitor.b(m1560k());
                                if (m1560k() != messageSenderModel) {
                                    graphQLVisitableModel = (LastMessageNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f1144h = messageSenderModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m1563a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m1558a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m1559j());
                            int a3 = ModelHelper.a(flatBufferBuilder, m1560k());
                            int a4 = flatBufferBuilder.a(m1561l());
                            int b = flatBufferBuilder.b(m1562m());
                            flatBufferBuilder.c(7);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.a(1, this.f1141e);
                            flatBufferBuilder.a(2, this.f1142f);
                            flatBufferBuilder.b(3, a2);
                            flatBufferBuilder.b(4, a3);
                            flatBufferBuilder.b(5, a4);
                            flatBufferBuilder.b(6, b);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m1565a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f1141e = mutableFlatBuffer.a(i, 1);
                            this.f1142f = mutableFlatBuffer.a(i, 2);
                        }
                    }

                    /* compiled from: system_page_load */
                    public class Serializer extends JsonSerializer<LastMessageModel> {
                        public final void m1566a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LastMessageModel lastMessageModel = (LastMessageModel) obj;
                            if (lastMessageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(lastMessageModel.m1568a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                lastMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LastMessageParser.m1620a(lastMessageModel.w_(), lastMessageModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(LastMessageModel.class, new Serializer());
                        }
                    }

                    public LastMessageModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<LastMessageNodesModel> m1567a() {
                        this.f1147d = super.a(this.f1147d, 0, LastMessageNodesModel.class);
                        return (ImmutableList) this.f1147d;
                    }

                    public final int jK_() {
                        return 1801832203;
                    }

                    public final GraphQLVisitableModel m1569a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1567a() != null) {
                            Builder a = ModelHelper.a(m1567a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (LastMessageModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1147d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1568a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1567a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1584886685)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: system_page_load */
                public final class OtherParticipantsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<OtherParticipantsNodesModel> f1152d;

                    /* compiled from: system_page_load */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(OtherParticipantsModel.class, new Deserializer());
                        }

                        public Object m1570a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(OtherParticipantsParser.m1625a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object otherParticipantsModel = new OtherParticipantsModel();
                            ((BaseModel) otherParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (otherParticipantsModel instanceof Postprocessable) {
                                return ((Postprocessable) otherParticipantsModel).a();
                            }
                            return otherParticipantsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1961070588)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: system_page_load */
                    public final class OtherParticipantsNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private MessagingActorModel f1151d;

                        /* compiled from: system_page_load */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(OtherParticipantsNodesModel.class, new Deserializer());
                            }

                            public Object m1571a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(OtherParticipantsNodesParser.m1623b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object otherParticipantsNodesModel = new OtherParticipantsNodesModel();
                                ((BaseModel) otherParticipantsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (otherParticipantsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) otherParticipantsNodesModel).a();
                                }
                                return otherParticipantsNodesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 1255661007)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: system_page_load */
                        public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                            @Nullable
                            private GraphQLObjectType f1148d;
                            @Nullable
                            private String f1149e;
                            @Nullable
                            private String f1150f;

                            /* compiled from: system_page_load */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                                }

                                public Object m1572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(OtherParticipantsNodesParser.MessagingActorParser.m1621a(jsonParser, flatBufferBuilder));
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

                            /* compiled from: system_page_load */
                            public class Serializer extends JsonSerializer<MessagingActorModel> {
                                public final void m1573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                                    if (messagingActorModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(messagingActorModel.m1577a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    OtherParticipantsNodesParser.MessagingActorParser.m1622a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                                }
                            }

                            public MessagingActorModel() {
                                super(3);
                            }

                            @Nullable
                            private GraphQLObjectType m1574j() {
                                if (this.b != null && this.f1148d == null) {
                                    this.f1148d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                }
                                return this.f1148d;
                            }

                            @Nullable
                            private String m1575k() {
                                this.f1149e = super.a(this.f1149e, 1);
                                return this.f1149e;
                            }

                            @Nullable
                            private String m1576l() {
                                this.f1150f = super.a(this.f1150f, 2);
                                return this.f1150f;
                            }

                            @Nullable
                            public final String m1579a() {
                                return m1575k();
                            }

                            public final int jK_() {
                                return -1575218831;
                            }

                            public final GraphQLVisitableModel m1578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m1577a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m1574j());
                                int b = flatBufferBuilder.b(m1575k());
                                int b2 = flatBufferBuilder.b(m1576l());
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, b);
                                flatBufferBuilder.b(2, b2);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: system_page_load */
                        public class Serializer extends JsonSerializer<OtherParticipantsNodesModel> {
                            public final void m1580a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                OtherParticipantsNodesModel otherParticipantsNodesModel = (OtherParticipantsNodesModel) obj;
                                if (otherParticipantsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(otherParticipantsNodesModel.m1582a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    otherParticipantsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                OtherParticipantsNodesParser.m1624b(otherParticipantsNodesModel.w_(), otherParticipantsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(OtherParticipantsNodesModel.class, new Serializer());
                            }
                        }

                        public OtherParticipantsNodesModel() {
                            super(1);
                        }

                        @Nullable
                        private MessagingActorModel m1581a() {
                            this.f1151d = (MessagingActorModel) super.a(this.f1151d, 0, MessagingActorModel.class);
                            return this.f1151d;
                        }

                        public final int jK_() {
                            return -1020278353;
                        }

                        public final GraphQLVisitableModel m1583a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m1581a() != null) {
                                MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m1581a());
                                if (m1581a() != messagingActorModel) {
                                    graphQLVisitableModel = (OtherParticipantsNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1151d = messagingActorModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m1582a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m1581a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: system_page_load */
                    public class Serializer extends JsonSerializer<OtherParticipantsModel> {
                        public final void m1584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) obj;
                            if (otherParticipantsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(otherParticipantsModel.m1586a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                otherParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            OtherParticipantsParser.m1626a(otherParticipantsModel.w_(), otherParticipantsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(OtherParticipantsModel.class, new Serializer());
                        }
                    }

                    public OtherParticipantsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<OtherParticipantsNodesModel> m1585a() {
                        this.f1152d = super.a(this.f1152d, 0, OtherParticipantsNodesModel.class);
                        return (ImmutableList) this.f1152d;
                    }

                    public final int jK_() {
                        return -514756541;
                    }

                    public final GraphQLVisitableModel m1587a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1585a() != null) {
                            Builder a = ModelHelper.a(m1585a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (OtherParticipantsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1152d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1586a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1585a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: system_page_load */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m1588a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m1600a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m1630b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -955914545)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: system_page_load */
                public final class ThreadKeyModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1153d;
                    @Nullable
                    private String f1154e;

                    /* compiled from: system_page_load */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ThreadKeyModel.class, new Deserializer());
                        }

                        public Object m1589a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ThreadKeyParser.m1627a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object threadKeyModel = new ThreadKeyModel();
                            ((BaseModel) threadKeyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (threadKeyModel instanceof Postprocessable) {
                                return ((Postprocessable) threadKeyModel).a();
                            }
                            return threadKeyModel;
                        }
                    }

                    /* compiled from: system_page_load */
                    public class Serializer extends JsonSerializer<ThreadKeyModel> {
                        public final void m1590a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ThreadKeyModel threadKeyModel = (ThreadKeyModel) obj;
                            if (threadKeyModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(threadKeyModel.m1593a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                threadKeyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ThreadKeyParser.m1628a(threadKeyModel.w_(), threadKeyModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ThreadKeyModel.class, new Serializer());
                        }
                    }

                    public ThreadKeyModel() {
                        super(2);
                    }

                    @Nullable
                    private String m1591a() {
                        this.f1153d = super.a(this.f1153d, 0);
                        return this.f1153d;
                    }

                    @Nullable
                    private String m1592j() {
                        this.f1154e = super.a(this.f1154e, 1);
                        return this.f1154e;
                    }

                    public final int jK_() {
                        return 898588622;
                    }

                    public final GraphQLVisitableModel m1594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1593a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m1591a());
                        int b2 = flatBufferBuilder.b(m1592j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public NodesModel() {
                    super(8);
                }

                @Nullable
                private GraphQLMailboxFolder m1595a() {
                    this.f1155d = (GraphQLMailboxFolder) super.b(this.f1155d, 0, GraphQLMailboxFolder.class, GraphQLMailboxFolder.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f1155d;
                }

                @Nullable
                private LastMessageModel m1596j() {
                    this.f1158g = (LastMessageModel) super.a(this.f1158g, 3, LastMessageModel.class);
                    return this.f1158g;
                }

                @Nullable
                private OtherParticipantsModel m1597k() {
                    this.f1159h = (OtherParticipantsModel) super.a(this.f1159h, 4, OtherParticipantsModel.class);
                    return this.f1159h;
                }

                @Nullable
                private ThreadKeyModel m1598l() {
                    this.f1160i = (ThreadKeyModel) super.a(this.f1160i, 5, ThreadKeyModel.class);
                    return this.f1160i;
                }

                @Nullable
                private String m1599m() {
                    this.f1162k = super.a(this.f1162k, 7);
                    return this.f1162k;
                }

                public final int jK_() {
                    return -740570927;
                }

                public final GraphQLVisitableModel m1601a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1596j() != null) {
                        LastMessageModel lastMessageModel = (LastMessageModel) graphQLModelMutatingVisitor.b(m1596j());
                        if (m1596j() != lastMessageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1158g = lastMessageModel;
                        }
                    }
                    if (m1597k() != null) {
                        OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) graphQLModelMutatingVisitor.b(m1597k());
                        if (m1597k() != otherParticipantsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1159h = otherParticipantsModel;
                        }
                    }
                    if (m1598l() != null) {
                        ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(m1598l());
                        if (m1598l() != threadKeyModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1160i = threadKeyModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1600a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m1595a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1596j());
                    int a3 = ModelHelper.a(flatBufferBuilder, m1597k());
                    int a4 = ModelHelper.a(flatBufferBuilder, m1598l());
                    int b = flatBufferBuilder.b(m1599m());
                    flatBufferBuilder.c(8);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f1156e);
                    flatBufferBuilder.a(2, this.f1157f);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, a4);
                    flatBufferBuilder.a(6, this.f1161j, 0);
                    flatBufferBuilder.b(7, b);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m1602a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1156e = mutableFlatBuffer.a(i, 1);
                    this.f1157f = mutableFlatBuffer.a(i, 2);
                    this.f1161j = mutableFlatBuffer.a(i, 6, 0);
                }
            }

            /* compiled from: system_page_load */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m1603a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m1605a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageThreadsParser.m1632a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m1604a() {
                this.f1163d = super.a(this.f1163d, 0, NodesModel.class);
                return (ImmutableList) this.f1163d;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m1606a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1604a() != null) {
                    Builder a = ModelHelper.a(m1604a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1163d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1605a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1604a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: system_page_load */
        public class Serializer extends JsonSerializer<ContactSearchQueryModel> {
            public final void m1607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContactSearchQueryModel contactSearchQueryModel = (ContactSearchQueryModel) obj;
                if (contactSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactSearchQueryModel.m1609a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contactSearchQueryModel.w_();
                int u_ = contactSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MessageThreadsParser.m1632a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContactSearchQueryModel.class, new Serializer());
            }
        }

        public ContactSearchQueryModel() {
            super(1);
        }

        @Nullable
        private MessageThreadsModel m1608a() {
            this.f1164d = (MessageThreadsModel) super.a(this.f1164d, 0, MessageThreadsModel.class);
            return this.f1164d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1608a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m1608a());
                if (m1608a() != messageThreadsModel) {
                    graphQLVisitableModel = (ContactSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1164d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1609a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1608a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
