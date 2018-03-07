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
import com.facebook.messaging.composershortcuts.graphql.ComposerOrderQueryFragmentParsers.ComposerOrderQueryFragmentParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerOrderQueryFragmentParsers.ComposerOrderQueryFragmentParser.MessengerComposerOrderParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerOrderQueryFragmentParsers.ComposerOrderQueryFragmentParser.MessengerComposerOrderParser.EdgesParser;
import com.facebook.messaging.composershortcuts.graphql.ComposerOrderQueryFragmentParsers.ComposerOrderQueryFragmentParser.MessengerComposerOrderParser.EdgesParser.NodeParser;
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

/* compiled from: message_count=0 */
public class ComposerOrderQueryFragmentModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 931536635)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: message_count=0 */
    public final class ComposerOrderQueryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerComposerOrderModel f10173d;

        /* compiled from: message_count=0 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ComposerOrderQueryFragmentModel.class, new Deserializer());
            }

            public Object m10619a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ComposerOrderQueryFragmentParser.m10645a(jsonParser);
                Object composerOrderQueryFragmentModel = new ComposerOrderQueryFragmentModel();
                ((BaseModel) composerOrderQueryFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (composerOrderQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) composerOrderQueryFragmentModel).a();
                }
                return composerOrderQueryFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 331478497)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: message_count=0 */
        public final class MessengerComposerOrderModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10172d;

            /* compiled from: message_count=0 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerComposerOrderModel.class, new Deserializer());
                }

                public Object m10620a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerComposerOrderParser.m10643a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerComposerOrderModel = new MessengerComposerOrderModel();
                    ((BaseModel) messengerComposerOrderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerComposerOrderModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerComposerOrderModel).a();
                    }
                    return messengerComposerOrderModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -108315237)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: message_count=0 */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10171d;

                /* compiled from: message_count=0 */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m10621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m10641b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 273304230)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: message_count=0 */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f10170d;

                    /* compiled from: message_count=0 */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m10622a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m10639a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: message_count=0 */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m10623a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m10625a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m10640a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    @Nullable
                    private String m10624a() {
                        this.f10170d = super.a(this.f10170d, 0);
                        return this.f10170d;
                    }

                    public final int jK_() {
                        return -1932938258;
                    }

                    public final GraphQLVisitableModel m10626a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m10625a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m10624a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: message_count=0 */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m10627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m10629a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m10642b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m10628a() {
                    this.f10171d = (NodeModel) super.a(this.f10171d, 0, NodeModel.class);
                    return this.f10171d;
                }

                public final int jK_() {
                    return -1142345493;
                }

                public final GraphQLVisitableModel m10630a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10628a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m10628a());
                        if (m10628a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10171d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10629a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10628a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: message_count=0 */
            public class Serializer extends JsonSerializer<MessengerComposerOrderModel> {
                public final void m10631a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerComposerOrderModel messengerComposerOrderModel = (MessengerComposerOrderModel) obj;
                    if (messengerComposerOrderModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerComposerOrderModel.m10633a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerComposerOrderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerComposerOrderParser.m10644a(messengerComposerOrderModel.w_(), messengerComposerOrderModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerComposerOrderModel.class, new Serializer());
                }
            }

            public MessengerComposerOrderModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m10632a() {
                this.f10172d = super.a(this.f10172d, 0, EdgesModel.class);
                return (ImmutableList) this.f10172d;
            }

            public final int jK_() {
                return -12671092;
            }

            public final GraphQLVisitableModel m10634a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10632a() != null) {
                    Builder a = ModelHelper.a(m10632a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerComposerOrderModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10172d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10633a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10632a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: message_count=0 */
        public class Serializer extends JsonSerializer<ComposerOrderQueryFragmentModel> {
            public final void m10635a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ComposerOrderQueryFragmentModel composerOrderQueryFragmentModel = (ComposerOrderQueryFragmentModel) obj;
                if (composerOrderQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(composerOrderQueryFragmentModel.m10637a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    composerOrderQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = composerOrderQueryFragmentModel.w_();
                int u_ = composerOrderQueryFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_composer_order");
                    MessengerComposerOrderParser.m10644a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ComposerOrderQueryFragmentModel.class, new Serializer());
            }
        }

        public ComposerOrderQueryFragmentModel() {
            super(1);
        }

        @Nullable
        private MessengerComposerOrderModel m10636a() {
            this.f10173d = (MessengerComposerOrderModel) super.a(this.f10173d, 0, MessengerComposerOrderModel.class);
            return this.f10173d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m10638a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10636a() != null) {
                MessengerComposerOrderModel messengerComposerOrderModel = (MessengerComposerOrderModel) graphQLModelMutatingVisitor.b(m10636a());
                if (m10636a() != messengerComposerOrderModel) {
                    graphQLVisitableModel = (ComposerOrderQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10173d = messengerComposerOrderModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10637a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10636a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
