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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser.MatchedMessagesParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser.NodeParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser.NodeParser.OtherParticipantsParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser.NodeParser.OtherParticipantsParser.OtherParticipantsEdgesParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser.NodeParser.OtherParticipantsParser.OtherParticipantsEdgesParser.OtherParticipantsEdgesNodeParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser.NodeParser.OtherParticipantsParser.OtherParticipantsEdgesParser.OtherParticipantsEdgesNodeParser.MessagingActorParser;
import com.facebook.pages.app.data.protocol.methods.graphql.MessageContentSearchParsers.MessageContentSearchQueryParser.MessageThreadsParser.EdgesParser.NodeParser.ThreadKeyParser;
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

/* compiled from: survey_statement */
public class MessageContentSearchModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 59713680)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: survey_statement */
    public final class MessageContentSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f1207d;

        /* compiled from: survey_statement */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageContentSearchQueryModel.class, new Deserializer());
            }

            public Object m1709a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessageContentSearchQueryParser.m1787a(jsonParser);
                Object messageContentSearchQueryModel = new MessageContentSearchQueryModel();
                ((BaseModel) messageContentSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messageContentSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) messageContentSearchQueryModel).a();
                }
                return messageContentSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1378465336)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: survey_statement */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f1206d;

            /* compiled from: survey_statement */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m1710a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageThreadsParser.m1785a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -1923816331)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: survey_statement */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<MatchedMessagesModel> f1204d;
                @Nullable
                private NodeModel f1205e;

                /* compiled from: survey_statement */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m1711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m1783b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 2040686452)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: survey_statement */
                public final class MatchedMessagesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f1189d;
                    @Nullable
                    private String f1190e;
                    @Nullable
                    private String f1191f;

                    /* compiled from: survey_statement */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MatchedMessagesModel.class, new Deserializer());
                        }

                        public Object m1712a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MatchedMessagesParser.m1770b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object matchedMessagesModel = new MatchedMessagesModel();
                            ((BaseModel) matchedMessagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (matchedMessagesModel instanceof Postprocessable) {
                                return ((Postprocessable) matchedMessagesModel).a();
                            }
                            return matchedMessagesModel;
                        }
                    }

                    /* compiled from: survey_statement */
                    public class Serializer extends JsonSerializer<MatchedMessagesModel> {
                        public final void m1713a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MatchedMessagesModel matchedMessagesModel = (MatchedMessagesModel) obj;
                            if (matchedMessagesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(matchedMessagesModel.m1717a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                matchedMessagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MatchedMessagesParser.m1769a(matchedMessagesModel.w_(), matchedMessagesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(MatchedMessagesModel.class, new Serializer());
                        }
                    }

                    public MatchedMessagesModel() {
                        super(3);
                    }

                    @Nullable
                    private GraphQLObjectType m1714a() {
                        if (this.b != null && this.f1189d == null) {
                            this.f1189d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f1189d;
                    }

                    @Nullable
                    private String m1715j() {
                        this.f1190e = super.a(this.f1190e, 1);
                        return this.f1190e;
                    }

                    @Nullable
                    private String m1716k() {
                        this.f1191f = super.a(this.f1191f, 2);
                        return this.f1191f;
                    }

                    public final int jK_() {
                        return -1675388953;
                    }

                    public final GraphQLVisitableModel m1718a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1717a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1714a());
                        int b = flatBufferBuilder.b(m1715j());
                        int b2 = flatBufferBuilder.b(m1716k());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -49170719)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: survey_statement */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private OtherParticipantsModel f1200d;
                    @Nullable
                    private ThreadKeyModel f1201e;
                    private int f1202f;
                    @Nullable
                    private String f1203g;

                    /* compiled from: survey_statement */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m1719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m1781a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 755286100)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: survey_statement */
                    public final class OtherParticipantsModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<OtherParticipantsEdgesModel> f1197d;

                        /* compiled from: survey_statement */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(OtherParticipantsModel.class, new Deserializer());
                            }

                            public Object m1720a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(OtherParticipantsParser.m1777a(jsonParser, flatBufferBuilder));
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
                        @ModelWithFlatBufferFormatHash(a = -1187025136)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: survey_statement */
                        public final class OtherParticipantsEdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private OtherParticipantsEdgesNodeModel f1196d;

                            /* compiled from: survey_statement */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(OtherParticipantsEdgesModel.class, new Deserializer());
                                }

                                public Object m1721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(OtherParticipantsEdgesParser.m1775b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object otherParticipantsEdgesModel = new OtherParticipantsEdgesModel();
                                    ((BaseModel) otherParticipantsEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (otherParticipantsEdgesModel instanceof Postprocessable) {
                                        return ((Postprocessable) otherParticipantsEdgesModel).a();
                                    }
                                    return otherParticipantsEdgesModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = 2139029491)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: survey_statement */
                            public final class OtherParticipantsEdgesNodeModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private MessagingActorModel f1195d;

                                /* compiled from: survey_statement */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(OtherParticipantsEdgesNodeModel.class, new Deserializer());
                                    }

                                    public Object m1722a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(OtherParticipantsEdgesNodeParser.m1773a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object otherParticipantsEdgesNodeModel = new OtherParticipantsEdgesNodeModel();
                                        ((BaseModel) otherParticipantsEdgesNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (otherParticipantsEdgesNodeModel instanceof Postprocessable) {
                                            return ((Postprocessable) otherParticipantsEdgesNodeModel).a();
                                        }
                                        return otherParticipantsEdgesNodeModel;
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = 1255661007)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: survey_statement */
                                public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                                    @Nullable
                                    private GraphQLObjectType f1192d;
                                    @Nullable
                                    private String f1193e;
                                    @Nullable
                                    private String f1194f;

                                    /* compiled from: survey_statement */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                                        }

                                        public Object m1723a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(MessagingActorParser.m1771a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: survey_statement */
                                    public class Serializer extends JsonSerializer<MessagingActorModel> {
                                        public final void m1724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                                            if (messagingActorModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(messagingActorModel.m1728a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            MessagingActorParser.m1772a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                                        }
                                    }

                                    public MessagingActorModel() {
                                        super(3);
                                    }

                                    @Nullable
                                    private GraphQLObjectType m1725j() {
                                        if (this.b != null && this.f1192d == null) {
                                            this.f1192d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                        }
                                        return this.f1192d;
                                    }

                                    @Nullable
                                    private String m1726k() {
                                        this.f1193e = super.a(this.f1193e, 1);
                                        return this.f1193e;
                                    }

                                    @Nullable
                                    private String m1727l() {
                                        this.f1194f = super.a(this.f1194f, 2);
                                        return this.f1194f;
                                    }

                                    @Nullable
                                    public final String m1730a() {
                                        return m1726k();
                                    }

                                    public final int jK_() {
                                        return -1575218831;
                                    }

                                    public final GraphQLVisitableModel m1729a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m1728a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int a = ModelHelper.a(flatBufferBuilder, m1725j());
                                        int b = flatBufferBuilder.b(m1726k());
                                        int b2 = flatBufferBuilder.b(m1727l());
                                        flatBufferBuilder.c(3);
                                        flatBufferBuilder.b(0, a);
                                        flatBufferBuilder.b(1, b);
                                        flatBufferBuilder.b(2, b2);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: survey_statement */
                                public class Serializer extends JsonSerializer<OtherParticipantsEdgesNodeModel> {
                                    public final void m1731a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        OtherParticipantsEdgesNodeModel otherParticipantsEdgesNodeModel = (OtherParticipantsEdgesNodeModel) obj;
                                        if (otherParticipantsEdgesNodeModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(otherParticipantsEdgesNodeModel.m1733a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            otherParticipantsEdgesNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        OtherParticipantsEdgesNodeParser.m1774a(otherParticipantsEdgesNodeModel.w_(), otherParticipantsEdgesNodeModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(OtherParticipantsEdgesNodeModel.class, new Serializer());
                                    }
                                }

                                public OtherParticipantsEdgesNodeModel() {
                                    super(1);
                                }

                                @Nullable
                                private MessagingActorModel m1732a() {
                                    this.f1195d = (MessagingActorModel) super.a(this.f1195d, 0, MessagingActorModel.class);
                                    return this.f1195d;
                                }

                                public final int jK_() {
                                    return -1020278353;
                                }

                                public final GraphQLVisitableModel m1734a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m1732a() != null) {
                                        MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m1732a());
                                        if (m1732a() != messagingActorModel) {
                                            graphQLVisitableModel = (OtherParticipantsEdgesNodeModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f1195d = messagingActorModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m1733a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m1732a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, a);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: survey_statement */
                            public class Serializer extends JsonSerializer<OtherParticipantsEdgesModel> {
                                public final void m1735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    OtherParticipantsEdgesModel otherParticipantsEdgesModel = (OtherParticipantsEdgesModel) obj;
                                    if (otherParticipantsEdgesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(otherParticipantsEdgesModel.m1737a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        otherParticipantsEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    OtherParticipantsEdgesParser.m1776b(otherParticipantsEdgesModel.w_(), otherParticipantsEdgesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(OtherParticipantsEdgesModel.class, new Serializer());
                                }
                            }

                            public OtherParticipantsEdgesModel() {
                                super(1);
                            }

                            @Nullable
                            private OtherParticipantsEdgesNodeModel m1736a() {
                                this.f1196d = (OtherParticipantsEdgesNodeModel) super.a(this.f1196d, 0, OtherParticipantsEdgesNodeModel.class);
                                return this.f1196d;
                            }

                            public final int jK_() {
                                return -1290629406;
                            }

                            public final GraphQLVisitableModel m1738a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m1736a() != null) {
                                    OtherParticipantsEdgesNodeModel otherParticipantsEdgesNodeModel = (OtherParticipantsEdgesNodeModel) graphQLModelMutatingVisitor.b(m1736a());
                                    if (m1736a() != otherParticipantsEdgesNodeModel) {
                                        graphQLVisitableModel = (OtherParticipantsEdgesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f1196d = otherParticipantsEdgesNodeModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m1737a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m1736a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: survey_statement */
                        public class Serializer extends JsonSerializer<OtherParticipantsModel> {
                            public final void m1739a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) obj;
                                if (otherParticipantsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(otherParticipantsModel.m1741a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    otherParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                OtherParticipantsParser.m1778a(otherParticipantsModel.w_(), otherParticipantsModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(OtherParticipantsModel.class, new Serializer());
                            }
                        }

                        public OtherParticipantsModel() {
                            super(1);
                        }

                        @Nonnull
                        private ImmutableList<OtherParticipantsEdgesModel> m1740a() {
                            this.f1197d = super.a(this.f1197d, 0, OtherParticipantsEdgesModel.class);
                            return (ImmutableList) this.f1197d;
                        }

                        public final int jK_() {
                            return -514756541;
                        }

                        public final GraphQLVisitableModel m1742a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m1740a() != null) {
                                Builder a = ModelHelper.a(m1740a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (OtherParticipantsModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1197d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m1741a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m1740a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: survey_statement */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m1743a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m1753a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m1782a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -955914545)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: survey_statement */
                    public final class ThreadKeyModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f1198d;
                        @Nullable
                        private String f1199e;

                        /* compiled from: survey_statement */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ThreadKeyModel.class, new Deserializer());
                            }

                            public Object m1744a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ThreadKeyParser.m1779a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: survey_statement */
                        public class Serializer extends JsonSerializer<ThreadKeyModel> {
                            public final void m1745a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ThreadKeyModel threadKeyModel = (ThreadKeyModel) obj;
                                if (threadKeyModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(threadKeyModel.m1748a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    threadKeyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ThreadKeyParser.m1780a(threadKeyModel.w_(), threadKeyModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ThreadKeyModel.class, new Serializer());
                            }
                        }

                        public ThreadKeyModel() {
                            super(2);
                        }

                        @Nullable
                        private String m1746a() {
                            this.f1198d = super.a(this.f1198d, 0);
                            return this.f1198d;
                        }

                        @Nullable
                        private String m1747j() {
                            this.f1199e = super.a(this.f1199e, 1);
                            return this.f1199e;
                        }

                        public final int jK_() {
                            return 898588622;
                        }

                        public final GraphQLVisitableModel m1749a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m1748a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m1746a());
                            int b2 = flatBufferBuilder.b(m1747j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.b(1, b2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public NodeModel() {
                        super(4);
                    }

                    @Nullable
                    private OtherParticipantsModel m1750a() {
                        this.f1200d = (OtherParticipantsModel) super.a(this.f1200d, 0, OtherParticipantsModel.class);
                        return this.f1200d;
                    }

                    @Nullable
                    private ThreadKeyModel m1751j() {
                        this.f1201e = (ThreadKeyModel) super.a(this.f1201e, 1, ThreadKeyModel.class);
                        return this.f1201e;
                    }

                    @Nullable
                    private String m1752k() {
                        this.f1203g = super.a(this.f1203g, 3);
                        return this.f1203g;
                    }

                    public final int jK_() {
                        return -740570927;
                    }

                    public final GraphQLVisitableModel m1754a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1750a() != null) {
                            OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) graphQLModelMutatingVisitor.b(m1750a());
                            if (m1750a() != otherParticipantsModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1200d = otherParticipantsModel;
                            }
                        }
                        if (m1751j() != null) {
                            ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(m1751j());
                            if (m1751j() != threadKeyModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f1201e = threadKeyModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1753a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1750a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m1751j());
                        int b = flatBufferBuilder.b(m1752k());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.a(2, this.f1202f, 0);
                        flatBufferBuilder.b(3, b);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m1755a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f1202f = mutableFlatBuffer.a(i, 2, 0);
                    }
                }

                /* compiled from: survey_statement */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m1756a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m1759a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m1784b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<MatchedMessagesModel> m1757a() {
                    this.f1204d = super.a(this.f1204d, 0, MatchedMessagesModel.class);
                    return (ImmutableList) this.f1204d;
                }

                @Nullable
                private NodeModel m1758j() {
                    this.f1205e = (NodeModel) super.a(this.f1205e, 1, NodeModel.class);
                    return this.f1205e;
                }

                public final int jK_() {
                    return 248461393;
                }

                public final GraphQLVisitableModel m1760a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    NodeModel nodeModel;
                    h();
                    if (m1757a() != null) {
                        Builder a = ModelHelper.a(m1757a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            EdgesModel edgesModel = (EdgesModel) ModelHelper.a(null, this);
                            edgesModel.f1204d = a.b();
                            graphQLVisitableModel = edgesModel;
                            if (m1758j() != null) {
                                nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m1758j());
                                if (m1758j() != nodeModel) {
                                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f1205e = nodeModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m1758j() != null) {
                        nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m1758j());
                        if (m1758j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1205e = nodeModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m1759a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1757a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1758j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: survey_statement */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m1761a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m1763a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageThreadsParser.m1786a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m1762a() {
                this.f1206d = super.a(this.f1206d, 0, EdgesModel.class);
                return (ImmutableList) this.f1206d;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m1764a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1762a() != null) {
                    Builder a = ModelHelper.a(m1762a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1206d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1763a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1762a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: survey_statement */
        public class Serializer extends JsonSerializer<MessageContentSearchQueryModel> {
            public final void m1765a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessageContentSearchQueryModel messageContentSearchQueryModel = (MessageContentSearchQueryModel) obj;
                if (messageContentSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageContentSearchQueryModel.m1767a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageContentSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messageContentSearchQueryModel.w_();
                int u_ = messageContentSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MessageThreadsParser.m1786a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessageContentSearchQueryModel.class, new Serializer());
            }
        }

        public MessageContentSearchQueryModel() {
            super(1);
        }

        @Nullable
        private MessageThreadsModel m1766a() {
            this.f1207d = (MessageThreadsModel) super.a(this.f1207d, 0, MessageThreadsModel.class);
            return this.f1207d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1768a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1766a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m1766a());
                if (m1766a() != messageThreadsModel) {
                    graphQLVisitableModel = (MessageContentSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1207d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1767a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1766a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
