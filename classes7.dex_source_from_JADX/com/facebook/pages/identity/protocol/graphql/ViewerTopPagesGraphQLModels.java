package com.facebook.pages.identity.protocol.graphql;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.identity.protocol.graphql.ViewerTopPagesGraphQLParsers.ViewerTopPagesQueryParser;
import com.facebook.pages.identity.protocol.graphql.ViewerTopPagesGraphQLParsers.ViewerTopPagesQueryParser.FollowedProfilesParser;
import com.facebook.pages.identity.protocol.graphql.ViewerTopPagesGraphQLParsers.ViewerTopPagesQueryParser.FollowedProfilesParser.NodesParser;
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

/* compiled from: max_slider_value */
public class ViewerTopPagesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1872025053)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: max_slider_value */
    public final class ViewerTopPagesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FollowedProfilesModel f9202d;

        /* compiled from: max_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ViewerTopPagesQueryModel.class, new Deserializer());
            }

            public Object m11236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ViewerTopPagesQueryParser.m11259a(jsonParser);
                Object viewerTopPagesQueryModel = new ViewerTopPagesQueryModel();
                ((BaseModel) viewerTopPagesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (viewerTopPagesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) viewerTopPagesQueryModel).a();
                }
                return viewerTopPagesQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 524333418)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: max_slider_value */
        public final class FollowedProfilesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f9201d;

            /* compiled from: max_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FollowedProfilesModel.class, new Deserializer());
                }

                public Object m11237a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FollowedProfilesParser.m11257a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object followedProfilesModel = new FollowedProfilesModel();
                    ((BaseModel) followedProfilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (followedProfilesModel instanceof Postprocessable) {
                        return ((Postprocessable) followedProfilesModel).a();
                    }
                    return followedProfilesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: max_slider_value */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f9199d;
                @Nullable
                private String f9200e;

                /* compiled from: max_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m11238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m11256b(jsonParser, flatBufferBuilder));
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

                /* compiled from: max_slider_value */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m11239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m11241a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m11255a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public final void m11244a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m11245a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m11240j() {
                    if (this.b != null && this.f9199d == null) {
                        this.f9199d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f9199d;
                }

                @Nullable
                public final String m11246b() {
                    this.f9200e = super.a(this.f9200e, 1);
                    return this.f9200e;
                }

                @Nullable
                public final String m11243a() {
                    return m11246b();
                }

                public final int jK_() {
                    return 1355227529;
                }

                public final GraphQLVisitableModel m11242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11241a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11240j());
                    int b = flatBufferBuilder.b(m11246b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: max_slider_value */
            public class Serializer extends JsonSerializer<FollowedProfilesModel> {
                public final void m11247a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) obj;
                    if (followedProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(followedProfilesModel.m11248a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        followedProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FollowedProfilesParser.m11258a(followedProfilesModel.w_(), followedProfilesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FollowedProfilesModel.class, new Serializer());
                }
            }

            public FollowedProfilesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m11250a() {
                this.f9201d = super.a(this.f9201d, 0, NodesModel.class);
                return (ImmutableList) this.f9201d;
            }

            public final int jK_() {
                return -989905224;
            }

            public final GraphQLVisitableModel m11249a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11250a() != null) {
                    Builder a = ModelHelper.a(m11250a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FollowedProfilesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9201d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11248a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11250a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: max_slider_value */
        public class Serializer extends JsonSerializer<ViewerTopPagesQueryModel> {
            public final void m11251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ViewerTopPagesQueryModel viewerTopPagesQueryModel = (ViewerTopPagesQueryModel) obj;
                if (viewerTopPagesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(viewerTopPagesQueryModel.m11252a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    viewerTopPagesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = viewerTopPagesQueryModel.w_();
                int u_ = viewerTopPagesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("followed_profiles");
                    FollowedProfilesParser.m11258a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ViewerTopPagesQueryModel.class, new Serializer());
            }
        }

        public ViewerTopPagesQueryModel() {
            super(1);
        }

        @Nullable
        public final FollowedProfilesModel m11254a() {
            this.f9202d = (FollowedProfilesModel) super.a(this.f9202d, 0, FollowedProfilesModel.class);
            return this.f9202d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11253a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11254a() != null) {
                FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) graphQLModelMutatingVisitor.b(m11254a());
                if (m11254a() != followedProfilesModel) {
                    graphQLVisitableModel = (ViewerTopPagesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9202d = followedProfilesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11252a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11254a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
