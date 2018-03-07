package com.facebook.messaging.users.refresh.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesParsers.UsersAfterTimeQueryParser;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesParsers.UsersAfterTimeQueryParser.MessageThreadsParser;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesParsers.UsersAfterTimeQueryParser.MessageThreadsParser.NodesParser;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesParsers.UsersAfterTimeQueryParser.MessageThreadsParser.NodesParser.FormerParticipantsParser;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesParsers.UsersAfterTimeQueryParser.MessageThreadsParser.NodesParser.FormerParticipantsParser.FormerParticipantsNodesParser;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesParsers.UsersAfterTimeQueryParser.MessageThreadsParser.NodesParser.OtherParticipantsParser;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesParsers.UsersAfterTimeQueryParser.MessageThreadsParser.NodesParser.OtherParticipantsParser.OtherParticipantsNodesParser;
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

/* compiled from: chat_head_duration */
public class MostRecentConversationUserQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1987543311)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: chat_head_duration */
    public final class UsersAfterTimeQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f18339d;

        /* compiled from: chat_head_duration */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UsersAfterTimeQueryModel.class, new Deserializer());
            }

            public Object m18282a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UsersAfterTimeQueryParser.m18333a(jsonParser);
                Object usersAfterTimeQueryModel = new UsersAfterTimeQueryModel();
                ((BaseModel) usersAfterTimeQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (usersAfterTimeQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) usersAfterTimeQueryModel).a();
                }
                return usersAfterTimeQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1333107697)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: chat_head_duration */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f18338d;

            /* compiled from: chat_head_duration */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m18283a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageThreadsParser.m18331a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 612937673)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: chat_head_duration */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FormerParticipantsModel f18335d;
                @Nullable
                private OtherParticipantsModel f18336e;
                @Nullable
                private String f18337f;

                /* compiled from: chat_head_duration */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m18284a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m18329b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -583027391)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: chat_head_duration */
                public final class FormerParticipantsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<FormerParticipantsNodesModel> f18332d;

                    /* compiled from: chat_head_duration */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(FormerParticipantsModel.class, new Deserializer());
                        }

                        public Object m18285a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FormerParticipantsParser.m18323a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object formerParticipantsModel = new FormerParticipantsModel();
                            ((BaseModel) formerParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (formerParticipantsModel instanceof Postprocessable) {
                                return ((Postprocessable) formerParticipantsModel).a();
                            }
                            return formerParticipantsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: chat_head_duration */
                    public final class FormerParticipantsNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f18331d;

                        /* compiled from: chat_head_duration */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(FormerParticipantsNodesModel.class, new Deserializer());
                            }

                            public Object m18286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(FormerParticipantsNodesParser.m18322b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object formerParticipantsNodesModel = new FormerParticipantsNodesModel();
                                ((BaseModel) formerParticipantsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (formerParticipantsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) formerParticipantsNodesModel).a();
                                }
                                return formerParticipantsNodesModel;
                            }
                        }

                        /* compiled from: chat_head_duration */
                        public class Serializer extends JsonSerializer<FormerParticipantsNodesModel> {
                            public final void m18287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                FormerParticipantsNodesModel formerParticipantsNodesModel = (FormerParticipantsNodesModel) obj;
                                if (formerParticipantsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(formerParticipantsNodesModel.m18289a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    formerParticipantsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                FormerParticipantsNodesParser.m18321a(formerParticipantsNodesModel.w_(), formerParticipantsNodesModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(FormerParticipantsNodesModel.class, new Serializer());
                            }
                        }

                        public FormerParticipantsNodesModel() {
                            super(1);
                        }

                        @Nullable
                        private String m18288j() {
                            this.f18331d = super.a(this.f18331d, 0);
                            return this.f18331d;
                        }

                        @Nullable
                        public final String m18291a() {
                            return m18288j();
                        }

                        public final int jK_() {
                            return -1020278353;
                        }

                        public final GraphQLVisitableModel m18290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m18289a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m18288j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: chat_head_duration */
                    public class Serializer extends JsonSerializer<FormerParticipantsModel> {
                        public final void m18292a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            FormerParticipantsModel formerParticipantsModel = (FormerParticipantsModel) obj;
                            if (formerParticipantsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(formerParticipantsModel.m18294a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                formerParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FormerParticipantsParser.m18324a(formerParticipantsModel.w_(), formerParticipantsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(FormerParticipantsModel.class, new Serializer());
                        }
                    }

                    public FormerParticipantsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<FormerParticipantsNodesModel> m18293a() {
                        this.f18332d = super.a(this.f18332d, 0, FormerParticipantsNodesModel.class);
                        return (ImmutableList) this.f18332d;
                    }

                    public final int jK_() {
                        return 831093394;
                    }

                    public final GraphQLVisitableModel m18295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m18293a() != null) {
                            Builder a = ModelHelper.a(m18293a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (FormerParticipantsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f18332d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m18294a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m18293a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1520240461)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: chat_head_duration */
                public final class OtherParticipantsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<OtherParticipantsNodesModel> f18334d;

                    /* compiled from: chat_head_duration */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(OtherParticipantsModel.class, new Deserializer());
                        }

                        public Object m18296a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(OtherParticipantsParser.m18327a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: chat_head_duration */
                    public final class OtherParticipantsNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f18333d;

                        /* compiled from: chat_head_duration */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(OtherParticipantsNodesModel.class, new Deserializer());
                            }

                            public Object m18297a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(OtherParticipantsNodesParser.m18326b(jsonParser, flatBufferBuilder));
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

                        /* compiled from: chat_head_duration */
                        public class Serializer extends JsonSerializer<OtherParticipantsNodesModel> {
                            public final void m18298a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                OtherParticipantsNodesModel otherParticipantsNodesModel = (OtherParticipantsNodesModel) obj;
                                if (otherParticipantsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(otherParticipantsNodesModel.m18300a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    otherParticipantsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                OtherParticipantsNodesParser.m18325a(otherParticipantsNodesModel.w_(), otherParticipantsNodesModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(OtherParticipantsNodesModel.class, new Serializer());
                            }
                        }

                        public OtherParticipantsNodesModel() {
                            super(1);
                        }

                        @Nullable
                        private String m18299j() {
                            this.f18333d = super.a(this.f18333d, 0);
                            return this.f18333d;
                        }

                        @Nullable
                        public final String m18302a() {
                            return m18299j();
                        }

                        public final int jK_() {
                            return -1020278353;
                        }

                        public final GraphQLVisitableModel m18301a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m18300a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m18299j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: chat_head_duration */
                    public class Serializer extends JsonSerializer<OtherParticipantsModel> {
                        public final void m18303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) obj;
                            if (otherParticipantsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(otherParticipantsModel.m18305a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                otherParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            OtherParticipantsParser.m18328a(otherParticipantsModel.w_(), otherParticipantsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(OtherParticipantsModel.class, new Serializer());
                        }
                    }

                    public OtherParticipantsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<OtherParticipantsNodesModel> m18304a() {
                        this.f18334d = super.a(this.f18334d, 0, OtherParticipantsNodesModel.class);
                        return (ImmutableList) this.f18334d;
                    }

                    public final int jK_() {
                        return -514756541;
                    }

                    public final GraphQLVisitableModel m18306a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m18304a() != null) {
                            Builder a = ModelHelper.a(m18304a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (OtherParticipantsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f18334d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m18305a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m18304a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: chat_head_duration */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m18307a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m18310a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m18330b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                @Nullable
                private FormerParticipantsModel m18308j() {
                    this.f18335d = (FormerParticipantsModel) super.a(this.f18335d, 0, FormerParticipantsModel.class);
                    return this.f18335d;
                }

                @Nullable
                private OtherParticipantsModel m18309k() {
                    this.f18336e = (OtherParticipantsModel) super.a(this.f18336e, 1, OtherParticipantsModel.class);
                    return this.f18336e;
                }

                @Nullable
                public final String m18312a() {
                    this.f18337f = super.a(this.f18337f, 2);
                    return this.f18337f;
                }

                public final int jK_() {
                    return -740570927;
                }

                public final GraphQLVisitableModel m18311a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18308j() != null) {
                        FormerParticipantsModel formerParticipantsModel = (FormerParticipantsModel) graphQLModelMutatingVisitor.b(m18308j());
                        if (m18308j() != formerParticipantsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f18335d = formerParticipantsModel;
                        }
                    }
                    if (m18309k() != null) {
                        OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) graphQLModelMutatingVisitor.b(m18309k());
                        if (m18309k() != otherParticipantsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f18336e = otherParticipantsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18310a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18308j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m18309k());
                    int b = flatBufferBuilder.b(m18312a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: chat_head_duration */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m18313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m18314a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageThreadsParser.m18332a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m18316a() {
                this.f18338d = super.a(this.f18338d, 0, NodesModel.class);
                return (ImmutableList) this.f18338d;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m18315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18316a() != null) {
                    Builder a = ModelHelper.a(m18316a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f18338d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18314a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18316a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: chat_head_duration */
        public class Serializer extends JsonSerializer<UsersAfterTimeQueryModel> {
            public final void m18317a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UsersAfterTimeQueryModel usersAfterTimeQueryModel = (UsersAfterTimeQueryModel) obj;
                if (usersAfterTimeQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(usersAfterTimeQueryModel.m18318a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    usersAfterTimeQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = usersAfterTimeQueryModel.w_();
                int u_ = usersAfterTimeQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MessageThreadsParser.m18332a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UsersAfterTimeQueryModel.class, new Serializer());
            }
        }

        public UsersAfterTimeQueryModel() {
            super(1);
        }

        @Nullable
        public final MessageThreadsModel m18320a() {
            this.f18339d = (MessageThreadsModel) super.a(this.f18339d, 0, MessageThreadsModel.class);
            return this.f18339d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m18319a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18320a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m18320a());
                if (m18320a() != messageThreadsModel) {
                    graphQLVisitableModel = (UsersAfterTimeQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18339d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18318a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18320a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
