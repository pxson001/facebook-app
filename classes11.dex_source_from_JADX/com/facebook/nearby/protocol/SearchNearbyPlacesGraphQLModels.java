package com.facebook.nearby.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNearbySearchResultCategory;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.nearby.protocol.NearbyTilesGraphQLModels.NearbyGeoRectangleModel;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.EdgesParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.EdgesParser.NodeParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.EdgesParser.NodeParser.ResultsParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.EdgesParser.NodeParser.ResultsParser.ResultsEdgesParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.EdgesParser.NodeParser.ResultsParser.ResultsEdgesParser.ResultsEdgesNodeParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.EdgesParser.NodeParser.ResultsParser.ResultsEdgesParser.ResultsEdgesNodeParser.AddressParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.NodesParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.NodesParser.TopicSuggestionsParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.NodesParser.TopicSuggestionsParser.TopicSuggestionsNodesParser;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLParsers.SearchNearbyPlacesParser.ResultSectionsParser.NodesParser.TopicSuggestionsParser.TopicSuggestionsNodesParser.TopicParser;
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

/* compiled from: topic_feed_option_deselect */
public class SearchNearbyPlacesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2110645060)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: topic_feed_option_deselect */
    public final class SearchNearbyPlacesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ResultSectionsModel f694d;
        @Nullable
        private String f695e;

        /* compiled from: topic_feed_option_deselect */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchNearbyPlacesModel.class, new Deserializer());
            }

            public Object m899a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchNearbyPlacesParser.m1010a(jsonParser);
                Object searchNearbyPlacesModel = new SearchNearbyPlacesModel();
                ((BaseModel) searchNearbyPlacesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchNearbyPlacesModel instanceof Postprocessable) {
                    return ((Postprocessable) searchNearbyPlacesModel).a();
                }
                return searchNearbyPlacesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1167374568)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: topic_feed_option_deselect */
        public final class ResultSectionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f692d;
            @Nullable
            private List<NodesModel> f693e;

            /* compiled from: topic_feed_option_deselect */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResultSectionsModel.class, new Deserializer());
                }

                public Object m900a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResultSectionsParser.m1008a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object resultSectionsModel = new ResultSectionsModel();
                    ((BaseModel) resultSectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (resultSectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) resultSectionsModel).a();
                    }
                    return resultSectionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 346013313)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: topic_feed_option_deselect */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f680d;

                /* compiled from: topic_feed_option_deselect */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m901a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m997b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 926987626)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: topic_feed_option_deselect */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLNearbySearchResultCategory f678d;
                    @Nullable
                    private ResultsModel f679e;

                    /* compiled from: topic_feed_option_deselect */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m902a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m995a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = -1216927719)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: topic_feed_option_deselect */
                    public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<ResultsEdgesModel> f677d;

                        /* compiled from: topic_feed_option_deselect */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                            }

                            public Object m903a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ResultsParser.m993a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object resultsModel = new ResultsModel();
                                ((BaseModel) resultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (resultsModel instanceof Postprocessable) {
                                    return ((Postprocessable) resultsModel).a();
                                }
                                return resultsModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -317859448)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: topic_feed_option_deselect */
                        public final class ResultsEdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private ResultsEdgesNodeModel f676d;

                            /* compiled from: topic_feed_option_deselect */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ResultsEdgesModel.class, new Deserializer());
                                }

                                public Object m904a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(ResultsEdgesParser.m991b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object resultsEdgesModel = new ResultsEdgesModel();
                                    ((BaseModel) resultsEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (resultsEdgesModel instanceof Postprocessable) {
                                        return ((Postprocessable) resultsEdgesModel).a();
                                    }
                                    return resultsEdgesModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = 1768871132)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: topic_feed_option_deselect */
                            public final class ResultsEdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                                @Nullable
                                private GraphQLObjectType f663d;
                                @Nullable
                                private AddressModel f664e;
                                @Nullable
                                private List<String> f665f;
                                private boolean f666g;
                                @Nullable
                                private String f667h;
                                private boolean f668i;
                                @Nullable
                                private DefaultLocationFieldsModel f669j;
                                private int f670k;
                                @Nullable
                                private String f671l;
                                private double f672m;
                                @Nullable
                                private GraphQLPlaceType f673n;
                                @Nullable
                                private DefaultImageFieldsModel f674o;
                                @Nullable
                                private GraphQLSavedState f675p;

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = 1000273915)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: topic_feed_option_deselect */
                                public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f660d;
                                    @Nullable
                                    private String f661e;
                                    @Nullable
                                    private String f662f;

                                    /* compiled from: topic_feed_option_deselect */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                                        }

                                        public Object m905a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(AddressParser.m987a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object addressModel = new AddressModel();
                                            ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (addressModel instanceof Postprocessable) {
                                                return ((Postprocessable) addressModel).a();
                                            }
                                            return addressModel;
                                        }
                                    }

                                    /* compiled from: topic_feed_option_deselect */
                                    public class Serializer extends JsonSerializer<AddressModel> {
                                        public final void m906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            AddressModel addressModel = (AddressModel) obj;
                                            if (addressModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(addressModel.m910a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            AddressParser.m988a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(AddressModel.class, new Serializer());
                                        }
                                    }

                                    public AddressModel() {
                                        super(3);
                                    }

                                    @Nullable
                                    private String m907a() {
                                        this.f660d = super.a(this.f660d, 0);
                                        return this.f660d;
                                    }

                                    @Nullable
                                    private String m908j() {
                                        this.f661e = super.a(this.f661e, 1);
                                        return this.f661e;
                                    }

                                    @Nullable
                                    private String m909k() {
                                        this.f662f = super.a(this.f662f, 2);
                                        return this.f662f;
                                    }

                                    public final int jK_() {
                                        return 799251025;
                                    }

                                    public final GraphQLVisitableModel m911a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m910a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m907a());
                                        int b2 = flatBufferBuilder.b(m908j());
                                        int b3 = flatBufferBuilder.b(m909k());
                                        flatBufferBuilder.c(3);
                                        flatBufferBuilder.b(0, b);
                                        flatBufferBuilder.b(1, b2);
                                        flatBufferBuilder.b(2, b3);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: topic_feed_option_deselect */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(ResultsEdgesNodeModel.class, new Deserializer());
                                    }

                                    public Object m912a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(ResultsEdgesNodeParser.m989a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object resultsEdgesNodeModel = new ResultsEdgesNodeModel();
                                        ((BaseModel) resultsEdgesNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (resultsEdgesNodeModel instanceof Postprocessable) {
                                            return ((Postprocessable) resultsEdgesNodeModel).a();
                                        }
                                        return resultsEdgesNodeModel;
                                    }
                                }

                                /* compiled from: topic_feed_option_deselect */
                                public class Serializer extends JsonSerializer<ResultsEdgesNodeModel> {
                                    public final void m913a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        ResultsEdgesNodeModel resultsEdgesNodeModel = (ResultsEdgesNodeModel) obj;
                                        if (resultsEdgesNodeModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(resultsEdgesNodeModel.m924a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            resultsEdgesNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        ResultsEdgesNodeParser.m990a(resultsEdgesNodeModel.w_(), resultsEdgesNodeModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(ResultsEdgesNodeModel.class, new Serializer());
                                    }
                                }

                                public ResultsEdgesNodeModel() {
                                    super(13);
                                }

                                public final void m928a(String str, ConsistencyTuple consistencyTuple) {
                                    if ("viewer_saved_state".equals(str)) {
                                        consistencyTuple.a = m923r();
                                        consistencyTuple.b = u_();
                                        consistencyTuple.c = 12;
                                        return;
                                    }
                                    consistencyTuple.a();
                                }

                                public final void m929a(String str, Object obj, boolean z) {
                                    if ("viewer_saved_state".equals(str)) {
                                        m914a((GraphQLSavedState) obj);
                                    }
                                }

                                @Nullable
                                private GraphQLObjectType m915j() {
                                    if (this.b != null && this.f663d == null) {
                                        this.f663d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                    }
                                    return this.f663d;
                                }

                                @Nullable
                                private AddressModel m916k() {
                                    this.f664e = (AddressModel) super.a(this.f664e, 1, AddressModel.class);
                                    return this.f664e;
                                }

                                @Nonnull
                                private ImmutableList<String> m917l() {
                                    this.f665f = super.a(this.f665f, 2);
                                    return (ImmutableList) this.f665f;
                                }

                                @Nullable
                                private String m918m() {
                                    this.f667h = super.a(this.f667h, 4);
                                    return this.f667h;
                                }

                                @Nullable
                                private DefaultLocationFieldsModel m919n() {
                                    this.f669j = (DefaultLocationFieldsModel) super.a(this.f669j, 6, DefaultLocationFieldsModel.class);
                                    return this.f669j;
                                }

                                @Nullable
                                private String m920o() {
                                    this.f671l = super.a(this.f671l, 8);
                                    return this.f671l;
                                }

                                @Nullable
                                private GraphQLPlaceType m921p() {
                                    this.f673n = (GraphQLPlaceType) super.b(this.f673n, 10, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f673n;
                                }

                                @Nullable
                                private DefaultImageFieldsModel m922q() {
                                    this.f674o = (DefaultImageFieldsModel) super.a(this.f674o, 11, DefaultImageFieldsModel.class);
                                    return this.f674o;
                                }

                                @Nullable
                                private GraphQLSavedState m923r() {
                                    this.f675p = (GraphQLSavedState) super.b(this.f675p, 12, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f675p;
                                }

                                private void m914a(GraphQLSavedState graphQLSavedState) {
                                    this.f675p = graphQLSavedState;
                                    if (this.b != null && this.b.d) {
                                        this.b.a(this.c, 12, graphQLSavedState != null ? graphQLSavedState.name() : null);
                                    }
                                }

                                @Nullable
                                public final String m926a() {
                                    return m918m();
                                }

                                public final int jK_() {
                                    return 2433570;
                                }

                                public final GraphQLVisitableModel m925a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m916k() != null) {
                                        AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m916k());
                                        if (m916k() != addressModel) {
                                            graphQLVisitableModel = (ResultsEdgesNodeModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f664e = addressModel;
                                        }
                                    }
                                    if (m919n() != null) {
                                        DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m919n());
                                        if (m919n() != defaultLocationFieldsModel) {
                                            graphQLVisitableModel = (ResultsEdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f669j = defaultLocationFieldsModel;
                                        }
                                    }
                                    if (m922q() != null) {
                                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m922q());
                                        if (m922q() != defaultImageFieldsModel) {
                                            graphQLVisitableModel = (ResultsEdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f674o = defaultImageFieldsModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m924a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m915j());
                                    int a2 = ModelHelper.a(flatBufferBuilder, m916k());
                                    int c = flatBufferBuilder.c(m917l());
                                    int b = flatBufferBuilder.b(m918m());
                                    int a3 = ModelHelper.a(flatBufferBuilder, m919n());
                                    int b2 = flatBufferBuilder.b(m920o());
                                    int a4 = flatBufferBuilder.a(m921p());
                                    int a5 = ModelHelper.a(flatBufferBuilder, m922q());
                                    int a6 = flatBufferBuilder.a(m923r());
                                    flatBufferBuilder.c(13);
                                    flatBufferBuilder.b(0, a);
                                    flatBufferBuilder.b(1, a2);
                                    flatBufferBuilder.b(2, c);
                                    flatBufferBuilder.a(3, this.f666g);
                                    flatBufferBuilder.b(4, b);
                                    flatBufferBuilder.a(5, this.f668i);
                                    flatBufferBuilder.b(6, a3);
                                    flatBufferBuilder.a(7, this.f670k, 0);
                                    flatBufferBuilder.b(8, b2);
                                    flatBufferBuilder.a(9, this.f672m, 0.0d);
                                    flatBufferBuilder.b(10, a4);
                                    flatBufferBuilder.b(11, a5);
                                    flatBufferBuilder.b(12, a6);
                                    i();
                                    return flatBufferBuilder.d();
                                }

                                public final void m927a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                    super.a(mutableFlatBuffer, i, obj);
                                    this.f666g = mutableFlatBuffer.a(i, 3);
                                    this.f668i = mutableFlatBuffer.a(i, 5);
                                    this.f670k = mutableFlatBuffer.a(i, 7, 0);
                                    this.f672m = mutableFlatBuffer.a(i, 9, 0.0d);
                                }
                            }

                            /* compiled from: topic_feed_option_deselect */
                            public class Serializer extends JsonSerializer<ResultsEdgesModel> {
                                public final void m930a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ResultsEdgesModel resultsEdgesModel = (ResultsEdgesModel) obj;
                                    if (resultsEdgesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(resultsEdgesModel.m932a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        resultsEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    ResultsEdgesParser.m992b(resultsEdgesModel.w_(), resultsEdgesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(ResultsEdgesModel.class, new Serializer());
                                }
                            }

                            public ResultsEdgesModel() {
                                super(1);
                            }

                            @Nullable
                            private ResultsEdgesNodeModel m931a() {
                                this.f676d = (ResultsEdgesNodeModel) super.a(this.f676d, 0, ResultsEdgesNodeModel.class);
                                return this.f676d;
                            }

                            public final int jK_() {
                                return -1512360148;
                            }

                            public final GraphQLVisitableModel m933a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m931a() != null) {
                                    ResultsEdgesNodeModel resultsEdgesNodeModel = (ResultsEdgesNodeModel) graphQLModelMutatingVisitor.b(m931a());
                                    if (m931a() != resultsEdgesNodeModel) {
                                        graphQLVisitableModel = (ResultsEdgesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f676d = resultsEdgesNodeModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m932a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m931a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: topic_feed_option_deselect */
                        public class Serializer extends JsonSerializer<ResultsModel> {
                            public final void m934a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ResultsModel resultsModel = (ResultsModel) obj;
                                if (resultsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(resultsModel.m936a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ResultsParser.m994a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(ResultsModel.class, new Serializer());
                            }
                        }

                        public ResultsModel() {
                            super(1);
                        }

                        @Nonnull
                        private ImmutableList<ResultsEdgesModel> m935a() {
                            this.f677d = super.a(this.f677d, 0, ResultsEdgesModel.class);
                            return (ImmutableList) this.f677d;
                        }

                        public final int jK_() {
                            return -7784179;
                        }

                        public final GraphQLVisitableModel m937a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m935a() != null) {
                                Builder a = ModelHelper.a(m935a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (ResultsModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f677d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m936a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m935a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: topic_feed_option_deselect */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m938a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m941a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m996a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    @Nullable
                    private GraphQLNearbySearchResultCategory m939a() {
                        this.f678d = (GraphQLNearbySearchResultCategory) super.b(this.f678d, 0, GraphQLNearbySearchResultCategory.class, GraphQLNearbySearchResultCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f678d;
                    }

                    @Nullable
                    private ResultsModel m940j() {
                        this.f679e = (ResultsModel) super.a(this.f679e, 1, ResultsModel.class);
                        return this.f679e;
                    }

                    public final int jK_() {
                        return 901101089;
                    }

                    public final GraphQLVisitableModel m942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m940j() != null) {
                            ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m940j());
                            if (m940j() != resultsModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f679e = resultsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m941a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = flatBufferBuilder.a(m939a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m940j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: topic_feed_option_deselect */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m943a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m945a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m998b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m944a() {
                    this.f680d = (NodeModel) super.a(this.f680d, 0, NodeModel.class);
                    return this.f680d;
                }

                public final int jK_() {
                    return -466524337;
                }

                public final GraphQLVisitableModel m946a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m944a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m944a());
                        if (m944a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f680d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m945a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m944a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1353565802)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: topic_feed_option_deselect */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLNearbySearchResultCategory f690d;
                @Nullable
                private TopicSuggestionsModel f691e;

                /* compiled from: topic_feed_option_deselect */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m947a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m1006b(jsonParser, flatBufferBuilder));
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

                /* compiled from: topic_feed_option_deselect */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m948a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m975a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m1007b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 500725604)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: topic_feed_option_deselect */
                public final class TopicSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<TopicSuggestionsNodesModel> f689d;

                    /* compiled from: topic_feed_option_deselect */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TopicSuggestionsModel.class, new Deserializer());
                        }

                        public Object m949a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TopicSuggestionsParser.m1003a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object topicSuggestionsModel = new TopicSuggestionsModel();
                            ((BaseModel) topicSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (topicSuggestionsModel instanceof Postprocessable) {
                                return ((Postprocessable) topicSuggestionsModel).a();
                            }
                            return topicSuggestionsModel;
                        }
                    }

                    /* compiled from: topic_feed_option_deselect */
                    public class Serializer extends JsonSerializer<TopicSuggestionsModel> {
                        public final void m950a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TopicSuggestionsModel topicSuggestionsModel = (TopicSuggestionsModel) obj;
                            if (topicSuggestionsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(topicSuggestionsModel.m971a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                topicSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TopicSuggestionsParser.m1004a(topicSuggestionsModel.w_(), topicSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(TopicSuggestionsModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -781033955)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: topic_feed_option_deselect */
                    public final class TopicSuggestionsNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private NearbyGeoRectangleModel f685d;
                        @Nullable
                        private DefaultTextWithEntitiesFieldsModel f686e;
                        @Nullable
                        private DefaultTextWithEntitiesFieldsModel f687f;
                        @Nullable
                        private TopicModel f688g;

                        /* compiled from: topic_feed_option_deselect */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(TopicSuggestionsNodesModel.class, new Deserializer());
                            }

                            public Object m951a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(TopicSuggestionsNodesParser.m1001b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object topicSuggestionsNodesModel = new TopicSuggestionsNodesModel();
                                ((BaseModel) topicSuggestionsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (topicSuggestionsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) topicSuggestionsNodesModel).a();
                                }
                                return topicSuggestionsNodesModel;
                            }
                        }

                        /* compiled from: topic_feed_option_deselect */
                        public class Serializer extends JsonSerializer<TopicSuggestionsNodesModel> {
                            public final void m952a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                TopicSuggestionsNodesModel topicSuggestionsNodesModel = (TopicSuggestionsNodesModel) obj;
                                if (topicSuggestionsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(topicSuggestionsNodesModel.m968a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    topicSuggestionsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                TopicSuggestionsNodesParser.m1002b(topicSuggestionsNodesModel.w_(), topicSuggestionsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(TopicSuggestionsNodesModel.class, new Serializer());
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1234643025)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: topic_feed_option_deselect */
                        public final class TopicModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                            @Nullable
                            private String f681d;
                            @Nullable
                            private DefaultLocationFieldsModel f682e;
                            @Nullable
                            private String f683f;
                            @Nullable
                            private String f684g;

                            /* compiled from: topic_feed_option_deselect */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(TopicModel.class, new Deserializer());
                                }

                                public Object m953a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(TopicParser.m999a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object topicModel = new TopicModel();
                                    ((BaseModel) topicModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (topicModel instanceof Postprocessable) {
                                        return ((Postprocessable) topicModel).a();
                                    }
                                    return topicModel;
                                }
                            }

                            /* compiled from: topic_feed_option_deselect */
                            public class Serializer extends JsonSerializer<TopicModel> {
                                public final void m954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    TopicModel topicModel = (TopicModel) obj;
                                    if (topicModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(topicModel.m959a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        topicModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    TopicParser.m1000a(topicModel.w_(), topicModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(TopicModel.class, new Serializer());
                                }
                            }

                            public TopicModel() {
                                super(4);
                            }

                            public final void m962a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m963a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            private String m955j() {
                                this.f681d = super.a(this.f681d, 0);
                                return this.f681d;
                            }

                            @Nullable
                            private DefaultLocationFieldsModel m956k() {
                                this.f682e = (DefaultLocationFieldsModel) super.a(this.f682e, 1, DefaultLocationFieldsModel.class);
                                return this.f682e;
                            }

                            @Nullable
                            private String m957l() {
                                this.f683f = super.a(this.f683f, 2);
                                return this.f683f;
                            }

                            @Nullable
                            private String m958m() {
                                this.f684g = super.a(this.f684g, 3);
                                return this.f684g;
                            }

                            @Nullable
                            public final String m961a() {
                                return m955j();
                            }

                            public final int jK_() {
                                return 2479791;
                            }

                            public final GraphQLVisitableModel m960a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m956k() != null) {
                                    DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m956k());
                                    if (m956k() != defaultLocationFieldsModel) {
                                        graphQLVisitableModel = (TopicModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f682e = defaultLocationFieldsModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m959a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m955j());
                                int a = ModelHelper.a(flatBufferBuilder, m956k());
                                int b2 = flatBufferBuilder.b(m957l());
                                int b3 = flatBufferBuilder.b(m958m());
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, a);
                                flatBufferBuilder.b(2, b2);
                                flatBufferBuilder.b(3, b3);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        public TopicSuggestionsNodesModel() {
                            super(4);
                        }

                        @Nullable
                        private NearbyGeoRectangleModel m964a() {
                            this.f685d = (NearbyGeoRectangleModel) super.a(this.f685d, 0, NearbyGeoRectangleModel.class);
                            return this.f685d;
                        }

                        @Nullable
                        private DefaultTextWithEntitiesFieldsModel m965j() {
                            this.f686e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f686e, 1, DefaultTextWithEntitiesFieldsModel.class);
                            return this.f686e;
                        }

                        @Nullable
                        private DefaultTextWithEntitiesFieldsModel m966k() {
                            this.f687f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f687f, 2, DefaultTextWithEntitiesFieldsModel.class);
                            return this.f687f;
                        }

                        @Nullable
                        private TopicModel m967l() {
                            this.f688g = (TopicModel) super.a(this.f688g, 3, TopicModel.class);
                            return this.f688g;
                        }

                        public final int jK_() {
                            return 1165710987;
                        }

                        public final GraphQLVisitableModel m969a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m964a() != null) {
                                NearbyGeoRectangleModel nearbyGeoRectangleModel = (NearbyGeoRectangleModel) graphQLModelMutatingVisitor.b(m964a());
                                if (m964a() != nearbyGeoRectangleModel) {
                                    graphQLVisitableModel = (TopicSuggestionsNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f685d = nearbyGeoRectangleModel;
                                }
                            }
                            if (m965j() != null) {
                                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m965j());
                                if (m965j() != defaultTextWithEntitiesFieldsModel) {
                                    graphQLVisitableModel = (TopicSuggestionsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f686e = defaultTextWithEntitiesFieldsModel;
                                }
                            }
                            if (m966k() != null) {
                                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m966k());
                                if (m966k() != defaultTextWithEntitiesFieldsModel) {
                                    graphQLVisitableModel = (TopicSuggestionsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f687f = defaultTextWithEntitiesFieldsModel;
                                }
                            }
                            if (m967l() != null) {
                                TopicModel topicModel = (TopicModel) graphQLModelMutatingVisitor.b(m967l());
                                if (m967l() != topicModel) {
                                    graphQLVisitableModel = (TopicSuggestionsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f688g = topicModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m968a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m964a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m965j());
                            int a3 = ModelHelper.a(flatBufferBuilder, m966k());
                            int a4 = ModelHelper.a(flatBufferBuilder, m967l());
                            flatBufferBuilder.c(4);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            flatBufferBuilder.b(2, a3);
                            flatBufferBuilder.b(3, a4);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public TopicSuggestionsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<TopicSuggestionsNodesModel> m970a() {
                        this.f689d = super.a(this.f689d, 0, TopicSuggestionsNodesModel.class);
                        return (ImmutableList) this.f689d;
                    }

                    public final int jK_() {
                        return 368729158;
                    }

                    public final GraphQLVisitableModel m972a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m970a() != null) {
                            Builder a = ModelHelper.a(m970a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (TopicSuggestionsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f689d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m971a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m970a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                private GraphQLNearbySearchResultCategory m973a() {
                    this.f690d = (GraphQLNearbySearchResultCategory) super.b(this.f690d, 0, GraphQLNearbySearchResultCategory.class, GraphQLNearbySearchResultCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f690d;
                }

                @Nullable
                private TopicSuggestionsModel m974j() {
                    this.f691e = (TopicSuggestionsModel) super.a(this.f691e, 1, TopicSuggestionsModel.class);
                    return this.f691e;
                }

                public final int jK_() {
                    return 901101089;
                }

                public final GraphQLVisitableModel m976a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m974j() != null) {
                        TopicSuggestionsModel topicSuggestionsModel = (TopicSuggestionsModel) graphQLModelMutatingVisitor.b(m974j());
                        if (m974j() != topicSuggestionsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f691e = topicSuggestionsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m975a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m973a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m974j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: topic_feed_option_deselect */
            public class Serializer extends JsonSerializer<ResultSectionsModel> {
                public final void m977a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResultSectionsModel resultSectionsModel = (ResultSectionsModel) obj;
                    if (resultSectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resultSectionsModel.m980a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resultSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResultSectionsParser.m1009a(resultSectionsModel.w_(), resultSectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ResultSectionsModel.class, new Serializer());
                }
            }

            public ResultSectionsModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m978a() {
                this.f692d = super.a(this.f692d, 0, EdgesModel.class);
                return (ImmutableList) this.f692d;
            }

            @Nonnull
            private ImmutableList<NodesModel> m979j() {
                this.f693e = super.a(this.f693e, 1, NodesModel.class);
                return (ImmutableList) this.f693e;
            }

            public final int jK_() {
                return 200639216;
            }

            public final GraphQLVisitableModel m981a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m978a() != null) {
                    a = ModelHelper.a(m978a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ResultSectionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f692d = a.b();
                    }
                }
                if (m979j() != null) {
                    a = ModelHelper.a(m979j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ResultSectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f693e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m980a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m978a());
                int a2 = ModelHelper.a(flatBufferBuilder, m979j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: topic_feed_option_deselect */
        public class Serializer extends JsonSerializer<SearchNearbyPlacesModel> {
            public final void m982a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchNearbyPlacesModel searchNearbyPlacesModel = (SearchNearbyPlacesModel) obj;
                if (searchNearbyPlacesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchNearbyPlacesModel.m985a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchNearbyPlacesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchNearbyPlacesModel.w_();
                int u_ = searchNearbyPlacesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("result_sections");
                    ResultSectionsParser.m1009a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("search_session_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchNearbyPlacesModel.class, new Serializer());
            }
        }

        public SearchNearbyPlacesModel() {
            super(2);
        }

        @Nullable
        private ResultSectionsModel m983a() {
            this.f694d = (ResultSectionsModel) super.a(this.f694d, 0, ResultSectionsModel.class);
            return this.f694d;
        }

        @Nullable
        private String m984j() {
            this.f695e = super.a(this.f695e, 1);
            return this.f695e;
        }

        public final int jK_() {
            return 1725273057;
        }

        public final GraphQLVisitableModel m986a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m983a() != null) {
                ResultSectionsModel resultSectionsModel = (ResultSectionsModel) graphQLModelMutatingVisitor.b(m983a());
                if (m983a() != resultSectionsModel) {
                    graphQLVisitableModel = (SearchNearbyPlacesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f694d = resultSectionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m985a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m983a());
            int b = flatBufferBuilder.b(m984j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
