package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionAddVoteMutationParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser.OptionsParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser.OptionsParser.EdgesParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser.OptionsParser.EdgesParser.NodeParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser.OptionsParser.EdgesParser.NodeParser.TextWithEntitiesParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser.OptionsParser.EdgesParser.NodeParser.VotersParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser.OptionsParser.EdgesParser.NodeParser.VotersParser.VotersEdgesParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser.OptionsParser.EdgesParser.NodeParser.VotersParser.VotersEdgesParser.VotersEdgesNodeParser;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionRemoveVoteMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: messenger_optin_interstitial_new */
public class QuestionPollUpdateVoteModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 262104880)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_optin_interstitial_new */
    public final class QuestionAddVoteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private QuestionMutationFragmentModel f10352d;

        /* compiled from: messenger_optin_interstitial_new */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QuestionAddVoteMutationModel.class, new Deserializer());
            }

            public Object m16408a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = QuestionAddVoteMutationParser.m16476a(jsonParser);
                Object questionAddVoteMutationModel = new QuestionAddVoteMutationModel();
                ((BaseModel) questionAddVoteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (questionAddVoteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) questionAddVoteMutationModel).a();
                }
                return questionAddVoteMutationModel;
            }
        }

        /* compiled from: messenger_optin_interstitial_new */
        public class Serializer extends JsonSerializer<QuestionAddVoteMutationModel> {
            public final void m16409a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                QuestionAddVoteMutationModel questionAddVoteMutationModel = (QuestionAddVoteMutationModel) obj;
                if (questionAddVoteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(questionAddVoteMutationModel.m16411a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    questionAddVoteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = questionAddVoteMutationModel.w_();
                int u_ = questionAddVoteMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("question");
                    QuestionMutationFragmentParser.m16492a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(QuestionAddVoteMutationModel.class, new Serializer());
            }
        }

        public QuestionAddVoteMutationModel() {
            super(1);
        }

        @Nullable
        private QuestionMutationFragmentModel m16410a() {
            this.f10352d = (QuestionMutationFragmentModel) super.a(this.f10352d, 0, QuestionMutationFragmentModel.class);
            return this.f10352d;
        }

        public final int jK_() {
            return 876299016;
        }

        public final GraphQLVisitableModel m16412a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16410a() != null) {
                QuestionMutationFragmentModel questionMutationFragmentModel = (QuestionMutationFragmentModel) graphQLModelMutatingVisitor.b(m16410a());
                if (m16410a() != questionMutationFragmentModel) {
                    graphQLVisitableModel = (QuestionAddVoteMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10352d = questionMutationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16411a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16410a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1392556400)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_optin_interstitial_new */
    public final class QuestionMutationFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f10366d;
        @Nullable
        private OptionsModel f10367e;

        /* compiled from: messenger_optin_interstitial_new */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QuestionMutationFragmentModel.class, new Deserializer());
            }

            public Object m16413a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(QuestionMutationFragmentParser.m16491a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object questionMutationFragmentModel = new QuestionMutationFragmentModel();
                ((BaseModel) questionMutationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (questionMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) questionMutationFragmentModel).a();
                }
                return questionMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -716186733)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messenger_optin_interstitial_new */
        public final class OptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10365d;

            /* compiled from: messenger_optin_interstitial_new */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionsModel.class, new Deserializer());
                }

                public Object m16414a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionsParser.m16489a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionsModel = new OptionsModel();
                    ((BaseModel) optionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionsModel instanceof Postprocessable) {
                        return ((Postprocessable) optionsModel).a();
                    }
                    return optionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -547881087)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: messenger_optin_interstitial_new */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10364d;

                /* compiled from: messenger_optin_interstitial_new */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m16415a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m16487b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -777885167)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: messenger_optin_interstitial_new */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f10360d;
                    @Nullable
                    private TextWithEntitiesModel f10361e;
                    private boolean f10362f;
                    @Nullable
                    private VotersModel f10363g;

                    /* compiled from: messenger_optin_interstitial_new */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m16416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m16485a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: messenger_optin_interstitial_new */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m16417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m16449a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m16486a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1352864475)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: messenger_optin_interstitial_new */
                    public final class TextWithEntitiesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f10353d;

                        /* compiled from: messenger_optin_interstitial_new */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(TextWithEntitiesModel.class, new Deserializer());
                            }

                            public Object m16418a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(TextWithEntitiesParser.m16477a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object textWithEntitiesModel = new TextWithEntitiesModel();
                                ((BaseModel) textWithEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (textWithEntitiesModel instanceof Postprocessable) {
                                    return ((Postprocessable) textWithEntitiesModel).a();
                                }
                                return textWithEntitiesModel;
                            }
                        }

                        /* compiled from: messenger_optin_interstitial_new */
                        public class Serializer extends JsonSerializer<TextWithEntitiesModel> {
                            public final void m16419a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                TextWithEntitiesModel textWithEntitiesModel = (TextWithEntitiesModel) obj;
                                if (textWithEntitiesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(textWithEntitiesModel.m16420a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    textWithEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                TextWithEntitiesParser.m16478a(textWithEntitiesModel.w_(), textWithEntitiesModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(TextWithEntitiesModel.class, new Serializer());
                            }
                        }

                        public TextWithEntitiesModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m16422a() {
                            this.f10353d = super.a(this.f10353d, 0);
                            return this.f10353d;
                        }

                        public final int jK_() {
                            return -1919764332;
                        }

                        public final GraphQLVisitableModel m16421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m16420a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m16422a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1384143863)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: messenger_optin_interstitial_new */
                    public final class VotersModel extends BaseModel implements GraphQLVisitableModel {
                        private int f10358d;
                        @Nullable
                        private List<VotersEdgesModel> f10359e;

                        /* compiled from: messenger_optin_interstitial_new */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(VotersModel.class, new Deserializer());
                            }

                            public Object m16423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(VotersParser.m16483a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object votersModel = new VotersModel();
                                ((BaseModel) votersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (votersModel instanceof Postprocessable) {
                                    return ((Postprocessable) votersModel).a();
                                }
                                return votersModel;
                            }
                        }

                        /* compiled from: messenger_optin_interstitial_new */
                        public class Serializer extends JsonSerializer<VotersModel> {
                            public final void m16424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                VotersModel votersModel = (VotersModel) obj;
                                if (votersModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(votersModel.m16442a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    votersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                VotersParser.m16484a(votersModel.w_(), votersModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(VotersModel.class, new Serializer());
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1387001793)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: messenger_optin_interstitial_new */
                        public final class VotersEdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private VotersEdgesNodeModel f10357d;

                            /* compiled from: messenger_optin_interstitial_new */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(VotersEdgesModel.class, new Deserializer());
                                }

                                public Object m16425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(VotersEdgesParser.m16481b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object votersEdgesModel = new VotersEdgesModel();
                                    ((BaseModel) votersEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (votersEdgesModel instanceof Postprocessable) {
                                        return ((Postprocessable) votersEdgesModel).a();
                                    }
                                    return votersEdgesModel;
                                }
                            }

                            /* compiled from: messenger_optin_interstitial_new */
                            public class Serializer extends JsonSerializer<VotersEdgesModel> {
                                public final void m16426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    VotersEdgesModel votersEdgesModel = (VotersEdgesModel) obj;
                                    if (votersEdgesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(votersEdgesModel.m16438a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        votersEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    VotersEdgesParser.m16482b(votersEdgesModel.w_(), votersEdgesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(VotersEdgesModel.class, new Serializer());
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -1257524174)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: messenger_optin_interstitial_new */
                            public final class VotersEdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                                @Nullable
                                private String f10354d;
                                private boolean f10355e;
                                @Nullable
                                private DefaultImageFieldsModel f10356f;

                                /* compiled from: messenger_optin_interstitial_new */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(VotersEdgesNodeModel.class, new Deserializer());
                                    }

                                    public Object m16427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(VotersEdgesNodeParser.m16479a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object votersEdgesNodeModel = new VotersEdgesNodeModel();
                                        ((BaseModel) votersEdgesNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (votersEdgesNodeModel instanceof Postprocessable) {
                                            return ((Postprocessable) votersEdgesNodeModel).a();
                                        }
                                        return votersEdgesNodeModel;
                                    }
                                }

                                /* compiled from: messenger_optin_interstitial_new */
                                public class Serializer extends JsonSerializer<VotersEdgesNodeModel> {
                                    public final void m16428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        VotersEdgesNodeModel votersEdgesNodeModel = (VotersEdgesNodeModel) obj;
                                        if (votersEdgesNodeModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(votersEdgesNodeModel.m16431a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            votersEdgesNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        VotersEdgesNodeParser.m16480a(votersEdgesNodeModel.w_(), votersEdgesNodeModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(VotersEdgesNodeModel.class, new Serializer());
                                    }
                                }

                                public VotersEdgesNodeModel() {
                                    super(3);
                                }

                                public final void m16435a(String str, ConsistencyTuple consistencyTuple) {
                                    consistencyTuple.a();
                                }

                                public final void m16436a(String str, Object obj, boolean z) {
                                }

                                @Nullable
                                private String m16429j() {
                                    this.f10354d = super.a(this.f10354d, 0);
                                    return this.f10354d;
                                }

                                @Nullable
                                private DefaultImageFieldsModel m16430k() {
                                    this.f10356f = (DefaultImageFieldsModel) super.a(this.f10356f, 2, DefaultImageFieldsModel.class);
                                    return this.f10356f;
                                }

                                @Nullable
                                public final String m16433a() {
                                    return m16429j();
                                }

                                public final int jK_() {
                                    return 2645995;
                                }

                                public final GraphQLVisitableModel m16432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m16430k() != null) {
                                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16430k());
                                        if (m16430k() != defaultImageFieldsModel) {
                                            graphQLVisitableModel = (VotersEdgesNodeModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f10356f = defaultImageFieldsModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m16431a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int b = flatBufferBuilder.b(m16429j());
                                    int a = ModelHelper.a(flatBufferBuilder, m16430k());
                                    flatBufferBuilder.c(3);
                                    flatBufferBuilder.b(0, b);
                                    flatBufferBuilder.a(1, this.f10355e);
                                    flatBufferBuilder.b(2, a);
                                    i();
                                    return flatBufferBuilder.d();
                                }

                                public final void m16434a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                    super.a(mutableFlatBuffer, i, obj);
                                    this.f10355e = mutableFlatBuffer.a(i, 1);
                                }
                            }

                            public VotersEdgesModel() {
                                super(1);
                            }

                            @Nullable
                            private VotersEdgesNodeModel m16437a() {
                                this.f10357d = (VotersEdgesNodeModel) super.a(this.f10357d, 0, VotersEdgesNodeModel.class);
                                return this.f10357d;
                            }

                            public final int jK_() {
                                return 299241859;
                            }

                            public final GraphQLVisitableModel m16439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m16437a() != null) {
                                    VotersEdgesNodeModel votersEdgesNodeModel = (VotersEdgesNodeModel) graphQLModelMutatingVisitor.b(m16437a());
                                    if (m16437a() != votersEdgesNodeModel) {
                                        graphQLVisitableModel = (VotersEdgesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f10357d = votersEdgesNodeModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m16438a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m16437a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        public VotersModel() {
                            super(2);
                        }

                        public final int m16441a() {
                            a(0, 0);
                            return this.f10358d;
                        }

                        public final void m16444a(int i) {
                            this.f10358d = i;
                            if (this.b != null && this.b.d) {
                                this.b.b(this.c, 0, i);
                            }
                        }

                        @Nonnull
                        private ImmutableList<VotersEdgesModel> m16440j() {
                            this.f10359e = super.a(this.f10359e, 1, VotersEdgesModel.class);
                            return (ImmutableList) this.f10359e;
                        }

                        public final int jK_() {
                            return 280409636;
                        }

                        public final GraphQLVisitableModel m16443a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m16440j() != null) {
                                Builder a = ModelHelper.a(m16440j(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (VotersModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f10359e = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m16442a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m16440j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, this.f10358d, 0);
                            flatBufferBuilder.b(1, a);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m16445a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f10358d = mutableFlatBuffer.a(i, 0, 0);
                        }
                    }

                    public NodeModel() {
                        super(4);
                    }

                    public final void m16453a(String str, ConsistencyTuple consistencyTuple) {
                        if ("viewer_has_voted".equals(str)) {
                            consistencyTuple.a = Boolean.valueOf(m16447l());
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 2;
                            return;
                        }
                        if ("voters.count".equals(str)) {
                            VotersModel m = m16448m();
                            if (m != null) {
                                consistencyTuple.a = Integer.valueOf(m.m16441a());
                                consistencyTuple.b = m.u_();
                                consistencyTuple.c = 0;
                                return;
                            }
                        }
                        consistencyTuple.a();
                    }

                    public final void m16454a(String str, Object obj, boolean z) {
                        if ("viewer_has_voted".equals(str)) {
                            m16446a(((Boolean) obj).booleanValue());
                        } else if ("voters.count".equals(str)) {
                            VotersModel m = m16448m();
                            if (m == null) {
                                return;
                            }
                            if (z) {
                                m = (VotersModel) m.clone();
                                m.m16444a(((Integer) obj).intValue());
                                this.f10363g = m;
                                return;
                            }
                            m.m16444a(((Integer) obj).intValue());
                        }
                    }

                    @Nullable
                    public final String m16455j() {
                        this.f10360d = super.a(this.f10360d, 0);
                        return this.f10360d;
                    }

                    @Nullable
                    public final TextWithEntitiesModel m16456k() {
                        this.f10361e = (TextWithEntitiesModel) super.a(this.f10361e, 1, TextWithEntitiesModel.class);
                        return this.f10361e;
                    }

                    private boolean m16447l() {
                        a(0, 2);
                        return this.f10362f;
                    }

                    private void m16446a(boolean z) {
                        this.f10362f = z;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 2, z);
                        }
                    }

                    @Nullable
                    private VotersModel m16448m() {
                        this.f10363g = (VotersModel) super.a(this.f10363g, 3, VotersModel.class);
                        return this.f10363g;
                    }

                    @Nullable
                    public final String m16451a() {
                        return m16455j();
                    }

                    public final int jK_() {
                        return 955873307;
                    }

                    public final GraphQLVisitableModel m16450a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m16456k() != null) {
                            TextWithEntitiesModel textWithEntitiesModel = (TextWithEntitiesModel) graphQLModelMutatingVisitor.b(m16456k());
                            if (m16456k() != textWithEntitiesModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10361e = textWithEntitiesModel;
                            }
                        }
                        if (m16448m() != null) {
                            VotersModel votersModel = (VotersModel) graphQLModelMutatingVisitor.b(m16448m());
                            if (m16448m() != votersModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10363g = votersModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m16449a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m16455j());
                        int a = ModelHelper.a(flatBufferBuilder, m16456k());
                        int a2 = ModelHelper.a(flatBufferBuilder, m16448m());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.a(2, this.f10362f);
                        flatBufferBuilder.b(3, a2);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m16452a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f10362f = mutableFlatBuffer.a(i, 2);
                    }
                }

                /* compiled from: messenger_optin_interstitial_new */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m16457a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m16458a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m16488b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m16459a() {
                    this.f10364d = (NodeModel) super.a(this.f10364d, 0, NodeModel.class);
                    return this.f10364d;
                }

                public final int jK_() {
                    return 1958334869;
                }

                public final GraphQLVisitableModel m16460a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16459a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m16459a());
                        if (m16459a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10364d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16458a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16459a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: messenger_optin_interstitial_new */
            public class Serializer extends JsonSerializer<OptionsModel> {
                public final void m16461a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionsModel optionsModel = (OptionsModel) obj;
                    if (optionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionsModel.m16462a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionsParser.m16490a(optionsModel.w_(), optionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OptionsModel.class, new Serializer());
                }
            }

            public OptionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m16464a() {
                this.f10365d = super.a(this.f10365d, 0, EdgesModel.class);
                return (ImmutableList) this.f10365d;
            }

            public final int jK_() {
                return -503668554;
            }

            public final GraphQLVisitableModel m16463a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16464a() != null) {
                    Builder a = ModelHelper.a(m16464a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (OptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10365d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16462a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16464a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: messenger_optin_interstitial_new */
        public class Serializer extends JsonSerializer<QuestionMutationFragmentModel> {
            public final void m16465a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                QuestionMutationFragmentModel questionMutationFragmentModel = (QuestionMutationFragmentModel) obj;
                if (questionMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(questionMutationFragmentModel.m16466a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    questionMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                QuestionMutationFragmentParser.m16492a(questionMutationFragmentModel.w_(), questionMutationFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(QuestionMutationFragmentModel.class, new Serializer());
            }
        }

        public QuestionMutationFragmentModel() {
            super(2);
        }

        @Nullable
        public final String m16469j() {
            this.f10366d = super.a(this.f10366d, 0);
            return this.f10366d;
        }

        @Nullable
        public final OptionsModel m16470k() {
            this.f10367e = (OptionsModel) super.a(this.f10367e, 1, OptionsModel.class);
            return this.f10367e;
        }

        @Nullable
        public final String m16468a() {
            return m16469j();
        }

        public final int jK_() {
            return -1101225978;
        }

        public final GraphQLVisitableModel m16467a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16470k() != null) {
                OptionsModel optionsModel = (OptionsModel) graphQLModelMutatingVisitor.b(m16470k());
                if (m16470k() != optionsModel) {
                    graphQLVisitableModel = (QuestionMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10367e = optionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16466a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16469j());
            int a = ModelHelper.a(flatBufferBuilder, m16470k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 262104880)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_optin_interstitial_new */
    public final class QuestionRemoveVoteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private QuestionMutationFragmentModel f10368d;

        /* compiled from: messenger_optin_interstitial_new */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QuestionRemoveVoteMutationModel.class, new Deserializer());
            }

            public Object m16471a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = QuestionRemoveVoteMutationParser.m16493a(jsonParser);
                Object questionRemoveVoteMutationModel = new QuestionRemoveVoteMutationModel();
                ((BaseModel) questionRemoveVoteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (questionRemoveVoteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) questionRemoveVoteMutationModel).a();
                }
                return questionRemoveVoteMutationModel;
            }
        }

        /* compiled from: messenger_optin_interstitial_new */
        public class Serializer extends JsonSerializer<QuestionRemoveVoteMutationModel> {
            public final void m16472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                QuestionRemoveVoteMutationModel questionRemoveVoteMutationModel = (QuestionRemoveVoteMutationModel) obj;
                if (questionRemoveVoteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(questionRemoveVoteMutationModel.m16474a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    questionRemoveVoteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = questionRemoveVoteMutationModel.w_();
                int u_ = questionRemoveVoteMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("question");
                    QuestionMutationFragmentParser.m16492a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(QuestionRemoveVoteMutationModel.class, new Serializer());
            }
        }

        public QuestionRemoveVoteMutationModel() {
            super(1);
        }

        @Nullable
        private QuestionMutationFragmentModel m16473a() {
            this.f10368d = (QuestionMutationFragmentModel) super.a(this.f10368d, 0, QuestionMutationFragmentModel.class);
            return this.f10368d;
        }

        public final int jK_() {
            return 935020857;
        }

        public final GraphQLVisitableModel m16475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16473a() != null) {
                QuestionMutationFragmentModel questionMutationFragmentModel = (QuestionMutationFragmentModel) graphQLModelMutatingVisitor.b(m16473a());
                if (m16473a() != questionMutationFragmentModel) {
                    graphQLVisitableModel = (QuestionRemoveVoteMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10368d = questionMutationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16474a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16473a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
