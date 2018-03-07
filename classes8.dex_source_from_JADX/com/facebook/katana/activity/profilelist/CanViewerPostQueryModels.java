package com.facebook.katana.activity.profilelist;

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
import com.facebook.katana.activity.profilelist.CanViewerPostQueryParsers.FetchCanViewerPostParser;
import com.facebook.katana.activity.profilelist.CanViewerPostQueryParsers.FetchCanViewerPostParser.FriendsParser;
import com.facebook.katana.activity.profilelist.CanViewerPostQueryParsers.FetchCanViewerPostParser.FriendsParser.NodesParser;
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

/* compiled from: unhandled relative layout param =  */
public class CanViewerPostQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1292188839)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unhandled relative layout param =  */
    public final class FetchCanViewerPostModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1185d;
        @Nullable
        private FriendsModel f1186e;

        /* compiled from: unhandled relative layout param =  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchCanViewerPostModel.class, new Deserializer());
            }

            public Object m1402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchCanViewerPostParser.m1427a(jsonParser);
                Object fetchCanViewerPostModel = new FetchCanViewerPostModel();
                ((BaseModel) fetchCanViewerPostModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchCanViewerPostModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchCanViewerPostModel).a();
                }
                return fetchCanViewerPostModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -560548037)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unhandled relative layout param =  */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1184d;

            /* compiled from: unhandled relative layout param =  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m1403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsParser.m1425a(jsonParser, flatBufferBuilder));
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
            /* compiled from: unhandled relative layout param =  */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f1183d;

                /* compiled from: unhandled relative layout param =  */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m1404a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m1424b(jsonParser, flatBufferBuilder));
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

                /* compiled from: unhandled relative layout param =  */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m1405a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m1406a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m1423a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m1409a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m1410a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m1411j() {
                    this.f1183d = super.a(this.f1183d, 0);
                    return this.f1183d;
                }

                @Nullable
                public final String m1408a() {
                    return m1411j();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m1407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1406a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1411j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: unhandled relative layout param =  */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m1412a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m1413a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsParser.m1426a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m1415a() {
                this.f1184d = super.a(this.f1184d, 0, NodesModel.class);
                return (ImmutableList) this.f1184d;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m1414a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1415a() != null) {
                    Builder a = ModelHelper.a(m1415a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1184d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1413a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1415a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: unhandled relative layout param =  */
        public class Serializer extends JsonSerializer<FetchCanViewerPostModel> {
            public final void m1416a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchCanViewerPostModel fetchCanViewerPostModel = (FetchCanViewerPostModel) obj;
                if (fetchCanViewerPostModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchCanViewerPostModel.m1418a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchCanViewerPostModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchCanViewerPostModel.w_();
                int u_ = fetchCanViewerPostModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FriendsParser.m1426a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchCanViewerPostModel.class, new Serializer());
            }
        }

        public FetchCanViewerPostModel() {
            super(2);
        }

        public final void m1421a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1422a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m1417j() {
            if (this.b != null && this.f1185d == null) {
                this.f1185d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1185d;
        }

        @Nullable
        public final FriendsModel m1420a() {
            this.f1186e = (FriendsModel) super.a(this.f1186e, 1, FriendsModel.class);
            return this.f1186e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m1419a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1420a() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m1420a());
                if (m1420a() != friendsModel) {
                    graphQLVisitableModel = (FetchCanViewerPostModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1186e = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1418a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1417j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1420a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
