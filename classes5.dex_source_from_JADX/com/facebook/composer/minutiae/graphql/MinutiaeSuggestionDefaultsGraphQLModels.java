package com.facebook.composer.minutiae.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeIconModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableObjectFieldsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLParsers.MinutiaeTaggableSuggestionsParser;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLParsers.MinutiaeTaggableSuggestionsParser.NodeParser;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLParsers.MinutiaeTaggableSuggestionsParser.NodeParser.TaggableActivityIconParser;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLParsers.MinutiaeTaggableSuggestionsParser.SubtextParser;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLParsers.RidgeSuggestionsQueryParser;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLParsers.RidgeSuggestionsQueryParser.SuggestedTaggableActivitiesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTaggableActivitySuggestionMechanism;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: additional_suggested_post_ads */
public class MinutiaeSuggestionDefaultsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 723325815)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: additional_suggested_post_ads */
    public final class MinutiaeTaggableSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<MinutiaeIconModel> f11461d;
        @Nullable
        private String f11462e;
        @Nullable
        private NodeModel f11463f;
        @Nullable
        private SubtextModel f11464g;
        @Nullable
        private List<GraphQLTaggableActivitySuggestionMechanism> f11465h;
        @Nullable
        private String f11466i;

        /* compiled from: additional_suggested_post_ads */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeTaggableSuggestionsModel.class, new Deserializer());
            }

            public Object m19541a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaeTaggableSuggestionsParser.m19592b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaeTaggableSuggestionsModel = new MinutiaeTaggableSuggestionsModel();
                ((BaseModel) minutiaeTaggableSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaeTaggableSuggestionsModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeTaggableSuggestionsModel).a();
                }
                return minutiaeTaggableSuggestionsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1142116358)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: additional_suggested_post_ads */
        public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MinutiaeTaggableObjectFieldsModel f11457d;
            @Nullable
            private MinutiaeTaggableActivityModel f11458e;
            @Nullable
            private TaggableActivityIconModel f11459f;

            /* compiled from: additional_suggested_post_ads */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m19542a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m19588a(jsonParser, flatBufferBuilder));
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

            /* compiled from: additional_suggested_post_ads */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m19543a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m19554a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m19589a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1157469815)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: additional_suggested_post_ads */
            public final class TaggableActivityIconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private DefaultImageFieldsModel f11456d;

                /* compiled from: additional_suggested_post_ads */
                public final class Builder {
                    @Nullable
                    public DefaultImageFieldsModel f11455a;
                }

                /* compiled from: additional_suggested_post_ads */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TaggableActivityIconModel.class, new Deserializer());
                    }

                    public Object m19544a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TaggableActivityIconParser.m19586a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object taggableActivityIconModel = new TaggableActivityIconModel();
                        ((BaseModel) taggableActivityIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (taggableActivityIconModel instanceof Postprocessable) {
                            return ((Postprocessable) taggableActivityIconModel).a();
                        }
                        return taggableActivityIconModel;
                    }
                }

                /* compiled from: additional_suggested_post_ads */
                public class Serializer extends JsonSerializer<TaggableActivityIconModel> {
                    public final void m19545a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TaggableActivityIconModel taggableActivityIconModel = (TaggableActivityIconModel) obj;
                        if (taggableActivityIconModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(taggableActivityIconModel.m19547a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            taggableActivityIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TaggableActivityIconParser.m19587a(taggableActivityIconModel.w_(), taggableActivityIconModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(TaggableActivityIconModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields m19548a() {
                    return m19550j();
                }

                public TaggableActivityIconModel() {
                    super(1);
                }

                public TaggableActivityIconModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final DefaultImageFieldsModel m19550j() {
                    this.f11456d = (DefaultImageFieldsModel) super.a(this.f11456d, 0, DefaultImageFieldsModel.class);
                    return this.f11456d;
                }

                public static TaggableActivityIconModel m19546a(TaggableActivityIconModel taggableActivityIconModel) {
                    if (taggableActivityIconModel == null) {
                        return null;
                    }
                    if (taggableActivityIconModel instanceof TaggableActivityIconModel) {
                        return taggableActivityIconModel;
                    }
                    Builder builder = new Builder();
                    builder.f11455a = DefaultImageFieldsModel.a(taggableActivityIconModel.m19548a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f11455a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new TaggableActivityIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 638969039;
                }

                public final GraphQLVisitableModel m19549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m19550j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19550j());
                        if (m19550j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (TaggableActivityIconModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11456d = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m19547a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m19550j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ MinutiaeTaggableObjectFieldsModel m19555a() {
                return m19551j();
            }

            @Nullable
            public final /* synthetic */ MinutiaeTaggableActivity m19557b() {
                return m19552k();
            }

            @Nullable
            public final /* synthetic */ TaggableActivityIconModel m19558c() {
                return m19553l();
            }

            public NodeModel() {
                super(3);
            }

            @Nullable
            private MinutiaeTaggableObjectFieldsModel m19551j() {
                this.f11457d = (MinutiaeTaggableObjectFieldsModel) super.a(this.f11457d, 0, MinutiaeTaggableObjectFieldsModel.class);
                return this.f11457d;
            }

            @Nullable
            private MinutiaeTaggableActivityModel m19552k() {
                this.f11458e = (MinutiaeTaggableActivityModel) super.a(this.f11458e, 1, MinutiaeTaggableActivityModel.class);
                return this.f11458e;
            }

            @Nullable
            private TaggableActivityIconModel m19553l() {
                this.f11459f = (TaggableActivityIconModel) super.a(this.f11459f, 2, TaggableActivityIconModel.class);
                return this.f11459f;
            }

            public final int jK_() {
                return 1291787496;
            }

            public final GraphQLVisitableModel m19556a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19551j() != null) {
                    MinutiaeTaggableObjectFieldsModel minutiaeTaggableObjectFieldsModel = (MinutiaeTaggableObjectFieldsModel) graphQLModelMutatingVisitor.b(m19551j());
                    if (m19551j() != minutiaeTaggableObjectFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11457d = minutiaeTaggableObjectFieldsModel;
                    }
                }
                if (m19552k() != null) {
                    MinutiaeTaggableActivityModel minutiaeTaggableActivityModel = (MinutiaeTaggableActivityModel) graphQLModelMutatingVisitor.b(m19552k());
                    if (m19552k() != minutiaeTaggableActivityModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11458e = minutiaeTaggableActivityModel;
                    }
                }
                if (m19553l() != null) {
                    TaggableActivityIconModel taggableActivityIconModel = (TaggableActivityIconModel) graphQLModelMutatingVisitor.b(m19553l());
                    if (m19553l() != taggableActivityIconModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11459f = taggableActivityIconModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19554a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19551j());
                int a2 = ModelHelper.a(flatBufferBuilder, m19552k());
                int a3 = ModelHelper.a(flatBufferBuilder, m19553l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: additional_suggested_post_ads */
        public class Serializer extends JsonSerializer<MinutiaeTaggableSuggestionsModel> {
            public final void m19559a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel = (MinutiaeTaggableSuggestionsModel) obj;
                if (minutiaeTaggableSuggestionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeTaggableSuggestionsModel.m19568a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeTaggableSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaeTaggableSuggestionsParser.m19593b(minutiaeTaggableSuggestionsModel.w_(), minutiaeTaggableSuggestionsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaeTaggableSuggestionsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: additional_suggested_post_ads */
        public final class SubtextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11460d;

            /* compiled from: additional_suggested_post_ads */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtextModel.class, new Deserializer());
                }

                public Object m19560a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubtextParser.m19590a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subtextModel = new SubtextModel();
                    ((BaseModel) subtextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subtextModel instanceof Postprocessable) {
                        return ((Postprocessable) subtextModel).a();
                    }
                    return subtextModel;
                }
            }

            /* compiled from: additional_suggested_post_ads */
            public class Serializer extends JsonSerializer<SubtextModel> {
                public final void m19561a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtextModel subtextModel = (SubtextModel) obj;
                    if (subtextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtextModel.m19562a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubtextParser.m19591a(subtextModel.w_(), subtextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtextModel.class, new Serializer());
                }
            }

            public SubtextModel() {
                super(1);
            }

            @Nullable
            public final String m19564a() {
                this.f11460d = super.a(this.f11460d, 0);
                return this.f11460d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m19563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19562a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19564a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ NodeModel m19572c() {
            return m19565j();
        }

        @Nullable
        public final /* synthetic */ SubtextModel m19573d() {
            return m19566k();
        }

        public MinutiaeTaggableSuggestionsModel() {
            super(6);
        }

        @Nonnull
        public final ImmutableList<MinutiaeIconModel> m19570a() {
            this.f11461d = super.a(this.f11461d, 0, MinutiaeIconModel.class);
            return (ImmutableList) this.f11461d;
        }

        @Nullable
        public final String m19571b() {
            this.f11462e = super.a(this.f11462e, 1);
            return this.f11462e;
        }

        @Nullable
        private NodeModel m19565j() {
            this.f11463f = (NodeModel) super.a(this.f11463f, 2, NodeModel.class);
            return this.f11463f;
        }

        @Nullable
        private SubtextModel m19566k() {
            this.f11464g = (SubtextModel) super.a(this.f11464g, 3, SubtextModel.class);
            return this.f11464g;
        }

        @Nonnull
        public final ImmutableList<GraphQLTaggableActivitySuggestionMechanism> ag_() {
            this.f11465h = super.c(this.f11465h, 4, GraphQLTaggableActivitySuggestionMechanism.class);
            return (ImmutableList) this.f11465h;
        }

        @Nullable
        private String m19567l() {
            this.f11466i = super.a(this.f11466i, 5);
            return this.f11466i;
        }

        public final int jK_() {
            return 864061684;
        }

        public final GraphQLVisitableModel m19569a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            NodeModel nodeModel;
            SubtextModel subtextModel;
            h();
            if (m19570a() != null) {
                Builder a = ModelHelper.a(m19570a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel = (MinutiaeTaggableSuggestionsModel) ModelHelper.a(null, this);
                    minutiaeTaggableSuggestionsModel.f11461d = a.b();
                    graphQLVisitableModel = minutiaeTaggableSuggestionsModel;
                    if (m19565j() != null) {
                        nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m19565j());
                        if (m19565j() != nodeModel) {
                            graphQLVisitableModel = (MinutiaeTaggableSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f11463f = nodeModel;
                        }
                    }
                    if (m19566k() != null) {
                        subtextModel = (SubtextModel) graphQLModelMutatingVisitor.b(m19566k());
                        if (m19566k() != subtextModel) {
                            graphQLVisitableModel = (MinutiaeTaggableSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f11464g = subtextModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m19565j() != null) {
                nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m19565j());
                if (m19565j() != nodeModel) {
                    graphQLVisitableModel = (MinutiaeTaggableSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11463f = nodeModel;
                }
            }
            if (m19566k() != null) {
                subtextModel = (SubtextModel) graphQLModelMutatingVisitor.b(m19566k());
                if (m19566k() != subtextModel) {
                    graphQLVisitableModel = (MinutiaeTaggableSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11464g = subtextModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m19568a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19570a());
            int b = flatBufferBuilder.b(m19571b());
            int a2 = ModelHelper.a(flatBufferBuilder, m19565j());
            int a3 = ModelHelper.a(flatBufferBuilder, m19566k());
            int d = flatBufferBuilder.d(ag_());
            int b2 = flatBufferBuilder.b(m19567l());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, d);
            flatBufferBuilder.b(5, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1727277514)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: additional_suggested_post_ads */
    public final class RidgeSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestedTaggableActivitiesModel f11469d;

        /* compiled from: additional_suggested_post_ads */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RidgeSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m19574a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RidgeSuggestionsQueryParser.m19596a(jsonParser);
                Object ridgeSuggestionsQueryModel = new RidgeSuggestionsQueryModel();
                ((BaseModel) ridgeSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (ridgeSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) ridgeSuggestionsQueryModel).a();
                }
                return ridgeSuggestionsQueryModel;
            }
        }

        /* compiled from: additional_suggested_post_ads */
        public class Serializer extends JsonSerializer<RidgeSuggestionsQueryModel> {
            public final void m19575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RidgeSuggestionsQueryModel ridgeSuggestionsQueryModel = (RidgeSuggestionsQueryModel) obj;
                if (ridgeSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ridgeSuggestionsQueryModel.m19583a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    ridgeSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = ridgeSuggestionsQueryModel.w_();
                int u_ = ridgeSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggested_taggable_activities");
                    SuggestedTaggableActivitiesParser.m19595a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RidgeSuggestionsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -856840884)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: additional_suggested_post_ads */
        public final class SuggestedTaggableActivitiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MinutiaeTaggableSuggestionsModel> f11467d;
            private boolean f11468e;

            /* compiled from: additional_suggested_post_ads */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedTaggableActivitiesModel.class, new Deserializer());
                }

                public Object m19576a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestedTaggableActivitiesParser.m19594a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedTaggableActivitiesModel = new SuggestedTaggableActivitiesModel();
                    ((BaseModel) suggestedTaggableActivitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedTaggableActivitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedTaggableActivitiesModel).a();
                    }
                    return suggestedTaggableActivitiesModel;
                }
            }

            /* compiled from: additional_suggested_post_ads */
            public class Serializer extends JsonSerializer<SuggestedTaggableActivitiesModel> {
                public final void m19577a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedTaggableActivitiesModel suggestedTaggableActivitiesModel = (SuggestedTaggableActivitiesModel) obj;
                    if (suggestedTaggableActivitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedTaggableActivitiesModel.m19578a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedTaggableActivitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestedTaggableActivitiesParser.m19595a(suggestedTaggableActivitiesModel.w_(), suggestedTaggableActivitiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestedTaggableActivitiesModel.class, new Serializer());
                }
            }

            public SuggestedTaggableActivitiesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MinutiaeTaggableSuggestionsModel> m19580a() {
                this.f11467d = super.a(this.f11467d, 0, MinutiaeTaggableSuggestionsModel.class);
                return (ImmutableList) this.f11467d;
            }

            public final boolean m19582b() {
                a(0, 1);
                return this.f11468e;
            }

            public final int jK_() {
                return 705434837;
            }

            public final GraphQLVisitableModel m19579a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19580a() != null) {
                    Builder a = ModelHelper.a(m19580a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SuggestedTaggableActivitiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11467d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19578a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19580a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f11468e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19581a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11468e = mutableFlatBuffer.a(i, 1);
            }
        }

        public RidgeSuggestionsQueryModel() {
            super(1);
        }

        @Nullable
        public final SuggestedTaggableActivitiesModel m19584a() {
            this.f11469d = (SuggestedTaggableActivitiesModel) super.a(this.f11469d, 0, SuggestedTaggableActivitiesModel.class);
            return this.f11469d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m19585a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19584a() != null) {
                SuggestedTaggableActivitiesModel suggestedTaggableActivitiesModel = (SuggestedTaggableActivitiesModel) graphQLModelMutatingVisitor.b(m19584a());
                if (m19584a() != suggestedTaggableActivitiesModel) {
                    graphQLVisitableModel = (RidgeSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11469d = suggestedTaggableActivitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19583a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19584a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
