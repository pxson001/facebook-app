package com.facebook.groups.memberpicker.protocol;

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
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryParsers.GroupInviteMembersSearchQueryParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryParsers.GroupInviteMembersSearchQueryParser.GroupInviteMembersParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryParsers.GroupInviteMembersSearchQueryParser.GroupInviteMembersParser.EdgesParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryParsers.GroupInviteMembersSearchQueryParser.GroupInviteMembersParser.EdgesParser.NodeParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataInterfaces.FBTaggableUserFragment;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBNameFragmentModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBTaggableUserFragmentModel.BylinesModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel;
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

/* compiled from: event_ticketing */
public class GroupSuggestedInviteSearchQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1903793333)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_ticketing */
    public final class GroupInviteMembersSearchQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f14659d;
        @Nullable
        private GroupInviteMembersModel f14660e;
        @Nullable
        private String f14661f;

        /* compiled from: event_ticketing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupInviteMembersSearchQueryModel.class, new Deserializer());
            }

            public Object m16606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupInviteMembersSearchQueryParser.m16650a(jsonParser);
                Object groupInviteMembersSearchQueryModel = new GroupInviteMembersSearchQueryModel();
                ((BaseModel) groupInviteMembersSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupInviteMembersSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) groupInviteMembersSearchQueryModel).a();
                }
                return groupInviteMembersSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 967028819)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: event_ticketing */
        public final class GroupInviteMembersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f14658d;

            /* compiled from: event_ticketing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupInviteMembersModel.class, new Deserializer());
                }

                public Object m16607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupInviteMembersParser.m16648a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupInviteMembersModel = new GroupInviteMembersModel();
                    ((BaseModel) groupInviteMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupInviteMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) groupInviteMembersModel).a();
                    }
                    return groupInviteMembersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -909597973)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: event_ticketing */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f14655d;
                @Nullable
                private NodeModel f14656e;
                @Nullable
                private String f14657f;

                /* compiled from: event_ticketing */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m16608a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m16646b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1840870178)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: event_ticketing */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FBTaggableUserFragment {
                    @Nullable
                    private GraphQLObjectType f14647d;
                    @Nullable
                    private List<BylinesModel> f14648e;
                    private double f14649f;
                    @Nullable
                    private String f14650g;
                    @Nullable
                    private String f14651h;
                    @Nullable
                    private List<String> f14652i;
                    @Nullable
                    private FullImageFragmentModel f14653j;
                    @Nullable
                    private FBNameFragmentModel f14654k;

                    /* compiled from: event_ticketing */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m16609a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m16644a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: event_ticketing */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m16610a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m16615a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m16645a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ FullImageFragmentModel mo894m() {
                        return m16613p();
                    }

                    public NodeModel() {
                        super(8);
                    }

                    public final void m16619a(String str, ConsistencyTuple consistencyTuple) {
                        r2.a();
                    }

                    public final void m16620a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private GraphQLObjectType m16611n() {
                        if (this.b != null && this.f14647d == null) {
                            this.f14647d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f14647d;
                    }

                    @Nonnull
                    private ImmutableList<BylinesModel> m16612o() {
                        this.f14648e = super.a(this.f14648e, 1, BylinesModel.class);
                        return (ImmutableList) this.f14648e;
                    }

                    @Nullable
                    public final String mo891j() {
                        this.f14650g = super.a(this.f14650g, 3);
                        return this.f14650g;
                    }

                    @Nullable
                    public final String mo892k() {
                        this.f14651h = super.a(this.f14651h, 4);
                        return this.f14651h;
                    }

                    @Nonnull
                    public final ImmutableList<String> mo893l() {
                        this.f14652i = super.a(this.f14652i, 5);
                        return (ImmutableList) this.f14652i;
                    }

                    @Nullable
                    private FullImageFragmentModel m16613p() {
                        this.f14653j = (FullImageFragmentModel) super.a(this.f14653j, 6, FullImageFragmentModel.class);
                        return this.f14653j;
                    }

                    @Nullable
                    private FBNameFragmentModel m16614q() {
                        this.f14654k = (FBNameFragmentModel) super.a(this.f14654k, 7, FBNameFragmentModel.class);
                        return this.f14654k;
                    }

                    @Nullable
                    public final String m16617a() {
                        return mo891j();
                    }

                    public final int jK_() {
                        return 1355227529;
                    }

                    public final GraphQLVisitableModel m16616a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel;
                        FullImageFragmentModel fullImageFragmentModel;
                        FBNameFragmentModel fBNameFragmentModel;
                        h();
                        if (m16612o() != null) {
                            Builder a = ModelHelper.a(m16612o(), r4);
                            if (a != null) {
                                NodeModel nodeModel = (NodeModel) ModelHelper.a(null, this);
                                nodeModel.f14648e = a.b();
                                graphQLVisitableModel = nodeModel;
                                if (m16613p() != null) {
                                    fullImageFragmentModel = (FullImageFragmentModel) r4.b(m16613p());
                                    if (m16613p() != fullImageFragmentModel) {
                                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f14653j = fullImageFragmentModel;
                                    }
                                }
                                if (m16614q() != null) {
                                    fBNameFragmentModel = (FBNameFragmentModel) r4.b(m16614q());
                                    if (m16614q() != fBNameFragmentModel) {
                                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f14654k = fBNameFragmentModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                            }
                        }
                        graphQLVisitableModel = null;
                        if (m16613p() != null) {
                            fullImageFragmentModel = (FullImageFragmentModel) r4.b(m16613p());
                            if (m16613p() != fullImageFragmentModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f14653j = fullImageFragmentModel;
                            }
                        }
                        if (m16614q() != null) {
                            fBNameFragmentModel = (FBNameFragmentModel) r4.b(m16614q());
                            if (m16614q() != fBNameFragmentModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f14654k = fBNameFragmentModel;
                            }
                        }
                        i();
                        if (graphQLVisitableModel != null) {
                        }
                    }

                    public final int m16615a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(r12, m16611n());
                        int a2 = ModelHelper.a(r12, m16612o());
                        int b = r12.b(mo891j());
                        int b2 = r12.b(mo892k());
                        int c = r12.c(mo893l());
                        int a3 = ModelHelper.a(r12, m16613p());
                        int a4 = ModelHelper.a(r12, m16614q());
                        r12.c(8);
                        r12.b(0, a);
                        r12.b(1, a2);
                        r12.a(2, this.f14649f, 0.0d);
                        r12.b(3, b);
                        r12.b(4, b2);
                        r12.b(5, c);
                        r12.b(6, a3);
                        r12.b(7, a4);
                        i();
                        return r12.d();
                    }

                    public final void m16618a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(r5, r6, r7);
                        this.f14649f = r5.a(r6, 2, 0.0d);
                    }
                }

                /* compiled from: event_ticketing */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m16625a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) r8;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m16626a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m16647b(edgesModel.w_(), edgesModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(3);
                }

                @Nullable
                public final String m16628a() {
                    this.f14655d = super.a(this.f14655d, 0);
                    return this.f14655d;
                }

                @Nullable
                public final NodeModel m16629j() {
                    this.f14656e = (NodeModel) super.a(this.f14656e, 1, NodeModel.class);
                    return this.f14656e;
                }

                @Nullable
                public final String m16630k() {
                    this.f14657f = super.a(this.f14657f, 2);
                    return this.f14657f;
                }

                public final int jK_() {
                    return 682377998;
                }

                public final GraphQLVisitableModel m16627a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16629j() != null) {
                        NodeModel nodeModel = (NodeModel) r4.b(m16629j());
                        if (m16629j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f14656e = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16626a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r5.b(m16628a());
                    int a = ModelHelper.a(r5, m16629j());
                    int b2 = r5.b(m16630k());
                    r5.c(3);
                    r5.b(0, b);
                    r5.b(1, a);
                    r5.b(2, b2);
                    i();
                    return r5.d();
                }
            }

            /* compiled from: event_ticketing */
            public class Serializer extends JsonSerializer<GroupInviteMembersModel> {
                public final void m16631a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupInviteMembersModel groupInviteMembersModel = (GroupInviteMembersModel) r8;
                    if (groupInviteMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupInviteMembersModel.m16632a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupInviteMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupInviteMembersParser.m16649a(groupInviteMembersModel.w_(), groupInviteMembersModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(GroupInviteMembersModel.class, new Serializer());
                }
            }

            public GroupInviteMembersModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m16634a() {
                this.f14658d = super.a(this.f14658d, 0, EdgesModel.class);
                return (ImmutableList) this.f14658d;
            }

            public final int jK_() {
                return -110734481;
            }

            public final GraphQLVisitableModel m16633a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16634a() != null) {
                    Builder a = ModelHelper.a(m16634a(), r3);
                    if (a != null) {
                        graphQLVisitableModel = (GroupInviteMembersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14658d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16632a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m16634a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        /* compiled from: event_ticketing */
        public class Serializer extends JsonSerializer<GroupInviteMembersSearchQueryModel> {
            public final void m16635a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupInviteMembersSearchQueryModel groupInviteMembersSearchQueryModel = (GroupInviteMembersSearchQueryModel) r10;
                if (groupInviteMembersSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupInviteMembersSearchQueryModel.m16638a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupInviteMembersSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupInviteMembersSearchQueryModel.w_();
                int u_ = groupInviteMembersSearchQueryModel.u_();
                r11.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    r11.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, r11);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    r11.a("group_invite_members");
                    GroupInviteMembersParser.m16649a(mutableFlatBuffer, g, r11, r12);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    r11.a("id");
                    r11.b(mutableFlatBuffer.c(u_, 2));
                }
                r11.g();
            }

            static {
                FbSerializerProvider.a(GroupInviteMembersSearchQueryModel.class, new Serializer());
            }
        }

        public GroupInviteMembersSearchQueryModel() {
            super(3);
        }

        public final void m16641a(String str, ConsistencyTuple consistencyTuple) {
            r2.a();
        }

        public final void m16642a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16636k() {
            if (this.b != null && this.f14659d == null) {
                this.f14659d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f14659d;
        }

        @Nullable
        public final GroupInviteMembersModel m16643j() {
            this.f14660e = (GroupInviteMembersModel) super.a(this.f14660e, 1, GroupInviteMembersModel.class);
            return this.f14660e;
        }

        @Nullable
        private String m16637l() {
            this.f14661f = super.a(this.f14661f, 2);
            return this.f14661f;
        }

        @Nullable
        public final String m16640a() {
            return m16637l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16639a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16643j() != null) {
                GroupInviteMembersModel groupInviteMembersModel = (GroupInviteMembersModel) r4.b(m16643j());
                if (m16643j() != groupInviteMembersModel) {
                    graphQLVisitableModel = (GroupInviteMembersSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14660e = groupInviteMembersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16638a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r5, m16636k());
            int a2 = ModelHelper.a(r5, m16643j());
            int b = r5.b(m16637l());
            r5.c(3);
            r5.b(0, a);
            r5.b(1, a2);
            r5.b(2, b);
            i();
            return r5.d();
        }
    }
}
