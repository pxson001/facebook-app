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
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlInterfaces.PulsePhrasesAnalysisExternalUrl;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser.PhrasesParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser.PhrasesParser.EdgesParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser.PhrasesParser.EdgesParser.NodeParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser.PhrasesParser.EdgesParser.NodeParser.MorePostsQueryParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser.PhrasesParser.EdgesParser.NodeParser.MorePostsQueryParser.QueryTitleParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser.PhrasesParser.EdgesParser.NodeParser.PhraseOwnerParser;
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

/* compiled from: messenger_content_subscription_banner_impression */
public class PulsePhrasesAnalysisExternalUrlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -246791316)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_content_subscription_banner_impression */
    public final class PulsePhrasesAnalysisExternalUrlModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PulsePhrasesAnalysisExternalUrl {
        @Nullable
        private String f8787d;
        @Nullable
        private PhrasesAnalysisModel f8788e;

        /* compiled from: messenger_content_subscription_banner_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PulsePhrasesAnalysisExternalUrlModel.class, new Deserializer());
            }

            public Object m10288a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PulsePhrasesAnalysisExternalUrlParser.m10372a(jsonParser);
                Object pulsePhrasesAnalysisExternalUrlModel = new PulsePhrasesAnalysisExternalUrlModel();
                ((BaseModel) pulsePhrasesAnalysisExternalUrlModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pulsePhrasesAnalysisExternalUrlModel instanceof Postprocessable) {
                    return ((Postprocessable) pulsePhrasesAnalysisExternalUrlModel).a();
                }
                return pulsePhrasesAnalysisExternalUrlModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1944577888)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messenger_content_subscription_banner_impression */
        public final class PhrasesAnalysisModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhrasesModel f8786d;

            /* compiled from: messenger_content_subscription_banner_impression */
            public final class Builder {
                @Nullable
                public PhrasesModel f8747a;
            }

            /* compiled from: messenger_content_subscription_banner_impression */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhrasesAnalysisModel.class, new Deserializer());
                }

                public Object m10289a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhrasesAnalysisParser.m10370a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object phrasesAnalysisModel = new PhrasesAnalysisModel();
                    ((BaseModel) phrasesAnalysisModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (phrasesAnalysisModel instanceof Postprocessable) {
                        return ((Postprocessable) phrasesAnalysisModel).a();
                    }
                    return phrasesAnalysisModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1513959620)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: messenger_content_subscription_banner_impression */
            public final class PhrasesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f8785d;

                /* compiled from: messenger_content_subscription_banner_impression */
                public final class Builder {
                    @Nullable
                    public ImmutableList<EdgesModel> f8748a;
                }

                /* compiled from: messenger_content_subscription_banner_impression */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhrasesModel.class, new Deserializer());
                    }

                    public Object m10290a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhrasesParser.m10368a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object phrasesModel = new PhrasesModel();
                        ((BaseModel) phrasesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (phrasesModel instanceof Postprocessable) {
                            return ((Postprocessable) phrasesModel).a();
                        }
                        return phrasesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1455565356)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: messenger_content_subscription_banner_impression */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f8784d;

                    /* compiled from: messenger_content_subscription_banner_impression */
                    public final class Builder {
                        @Nullable
                        public NodeModel f8749a;
                    }

                    /* compiled from: messenger_content_subscription_banner_impression */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m10291a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m10366b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 832336808)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: messenger_content_subscription_banner_impression */
                    public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        private int f8775d;
                        @Nullable
                        private String f8776e;
                        @Nullable
                        private MorePostsQueryModel f8777f;
                        @Nullable
                        private String f8778g;
                        private int f8779h;
                        private int f8780i;
                        @Nullable
                        private PhraseOwnerModel f8781j;
                        @Nullable
                        private String f8782k;
                        @Nullable
                        private String f8783l;

                        /* compiled from: messenger_content_subscription_banner_impression */
                        public final class Builder {
                            public int f8750a;
                            @Nullable
                            public String f8751b;
                            @Nullable
                            public MorePostsQueryModel f8752c;
                            @Nullable
                            public String f8753d;
                            public int f8754e;
                            public int f8755f;
                            @Nullable
                            public PhraseOwnerModel f8756g;
                            @Nullable
                            public String f8757h;
                            @Nullable
                            public String f8758i;
                        }

                        /* compiled from: messenger_content_subscription_banner_impression */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m10292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m10364a(jsonParser, flatBufferBuilder));
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
                        @ModelWithFlatBufferFormatHash(a = 1806140657)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: messenger_content_subscription_banner_impression */
                        public final class MorePostsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                            @Nullable
                            private String f8765d;
                            @Nullable
                            private String f8766e;
                            @Nullable
                            private QueryTitleModel f8767f;
                            @Nullable
                            private List<GraphQLGraphSearchResultsDisplayStyle> f8768g;

                            /* compiled from: messenger_content_subscription_banner_impression */
                            public final class Builder {
                                @Nullable
                                public String f8759a;
                                @Nullable
                                public String f8760b;
                                @Nullable
                                public QueryTitleModel f8761c;
                                @Nullable
                                public ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f8762d;
                            }

                            /* compiled from: messenger_content_subscription_banner_impression */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MorePostsQueryModel.class, new Deserializer());
                                }

                                public Object m10293a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MorePostsQueryParser.m10360a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object morePostsQueryModel = new MorePostsQueryModel();
                                    ((BaseModel) morePostsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (morePostsQueryModel instanceof Postprocessable) {
                                        return ((Postprocessable) morePostsQueryModel).a();
                                    }
                                    return morePostsQueryModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -1352864475)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: messenger_content_subscription_banner_impression */
                            public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private String f8764d;

                                /* compiled from: messenger_content_subscription_banner_impression */
                                public final class Builder {
                                    @Nullable
                                    public String f8763a;
                                }

                                /* compiled from: messenger_content_subscription_banner_impression */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                                    }

                                    public Object m10294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(QueryTitleParser.m10358a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object queryTitleModel = new QueryTitleModel();
                                        ((BaseModel) queryTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (queryTitleModel instanceof Postprocessable) {
                                            return ((Postprocessable) queryTitleModel).a();
                                        }
                                        return queryTitleModel;
                                    }
                                }

                                /* compiled from: messenger_content_subscription_banner_impression */
                                public class Serializer extends JsonSerializer<QueryTitleModel> {
                                    public final void m10295a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                                        if (queryTitleModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(queryTitleModel.m10297a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        QueryTitleParser.m10359a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                                    }

                                    static {
                                        FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                                    }
                                }

                                public QueryTitleModel() {
                                    super(1);
                                }

                                public QueryTitleModel(MutableFlatBuffer mutableFlatBuffer) {
                                    super(1);
                                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }

                                @Nullable
                                public final String m10299a() {
                                    this.f8764d = super.a(this.f8764d, 0);
                                    return this.f8764d;
                                }

                                public static QueryTitleModel m10296a(QueryTitleModel queryTitleModel) {
                                    if (queryTitleModel == null) {
                                        return null;
                                    }
                                    if (queryTitleModel instanceof QueryTitleModel) {
                                        return queryTitleModel;
                                    }
                                    Builder builder = new Builder();
                                    builder.f8763a = queryTitleModel.m10299a();
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    int b = flatBufferBuilder.b(builder.f8763a);
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, b);
                                    flatBufferBuilder.d(flatBufferBuilder.d());
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    return new QueryTitleModel(new MutableFlatBuffer(wrap, null, null, true, null));
                                }

                                public final int jK_() {
                                    return -1696096378;
                                }

                                public final GraphQLVisitableModel m10298a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    h();
                                    i();
                                    return this;
                                }

                                public final int m10297a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int b = flatBufferBuilder.b(m10299a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, b);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: messenger_content_subscription_banner_impression */
                            public class Serializer extends JsonSerializer<MorePostsQueryModel> {
                                public final void m10300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MorePostsQueryModel morePostsQueryModel = (MorePostsQueryModel) obj;
                                    if (morePostsQueryModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(morePostsQueryModel.m10303a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        morePostsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MorePostsQueryParser.m10361a(morePostsQueryModel.w_(), morePostsQueryModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(MorePostsQueryModel.class, new Serializer());
                                }
                            }

                            @Nullable
                            public final /* synthetic */ QueryTitleModel m10308d() {
                                return m10302j();
                            }

                            public MorePostsQueryModel() {
                                super(4);
                            }

                            public MorePostsQueryModel(MutableFlatBuffer mutableFlatBuffer) {
                                super(4);
                                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }

                            @Nullable
                            public final String m10306b() {
                                this.f8765d = super.a(this.f8765d, 0);
                                return this.f8765d;
                            }

                            @Nullable
                            public final String m10307c() {
                                this.f8766e = super.a(this.f8766e, 1);
                                return this.f8766e;
                            }

                            @Nullable
                            private QueryTitleModel m10302j() {
                                this.f8767f = (QueryTitleModel) super.a(this.f8767f, 2, QueryTitleModel.class);
                                return this.f8767f;
                            }

                            @Nonnull
                            public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> jt_() {
                                this.f8768g = super.c(this.f8768g, 3, GraphQLGraphSearchResultsDisplayStyle.class);
                                return (ImmutableList) this.f8768g;
                            }

                            public static MorePostsQueryModel m10301a(MorePostsQueryModel morePostsQueryModel) {
                                if (morePostsQueryModel == null) {
                                    return null;
                                }
                                if (morePostsQueryModel instanceof MorePostsQueryModel) {
                                    return morePostsQueryModel;
                                }
                                Builder builder = new Builder();
                                builder.f8759a = morePostsQueryModel.m10306b();
                                builder.f8760b = morePostsQueryModel.m10307c();
                                builder.f8761c = QueryTitleModel.m10296a(morePostsQueryModel.m10308d());
                                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                                for (int i = 0; i < morePostsQueryModel.jt_().size(); i++) {
                                    builder2.c(morePostsQueryModel.jt_().get(i));
                                }
                                builder.f8762d = builder2.b();
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int b = flatBufferBuilder.b(builder.f8759a);
                                int b2 = flatBufferBuilder.b(builder.f8760b);
                                int a = ModelHelper.a(flatBufferBuilder, builder.f8761c);
                                int d = flatBufferBuilder.d(builder.f8762d);
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, b2);
                                flatBufferBuilder.b(2, a);
                                flatBufferBuilder.b(3, d);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new MorePostsQueryModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }

                            @Nullable
                            public final String m10305a() {
                                return m10306b();
                            }

                            public final int jK_() {
                                return -466486798;
                            }

                            public final GraphQLVisitableModel m10304a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m10302j() != null) {
                                    QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m10302j());
                                    if (m10302j() != queryTitleModel) {
                                        graphQLVisitableModel = (MorePostsQueryModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f8767f = queryTitleModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m10303a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m10306b());
                                int b2 = flatBufferBuilder.b(m10307c());
                                int a = ModelHelper.a(flatBufferBuilder, m10302j());
                                int d = flatBufferBuilder.d(jt_());
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, b2);
                                flatBufferBuilder.b(2, a);
                                flatBufferBuilder.b(3, d);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1830386992)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: messenger_content_subscription_banner_impression */
                        public final class PhraseOwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                            @Nullable
                            private GraphQLObjectType f8772d;
                            @Nullable
                            private String f8773e;
                            @Nullable
                            private DefaultImageFieldsModel f8774f;

                            /* compiled from: messenger_content_subscription_banner_impression */
                            public final class Builder {
                                @Nullable
                                public GraphQLObjectType f8769a;
                                @Nullable
                                public String f8770b;
                                @Nullable
                                public DefaultImageFieldsModel f8771c;
                            }

                            /* compiled from: messenger_content_subscription_banner_impression */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(PhraseOwnerModel.class, new Deserializer());
                                }

                                public Object m10309a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(PhraseOwnerParser.m10362a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object phraseOwnerModel = new PhraseOwnerModel();
                                    ((BaseModel) phraseOwnerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (phraseOwnerModel instanceof Postprocessable) {
                                        return ((Postprocessable) phraseOwnerModel).a();
                                    }
                                    return phraseOwnerModel;
                                }
                            }

                            /* compiled from: messenger_content_subscription_banner_impression */
                            public class Serializer extends JsonSerializer<PhraseOwnerModel> {
                                public final void m10310a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    PhraseOwnerModel phraseOwnerModel = (PhraseOwnerModel) obj;
                                    if (phraseOwnerModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(phraseOwnerModel.m10313a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        phraseOwnerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    PhraseOwnerParser.m10363a(phraseOwnerModel.w_(), phraseOwnerModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(PhraseOwnerModel.class, new Serializer());
                                }
                            }

                            @Nullable
                            public final /* synthetic */ DefaultImageFields m10320d() {
                                return m10312j();
                            }

                            public PhraseOwnerModel() {
                                super(3);
                            }

                            public PhraseOwnerModel(MutableFlatBuffer mutableFlatBuffer) {
                                super(3);
                                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }

                            public final void m10316a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m10317a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            public final GraphQLObjectType m10318b() {
                                if (this.b != null && this.f8772d == null) {
                                    this.f8772d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                }
                                return this.f8772d;
                            }

                            @Nullable
                            public final String m10319c() {
                                this.f8773e = super.a(this.f8773e, 1);
                                return this.f8773e;
                            }

                            @Nullable
                            private DefaultImageFieldsModel m10312j() {
                                this.f8774f = (DefaultImageFieldsModel) super.a(this.f8774f, 2, DefaultImageFieldsModel.class);
                                return this.f8774f;
                            }

                            public static PhraseOwnerModel m10311a(PhraseOwnerModel phraseOwnerModel) {
                                if (phraseOwnerModel == null) {
                                    return null;
                                }
                                if (phraseOwnerModel instanceof PhraseOwnerModel) {
                                    return phraseOwnerModel;
                                }
                                Builder builder = new Builder();
                                builder.f8769a = phraseOwnerModel.m10318b();
                                builder.f8770b = phraseOwnerModel.m10319c();
                                builder.f8771c = DefaultImageFieldsModel.a(phraseOwnerModel.m10320d());
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int a = ModelHelper.a(flatBufferBuilder, builder.f8769a);
                                int b = flatBufferBuilder.b(builder.f8770b);
                                int a2 = ModelHelper.a(flatBufferBuilder, builder.f8771c);
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, b);
                                flatBufferBuilder.b(2, a2);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new PhraseOwnerModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }

                            @Nullable
                            public final String m10315a() {
                                return m10319c();
                            }

                            public final int jK_() {
                                return 1355227529;
                            }

                            public final GraphQLVisitableModel m10314a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m10312j() != null) {
                                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10312j());
                                    if (m10312j() != defaultImageFieldsModel) {
                                        graphQLVisitableModel = (PhraseOwnerModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f8774f = defaultImageFieldsModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m10313a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m10318b());
                                int b = flatBufferBuilder.b(m10319c());
                                int a2 = ModelHelper.a(flatBufferBuilder, m10312j());
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, b);
                                flatBufferBuilder.b(2, a2);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: messenger_content_subscription_banner_impression */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m10321a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m10325a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m10365a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ MorePostsQueryModel m10331d() {
                            return m10323l();
                        }

                        @Nullable
                        public final /* synthetic */ PhraseOwnerModel js_() {
                            return m10324m();
                        }

                        public NodeModel() {
                            super(9);
                        }

                        public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(9);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        public final int m10329b() {
                            a(0, 0);
                            return this.f8775d;
                        }

                        @Nullable
                        public final String m10330c() {
                            this.f8776e = super.a(this.f8776e, 1);
                            return this.f8776e;
                        }

                        @Nullable
                        private MorePostsQueryModel m10323l() {
                            this.f8777f = (MorePostsQueryModel) super.a(this.f8777f, 2, MorePostsQueryModel.class);
                            return this.f8777f;
                        }

                        @Nullable
                        public final String jq_() {
                            this.f8778g = super.a(this.f8778g, 3);
                            return this.f8778g;
                        }

                        public final int m10332g() {
                            a(0, 4);
                            return this.f8779h;
                        }

                        public final int jr_() {
                            a(0, 5);
                            return this.f8780i;
                        }

                        @Nullable
                        private PhraseOwnerModel m10324m() {
                            this.f8781j = (PhraseOwnerModel) super.a(this.f8781j, 6, PhraseOwnerModel.class);
                            return this.f8781j;
                        }

                        @Nullable
                        public final String m10333j() {
                            this.f8782k = super.a(this.f8782k, 7);
                            return this.f8782k;
                        }

                        @Nullable
                        public final String m10334k() {
                            this.f8783l = super.a(this.f8783l, 8);
                            return this.f8783l;
                        }

                        public static NodeModel m10322a(NodeModel nodeModel) {
                            if (nodeModel == null) {
                                return null;
                            }
                            if (nodeModel instanceof NodeModel) {
                                return nodeModel;
                            }
                            Builder builder = new Builder();
                            builder.f8750a = nodeModel.m10329b();
                            builder.f8751b = nodeModel.m10330c();
                            builder.f8752c = MorePostsQueryModel.m10301a(nodeModel.m10331d());
                            builder.f8753d = nodeModel.jq_();
                            builder.f8754e = nodeModel.m10332g();
                            builder.f8755f = nodeModel.jr_();
                            builder.f8756g = PhraseOwnerModel.m10311a(nodeModel.js_());
                            builder.f8757h = nodeModel.m10333j();
                            builder.f8758i = nodeModel.m10334k();
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int b = flatBufferBuilder.b(builder.f8751b);
                            int a = ModelHelper.a(flatBufferBuilder, builder.f8752c);
                            int b2 = flatBufferBuilder.b(builder.f8753d);
                            int a2 = ModelHelper.a(flatBufferBuilder, builder.f8756g);
                            int b3 = flatBufferBuilder.b(builder.f8757h);
                            int b4 = flatBufferBuilder.b(builder.f8758i);
                            flatBufferBuilder.c(9);
                            flatBufferBuilder.a(0, builder.f8750a, 0);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.b(2, a);
                            flatBufferBuilder.b(3, b2);
                            flatBufferBuilder.a(4, builder.f8754e, 0);
                            flatBufferBuilder.a(5, builder.f8755f, 0);
                            flatBufferBuilder.b(6, a2);
                            flatBufferBuilder.b(7, b3);
                            flatBufferBuilder.b(8, b4);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }

                        @Nullable
                        public final String m10327a() {
                            return m10330c();
                        }

                        public final int jK_() {
                            return -991219223;
                        }

                        public final GraphQLVisitableModel m10326a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m10323l() != null) {
                                MorePostsQueryModel morePostsQueryModel = (MorePostsQueryModel) graphQLModelMutatingVisitor.b(m10323l());
                                if (m10323l() != morePostsQueryModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f8777f = morePostsQueryModel;
                                }
                            }
                            if (m10324m() != null) {
                                PhraseOwnerModel phraseOwnerModel = (PhraseOwnerModel) graphQLModelMutatingVisitor.b(m10324m());
                                if (m10324m() != phraseOwnerModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f8781j = phraseOwnerModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m10325a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m10330c());
                            int a = ModelHelper.a(flatBufferBuilder, m10323l());
                            int b2 = flatBufferBuilder.b(jq_());
                            int a2 = ModelHelper.a(flatBufferBuilder, m10324m());
                            int b3 = flatBufferBuilder.b(m10333j());
                            int b4 = flatBufferBuilder.b(m10334k());
                            flatBufferBuilder.c(9);
                            flatBufferBuilder.a(0, this.f8775d, 0);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.b(2, a);
                            flatBufferBuilder.b(3, b2);
                            flatBufferBuilder.a(4, this.f8779h, 0);
                            flatBufferBuilder.a(5, this.f8780i, 0);
                            flatBufferBuilder.b(6, a2);
                            flatBufferBuilder.b(7, b3);
                            flatBufferBuilder.b(8, b4);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m10328a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f8775d = mutableFlatBuffer.a(i, 0, 0);
                            this.f8779h = mutableFlatBuffer.a(i, 4, 0);
                            this.f8780i = mutableFlatBuffer.a(i, 5, 0);
                        }
                    }

                    /* compiled from: messenger_content_subscription_banner_impression */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m10335a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m10338a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m10367b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ NodeModel m10340a() {
                        return m10337j();
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    private NodeModel m10337j() {
                        this.f8784d = (NodeModel) super.a(this.f8784d, 0, NodeModel.class);
                        return this.f8784d;
                    }

                    public static EdgesModel m10336a(EdgesModel edgesModel) {
                        if (edgesModel == null) {
                            return null;
                        }
                        if (edgesModel instanceof EdgesModel) {
                            return edgesModel;
                        }
                        Builder builder = new Builder();
                        builder.f8749a = NodeModel.m10322a(edgesModel.m10340a());
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f8749a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return -948303737;
                    }

                    public final GraphQLVisitableModel m10339a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10337j() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m10337j());
                            if (m10337j() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8784d = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10338a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m10337j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: messenger_content_subscription_banner_impression */
                public class Serializer extends JsonSerializer<PhrasesModel> {
                    public final void m10341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhrasesModel phrasesModel = (PhrasesModel) obj;
                        if (phrasesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(phrasesModel.m10343a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            phrasesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhrasesParser.m10369a(phrasesModel.w_(), phrasesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhrasesModel.class, new Serializer());
                    }
                }

                public PhrasesModel() {
                    super(1);
                }

                public PhrasesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m10345a() {
                    this.f8785d = super.a(this.f8785d, 0, EdgesModel.class);
                    return (ImmutableList) this.f8785d;
                }

                public static PhrasesModel m10342a(PhrasesModel phrasesModel) {
                    if (phrasesModel == null) {
                        return null;
                    }
                    if (phrasesModel instanceof PhrasesModel) {
                        return phrasesModel;
                    }
                    Builder builder = new Builder();
                    com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (int i = 0; i < phrasesModel.m10345a().size(); i++) {
                        builder2.c(EdgesModel.m10336a((EdgesModel) phrasesModel.m10345a().get(i)));
                    }
                    builder.f8748a = builder2.b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f8748a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PhrasesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1226941912;
                }

                public final GraphQLVisitableModel m10344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10345a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10345a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (PhrasesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8785d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10343a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10345a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: messenger_content_subscription_banner_impression */
            public class Serializer extends JsonSerializer<PhrasesAnalysisModel> {
                public final void m10346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhrasesAnalysisModel phrasesAnalysisModel = (PhrasesAnalysisModel) obj;
                    if (phrasesAnalysisModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(phrasesAnalysisModel.m10349a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        phrasesAnalysisModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhrasesAnalysisParser.m10371a(phrasesAnalysisModel.w_(), phrasesAnalysisModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhrasesAnalysisModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PhrasesModel m10351a() {
                return m10348j();
            }

            public PhrasesAnalysisModel() {
                super(1);
            }

            public PhrasesAnalysisModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private PhrasesModel m10348j() {
                this.f8786d = (PhrasesModel) super.a(this.f8786d, 0, PhrasesModel.class);
                return this.f8786d;
            }

            public static PhrasesAnalysisModel m10347a(PhrasesAnalysisModel phrasesAnalysisModel) {
                if (phrasesAnalysisModel == null) {
                    return null;
                }
                if (phrasesAnalysisModel instanceof PhrasesAnalysisModel) {
                    return phrasesAnalysisModel;
                }
                Builder builder = new Builder();
                builder.f8747a = PhrasesModel.m10342a(phrasesAnalysisModel.m10351a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8747a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PhrasesAnalysisModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1668149834;
            }

            public final GraphQLVisitableModel m10350a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10348j() != null) {
                    PhrasesModel phrasesModel = (PhrasesModel) graphQLModelMutatingVisitor.b(m10348j());
                    if (m10348j() != phrasesModel) {
                        graphQLVisitableModel = (PhrasesAnalysisModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8786d = phrasesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10349a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10348j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: messenger_content_subscription_banner_impression */
        public class Serializer extends JsonSerializer<PulsePhrasesAnalysisExternalUrlModel> {
            public final void m10352a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PulsePhrasesAnalysisExternalUrlModel pulsePhrasesAnalysisExternalUrlModel = (PulsePhrasesAnalysisExternalUrlModel) obj;
                if (pulsePhrasesAnalysisExternalUrlModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pulsePhrasesAnalysisExternalUrlModel.m10355a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pulsePhrasesAnalysisExternalUrlModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pulsePhrasesAnalysisExternalUrlModel.w_();
                int u_ = pulsePhrasesAnalysisExternalUrlModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("phrases_analysis");
                    PhrasesAnalysisParser.m10371a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PulsePhrasesAnalysisExternalUrlModel.class, new Serializer());
            }
        }

        public PulsePhrasesAnalysisExternalUrlModel() {
            super(2);
        }

        @Nullable
        private String m10353j() {
            this.f8787d = super.a(this.f8787d, 0);
            return this.f8787d;
        }

        @Nullable
        private PhrasesAnalysisModel m10354k() {
            this.f8788e = (PhrasesAnalysisModel) super.a(this.f8788e, 1, PhrasesAnalysisModel.class);
            return this.f8788e;
        }

        @Nullable
        public final String m10357a() {
            return m10353j();
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m10356a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10354k() != null) {
                PhrasesAnalysisModel phrasesAnalysisModel = (PhrasesAnalysisModel) graphQLModelMutatingVisitor.b(m10354k());
                if (m10354k() != phrasesAnalysisModel) {
                    graphQLVisitableModel = (PulsePhrasesAnalysisExternalUrlModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8788e = phrasesAnalysisModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10355a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10353j());
            int a = ModelHelper.a(flatBufferBuilder, m10354k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
