package com.facebook.nearby.protocol;

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
import com.facebook.nearby.protocol.FetchNearbyPlacesGraphQLFragmentsParsers.NearbyFacepilesFragmentParser;
import com.facebook.nearby.protocol.FetchNearbyPlacesGraphQLFragmentsParsers.NearbyFacepilesFragmentParser.ConnectedFriendsParser;
import com.facebook.nearby.protocol.FetchNearbyPlacesGraphQLFragmentsParsers.NearbyFacepilesFragmentParser.ConnectedFriendsParser.EdgesParser;
import com.facebook.nearby.protocol.FetchNearbyPlacesGraphQLFragmentsParsers.NearbyFacepilesFragmentParser.ConnectedFriendsParser.EdgesParser.NodeParser;
import com.facebook.nearby.protocol.FetchNearbyPlacesGraphQLFragmentsParsers.NearbyFacepilesFragmentParser.ConnectedFriendsParser.EdgesParser.NodeParser.ProfilePictureParser;
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

/* compiled from: unexpected collection style */
public class FetchNearbyPlacesGraphQLFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1576619452)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unexpected collection style */
    public final class NearbyFacepilesFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ConnectedFriendsModel f518d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1705952571)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unexpected collection style */
        public final class ConnectedFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f516d;
            @Nullable
            private List<EdgesModel> f517e;

            /* compiled from: unexpected collection style */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ConnectedFriendsModel.class, new Deserializer());
                }

                public Object m604a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ConnectedFriendsParser.m641a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object connectedFriendsModel = new ConnectedFriendsModel();
                    ((BaseModel) connectedFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (connectedFriendsModel instanceof Postprocessable) {
                        return ((Postprocessable) connectedFriendsModel).a();
                    }
                    return connectedFriendsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1944799073)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: unexpected collection style */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f515d;

                /* compiled from: unexpected collection style */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m639b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 550844997)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: unexpected collection style */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f512d;
                    @Nullable
                    private String f513e;
                    @Nullable
                    private ProfilePictureModel f514f;

                    /* compiled from: unexpected collection style */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m637a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: unexpected collection style */
                    public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f511d;

                        /* compiled from: unexpected collection style */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                            }

                            public Object m607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ProfilePictureParser.m635a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: unexpected collection style */
                        public class Serializer extends JsonSerializer<ProfilePictureModel> {
                            public final void m608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                                if (profilePictureModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(profilePictureModel.m610a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ProfilePictureParser.m636a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                            }
                        }

                        public ProfilePictureModel() {
                            super(1);
                        }

                        @Nullable
                        private String m609a() {
                            this.f511d = super.a(this.f511d, 0);
                            return this.f511d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m611a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m610a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m609a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: unexpected collection style */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m616a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m638a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(3);
                    }

                    public final void m619a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m620a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private String m613j() {
                        this.f512d = super.a(this.f512d, 0);
                        return this.f512d;
                    }

                    @Nullable
                    private String m614k() {
                        this.f513e = super.a(this.f513e, 1);
                        return this.f513e;
                    }

                    @Nullable
                    private ProfilePictureModel m615l() {
                        this.f514f = (ProfilePictureModel) super.a(this.f514f, 2, ProfilePictureModel.class);
                        return this.f514f;
                    }

                    @Nullable
                    public final String m618a() {
                        return m613j();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m617a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m615l() != null) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m615l());
                            if (m615l() != profilePictureModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f514f = profilePictureModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m616a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m613j());
                        int b2 = flatBufferBuilder.b(m614k());
                        int a = ModelHelper.a(flatBufferBuilder, m615l());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: unexpected collection style */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m621a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m623a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m640b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m622a() {
                    this.f515d = (NodeModel) super.a(this.f515d, 0, NodeModel.class);
                    return this.f515d;
                }

                public final int jK_() {
                    return -1522965569;
                }

                public final GraphQLVisitableModel m624a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m622a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m622a());
                        if (m622a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f515d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m623a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m622a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: unexpected collection style */
            public class Serializer extends JsonSerializer<ConnectedFriendsModel> {
                public final void m625a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ConnectedFriendsModel connectedFriendsModel = (ConnectedFriendsModel) obj;
                    if (connectedFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(connectedFriendsModel.m627a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        connectedFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ConnectedFriendsParser.m642a(connectedFriendsModel.w_(), connectedFriendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ConnectedFriendsModel.class, new Serializer());
                }
            }

            public ConnectedFriendsModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m626a() {
                this.f517e = super.a(this.f517e, 1, EdgesModel.class);
                return (ImmutableList) this.f517e;
            }

            public final int jK_() {
                return 1925868384;
            }

            public final GraphQLVisitableModel m628a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m626a() != null) {
                    Builder a = ModelHelper.a(m626a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ConnectedFriendsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f517e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m627a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m626a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f516d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m629a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f516d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: unexpected collection style */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyFacepilesFragmentModel.class, new Deserializer());
            }

            public Object m630a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NearbyFacepilesFragmentParser.m643a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nearbyFacepilesFragmentModel = new NearbyFacepilesFragmentModel();
                ((BaseModel) nearbyFacepilesFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nearbyFacepilesFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyFacepilesFragmentModel).a();
                }
                return nearbyFacepilesFragmentModel;
            }
        }

        /* compiled from: unexpected collection style */
        public class Serializer extends JsonSerializer<NearbyFacepilesFragmentModel> {
            public final void m631a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NearbyFacepilesFragmentModel nearbyFacepilesFragmentModel = (NearbyFacepilesFragmentModel) obj;
                if (nearbyFacepilesFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyFacepilesFragmentModel.m633a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyFacepilesFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NearbyFacepilesFragmentParser.m644a(nearbyFacepilesFragmentModel.w_(), nearbyFacepilesFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NearbyFacepilesFragmentModel.class, new Serializer());
            }
        }

        public NearbyFacepilesFragmentModel() {
            super(1);
        }

        @Nullable
        private ConnectedFriendsModel m632a() {
            this.f518d = (ConnectedFriendsModel) super.a(this.f518d, 0, ConnectedFriendsModel.class);
            return this.f518d;
        }

        public final int jK_() {
            return 379010371;
        }

        public final GraphQLVisitableModel m634a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m632a() != null) {
                ConnectedFriendsModel connectedFriendsModel = (ConnectedFriendsModel) graphQLModelMutatingVisitor.b(m632a());
                if (m632a() != connectedFriendsModel) {
                    graphQLVisitableModel = (NearbyFacepilesFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f518d = connectedFriendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m633a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m632a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
