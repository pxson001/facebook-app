package com.facebook.groups.grouppurposes.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupPurposeType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryInterfaces.GroupPurposeFragment;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryParsers.FetchGroupPurposesQueryParser;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryParsers.FetchGroupPurposesQueryParser.GroupsAppGroupPurposesParser;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryParsers.FetchGroupPurposesQueryParser.GroupsAppGroupPurposesParser.EdgesParser;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryParsers.FetchGroupPurposesQueryParser.GroupsAppGroupPurposesParser.EdgesParser.NodeParser;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryParsers.GroupPurposeFragmentParser;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryParsers.GroupPurposesImageFragmentParser;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryParsers.GroupPurposesImageFragmentParser.PurposeImageParser;
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

/* compiled from: psym_click */
public class FetchGroupPurposesQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1079598122)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: psym_click */
    public final class FetchGroupPurposesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupsAppGroupPurposesModel f5710d;

        /* compiled from: psym_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupPurposesQueryModel.class, new Deserializer());
            }

            public Object m6954a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupPurposesQueryParser.m7004a(jsonParser);
                Object fetchGroupPurposesQueryModel = new FetchGroupPurposesQueryModel();
                ((BaseModel) fetchGroupPurposesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupPurposesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupPurposesQueryModel).a();
                }
                return fetchGroupPurposesQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1273337482)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: psym_click */
        public final class GroupsAppGroupPurposesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f5709d;

            /* compiled from: psym_click */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupsAppGroupPurposesModel.class, new Deserializer());
                }

                public Object m6955a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupsAppGroupPurposesParser.m7002a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupsAppGroupPurposesModel = new GroupsAppGroupPurposesModel();
                    ((BaseModel) groupsAppGroupPurposesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupsAppGroupPurposesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupsAppGroupPurposesModel).a();
                    }
                    return groupsAppGroupPurposesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1910884654)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: psym_click */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f5708d;

                /* compiled from: psym_click */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m6956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m7000b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1723970004)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: psym_click */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel, GroupPurposeFragment {
                    @Nullable
                    private String f5702d;
                    @Nullable
                    private GraphQLGroupPurposeType f5703e;
                    @Nullable
                    private PurposeImageModel f5704f;
                    @Nullable
                    private String f5705g;
                    @Nullable
                    private String f5706h;
                    @Nullable
                    private GraphQLGroupVisibility f5707i;

                    /* compiled from: psym_click */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m6957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m6998a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: psym_click */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m6958a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m6960a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m6999a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(6);
                    }

                    @Nullable
                    public final String mo302a() {
                        this.f5702d = super.a(this.f5702d, 0);
                        return this.f5702d;
                    }

                    @Nullable
                    public final GraphQLGroupPurposeType mo303b() {
                        this.f5703e = (GraphQLGroupPurposeType) super.b(this.f5703e, 1, GraphQLGroupPurposeType.class, GraphQLGroupPurposeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f5703e;
                    }

                    @Nullable
                    private PurposeImageModel m6959j() {
                        this.f5704f = (PurposeImageModel) super.a(this.f5704f, 2, PurposeImageModel.class);
                        return this.f5704f;
                    }

                    @Nullable
                    public final String mo304c() {
                        this.f5705g = super.a(this.f5705g, 3);
                        return this.f5705g;
                    }

                    @Nullable
                    public final String mo305d() {
                        this.f5706h = super.a(this.f5706h, 4);
                        return this.f5706h;
                    }

                    @Nullable
                    public final GraphQLGroupVisibility gV_() {
                        this.f5707i = (GraphQLGroupVisibility) super.b(this.f5707i, 5, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f5707i;
                    }

                    public final int jK_() {
                        return -405572161;
                    }

                    public final GraphQLVisitableModel m6961a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6959j() != null) {
                            PurposeImageModel purposeImageModel = (PurposeImageModel) graphQLModelMutatingVisitor.b(m6959j());
                            if (m6959j() != purposeImageModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f5704f = purposeImageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6960a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(mo302a());
                        int a = flatBufferBuilder.a(mo303b());
                        int a2 = ModelHelper.a(flatBufferBuilder, m6959j());
                        int b2 = flatBufferBuilder.b(mo304c());
                        int b3 = flatBufferBuilder.b(mo305d());
                        int a3 = flatBufferBuilder.a(gV_());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.b(2, a2);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.b(5, a3);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: psym_click */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m6966a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m6968a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m7001b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m6967a() {
                    this.f5708d = (NodeModel) super.a(this.f5708d, 0, NodeModel.class);
                    return this.f5708d;
                }

                public final int jK_() {
                    return -143607183;
                }

                public final GraphQLVisitableModel m6969a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6967a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m6967a());
                        if (m6967a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5708d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6968a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6967a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: psym_click */
            public class Serializer extends JsonSerializer<GroupsAppGroupPurposesModel> {
                public final void m6970a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupsAppGroupPurposesModel groupsAppGroupPurposesModel = (GroupsAppGroupPurposesModel) obj;
                    if (groupsAppGroupPurposesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupsAppGroupPurposesModel.m6972a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupsAppGroupPurposesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupsAppGroupPurposesParser.m7003a(groupsAppGroupPurposesModel.w_(), groupsAppGroupPurposesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupsAppGroupPurposesModel.class, new Serializer());
                }
            }

            public GroupsAppGroupPurposesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m6971a() {
                this.f5709d = super.a(this.f5709d, 0, EdgesModel.class);
                return (ImmutableList) this.f5709d;
            }

            public final int jK_() {
                return 532575378;
            }

            public final GraphQLVisitableModel m6973a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6971a() != null) {
                    Builder a = ModelHelper.a(m6971a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupsAppGroupPurposesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5709d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6972a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6971a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: psym_click */
        public class Serializer extends JsonSerializer<FetchGroupPurposesQueryModel> {
            public final void m6974a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupPurposesQueryModel fetchGroupPurposesQueryModel = (FetchGroupPurposesQueryModel) obj;
                if (fetchGroupPurposesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupPurposesQueryModel.m6976a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupPurposesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupPurposesQueryModel.w_();
                int u_ = fetchGroupPurposesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("groups_app_group_purposes");
                    GroupsAppGroupPurposesParser.m7003a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupPurposesQueryModel.class, new Serializer());
            }
        }

        public FetchGroupPurposesQueryModel() {
            super(1);
        }

        @Nullable
        private GroupsAppGroupPurposesModel m6975a() {
            this.f5710d = (GroupsAppGroupPurposesModel) super.a(this.f5710d, 0, GroupsAppGroupPurposesModel.class);
            return this.f5710d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m6977a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6975a() != null) {
                GroupsAppGroupPurposesModel groupsAppGroupPurposesModel = (GroupsAppGroupPurposesModel) graphQLModelMutatingVisitor.b(m6975a());
                if (m6975a() != groupsAppGroupPurposesModel) {
                    graphQLVisitableModel = (FetchGroupPurposesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5710d = groupsAppGroupPurposesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6976a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6975a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -478791464)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: psym_click */
    public final class GroupPurposeFragmentModel extends BaseModel implements GraphQLVisitableModel, GroupPurposeFragment {
        @Nullable
        private String f5716d;
        @Nullable
        private GraphQLGroupPurposeType f5717e;
        @Nullable
        private String f5718f;
        @Nullable
        private String f5719g;
        @Nullable
        private GraphQLGroupVisibility f5720h;

        /* compiled from: psym_click */
        public final class Builder {
            @Nullable
            public String f5711a;
            @Nullable
            public GraphQLGroupPurposeType f5712b;
            @Nullable
            public String f5713c;
            @Nullable
            public String f5714d;
            @Nullable
            public GraphQLGroupVisibility f5715e;
        }

        /* compiled from: psym_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupPurposeFragmentModel.class, new Deserializer());
            }

            public Object m6978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupPurposeFragmentParser.m7006b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupPurposeFragmentModel = new GroupPurposeFragmentModel();
                ((BaseModel) groupPurposeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupPurposeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) groupPurposeFragmentModel).a();
                }
                return groupPurposeFragmentModel;
            }
        }

        /* compiled from: psym_click */
        public class Serializer extends JsonSerializer<GroupPurposeFragmentModel> {
            public final void m6979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupPurposeFragmentModel groupPurposeFragmentModel = (GroupPurposeFragmentModel) obj;
                if (groupPurposeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupPurposeFragmentModel.m6981a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupPurposeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupPurposeFragmentParser.m7005a(groupPurposeFragmentModel.w_(), groupPurposeFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(GroupPurposeFragmentModel.class, new Serializer());
            }
        }

        public GroupPurposeFragmentModel() {
            super(5);
        }

        public GroupPurposeFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String mo302a() {
            this.f5716d = super.a(this.f5716d, 0);
            return this.f5716d;
        }

        @Nullable
        public final GraphQLGroupPurposeType mo303b() {
            this.f5717e = (GraphQLGroupPurposeType) super.b(this.f5717e, 1, GraphQLGroupPurposeType.class, GraphQLGroupPurposeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5717e;
        }

        @Nullable
        public final String mo304c() {
            this.f5718f = super.a(this.f5718f, 2);
            return this.f5718f;
        }

        @Nullable
        public final String mo305d() {
            this.f5719g = super.a(this.f5719g, 3);
            return this.f5719g;
        }

        @Nullable
        public final GraphQLGroupVisibility gV_() {
            this.f5720h = (GraphQLGroupVisibility) super.b(this.f5720h, 4, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5720h;
        }

        public static GroupPurposeFragmentModel m6980a(GroupPurposeFragment groupPurposeFragment) {
            if (groupPurposeFragment == null) {
                return null;
            }
            if (groupPurposeFragment instanceof GroupPurposeFragmentModel) {
                return (GroupPurposeFragmentModel) groupPurposeFragment;
            }
            Builder builder = new Builder();
            builder.f5711a = groupPurposeFragment.mo302a();
            builder.f5712b = groupPurposeFragment.mo303b();
            builder.f5713c = groupPurposeFragment.mo304c();
            builder.f5714d = groupPurposeFragment.mo305d();
            builder.f5715e = groupPurposeFragment.gV_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f5711a);
            int a = flatBufferBuilder.a(builder.f5712b);
            int b2 = flatBufferBuilder.b(builder.f5713c);
            int b3 = flatBufferBuilder.b(builder.f5714d);
            int a2 = flatBufferBuilder.a(builder.f5715e);
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new GroupPurposeFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -405572161;
        }

        public final GraphQLVisitableModel m6982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6981a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo302a());
            int a = flatBufferBuilder.a(mo303b());
            int b2 = flatBufferBuilder.b(mo304c());
            int b3 = flatBufferBuilder.b(mo305d());
            int a2 = flatBufferBuilder.a(gV_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1666034934)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: psym_click */
    public final class GroupPurposesImageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PurposeImageModel f5723d;

        /* compiled from: psym_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupPurposesImageFragmentModel.class, new Deserializer());
            }

            public Object m6987a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupPurposesImageFragmentParser.m7009a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupPurposesImageFragmentModel = new GroupPurposesImageFragmentModel();
                ((BaseModel) groupPurposesImageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupPurposesImageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) groupPurposesImageFragmentModel).a();
                }
                return groupPurposesImageFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -817178504)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: psym_click */
        public final class PurposeImageModel extends BaseModel implements GraphQLVisitableModel {
            private int f5721d;
            @Nullable
            private String f5722e;

            /* compiled from: psym_click */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PurposeImageModel.class, new Deserializer());
                }

                public Object m6988a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PurposeImageParser.m7007a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object purposeImageModel = new PurposeImageModel();
                    ((BaseModel) purposeImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (purposeImageModel instanceof Postprocessable) {
                        return ((Postprocessable) purposeImageModel).a();
                    }
                    return purposeImageModel;
                }
            }

            /* compiled from: psym_click */
            public class Serializer extends JsonSerializer<PurposeImageModel> {
                public final void m6989a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PurposeImageModel purposeImageModel = (PurposeImageModel) obj;
                    if (purposeImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(purposeImageModel.m6990a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        purposeImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PurposeImageParser.m7008a(purposeImageModel.w_(), purposeImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PurposeImageModel.class, new Serializer());
                }
            }

            public PurposeImageModel() {
                super(2);
            }

            @Nullable
            public final String m6992a() {
                this.f5722e = super.a(this.f5722e, 1);
                return this.f5722e;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m6991a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6990a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6992a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f5721d, 0);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6993a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5721d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: psym_click */
        public class Serializer extends JsonSerializer<GroupPurposesImageFragmentModel> {
            public final void m6994a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupPurposesImageFragmentModel groupPurposesImageFragmentModel = (GroupPurposesImageFragmentModel) obj;
                if (groupPurposesImageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupPurposesImageFragmentModel.m6995a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupPurposesImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupPurposesImageFragmentParser.m7010a(groupPurposesImageFragmentModel.w_(), groupPurposesImageFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupPurposesImageFragmentModel.class, new Serializer());
            }
        }

        public GroupPurposesImageFragmentModel() {
            super(1);
        }

        @Nullable
        public final PurposeImageModel m6997a() {
            this.f5723d = (PurposeImageModel) super.a(this.f5723d, 0, PurposeImageModel.class);
            return this.f5723d;
        }

        public final int jK_() {
            return -405572161;
        }

        public final GraphQLVisitableModel m6996a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6997a() != null) {
                PurposeImageModel purposeImageModel = (PurposeImageModel) graphQLModelMutatingVisitor.b(m6997a());
                if (m6997a() != purposeImageModel) {
                    graphQLVisitableModel = (GroupPurposesImageFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5723d = purposeImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6995a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6997a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
