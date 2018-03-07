package com.facebook.redspace.protocol;

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
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceFriendDemoteMutationParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceFriendPromoteMutationParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceFriendPromoteMutationParser.ViewerParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceFriendPromoteMutationParser.ViewerParser.RedspaceParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceFriendPromoteMutationParser.ViewerParser.RedspaceParser.FriendsParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceFriendPromoteMutationParser.ViewerParser.RedspaceParser.FriendsParser.NodesParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceFriendViewMutationParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceHomeViewMutationParser;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsParsers.RedSpaceSelfViewMutationParser;
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

/* compiled from: shouldSendReadReceipt */
public class RedSpaceMutationFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: shouldSendReadReceipt */
    public final class RedSpaceFriendDemoteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4512d;

        /* compiled from: shouldSendReadReceipt */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceFriendDemoteMutationModel.class, new Deserializer());
            }

            public Object m6923a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceFriendDemoteMutationParser.m6994a(jsonParser);
                Object redSpaceFriendDemoteMutationModel = new RedSpaceFriendDemoteMutationModel();
                ((BaseModel) redSpaceFriendDemoteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceFriendDemoteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceFriendDemoteMutationModel).a();
                }
                return redSpaceFriendDemoteMutationModel;
            }
        }

        /* compiled from: shouldSendReadReceipt */
        public class Serializer extends JsonSerializer<RedSpaceFriendDemoteMutationModel> {
            public final void m6924a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceFriendDemoteMutationModel redSpaceFriendDemoteMutationModel = (RedSpaceFriendDemoteMutationModel) obj;
                if (redSpaceFriendDemoteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceFriendDemoteMutationModel.m6926a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceFriendDemoteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceFriendDemoteMutationModel.w_();
                int u_ = redSpaceFriendDemoteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceFriendDemoteMutationModel.class, new Serializer());
            }
        }

        public RedSpaceFriendDemoteMutationModel() {
            super(1);
        }

        @Nullable
        private String m6925a() {
            this.f4512d = super.a(this.f4512d, 0);
            return this.f4512d;
        }

        public final int jK_() {
            return -863523047;
        }

        public final GraphQLVisitableModel m6927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6926a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6925a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 574293418)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: shouldSendReadReceipt */
    public final class RedSpaceFriendPromoteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f4517d;

        /* compiled from: shouldSendReadReceipt */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceFriendPromoteMutationModel.class, new Deserializer());
            }

            public Object m6928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceFriendPromoteMutationParser.m7003a(jsonParser);
                Object redSpaceFriendPromoteMutationModel = new RedSpaceFriendPromoteMutationModel();
                ((BaseModel) redSpaceFriendPromoteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceFriendPromoteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceFriendPromoteMutationModel).a();
                }
                return redSpaceFriendPromoteMutationModel;
            }
        }

        /* compiled from: shouldSendReadReceipt */
        public class Serializer extends JsonSerializer<RedSpaceFriendPromoteMutationModel> {
            public final void m6929a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceFriendPromoteMutationModel redSpaceFriendPromoteMutationModel = (RedSpaceFriendPromoteMutationModel) obj;
                if (redSpaceFriendPromoteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceFriendPromoteMutationModel.m6953a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceFriendPromoteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceFriendPromoteMutationModel.w_();
                int u_ = redSpaceFriendPromoteMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m7002a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceFriendPromoteMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1946281911)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: shouldSendReadReceipt */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private RedspaceModel f4516d;

            /* compiled from: shouldSendReadReceipt */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m6930a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m7001a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -311784063)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: shouldSendReadReceipt */
            public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FriendsModel f4515d;

                /* compiled from: shouldSendReadReceipt */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                    }

                    public Object m6931a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RedspaceParser.m6999a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object redspaceModel = new RedspaceModel();
                        ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (redspaceModel instanceof Postprocessable) {
                            return ((Postprocessable) redspaceModel).a();
                        }
                        return redspaceModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 2032321974)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: shouldSendReadReceipt */
                public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<NodesModel> f4514d;

                    /* compiled from: shouldSendReadReceipt */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                        }

                        public Object m6932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FriendsParser.m6997a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object friendsModel = new FriendsModel();
                            ((BaseModel) friendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (friendsModel instanceof Postprocessable) {
                                return ((Postprocessable) friendsModel).a();
                            }
                            return friendsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: shouldSendReadReceipt */
                    public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f4513d;

                        /* compiled from: shouldSendReadReceipt */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                            }

                            public Object m6933a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodesParser.m6996b(jsonParser, flatBufferBuilder));
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

                        /* compiled from: shouldSendReadReceipt */
                        public class Serializer extends JsonSerializer<NodesModel> {
                            public final void m6934a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodesModel nodesModel = (NodesModel) obj;
                                if (nodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodesModel.m6936a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodesParser.m6995a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(NodesModel.class, new Serializer());
                            }
                        }

                        public NodesModel() {
                            super(1);
                        }

                        public final void m6939a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m6940a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        private String m6935j() {
                            this.f4513d = super.a(this.f4513d, 0);
                            return this.f4513d;
                        }

                        @Nullable
                        public final String m6938a() {
                            return m6935j();
                        }

                        public final int jK_() {
                            return 2645995;
                        }

                        public final GraphQLVisitableModel m6937a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m6936a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m6935j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: shouldSendReadReceipt */
                    public class Serializer extends JsonSerializer<FriendsModel> {
                        public final void m6941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            FriendsModel friendsModel = (FriendsModel) obj;
                            if (friendsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(friendsModel.m6942a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FriendsParser.m6998a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(FriendsModel.class, new Serializer());
                        }
                    }

                    public FriendsModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<NodesModel> m6944a() {
                        this.f4514d = super.a(this.f4514d, 0, NodesModel.class);
                        return (ImmutableList) this.f4514d;
                    }

                    public final int jK_() {
                        return -596919362;
                    }

                    public final GraphQLVisitableModel m6943a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6944a() != null) {
                            Builder a = ModelHelper.a(m6944a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (FriendsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4514d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6942a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6944a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: shouldSendReadReceipt */
                public class Serializer extends JsonSerializer<RedspaceModel> {
                    public final void m6945a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RedspaceModel redspaceModel = (RedspaceModel) obj;
                        if (redspaceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(redspaceModel.m6946a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RedspaceParser.m7000a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                    }
                }

                public RedspaceModel() {
                    super(1);
                }

                @Nullable
                public final FriendsModel m6948a() {
                    this.f4515d = (FriendsModel) super.a(this.f4515d, 0, FriendsModel.class);
                    return this.f4515d;
                }

                public final int jK_() {
                    return 399824597;
                }

                public final GraphQLVisitableModel m6947a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6948a() != null) {
                        FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m6948a());
                        if (m6948a() != friendsModel) {
                            graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4515d = friendsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6946a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6948a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: shouldSendReadReceipt */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m6949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m6950a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m7002a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            public final RedspaceModel m6952a() {
                this.f4516d = (RedspaceModel) super.a(this.f4516d, 0, RedspaceModel.class);
                return this.f4516d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m6951a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6952a() != null) {
                    RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6952a());
                    if (m6952a() != redspaceModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4516d = redspaceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6950a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6952a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RedSpaceFriendPromoteMutationModel() {
            super(1);
        }

        @Nullable
        public final ViewerModel m6955a() {
            this.f4517d = (ViewerModel) super.a(this.f4517d, 0, ViewerModel.class);
            return this.f4517d;
        }

        public final int jK_() {
            return 508115693;
        }

        public final GraphQLVisitableModel m6954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6955a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m6955a());
                if (m6955a() != viewerModel) {
                    graphQLVisitableModel = (RedSpaceFriendPromoteMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4517d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6953a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6955a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -649698231)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: shouldSendReadReceipt */
    public final class RedSpaceFriendViewMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f4522d;

        /* compiled from: shouldSendReadReceipt */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceFriendViewMutationModel.class, new Deserializer());
            }

            public Object m6956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceFriendViewMutationParser.m7012a(jsonParser);
                Object redSpaceFriendViewMutationModel = new RedSpaceFriendViewMutationModel();
                ((BaseModel) redSpaceFriendViewMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceFriendViewMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceFriendViewMutationModel).a();
                }
                return redSpaceFriendViewMutationModel;
            }
        }

        /* compiled from: shouldSendReadReceipt */
        public class Serializer extends JsonSerializer<RedSpaceFriendViewMutationModel> {
            public final void m6957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceFriendViewMutationModel redSpaceFriendViewMutationModel = (RedSpaceFriendViewMutationModel) obj;
                if (redSpaceFriendViewMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceFriendViewMutationModel.m6981a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceFriendViewMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceFriendViewMutationModel.w_();
                int u_ = redSpaceFriendViewMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    RedSpaceFriendViewMutationParser.ViewerParser.m7011a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceFriendViewMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1458437210)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: shouldSendReadReceipt */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private RedspaceModel f4521d;

            /* compiled from: shouldSendReadReceipt */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m6958a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedSpaceFriendViewMutationParser.ViewerParser.m7010a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 213997682)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: shouldSendReadReceipt */
            public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FriendsModel f4520d;

                /* compiled from: shouldSendReadReceipt */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                    }

                    public Object m6959a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RedSpaceFriendViewMutationParser.ViewerParser.RedspaceParser.m7008a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object redspaceModel = new RedspaceModel();
                        ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (redspaceModel instanceof Postprocessable) {
                            return ((Postprocessable) redspaceModel).a();
                        }
                        return redspaceModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1663689988)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: shouldSendReadReceipt */
                public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<NodesModel> f4519d;

                    /* compiled from: shouldSendReadReceipt */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                        }

                        public Object m6960a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RedSpaceFriendViewMutationParser.ViewerParser.RedspaceParser.FriendsParser.m7006a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object friendsModel = new FriendsModel();
                            ((BaseModel) friendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (friendsModel instanceof Postprocessable) {
                                return ((Postprocessable) friendsModel).a();
                            }
                            return friendsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: shouldSendReadReceipt */
                    public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f4518d;

                        /* compiled from: shouldSendReadReceipt */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                            }

                            public Object m6961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(RedSpaceFriendViewMutationParser.ViewerParser.RedspaceParser.FriendsParser.NodesParser.m7005b(jsonParser, flatBufferBuilder));
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

                        /* compiled from: shouldSendReadReceipt */
                        public class Serializer extends JsonSerializer<NodesModel> {
                            public final void m6962a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodesModel nodesModel = (NodesModel) obj;
                                if (nodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodesModel.m6964a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                RedSpaceFriendViewMutationParser.ViewerParser.RedspaceParser.FriendsParser.NodesParser.m7004a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(NodesModel.class, new Serializer());
                            }
                        }

                        public NodesModel() {
                            super(1);
                        }

                        public final void m6967a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m6968a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        private String m6963j() {
                            this.f4518d = super.a(this.f4518d, 0);
                            return this.f4518d;
                        }

                        @Nullable
                        public final String m6966a() {
                            return m6963j();
                        }

                        public final int jK_() {
                            return 2645995;
                        }

                        public final GraphQLVisitableModel m6965a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m6964a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m6963j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: shouldSendReadReceipt */
                    public class Serializer extends JsonSerializer<FriendsModel> {
                        public final void m6969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            FriendsModel friendsModel = (FriendsModel) obj;
                            if (friendsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(friendsModel.m6970a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RedSpaceFriendViewMutationParser.ViewerParser.RedspaceParser.FriendsParser.m7007a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(FriendsModel.class, new Serializer());
                        }
                    }

                    public FriendsModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<NodesModel> m6972a() {
                        this.f4519d = super.a(this.f4519d, 0, NodesModel.class);
                        return (ImmutableList) this.f4519d;
                    }

                    public final int jK_() {
                        return -596919362;
                    }

                    public final GraphQLVisitableModel m6971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6972a() != null) {
                            Builder a = ModelHelper.a(m6972a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (FriendsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4519d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6970a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6972a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: shouldSendReadReceipt */
                public class Serializer extends JsonSerializer<RedspaceModel> {
                    public final void m6973a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RedspaceModel redspaceModel = (RedspaceModel) obj;
                        if (redspaceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(redspaceModel.m6974a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RedSpaceFriendViewMutationParser.ViewerParser.RedspaceParser.m7009a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                    }
                }

                public RedspaceModel() {
                    super(1);
                }

                @Nullable
                public final FriendsModel m6976a() {
                    this.f4520d = (FriendsModel) super.a(this.f4520d, 0, FriendsModel.class);
                    return this.f4520d;
                }

                public final int jK_() {
                    return 399824597;
                }

                public final GraphQLVisitableModel m6975a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6976a() != null) {
                        FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m6976a());
                        if (m6976a() != friendsModel) {
                            graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4520d = friendsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6974a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6976a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: shouldSendReadReceipt */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m6977a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m6978a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedSpaceFriendViewMutationParser.ViewerParser.m7011a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            public final RedspaceModel m6980a() {
                this.f4521d = (RedspaceModel) super.a(this.f4521d, 0, RedspaceModel.class);
                return this.f4521d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m6979a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6980a() != null) {
                    RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6980a());
                    if (m6980a() != redspaceModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4521d = redspaceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6978a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6980a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RedSpaceFriendViewMutationModel() {
            super(1);
        }

        @Nullable
        public final ViewerModel m6983a() {
            this.f4522d = (ViewerModel) super.a(this.f4522d, 0, ViewerModel.class);
            return this.f4522d;
        }

        public final int jK_() {
            return -423706648;
        }

        public final GraphQLVisitableModel m6982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6983a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m6983a());
                if (m6983a() != viewerModel) {
                    graphQLVisitableModel = (RedSpaceFriendViewMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4522d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6981a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6983a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: shouldSendReadReceipt */
    public final class RedSpaceHomeViewMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4523d;

        /* compiled from: shouldSendReadReceipt */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceHomeViewMutationModel.class, new Deserializer());
            }

            public Object m6984a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceHomeViewMutationParser.m7013a(jsonParser);
                Object redSpaceHomeViewMutationModel = new RedSpaceHomeViewMutationModel();
                ((BaseModel) redSpaceHomeViewMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceHomeViewMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceHomeViewMutationModel).a();
                }
                return redSpaceHomeViewMutationModel;
            }
        }

        /* compiled from: shouldSendReadReceipt */
        public class Serializer extends JsonSerializer<RedSpaceHomeViewMutationModel> {
            public final void m6985a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceHomeViewMutationModel redSpaceHomeViewMutationModel = (RedSpaceHomeViewMutationModel) obj;
                if (redSpaceHomeViewMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceHomeViewMutationModel.m6987a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceHomeViewMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceHomeViewMutationModel.w_();
                int u_ = redSpaceHomeViewMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceHomeViewMutationModel.class, new Serializer());
            }
        }

        public RedSpaceHomeViewMutationModel() {
            super(1);
        }

        @Nullable
        private String m6986a() {
            this.f4523d = super.a(this.f4523d, 0);
            return this.f4523d;
        }

        public final int jK_() {
            return -1447897516;
        }

        public final GraphQLVisitableModel m6988a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6987a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6986a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: shouldSendReadReceipt */
    public final class RedSpaceSelfViewMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4524d;

        /* compiled from: shouldSendReadReceipt */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceSelfViewMutationModel.class, new Deserializer());
            }

            public Object m6989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceSelfViewMutationParser.m7014a(jsonParser);
                Object redSpaceSelfViewMutationModel = new RedSpaceSelfViewMutationModel();
                ((BaseModel) redSpaceSelfViewMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceSelfViewMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceSelfViewMutationModel).a();
                }
                return redSpaceSelfViewMutationModel;
            }
        }

        /* compiled from: shouldSendReadReceipt */
        public class Serializer extends JsonSerializer<RedSpaceSelfViewMutationModel> {
            public final void m6990a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceSelfViewMutationModel redSpaceSelfViewMutationModel = (RedSpaceSelfViewMutationModel) obj;
                if (redSpaceSelfViewMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceSelfViewMutationModel.m6992a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceSelfViewMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceSelfViewMutationModel.w_();
                int u_ = redSpaceSelfViewMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceSelfViewMutationModel.class, new Serializer());
            }
        }

        public RedSpaceSelfViewMutationModel() {
            super(1);
        }

        @Nullable
        private String m6991a() {
            this.f4524d = super.a(this.f4524d, 0);
            return this.f4524d;
        }

        public final int jK_() {
            return 1940128455;
        }

        public final GraphQLVisitableModel m6993a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6992a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6991a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
