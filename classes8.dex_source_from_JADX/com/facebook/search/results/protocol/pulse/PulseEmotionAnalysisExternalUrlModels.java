package com.facebook.search.results.protocol.pulse;

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
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlInterfaces.PulseEmotionAnalysisExternalUrl;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser.EmotionalAnalysisParser;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser.EmotionalAnalysisParser.EmotionsParser;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser.EmotionalAnalysisParser.EmotionsParser.EdgesParser;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser.EmotionalAnalysisParser.EmotionsParser.EdgesParser.NodeParser;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser.EmotionalAnalysisParser.EmotionsParser.EdgesParser.NodeParser.IconImageParser;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser.EmotionalAnalysisParser.EmotionsParser.EdgesParser.NodeParser.MoodPageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: messenger_hscroll */
public class PulseEmotionAnalysisExternalUrlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1438551109)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_hscroll */
    public final class PulseEmotionAnalysisExternalUrlModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PulseEmotionAnalysisExternalUrl {
        @Nullable
        private EmotionalAnalysisModel f8745d;
        @Nullable
        private String f8746e;

        /* compiled from: messenger_hscroll */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PulseEmotionAnalysisExternalUrlModel.class, new Deserializer());
            }

            public Object m10221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PulseEmotionAnalysisExternalUrlParser.m10287a(jsonParser);
                Object pulseEmotionAnalysisExternalUrlModel = new PulseEmotionAnalysisExternalUrlModel();
                ((BaseModel) pulseEmotionAnalysisExternalUrlModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pulseEmotionAnalysisExternalUrlModel instanceof Postprocessable) {
                    return ((Postprocessable) pulseEmotionAnalysisExternalUrlModel).a();
                }
                return pulseEmotionAnalysisExternalUrlModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1393354922)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messenger_hscroll */
        public final class EmotionalAnalysisModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EmotionsModel f8744d;

            /* compiled from: messenger_hscroll */
            public final class Builder {
                @Nullable
                public EmotionsModel f8727a;
            }

            /* compiled from: messenger_hscroll */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EmotionalAnalysisModel.class, new Deserializer());
                }

                public Object m10222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EmotionalAnalysisParser.m10285a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object emotionalAnalysisModel = new EmotionalAnalysisModel();
                    ((BaseModel) emotionalAnalysisModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (emotionalAnalysisModel instanceof Postprocessable) {
                        return ((Postprocessable) emotionalAnalysisModel).a();
                    }
                    return emotionalAnalysisModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1119903194)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: messenger_hscroll */
            public final class EmotionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f8743d;

                /* compiled from: messenger_hscroll */
                public final class Builder {
                    @Nullable
                    public ImmutableList<EdgesModel> f8728a;
                }

                /* compiled from: messenger_hscroll */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EmotionsModel.class, new Deserializer());
                    }

                    public Object m10223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EmotionsParser.m10283a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object emotionsModel = new EmotionsModel();
                        ((BaseModel) emotionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (emotionsModel instanceof Postprocessable) {
                            return ((Postprocessable) emotionsModel).a();
                        }
                        return emotionsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -104299473)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: messenger_hscroll */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f8742d;

                    /* compiled from: messenger_hscroll */
                    public final class Builder {
                        @Nullable
                        public NodeModel f8729a;
                    }

                    /* compiled from: messenger_hscroll */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m10224a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m10281b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 1046719401)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: messenger_hscroll */
                    public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                        private int f8739d;
                        @Nullable
                        private IconImageModel f8740e;
                        @Nullable
                        private MoodPageModel f8741f;

                        /* compiled from: messenger_hscroll */
                        public final class Builder {
                            public int f8730a;
                            @Nullable
                            public IconImageModel f8731b;
                            @Nullable
                            public MoodPageModel f8732c;
                        }

                        /* compiled from: messenger_hscroll */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m10225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m10279a(jsonParser, flatBufferBuilder));
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
                        /* compiled from: messenger_hscroll */
                        public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f8734d;

                            /* compiled from: messenger_hscroll */
                            public final class Builder {
                                @Nullable
                                public String f8733a;
                            }

                            /* compiled from: messenger_hscroll */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                                }

                                public Object m10226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(IconImageParser.m10275a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object iconImageModel = new IconImageModel();
                                    ((BaseModel) iconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (iconImageModel instanceof Postprocessable) {
                                        return ((Postprocessable) iconImageModel).a();
                                    }
                                    return iconImageModel;
                                }
                            }

                            /* compiled from: messenger_hscroll */
                            public class Serializer extends JsonSerializer<IconImageModel> {
                                public final void m10227a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    IconImageModel iconImageModel = (IconImageModel) obj;
                                    if (iconImageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(iconImageModel.m10229a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    IconImageParser.m10276a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(IconImageModel.class, new Serializer());
                                }
                            }

                            public IconImageModel() {
                                super(1);
                            }

                            public IconImageModel(MutableFlatBuffer mutableFlatBuffer) {
                                super(1);
                                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }

                            @Nullable
                            public final String m10231a() {
                                this.f8734d = super.a(this.f8734d, 0);
                                return this.f8734d;
                            }

                            public static IconImageModel m10228a(IconImageModel iconImageModel) {
                                if (iconImageModel == null) {
                                    return null;
                                }
                                if (iconImageModel instanceof IconImageModel) {
                                    return iconImageModel;
                                }
                                Builder builder = new Builder();
                                builder.f8733a = iconImageModel.m10231a();
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int b = flatBufferBuilder.b(builder.f8733a);
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new IconImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m10230a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m10229a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m10231a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1185712657)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: messenger_hscroll */
                        public final class MoodPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                            @Nullable
                            private String f8737d;
                            @Nullable
                            private String f8738e;

                            /* compiled from: messenger_hscroll */
                            public final class Builder {
                                @Nullable
                                public String f8735a;
                                @Nullable
                                public String f8736b;
                            }

                            /* compiled from: messenger_hscroll */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MoodPageModel.class, new Deserializer());
                                }

                                public Object m10232a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MoodPageParser.m10277a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object moodPageModel = new MoodPageModel();
                                    ((BaseModel) moodPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (moodPageModel instanceof Postprocessable) {
                                        return ((Postprocessable) moodPageModel).a();
                                    }
                                    return moodPageModel;
                                }
                            }

                            /* compiled from: messenger_hscroll */
                            public class Serializer extends JsonSerializer<MoodPageModel> {
                                public final void m10233a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MoodPageModel moodPageModel = (MoodPageModel) obj;
                                    if (moodPageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(moodPageModel.m10235a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        moodPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MoodPageParser.m10278a(moodPageModel.w_(), moodPageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(MoodPageModel.class, new Serializer());
                                }
                            }

                            public MoodPageModel() {
                                super(2);
                            }

                            public MoodPageModel(MutableFlatBuffer mutableFlatBuffer) {
                                super(2);
                                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }

                            public final void m10238a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m10239a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            public final String m10240b() {
                                this.f8737d = super.a(this.f8737d, 0);
                                return this.f8737d;
                            }

                            @Nullable
                            public final String m10241c() {
                                this.f8738e = super.a(this.f8738e, 1);
                                return this.f8738e;
                            }

                            public static MoodPageModel m10234a(MoodPageModel moodPageModel) {
                                if (moodPageModel == null) {
                                    return null;
                                }
                                if (moodPageModel instanceof MoodPageModel) {
                                    return moodPageModel;
                                }
                                Builder builder = new Builder();
                                builder.f8735a = moodPageModel.m10240b();
                                builder.f8736b = moodPageModel.m10241c();
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int b = flatBufferBuilder.b(builder.f8735a);
                                int b2 = flatBufferBuilder.b(builder.f8736b);
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, b2);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new MoodPageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }

                            @Nullable
                            public final String m10237a() {
                                return m10240b();
                            }

                            public final int jK_() {
                                return 2479791;
                            }

                            public final GraphQLVisitableModel m10236a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m10235a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m10240b());
                                int b2 = flatBufferBuilder.b(m10241c());
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, b2);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: messenger_hscroll */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m10242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m10247a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m10280a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ IconImageModel m10250b() {
                            return m10244j();
                        }

                        @Nullable
                        public final /* synthetic */ MoodPageModel m10251c() {
                            return m10245k();
                        }

                        public NodeModel() {
                            super(3);
                        }

                        public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(3);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        public final int m10246a() {
                            a(0, 0);
                            return this.f8739d;
                        }

                        @Nullable
                        private IconImageModel m10244j() {
                            this.f8740e = (IconImageModel) super.a(this.f8740e, 1, IconImageModel.class);
                            return this.f8740e;
                        }

                        @Nullable
                        private MoodPageModel m10245k() {
                            this.f8741f = (MoodPageModel) super.a(this.f8741f, 2, MoodPageModel.class);
                            return this.f8741f;
                        }

                        public static NodeModel m10243a(NodeModel nodeModel) {
                            if (nodeModel == null) {
                                return null;
                            }
                            if (nodeModel instanceof NodeModel) {
                                return nodeModel;
                            }
                            Builder builder = new Builder();
                            builder.f8730a = nodeModel.m10246a();
                            builder.f8731b = IconImageModel.m10228a(nodeModel.m10250b());
                            builder.f8732c = MoodPageModel.m10234a(nodeModel.m10251c());
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, builder.f8731b);
                            int a2 = ModelHelper.a(flatBufferBuilder, builder.f8732c);
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.a(0, builder.f8730a, 0);
                            flatBufferBuilder.b(1, a);
                            flatBufferBuilder.b(2, a2);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }

                        public final int jK_() {
                            return -1707999019;
                        }

                        public final GraphQLVisitableModel m10248a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m10244j() != null) {
                                IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m10244j());
                                if (m10244j() != iconImageModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f8740e = iconImageModel;
                                }
                            }
                            if (m10245k() != null) {
                                MoodPageModel moodPageModel = (MoodPageModel) graphQLModelMutatingVisitor.b(m10245k());
                                if (m10245k() != moodPageModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f8741f = moodPageModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m10247a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m10244j());
                            int a2 = ModelHelper.a(flatBufferBuilder, m10245k());
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.a(0, this.f8739d, 0);
                            flatBufferBuilder.b(1, a);
                            flatBufferBuilder.b(2, a2);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m10249a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f8739d = mutableFlatBuffer.a(i, 0, 0);
                        }
                    }

                    /* compiled from: messenger_hscroll */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m10252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m10255a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m10282b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ NodeModel m10257a() {
                        return m10254j();
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    private NodeModel m10254j() {
                        this.f8742d = (NodeModel) super.a(this.f8742d, 0, NodeModel.class);
                        return this.f8742d;
                    }

                    public static EdgesModel m10253a(EdgesModel edgesModel) {
                        if (edgesModel == null) {
                            return null;
                        }
                        if (edgesModel instanceof EdgesModel) {
                            return edgesModel;
                        }
                        Builder builder = new Builder();
                        builder.f8729a = NodeModel.m10243a(edgesModel.m10257a());
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f8729a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 1727769883;
                    }

                    public final GraphQLVisitableModel m10256a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10254j() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m10254j());
                            if (m10254j() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8742d = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10255a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m10254j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: messenger_hscroll */
                public class Serializer extends JsonSerializer<EmotionsModel> {
                    public final void m10258a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EmotionsModel emotionsModel = (EmotionsModel) obj;
                        if (emotionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(emotionsModel.m10260a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            emotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EmotionsParser.m10284a(emotionsModel.w_(), emotionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EmotionsModel.class, new Serializer());
                    }
                }

                public EmotionsModel() {
                    super(1);
                }

                public EmotionsModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m10262a() {
                    this.f8743d = super.a(this.f8743d, 0, EdgesModel.class);
                    return (ImmutableList) this.f8743d;
                }

                public static EmotionsModel m10259a(EmotionsModel emotionsModel) {
                    if (emotionsModel == null) {
                        return null;
                    }
                    if (emotionsModel instanceof EmotionsModel) {
                        return emotionsModel;
                    }
                    Builder builder = new Builder();
                    com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (int i = 0; i < emotionsModel.m10262a().size(); i++) {
                        builder2.c(EdgesModel.m10253a((EdgesModel) emotionsModel.m10262a().get(i)));
                    }
                    builder.f8728a = builder2.b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f8728a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EmotionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 78593980;
                }

                public final GraphQLVisitableModel m10261a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10262a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10262a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (EmotionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8743d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10260a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10262a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: messenger_hscroll */
            public class Serializer extends JsonSerializer<EmotionalAnalysisModel> {
                public final void m10263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EmotionalAnalysisModel emotionalAnalysisModel = (EmotionalAnalysisModel) obj;
                    if (emotionalAnalysisModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(emotionalAnalysisModel.m10266a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        emotionalAnalysisModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EmotionalAnalysisParser.m10286a(emotionalAnalysisModel.w_(), emotionalAnalysisModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EmotionalAnalysisModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EmotionsModel m10268a() {
                return m10265j();
            }

            public EmotionalAnalysisModel() {
                super(1);
            }

            public EmotionalAnalysisModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private EmotionsModel m10265j() {
                this.f8744d = (EmotionsModel) super.a(this.f8744d, 0, EmotionsModel.class);
                return this.f8744d;
            }

            public static EmotionalAnalysisModel m10264a(EmotionalAnalysisModel emotionalAnalysisModel) {
                if (emotionalAnalysisModel == null) {
                    return null;
                }
                if (emotionalAnalysisModel instanceof EmotionalAnalysisModel) {
                    return emotionalAnalysisModel;
                }
                Builder builder = new Builder();
                builder.f8727a = EmotionsModel.m10259a(emotionalAnalysisModel.m10268a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8727a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EmotionalAnalysisModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 520958626;
            }

            public final GraphQLVisitableModel m10267a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10265j() != null) {
                    EmotionsModel emotionsModel = (EmotionsModel) graphQLModelMutatingVisitor.b(m10265j());
                    if (m10265j() != emotionsModel) {
                        graphQLVisitableModel = (EmotionalAnalysisModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8744d = emotionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10266a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10265j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: messenger_hscroll */
        public class Serializer extends JsonSerializer<PulseEmotionAnalysisExternalUrlModel> {
            public final void m10269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PulseEmotionAnalysisExternalUrlModel pulseEmotionAnalysisExternalUrlModel = (PulseEmotionAnalysisExternalUrlModel) obj;
                if (pulseEmotionAnalysisExternalUrlModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pulseEmotionAnalysisExternalUrlModel.m10272a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pulseEmotionAnalysisExternalUrlModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pulseEmotionAnalysisExternalUrlModel.w_();
                int u_ = pulseEmotionAnalysisExternalUrlModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("emotional_analysis");
                    EmotionalAnalysisParser.m10286a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PulseEmotionAnalysisExternalUrlModel.class, new Serializer());
            }
        }

        public PulseEmotionAnalysisExternalUrlModel() {
            super(2);
        }

        @Nullable
        private EmotionalAnalysisModel m10270j() {
            this.f8745d = (EmotionalAnalysisModel) super.a(this.f8745d, 0, EmotionalAnalysisModel.class);
            return this.f8745d;
        }

        @Nullable
        private String m10271k() {
            this.f8746e = super.a(this.f8746e, 1);
            return this.f8746e;
        }

        @Nullable
        public final String m10274a() {
            return m10271k();
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m10273a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10270j() != null) {
                EmotionalAnalysisModel emotionalAnalysisModel = (EmotionalAnalysisModel) graphQLModelMutatingVisitor.b(m10270j());
                if (m10270j() != emotionalAnalysisModel) {
                    graphQLVisitableModel = (PulseEmotionAnalysisExternalUrlModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8745d = emotionalAnalysisModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10272a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10270j());
            int b = flatBufferBuilder.b(m10271k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
