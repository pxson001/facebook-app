package com.facebook.nearby.v2.network;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesHugeResultCellPageInformationFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.BrowseNearbyPlacesFullImageFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.AddressModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.HoursModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.LocationModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.OverallStarRatingModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.PageLikersModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.PageVisitsModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.PlaceOpenStatusModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.RatersModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesPageProfilePhotoModel.ProfilePhotoModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyRecommendationsConnectionFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.PageTWEFragmentModel.RedirectionInfoModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.Photo320FragmentModel;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQLParsers.FBNearbyPlacesHereCardHugeResultCellQueryParser;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQLParsers.FBNearbyPlacesHereCardHugeResultCellQueryParser.SuggestionsParser;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQLParsers.FBNearbyPlacesHereCardHugeResultCellQueryParser.SuggestionsParser.EdgesParser;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQLParsers.FBNearbyPlacesHereCardHugeResultCellQueryParser.SuggestionsParser.EdgesParser.NodeParser;
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

/* compiled from: destination_filter_type */
public class NearbyPlacesHereCardSuggestionGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1981279525)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: destination_filter_type */
    public final class FBNearbyPlacesHereCardHugeResultCellQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestionsModel f15746d;

        /* compiled from: destination_filter_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBNearbyPlacesHereCardHugeResultCellQueryModel.class, new Deserializer());
            }

            public Object m18417a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBNearbyPlacesHereCardHugeResultCellQueryParser.m18494a(jsonParser);
                Object fBNearbyPlacesHereCardHugeResultCellQueryModel = new FBNearbyPlacesHereCardHugeResultCellQueryModel();
                ((BaseModel) fBNearbyPlacesHereCardHugeResultCellQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBNearbyPlacesHereCardHugeResultCellQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBNearbyPlacesHereCardHugeResultCellQueryModel).a();
                }
                return fBNearbyPlacesHereCardHugeResultCellQueryModel;
            }
        }

        /* compiled from: destination_filter_type */
        public class Serializer extends JsonSerializer<FBNearbyPlacesHereCardHugeResultCellQueryModel> {
            public final void m18418a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBNearbyPlacesHereCardHugeResultCellQueryModel fBNearbyPlacesHereCardHugeResultCellQueryModel = (FBNearbyPlacesHereCardHugeResultCellQueryModel) obj;
                if (fBNearbyPlacesHereCardHugeResultCellQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBNearbyPlacesHereCardHugeResultCellQueryModel.m18485a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBNearbyPlacesHereCardHugeResultCellQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBNearbyPlacesHereCardHugeResultCellQueryModel.w_();
                int u_ = fBNearbyPlacesHereCardHugeResultCellQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggestions");
                    SuggestionsParser.m18493a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBNearbyPlacesHereCardHugeResultCellQueryModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1281957958)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: destination_filter_type */
        public final class SuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f15745d;

            /* compiled from: destination_filter_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestionsModel.class, new Deserializer());
                }

                public Object m18419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestionsParser.m18492a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestionsModel = new SuggestionsModel();
                    ((BaseModel) suggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestionsModel).a();
                    }
                    return suggestionsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -968773061)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: destination_filter_type */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f15743d;
                @Nullable
                private String f15744e;

                /* compiled from: destination_filter_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m18420a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m18490b(jsonParser, flatBufferBuilder));
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

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 614506795)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: destination_filter_type */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NearbyPlacesHugeResultCellPageInformationFragment {
                    @Nullable
                    private BrowseNearbyPlacesFullImageFragmentModel f15707A;
                    @Nullable
                    private ProfilePhotoModel f15708B;
                    private boolean f15709C;
                    @Nullable
                    private RatersModel f15710D;
                    @Nullable
                    private NearbyRecommendationsConnectionFragmentModel f15711E;
                    @Nullable
                    private List<RedirectionInfoModel> f15712F;
                    @Nullable
                    private List<Photo320FragmentModel> f15713G;
                    @Nullable
                    private List<String> f15714H;
                    private boolean f15715I;
                    @Nullable
                    private List<String> f15716J;
                    @Nullable
                    private GraphQLPageSuperCategoryType f15717K;
                    @Nullable
                    private List<String> f15718L;
                    @Nullable
                    private GraphQLSavedState f15719M;
                    @Nullable
                    private GraphQLObjectType f15720d;
                    @Nullable
                    private AddressModel f15721e;
                    private boolean f15722f;
                    private boolean f15723g;
                    @Nullable
                    private List<String> f15724h;
                    @Nullable
                    private GraphQLPageCategoryType f15725i;
                    private boolean f15726j;
                    private boolean f15727k;
                    @Nullable
                    private FriendsWhoVisitedModel f15728l;
                    @Nullable
                    private List<HoursModel> f15729m;
                    @Nullable
                    private String f15730n;
                    private boolean f15731o;
                    @Nullable
                    private LocationModel f15732p;
                    @Nullable
                    private String f15733q;
                    @Nullable
                    private OverallStarRatingModel f15734r;
                    @Nullable
                    private PageLikersModel f15735s;
                    @Nullable
                    private PageVisitsModel f15736t;
                    @Nullable
                    private GraphQLPermanentlyClosedStatus f15737u;
                    @Nullable
                    private PlaceOpenStatusModel f15738v;
                    @Nullable
                    private GraphQLPageOpenHoursDisplayDecisionEnum f15739w;
                    @Nullable
                    private GraphQLPlaceType f15740x;
                    @Nullable
                    private String f15741y;
                    @Nullable
                    private BrowseNearbyPlacesFullImageFragmentModel f15742z;

                    /* compiled from: destination_filter_type */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m18421a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m18488a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: destination_filter_type */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m18422a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m18449a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m18489a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ RatersModel mo920B() {
                        return m18434W();
                    }

                    @Nullable
                    public final /* synthetic */ NearbyRecommendationsConnectionFragmentModel mo921C() {
                        return m18435X();
                    }

                    @Nullable
                    public final /* synthetic */ AddressModel mo930b() {
                        return m18424M();
                    }

                    @Nullable
                    public final /* synthetic */ FriendsWhoVisitedModel mo934j() {
                        return m18425N();
                    }

                    @Nullable
                    public final /* synthetic */ LocationModel mo941n() {
                        return m18426O();
                    }

                    @Nullable
                    public final /* synthetic */ OverallStarRatingModel mo943p() {
                        return m18427P();
                    }

                    @Nullable
                    public final /* synthetic */ PageLikersModel mo944q() {
                        return m18428Q();
                    }

                    @Nullable
                    public final /* synthetic */ PageVisitsModel mo945r() {
                        return m18429R();
                    }

                    @Nullable
                    public final /* synthetic */ PlaceOpenStatusModel mo947t() {
                        return m18430S();
                    }

                    @Nullable
                    public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel mo951x() {
                        return m18431T();
                    }

                    @Nullable
                    public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel mo952y() {
                        return m18432U();
                    }

                    @Nullable
                    public final /* synthetic */ ProfilePhotoModel mo953z() {
                        return m18433V();
                    }

                    public NodeModel() {
                        super(36);
                    }

                    public final void m18453a(String str, ConsistencyTuple consistencyTuple) {
                        if ("name".equals(str)) {
                            consistencyTuple.a = mo942o();
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 13;
                        } else if ("viewer_saved_state".equals(str)) {
                            consistencyTuple.a = mo929K();
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 35;
                        } else {
                            consistencyTuple.a();
                        }
                    }

                    public final void m18454a(String str, Object obj, boolean z) {
                        if ("name".equals(str)) {
                            m18437a((String) obj);
                        } else if ("viewer_saved_state".equals(str)) {
                            m18436a((GraphQLSavedState) obj);
                        }
                    }

                    @Nullable
                    private GraphQLObjectType m18423L() {
                        if (this.b != null && this.f15720d == null) {
                            this.f15720d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f15720d;
                    }

                    @Nullable
                    private AddressModel m18424M() {
                        this.f15721e = (AddressModel) super.a(this.f15721e, 1, AddressModel.class);
                        return this.f15721e;
                    }

                    public final boolean mo931c() {
                        a(0, 2);
                        return this.f15722f;
                    }

                    public final boolean mo932d() {
                        a(0, 3);
                        return this.f15723g;
                    }

                    @Nonnull
                    public final ImmutableList<String> jY_() {
                        this.f15724h = super.a(this.f15724h, 4);
                        return (ImmutableList) this.f15724h;
                    }

                    @Nullable
                    public final GraphQLPageCategoryType mo933g() {
                        this.f15725i = (GraphQLPageCategoryType) super.b(this.f15725i, 5, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f15725i;
                    }

                    public final boolean jZ_() {
                        a(0, 6);
                        return this.f15726j;
                    }

                    public final boolean ka_() {
                        a(0, 7);
                        return this.f15727k;
                    }

                    @Nullable
                    private FriendsWhoVisitedModel m18425N() {
                        this.f15728l = (FriendsWhoVisitedModel) super.a(this.f15728l, 8, FriendsWhoVisitedModel.class);
                        return this.f15728l;
                    }

                    @Nonnull
                    public final ImmutableList<HoursModel> mo937k() {
                        this.f15729m = super.a(this.f15729m, 9, HoursModel.class);
                        return (ImmutableList) this.f15729m;
                    }

                    @Nullable
                    public final String mo939l() {
                        this.f15730n = super.a(this.f15730n, 10);
                        return this.f15730n;
                    }

                    public final boolean mo940m() {
                        a(1, 3);
                        return this.f15731o;
                    }

                    @Nullable
                    private LocationModel m18426O() {
                        this.f15732p = (LocationModel) super.a(this.f15732p, 12, LocationModel.class);
                        return this.f15732p;
                    }

                    @Nullable
                    public final String mo942o() {
                        this.f15733q = super.a(this.f15733q, 13);
                        return this.f15733q;
                    }

                    private void m18437a(@Nullable String str) {
                        this.f15733q = str;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 13, str);
                        }
                    }

                    @Nullable
                    private OverallStarRatingModel m18427P() {
                        this.f15734r = (OverallStarRatingModel) super.a(this.f15734r, 14, OverallStarRatingModel.class);
                        return this.f15734r;
                    }

                    @Nullable
                    private PageLikersModel m18428Q() {
                        this.f15735s = (PageLikersModel) super.a(this.f15735s, 15, PageLikersModel.class);
                        return this.f15735s;
                    }

                    @Nullable
                    private PageVisitsModel m18429R() {
                        this.f15736t = (PageVisitsModel) super.a(this.f15736t, 16, PageVisitsModel.class);
                        return this.f15736t;
                    }

                    @Nullable
                    public final GraphQLPermanentlyClosedStatus mo946s() {
                        this.f15737u = (GraphQLPermanentlyClosedStatus) super.b(this.f15737u, 17, GraphQLPermanentlyClosedStatus.class, GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f15737u;
                    }

                    @Nullable
                    private PlaceOpenStatusModel m18430S() {
                        this.f15738v = (PlaceOpenStatusModel) super.a(this.f15738v, 18, PlaceOpenStatusModel.class);
                        return this.f15738v;
                    }

                    @Nullable
                    public final GraphQLPageOpenHoursDisplayDecisionEnum mo948u() {
                        this.f15739w = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f15739w, 19, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f15739w;
                    }

                    @Nullable
                    public final GraphQLPlaceType mo949v() {
                        this.f15740x = (GraphQLPlaceType) super.b(this.f15740x, 20, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f15740x;
                    }

                    @Nullable
                    public final String mo950w() {
                        this.f15741y = super.a(this.f15741y, 21);
                        return this.f15741y;
                    }

                    @Nullable
                    private BrowseNearbyPlacesFullImageFragmentModel m18431T() {
                        this.f15742z = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15742z, 22, BrowseNearbyPlacesFullImageFragmentModel.class);
                        return this.f15742z;
                    }

                    @Nullable
                    private BrowseNearbyPlacesFullImageFragmentModel m18432U() {
                        this.f15707A = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15707A, 23, BrowseNearbyPlacesFullImageFragmentModel.class);
                        return this.f15707A;
                    }

                    @Nullable
                    private ProfilePhotoModel m18433V() {
                        this.f15708B = (ProfilePhotoModel) super.a(this.f15708B, 24, ProfilePhotoModel.class);
                        return this.f15708B;
                    }

                    public final boolean mo919A() {
                        a(3, 1);
                        return this.f15709C;
                    }

                    @Nullable
                    private RatersModel m18434W() {
                        this.f15710D = (RatersModel) super.a(this.f15710D, 26, RatersModel.class);
                        return this.f15710D;
                    }

                    @Nullable
                    private NearbyRecommendationsConnectionFragmentModel m18435X() {
                        this.f15711E = (NearbyRecommendationsConnectionFragmentModel) super.a(this.f15711E, 27, NearbyRecommendationsConnectionFragmentModel.class);
                        return this.f15711E;
                    }

                    @Nonnull
                    public final ImmutableList<RedirectionInfoModel> mo922D() {
                        this.f15712F = super.a(this.f15712F, 28, RedirectionInfoModel.class);
                        return (ImmutableList) this.f15712F;
                    }

                    @Nonnull
                    public final ImmutableList<Photo320FragmentModel> mo923E() {
                        this.f15713G = super.a(this.f15713G, 29, Photo320FragmentModel.class);
                        return (ImmutableList) this.f15713G;
                    }

                    @Nonnull
                    public final ImmutableList<String> mo924F() {
                        this.f15714H = super.a(this.f15714H, 30);
                        return (ImmutableList) this.f15714H;
                    }

                    public final boolean mo925G() {
                        a(3, 7);
                        return this.f15715I;
                    }

                    @Nonnull
                    public final ImmutableList<String> mo926H() {
                        this.f15716J = super.a(this.f15716J, 32);
                        return (ImmutableList) this.f15716J;
                    }

                    @Nullable
                    public final GraphQLPageSuperCategoryType mo927I() {
                        this.f15717K = (GraphQLPageSuperCategoryType) super.b(this.f15717K, 33, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f15717K;
                    }

                    @Nonnull
                    public final ImmutableList<String> mo928J() {
                        this.f15718L = super.a(this.f15718L, 34);
                        return (ImmutableList) this.f15718L;
                    }

                    @Nullable
                    public final GraphQLSavedState mo929K() {
                        this.f15719M = (GraphQLSavedState) super.b(this.f15719M, 35, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f15719M;
                    }

                    private void m18436a(GraphQLSavedState graphQLSavedState) {
                        this.f15719M = graphQLSavedState;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 35, graphQLSavedState != null ? graphQLSavedState.name() : null);
                        }
                    }

                    @Nullable
                    public final String m18451a() {
                        return mo939l();
                    }

                    public final int jK_() {
                        return 77195495;
                    }

                    public final GraphQLVisitableModel m18450a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        Builder a;
                        BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel;
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m18424M() != null) {
                            AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m18424M());
                            if (m18424M() != addressModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f15721e = addressModel;
                            }
                        }
                        if (m18425N() != null) {
                            FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) graphQLModelMutatingVisitor.b(m18425N());
                            if (m18425N() != friendsWhoVisitedModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15728l = friendsWhoVisitedModel;
                            }
                        }
                        if (mo937k() != null) {
                            a = ModelHelper.a(mo937k(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f15729m = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (m18426O() != null) {
                            LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m18426O());
                            if (m18426O() != locationModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15732p = locationModel;
                            }
                        }
                        if (m18427P() != null) {
                            OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m18427P());
                            if (m18427P() != overallStarRatingModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15734r = overallStarRatingModel;
                            }
                        }
                        if (m18428Q() != null) {
                            PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m18428Q());
                            if (m18428Q() != pageLikersModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15735s = pageLikersModel;
                            }
                        }
                        if (m18429R() != null) {
                            PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m18429R());
                            if (m18429R() != pageVisitsModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15736t = pageVisitsModel;
                            }
                        }
                        if (m18430S() != null) {
                            PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m18430S());
                            if (m18430S() != placeOpenStatusModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15738v = placeOpenStatusModel;
                            }
                        }
                        if (m18431T() != null) {
                            browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18431T());
                            if (m18431T() != browseNearbyPlacesFullImageFragmentModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15742z = browseNearbyPlacesFullImageFragmentModel;
                            }
                        }
                        if (m18432U() != null) {
                            browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18432U());
                            if (m18432U() != browseNearbyPlacesFullImageFragmentModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15707A = browseNearbyPlacesFullImageFragmentModel;
                            }
                        }
                        if (m18433V() != null) {
                            ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) graphQLModelMutatingVisitor.b(m18433V());
                            if (m18433V() != profilePhotoModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15708B = profilePhotoModel;
                            }
                        }
                        if (m18434W() != null) {
                            RatersModel ratersModel = (RatersModel) graphQLModelMutatingVisitor.b(m18434W());
                            if (m18434W() != ratersModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15710D = ratersModel;
                            }
                        }
                        if (m18435X() != null) {
                            NearbyRecommendationsConnectionFragmentModel nearbyRecommendationsConnectionFragmentModel = (NearbyRecommendationsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m18435X());
                            if (m18435X() != nearbyRecommendationsConnectionFragmentModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15711E = nearbyRecommendationsConnectionFragmentModel;
                            }
                        }
                        if (mo922D() != null) {
                            a = ModelHelper.a(mo922D(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f15712F = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (mo923E() != null) {
                            a = ModelHelper.a(mo923E(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f15713G = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m18449a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m18423L());
                        int a2 = ModelHelper.a(flatBufferBuilder, m18424M());
                        int c = flatBufferBuilder.c(jY_());
                        int a3 = flatBufferBuilder.a(mo933g());
                        int a4 = ModelHelper.a(flatBufferBuilder, m18425N());
                        int a5 = ModelHelper.a(flatBufferBuilder, mo937k());
                        int b = flatBufferBuilder.b(mo939l());
                        int a6 = ModelHelper.a(flatBufferBuilder, m18426O());
                        int b2 = flatBufferBuilder.b(mo942o());
                        int a7 = ModelHelper.a(flatBufferBuilder, m18427P());
                        int a8 = ModelHelper.a(flatBufferBuilder, m18428Q());
                        int a9 = ModelHelper.a(flatBufferBuilder, m18429R());
                        int a10 = flatBufferBuilder.a(mo946s());
                        int a11 = ModelHelper.a(flatBufferBuilder, m18430S());
                        int a12 = flatBufferBuilder.a(mo948u());
                        int a13 = flatBufferBuilder.a(mo949v());
                        int b3 = flatBufferBuilder.b(mo950w());
                        int a14 = ModelHelper.a(flatBufferBuilder, m18431T());
                        int a15 = ModelHelper.a(flatBufferBuilder, m18432U());
                        int a16 = ModelHelper.a(flatBufferBuilder, m18433V());
                        int a17 = ModelHelper.a(flatBufferBuilder, m18434W());
                        int a18 = ModelHelper.a(flatBufferBuilder, m18435X());
                        int a19 = ModelHelper.a(flatBufferBuilder, mo922D());
                        int a20 = ModelHelper.a(flatBufferBuilder, mo923E());
                        int c2 = flatBufferBuilder.c(mo924F());
                        int c3 = flatBufferBuilder.c(mo926H());
                        int a21 = flatBufferBuilder.a(mo927I());
                        int c4 = flatBufferBuilder.c(mo928J());
                        int a22 = flatBufferBuilder.a(mo929K());
                        flatBufferBuilder.c(36);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.a(2, this.f15722f);
                        flatBufferBuilder.a(3, this.f15723g);
                        flatBufferBuilder.b(4, c);
                        flatBufferBuilder.b(5, a3);
                        flatBufferBuilder.a(6, this.f15726j);
                        flatBufferBuilder.a(7, this.f15727k);
                        flatBufferBuilder.b(8, a4);
                        flatBufferBuilder.b(9, a5);
                        flatBufferBuilder.b(10, b);
                        flatBufferBuilder.a(11, this.f15731o);
                        flatBufferBuilder.b(12, a6);
                        flatBufferBuilder.b(13, b2);
                        flatBufferBuilder.b(14, a7);
                        flatBufferBuilder.b(15, a8);
                        flatBufferBuilder.b(16, a9);
                        flatBufferBuilder.b(17, a10);
                        flatBufferBuilder.b(18, a11);
                        flatBufferBuilder.b(19, a12);
                        flatBufferBuilder.b(20, a13);
                        flatBufferBuilder.b(21, b3);
                        flatBufferBuilder.b(22, a14);
                        flatBufferBuilder.b(23, a15);
                        flatBufferBuilder.b(24, a16);
                        flatBufferBuilder.a(25, this.f15709C);
                        flatBufferBuilder.b(26, a17);
                        flatBufferBuilder.b(27, a18);
                        flatBufferBuilder.b(28, a19);
                        flatBufferBuilder.b(29, a20);
                        flatBufferBuilder.b(30, c2);
                        flatBufferBuilder.a(31, this.f15715I);
                        flatBufferBuilder.b(32, c3);
                        flatBufferBuilder.b(33, a21);
                        flatBufferBuilder.b(34, c4);
                        flatBufferBuilder.b(35, a22);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m18452a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f15722f = mutableFlatBuffer.a(i, 2);
                        this.f15723g = mutableFlatBuffer.a(i, 3);
                        this.f15726j = mutableFlatBuffer.a(i, 6);
                        this.f15727k = mutableFlatBuffer.a(i, 7);
                        this.f15731o = mutableFlatBuffer.a(i, 11);
                        this.f15709C = mutableFlatBuffer.a(i, 25);
                        this.f15715I = mutableFlatBuffer.a(i, 31);
                    }
                }

                /* compiled from: destination_filter_type */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m18476a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m18478a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m18491b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                @Nullable
                public final NodeModel m18480a() {
                    this.f15743d = (NodeModel) super.a(this.f15743d, 0, NodeModel.class);
                    return this.f15743d;
                }

                @Nullable
                private String m18477j() {
                    this.f15744e = super.a(this.f15744e, 1);
                    return this.f15744e;
                }

                public final int jK_() {
                    return -847651457;
                }

                public final GraphQLVisitableModel m18479a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18480a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18480a());
                        if (m18480a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15743d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18478a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18480a());
                    int b = flatBufferBuilder.b(m18477j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: destination_filter_type */
            public class Serializer extends JsonSerializer<SuggestionsModel> {
                public final void m18481a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestionsModel suggestionsModel = (SuggestionsModel) obj;
                    if (suggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestionsModel.m18482a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestionsParser.m18493a(suggestionsModel.w_(), suggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestionsModel.class, new Serializer());
                }
            }

            public SuggestionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m18484a() {
                this.f15745d = super.a(this.f15745d, 0, EdgesModel.class);
                return (ImmutableList) this.f15745d;
            }

            public final int jK_() {
                return -373779168;
            }

            public final GraphQLVisitableModel m18483a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18484a() != null) {
                    Builder a = ModelHelper.a(m18484a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15745d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18482a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18484a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FBNearbyPlacesHereCardHugeResultCellQueryModel() {
            super(1);
        }

        @Nullable
        public final SuggestionsModel m18487a() {
            this.f15746d = (SuggestionsModel) super.a(this.f15746d, 0, SuggestionsModel.class);
            return this.f15746d;
        }

        public final int jK_() {
            return -1042435661;
        }

        public final GraphQLVisitableModel m18486a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18487a() != null) {
                SuggestionsModel suggestionsModel = (SuggestionsModel) graphQLModelMutatingVisitor.b(m18487a());
                if (m18487a() != suggestionsModel) {
                    graphQLVisitableModel = (FBNearbyPlacesHereCardHugeResultCellQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15746d = suggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18485a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18487a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
