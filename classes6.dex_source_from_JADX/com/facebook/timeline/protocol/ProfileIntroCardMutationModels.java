package com.facebook.timeline.protocol;

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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.ProfileIntroCardMutationParsers.ProfileIntroCardBioMutationParser;
import com.facebook.timeline.protocol.ProfileIntroCardMutationParsers.ProfileIntroCardBioMutationParser.ProfileIntroCardParser;
import com.facebook.timeline.protocol.ProfileIntroCardMutationParsers.ProfileIntroCardFavPhotosMutationParser;
import com.facebook.timeline.protocol.ProfileIntroCardMutationParsers.ProfileIntroCardFavPhotosMutationParser.ProfileIntroCardParser.FeaturedPhotosParser;
import com.facebook.timeline.protocol.ProfileIntroCardMutationParsers.ProfileIntroCardFavPhotosMutationParser.ProfileIntroCardParser.FeaturedPhotosParser.EdgesParser;
import com.facebook.timeline.protocol.ProfileIntroCardMutationParsers.ProfileIntroCardFavPhotosMutationParser.ProfileIntroCardParser.FeaturedPhotosParser.EdgesParser.NodeParser;
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

/* compiled from: declined */
public class ProfileIntroCardMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -365592459)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: declined */
    public final class ProfileIntroCardBioMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileIntroCardModel f17842d;

        /* compiled from: declined */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileIntroCardBioMutationModel.class, new Deserializer());
            }

            public Object m26227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileIntroCardBioMutationParser.m26265a(jsonParser);
                Object profileIntroCardBioMutationModel = new ProfileIntroCardBioMutationModel();
                ((BaseModel) profileIntroCardBioMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileIntroCardBioMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) profileIntroCardBioMutationModel).a();
                }
                return profileIntroCardBioMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 374173015)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: declined */
        public final class ProfileIntroCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f17841d;

            /* compiled from: declined */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileIntroCardModel.class, new Deserializer());
                }

                public Object m26228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileIntroCardParser.m26263a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileIntroCardModel = new ProfileIntroCardModel();
                    ((BaseModel) profileIntroCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileIntroCardModel instanceof Postprocessable) {
                        return ((Postprocessable) profileIntroCardModel).a();
                    }
                    return profileIntroCardModel;
                }
            }

            /* compiled from: declined */
            public class Serializer extends JsonSerializer<ProfileIntroCardModel> {
                public final void m26229a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) obj;
                    if (profileIntroCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileIntroCardModel.m26231a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileIntroCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileIntroCardParser.m26264a(profileIntroCardModel.w_(), profileIntroCardModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileIntroCardModel.class, new Serializer());
                }
            }

            public ProfileIntroCardModel() {
                super(1);
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m26230a() {
                this.f17841d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f17841d, 0, DefaultTextWithEntitiesFieldsModel.class);
                return this.f17841d;
            }

            public final int jK_() {
                return 2102913043;
            }

            public final GraphQLVisitableModel m26232a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26230a() != null) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m26230a());
                    if (m26230a() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (ProfileIntroCardModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17841d = defaultTextWithEntitiesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26231a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26230a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: declined */
        public class Serializer extends JsonSerializer<ProfileIntroCardBioMutationModel> {
            public final void m26233a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileIntroCardBioMutationModel profileIntroCardBioMutationModel = (ProfileIntroCardBioMutationModel) obj;
                if (profileIntroCardBioMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileIntroCardBioMutationModel.m26235a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileIntroCardBioMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileIntroCardBioMutationModel.w_();
                int u_ = profileIntroCardBioMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_intro_card");
                    ProfileIntroCardParser.m26264a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileIntroCardBioMutationModel.class, new Serializer());
            }
        }

        public ProfileIntroCardBioMutationModel() {
            super(1);
        }

        @Nullable
        private ProfileIntroCardModel m26234a() {
            this.f17842d = (ProfileIntroCardModel) super.a(this.f17842d, 0, ProfileIntroCardModel.class);
            return this.f17842d;
        }

        public final int jK_() {
            return -1623549250;
        }

        public final GraphQLVisitableModel m26236a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26234a() != null) {
                ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) graphQLModelMutatingVisitor.b(m26234a());
                if (m26234a() != profileIntroCardModel) {
                    graphQLVisitableModel = (ProfileIntroCardBioMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17842d = profileIntroCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26235a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26234a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1689739683)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: declined */
    public final class ProfileIntroCardFavPhotosMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileIntroCardModel f17847d;

        /* compiled from: declined */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileIntroCardFavPhotosMutationModel.class, new Deserializer());
            }

            public Object m26237a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileIntroCardFavPhotosMutationParser.m26274a(jsonParser);
                Object profileIntroCardFavPhotosMutationModel = new ProfileIntroCardFavPhotosMutationModel();
                ((BaseModel) profileIntroCardFavPhotosMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileIntroCardFavPhotosMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) profileIntroCardFavPhotosMutationModel).a();
                }
                return profileIntroCardFavPhotosMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -400624234)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: declined */
        public final class ProfileIntroCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FeaturedPhotosModel f17846d;

            /* compiled from: declined */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileIntroCardModel.class, new Deserializer());
                }

                public Object m26238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileIntroCardFavPhotosMutationParser.ProfileIntroCardParser.m26272a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileIntroCardModel = new ProfileIntroCardModel();
                    ((BaseModel) profileIntroCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileIntroCardModel instanceof Postprocessable) {
                        return ((Postprocessable) profileIntroCardModel).a();
                    }
                    return profileIntroCardModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1330089461)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: declined */
            public final class FeaturedPhotosModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f17845d;

                /* compiled from: declined */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FeaturedPhotosModel.class, new Deserializer());
                    }

                    public Object m26239a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeaturedPhotosParser.m26270a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object featuredPhotosModel = new FeaturedPhotosModel();
                        ((BaseModel) featuredPhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (featuredPhotosModel instanceof Postprocessable) {
                            return ((Postprocessable) featuredPhotosModel).a();
                        }
                        return featuredPhotosModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 714603292)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: declined */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f17844d;

                    /* compiled from: declined */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m26240a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m26268b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: declined */
                    public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f17843d;

                        /* compiled from: declined */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m26241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m26266a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: declined */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m26242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m26244a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m26267a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        public NodeModel() {
                            super(1);
                        }

                        @Nullable
                        private String m26243j() {
                            this.f17843d = super.a(this.f17843d, 0);
                            return this.f17843d;
                        }

                        @Nullable
                        public final String m26246a() {
                            return m26243j();
                        }

                        public final int jK_() {
                            return 77090322;
                        }

                        public final GraphQLVisitableModel m26245a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m26244a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m26243j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: declined */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m26247a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m26249a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m26269b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private NodeModel m26248a() {
                        this.f17844d = (NodeModel) super.a(this.f17844d, 0, NodeModel.class);
                        return this.f17844d;
                    }

                    public final int jK_() {
                        return -517732833;
                    }

                    public final GraphQLVisitableModel m26250a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m26248a() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m26248a());
                            if (m26248a() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f17844d = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m26249a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m26248a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: declined */
                public class Serializer extends JsonSerializer<FeaturedPhotosModel> {
                    public final void m26251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FeaturedPhotosModel featuredPhotosModel = (FeaturedPhotosModel) obj;
                        if (featuredPhotosModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(featuredPhotosModel.m26253a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            featuredPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeaturedPhotosParser.m26271a(featuredPhotosModel.w_(), featuredPhotosModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FeaturedPhotosModel.class, new Serializer());
                    }
                }

                public FeaturedPhotosModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<EdgesModel> m26252a() {
                    this.f17845d = super.a(this.f17845d, 0, EdgesModel.class);
                    return (ImmutableList) this.f17845d;
                }

                public final int jK_() {
                    return 520734144;
                }

                public final GraphQLVisitableModel m26254a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m26252a() != null) {
                        Builder a = ModelHelper.a(m26252a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (FeaturedPhotosModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17845d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m26253a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m26252a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: declined */
            public class Serializer extends JsonSerializer<ProfileIntroCardModel> {
                public final void m26255a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) obj;
                    if (profileIntroCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileIntroCardModel.m26257a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileIntroCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileIntroCardFavPhotosMutationParser.ProfileIntroCardParser.m26273a(profileIntroCardModel.w_(), profileIntroCardModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileIntroCardModel.class, new Serializer());
                }
            }

            public ProfileIntroCardModel() {
                super(1);
            }

            @Nullable
            private FeaturedPhotosModel m26256a() {
                this.f17846d = (FeaturedPhotosModel) super.a(this.f17846d, 0, FeaturedPhotosModel.class);
                return this.f17846d;
            }

            public final int jK_() {
                return 2102913043;
            }

            public final GraphQLVisitableModel m26258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26256a() != null) {
                    FeaturedPhotosModel featuredPhotosModel = (FeaturedPhotosModel) graphQLModelMutatingVisitor.b(m26256a());
                    if (m26256a() != featuredPhotosModel) {
                        graphQLVisitableModel = (ProfileIntroCardModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17846d = featuredPhotosModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26257a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26256a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: declined */
        public class Serializer extends JsonSerializer<ProfileIntroCardFavPhotosMutationModel> {
            public final void m26259a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileIntroCardFavPhotosMutationModel profileIntroCardFavPhotosMutationModel = (ProfileIntroCardFavPhotosMutationModel) obj;
                if (profileIntroCardFavPhotosMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileIntroCardFavPhotosMutationModel.m26261a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileIntroCardFavPhotosMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileIntroCardFavPhotosMutationModel.w_();
                int u_ = profileIntroCardFavPhotosMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_intro_card");
                    ProfileIntroCardFavPhotosMutationParser.ProfileIntroCardParser.m26273a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileIntroCardFavPhotosMutationModel.class, new Serializer());
            }
        }

        public ProfileIntroCardFavPhotosMutationModel() {
            super(1);
        }

        @Nullable
        private ProfileIntroCardModel m26260a() {
            this.f17847d = (ProfileIntroCardModel) super.a(this.f17847d, 0, ProfileIntroCardModel.class);
            return this.f17847d;
        }

        public final int jK_() {
            return 2076245727;
        }

        public final GraphQLVisitableModel m26262a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26260a() != null) {
                ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) graphQLModelMutatingVisitor.b(m26260a());
                if (m26260a() != profileIntroCardModel) {
                    graphQLVisitableModel = (ProfileIntroCardFavPhotosMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17847d = profileIntroCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26261a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26260a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
