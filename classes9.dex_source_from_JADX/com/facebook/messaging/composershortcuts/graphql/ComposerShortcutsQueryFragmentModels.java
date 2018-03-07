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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.composershortcuts.graphql.ComposerShortcutsQueryFragmentParsers.ComposerShortcutsQueryFragmentParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerShortcutsQueryFragmentParsers.ComposerShortcutsQueryFragmentParser.AppsParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerShortcutsQueryFragmentParsers.ComposerShortcutsQueryFragmentParser.AppsParser.EdgesParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerShortcutsQueryFragmentParsers.ComposerShortcutsQueryFragmentParser.AppsParser.EdgesParser.NodeParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerShortcutsQueryFragmentParsers.ComposerShortcutsQueryFragmentParser.AppsParser.EdgesParser.NodeParser.IconParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerShortcutsQueryFragmentParsers.ComposerShortcutsQueryFragmentParser.AppsParser.EdgesParser.NodeParser.SampleContentParser;
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

/* compiled from: message_cap */
public class ComposerShortcutsQueryFragmentModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -331321045)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: message_cap */
    public final class ComposerShortcutsQueryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AppsModel f10186d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1057057844)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: message_cap */
        public final class AppsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10185d;

            /* compiled from: message_cap */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AppsModel.class, new Deserializer());
                }

                public Object m10646a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AppsParser.m10691a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -454178581)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: message_cap */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10184d;

                /* compiled from: message_cap */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m10647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m10689b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 971954455)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: message_cap */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f10178d;
                    @Nullable
                    private String f10179e;
                    @Nullable
                    private List<IconModel> f10180f;
                    @Nullable
                    private String f10181g;
                    @Nullable
                    private List<SampleContentModel> f10182h;
                    @Nullable
                    private String f10183i;

                    /* compiled from: message_cap */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m10648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m10687a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 694697592)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: message_cap */
                    public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                        private int f10174d;
                        @Nullable
                        private String f10175e;
                        private int f10176f;

                        /* compiled from: message_cap */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                            }

                            public Object m10649a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(IconParser.m10683b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object iconModel = new IconModel();
                                ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (iconModel instanceof Postprocessable) {
                                    return ((Postprocessable) iconModel).a();
                                }
                                return iconModel;
                            }
                        }

                        /* compiled from: message_cap */
                        public class Serializer extends JsonSerializer<IconModel> {
                            public final void m10650a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                IconModel iconModel = (IconModel) obj;
                                if (iconModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(iconModel.m10652a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                IconParser.m10682a(iconModel.w_(), iconModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(IconModel.class, new Serializer());
                            }
                        }

                        public IconModel() {
                            super(3);
                        }

                        @Nullable
                        private String m10651a() {
                            this.f10175e = super.a(this.f10175e, 1);
                            return this.f10175e;
                        }

                        public final int jK_() {
                            return -1662459061;
                        }

                        public final GraphQLVisitableModel m10653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m10652a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m10651a());
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.a(0, this.f10174d, 0);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.a(2, this.f10176f, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m10654a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f10174d = mutableFlatBuffer.a(i, 0, 0);
                            this.f10176f = mutableFlatBuffer.a(i, 2, 0);
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -870599469)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: message_cap */
                    public final class SampleContentModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f10177d;

                        /* compiled from: message_cap */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(SampleContentModel.class, new Deserializer());
                            }

                            public Object m10655a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(SampleContentParser.m10686b(jsonParser, flatBufferBuilder));
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

                        /* compiled from: message_cap */
                        public class Serializer extends JsonSerializer<SampleContentModel> {
                            public final void m10656a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                SampleContentModel sampleContentModel = (SampleContentModel) obj;
                                if (sampleContentModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(sampleContentModel.m10658a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    sampleContentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                SampleContentParser.m10685a(sampleContentModel.w_(), sampleContentModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(SampleContentModel.class, new Serializer());
                            }
                        }

                        public SampleContentModel() {
                            super(1);
                        }

                        @Nullable
                        private String m10657a() {
                            this.f10177d = super.a(this.f10177d, 0);
                            return this.f10177d;
                        }

                        public final int jK_() {
                            return -1156662205;
                        }

                        public final GraphQLVisitableModel m10659a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m10658a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m10657a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: message_cap */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m10660a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m10667a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m10688a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(6);
                    }

                    @Nullable
                    private String m10661a() {
                        this.f10178d = super.a(this.f10178d, 0);
                        return this.f10178d;
                    }

                    @Nullable
                    private String m10662j() {
                        this.f10179e = super.a(this.f10179e, 1);
                        return this.f10179e;
                    }

                    @Nonnull
                    private ImmutableList<IconModel> m10663k() {
                        this.f10180f = super.a(this.f10180f, 2, IconModel.class);
                        return (ImmutableList) this.f10180f;
                    }

                    @Nullable
                    private String m10664l() {
                        this.f10181g = super.a(this.f10181g, 3);
                        return this.f10181g;
                    }

                    @Nonnull
                    private ImmutableList<SampleContentModel> m10665m() {
                        this.f10182h = super.a(this.f10182h, 4, SampleContentModel.class);
                        return (ImmutableList) this.f10182h;
                    }

                    @Nullable
                    private String m10666n() {
                        this.f10183i = super.a(this.f10183i, 5);
                        return this.f10183i;
                    }

                    public final int jK_() {
                        return 1611416799;
                    }

                    public final GraphQLVisitableModel m10668a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        Builder a;
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10663k() != null) {
                            a = ModelHelper.a(m10663k(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10180f = a.b();
                            }
                        }
                        if (m10665m() != null) {
                            a = ModelHelper.a(m10665m(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10182h = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10667a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m10661a());
                        int b2 = flatBufferBuilder.b(m10662j());
                        int a = ModelHelper.a(flatBufferBuilder, m10663k());
                        int b3 = flatBufferBuilder.b(m10664l());
                        int a2 = ModelHelper.a(flatBufferBuilder, m10665m());
                        int b4 = flatBufferBuilder.b(m10666n());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, a);
                        flatBufferBuilder.b(3, b3);
                        flatBufferBuilder.b(4, a2);
                        flatBufferBuilder.b(5, b4);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: message_cap */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m10669a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m10671a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m10690b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m10670a() {
                    this.f10184d = (NodeModel) super.a(this.f10184d, 0, NodeModel.class);
                    return this.f10184d;
                }

                public final int jK_() {
                    return -1788715670;
                }

                public final GraphQLVisitableModel m10672a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10670a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m10670a());
                        if (m10670a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10184d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10671a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10670a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: message_cap */
            public class Serializer extends JsonSerializer<AppsModel> {
                public final void m10673a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AppsModel appsModel = (AppsModel) obj;
                    if (appsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(appsModel.m10675a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        appsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AppsParser.m10692a(appsModel.w_(), appsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AppsModel.class, new Serializer());
                }
            }

            public AppsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m10674a() {
                this.f10185d = super.a(this.f10185d, 0, EdgesModel.class);
                return (ImmutableList) this.f10185d;
            }

            public final int jK_() {
                return -362923829;
            }

            public final GraphQLVisitableModel m10676a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10674a() != null) {
                    Builder a = ModelHelper.a(m10674a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AppsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10185d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10675a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10674a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: message_cap */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ComposerShortcutsQueryFragmentModel.class, new Deserializer());
            }

            public Object m10677a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ComposerShortcutsQueryFragmentParser.m10693a(jsonParser);
                Object composerShortcutsQueryFragmentModel = new ComposerShortcutsQueryFragmentModel();
                ((BaseModel) composerShortcutsQueryFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (composerShortcutsQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) composerShortcutsQueryFragmentModel).a();
                }
                return composerShortcutsQueryFragmentModel;
            }
        }

        /* compiled from: message_cap */
        public class Serializer extends JsonSerializer<ComposerShortcutsQueryFragmentModel> {
            public final void m10678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ComposerShortcutsQueryFragmentModel composerShortcutsQueryFragmentModel = (ComposerShortcutsQueryFragmentModel) obj;
                if (composerShortcutsQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(composerShortcutsQueryFragmentModel.m10680a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    composerShortcutsQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = composerShortcutsQueryFragmentModel.w_();
                int u_ = composerShortcutsQueryFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("apps");
                    AppsParser.m10692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ComposerShortcutsQueryFragmentModel.class, new Serializer());
            }
        }

        public ComposerShortcutsQueryFragmentModel() {
            super(1);
        }

        @Nullable
        private AppsModel m10679a() {
            this.f10186d = (AppsModel) super.a(this.f10186d, 0, AppsModel.class);
            return this.f10186d;
        }

        public final int jK_() {
            return -1278195774;
        }

        public final GraphQLVisitableModel m10681a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10679a() != null) {
                AppsModel appsModel = (AppsModel) graphQLModelMutatingVisitor.b(m10679a());
                if (m10679a() != appsModel) {
                    graphQLVisitableModel = (ComposerShortcutsQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10186d = appsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10680a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10679a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
