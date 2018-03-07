package com.facebook.messaging.composershortcuts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerPlatformMediaType;
import com.facebook.graphql.enums.GraphQLMessengerPlatformResultType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentParsers.SampleContentQueryFragmentParser;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentParsers.SampleContentQueryFragmentParser.AppsParser;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentParsers.SampleContentQueryFragmentParser.AppsParser.EdgesParser;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentParsers.SampleContentQueryFragmentParser.AppsParser.EdgesParser.NodeParser;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentParsers.SampleContentQueryFragmentParser.AppsParser.EdgesParser.NodeParser.SampleContentParser;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentParsers.SampleContentQueryFragmentParser.AppsParser.EdgesParser.NodeParser.SampleContentParser.MediaParser;
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

/* compiled from: message_attachment_preview_images */
public class SampleContentQueryFragmentModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -529282146)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: message_attachment_preview_images */
    public final class SampleContentQueryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AppsModel f10202d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 984993374)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: message_attachment_preview_images */
        public final class AppsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10201d;

            /* compiled from: message_attachment_preview_images */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AppsModel.class, new Deserializer());
                }

                public Object m10696a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AppsParser.m10745a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object appsModel = new AppsModel();
                    ((BaseModel) appsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (appsModel instanceof Postprocessable) {
                        return ((Postprocessable) appsModel).a();
                    }
                    return appsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -836848984)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: message_attachment_preview_images */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10200d;

                /* compiled from: message_attachment_preview_images */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m10697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m10743b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -210939318)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: message_attachment_preview_images */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f10196d;
                    @Nullable
                    private String f10197e;
                    @Nullable
                    private String f10198f;
                    @Nullable
                    private List<SampleContentModel> f10199g;

                    /* compiled from: message_attachment_preview_images */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m10698a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m10741a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 13206015)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: message_attachment_preview_images */
                    public final class SampleContentModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<MediaModel> f10193d;
                        @Nullable
                        private String f10194e;
                        @Nullable
                        private GraphQLMessengerPlatformResultType f10195f;

                        /* compiled from: message_attachment_preview_images */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(SampleContentModel.class, new Deserializer());
                            }

                            public Object m10699a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(SampleContentParser.m10739b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object sampleContentModel = new SampleContentModel();
                                ((BaseModel) sampleContentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (sampleContentModel instanceof Postprocessable) {
                                    return ((Postprocessable) sampleContentModel).a();
                                }
                                return sampleContentModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -838316462)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: message_attachment_preview_images */
                        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                            private int f10187d;
                            @Nullable
                            private GraphQLMessengerPlatformMediaType f10188e;
                            private int f10189f;
                            private int f10190g;
                            @Nullable
                            private String f10191h;
                            private int f10192i;

                            /* compiled from: message_attachment_preview_images */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                                }

                                public Object m10700a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MediaParser.m10738b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object mediaModel = new MediaModel();
                                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (mediaModel instanceof Postprocessable) {
                                        return ((Postprocessable) mediaModel).a();
                                    }
                                    return mediaModel;
                                }
                            }

                            /* compiled from: message_attachment_preview_images */
                            public class Serializer extends JsonSerializer<MediaModel> {
                                public final void m10701a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MediaModel mediaModel = (MediaModel) obj;
                                    if (mediaModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(mediaModel.m10702a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MediaParser.m10737a(mediaModel.w_(), mediaModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                                }
                            }

                            public MediaModel() {
                                super(6);
                            }

                            @Nullable
                            public final GraphQLMessengerPlatformMediaType m10703a() {
                                this.f10188e = (GraphQLMessengerPlatformMediaType) super.b(this.f10188e, 1, GraphQLMessengerPlatformMediaType.class, GraphQLMessengerPlatformMediaType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                return this.f10188e;
                            }

                            public final int m10706b() {
                                a(0, 2);
                                return this.f10189f;
                            }

                            @Nullable
                            public final String m10707c() {
                                this.f10191h = super.a(this.f10191h, 4);
                                return this.f10191h;
                            }

                            public final int m10708d() {
                                a(0, 5);
                                return this.f10192i;
                            }

                            public final int jK_() {
                                return 789339902;
                            }

                            public final GraphQLVisitableModel m10704a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m10702a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = flatBufferBuilder.a(m10703a());
                                int b = flatBufferBuilder.b(m10707c());
                                flatBufferBuilder.c(6);
                                flatBufferBuilder.a(0, this.f10187d, 0);
                                flatBufferBuilder.b(1, a);
                                flatBufferBuilder.a(2, this.f10189f, 0);
                                flatBufferBuilder.a(3, this.f10190g, 0);
                                flatBufferBuilder.b(4, b);
                                flatBufferBuilder.a(5, this.f10192i, 0);
                                i();
                                return flatBufferBuilder.d();
                            }

                            public final void m10705a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                super.a(mutableFlatBuffer, i, obj);
                                this.f10187d = mutableFlatBuffer.a(i, 0, 0);
                                this.f10189f = mutableFlatBuffer.a(i, 2, 0);
                                this.f10190g = mutableFlatBuffer.a(i, 3, 0);
                                this.f10192i = mutableFlatBuffer.a(i, 5, 0);
                            }
                        }

                        /* compiled from: message_attachment_preview_images */
                        public class Serializer extends JsonSerializer<SampleContentModel> {
                            public final void m10709a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                SampleContentModel sampleContentModel = (SampleContentModel) obj;
                                if (sampleContentModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(sampleContentModel.m10710a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    sampleContentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                SampleContentParser.m10740b(sampleContentModel.w_(), sampleContentModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(SampleContentModel.class, new Serializer());
                            }
                        }

                        public SampleContentModel() {
                            super(3);
                        }

                        @Nonnull
                        public final ImmutableList<MediaModel> m10712a() {
                            this.f10193d = super.a(this.f10193d, 0, MediaModel.class);
                            return (ImmutableList) this.f10193d;
                        }

                        @Nullable
                        public final String m10713b() {
                            this.f10194e = super.a(this.f10194e, 1);
                            return this.f10194e;
                        }

                        @Nullable
                        public final GraphQLMessengerPlatformResultType m10714c() {
                            this.f10195f = (GraphQLMessengerPlatformResultType) super.b(this.f10195f, 2, GraphQLMessengerPlatformResultType.class, GraphQLMessengerPlatformResultType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                            return this.f10195f;
                        }

                        public final int jK_() {
                            return -1156662205;
                        }

                        public final GraphQLVisitableModel m10711a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m10712a() != null) {
                                Builder a = ModelHelper.a(m10712a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (SampleContentModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f10193d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m10710a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m10712a());
                            int b = flatBufferBuilder.b(m10713b());
                            int a2 = flatBufferBuilder.a(m10714c());
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.b(2, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: message_attachment_preview_images */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m10715a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m10716a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m10742a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(4);
                    }

                    @Nullable
                    public final String m10718a() {
                        this.f10196d = super.a(this.f10196d, 0);
                        return this.f10196d;
                    }

                    @Nullable
                    public final String m10719b() {
                        this.f10197e = super.a(this.f10197e, 1);
                        return this.f10197e;
                    }

                    @Nullable
                    public final String m10720c() {
                        this.f10198f = super.a(this.f10198f, 2);
                        return this.f10198f;
                    }

                    @Nonnull
                    public final ImmutableList<SampleContentModel> m10721d() {
                        this.f10199g = super.a(this.f10199g, 3, SampleContentModel.class);
                        return (ImmutableList) this.f10199g;
                    }

                    public final int jK_() {
                        return 1611416799;
                    }

                    public final GraphQLVisitableModel m10717a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10721d() != null) {
                            Builder a = ModelHelper.a(m10721d(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10199g = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10716a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m10718a());
                        int b2 = flatBufferBuilder.b(m10719b());
                        int b3 = flatBufferBuilder.b(m10720c());
                        int a = ModelHelper.a(flatBufferBuilder, m10721d());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, b3);
                        flatBufferBuilder.b(3, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: message_attachment_preview_images */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m10722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m10724a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m10744b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NodeModel m10726a() {
                    return m10723j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m10723j() {
                    this.f10200d = (NodeModel) super.a(this.f10200d, 0, NodeModel.class);
                    return this.f10200d;
                }

                public final int jK_() {
                    return -1788715670;
                }

                public final GraphQLVisitableModel m10725a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10723j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m10723j());
                        if (m10723j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10200d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10724a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10723j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: message_attachment_preview_images */
            public class Serializer extends JsonSerializer<AppsModel> {
                public final void m10727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AppsModel appsModel = (AppsModel) obj;
                    if (appsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(appsModel.m10728a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        appsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AppsParser.m10746a(appsModel.w_(), appsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AppsModel.class, new Serializer());
                }
            }

            public AppsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m10730a() {
                this.f10201d = super.a(this.f10201d, 0, EdgesModel.class);
                return (ImmutableList) this.f10201d;
            }

            public final int jK_() {
                return -362923829;
            }

            public final GraphQLVisitableModel m10729a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10730a() != null) {
                    Builder a = ModelHelper.a(m10730a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AppsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10201d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10728a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10730a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: message_attachment_preview_images */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SampleContentQueryFragmentModel.class, new Deserializer());
            }

            public Object m10731a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SampleContentQueryFragmentParser.m10747a(jsonParser);
                Object sampleContentQueryFragmentModel = new SampleContentQueryFragmentModel();
                ((BaseModel) sampleContentQueryFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (sampleContentQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) sampleContentQueryFragmentModel).a();
                }
                return sampleContentQueryFragmentModel;
            }
        }

        /* compiled from: message_attachment_preview_images */
        public class Serializer extends JsonSerializer<SampleContentQueryFragmentModel> {
            public final void m10732a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SampleContentQueryFragmentModel sampleContentQueryFragmentModel = (SampleContentQueryFragmentModel) obj;
                if (sampleContentQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(sampleContentQueryFragmentModel.m10734a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    sampleContentQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = sampleContentQueryFragmentModel.w_();
                int u_ = sampleContentQueryFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("apps");
                    AppsParser.m10746a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SampleContentQueryFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AppsModel m10736a() {
            return m10733j();
        }

        public SampleContentQueryFragmentModel() {
            super(1);
        }

        @Nullable
        private AppsModel m10733j() {
            this.f10202d = (AppsModel) super.a(this.f10202d, 0, AppsModel.class);
            return this.f10202d;
        }

        public final int jK_() {
            return -1278195774;
        }

        public final GraphQLVisitableModel m10735a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10733j() != null) {
                AppsModel appsModel = (AppsModel) graphQLModelMutatingVisitor.b(m10733j());
                if (m10733j() != appsModel) {
                    graphQLVisitableModel = (SampleContentQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10202d = appsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10734a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10733j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
