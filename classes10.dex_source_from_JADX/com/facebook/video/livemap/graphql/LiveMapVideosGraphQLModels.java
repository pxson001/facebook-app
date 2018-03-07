package com.facebook.video.livemap.graphql;

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
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser.NodeParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser.NodeParser.LocationParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser.NodeParser.VideoParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser.NodeParser.VideoParser.CreationStoryParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser.NodeParser.VideoParser.OwnerParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser.NodeParser.VideoParser.SavableDescriptionParser;
import com.facebook.video.livemap.graphql.LiveMapVideosGraphQLParsers.LiveMapVideosQueryParser.VideosParser.EdgesParser.NodeParser.ViewerLocationsParser;
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

/* compiled from: extra_enable_extended_invite */
public class LiveMapVideosGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -528211658)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_enable_extended_invite */
    public final class LiveMapVideosQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideosModel f12963d;

        /* compiled from: extra_enable_extended_invite */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveMapVideosQueryModel.class, new Deserializer());
            }

            public Object m12917a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveMapVideosQueryParser.m13005a(jsonParser);
                Object liveMapVideosQueryModel = new LiveMapVideosQueryModel();
                ((BaseModel) liveMapVideosQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveMapVideosQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) liveMapVideosQueryModel).a();
                }
                return liveMapVideosQueryModel;
            }
        }

        /* compiled from: extra_enable_extended_invite */
        public class Serializer extends JsonSerializer<LiveMapVideosQueryModel> {
            public final void m12918a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveMapVideosQueryModel liveMapVideosQueryModel = (LiveMapVideosQueryModel) obj;
                if (liveMapVideosQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveMapVideosQueryModel.m12984a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveMapVideosQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveMapVideosQueryModel.w_();
                int u_ = liveMapVideosQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("videos");
                    VideosParser.m13004a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveMapVideosQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1500575684)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_enable_extended_invite */
        public final class VideosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f12962d;

            /* compiled from: extra_enable_extended_invite */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideosModel.class, new Deserializer());
                }

                public Object m12919a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideosParser.m13003a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videosModel = new VideosModel();
                    ((BaseModel) videosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videosModel instanceof Postprocessable) {
                        return ((Postprocessable) videosModel).a();
                    }
                    return videosModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -386835228)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_enable_extended_invite */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f12961d;

                /* compiled from: extra_enable_extended_invite */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m12920a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m13001b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -141928728)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: extra_enable_extended_invite */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private LocationModel f12954d;
                    @Nullable
                    private String f12955e;
                    @Nullable
                    private String f12956f;
                    @Nullable
                    private String f12957g;
                    @Nullable
                    private VideoModel f12958h;
                    private int f12959i;
                    @Nullable
                    private List<ViewerLocationsModel> f12960j;

                    /* compiled from: extra_enable_extended_invite */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m12921a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m12999a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 918622653)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: extra_enable_extended_invite */
                    public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                        private double f12934d;
                        private double f12935e;

                        /* compiled from: extra_enable_extended_invite */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                            }

                            public Object m12922a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(LocationParser.m12986a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object locationModel = new LocationModel();
                                ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (locationModel instanceof Postprocessable) {
                                    return ((Postprocessable) locationModel).a();
                                }
                                return locationModel;
                            }
                        }

                        /* compiled from: extra_enable_extended_invite */
                        public class Serializer extends JsonSerializer<LocationModel> {
                            public final void m12923a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                LocationModel locationModel = (LocationModel) obj;
                                if (locationModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(locationModel.m12924a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                LocationParser.m12987a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(LocationModel.class, new Serializer());
                            }
                        }

                        public LocationModel() {
                            super(2);
                        }

                        public final int jK_() {
                            return 1965687765;
                        }

                        public final GraphQLVisitableModel m12925a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m12924a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, this.f12934d, 0.0d);
                            flatBufferBuilder.a(1, this.f12935e, 0.0d);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m12926a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f12934d = mutableFlatBuffer.a(i, 0, 0.0d);
                            this.f12935e = mutableFlatBuffer.a(i, 1, 0.0d);
                        }
                    }

                    /* compiled from: extra_enable_extended_invite */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m12927a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m12972a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m13000a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -514483882)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: extra_enable_extended_invite */
                    public final class VideoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        private long f12940d;
                        @Nullable
                        private CreationStoryModel f12941e;
                        private int f12942f;
                        @Nullable
                        private String f12943g;
                        private boolean f12944h;
                        private boolean f12945i;
                        @Nullable
                        private OwnerModel f12946j;
                        private int f12947k;
                        @Nullable
                        private String f12948l;
                        @Nullable
                        private SavableDescriptionModel f12949m;
                        @Nullable
                        private String f12950n;
                        private int f12951o;

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 1801334754)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: extra_enable_extended_invite */
                        public final class CreationStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                            @Nullable
                            private String f12936d;

                            /* compiled from: extra_enable_extended_invite */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(CreationStoryModel.class, new Deserializer());
                                }

                                public Object m12928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(CreationStoryParser.m12988a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object creationStoryModel = new CreationStoryModel();
                                    ((BaseModel) creationStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (creationStoryModel instanceof Postprocessable) {
                                        return ((Postprocessable) creationStoryModel).a();
                                    }
                                    return creationStoryModel;
                                }
                            }

                            /* compiled from: extra_enable_extended_invite */
                            public class Serializer extends JsonSerializer<CreationStoryModel> {
                                public final void m12929a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    CreationStoryModel creationStoryModel = (CreationStoryModel) obj;
                                    if (creationStoryModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(creationStoryModel.m12931a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        creationStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    CreationStoryParser.m12989a(creationStoryModel.w_(), creationStoryModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(CreationStoryModel.class, new Serializer());
                                }
                            }

                            public CreationStoryModel() {
                                super(1);
                            }

                            public final void m12934a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m12935a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            private String m12930j() {
                                this.f12936d = super.a(this.f12936d, 0);
                                return this.f12936d;
                            }

                            @Nullable
                            public final String m12933a() {
                                return m12930j();
                            }

                            public final int jK_() {
                                return 80218325;
                            }

                            public final GraphQLVisitableModel m12932a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m12931a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m12930j());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: extra_enable_extended_invite */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(VideoModel.class, new Deserializer());
                            }

                            public Object m12936a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(VideoParser.m12994a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object videoModel = new VideoModel();
                                ((BaseModel) videoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (videoModel instanceof Postprocessable) {
                                    return ((Postprocessable) videoModel).a();
                                }
                                return videoModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -341630258)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: extra_enable_extended_invite */
                        public final class OwnerModel extends BaseModel implements GraphQLVisitableConsistentModel {
                            @Nullable
                            private GraphQLObjectType f12937d;
                            @Nullable
                            private String f12938e;

                            /* compiled from: extra_enable_extended_invite */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                                }

                                public Object m12937a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(OwnerParser.m12990a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object ownerModel = new OwnerModel();
                                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (ownerModel instanceof Postprocessable) {
                                        return ((Postprocessable) ownerModel).a();
                                    }
                                    return ownerModel;
                                }
                            }

                            /* compiled from: extra_enable_extended_invite */
                            public class Serializer extends JsonSerializer<OwnerModel> {
                                public final void m12938a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    OwnerModel ownerModel = (OwnerModel) obj;
                                    if (ownerModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(ownerModel.m12941a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    OwnerParser.m12991a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                                }
                            }

                            public OwnerModel() {
                                super(2);
                            }

                            public final void m12943a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m12944a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            private GraphQLObjectType m12939a() {
                                if (this.b != null && this.f12937d == null) {
                                    this.f12937d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                }
                                return this.f12937d;
                            }

                            @Nullable
                            private String m12940j() {
                                this.f12938e = super.a(this.f12938e, 1);
                                return this.f12938e;
                            }

                            public final int jK_() {
                                return 63093205;
                            }

                            public final GraphQLVisitableModel m12942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m12941a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m12939a());
                                int b = flatBufferBuilder.b(m12940j());
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1352864475)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: extra_enable_extended_invite */
                        public final class SavableDescriptionModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f12939d;

                            /* compiled from: extra_enable_extended_invite */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(SavableDescriptionModel.class, new Deserializer());
                                }

                                public Object m12945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(SavableDescriptionParser.m12992a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object savableDescriptionModel = new SavableDescriptionModel();
                                    ((BaseModel) savableDescriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (savableDescriptionModel instanceof Postprocessable) {
                                        return ((Postprocessable) savableDescriptionModel).a();
                                    }
                                    return savableDescriptionModel;
                                }
                            }

                            /* compiled from: extra_enable_extended_invite */
                            public class Serializer extends JsonSerializer<SavableDescriptionModel> {
                                public final void m12946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    SavableDescriptionModel savableDescriptionModel = (SavableDescriptionModel) obj;
                                    if (savableDescriptionModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(savableDescriptionModel.m12948a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        savableDescriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    SavableDescriptionParser.m12993a(savableDescriptionModel.w_(), savableDescriptionModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(SavableDescriptionModel.class, new Serializer());
                                }
                            }

                            public SavableDescriptionModel() {
                                super(1);
                            }

                            @Nullable
                            private String m12947a() {
                                this.f12939d = super.a(this.f12939d, 0);
                                return this.f12939d;
                            }

                            public final int jK_() {
                                return -1919764332;
                            }

                            public final GraphQLVisitableModel m12949a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m12948a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m12947a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: extra_enable_extended_invite */
                        public class Serializer extends JsonSerializer<VideoModel> {
                            public final void m12950a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                VideoModel videoModel = (VideoModel) obj;
                                if (videoModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(videoModel.m12957a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    videoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                VideoParser.m12995a(videoModel.w_(), videoModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(VideoModel.class, new Serializer());
                            }
                        }

                        public VideoModel() {
                            super(12);
                        }

                        @Nullable
                        private CreationStoryModel m12951j() {
                            this.f12941e = (CreationStoryModel) super.a(this.f12941e, 1, CreationStoryModel.class);
                            return this.f12941e;
                        }

                        @Nullable
                        private String m12952k() {
                            this.f12943g = super.a(this.f12943g, 3);
                            return this.f12943g;
                        }

                        @Nullable
                        private OwnerModel m12953l() {
                            this.f12946j = (OwnerModel) super.a(this.f12946j, 6, OwnerModel.class);
                            return this.f12946j;
                        }

                        @Nullable
                        private String m12954m() {
                            this.f12948l = super.a(this.f12948l, 8);
                            return this.f12948l;
                        }

                        @Nullable
                        private SavableDescriptionModel m12955n() {
                            this.f12949m = (SavableDescriptionModel) super.a(this.f12949m, 9, SavableDescriptionModel.class);
                            return this.f12949m;
                        }

                        @Nullable
                        private String m12956o() {
                            this.f12950n = super.a(this.f12950n, 10);
                            return this.f12950n;
                        }

                        @Nullable
                        public final String m12959a() {
                            return m12952k();
                        }

                        public final int jK_() {
                            return 82650203;
                        }

                        public final GraphQLVisitableModel m12958a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m12951j() != null) {
                                CreationStoryModel creationStoryModel = (CreationStoryModel) graphQLModelMutatingVisitor.b(m12951j());
                                if (m12951j() != creationStoryModel) {
                                    graphQLVisitableModel = (VideoModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f12941e = creationStoryModel;
                                }
                            }
                            if (m12953l() != null) {
                                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m12953l());
                                if (m12953l() != ownerModel) {
                                    graphQLVisitableModel = (VideoModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f12946j = ownerModel;
                                }
                            }
                            if (m12955n() != null) {
                                SavableDescriptionModel savableDescriptionModel = (SavableDescriptionModel) graphQLModelMutatingVisitor.b(m12955n());
                                if (m12955n() != savableDescriptionModel) {
                                    graphQLVisitableModel = (VideoModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f12949m = savableDescriptionModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m12957a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m12951j());
                            int b = flatBufferBuilder.b(m12952k());
                            int a2 = ModelHelper.a(flatBufferBuilder, m12953l());
                            int b2 = flatBufferBuilder.b(m12954m());
                            int a3 = ModelHelper.a(flatBufferBuilder, m12955n());
                            int b3 = flatBufferBuilder.b(m12956o());
                            flatBufferBuilder.c(12);
                            flatBufferBuilder.a(0, this.f12940d, 0);
                            flatBufferBuilder.b(1, a);
                            flatBufferBuilder.a(2, this.f12942f, 0);
                            flatBufferBuilder.b(3, b);
                            flatBufferBuilder.a(4, this.f12944h);
                            flatBufferBuilder.a(5, this.f12945i);
                            flatBufferBuilder.b(6, a2);
                            flatBufferBuilder.a(7, this.f12947k, 0);
                            flatBufferBuilder.b(8, b2);
                            flatBufferBuilder.b(9, a3);
                            flatBufferBuilder.b(10, b3);
                            flatBufferBuilder.a(11, this.f12951o, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m12960a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f12940d = mutableFlatBuffer.a(i, 0, 0);
                            this.f12942f = mutableFlatBuffer.a(i, 2, 0);
                            this.f12944h = mutableFlatBuffer.a(i, 4);
                            this.f12945i = mutableFlatBuffer.a(i, 5);
                            this.f12947k = mutableFlatBuffer.a(i, 7, 0);
                            this.f12951o = mutableFlatBuffer.a(i, 11, 0);
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 918622653)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: extra_enable_extended_invite */
                    public final class ViewerLocationsModel extends BaseModel implements GraphQLVisitableModel {
                        private double f12952d;
                        private double f12953e;

                        /* compiled from: extra_enable_extended_invite */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ViewerLocationsModel.class, new Deserializer());
                            }

                            public Object m12961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ViewerLocationsParser.m12998b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object viewerLocationsModel = new ViewerLocationsModel();
                                ((BaseModel) viewerLocationsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (viewerLocationsModel instanceof Postprocessable) {
                                    return ((Postprocessable) viewerLocationsModel).a();
                                }
                                return viewerLocationsModel;
                            }
                        }

                        /* compiled from: extra_enable_extended_invite */
                        public class Serializer extends JsonSerializer<ViewerLocationsModel> {
                            public final void m12962a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ViewerLocationsModel viewerLocationsModel = (ViewerLocationsModel) obj;
                                if (viewerLocationsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(viewerLocationsModel.m12963a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    viewerLocationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ViewerLocationsParser.m12997a(viewerLocationsModel.w_(), viewerLocationsModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ViewerLocationsModel.class, new Serializer());
                            }
                        }

                        public ViewerLocationsModel() {
                            super(2);
                        }

                        public final int jK_() {
                            return 1965687765;
                        }

                        public final GraphQLVisitableModel m12964a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m12963a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, this.f12952d, 0.0d);
                            flatBufferBuilder.a(1, this.f12953e, 0.0d);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m12965a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f12952d = mutableFlatBuffer.a(i, 0, 0.0d);
                            this.f12953e = mutableFlatBuffer.a(i, 1, 0.0d);
                        }
                    }

                    public NodeModel() {
                        super(7);
                    }

                    @Nullable
                    private LocationModel m12966a() {
                        this.f12954d = (LocationModel) super.a(this.f12954d, 0, LocationModel.class);
                        return this.f12954d;
                    }

                    @Nullable
                    private String m12967j() {
                        this.f12955e = super.a(this.f12955e, 1);
                        return this.f12955e;
                    }

                    @Nullable
                    private String m12968k() {
                        this.f12956f = super.a(this.f12956f, 2);
                        return this.f12956f;
                    }

                    @Nullable
                    private String m12969l() {
                        this.f12957g = super.a(this.f12957g, 3);
                        return this.f12957g;
                    }

                    @Nullable
                    private VideoModel m12970m() {
                        this.f12958h = (VideoModel) super.a(this.f12958h, 4, VideoModel.class);
                        return this.f12958h;
                    }

                    @Nonnull
                    private ImmutableList<ViewerLocationsModel> m12971n() {
                        this.f12960j = super.a(this.f12960j, 6, ViewerLocationsModel.class);
                        return (ImmutableList) this.f12960j;
                    }

                    public final int jK_() {
                        return 128592791;
                    }

                    public final GraphQLVisitableModel m12973a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m12966a() != null) {
                            LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m12966a());
                            if (m12966a() != locationModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f12954d = locationModel;
                            }
                        }
                        if (m12970m() != null) {
                            VideoModel videoModel = (VideoModel) graphQLModelMutatingVisitor.b(m12970m());
                            if (m12970m() != videoModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12958h = videoModel;
                            }
                        }
                        if (m12971n() != null) {
                            Builder a = ModelHelper.a(m12971n(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f12960j = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m12972a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m12966a());
                        int b = flatBufferBuilder.b(m12967j());
                        int b2 = flatBufferBuilder.b(m12968k());
                        int b3 = flatBufferBuilder.b(m12969l());
                        int a2 = ModelHelper.a(flatBufferBuilder, m12970m());
                        int a3 = ModelHelper.a(flatBufferBuilder, m12971n());
                        flatBufferBuilder.c(7);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, b2);
                        flatBufferBuilder.b(3, b3);
                        flatBufferBuilder.b(4, a2);
                        flatBufferBuilder.a(5, this.f12959i, 0);
                        flatBufferBuilder.b(6, a3);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m12974a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f12959i = mutableFlatBuffer.a(i, 5, 0);
                    }
                }

                /* compiled from: extra_enable_extended_invite */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m12975a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m12977a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m13002b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m12976a() {
                    this.f12961d = (NodeModel) super.a(this.f12961d, 0, NodeModel.class);
                    return this.f12961d;
                }

                public final int jK_() {
                    return -906153589;
                }

                public final GraphQLVisitableModel m12978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12976a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m12976a());
                        if (m12976a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12961d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12977a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12976a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: extra_enable_extended_invite */
            public class Serializer extends JsonSerializer<VideosModel> {
                public final void m12979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideosModel videosModel = (VideosModel) obj;
                    if (videosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videosModel.m12981a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideosParser.m13004a(videosModel.w_(), videosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideosModel.class, new Serializer());
                }
            }

            public VideosModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m12980a() {
                this.f12962d = super.a(this.f12962d, 0, EdgesModel.class);
                return (ImmutableList) this.f12962d;
            }

            public final int jK_() {
                return 1043836972;
            }

            public final GraphQLVisitableModel m12982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12980a() != null) {
                    Builder a = ModelHelper.a(m12980a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (VideosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12962d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12981a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12980a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public LiveMapVideosQueryModel() {
            super(1);
        }

        @Nullable
        private VideosModel m12983a() {
            this.f12963d = (VideosModel) super.a(this.f12963d, 0, VideosModel.class);
            return this.f12963d;
        }

        public final int jK_() {
            return 1629389184;
        }

        public final GraphQLVisitableModel m12985a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12983a() != null) {
                VideosModel videosModel = (VideosModel) graphQLModelMutatingVisitor.b(m12983a());
                if (m12983a() != videosModel) {
                    graphQLVisitableModel = (LiveMapVideosQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12963d = videosModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12984a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12983a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
