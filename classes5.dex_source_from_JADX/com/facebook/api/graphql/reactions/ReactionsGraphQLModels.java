package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.CompleteReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.ReactionsCountFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.SimpleReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.ViewerReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.ViewerReactionsSocialFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.CompleteReactionsCountFieldsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.CompleteReactionsCountFieldsParser.TopReactionsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.CompleteReactionsCountFieldsParser.TopReactionsParser.EdgesParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.CompleteReactionsCountFieldsParser.TopReactionsParser.EdgesParser.NodeParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.CompleteReactionsFeedbackFieldsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.CompleteReactionsFeedbackFieldsParser.ReactorsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.SimpleReactionsFeedbackFieldsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsFeedbackFieldsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsFeedbackFieldsParser.SupportedReactionsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ImportantReactorsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ImportantReactorsParser.NodesParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ViewerActsAsPersonParser;
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

/* compiled from: android_place_picker_long_press_report_duplicates */
public class ReactionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -237310049)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class CompleteReactionsCountFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private TopReactionsModel f9787d;

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CompleteReactionsCountFieldsModel.class, new Deserializer());
            }

            public Object m16994a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CompleteReactionsCountFieldsParser.m17151a(jsonParser);
                Object completeReactionsCountFieldsModel = new CompleteReactionsCountFieldsModel();
                ((BaseModel) completeReactionsCountFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (completeReactionsCountFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) completeReactionsCountFieldsModel).a();
                }
                return completeReactionsCountFieldsModel;
            }
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<CompleteReactionsCountFieldsModel> {
            public final void m16995a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CompleteReactionsCountFieldsModel completeReactionsCountFieldsModel = (CompleteReactionsCountFieldsModel) obj;
                if (completeReactionsCountFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(completeReactionsCountFieldsModel.m17013a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    completeReactionsCountFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = completeReactionsCountFieldsModel.w_();
                int u_ = completeReactionsCountFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("top_reactions");
                    TopReactionsParser.m17150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CompleteReactionsCountFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1120535959)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_long_press_report_duplicates */
        public final class TopReactionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f9786d;

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopReactionsModel.class, new Deserializer());
                }

                public Object m16996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopReactionsParser.m17149a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topReactionsModel = new TopReactionsModel();
                    ((BaseModel) topReactionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topReactionsModel instanceof Postprocessable) {
                        return ((Postprocessable) topReactionsModel).a();
                    }
                    return topReactionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 427399420)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_long_press_report_duplicates */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f9784d;
                private int f9785e;

                /* compiled from: android_place_picker_long_press_report_duplicates */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m16997a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m17147b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 224127441)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_long_press_report_duplicates */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    private int f9783d;

                    /* compiled from: android_place_picker_long_press_report_duplicates */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m16998a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m17145a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: android_place_picker_long_press_report_duplicates */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m16999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m17000a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m17146a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    public final int jK_() {
                        return -1654469956;
                    }

                    public final GraphQLVisitableModel m17001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17000a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f9783d, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m17002a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f9783d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                /* compiled from: android_place_picker_long_press_report_duplicates */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m17003a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m17005a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m17148b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                @Nullable
                private NodeModel m17004a() {
                    this.f9784d = (NodeModel) super.a(this.f9784d, 0, NodeModel.class);
                    return this.f9784d;
                }

                public final int jK_() {
                    return -1719612142;
                }

                public final GraphQLVisitableModel m17006a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17004a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m17004a());
                        if (m17004a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9784d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17005a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17004a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f9785e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17007a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9785e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Serializer extends JsonSerializer<TopReactionsModel> {
                public final void m17008a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopReactionsModel topReactionsModel = (TopReactionsModel) obj;
                    if (topReactionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topReactionsModel.m17010a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topReactionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopReactionsParser.m17150a(topReactionsModel.w_(), topReactionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TopReactionsModel.class, new Serializer());
                }
            }

            public TopReactionsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m17009a() {
                this.f9786d = super.a(this.f9786d, 0, EdgesModel.class);
                return (ImmutableList) this.f9786d;
            }

            public final int jK_() {
                return 1791249011;
            }

            public final GraphQLVisitableModel m17011a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17009a() != null) {
                    Builder a = ModelHelper.a(m17009a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TopReactionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9786d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17010a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17009a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public CompleteReactionsCountFieldsModel() {
            super(1);
        }

        public final void m17015a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17016a(String str, Object obj, boolean z) {
        }

        @Nullable
        private TopReactionsModel m17012a() {
            this.f9787d = (TopReactionsModel) super.a(this.f9787d, 0, TopReactionsModel.class);
            return this.f9787d;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m17014a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17012a() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m17012a());
                if (m17012a() != topReactionsModel) {
                    graphQLVisitableModel = (CompleteReactionsCountFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9787d = topReactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17013a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17012a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1142260669)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class CompleteReactionsFeedbackFieldsModel extends BaseModel implements CompleteReactionsFeedbackFields, GraphQLVisitableConsistentModel {
        private boolean f9789d;
        private boolean f9790e;
        @Nullable
        private ImportantReactorsModel f9791f;
        @Nullable
        private ReactorsModel f9792g;
        @Nullable
        private List<SupportedReactionsModel> f9793h;
        @Nullable
        private TopReactionsModel f9794i;
        @Nullable
        private ViewerActsAsPersonModel f9795j;
        private int f9796k;

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CompleteReactionsFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m17017a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CompleteReactionsFeedbackFieldsParser.m17154a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object completeReactionsFeedbackFieldsModel = new CompleteReactionsFeedbackFieldsModel();
                ((BaseModel) completeReactionsFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (completeReactionsFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) completeReactionsFeedbackFieldsModel).a();
                }
                return completeReactionsFeedbackFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_long_press_report_duplicates */
        public final class ReactorsModel extends BaseModel implements GraphQLVisitableModel {
            private int f9788d;

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactorsModel.class, new Deserializer());
                }

                public Object m17018a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactorsParser.m17152a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactorsModel = new ReactorsModel();
                    ((BaseModel) reactorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactorsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactorsModel).a();
                    }
                    return reactorsModel;
                }
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Serializer extends JsonSerializer<ReactorsModel> {
                public final void m17019a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactorsModel reactorsModel = (ReactorsModel) obj;
                    if (reactorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactorsModel.m17021a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactorsParser.m17153a(reactorsModel.w_(), reactorsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReactorsModel.class, new Serializer());
                }
            }

            public ReactorsModel() {
                super(1);
            }

            public final int m17020a() {
                a(0, 0);
                return this.f9788d;
            }

            public final void m17023a(int i) {
                this.f9788d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 256909871;
            }

            public final GraphQLVisitableModel m17022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17021a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9788d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17024a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9788d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<CompleteReactionsFeedbackFieldsModel> {
            public final void m17025a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CompleteReactionsFeedbackFieldsModel completeReactionsFeedbackFieldsModel = (CompleteReactionsFeedbackFieldsModel) obj;
                if (completeReactionsFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(completeReactionsFeedbackFieldsModel.m17033a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    completeReactionsFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = completeReactionsFeedbackFieldsModel.w_();
                int u_ = completeReactionsFeedbackFieldsModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_react");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("display_reactions");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("important_reactors");
                    ImportantReactorsParser.m17182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("reactors");
                    ReactorsParser.m17153a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("supported_reactions");
                    SupportedReactionsParser.m17167a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("top_reactions");
                    TopReactionsParser.m17150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("viewer_acts_as_person");
                    ViewerActsAsPersonParser.m17184a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 7, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer_feedback_reaction_key");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CompleteReactionsFeedbackFieldsModel.class, new Serializer());
            }
        }

        public CompleteReactionsFeedbackFieldsModel() {
            super(8);
        }

        public final void m17036a(String str, ConsistencyTuple consistencyTuple) {
            if ("reactors.count".equals(str)) {
                ReactorsModel j = m17028j();
                if (j != null) {
                    consistencyTuple.a = Integer.valueOf(j.m17020a());
                    consistencyTuple.b = j.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.a = Integer.valueOf(m17032n());
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
                return;
            }
            consistencyTuple.a();
        }

        public final void m17037a(String str, Object obj, boolean z) {
            if ("reactors.count".equals(str)) {
                ReactorsModel j = m17028j();
                if (j == null) {
                    return;
                }
                if (z) {
                    j = (ReactorsModel) j.clone();
                    j.m17023a(((Integer) obj).intValue());
                    this.f9792g = j;
                    return;
                }
                j.m17023a(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m17027a(((Integer) obj).intValue());
            }
        }

        @Nullable
        private ImportantReactorsModel m17026a() {
            this.f9791f = (ImportantReactorsModel) super.a(this.f9791f, 2, ImportantReactorsModel.class);
            return this.f9791f;
        }

        @Nullable
        private ReactorsModel m17028j() {
            this.f9792g = (ReactorsModel) super.a(this.f9792g, 3, ReactorsModel.class);
            return this.f9792g;
        }

        @Nonnull
        private ImmutableList<SupportedReactionsModel> m17029k() {
            this.f9793h = super.a(this.f9793h, 4, SupportedReactionsModel.class);
            return (ImmutableList) this.f9793h;
        }

        @Nullable
        private TopReactionsModel m17030l() {
            this.f9794i = (TopReactionsModel) super.a(this.f9794i, 5, TopReactionsModel.class);
            return this.f9794i;
        }

        @Nullable
        private ViewerActsAsPersonModel m17031m() {
            this.f9795j = (ViewerActsAsPersonModel) super.a(this.f9795j, 6, ViewerActsAsPersonModel.class);
            return this.f9795j;
        }

        private int m17032n() {
            a(0, 7);
            return this.f9796k;
        }

        private void m17027a(int i) {
            this.f9796k = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 7, i);
            }
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m17034a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17026a() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m17026a());
                if (m17026a() != importantReactorsModel) {
                    graphQLVisitableModel = (CompleteReactionsFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9791f = importantReactorsModel;
                }
            }
            if (m17028j() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m17028j());
                if (m17028j() != reactorsModel) {
                    graphQLVisitableModel = (CompleteReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9792g = reactorsModel;
                }
            }
            if (m17029k() != null) {
                Builder a = ModelHelper.a(m17029k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CompleteReactionsFeedbackFieldsModel completeReactionsFeedbackFieldsModel = (CompleteReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    completeReactionsFeedbackFieldsModel.f9793h = a.b();
                    graphQLVisitableModel = completeReactionsFeedbackFieldsModel;
                }
            }
            if (m17030l() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m17030l());
                if (m17030l() != topReactionsModel) {
                    graphQLVisitableModel = (CompleteReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9794i = topReactionsModel;
                }
            }
            if (m17031m() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m17031m());
                if (m17031m() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (CompleteReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9795j = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17033a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17026a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17028j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17029k());
            int a4 = ModelHelper.a(flatBufferBuilder, m17030l());
            int a5 = ModelHelper.a(flatBufferBuilder, m17031m());
            flatBufferBuilder.c(8);
            flatBufferBuilder.a(0, this.f9789d);
            flatBufferBuilder.a(1, this.f9790e);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.a(7, this.f9796k, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17035a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9789d = mutableFlatBuffer.a(i, 0);
            this.f9790e = mutableFlatBuffer.a(i, 1);
            this.f9796k = mutableFlatBuffer.a(i, 7, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1895029982)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class ReactionsCountFieldsModel extends BaseModel implements ReactionsCountFields, GraphQLVisitableConsistentModel {
        @Nullable
        private TopReactionsModel f9804d;

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionsCountFieldsModel.class, new Deserializer());
            }

            public Object m17038a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionsCountFieldsParser.m17161a(jsonParser);
                Object reactionsCountFieldsModel = new ReactionsCountFieldsModel();
                ((BaseModel) reactionsCountFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionsCountFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionsCountFieldsModel).a();
                }
                return reactionsCountFieldsModel;
            }
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<ReactionsCountFieldsModel> {
            public final void m17039a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionsCountFieldsModel reactionsCountFieldsModel = (ReactionsCountFieldsModel) obj;
                if (reactionsCountFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionsCountFieldsModel.m17059a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionsCountFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionsCountFieldsModel.w_();
                int u_ = reactionsCountFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("top_reactions");
                    ReactionsCountFieldsParser.TopReactionsParser.m17160a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionsCountFieldsModel.class, new Serializer());
            }
        }

        public ReactionsCountFieldsModel() {
            super(1);
        }

        public final void m17061a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17062a(String str, Object obj, boolean z) {
        }

        @Nullable
        private TopReactionsModel m17058a() {
            this.f9804d = (TopReactionsModel) super.a(this.f9804d, 0, TopReactionsModel.class);
            return this.f9804d;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m17060a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17058a() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m17058a());
                if (m17058a() != topReactionsModel) {
                    graphQLVisitableModel = (ReactionsCountFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9804d = topReactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17059a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17058a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1499543739)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class SimpleReactionsFeedbackFieldsModel extends BaseModel implements SimpleReactionsFeedbackFields, GraphQLVisitableConsistentModel {
        private boolean f9807d;
        private boolean f9808e;
        @Nullable
        private ImportantReactorsModel f9809f;
        @Nullable
        private ReactorsModel f9810g;
        @Nullable
        private List<SupportedReactionsModel> f9811h;
        @Nullable
        private TopReactionsModel f9812i;
        @Nullable
        private ViewerActsAsPersonModel f9813j;
        private int f9814k;

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SimpleReactionsFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m17063a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SimpleReactionsFeedbackFieldsParser.m17164a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object simpleReactionsFeedbackFieldsModel = new SimpleReactionsFeedbackFieldsModel();
                ((BaseModel) simpleReactionsFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (simpleReactionsFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) simpleReactionsFeedbackFieldsModel).a();
                }
                return simpleReactionsFeedbackFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_long_press_report_duplicates */
        public final class ReactorsModel extends BaseModel implements GraphQLVisitableModel {
            private int f9806d;

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public final class Builder {
                public int f9805a;
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactorsModel.class, new Deserializer());
                }

                public Object m17064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SimpleReactionsFeedbackFieldsParser.ReactorsParser.m17162a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactorsModel = new ReactorsModel();
                    ((BaseModel) reactorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactorsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactorsModel).a();
                    }
                    return reactorsModel;
                }
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Serializer extends JsonSerializer<ReactorsModel> {
                public final void m17065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactorsModel reactorsModel = (ReactorsModel) obj;
                    if (reactorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactorsModel.m17068a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SimpleReactionsFeedbackFieldsParser.ReactorsParser.m17163a(reactorsModel.w_(), reactorsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReactorsModel.class, new Serializer());
                }
            }

            public ReactorsModel() {
                super(1);
            }

            public ReactorsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m17067a() {
                a(0, 0);
                return this.f9806d;
            }

            public final void m17070a(int i) {
                this.f9806d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public static ReactorsModel m17066a(ReactorsModel reactorsModel) {
                if (reactorsModel == null) {
                    return null;
                }
                if (reactorsModel instanceof ReactorsModel) {
                    return reactorsModel;
                }
                Builder builder = new Builder();
                builder.f9805a = reactorsModel.m17067a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f9805a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactorsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 256909871;
            }

            public final GraphQLVisitableModel m17069a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17068a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9806d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17071a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9806d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<SimpleReactionsFeedbackFieldsModel> {
            public final void m17072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SimpleReactionsFeedbackFieldsModel simpleReactionsFeedbackFieldsModel = (SimpleReactionsFeedbackFieldsModel) obj;
                if (simpleReactionsFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(simpleReactionsFeedbackFieldsModel.m17080a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    simpleReactionsFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = simpleReactionsFeedbackFieldsModel.w_();
                int u_ = simpleReactionsFeedbackFieldsModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_react");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("display_reactions");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("important_reactors");
                    ImportantReactorsParser.m17182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("reactors");
                    SimpleReactionsFeedbackFieldsParser.ReactorsParser.m17163a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("supported_reactions");
                    SupportedReactionsParser.m17167a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("top_reactions");
                    ReactionsCountFieldsParser.TopReactionsParser.m17160a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("viewer_acts_as_person");
                    ViewerActsAsPersonParser.m17184a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 7, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer_feedback_reaction_key");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SimpleReactionsFeedbackFieldsModel.class, new Serializer());
            }
        }

        public SimpleReactionsFeedbackFieldsModel() {
            super(8);
        }

        public final void m17083a(String str, ConsistencyTuple consistencyTuple) {
            if ("reactors.count".equals(str)) {
                ReactorsModel j = m17075j();
                if (j != null) {
                    consistencyTuple.a = Integer.valueOf(j.m17067a());
                    consistencyTuple.b = j.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.a = Integer.valueOf(m17079n());
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
                return;
            }
            consistencyTuple.a();
        }

        public final void m17084a(String str, Object obj, boolean z) {
            if ("reactors.count".equals(str)) {
                ReactorsModel j = m17075j();
                if (j == null) {
                    return;
                }
                if (z) {
                    j = (ReactorsModel) j.clone();
                    j.m17070a(((Integer) obj).intValue());
                    this.f9810g = j;
                    return;
                }
                j.m17070a(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m17074a(((Integer) obj).intValue());
            }
        }

        @Nullable
        private ImportantReactorsModel m17073a() {
            this.f9809f = (ImportantReactorsModel) super.a(this.f9809f, 2, ImportantReactorsModel.class);
            return this.f9809f;
        }

        @Nullable
        private ReactorsModel m17075j() {
            this.f9810g = (ReactorsModel) super.a(this.f9810g, 3, ReactorsModel.class);
            return this.f9810g;
        }

        @Nonnull
        private ImmutableList<SupportedReactionsModel> m17076k() {
            this.f9811h = super.a(this.f9811h, 4, SupportedReactionsModel.class);
            return (ImmutableList) this.f9811h;
        }

        @Nullable
        private TopReactionsModel m17077l() {
            this.f9812i = (TopReactionsModel) super.a(this.f9812i, 5, TopReactionsModel.class);
            return this.f9812i;
        }

        @Nullable
        private ViewerActsAsPersonModel m17078m() {
            this.f9813j = (ViewerActsAsPersonModel) super.a(this.f9813j, 6, ViewerActsAsPersonModel.class);
            return this.f9813j;
        }

        private int m17079n() {
            a(0, 7);
            return this.f9814k;
        }

        private void m17074a(int i) {
            this.f9814k = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 7, i);
            }
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m17081a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17073a() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m17073a());
                if (m17073a() != importantReactorsModel) {
                    graphQLVisitableModel = (SimpleReactionsFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9809f = importantReactorsModel;
                }
            }
            if (m17075j() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m17075j());
                if (m17075j() != reactorsModel) {
                    graphQLVisitableModel = (SimpleReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9810g = reactorsModel;
                }
            }
            if (m17076k() != null) {
                Builder a = ModelHelper.a(m17076k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    SimpleReactionsFeedbackFieldsModel simpleReactionsFeedbackFieldsModel = (SimpleReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    simpleReactionsFeedbackFieldsModel.f9811h = a.b();
                    graphQLVisitableModel = simpleReactionsFeedbackFieldsModel;
                }
            }
            if (m17077l() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m17077l());
                if (m17077l() != topReactionsModel) {
                    graphQLVisitableModel = (SimpleReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9812i = topReactionsModel;
                }
            }
            if (m17078m() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m17078m());
                if (m17078m() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (SimpleReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9813j = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17080a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17073a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17075j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17076k());
            int a4 = ModelHelper.a(flatBufferBuilder, m17077l());
            int a5 = ModelHelper.a(flatBufferBuilder, m17078m());
            flatBufferBuilder.c(8);
            flatBufferBuilder.a(0, this.f9807d);
            flatBufferBuilder.a(1, this.f9808e);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.a(7, this.f9814k, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17082a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9807d = mutableFlatBuffer.a(i, 0);
            this.f9808e = mutableFlatBuffer.a(i, 1);
            this.f9814k = mutableFlatBuffer.a(i, 7, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1305941661)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class ViewerReactionsFeedbackFieldsModel extends BaseModel implements ViewerReactionsFeedbackFields, GraphQLVisitableConsistentModel {
        private boolean f9817d;
        private boolean f9818e;
        @Nullable
        private ImportantReactorsModel f9819f;
        @Nullable
        private List<SupportedReactionsModel> f9820g;
        @Nullable
        private ViewerActsAsPersonModel f9821h;
        private int f9822i;

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ViewerReactionsFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m17085a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ViewerReactionsFeedbackFieldsParser.m17169a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object viewerReactionsFeedbackFieldsModel = new ViewerReactionsFeedbackFieldsModel();
                ((BaseModel) viewerReactionsFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (viewerReactionsFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) viewerReactionsFeedbackFieldsModel).a();
                }
                return viewerReactionsFeedbackFieldsModel;
            }
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<ViewerReactionsFeedbackFieldsModel> {
            public final void m17086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ViewerReactionsFeedbackFieldsModel viewerReactionsFeedbackFieldsModel = (ViewerReactionsFeedbackFieldsModel) obj;
                if (viewerReactionsFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(viewerReactionsFeedbackFieldsModel.m17099a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    viewerReactionsFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = viewerReactionsFeedbackFieldsModel.w_();
                int u_ = viewerReactionsFeedbackFieldsModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_react");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("display_reactions");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("important_reactors");
                    ImportantReactorsParser.m17182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("supported_reactions");
                    SupportedReactionsParser.m17167a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("viewer_acts_as_person");
                    ViewerActsAsPersonParser.m17184a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 5, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer_feedback_reaction_key");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ViewerReactionsFeedbackFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 224127441)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_long_press_report_duplicates */
        public final class SupportedReactionsModel extends BaseModel implements GraphQLVisitableModel {
            private int f9816d;

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public final class Builder {
                public int f9815a;
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SupportedReactionsModel.class, new Deserializer());
                }

                public Object m17087a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SupportedReactionsParser.m17168b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object supportedReactionsModel = new SupportedReactionsModel();
                    ((BaseModel) supportedReactionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (supportedReactionsModel instanceof Postprocessable) {
                        return ((Postprocessable) supportedReactionsModel).a();
                    }
                    return supportedReactionsModel;
                }
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Serializer extends JsonSerializer<SupportedReactionsModel> {
                public final void m17088a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SupportedReactionsModel supportedReactionsModel = (SupportedReactionsModel) obj;
                    if (supportedReactionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(supportedReactionsModel.m17091a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        supportedReactionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SupportedReactionsParser.m17166a(supportedReactionsModel.w_(), supportedReactionsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SupportedReactionsModel.class, new Serializer());
                }
            }

            public SupportedReactionsModel() {
                super(1);
            }

            public SupportedReactionsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m17090a() {
                a(0, 0);
                return this.f9816d;
            }

            public static SupportedReactionsModel m17089a(SupportedReactionsModel supportedReactionsModel) {
                if (supportedReactionsModel == null) {
                    return null;
                }
                if (supportedReactionsModel instanceof SupportedReactionsModel) {
                    return supportedReactionsModel;
                }
                Builder builder = new Builder();
                builder.f9815a = supportedReactionsModel.m17090a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f9815a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SupportedReactionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 116529390;
            }

            public final GraphQLVisitableModel m17092a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17091a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9816d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17093a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9816d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public ViewerReactionsFeedbackFieldsModel() {
            super(6);
        }

        public final void m17102a(String str, ConsistencyTuple consistencyTuple) {
            if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.a = Integer.valueOf(m17098l());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            }
            consistencyTuple.a();
        }

        public final void m17103a(String str, Object obj, boolean z) {
            if ("viewer_feedback_reaction_key".equals(str)) {
                m17095a(((Integer) obj).intValue());
            }
        }

        @Nullable
        private ImportantReactorsModel m17094a() {
            this.f9819f = (ImportantReactorsModel) super.a(this.f9819f, 2, ImportantReactorsModel.class);
            return this.f9819f;
        }

        @Nonnull
        private ImmutableList<SupportedReactionsModel> m17096j() {
            this.f9820g = super.a(this.f9820g, 3, SupportedReactionsModel.class);
            return (ImmutableList) this.f9820g;
        }

        @Nullable
        private ViewerActsAsPersonModel m17097k() {
            this.f9821h = (ViewerActsAsPersonModel) super.a(this.f9821h, 4, ViewerActsAsPersonModel.class);
            return this.f9821h;
        }

        private int m17098l() {
            a(0, 5);
            return this.f9822i;
        }

        private void m17095a(int i) {
            this.f9822i = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 5, i);
            }
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m17100a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17094a() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m17094a());
                if (m17094a() != importantReactorsModel) {
                    graphQLVisitableModel = (ViewerReactionsFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9819f = importantReactorsModel;
                }
            }
            if (m17096j() != null) {
                Builder a = ModelHelper.a(m17096j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ViewerReactionsFeedbackFieldsModel viewerReactionsFeedbackFieldsModel = (ViewerReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    viewerReactionsFeedbackFieldsModel.f9820g = a.b();
                    graphQLVisitableModel = viewerReactionsFeedbackFieldsModel;
                }
            }
            if (m17097k() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m17097k());
                if (m17097k() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (ViewerReactionsFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9821h = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17099a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17094a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17096j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17097k());
            flatBufferBuilder.c(6);
            flatBufferBuilder.a(0, this.f9817d);
            flatBufferBuilder.a(1, this.f9818e);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.a(5, this.f9822i, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17101a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9817d = mutableFlatBuffer.a(i, 0);
            this.f9818e = mutableFlatBuffer.a(i, 1);
            this.f9822i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1393197004)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class ViewerReactionsSocialFeedbackFieldsModel extends BaseModel implements ViewerReactionsSocialFeedbackFields, GraphQLVisitableConsistentModel {
        @Nullable
        private ImportantReactorsModel f9831d;
        @Nullable
        private ViewerActsAsPersonModel f9832e;

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ViewerReactionsSocialFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m17114a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ViewerReactionsSocialFeedbackFieldsParser.m17185a(jsonParser);
                Object viewerReactionsSocialFeedbackFieldsModel = new ViewerReactionsSocialFeedbackFieldsModel();
                ((BaseModel) viewerReactionsSocialFeedbackFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (viewerReactionsSocialFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) viewerReactionsSocialFeedbackFieldsModel).a();
                }
                return viewerReactionsSocialFeedbackFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2012286744)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_long_press_report_duplicates */
        public final class ImportantReactorsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f9828d;

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f9823a;
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImportantReactorsModel.class, new Deserializer());
                }

                public Object m17115a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImportantReactorsParser.m17181a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object importantReactorsModel = new ImportantReactorsModel();
                    ((BaseModel) importantReactorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (importantReactorsModel instanceof Postprocessable) {
                        return ((Postprocessable) importantReactorsModel).a();
                    }
                    return importantReactorsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -341630258)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_long_press_report_duplicates */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f9826d;
                @Nullable
                private String f9827e;

                /* compiled from: android_place_picker_long_press_report_duplicates */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f9824a;
                    @Nullable
                    public String f9825b;
                }

                /* compiled from: android_place_picker_long_press_report_duplicates */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17116a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m17180b(jsonParser, flatBufferBuilder));
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

                /* compiled from: android_place_picker_long_press_report_duplicates */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17119a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m17179a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m17122a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m17123a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m17120a() {
                    if (this.b != null && this.f9826d == null) {
                        this.f9826d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f9826d;
                }

                @Nullable
                public final String m17124b() {
                    this.f9827e = super.a(this.f9827e, 1);
                    return this.f9827e;
                }

                public static NodesModel m17118a(NodesModel nodesModel) {
                    if (nodesModel == null) {
                        return null;
                    }
                    if (nodesModel instanceof NodesModel) {
                        return nodesModel;
                    }
                    Builder builder = new Builder();
                    builder.f9824a = nodesModel.m17120a();
                    builder.f9825b = nodesModel.m17124b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f9824a);
                    int b = flatBufferBuilder.b(builder.f9825b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m17121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17119a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17120a());
                    int b = flatBufferBuilder.b(m17124b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Serializer extends JsonSerializer<ImportantReactorsModel> {
                public final void m17125a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) obj;
                    if (importantReactorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(importantReactorsModel.m17127a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        importantReactorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImportantReactorsParser.m17182a(importantReactorsModel.w_(), importantReactorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ImportantReactorsModel.class, new Serializer());
                }
            }

            public ImportantReactorsModel() {
                super(1);
            }

            public ImportantReactorsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> m17129a() {
                this.f9828d = super.a(this.f9828d, 0, NodesModel.class);
                return (ImmutableList) this.f9828d;
            }

            public static ImportantReactorsModel m17126a(ImportantReactorsModel importantReactorsModel) {
                if (importantReactorsModel == null) {
                    return null;
                }
                if (importantReactorsModel instanceof ImportantReactorsModel) {
                    return importantReactorsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < importantReactorsModel.m17129a().size(); i++) {
                    builder2.c(NodesModel.m17118a((NodesModel) importantReactorsModel.m17129a().get(i)));
                }
                builder.f9823a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f9823a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ImportantReactorsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 376615537;
            }

            public final GraphQLVisitableModel m17128a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17129a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m17129a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ImportantReactorsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9828d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17127a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17129a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<ViewerReactionsSocialFeedbackFieldsModel> {
            public final void m17130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ViewerReactionsSocialFeedbackFieldsModel viewerReactionsSocialFeedbackFieldsModel = (ViewerReactionsSocialFeedbackFieldsModel) obj;
                if (viewerReactionsSocialFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(viewerReactionsSocialFeedbackFieldsModel.m17141a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    viewerReactionsSocialFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = viewerReactionsSocialFeedbackFieldsModel.w_();
                int u_ = viewerReactionsSocialFeedbackFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("important_reactors");
                    ImportantReactorsParser.m17182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("viewer_acts_as_person");
                    ViewerActsAsPersonParser.m17184a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ViewerReactionsSocialFeedbackFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_long_press_report_duplicates */
        public final class ViewerActsAsPersonModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f9830d;

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public final class Builder {
                @Nullable
                public String f9829a;
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerActsAsPersonModel.class, new Deserializer());
                }

                public Object m17131a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerActsAsPersonParser.m17183a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerActsAsPersonModel = new ViewerActsAsPersonModel();
                    ((BaseModel) viewerActsAsPersonModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerActsAsPersonModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerActsAsPersonModel).a();
                    }
                    return viewerActsAsPersonModel;
                }
            }

            /* compiled from: android_place_picker_long_press_report_duplicates */
            public class Serializer extends JsonSerializer<ViewerActsAsPersonModel> {
                public final void m17132a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) obj;
                    if (viewerActsAsPersonModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerActsAsPersonModel.m17134a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerActsAsPersonModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerActsAsPersonParser.m17184a(viewerActsAsPersonModel.w_(), viewerActsAsPersonModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerActsAsPersonModel.class, new Serializer());
                }
            }

            public ViewerActsAsPersonModel() {
                super(1);
            }

            public ViewerActsAsPersonModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m17137a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17138a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m17136a() {
                this.f9830d = super.a(this.f9830d, 0);
                return this.f9830d;
            }

            public static ViewerActsAsPersonModel m17133a(ViewerActsAsPersonModel viewerActsAsPersonModel) {
                if (viewerActsAsPersonModel == null) {
                    return null;
                }
                if (viewerActsAsPersonModel instanceof ViewerActsAsPersonModel) {
                    return viewerActsAsPersonModel;
                }
                Builder builder = new Builder();
                builder.f9829a = viewerActsAsPersonModel.m17136a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f9829a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ViewerActsAsPersonModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17134a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17136a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ViewerReactionsSocialFeedbackFieldsModel() {
            super(2);
        }

        public final void m17143a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17144a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ImportantReactorsModel m17139a() {
            this.f9831d = (ImportantReactorsModel) super.a(this.f9831d, 0, ImportantReactorsModel.class);
            return this.f9831d;
        }

        @Nullable
        private ViewerActsAsPersonModel m17140j() {
            this.f9832e = (ViewerActsAsPersonModel) super.a(this.f9832e, 1, ViewerActsAsPersonModel.class);
            return this.f9832e;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m17142a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17139a() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m17139a());
                if (m17139a() != importantReactorsModel) {
                    graphQLVisitableModel = (ViewerReactionsSocialFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9831d = importantReactorsModel;
                }
            }
            if (m17140j() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m17140j());
                if (m17140j() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (ViewerReactionsSocialFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9832e = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17141a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17139a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17140j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
