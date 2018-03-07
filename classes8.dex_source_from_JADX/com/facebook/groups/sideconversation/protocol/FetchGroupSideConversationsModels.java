package com.facebook.groups.sideconversation.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.AllParticipantsParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.AllParticipantsParser.EdgesParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.AllParticipantsParser.EdgesParser.NodeParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.AllParticipantsParser.EdgesParser.NodeParser.MessagingActorParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.AllParticipantsParser.EdgesParser.NodeParser.MessagingActorParser.ProfilePictureParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.ImageParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.MessagesParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.MessagesParser.EdgesParser.NodeParser.MessageParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.MessagesParser.EdgesParser.NodeParser.MessageSenderParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.NodesParser.ThreadKeyParser;
import com.facebook.groups.sideconversation.protocol.FetchGroupSideConversationsParsers.FetchGroupSideConversationsParser.GroupAssociatedMessageThreadsParser.PageInfoParser;
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

/* compiled from: end_session_candidate_results */
public class FetchGroupSideConversationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1679990011)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: end_session_candidate_results */
    public final class FetchGroupSideConversationsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GroupAssociatedMessageThreadsModel f14837d;
        @Nullable
        private GraphQLGroupJoinState f14838e;
        @Nullable
        private GraphQLGroupPostStatus f14839f;
        @Nullable
        private GraphQLGroupVisibility f14840g;

        /* compiled from: end_session_candidate_results */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupSideConversationsModel.class, new Deserializer());
            }

            public Object m17171a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupSideConversationsParser.m17312a(jsonParser);
                Object fetchGroupSideConversationsModel = new FetchGroupSideConversationsModel();
                ((BaseModel) fetchGroupSideConversationsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupSideConversationsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupSideConversationsModel).a();
                }
                return fetchGroupSideConversationsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -382514866)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: end_session_candidate_results */
        public final class GroupAssociatedMessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f14835d;
            @Nullable
            private PageInfoModel f14836e;

            /* compiled from: end_session_candidate_results */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupAssociatedMessageThreadsModel.class, new Deserializer());
                }

                public Object m17172a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupAssociatedMessageThreadsParser.m17310a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupAssociatedMessageThreadsModel = new GroupAssociatedMessageThreadsModel();
                    ((BaseModel) groupAssociatedMessageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupAssociatedMessageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) groupAssociatedMessageThreadsModel).a();
                    }
                    return groupAssociatedMessageThreadsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 921928818)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: end_session_candidate_results */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private AllParticipantsModel f14827d;
                @Nullable
                private ImageModel f14828e;
                @Nullable
                private MessagesModel f14829f;
                @Nullable
                private String f14830g;
                @Nullable
                private ThreadKeyModel f14831h;
                @Nullable
                private String f14832i;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 782308766)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: end_session_candidate_results */
                public final class AllParticipantsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<EdgesModel> f14812d;

                    /* compiled from: end_session_candidate_results */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(AllParticipantsModel.class, new Deserializer());
                        }

                        public Object m17173a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(AllParticipantsParser.m17288a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object allParticipantsModel = new AllParticipantsModel();
                            ((BaseModel) allParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (allParticipantsModel instanceof Postprocessable) {
                                return ((Postprocessable) allParticipantsModel).a();
                            }
                            return allParticipantsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 952984780)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: end_session_candidate_results */
                    public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private NodeModel f14811d;

                        /* compiled from: end_session_candidate_results */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                            }

                            public Object m17174a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(EdgesParser.m17286b(jsonParser, flatBufferBuilder));
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
                        @ModelWithFlatBufferFormatHash(a = 297392719)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: end_session_candidate_results */
                        public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private MessagingActorModel f14810d;

                            /* compiled from: end_session_candidate_results */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                                }

                                public Object m17175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(NodeParser.m17284a(jsonParser, flatBufferBuilder));
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
                            @ModelWithFlatBufferFormatHash(a = 1571200232)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: end_session_candidate_results */
                            public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                                @Nullable
                                private GraphQLObjectType f14807d;
                                @Nullable
                                private String f14808e;
                                @Nullable
                                private ProfilePictureModel f14809f;

                                /* compiled from: end_session_candidate_results */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                                    }

                                    public Object m17176a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(MessagingActorParser.m17282a(jsonParser, flatBufferBuilder));
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

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = 842551240)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: end_session_candidate_results */
                                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f14806d;

                                    /* compiled from: end_session_candidate_results */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                                        }

                                        public Object m17177a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(ProfilePictureParser.m17280a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object profilePictureModel = new ProfilePictureModel();
                                            ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (profilePictureModel instanceof Postprocessable) {
                                                return ((Postprocessable) profilePictureModel).a();
                                            }
                                            return profilePictureModel;
                                        }
                                    }

                                    /* compiled from: end_session_candidate_results */
                                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                                        public final void m17178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                                            if (profilePictureModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(profilePictureModel.m17180a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            ProfilePictureParser.m17281a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                                        }
                                    }

                                    public ProfilePictureModel() {
                                        super(1);
                                    }

                                    @Nullable
                                    private String m17179a() {
                                        this.f14806d = super.a(this.f14806d, 0);
                                        return this.f14806d;
                                    }

                                    public final int jK_() {
                                        return 70760763;
                                    }

                                    public final GraphQLVisitableModel m17181a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m17180a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m17179a());
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.b(0, b);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: end_session_candidate_results */
                                public class Serializer extends JsonSerializer<MessagingActorModel> {
                                    public final void m17182a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                                        if (messagingActorModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(messagingActorModel.m17186a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        MessagingActorParser.m17283a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                                    }
                                }

                                public MessagingActorModel() {
                                    super(3);
                                }

                                @Nullable
                                private GraphQLObjectType m17183j() {
                                    if (this.b != null && this.f14807d == null) {
                                        this.f14807d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                    }
                                    return this.f14807d;
                                }

                                @Nullable
                                private String m17184k() {
                                    this.f14808e = super.a(this.f14808e, 1);
                                    return this.f14808e;
                                }

                                @Nullable
                                private ProfilePictureModel m17185l() {
                                    this.f14809f = (ProfilePictureModel) super.a(this.f14809f, 2, ProfilePictureModel.class);
                                    return this.f14809f;
                                }

                                @Nullable
                                public final String m17188a() {
                                    return m17184k();
                                }

                                public final int jK_() {
                                    return -1575218831;
                                }

                                public final GraphQLVisitableModel m17187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m17185l() != null) {
                                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m17185l());
                                        if (m17185l() != profilePictureModel) {
                                            graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f14809f = profilePictureModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m17186a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m17183j());
                                    int b = flatBufferBuilder.b(m17184k());
                                    int a2 = ModelHelper.a(flatBufferBuilder, m17185l());
                                    flatBufferBuilder.c(3);
                                    flatBufferBuilder.b(0, a);
                                    flatBufferBuilder.b(1, b);
                                    flatBufferBuilder.b(2, a2);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: end_session_candidate_results */
                            public class Serializer extends JsonSerializer<NodeModel> {
                                public final void m17189a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    NodeModel nodeModel = (NodeModel) obj;
                                    if (nodeModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(nodeModel.m17191a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    NodeParser.m17285a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                                }
                            }

                            public NodeModel() {
                                super(1);
                            }

                            @Nullable
                            private MessagingActorModel m17190a() {
                                this.f14810d = (MessagingActorModel) super.a(this.f14810d, 0, MessagingActorModel.class);
                                return this.f14810d;
                            }

                            public final int jK_() {
                                return -1020278353;
                            }

                            public final GraphQLVisitableModel m17192a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m17190a() != null) {
                                    MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m17190a());
                                    if (m17190a() != messagingActorModel) {
                                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f14810d = messagingActorModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m17191a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m17190a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: end_session_candidate_results */
                        public class Serializer extends JsonSerializer<EdgesModel> {
                            public final void m17193a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EdgesModel edgesModel = (EdgesModel) obj;
                                if (edgesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(edgesModel.m17195a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                EdgesParser.m17287b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(EdgesModel.class, new Serializer());
                            }
                        }

                        public EdgesModel() {
                            super(1);
                        }

                        @Nullable
                        private NodeModel m17194a() {
                            this.f14811d = (NodeModel) super.a(this.f14811d, 0, NodeModel.class);
                            return this.f14811d;
                        }

                        public final int jK_() {
                            return 1677164929;
                        }

                        public final GraphQLVisitableModel m17196a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m17194a() != null) {
                                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m17194a());
                                if (m17194a() != nodeModel) {
                                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f14811d = nodeModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m17195a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m17194a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: end_session_candidate_results */
                    public class Serializer extends JsonSerializer<AllParticipantsModel> {
                        public final void m17197a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            AllParticipantsModel allParticipantsModel = (AllParticipantsModel) obj;
                            if (allParticipantsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(allParticipantsModel.m17199a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                allParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            AllParticipantsParser.m17289a(allParticipantsModel.w_(), allParticipantsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(AllParticipantsModel.class, new Serializer());
                        }
                    }

                    public AllParticipantsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<EdgesModel> m17198a() {
                        this.f14812d = super.a(this.f14812d, 0, EdgesModel.class);
                        return (ImmutableList) this.f14812d;
                    }

                    public final int jK_() {
                        return -700993630;
                    }

                    public final GraphQLVisitableModel m17200a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m17198a() != null) {
                            Builder a = ModelHelper.a(m17198a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (AllParticipantsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f14812d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m17199a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m17198a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: end_session_candidate_results */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17201a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m17306b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: end_session_candidate_results */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f14813d;

                    /* compiled from: end_session_candidate_results */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m17202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m17290a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object imageModel = new ImageModel();
                            ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (imageModel instanceof Postprocessable) {
                                return ((Postprocessable) imageModel).a();
                            }
                            return imageModel;
                        }
                    }

                    /* compiled from: end_session_candidate_results */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m17203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m17205a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m17291a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m17204a() {
                        this.f14813d = super.a(this.f14813d, 0);
                        return this.f14813d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m17206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17205a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17204a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1025839634)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: end_session_candidate_results */
                public final class MessagesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<EdgesModel> f14825d;

                    /* compiled from: end_session_candidate_results */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MessagesModel.class, new Deserializer());
                        }

                        public Object m17207a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MessagesParser.m17302a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object messagesModel = new MessagesModel();
                            ((BaseModel) messagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (messagesModel instanceof Postprocessable) {
                                return ((Postprocessable) messagesModel).a();
                            }
                            return messagesModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 808843403)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: end_session_candidate_results */
                    public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private NodeModel f14824d;

                        /* compiled from: end_session_candidate_results */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                            }

                            public Object m17208a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(MessagesParser.EdgesParser.m17300b(jsonParser, flatBufferBuilder));
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
                        @ModelWithFlatBufferFormatHash(a = 70111625)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: end_session_candidate_results */
                        public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private GraphQLObjectType f14819d;
                            @Nullable
                            private MessageModel f14820e;
                            @Nullable
                            private MessageSenderModel f14821f;
                            @Nullable
                            private String f14822g;
                            private boolean f14823h;

                            /* compiled from: end_session_candidate_results */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                                }

                                public Object m17209a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MessagesParser.EdgesParser.NodeParser.m17298a(jsonParser, flatBufferBuilder));
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
                            @ModelWithFlatBufferFormatHash(a = -1352864475)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: end_session_candidate_results */
                            public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private String f14814d;

                                /* compiled from: end_session_candidate_results */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                                    }

                                    public Object m17210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(MessageParser.m17292a(jsonParser, flatBufferBuilder));
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

                                /* compiled from: end_session_candidate_results */
                                public class Serializer extends JsonSerializer<MessageModel> {
                                    public final void m17211a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        MessageModel messageModel = (MessageModel) obj;
                                        if (messageModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(messageModel.m17213a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        MessageParser.m17293a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                                    }

                                    static {
                                        FbSerializerProvider.a(MessageModel.class, new Serializer());
                                    }
                                }

                                public MessageModel() {
                                    super(1);
                                }

                                @Nullable
                                private String m17212a() {
                                    this.f14814d = super.a(this.f14814d, 0);
                                    return this.f14814d;
                                }

                                public final int jK_() {
                                    return -1919764332;
                                }

                                public final GraphQLVisitableModel m17214a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    h();
                                    i();
                                    return this;
                                }

                                public final int m17213a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int b = flatBufferBuilder.b(m17212a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, b);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -41592301)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: end_session_candidate_results */
                            public final class MessageSenderModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private MessagingActorModel f14818d;

                                /* compiled from: end_session_candidate_results */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(MessageSenderModel.class, new Deserializer());
                                    }

                                    public Object m17215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(MessageSenderParser.m17296a(jsonParser, flatBufferBuilder));
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
                                /* compiled from: end_session_candidate_results */
                                public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                                    @Nullable
                                    private GraphQLObjectType f14815d;
                                    @Nullable
                                    private String f14816e;
                                    @Nullable
                                    private String f14817f;

                                    /* compiled from: end_session_candidate_results */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                                        }

                                        public Object m17216a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(MessageSenderParser.MessagingActorParser.m17294a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: end_session_candidate_results */
                                    public class Serializer extends JsonSerializer<MessagingActorModel> {
                                        public final void m17217a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                                            if (messagingActorModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(messagingActorModel.m17221a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            MessageSenderParser.MessagingActorParser.m17295a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                                        }
                                    }

                                    public MessagingActorModel() {
                                        super(3);
                                    }

                                    @Nullable
                                    private GraphQLObjectType m17218j() {
                                        if (this.b != null && this.f14815d == null) {
                                            this.f14815d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                        }
                                        return this.f14815d;
                                    }

                                    @Nullable
                                    private String m17219k() {
                                        this.f14816e = super.a(this.f14816e, 1);
                                        return this.f14816e;
                                    }

                                    @Nullable
                                    private String m17220l() {
                                        this.f14817f = super.a(this.f14817f, 2);
                                        return this.f14817f;
                                    }

                                    @Nullable
                                    public final String m17223a() {
                                        return m17219k();
                                    }

                                    public final int jK_() {
                                        return -1575218831;
                                    }

                                    public final GraphQLVisitableModel m17222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m17221a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int a = ModelHelper.a(flatBufferBuilder, m17218j());
                                        int b = flatBufferBuilder.b(m17219k());
                                        int b2 = flatBufferBuilder.b(m17220l());
                                        flatBufferBuilder.c(3);
                                        flatBufferBuilder.b(0, a);
                                        flatBufferBuilder.b(1, b);
                                        flatBufferBuilder.b(2, b2);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: end_session_candidate_results */
                                public class Serializer extends JsonSerializer<MessageSenderModel> {
                                    public final void m17224a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        MessageSenderModel messageSenderModel = (MessageSenderModel) obj;
                                        if (messageSenderModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(messageSenderModel.m17226a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            messageSenderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        MessageSenderParser.m17297a(messageSenderModel.w_(), messageSenderModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(MessageSenderModel.class, new Serializer());
                                    }
                                }

                                public MessageSenderModel() {
                                    super(1);
                                }

                                @Nullable
                                private MessagingActorModel m17225a() {
                                    this.f14818d = (MessagingActorModel) super.a(this.f14818d, 0, MessagingActorModel.class);
                                    return this.f14818d;
                                }

                                public final int jK_() {
                                    return -1020278353;
                                }

                                public final GraphQLVisitableModel m17227a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m17225a() != null) {
                                        MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m17225a());
                                        if (m17225a() != messagingActorModel) {
                                            graphQLVisitableModel = (MessageSenderModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f14818d = messagingActorModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m17226a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m17225a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, a);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: end_session_candidate_results */
                            public class Serializer extends JsonSerializer<NodeModel> {
                                public final void m17228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    NodeModel nodeModel = (NodeModel) obj;
                                    if (nodeModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(nodeModel.m17233a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MessagesParser.EdgesParser.NodeParser.m17299a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                                }
                            }

                            public NodeModel() {
                                super(5);
                            }

                            @Nullable
                            private GraphQLObjectType m17229a() {
                                if (this.b != null && this.f14819d == null) {
                                    this.f14819d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                }
                                return this.f14819d;
                            }

                            @Nullable
                            private MessageModel m17230j() {
                                this.f14820e = (MessageModel) super.a(this.f14820e, 1, MessageModel.class);
                                return this.f14820e;
                            }

                            @Nullable
                            private MessageSenderModel m17231k() {
                                this.f14821f = (MessageSenderModel) super.a(this.f14821f, 2, MessageSenderModel.class);
                                return this.f14821f;
                            }

                            @Nullable
                            private String m17232l() {
                                this.f14822g = super.a(this.f14822g, 3);
                                return this.f14822g;
                            }

                            public final int jK_() {
                                return -1675388953;
                            }

                            public final GraphQLVisitableModel m17234a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m17230j() != null) {
                                    MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m17230j());
                                    if (m17230j() != messageModel) {
                                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f14820e = messageModel;
                                    }
                                }
                                if (m17231k() != null) {
                                    MessageSenderModel messageSenderModel = (MessageSenderModel) graphQLModelMutatingVisitor.b(m17231k());
                                    if (m17231k() != messageSenderModel) {
                                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f14821f = messageSenderModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m17233a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m17229a());
                                int a2 = ModelHelper.a(flatBufferBuilder, m17230j());
                                int a3 = ModelHelper.a(flatBufferBuilder, m17231k());
                                int b = flatBufferBuilder.b(m17232l());
                                flatBufferBuilder.c(5);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.b(2, a3);
                                flatBufferBuilder.b(3, b);
                                flatBufferBuilder.a(4, this.f14823h);
                                i();
                                return flatBufferBuilder.d();
                            }

                            public final void m17235a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                super.a(mutableFlatBuffer, i, obj);
                                this.f14823h = mutableFlatBuffer.a(i, 4);
                            }
                        }

                        /* compiled from: end_session_candidate_results */
                        public class Serializer extends JsonSerializer<EdgesModel> {
                            public final void m17236a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EdgesModel edgesModel = (EdgesModel) obj;
                                if (edgesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(edgesModel.m17238a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                MessagesParser.EdgesParser.m17301b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(EdgesModel.class, new Serializer());
                            }
                        }

                        public EdgesModel() {
                            super(1);
                        }

                        @Nullable
                        private NodeModel m17237a() {
                            this.f14824d = (NodeModel) super.a(this.f14824d, 0, NodeModel.class);
                            return this.f14824d;
                        }

                        public final int jK_() {
                            return 499227562;
                        }

                        public final GraphQLVisitableModel m17239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m17237a() != null) {
                                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m17237a());
                                if (m17237a() != nodeModel) {
                                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f14824d = nodeModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m17238a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m17237a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: end_session_candidate_results */
                    public class Serializer extends JsonSerializer<MessagesModel> {
                        public final void m17240a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MessagesModel messagesModel = (MessagesModel) obj;
                            if (messagesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(messagesModel.m17242a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                messagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MessagesParser.m17303a(messagesModel.w_(), messagesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(MessagesModel.class, new Serializer());
                        }
                    }

                    public MessagesModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<EdgesModel> m17241a() {
                        this.f14825d = super.a(this.f14825d, 0, EdgesModel.class);
                        return (ImmutableList) this.f14825d;
                    }

                    public final int jK_() {
                        return 1801832203;
                    }

                    public final GraphQLVisitableModel m17243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m17241a() != null) {
                            Builder a = ModelHelper.a(m17241a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (MessagesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f14825d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m17242a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m17241a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: end_session_candidate_results */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17256a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m17307b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 372214168)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: end_session_candidate_results */
                public final class ThreadKeyModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f14826d;

                    /* compiled from: end_session_candidate_results */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ThreadKeyModel.class, new Deserializer());
                        }

                        public Object m17245a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ThreadKeyParser.m17304a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: end_session_candidate_results */
                    public class Serializer extends JsonSerializer<ThreadKeyModel> {
                        public final void m17246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ThreadKeyModel threadKeyModel = (ThreadKeyModel) obj;
                            if (threadKeyModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(threadKeyModel.m17248a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                threadKeyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ThreadKeyParser.m17305a(threadKeyModel.w_(), threadKeyModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ThreadKeyModel.class, new Serializer());
                        }
                    }

                    public ThreadKeyModel() {
                        super(1);
                    }

                    @Nullable
                    private String m17247a() {
                        this.f14826d = super.a(this.f14826d, 0);
                        return this.f14826d;
                    }

                    public final int jK_() {
                        return 898588622;
                    }

                    public final GraphQLVisitableModel m17249a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17248a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17247a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public NodesModel() {
                    super(6);
                }

                @Nullable
                private AllParticipantsModel m17250a() {
                    this.f14827d = (AllParticipantsModel) super.a(this.f14827d, 0, AllParticipantsModel.class);
                    return this.f14827d;
                }

                @Nullable
                private ImageModel m17251j() {
                    this.f14828e = (ImageModel) super.a(this.f14828e, 1, ImageModel.class);
                    return this.f14828e;
                }

                @Nullable
                private MessagesModel m17252k() {
                    this.f14829f = (MessagesModel) super.a(this.f14829f, 2, MessagesModel.class);
                    return this.f14829f;
                }

                @Nullable
                private String m17253l() {
                    this.f14830g = super.a(this.f14830g, 3);
                    return this.f14830g;
                }

                @Nullable
                private ThreadKeyModel m17254m() {
                    this.f14831h = (ThreadKeyModel) super.a(this.f14831h, 4, ThreadKeyModel.class);
                    return this.f14831h;
                }

                @Nullable
                private String m17255n() {
                    this.f14832i = super.a(this.f14832i, 5);
                    return this.f14832i;
                }

                public final int jK_() {
                    return -740570927;
                }

                public final GraphQLVisitableModel m17257a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17250a() != null) {
                        AllParticipantsModel allParticipantsModel = (AllParticipantsModel) graphQLModelMutatingVisitor.b(m17250a());
                        if (m17250a() != allParticipantsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f14827d = allParticipantsModel;
                        }
                    }
                    if (m17251j() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m17251j());
                        if (m17251j() != imageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f14828e = imageModel;
                        }
                    }
                    if (m17252k() != null) {
                        MessagesModel messagesModel = (MessagesModel) graphQLModelMutatingVisitor.b(m17252k());
                        if (m17252k() != messagesModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f14829f = messagesModel;
                        }
                    }
                    if (m17254m() != null) {
                        ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(m17254m());
                        if (m17254m() != threadKeyModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f14831h = threadKeyModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17256a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17250a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m17251j());
                    int a3 = ModelHelper.a(flatBufferBuilder, m17252k());
                    int b = flatBufferBuilder.b(m17253l());
                    int a4 = ModelHelper.a(flatBufferBuilder, m17254m());
                    int b2 = flatBufferBuilder.b(m17255n());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.b(4, a4);
                    flatBufferBuilder.b(5, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: end_session_candidate_results */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f14833d;
                private boolean f14834e;

                /* compiled from: end_session_candidate_results */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m17258a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m17308a(jsonParser, flatBufferBuilder));
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

                /* compiled from: end_session_candidate_results */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m17259a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m17261a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m17309a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                private String m17260a() {
                    this.f14833d = super.a(this.f14833d, 0);
                    return this.f14833d;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m17262a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17261a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17260a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f14834e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17263a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f14834e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: end_session_candidate_results */
            public class Serializer extends JsonSerializer<GroupAssociatedMessageThreadsModel> {
                public final void m17264a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupAssociatedMessageThreadsModel groupAssociatedMessageThreadsModel = (GroupAssociatedMessageThreadsModel) obj;
                    if (groupAssociatedMessageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupAssociatedMessageThreadsModel.m17267a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupAssociatedMessageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupAssociatedMessageThreadsParser.m17311a(groupAssociatedMessageThreadsModel.w_(), groupAssociatedMessageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupAssociatedMessageThreadsModel.class, new Serializer());
                }
            }

            public GroupAssociatedMessageThreadsModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<NodesModel> m17265a() {
                this.f14835d = super.a(this.f14835d, 0, NodesModel.class);
                return (ImmutableList) this.f14835d;
            }

            @Nullable
            private PageInfoModel m17266j() {
                this.f14836e = (PageInfoModel) super.a(this.f14836e, 1, PageInfoModel.class);
                return this.f14836e;
            }

            public final int jK_() {
                return -754339835;
            }

            public final GraphQLVisitableModel m17268a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m17265a() != null) {
                    Builder a = ModelHelper.a(m17265a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        GroupAssociatedMessageThreadsModel groupAssociatedMessageThreadsModel = (GroupAssociatedMessageThreadsModel) ModelHelper.a(null, this);
                        groupAssociatedMessageThreadsModel.f14835d = a.b();
                        graphQLVisitableModel = groupAssociatedMessageThreadsModel;
                        if (m17266j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m17266j());
                            if (m17266j() != pageInfoModel) {
                                graphQLVisitableModel = (GroupAssociatedMessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f14836e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17266j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m17266j());
                    if (m17266j() != pageInfoModel) {
                        graphQLVisitableModel = (GroupAssociatedMessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f14836e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17267a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17265a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17266j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: end_session_candidate_results */
        public class Serializer extends JsonSerializer<FetchGroupSideConversationsModel> {
            public final void m17269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupSideConversationsModel fetchGroupSideConversationsModel = (FetchGroupSideConversationsModel) obj;
                if (fetchGroupSideConversationsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupSideConversationsModel.m17276a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupSideConversationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupSideConversationsModel.w_();
                int u_ = fetchGroupSideConversationsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_associated_message_threads");
                    GroupAssociatedMessageThreadsParser.m17311a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("viewer_join_state");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("viewer_post_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("visibility");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupSideConversationsModel.class, new Serializer());
            }
        }

        public FetchGroupSideConversationsModel() {
            super(4);
        }

        public final void m17278a(String str, ConsistencyTuple consistencyTuple) {
            if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = m17273j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("visibility".equals(str)) {
                consistencyTuple.a = m17275l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m17279a(String str, Object obj, boolean z) {
            if ("viewer_join_state".equals(str)) {
                m17271a((GraphQLGroupJoinState) obj);
            } else if ("visibility".equals(str)) {
                m17272a((GraphQLGroupVisibility) obj);
            }
        }

        @Nullable
        private GroupAssociatedMessageThreadsModel m17270a() {
            this.f14837d = (GroupAssociatedMessageThreadsModel) super.a(this.f14837d, 0, GroupAssociatedMessageThreadsModel.class);
            return this.f14837d;
        }

        @Nullable
        private GraphQLGroupJoinState m17273j() {
            this.f14838e = (GraphQLGroupJoinState) super.b(this.f14838e, 1, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14838e;
        }

        private void m17271a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.f14838e = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nullable
        private GraphQLGroupPostStatus m17274k() {
            this.f14839f = (GraphQLGroupPostStatus) super.b(this.f14839f, 2, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14839f;
        }

        @Nullable
        private GraphQLGroupVisibility m17275l() {
            this.f14840g = (GraphQLGroupVisibility) super.b(this.f14840g, 3, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14840g;
        }

        private void m17272a(GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f14840g = graphQLGroupVisibility;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
            }
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m17277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17270a() != null) {
                GroupAssociatedMessageThreadsModel groupAssociatedMessageThreadsModel = (GroupAssociatedMessageThreadsModel) graphQLModelMutatingVisitor.b(m17270a());
                if (m17270a() != groupAssociatedMessageThreadsModel) {
                    graphQLVisitableModel = (FetchGroupSideConversationsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14837d = groupAssociatedMessageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17276a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17270a());
            int a2 = flatBufferBuilder.a(m17273j());
            int a3 = flatBufferBuilder.a(m17274k());
            int a4 = flatBufferBuilder.a(m17275l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}
