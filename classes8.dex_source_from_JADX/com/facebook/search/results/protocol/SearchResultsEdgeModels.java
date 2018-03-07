package com.facebook.search.results.protocol;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser;
import com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel;
import com.facebook.search.results.protocol.common.SearchResultsDecorationModels.SearchResultsDecorationModel;
import com.facebook.search.results.protocol.entity.SearchResultsAppInterfaces.SearchResultsApp;
import com.facebook.search.results.protocol.entity.SearchResultsEventInterfaces.SearchResultsEvent;
import com.facebook.search.results.protocol.entity.SearchResultsEventModels.SearchResultsEventModel.EventPlaceModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupInterfaces.SearchResultsGroup;
import com.facebook.search.results.protocol.entity.SearchResultsGroupModels.SearchResultsGroupModel.GroupMembersModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupModels.SearchResultsGroupModel.SocialContextModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupModels.SearchResultsGroupModel.VisibilitySentenceModel;
import com.facebook.search.results.protocol.entity.SearchResultsPageInterfaces.SearchResultsPage;
import com.facebook.search.results.protocol.entity.SearchResultsPageModels.SearchResultsPageCTAModel;
import com.facebook.search.results.protocol.entity.SearchResultsPageModels.SearchResultsPageModel.CoverPhotoModel;
import com.facebook.search.results.protocol.entity.SearchResultsPageModels.SearchResultsPageModel.PageLikersModel;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceInterfaces.SearchResultsPlace;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceModels.SearchResultsPlaceModel.AddressModel;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceModels.SearchResultsPlaceModel.LocationModel;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceModels.SearchResultsPlaceModel.OverallStarRatingModel;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceModels.SearchResultsPlaceModel.PlaceOpenStatusModel;
import com.facebook.search.results.protocol.entity.SearchResultsUserInterfaces.SearchResultsUser;
import com.facebook.search.results.protocol.entity.SearchResultsUserModels.SearchResultsUserModel.BioTextModel;
import com.facebook.search.results.protocol.entity.SearchResultsUserModels.SearchResultsUserModel.MutualFriendsModel;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlInterfaces.PulseEmotionAnalysisExternalUrl;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels.PulseEmotionAnalysisExternalUrlModel.EmotionalAnalysisModel;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlInterfaces.PulsePhrasesAnalysisExternalUrl;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels.PulsePhrasesAnalysisExternalUrlModel.PhrasesAnalysisModel;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlInterfaces.PulseQuotesAnalysisExternalUrl;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels.PulseQuotesAnalysisExternalUrlModel.QuotesAnalysisModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl.LinkMedia;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl.Title;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.InstantArticleModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel;
import com.facebook.search.results.protocol.video.SearchResultsVideoInterfaces.SearchResultsVideo;
import com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.AllShareStories;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.VideoShare;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoModels.SearchResultsWebVideoModel.AllShareStoriesModel;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoModels.SearchResultsWebVideoModel.LinkMediaModel;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoModels.SearchResultsWebVideoModel.VideoShareModel;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels.SearchResultsWikiModulePageModel.BestDescriptionModel;
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

/* compiled from: module_role */
public class SearchResultsEdgeModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1562842608)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: module_role */
    public final class SearchResultsEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NodeModel f8556d;
        @Nullable
        private SearchResultsDecorationModel f8557e;
        @Nullable
        private List<GraphQLGraphSearchResultsDisplayStyle> f8558f;
        @Nullable
        private GraphQLGraphSearchResultRole f8559g;

        /* compiled from: module_role */
        public final class Builder {
            @Nullable
            public NodeModel f8320a;
            @Nullable
            public SearchResultsDecorationModel f8321b;
            @Nullable
            public ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f8322c;
            @Nullable
            public GraphQLGraphSearchResultRole f8323d;

            public static Builder m9576a(SearchResultsEdgeModel searchResultsEdgeModel) {
                Builder builder = new Builder();
                builder.f8320a = searchResultsEdgeModel.m9774j();
                builder.f8321b = searchResultsEdgeModel.m9775k();
                builder.f8322c = searchResultsEdgeModel.m9772c();
                builder.f8323d = searchResultsEdgeModel.m9773d();
                return builder;
            }

            public final SearchResultsEdgeModel m9577a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f8320a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f8321b);
                int d = flatBufferBuilder.d(this.f8322c);
                int a3 = flatBufferBuilder.a(this.f8323d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, d);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SearchResultsEdgeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: module_role */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsEdgeModel.class, new Deserializer());
            }

            public Object m9578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsEdgeParser.m9796b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsEdgeModel = new SearchResultsEdgeModel();
                ((BaseModel) searchResultsEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsEdgeModel).a();
                }
                return searchResultsEdgeModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 931232679)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: module_role */
        public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsApp, SearchResultsEvent, SearchResultsGroup, SearchResultsPage, SearchResultsPlace, SearchResultsUser, SearchResultsVideo, SearchResultsWebVideo {
            private int f8507A;
            @Nullable
            private String f8508B;
            @Nullable
            private DefaultImageFieldsModel f8509C;
            @Nullable
            private DefaultImageFieldsModel f8510D;
            @Nullable
            private DefaultImageFieldsModel f8511E;
            private int f8512F;
            private int f8513G;
            private int f8514H;
            private boolean f8515I;
            private boolean f8516J;
            private boolean f8517K;
            private boolean f8518L;
            private boolean f8519M;
            @Nullable
            private LinkMediaModel f8520N;
            private int f8521O;
            @Nullable
            private LocationModel f8522P;
            private int f8523Q;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f8524R;
            @Nullable
            private ModuleResultsModel f8525S;
            @Nullable
            private GraphQLGraphSearchResultRole f8526T;
            private int f8527U;
            @Nullable
            private String f8528V;
            @Nullable
            private MutualFriendsModel f8529W;
            @Nullable
            private String f8530X;
            @Nullable
            private OverallStarRatingModel f8531Y;
            @Nullable
            private OwnerModel f8532Z;
            @Nullable
            private VisibilitySentenceModel aA;
            private int aB;
            @Nullable
            private SearchResultsPageCTAModel aa;
            @Nullable
            private PageLikersModel ab;
            @Nullable
            private PlaceOpenStatusModel ac;
            @Nullable
            private GraphQLPageOpenHoursDisplayDecisionEnum ad;
            private int ae;
            private int af;
            @Nullable
            private String ag;
            @Nullable
            private String ah;
            @Nullable
            private DefaultImageFieldsModel ai;
            @Nullable
            private String aj;
            @Nullable
            private SearchResultsSeeMoreQueryModel ak;
            @Nullable
            private SocialContextModel al;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel am;
            private double an;
            private double ao;
            @Nullable
            private String ap;
            @Nullable
            private String aq;
            private int ar;
            private boolean as;
            @Nullable
            private String at;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel au;
            @Nullable
            private String av;
            @Nullable
            private VideoShareModel aw;
            @Nullable
            private GraphQLEventGuestStatus ax;
            @Nullable
            private GraphQLGroupJoinState ay;
            @Nullable
            private GraphQLSavedState az;
            @Nullable
            private GraphQLObjectType f8533d;
            @Nullable
            private AddressModel f8534e;
            @Nullable
            private AllShareStoriesModel f8535f;
            @Nullable
            private List<String> f8536g;
            @Nullable
            private BioTextModel f8537h;
            @Nullable
            private GraphQLVideoBroadcastStatus f8538i;
            private boolean f8539j;
            private boolean f8540k;
            @Nullable
            private List<String> f8541l;
            @Nullable
            private CoverPhotoModel f8542m;
            private long f8543n;
            @Nullable
            private GraphQLStory f8544o;
            private long f8545p;
            @Nullable
            private List<GraphQLGraphSearchResultsDisplayStyle> f8546q;
            private boolean f8547r;
            @Nullable
            private EventPlaceModel f8548s;
            private boolean f8549t;
            @Nullable
            private String f8550u;
            @Nullable
            private GraphQLFriendshipStatus f8551v;
            @Nullable
            private GroupMembersModel f8552w;
            @Nullable
            private GuidedTourModel f8553x;
            private boolean f8554y;
            private boolean f8555z;

            /* compiled from: module_role */
            public final class Builder {
                @Nullable
                public DefaultImageFieldsModel f8324A;
                @Nullable
                public DefaultImageFieldsModel f8325B;
                public int f8326C;
                public int f8327D;
                public int f8328E;
                public boolean f8329F;
                public boolean f8330G;
                public boolean f8331H;
                public boolean f8332I;
                public boolean f8333J;
                @Nullable
                public LinkMediaModel f8334K;
                public int f8335L;
                @Nullable
                public LocationModel f8336M;
                public int f8337N;
                @Nullable
                public DefaultTextWithEntitiesLongFieldsModel f8338O;
                @Nullable
                public ModuleResultsModel f8339P;
                @Nullable
                public GraphQLGraphSearchResultRole f8340Q;
                public int f8341R;
                @Nullable
                public String f8342S;
                @Nullable
                public MutualFriendsModel f8343T;
                @Nullable
                public String f8344U;
                @Nullable
                public OverallStarRatingModel f8345V;
                @Nullable
                public OwnerModel f8346W;
                @Nullable
                public SearchResultsPageCTAModel f8347X;
                @Nullable
                public PageLikersModel f8348Y;
                @Nullable
                public PlaceOpenStatusModel f8349Z;
                @Nullable
                public GraphQLObjectType f8350a;
                @Nullable
                public GraphQLPageOpenHoursDisplayDecisionEnum aa;
                public int ab;
                public int ac;
                @Nullable
                public String ad;
                @Nullable
                public String ae;
                @Nullable
                public DefaultImageFieldsModel af;
                @Nullable
                public String ag;
                @Nullable
                public SearchResultsSeeMoreQueryModel ah;
                @Nullable
                public SocialContextModel ai;
                @Nullable
                public DefaultTextWithEntitiesLongFieldsModel aj;
                public double ak;
                public double al;
                @Nullable
                public String am;
                @Nullable
                public String an;
                public int ao;
                public boolean ap;
                @Nullable
                public String aq;
                @Nullable
                public DefaultTextWithEntitiesLongFieldsModel ar;
                @Nullable
                public String as;
                @Nullable
                public VideoShareModel at;
                @Nullable
                public GraphQLEventGuestStatus au;
                @Nullable
                public GraphQLGroupJoinState av;
                @Nullable
                public GraphQLSavedState aw;
                @Nullable
                public VisibilitySentenceModel ax;
                public int ay;
                @Nullable
                public AddressModel f8351b;
                @Nullable
                public AllShareStoriesModel f8352c;
                @Nullable
                public ImmutableList<String> f8353d;
                @Nullable
                public BioTextModel f8354e;
                @Nullable
                public GraphQLVideoBroadcastStatus f8355f;
                public boolean f8356g;
                public boolean f8357h;
                @Nullable
                public ImmutableList<String> f8358i;
                @Nullable
                public CoverPhotoModel f8359j;
                public long f8360k;
                @Nullable
                public GraphQLStory f8361l;
                public long f8362m;
                @Nullable
                public ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f8363n;
                public boolean f8364o;
                @Nullable
                public EventPlaceModel f8365p;
                public boolean f8366q;
                @Nullable
                public String f8367r;
                @Nullable
                public GraphQLFriendshipStatus f8368s;
                @Nullable
                public GroupMembersModel f8369t;
                @Nullable
                public GuidedTourModel f8370u;
                public boolean f8371v;
                public boolean f8372w;
                public int f8373x;
                @Nullable
                public String f8374y;
                @Nullable
                public DefaultImageFieldsModel f8375z;

                public static Builder m9579a(NodeModel nodeModel) {
                    Builder builder = new Builder();
                    builder.f8350a = nodeModel.m9745b();
                    builder.f8351b = nodeModel.aB();
                    builder.f8352c = nodeModel.aC();
                    builder.f8353d = nodeModel.jg_();
                    builder.f8354e = nodeModel.aD();
                    builder.f8355f = nodeModel.jh_();
                    builder.f8356g = nodeModel.ji_();
                    builder.f8357h = nodeModel.m9751l();
                    builder.f8358i = nodeModel.m9752m();
                    builder.f8359j = nodeModel.aE();
                    builder.f8360k = nodeModel.mo590o();
                    builder.f8361l = nodeModel.mo591p();
                    builder.f8362m = nodeModel.mo592q();
                    builder.f8363n = nodeModel.m9757r();
                    builder.f8364o = nodeModel.m9758s();
                    builder.f8365p = nodeModel.aF();
                    builder.f8366q = nodeModel.m9760u();
                    builder.f8367r = nodeModel.mo593v();
                    builder.f8368s = nodeModel.m9762w();
                    builder.f8369t = nodeModel.aG();
                    builder.f8370u = nodeModel.aH();
                    builder.f8371v = nodeModel.m9765z();
                    builder.f8372w = nodeModel.mo571A();
                    builder.f8373x = nodeModel.m9714B();
                    builder.f8374y = nodeModel.mo572C();
                    builder.f8375z = nodeModel.aI();
                    builder.f8324A = nodeModel.aJ();
                    builder.f8325B = nodeModel.aK();
                    builder.f8326C = nodeModel.m9719G();
                    builder.f8327D = nodeModel.m9720H();
                    builder.f8328E = nodeModel.m9721I();
                    builder.f8329F = nodeModel.mo576J();
                    builder.f8330G = nodeModel.m9723K();
                    builder.f8331H = nodeModel.m9724L();
                    builder.f8332I = nodeModel.mo562j();
                    builder.f8333J = nodeModel.m9725M();
                    builder.f8334K = nodeModel.aL();
                    builder.f8335L = nodeModel.m9727O();
                    builder.f8336M = nodeModel.aM();
                    builder.f8337N = nodeModel.m9729Q();
                    builder.f8338O = nodeModel.aN();
                    builder.f8339P = nodeModel.aO();
                    builder.f8340Q = nodeModel.m9732T();
                    builder.f8341R = nodeModel.m9733U();
                    builder.f8342S = nodeModel.m9734V();
                    builder.f8343T = nodeModel.aP();
                    builder.f8344U = nodeModel.mo563k();
                    builder.f8345V = nodeModel.aQ();
                    builder.f8346W = nodeModel.aR();
                    builder.f8347X = nodeModel.aS();
                    builder.f8348Y = nodeModel.aT();
                    builder.f8349Z = nodeModel.aU();
                    builder.aa = nodeModel.ac();
                    builder.ab = nodeModel.ad();
                    builder.ac = nodeModel.ae();
                    builder.ad = nodeModel.af();
                    builder.ae = nodeModel.ag();
                    builder.af = nodeModel.aV();
                    builder.ag = nodeModel.ai();
                    builder.ah = nodeModel.aW();
                    builder.ai = nodeModel.aX();
                    builder.aj = nodeModel.aY();
                    builder.ak = nodeModel.am();
                    builder.al = nodeModel.an();
                    builder.am = nodeModel.ao();
                    builder.an = nodeModel.ap();
                    builder.ao = nodeModel.aq();
                    builder.ap = nodeModel.ar();
                    builder.aq = nodeModel.as();
                    builder.ar = nodeModel.aZ();
                    builder.as = nodeModel.au();
                    builder.at = nodeModel.ba();
                    builder.au = nodeModel.aw();
                    builder.av = nodeModel.ax();
                    builder.aw = nodeModel.ay();
                    builder.ax = nodeModel.bb();
                    builder.ay = nodeModel.aA();
                    return builder;
                }

                public final NodeModel m9580a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8350a);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f8351b);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f8352c);
                    int c = flatBufferBuilder.c(this.f8353d);
                    int a4 = ModelHelper.a(flatBufferBuilder, this.f8354e);
                    int a5 = flatBufferBuilder.a(this.f8355f);
                    int c2 = flatBufferBuilder.c(this.f8358i);
                    int a6 = ModelHelper.a(flatBufferBuilder, this.f8359j);
                    int a7 = ModelHelper.a(flatBufferBuilder, this.f8361l);
                    int d = flatBufferBuilder.d(this.f8363n);
                    int a8 = ModelHelper.a(flatBufferBuilder, this.f8365p);
                    int b = flatBufferBuilder.b(this.f8367r);
                    int a9 = flatBufferBuilder.a(this.f8368s);
                    int a10 = ModelHelper.a(flatBufferBuilder, this.f8369t);
                    int a11 = ModelHelper.a(flatBufferBuilder, this.f8370u);
                    int b2 = flatBufferBuilder.b(this.f8374y);
                    int a12 = ModelHelper.a(flatBufferBuilder, this.f8375z);
                    int a13 = ModelHelper.a(flatBufferBuilder, this.f8324A);
                    int a14 = ModelHelper.a(flatBufferBuilder, this.f8325B);
                    int a15 = ModelHelper.a(flatBufferBuilder, this.f8334K);
                    int a16 = ModelHelper.a(flatBufferBuilder, this.f8336M);
                    int a17 = ModelHelper.a(flatBufferBuilder, this.f8338O);
                    int a18 = ModelHelper.a(flatBufferBuilder, this.f8339P);
                    int a19 = flatBufferBuilder.a(this.f8340Q);
                    int b3 = flatBufferBuilder.b(this.f8342S);
                    int a20 = ModelHelper.a(flatBufferBuilder, this.f8343T);
                    int b4 = flatBufferBuilder.b(this.f8344U);
                    int a21 = ModelHelper.a(flatBufferBuilder, this.f8345V);
                    int a22 = ModelHelper.a(flatBufferBuilder, this.f8346W);
                    int a23 = ModelHelper.a(flatBufferBuilder, this.f8347X);
                    int a24 = ModelHelper.a(flatBufferBuilder, this.f8348Y);
                    int a25 = ModelHelper.a(flatBufferBuilder, this.f8349Z);
                    int a26 = flatBufferBuilder.a(this.aa);
                    int b5 = flatBufferBuilder.b(this.ad);
                    int b6 = flatBufferBuilder.b(this.ae);
                    int a27 = ModelHelper.a(flatBufferBuilder, this.af);
                    int b7 = flatBufferBuilder.b(this.ag);
                    int a28 = ModelHelper.a(flatBufferBuilder, this.ah);
                    int a29 = ModelHelper.a(flatBufferBuilder, this.ai);
                    int a30 = ModelHelper.a(flatBufferBuilder, this.aj);
                    int b8 = flatBufferBuilder.b(this.am);
                    int b9 = flatBufferBuilder.b(this.an);
                    int b10 = flatBufferBuilder.b(this.aq);
                    int a31 = ModelHelper.a(flatBufferBuilder, this.ar);
                    int b11 = flatBufferBuilder.b(this.as);
                    int a32 = ModelHelper.a(flatBufferBuilder, this.at);
                    int a33 = flatBufferBuilder.a(this.au);
                    int a34 = flatBufferBuilder.a(this.av);
                    int a35 = flatBufferBuilder.a(this.aw);
                    int a36 = ModelHelper.a(flatBufferBuilder, this.ax);
                    flatBufferBuilder.c(77);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, c);
                    flatBufferBuilder.b(4, a4);
                    flatBufferBuilder.b(5, a5);
                    flatBufferBuilder.a(6, this.f8356g);
                    flatBufferBuilder.a(7, this.f8357h);
                    flatBufferBuilder.b(8, c2);
                    flatBufferBuilder.b(9, a6);
                    flatBufferBuilder.a(10, this.f8360k, 0);
                    flatBufferBuilder.b(11, a7);
                    flatBufferBuilder.a(12, this.f8362m, 0);
                    flatBufferBuilder.b(13, d);
                    flatBufferBuilder.a(14, this.f8364o);
                    flatBufferBuilder.b(15, a8);
                    flatBufferBuilder.a(16, this.f8366q);
                    flatBufferBuilder.b(17, b);
                    flatBufferBuilder.b(18, a9);
                    flatBufferBuilder.b(19, a10);
                    flatBufferBuilder.b(20, a11);
                    flatBufferBuilder.a(21, this.f8371v);
                    flatBufferBuilder.a(22, this.f8372w);
                    flatBufferBuilder.a(23, this.f8373x, 0);
                    flatBufferBuilder.b(24, b2);
                    flatBufferBuilder.b(25, a12);
                    flatBufferBuilder.b(26, a13);
                    flatBufferBuilder.b(27, a14);
                    flatBufferBuilder.a(28, this.f8326C, 0);
                    flatBufferBuilder.a(29, this.f8327D, 0);
                    flatBufferBuilder.a(30, this.f8328E, 0);
                    flatBufferBuilder.a(31, this.f8329F);
                    flatBufferBuilder.a(32, this.f8330G);
                    flatBufferBuilder.a(33, this.f8331H);
                    flatBufferBuilder.a(34, this.f8332I);
                    flatBufferBuilder.a(35, this.f8333J);
                    flatBufferBuilder.b(36, a15);
                    flatBufferBuilder.a(37, this.f8335L, 0);
                    flatBufferBuilder.b(38, a16);
                    flatBufferBuilder.a(39, this.f8337N, 0);
                    flatBufferBuilder.b(40, a17);
                    flatBufferBuilder.b(41, a18);
                    flatBufferBuilder.b(42, a19);
                    flatBufferBuilder.a(43, this.f8341R, 0);
                    flatBufferBuilder.b(44, b3);
                    flatBufferBuilder.b(45, a20);
                    flatBufferBuilder.b(46, b4);
                    flatBufferBuilder.b(47, a21);
                    flatBufferBuilder.b(48, a22);
                    flatBufferBuilder.b(49, a23);
                    flatBufferBuilder.b(50, a24);
                    flatBufferBuilder.b(51, a25);
                    flatBufferBuilder.b(52, a26);
                    flatBufferBuilder.a(53, this.ab, 0);
                    flatBufferBuilder.a(54, this.ac, 0);
                    flatBufferBuilder.b(55, b5);
                    flatBufferBuilder.b(56, b6);
                    flatBufferBuilder.b(57, a27);
                    flatBufferBuilder.b(58, b7);
                    flatBufferBuilder.b(59, a28);
                    flatBufferBuilder.b(60, a29);
                    flatBufferBuilder.b(61, a30);
                    flatBufferBuilder.a(62, this.ak, 0.0d);
                    flatBufferBuilder.a(63, this.al, 0.0d);
                    flatBufferBuilder.b(64, b8);
                    flatBufferBuilder.b(65, b9);
                    flatBufferBuilder.a(66, this.ao, 0);
                    flatBufferBuilder.a(67, this.ap);
                    flatBufferBuilder.b(68, b10);
                    flatBufferBuilder.b(69, a31);
                    flatBufferBuilder.b(70, b11);
                    flatBufferBuilder.b(71, a32);
                    flatBufferBuilder.b(72, a33);
                    flatBufferBuilder.b(73, a34);
                    flatBufferBuilder.b(74, a35);
                    flatBufferBuilder.b(75, a36);
                    flatBufferBuilder.a(76, this.ay, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    NodeModel nodeModel = new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    if (this.f8361l != null) {
                        nodeModel.mo591p().a(this.f8361l.U_());
                    }
                    return nodeModel;
                }
            }

            /* compiled from: module_role */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m9581a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m9794a(jsonParser, flatBufferBuilder));
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

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1249243346)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: module_role */
            public final class ModuleResultsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f8506d;

                /* compiled from: module_role */
                public final class Builder {
                    @Nullable
                    public ImmutableList<EdgesModel> f8376a;

                    public Builder() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Builder.<init>():void");
                    }

                    public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Builder m9582a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$Builder;
                        r0.<init>();
                        r1 = r2.m9710a();
                        r0.f8376a = r1;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Builder.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$Builder");
                    }

                    public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel m9583a() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r6 = this;
                        r4 = 1;
                        r3 = 0;
                        r2 = 0;
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r6.f8376a;
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                        r0.c(r4);
                        r0.b(r3, r1);
                        r1 = r0.d();
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r1.position(r3);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel;
                        r1.<init>(r0);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Builder.a():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel");
                    }
                }

                /* compiled from: module_role */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Deserializer.<init>():void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.class;
                        r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m9584a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.m9792a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1275690900)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: module_role */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private EdgesNodeModel f8504d;
                    @Nullable
                    private GraphQLGraphSearchResultRole f8505e;

                    /* compiled from: module_role */
                    public final class Builder {
                        @Nullable
                        public EdgesNodeModel f8377a;
                        @Nullable
                        public GraphQLGraphSearchResultRole f8378b;

                        public Builder() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            r0.<init>();
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Builder.<init>():void");
                        }

                        public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Builder m9585a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel r2) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$Builder;
                            r0.<init>();
                            r1 = r2.m9701j();
                            r0.f8377a = r1;
                            r1 = r2.m9700b();
                            r0.f8378b = r1;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Builder.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$Builder");
                        }

                        public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel m9586a() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r4 = 1;
                            r6 = 0;
                            r2 = 0;
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r7.f8377a;
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                            r3 = r7.f8378b;
                            r3 = r0.a(r3);
                            r5 = 2;
                            r0.c(r5);
                            r0.b(r6, r1);
                            r0.b(r4, r3);
                            r1 = r0.d();
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r1.position(r6);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel;
                            r1.<init>(r0);
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Builder.a():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel");
                        }
                    }

                    /* compiled from: module_role */
                    public class Deserializer extends FbJsonDeserializer {
                        public Deserializer() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            r0.<init>();
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Deserializer.<init>():void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.class;
                            r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m9587a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.m9790b(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    @FragmentModelWithBridge
                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 382549765)
                    @JsonSerialize(using = Serializer.class)
                    /* compiled from: module_role */
                    public final class EdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, PulseEmotionAnalysisExternalUrl, PulsePhrasesAnalysisExternalUrl, PulseQuotesAnalysisExternalUrl, SearchResultsArticleExternalUrl, SearchResultsVideo, SearchResultsWebVideo, SearchResultsWikiModulePage {
                        private boolean f8455A;
                        private boolean f8456B;
                        @Nullable
                        private LinkMediaModel f8457C;
                        private int f8458D;
                        private int f8459E;
                        @Nullable
                        private DefaultTextWithEntitiesLongFieldsModel f8460F;
                        @Nullable
                        private String f8461G;
                        @Nullable
                        private OpenGraphNodeModel f8462H;
                        @Nullable
                        private OwnerModel f8463I;
                        @Nullable
                        private PhrasesAnalysisModel f8464J;
                        private int f8465K;
                        private int f8466L;
                        @Nullable
                        private String f8467M;
                        @Nullable
                        private String f8468N;
                        @Nullable
                        private QuotesAnalysisModel f8469O;
                        @Nullable
                        private SourceModel f8470P;
                        private double f8471Q;
                        private double f8472R;
                        @Nullable
                        private String f8473S;
                        @Nullable
                        private String f8474T;
                        private int f8475U;
                        @Nullable
                        private SummaryModel f8476V;
                        private boolean f8477W;
                        @Nullable
                        private TitleModel f8478X;
                        @Nullable
                        private String f8479Y;
                        @Nullable
                        private VideoShareModel f8480Z;
                        private int aa;
                        @Nullable
                        private GraphQLObjectType f8481d;
                        @Nullable
                        private AllShareStoriesModel f8482e;
                        @Nullable
                        private BestDescriptionModel f8483f;
                        @Nullable
                        private GraphQLVideoBroadcastStatus f8484g;
                        private long f8485h;
                        @Nullable
                        private GraphQLStory f8486i;
                        private long f8487j;
                        @Nullable
                        private EmotionalAnalysisModel f8488k;
                        @Nullable
                        private String f8489l;
                        @Nullable
                        private GuidedTourModel f8490m;
                        private boolean f8491n;
                        private boolean f8492o;
                        private int f8493p;
                        @Nullable
                        private String f8494q;
                        @Nullable
                        private DefaultImageFieldsModel f8495r;
                        @Nullable
                        private DefaultImageFieldsModel f8496s;
                        @Nullable
                        private DefaultImageFieldsModel f8497t;
                        private int f8498u;
                        private int f8499v;
                        private int f8500w;
                        @Nullable
                        private InstantArticleModel f8501x;
                        private boolean f8502y;
                        private boolean f8503z;

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1723990064)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: module_role */
                        public final class AllShareStoriesModel extends BaseModel implements GraphQLVisitableModel, AllShareStories {
                            private int f8380d;

                            /* compiled from: module_role */
                            public final class Builder {
                                public int f8379a;

                                public Builder() {
                                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.Builder.<init>():void");
                                }
                            }

                            /* compiled from: module_role */
                            public class Deserializer extends FbJsonDeserializer {
                                public Deserializer() {
                                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.Deserializer.<init>():void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m9588a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r10 = this;
                                    r8 = 1;
                                    r6 = 0;
                                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r4.<init>(r5);
                                    r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.AllShareStoriesParser.m9776a(r11, r4);
                                    r4.d(r5);
                                    r4 = r4.e();
                                    r5 = java.nio.ByteBuffer.wrap(r4);
                                    r4 = 0;
                                    r5.position(r4);
                                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r7 = r6;
                                    r9 = r6;
                                    r4.<init>(r5, r6, r7, r8, r9);
                                    r5 = 4;
                                    r6 = java.lang.Boolean.valueOf(r8);
                                    r4.a(r5, r6);
                                    r2 = r4;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel;
                                    r1.<init>();
                                    r4 = r2.a;
                                    r0 = r4;
                                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                    r0 = r1;
                                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                    r0.a(r2, r3, r11);
                                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                    if (r0 == 0) goto L_0x0048;
                                L_0x0042:
                                    r1 = (com.facebook.common.json.Postprocessable) r1;
                                    r1 = r1.a();
                                L_0x0048:
                                    return r1;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            /* compiled from: module_role */
                            public class Serializer extends JsonSerializer<AllShareStoriesModel> {
                                public Serializer() {
                                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.Serializer.<init>():void");
                                }

                                public final void m9589a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.checkObjectInline(ConstInlineVisitor.java:80)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:57)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r7 = this;
                                    r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m9592a(r0);
                                    r0.d(r1);
                                    r0 = r0.e();
                                    r1 = java.nio.ByteBuffer.wrap(r0);
                                    r0 = 0;
                                    r1.position(r0);
                                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r4 = 1;
                                    r3 = r2;
                                    r5 = r2;
                                    r0.<init>(r1, r2, r3, r4, r5);
                                    r6 = r0.a;
                                    r1 = r6;
                                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                    r8.a(r0, r1);
                                L_0x0035:
                                    r0 = r8.w_();
                                    r1 = r8.u_();
                                    com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.AllShareStoriesParser.m9777a(r0, r1, r9);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.Serializer.<clinit>():void");
                                }
                            }

                            public AllShareStoriesModel() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 1;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.<init>():void");
                            }

                            public AllShareStoriesModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 1;
                                r2.<init>(r0);
                                r1 = r3.a;
                                r0 = r1;
                                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r2.a(r3, r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                            }

                            public final int mo564a() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.checkObjectInline(ConstInlineVisitor.java:80)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:57)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 0;
                                r1.a(r0, r0);
                                r0 = r1.f8380d;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.a():int");
                            }

                            public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel m9590a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel r8) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.checkObjectInline(ConstInlineVisitor.java:80)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:57)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                if (r8 != 0) goto L_0x0004;
                            L_0x0002:
                                r8 = 0;
                            L_0x0003:
                                return r8;
                            L_0x0004:
                                r0 = r8 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel;
                                if (r0 == 0) goto L_0x000b;
                            L_0x0008:
                                r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel) r8;
                                goto L_0x0003;
                            L_0x000b:
                                r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel$Builder;
                                r0.<init>();
                                r1 = r8.mo564a();
                                r0.f8379a = r1;
                                r6 = 1;
                                r4 = 0;
                                r5 = 0;
                                r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r2.<init>(r3);
                                r2.c(r6);
                                r3 = r0.f8379a;
                                r2.a(r5, r3, r5);
                                r3 = r2.d();
                                r2.d(r3);
                                r2 = r2.e();
                                r3 = java.nio.ByteBuffer.wrap(r2);
                                r3.position(r5);
                                r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r5 = r4;
                                r7 = r4;
                                r2.<init>(r3, r4, r5, r6, r7);
                                r3 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel;
                                r3.<init>(r2);
                                r8 = r3;
                                goto L_0x0003;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel");
                            }

                            public final int jK_() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = -1051680685; // 0xffffffffc150a053 float:-13.039142 double:NaN;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m9593a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = this;
                                r0.h();
                                r0.i();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m9592a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.checkObjectInline(ConstInlineVisitor.java:80)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:57)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r1 = 0;
                                r2.h();
                                r0 = 1;
                                r3.c(r0);
                                r0 = r2.f8380d;
                                r3.a(r1, r0, r1);
                                r2.i();
                                r0 = r3.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }

                            public final void m9594a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.checkObjectInline(ConstInlineVisitor.java:80)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:57)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 0;
                                super.a(r2, r3, r4);
                                r0 = r2.a(r3, r0, r0);
                                r1.f8380d = r0;
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                            }
                        }

                        /* compiled from: module_role */
                        public final class Builder {
                            public int f8381A;
                            public int f8382B;
                            @Nullable
                            public DefaultTextWithEntitiesLongFieldsModel f8383C;
                            @Nullable
                            public String f8384D;
                            @Nullable
                            public OpenGraphNodeModel f8385E;
                            @Nullable
                            public OwnerModel f8386F;
                            @Nullable
                            public PhrasesAnalysisModel f8387G;
                            public int f8388H;
                            public int f8389I;
                            @Nullable
                            public String f8390J;
                            @Nullable
                            public String f8391K;
                            @Nullable
                            public QuotesAnalysisModel f8392L;
                            @Nullable
                            public SourceModel f8393M;
                            public double f8394N;
                            public double f8395O;
                            @Nullable
                            public String f8396P;
                            @Nullable
                            public String f8397Q;
                            public int f8398R;
                            @Nullable
                            public SummaryModel f8399S;
                            public boolean f8400T;
                            @Nullable
                            public TitleModel f8401U;
                            @Nullable
                            public String f8402V;
                            @Nullable
                            public VideoShareModel f8403W;
                            public int f8404X;
                            @Nullable
                            public GraphQLObjectType f8405a;
                            @Nullable
                            public AllShareStoriesModel f8406b;
                            @Nullable
                            public BestDescriptionModel f8407c;
                            @Nullable
                            public GraphQLVideoBroadcastStatus f8408d;
                            public long f8409e;
                            @Nullable
                            public GraphQLStory f8410f;
                            public long f8411g;
                            @Nullable
                            public EmotionalAnalysisModel f8412h;
                            @Nullable
                            public String f8413i;
                            @Nullable
                            public GuidedTourModel f8414j;
                            public boolean f8415k;
                            public boolean f8416l;
                            public int f8417m;
                            @Nullable
                            public String f8418n;
                            @Nullable
                            public DefaultImageFieldsModel f8419o;
                            @Nullable
                            public DefaultImageFieldsModel f8420p;
                            @Nullable
                            public DefaultImageFieldsModel f8421q;
                            public int f8422r;
                            public int f8423s;
                            public int f8424t;
                            @Nullable
                            public InstantArticleModel f8425u;
                            public boolean f8426v;
                            public boolean f8427w;
                            public boolean f8428x;
                            public boolean f8429y;
                            @Nullable
                            public LinkMediaModel f8430z;

                            public Builder() {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = this;
                                r0.<init>();
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Builder.<init>():void");
                            }

                            public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Builder m9595a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel r4) {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$Builder;
                                r0.<init>();
                                r1 = r4.m9674b();
                                r0.f8405a = r1;
                                r1 = r4.aa();
                                r0.f8406b = r1;
                                r1 = r4.ab();
                                r0.f8407c = r1;
                                r1 = r4.m9677g();
                                r0.f8408d = r1;
                                r2 = r4.mo590o();
                                r0.f8409e = r2;
                                r1 = r4.mo591p();
                                r0.f8410f = r1;
                                r2 = r4.mo592q();
                                r0.f8411g = r2;
                                r1 = r4.ac();
                                r0.f8412h = r1;
                                r1 = r4.mo593v();
                                r0.f8413i = r1;
                                r1 = r4.af();
                                r0.f8414j = r1;
                                r1 = r4.m9678j();
                                r0.f8415k = r1;
                                r1 = r4.mo571A();
                                r0.f8416l = r1;
                                r1 = r4.m9679k();
                                r0.f8417m = r1;
                                r1 = r4.mo572C();
                                r0.f8418n = r1;
                                r1 = r4.ag();
                                r0.f8419o = r1;
                                r1 = r4.ah();
                                r0.f8420p = r1;
                                r1 = r4.ai();
                                r0.f8421q = r1;
                                r1 = r4.m9682n();
                                r0.f8422r = r1;
                                r1 = r4.m9686r();
                                r0.f8423s = r1;
                                r1 = r4.m9687s();
                                r0.f8424t = r1;
                                r1 = r4.aj();
                                r0.f8425u = r1;
                                r1 = r4.mo576J();
                                r0.f8426v = r1;
                                r1 = r4.m9689u();
                                r0.f8427w = r1;
                                r1 = r4.m9691w();
                                r0.f8428x = r1;
                                r1 = r4.m9692x();
                                r0.f8429y = r1;
                                r1 = r4.ak();
                                r0.f8430z = r1;
                                r1 = r4.m9694z();
                                r0.f8381A = r1;
                                r1 = r4.m9643B();
                                r0.f8382B = r1;
                                r1 = r4.am();
                                r0.f8383C = r1;
                                r1 = r4.mo573D();
                                r0.f8384D = r1;
                                r1 = r4.an();
                                r0.f8385E = r1;
                                r1 = r4.ao();
                                r0.f8386F = r1;
                                r1 = r4.ap();
                                r0.f8387G = r1;
                                r1 = r4.ad();
                                r0.f8388H = r1;
                                r1 = r4.ae();
                                r0.f8389I = r1;
                                r1 = r4.m9649H();
                                r0.f8390J = r1;
                                r1 = r4.m9650I();
                                r0.f8391K = r1;
                                r1 = r4.aq();
                                r0.f8392L = r1;
                                r1 = r4.ar();
                                r0.f8393M = r1;
                                r2 = r4.m9654M();
                                r0.f8394N = r2;
                                r2 = r4.m9656O();
                                r0.f8395O = r2;
                                r1 = r4.m9657P();
                                r0.f8396P = r1;
                                r1 = r4.m9658Q();
                                r0.f8397Q = r1;
                                r1 = r4.m9660S();
                                r0.f8398R = r1;
                                r1 = r4.as();
                                r0.f8399S = r1;
                                r1 = r4.m9662U();
                                r0.f8400T = r1;
                                r1 = r4.au();
                                r0.f8401U = r1;
                                r1 = r4.m9664W();
                                r0.f8402V = r1;
                                r1 = r4.aw();
                                r0.f8403W = r1;
                                r1 = r4.m9667Z();
                                r0.f8404X = r1;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Builder.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$Builder");
                            }

                            public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel m9596a() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:102)
	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:71)
	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r33 = this;
                                r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r2.<init>(r3);
                                r0 = r33;
                                r3 = r0.f8405a;
                                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                                r0 = r33;
                                r4 = r0.f8406b;
                                r4 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r4);
                                r0 = r33;
                                r5 = r0.f8407c;
                                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r5);
                                r0 = r33;
                                r6 = r0.f8408d;
                                r6 = r2.a(r6);
                                r0 = r33;
                                r7 = r0.f8410f;
                                r8 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8412h;
                                r9 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8413i;
                                r10 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8414j;
                                r11 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8418n;
                                r12 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8419o;
                                r13 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8420p;
                                r14 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8421q;
                                r15 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8425u;
                                r16 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8430z;
                                r17 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8383C;
                                r18 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8384D;
                                r19 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8385E;
                                r20 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8386F;
                                r21 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8387G;
                                r22 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8390J;
                                r23 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8391K;
                                r24 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8392L;
                                r25 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8393M;
                                r26 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8396P;
                                r27 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8397Q;
                                r28 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8399S;
                                r29 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8401U;
                                r30 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r0 = r33;
                                r7 = r0.f8402V;
                                r31 = r2.b(r7);
                                r0 = r33;
                                r7 = r0.f8403W;
                                r32 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r7 = 50;
                                r2.c(r7);
                                r7 = 0;
                                r2.b(r7, r3);
                                r3 = 1;
                                r2.b(r3, r4);
                                r3 = 2;
                                r2.b(r3, r5);
                                r3 = 3;
                                r2.b(r3, r6);
                                r3 = 4;
                                r0 = r33;
                                r4 = r0.f8409e;
                                r6 = 0;
                                r2.a(r3, r4, r6);
                                r3 = 5;
                                r2.b(r3, r8);
                                r3 = 6;
                                r0 = r33;
                                r4 = r0.f8411g;
                                r6 = 0;
                                r2.a(r3, r4, r6);
                                r3 = 7;
                                r2.b(r3, r9);
                                r3 = 8;
                                r2.b(r3, r10);
                                r3 = 9;
                                r2.b(r3, r11);
                                r3 = 10;
                                r0 = r33;
                                r4 = r0.f8415k;
                                r2.a(r3, r4);
                                r3 = 11;
                                r0 = r33;
                                r4 = r0.f8416l;
                                r2.a(r3, r4);
                                r3 = 12;
                                r0 = r33;
                                r4 = r0.f8417m;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 13;
                                r2.b(r3, r12);
                                r3 = 14;
                                r2.b(r3, r13);
                                r3 = 15;
                                r2.b(r3, r14);
                                r3 = 16;
                                r2.b(r3, r15);
                                r3 = 17;
                                r0 = r33;
                                r4 = r0.f8422r;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 18;
                                r0 = r33;
                                r4 = r0.f8423s;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 19;
                                r0 = r33;
                                r4 = r0.f8424t;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 20;
                                r0 = r16;
                                r2.b(r3, r0);
                                r3 = 21;
                                r0 = r33;
                                r4 = r0.f8426v;
                                r2.a(r3, r4);
                                r3 = 22;
                                r0 = r33;
                                r4 = r0.f8427w;
                                r2.a(r3, r4);
                                r3 = 23;
                                r0 = r33;
                                r4 = r0.f8428x;
                                r2.a(r3, r4);
                                r3 = 24;
                                r0 = r33;
                                r4 = r0.f8429y;
                                r2.a(r3, r4);
                                r3 = 25;
                                r0 = r17;
                                r2.b(r3, r0);
                                r3 = 26;
                                r0 = r33;
                                r4 = r0.f8381A;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 27;
                                r0 = r33;
                                r4 = r0.f8382B;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 28;
                                r0 = r18;
                                r2.b(r3, r0);
                                r3 = 29;
                                r0 = r19;
                                r2.b(r3, r0);
                                r3 = 30;
                                r0 = r20;
                                r2.b(r3, r0);
                                r3 = 31;
                                r0 = r21;
                                r2.b(r3, r0);
                                r3 = 32;
                                r0 = r22;
                                r2.b(r3, r0);
                                r3 = 33;
                                r0 = r33;
                                r4 = r0.f8388H;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 34;
                                r0 = r33;
                                r4 = r0.f8389I;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 35;
                                r0 = r23;
                                r2.b(r3, r0);
                                r3 = 36;
                                r0 = r24;
                                r2.b(r3, r0);
                                r3 = 37;
                                r0 = r25;
                                r2.b(r3, r0);
                                r3 = 38;
                                r0 = r26;
                                r2.b(r3, r0);
                                r3 = 39;
                                r0 = r33;
                                r4 = r0.f8394N;
                                r6 = 0;
                                r2.a(r3, r4, r6);
                                r3 = 40;
                                r0 = r33;
                                r4 = r0.f8395O;
                                r6 = 0;
                                r2.a(r3, r4, r6);
                                r3 = 41;
                                r0 = r27;
                                r2.b(r3, r0);
                                r3 = 42;
                                r0 = r28;
                                r2.b(r3, r0);
                                r3 = 43;
                                r0 = r33;
                                r4 = r0.f8398R;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = 44;
                                r0 = r29;
                                r2.b(r3, r0);
                                r3 = 45;
                                r0 = r33;
                                r4 = r0.f8400T;
                                r2.a(r3, r4);
                                r3 = 46;
                                r0 = r30;
                                r2.b(r3, r0);
                                r3 = 47;
                                r0 = r31;
                                r2.b(r3, r0);
                                r3 = 48;
                                r0 = r32;
                                r2.b(r3, r0);
                                r3 = 49;
                                r0 = r33;
                                r4 = r0.f8404X;
                                r5 = 0;
                                r2.a(r3, r4, r5);
                                r3 = r2.d();
                                r2.d(r3);
                                r2 = r2.e();
                                r3 = java.nio.ByteBuffer.wrap(r2);
                                r2 = 0;
                                r3.position(r2);
                                r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r4 = 0;
                                r5 = 0;
                                r6 = 1;
                                r7 = 0;
                                r2.<init>(r3, r4, r5, r6, r7);
                                r3 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel;
                                r3.<init>(r2);
                                r0 = r33;
                                r2 = r0.f8410f;
                                if (r2 == 0) goto L_0x02a4;
                            L_0x0295:
                                r2 = r3.mo591p();
                                r0 = r33;
                                r4 = r0.f8410f;
                                r4 = r4.U_();
                                r2.a(r4);
                            L_0x02a4:
                                return r3;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Builder.a():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel");
                            }
                        }

                        /* compiled from: module_role */
                        public class Deserializer extends FbJsonDeserializer {
                            public Deserializer() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = this;
                                r0.<init>();
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Deserializer.<init>():void");
                            }

                            static {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.class;
                                r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m9597a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r10 = this;
                                r8 = 1;
                                r6 = 0;
                                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r4.<init>(r5);
                                r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.m9788a(r11, r4);
                                r4.d(r5);
                                r4 = r4.e();
                                r5 = java.nio.ByteBuffer.wrap(r4);
                                r4 = 0;
                                r5.position(r4);
                                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r7 = r6;
                                r9 = r6;
                                r4.<init>(r5, r6, r7, r8, r9);
                                r5 = 4;
                                r6 = java.lang.Boolean.valueOf(r8);
                                r4.a(r5, r6);
                                r2 = r4;
                                r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel;
                                r1.<init>();
                                r4 = r2.a;
                                r0 = r4;
                                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r0 = r1;
                                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                r0.a(r2, r3, r11);
                                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                if (r0 == 0) goto L_0x0048;
                            L_0x0042:
                                r1 = (com.facebook.common.json.Postprocessable) r1;
                                r1 = r1.a();
                            L_0x0048:
                                return r1;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1804474546)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: module_role */
                        public final class LinkMediaModel extends BaseModel implements GraphQLVisitableModel, LinkMedia, SearchResultsWebVideo.LinkMedia {
                            @Nullable
                            private GraphQLObjectType f8440d;
                            @Nullable
                            private ImageModel f8441e;
                            @Nullable
                            private PulseCoverPhotoModel f8442f;

                            /* compiled from: module_role */
                            public final class Builder {
                                @Nullable
                                public GraphQLObjectType f8431a;
                                @Nullable
                                public ImageModel f8432b;
                                @Nullable
                                public PulseCoverPhotoModel f8433c;

                                public Builder() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.Builder.<init>():void");
                                }
                            }

                            /* compiled from: module_role */
                            public class Deserializer extends FbJsonDeserializer {
                                public Deserializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.Deserializer.<init>():void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m9598a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r10 = this;
                                    r8 = 1;
                                    r6 = 0;
                                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r4.<init>(r5);
                                    r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.LinkMediaParser.m9780a(r11, r4);
                                    r4.d(r5);
                                    r4 = r4.e();
                                    r5 = java.nio.ByteBuffer.wrap(r4);
                                    r4 = 0;
                                    r5.position(r4);
                                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r7 = r6;
                                    r9 = r6;
                                    r4.<init>(r5, r6, r7, r8, r9);
                                    r5 = 4;
                                    r6 = java.lang.Boolean.valueOf(r8);
                                    r4.a(r5, r6);
                                    r2 = r4;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel;
                                    r1.<init>();
                                    r4 = r2.a;
                                    r0 = r4;
                                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                    r0 = r1;
                                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                    r0.a(r2, r3, r11);
                                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                    if (r0 == 0) goto L_0x0048;
                                L_0x0042:
                                    r1 = (com.facebook.common.json.Postprocessable) r1;
                                    r1 = r1.a();
                                L_0x0048:
                                    return r1;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = 729935302)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: module_role */
                            public final class ImageModel extends BaseModel implements DefaultImageFields, GraphQLVisitableModel {
                                private int f8437d;
                                @Nullable
                                private String f8438e;
                                private int f8439f;

                                /* compiled from: module_role */
                                public final class Builder {
                                    public int f8434a;
                                    @Nullable
                                    public String f8435b;
                                    public int f8436c;

                                    public Builder() {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r0 = this;
                                        r0.<init>();
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.Builder.<init>():void");
                                    }
                                }

                                /* compiled from: module_role */
                                public class Deserializer extends FbJsonDeserializer {
                                    public Deserializer() {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r0 = this;
                                        r0.<init>();
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.Deserializer.<init>():void");
                                    }

                                    static {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.class;
                                        r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel$Deserializer;
                                        r1.<init>();
                                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.Deserializer.<clinit>():void");
                                    }

                                    public java.lang.Object m9599a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r10 = this;
                                        r8 = 1;
                                        r6 = 0;
                                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                        r4.<init>(r5);
                                        r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.LinkMediaParser.ImageParser.m9778a(r11, r4);
                                        r4.d(r5);
                                        r4 = r4.e();
                                        r5 = java.nio.ByteBuffer.wrap(r4);
                                        r4 = 0;
                                        r5.position(r4);
                                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                        r7 = r6;
                                        r9 = r6;
                                        r4.<init>(r5, r6, r7, r8, r9);
                                        r5 = 4;
                                        r6 = java.lang.Boolean.valueOf(r8);
                                        r4.a(r5, r6);
                                        r2 = r4;
                                        r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel;
                                        r1.<init>();
                                        r4 = r2.a;
                                        r0 = r4;
                                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                        r0 = r1;
                                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                        r0.a(r2, r3, r11);
                                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                        if (r0 == 0) goto L_0x0048;
                                    L_0x0042:
                                        r1 = (com.facebook.common.json.Postprocessable) r1;
                                        r1 = r1.a();
                                    L_0x0048:
                                        return r1;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                    }
                                }

                                /* compiled from: module_role */
                                public class Serializer extends JsonSerializer<ImageModel> {
                                    public Serializer() {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r0 = this;
                                        r0.<init>();
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.Serializer.<init>():void");
                                    }

                                    public final void m9600a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r7 = this;
                                        r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel) r8;
                                        r2 = 0;
                                        r0 = r8.w_();
                                        if (r0 != 0) goto L_0x0035;
                                    L_0x0009:
                                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                        r0.<init>(r1);
                                        r1 = r8.m9603a(r0);
                                        r0.d(r1);
                                        r0 = r0.e();
                                        r1 = java.nio.ByteBuffer.wrap(r0);
                                        r0 = 0;
                                        r1.position(r0);
                                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                        r4 = 1;
                                        r3 = r2;
                                        r5 = r2;
                                        r0.<init>(r1, r2, r3, r4, r5);
                                        r6 = r0.a;
                                        r1 = r6;
                                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                        r8.a(r0, r1);
                                    L_0x0035:
                                        r0 = r8.w_();
                                        r1 = r8.u_();
                                        com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.LinkMediaParser.ImageParser.m9779a(r0, r1, r9);
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                                    }

                                    static {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.class;
                                        r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel$Serializer;
                                        r1.<init>();
                                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.Serializer.<clinit>():void");
                                    }
                                }

                                public ImageModel() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r1 = this;
                                    r0 = 3;
                                    r1.<init>(r0);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.<init>():void");
                                }

                                public ImageModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r2 = this;
                                    r0 = 3;
                                    r2.<init>(r0);
                                    r1 = r3.a;
                                    r0 = r1;
                                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                    r2.a(r3, r0);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                                }

                                public final int m9602a() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r1 = this;
                                    r0 = 0;
                                    r1.a(r0, r0);
                                    r0 = r1.f8437d;
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.a():int");
                                }

                                @javax.annotation.Nullable
                                public final java.lang.String m9606b() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r2 = this;
                                    r0 = r2.f8438e;
                                    r1 = 1;
                                    r0 = super.a(r0, r1);
                                    r2.f8438e = r0;
                                    r0 = r2.f8438e;
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.b():java.lang.String");
                                }

                                public final int m9607c() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r2 = this;
                                    r0 = 0;
                                    r1 = 2;
                                    r2.a(r0, r1);
                                    r0 = r2.f8439f;
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.c():int");
                                }

                                public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel m9601a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel r8) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    if (r8 != 0) goto L_0x0004;
                                L_0x0002:
                                    r8 = 0;
                                L_0x0003:
                                    return r8;
                                L_0x0004:
                                    r0 = r8 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel;
                                    if (r0 == 0) goto L_0x000b;
                                L_0x0008:
                                    r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel) r8;
                                    goto L_0x0003;
                                L_0x000b:
                                    r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel$Builder;
                                    r0.<init>();
                                    r1 = r8.m9602a();
                                    r0.f8434a = r1;
                                    r1 = r8.m9606b();
                                    r0.f8435b = r1;
                                    r1 = r8.m9607c();
                                    r0.f8436c = r1;
                                    r6 = 1;
                                    r4 = 0;
                                    r7 = 0;
                                    r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r2.<init>(r3);
                                    r3 = r0.f8435b;
                                    r3 = r2.b(r3);
                                    r5 = 3;
                                    r2.c(r5);
                                    r5 = r0.f8434a;
                                    r2.a(r7, r5, r7);
                                    r2.b(r6, r3);
                                    r3 = 2;
                                    r5 = r0.f8436c;
                                    r2.a(r3, r5, r7);
                                    r3 = r2.d();
                                    r2.d(r3);
                                    r2 = r2.e();
                                    r3 = java.nio.ByteBuffer.wrap(r2);
                                    r3.position(r7);
                                    r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r5 = r4;
                                    r7 = r4;
                                    r2.<init>(r3, r4, r5, r6, r7);
                                    r3 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel;
                                    r3.<init>(r2);
                                    r8 = r3;
                                    goto L_0x0003;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel");
                                }

                                public final int jK_() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r1 = this;
                                    r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.jK_():int");
                                }

                                public final com.facebook.graphql.visitor.GraphQLVisitableModel m9604a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.h();
                                    r0.i();
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                                }

                                public final int m9603a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r3 = this;
                                    r2 = 0;
                                    r3.h();
                                    r0 = r3.m9606b();
                                    r0 = r4.b(r0);
                                    r1 = 3;
                                    r4.c(r1);
                                    r1 = r3.f8437d;
                                    r4.a(r2, r1, r2);
                                    r1 = 1;
                                    r4.b(r1, r0);
                                    r0 = 2;
                                    r1 = r3.f8439f;
                                    r4.a(r0, r1, r2);
                                    r3.i();
                                    r0 = r4.d();
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                                }

                                public final void m9605a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r2 = this;
                                    r1 = 0;
                                    super.a(r3, r4, r5);
                                    r0 = r3.a(r4, r1, r1);
                                    r2.f8437d = r0;
                                    r0 = 2;
                                    r0 = r3.a(r4, r0, r1);
                                    r2.f8439f = r0;
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                                }
                            }

                            /* compiled from: module_role */
                            public class Serializer extends JsonSerializer<LinkMediaModel> {
                                public Serializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.Serializer.<init>():void");
                                }

                                public final void m9608a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r7 = this;
                                    r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m9612a(r0);
                                    r0.d(r1);
                                    r0 = r0.e();
                                    r1 = java.nio.ByteBuffer.wrap(r0);
                                    r0 = 0;
                                    r1.position(r0);
                                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r4 = 1;
                                    r3 = r2;
                                    r5 = r2;
                                    r0.<init>(r1, r2, r3, r4, r5);
                                    r6 = r0.a;
                                    r1 = r6;
                                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                    r8.a(r0, r1);
                                L_0x0035:
                                    r0 = r8.w_();
                                    r1 = r8.u_();
                                    com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.LinkMediaParser.m9781a(r0, r1, r9, r10);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.Serializer.<clinit>():void");
                                }
                            }

                            @javax.annotation.Nullable
                            public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel m9615b() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = r1.m9610k();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.b():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel");
                            }

                            @javax.annotation.Nullable
                            public final /* synthetic */ com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel mo566c() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = r1.m9611l();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.c():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$LinkMediaModel$PulseCoverPhotoModel");
                            }

                            @javax.annotation.Nullable
                            public final /* synthetic */ com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields mo567j() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = r1.m9610k();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.j():com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageFields");
                            }

                            public LinkMediaModel() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 3;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.<init>():void");
                            }

                            public LinkMediaModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 3;
                                r2.<init>(r0);
                                r1 = r3.a;
                                r0 = r1;
                                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r2.a(r3, r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                            }

                            @javax.annotation.Nullable
                            public final com.facebook.graphql.enums.GraphQLObjectType mo565a() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r4 = this;
                                r0 = r4.b;
                                if (r0 == 0) goto L_0x0017;
                            L_0x0004:
                                r0 = r4.f8440d;
                                if (r0 != 0) goto L_0x0017;
                            L_0x0008:
                                r0 = r4.b;
                                r1 = r4.c;
                                r2 = 0;
                                r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                                r0 = r0.d(r1, r2, r3);
                                r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                                r4.f8440d = r0;
                            L_0x0017:
                                r0 = r4.f8440d;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.a():com.facebook.graphql.enums.GraphQLObjectType");
                            }

                            @javax.annotation.Nullable
                            private com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel m9610k() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r0 = r3.f8441e;
                                r1 = 1;
                                r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.class;
                                r0 = super.a(r0, r1, r2);
                                r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel) r0;
                                r3.f8441e = r0;
                                r0 = r3.f8441e;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.k():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$ImageModel");
                            }

                            @javax.annotation.Nullable
                            private com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel m9611l() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r0 = r3.f8442f;
                                r1 = 2;
                                r2 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel.class;
                                r0 = super.a(r0, r1, r2);
                                r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel) r0;
                                r3.f8442f = r0;
                                r0 = r3.f8442f;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.l():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$LinkMediaModel$PulseCoverPhotoModel");
                            }

                            public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel m9609a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel r10) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                if (r10 != 0) goto L_0x0004;
                            L_0x0002:
                                r10 = 0;
                            L_0x0003:
                                return r10;
                            L_0x0004:
                                r0 = r10 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel;
                                if (r0 == 0) goto L_0x000b;
                            L_0x0008:
                                r10 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel) r10;
                                goto L_0x0003;
                            L_0x000b:
                                r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel$Builder;
                                r0.<init>();
                                r1 = r10.mo565a();
                                r0.f8431a = r1;
                                r1 = r10.m9615b();
                                r1 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel.m9601a(r1);
                                r0.f8432b = r1;
                                r1 = r10.mo566c();
                                r1 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel.m10446a(r1);
                                r0.f8433c = r1;
                                r6 = 1;
                                r9 = 0;
                                r4 = 0;
                                r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r2.<init>(r3);
                                r3 = r0.f8431a;
                                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                                r5 = r0.f8432b;
                                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r5);
                                r7 = r0.f8433c;
                                r7 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r7);
                                r8 = 3;
                                r2.c(r8);
                                r2.b(r9, r3);
                                r2.b(r6, r5);
                                r3 = 2;
                                r2.b(r3, r7);
                                r3 = r2.d();
                                r2.d(r3);
                                r2 = r2.e();
                                r3 = java.nio.ByteBuffer.wrap(r2);
                                r3.position(r9);
                                r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r5 = r4;
                                r7 = r4;
                                r2.<init>(r3, r4, r5, r6, r7);
                                r3 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel;
                                r3.<init>(r2);
                                r10 = r3;
                                goto L_0x0003;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel");
                            }

                            public final int jK_() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 74219460; // 0x46c7fc4 float:2.7800334E-36 double:3.66692854E-316;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m9614a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r1 = 0;
                                r3.h();
                                r0 = r3.m9610k();
                                if (r0 == 0) goto L_0x0022;
                            L_0x000a:
                                r0 = r3.m9610k();
                                r0 = r4.b(r0);
                                r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.ImageModel) r0;
                                r2 = r3.m9610k();
                                if (r2 == r0) goto L_0x0022;
                            L_0x001a:
                                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                                r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel) r1;
                                r1.f8441e = r0;
                            L_0x0022:
                                r0 = r3.m9611l();
                                if (r0 == 0) goto L_0x0040;
                            L_0x0028:
                                r0 = r3.m9611l();
                                r0 = r4.b(r0);
                                r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel) r0;
                                r2 = r3.m9611l();
                                if (r2 == r0) goto L_0x0040;
                            L_0x0038:
                                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                                r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel) r1;
                                r1.f8442f = r0;
                            L_0x0040:
                                r3.i();
                                if (r1 != 0) goto L_0x0046;
                            L_0x0045:
                                return r3;
                            L_0x0046:
                                r3 = r1;
                                goto L_0x0045;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m9612a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r4 = this;
                                r4.h();
                                r0 = r4.mo565a();
                                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                                r1 = r4.m9610k();
                                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                                r2 = r4.m9611l();
                                r2 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r2);
                                r3 = 3;
                                r5.c(r3);
                                r3 = 0;
                                r5.b(r3, r0);
                                r0 = 1;
                                r5.b(r0, r1);
                                r0 = 2;
                                r5.b(r0, r2);
                                r4.i();
                                r0 = r5.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }
                        }

                        /* compiled from: module_role */
                        public class Serializer extends JsonSerializer<EdgesNodeModel> {
                            public Serializer() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = this;
                                r0.<init>();
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Serializer.<init>():void");
                            }

                            public final void m9618a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r7 = this;
                                r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m9668a(r0);
                                r0.d(r1);
                                r0 = r0.e();
                                r1 = java.nio.ByteBuffer.wrap(r0);
                                r0 = 0;
                                r1.position(r0);
                                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r4 = 1;
                                r3 = r2;
                                r5 = r2;
                                r0.<init>(r1, r2, r3, r4, r5);
                                r6 = r0.a;
                                r1 = r6;
                                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                r8.a(r0, r1);
                            L_0x0035:
                                r0 = r8.w_();
                                r1 = r8.u_();
                                com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.m9789a(r0, r1, r9, r10);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                            }

                            static {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.class;
                                r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Serializer.<clinit>():void");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1233606746)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: module_role */
                        public final class SourceModel extends BaseModel implements DefaultTextWithEntitiesLongFields, GraphQLVisitableModel {
                            @Nullable
                            private List<RangesModel> f8445d;
                            @Nullable
                            private String f8446e;

                            /* compiled from: module_role */
                            public final class Builder {
                                @Nullable
                                public ImmutableList<RangesModel> f8443a;
                                @Nullable
                                public String f8444b;

                                public Builder() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.Builder.<init>():void");
                                }
                            }

                            /* compiled from: module_role */
                            public class Deserializer extends FbJsonDeserializer {
                                public Deserializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.Deserializer.<init>():void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m9619a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r10 = this;
                                    r8 = 1;
                                    r6 = 0;
                                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r4.<init>(r5);
                                    r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.SourceParser.m9782a(r11, r4);
                                    r4.d(r5);
                                    r4 = r4.e();
                                    r5 = java.nio.ByteBuffer.wrap(r4);
                                    r4 = 0;
                                    r5.position(r4);
                                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r7 = r6;
                                    r9 = r6;
                                    r4.<init>(r5, r6, r7, r8, r9);
                                    r5 = 4;
                                    r6 = java.lang.Boolean.valueOf(r8);
                                    r4.a(r5, r6);
                                    r2 = r4;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel;
                                    r1.<init>();
                                    r4 = r2.a;
                                    r0 = r4;
                                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                    r0 = r1;
                                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                    r0.a(r2, r3, r11);
                                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                    if (r0 == 0) goto L_0x0048;
                                L_0x0042:
                                    r1 = (com.facebook.common.json.Postprocessable) r1;
                                    r1 = r1.a();
                                L_0x0048:
                                    return r1;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            /* compiled from: module_role */
                            public class Serializer extends JsonSerializer<SourceModel> {
                                public Serializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.Serializer.<init>():void");
                                }

                                public final void m9620a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r7 = this;
                                    r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m9622a(r0);
                                    r0.d(r1);
                                    r0 = r0.e();
                                    r1 = java.nio.ByteBuffer.wrap(r0);
                                    r0 = 0;
                                    r1.position(r0);
                                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r4 = 1;
                                    r3 = r2;
                                    r5 = r2;
                                    r0.<init>(r1, r2, r3, r4, r5);
                                    r6 = r0.a;
                                    r1 = r6;
                                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                    r8.a(r0, r1);
                                L_0x0035:
                                    r0 = r8.w_();
                                    r1 = r8.u_();
                                    com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.SourceParser.m9783a(r0, r1, r9, r10);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.Serializer.<clinit>():void");
                                }
                            }

                            public SourceModel() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 2;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.<init>():void");
                            }

                            public SourceModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 2;
                                r2.<init>(r0);
                                r1 = r3.a;
                                r0 = r1;
                                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r2.a(r3, r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                            }

                            @javax.annotation.Nonnull
                            public final com.google.common.collect.ImmutableList<com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel> m9625b() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r0 = r3.f8445d;
                                r1 = 0;
                                r2 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel.class;
                                r0 = super.a(r0, r1, r2);
                                r3.f8445d = r0;
                                r0 = r3.f8445d;
                                r0 = (com.google.common.collect.ImmutableList) r0;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.b():com.google.common.collect.ImmutableList<com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels$DefaultTextWithEntitiesLongFieldsModel$RangesModel>");
                            }

                            @javax.annotation.Nullable
                            public final java.lang.String m9624a() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = r2.f8446e;
                                r1 = 1;
                                r0 = super.a(r0, r1);
                                r2.f8446e = r0;
                                r0 = r2.f8446e;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.a():java.lang.String");
                            }

                            public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel m9621a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel r11) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                if (r11 != 0) goto L_0x0004;
                            L_0x0002:
                                r11 = 0;
                            L_0x0003:
                                return r11;
                            L_0x0004:
                                r0 = r11 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel;
                                if (r0 == 0) goto L_0x000b;
                            L_0x0008:
                                r11 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel) r11;
                                goto L_0x0003;
                            L_0x000b:
                                r2 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel$Builder;
                                r2.<init>();
                                r3 = com.google.common.collect.ImmutableList.builder();
                                r0 = 0;
                                r1 = r0;
                            L_0x0016:
                                r0 = r11.m9625b();
                                r0 = r0.size();
                                if (r1 >= r0) goto L_0x0035;
                            L_0x0020:
                                r0 = r11.m9625b();
                                r0 = r0.get(r1);
                                r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges) r0;
                                r0 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel.a(r0);
                                r3.c(r0);
                                r0 = r1 + 1;
                                r1 = r0;
                                goto L_0x0016;
                            L_0x0035:
                                r0 = r3.b();
                                r2.f8443a = r0;
                                r0 = r11.m9624a();
                                r2.f8444b = r0;
                                r8 = 1;
                                r10 = 0;
                                r6 = 0;
                                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r4.<init>(r5);
                                r5 = r2.f8443a;
                                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r5);
                                r7 = r2.f8444b;
                                r7 = r4.b(r7);
                                r9 = 2;
                                r4.c(r9);
                                r4.b(r10, r5);
                                r4.b(r8, r7);
                                r5 = r4.d();
                                r4.d(r5);
                                r4 = r4.e();
                                r5 = java.nio.ByteBuffer.wrap(r4);
                                r5.position(r10);
                                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r7 = r6;
                                r9 = r6;
                                r4.<init>(r5, r6, r7, r8, r9);
                                r5 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel;
                                r5.<init>(r4);
                                r11 = r5;
                                goto L_0x0003;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel");
                            }

                            public final int jK_() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m9623a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 0;
                                r2.h();
                                r1 = r2.m9625b();
                                if (r1 == 0) goto L_0x0020;
                            L_0x000a:
                                r1 = r2.m9625b();
                                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                                if (r1 == 0) goto L_0x0020;
                            L_0x0014:
                                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                                r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel) r0;
                                r1 = r1.b();
                                r0.f8445d = r1;
                            L_0x0020:
                                r2.i();
                                if (r0 != 0) goto L_0x0026;
                            L_0x0025:
                                return r2;
                            L_0x0026:
                                r2 = r0;
                                goto L_0x0025;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m9622a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r3.h();
                                r0 = r3.m9625b();
                                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                                r1 = r3.m9624a();
                                r1 = r4.b(r1);
                                r2 = 2;
                                r4.c(r2);
                                r2 = 0;
                                r4.b(r2, r0);
                                r0 = 1;
                                r4.b(r0, r1);
                                r3.i();
                                r0 = r4.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1233606746)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: module_role */
                        public final class TitleModel extends BaseModel implements DefaultTextWithEntitiesLongFields, GraphQLVisitableModel, Title {
                            @Nullable
                            private List<RangesModel> f8449d;
                            @Nullable
                            private String f8450e;

                            /* compiled from: module_role */
                            public final class Builder {
                                @Nullable
                                public ImmutableList<RangesModel> f8447a;
                                @Nullable
                                public String f8448b;

                                public Builder() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.Builder.<init>():void");
                                }
                            }

                            /* compiled from: module_role */
                            public class Deserializer extends FbJsonDeserializer {
                                public Deserializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.Deserializer.<init>():void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m9626a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r10 = this;
                                    r8 = 1;
                                    r6 = 0;
                                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r4.<init>(r5);
                                    r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.TitleParser.m9784a(r11, r4);
                                    r4.d(r5);
                                    r4 = r4.e();
                                    r5 = java.nio.ByteBuffer.wrap(r4);
                                    r4 = 0;
                                    r5.position(r4);
                                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r7 = r6;
                                    r9 = r6;
                                    r4.<init>(r5, r6, r7, r8, r9);
                                    r5 = 4;
                                    r6 = java.lang.Boolean.valueOf(r8);
                                    r4.a(r5, r6);
                                    r2 = r4;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel;
                                    r1.<init>();
                                    r4 = r2.a;
                                    r0 = r4;
                                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                    r0 = r1;
                                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                    r0.a(r2, r3, r11);
                                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                    if (r0 == 0) goto L_0x0048;
                                L_0x0042:
                                    r1 = (com.facebook.common.json.Postprocessable) r1;
                                    r1 = r1.a();
                                L_0x0048:
                                    return r1;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            /* compiled from: module_role */
                            public class Serializer extends JsonSerializer<TitleModel> {
                                public Serializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.Serializer.<init>():void");
                                }

                                public final void m9627a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r7 = this;
                                    r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m9629a(r0);
                                    r0.d(r1);
                                    r0 = r0.e();
                                    r1 = java.nio.ByteBuffer.wrap(r0);
                                    r0 = 0;
                                    r1.position(r0);
                                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r4 = 1;
                                    r3 = r2;
                                    r5 = r2;
                                    r0.<init>(r1, r2, r3, r4, r5);
                                    r6 = r0.a;
                                    r1 = r6;
                                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                    r8.a(r0, r1);
                                L_0x0035:
                                    r0 = r8.w_();
                                    r1 = r8.u_();
                                    com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.TitleParser.m9785a(r0, r1, r9, r10);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.Serializer.<clinit>():void");
                                }
                            }

                            public TitleModel() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 2;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.<init>():void");
                            }

                            public TitleModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 2;
                                r2.<init>(r0);
                                r1 = r3.a;
                                r0 = r1;
                                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r2.a(r3, r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                            }

                            @javax.annotation.Nonnull
                            public final com.google.common.collect.ImmutableList<com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel> m9632b() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r0 = r3.f8449d;
                                r1 = 0;
                                r2 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel.class;
                                r0 = super.a(r0, r1, r2);
                                r3.f8449d = r0;
                                r0 = r3.f8449d;
                                r0 = (com.google.common.collect.ImmutableList) r0;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.b():com.google.common.collect.ImmutableList<com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels$DefaultTextWithEntitiesLongFieldsModel$RangesModel>");
                            }

                            @javax.annotation.Nullable
                            public final java.lang.String mo568a() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = r2.f8450e;
                                r1 = 1;
                                r0 = super.a(r0, r1);
                                r2.f8450e = r0;
                                r0 = r2.f8450e;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.a():java.lang.String");
                            }

                            public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel m9628a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel r11) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                if (r11 != 0) goto L_0x0004;
                            L_0x0002:
                                r11 = 0;
                            L_0x0003:
                                return r11;
                            L_0x0004:
                                r0 = r11 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel;
                                if (r0 == 0) goto L_0x000b;
                            L_0x0008:
                                r11 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel) r11;
                                goto L_0x0003;
                            L_0x000b:
                                r2 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel$Builder;
                                r2.<init>();
                                r3 = com.google.common.collect.ImmutableList.builder();
                                r0 = 0;
                                r1 = r0;
                            L_0x0016:
                                r0 = r11.m9632b();
                                r0 = r0.size();
                                if (r1 >= r0) goto L_0x0035;
                            L_0x0020:
                                r0 = r11.m9632b();
                                r0 = r0.get(r1);
                                r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges) r0;
                                r0 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel.a(r0);
                                r3.c(r0);
                                r0 = r1 + 1;
                                r1 = r0;
                                goto L_0x0016;
                            L_0x0035:
                                r0 = r3.b();
                                r2.f8447a = r0;
                                r0 = r11.mo568a();
                                r2.f8448b = r0;
                                r8 = 1;
                                r10 = 0;
                                r6 = 0;
                                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r4.<init>(r5);
                                r5 = r2.f8447a;
                                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r5);
                                r7 = r2.f8448b;
                                r7 = r4.b(r7);
                                r9 = 2;
                                r4.c(r9);
                                r4.b(r10, r5);
                                r4.b(r8, r7);
                                r5 = r4.d();
                                r4.d(r5);
                                r4 = r4.e();
                                r5 = java.nio.ByteBuffer.wrap(r4);
                                r5.position(r10);
                                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r7 = r6;
                                r9 = r6;
                                r4.<init>(r5, r6, r7, r8, r9);
                                r5 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel;
                                r5.<init>(r4);
                                r11 = r5;
                                goto L_0x0003;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel");
                            }

                            public final int jK_() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m9630a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 0;
                                r2.h();
                                r1 = r2.m9632b();
                                if (r1 == 0) goto L_0x0020;
                            L_0x000a:
                                r1 = r2.m9632b();
                                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                                if (r1 == 0) goto L_0x0020;
                            L_0x0014:
                                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                                r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel) r0;
                                r1 = r1.b();
                                r0.f8449d = r1;
                            L_0x0020:
                                r2.i();
                                if (r0 != 0) goto L_0x0026;
                            L_0x0025:
                                return r2;
                            L_0x0026:
                                r2 = r0;
                                goto L_0x0025;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m9629a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r3.h();
                                r0 = r3.m9632b();
                                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                                r1 = r3.mo568a();
                                r1 = r4.b(r1);
                                r2 = 2;
                                r4.c(r2);
                                r2 = 0;
                                r4.b(r2, r0);
                                r0 = 1;
                                r4.b(r0, r1);
                                r3.i();
                                r0 = r4.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1861438057)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: module_role */
                        public final class VideoShareModel extends BaseModel implements GraphQLVisitableModel, VideoShare {
                            @Nullable
                            private String f8453d;
                            private int f8454e;

                            /* compiled from: module_role */
                            public final class Builder {
                                @Nullable
                                public String f8451a;
                                public int f8452b;

                                public Builder() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.Builder.<init>():void");
                                }
                            }

                            /* compiled from: module_role */
                            public class Deserializer extends FbJsonDeserializer {
                                public Deserializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.Deserializer.<init>():void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m9633a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r10 = this;
                                    r8 = 1;
                                    r6 = 0;
                                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r4.<init>(r5);
                                    r5 = com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.VideoShareParser.m9786a(r11, r4);
                                    r4.d(r5);
                                    r4 = r4.e();
                                    r5 = java.nio.ByteBuffer.wrap(r4);
                                    r4 = 0;
                                    r5.position(r4);
                                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r7 = r6;
                                    r9 = r6;
                                    r4.<init>(r5, r6, r7, r8, r9);
                                    r5 = 4;
                                    r6 = java.lang.Boolean.valueOf(r8);
                                    r4.a(r5, r6);
                                    r2 = r4;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel;
                                    r1.<init>();
                                    r4 = r2.a;
                                    r0 = r4;
                                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                    r0 = r1;
                                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                    r0.a(r2, r3, r11);
                                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                    if (r0 == 0) goto L_0x0048;
                                L_0x0042:
                                    r1 = (com.facebook.common.json.Postprocessable) r1;
                                    r1 = r1.a();
                                L_0x0048:
                                    return r1;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            /* compiled from: module_role */
                            public class Serializer extends JsonSerializer<VideoShareModel> {
                                public Serializer() {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = this;
                                    r0.<init>();
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.Serializer.<init>():void");
                                }

                                public final void m9634a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r7 = this;
                                    r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m9636a(r0);
                                    r0.d(r1);
                                    r0 = r0.e();
                                    r1 = java.nio.ByteBuffer.wrap(r0);
                                    r0 = 0;
                                    r1.position(r0);
                                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r4 = 1;
                                    r3 = r2;
                                    r5 = r2;
                                    r0.<init>(r1, r2, r3, r4, r5);
                                    r6 = r0.a;
                                    r1 = r6;
                                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                    r8.a(r0, r1);
                                L_0x0035:
                                    r0 = r8.w_();
                                    r1 = r8.u_();
                                    com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.EdgesNodeParser.VideoShareParser.m9787a(r0, r1, r9);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                                }

                                static {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                    /*
                                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.class;
                                    r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.Serializer.<clinit>():void");
                                }
                            }

                            public VideoShareModel() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 2;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.<init>():void");
                            }

                            public VideoShareModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 2;
                                r2.<init>(r0);
                                r1 = r3.a;
                                r0 = r1;
                                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r2.a(r3, r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                            }

                            @javax.annotation.Nullable
                            public final java.lang.String mo569a() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = r2.f8453d;
                                r1 = 0;
                                r0 = super.a(r0, r1);
                                r2.f8453d = r0;
                                r0 = r2.f8453d;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.a():java.lang.String");
                            }

                            public final int mo570b() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                r0 = 0;
                                r1 = 1;
                                r2.a(r0, r1);
                                r0 = r2.f8454e;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.b():int");
                            }

                            public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel m9635a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel r8) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                if (r8 != 0) goto L_0x0004;
                            L_0x0002:
                                r8 = 0;
                            L_0x0003:
                                return r8;
                            L_0x0004:
                                r0 = r8 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel;
                                if (r0 == 0) goto L_0x000b;
                            L_0x0008:
                                r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel) r8;
                                goto L_0x0003;
                            L_0x000b:
                                r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel$Builder;
                                r0.<init>();
                                r1 = r8.mo569a();
                                r0.f8451a = r1;
                                r1 = r8.mo570b();
                                r0.f8452b = r1;
                                r6 = 1;
                                r4 = 0;
                                r7 = 0;
                                r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r2.<init>(r3);
                                r3 = r0.f8451a;
                                r3 = r2.b(r3);
                                r5 = 2;
                                r2.c(r5);
                                r2.b(r7, r3);
                                r3 = r0.f8452b;
                                r2.a(r6, r3, r7);
                                r3 = r2.d();
                                r2.d(r3);
                                r2 = r2.e();
                                r3 = java.nio.ByteBuffer.wrap(r2);
                                r3.position(r7);
                                r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r5 = r4;
                                r7 = r4;
                                r2.<init>(r3, r4, r5, r6, r7);
                                r3 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel;
                                r3.<init>(r2);
                                r8 = r3;
                                goto L_0x0003;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel");
                            }

                            public final int jK_() {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r1 = this;
                                r0 = 364166212; // 0x15b4bc44 float:7.299845E-26 double:1.799220147E-315;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m9637a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = this;
                                r0.h();
                                r0.i();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m9636a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r3 = this;
                                r2 = 0;
                                r3.h();
                                r0 = r3.mo569a();
                                r0 = r4.b(r0);
                                r1 = 2;
                                r4.c(r1);
                                r4.b(r2, r0);
                                r0 = 1;
                                r1 = r3.f8454e;
                                r4.a(r0, r1, r2);
                                r3.i();
                                r0 = r4.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }

                            public final void m9639a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r2 = this;
                                super.a(r3, r4, r5);
                                r0 = 1;
                                r1 = 0;
                                r0 = r3.a(r4, r0, r1);
                                r2.f8454e = r0;
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                            }
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel mo574E() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.an();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.E():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$OpenGraphNodeModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields mo575F() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ai();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.F():com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageFields");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels.PulsePhrasesAnalysisExternalUrlModel.PhrasesAnalysisModel m9648G() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ap();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.G():com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels$PulsePhrasesAnalysisExternalUrlModel$PhrasesAnalysisModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels.PulseQuotesAnalysisExternalUrlModel.QuotesAnalysisModel m9652K() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.aq();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.K():com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels$PulseQuotesAnalysisExternalUrlModel$QuotesAnalysisModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel m9653L() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ar();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.L():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.LinkMedia mo577N() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ak();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.N():com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces$SearchResultsWebVideo$LinkMedia");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields mo578R() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.am();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.R():com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces$DefaultTextWithEntitiesLongFields");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel mo579T() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.as();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.T():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$SummaryModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel m9663V() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.au();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.V():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel m9665X() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.aw();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.X():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel mo580Y() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ao();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Y():com.facebook.search.results.protocol.video.SearchResultsVideoModels$SearchResultsVideoModel$OwnerModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields al() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ar();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.al():com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces$DefaultTextWithEntitiesLongFields");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields at() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.au();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.at():com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces$DefaultTextWithEntitiesLongFields");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.VideoShare av() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.aw();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.av():com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces$SearchResultsWebVideo$VideoShare");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl.Title ax() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.au();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ax():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces$SearchResultsArticleExternalUrl$Title");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl.LinkMedia ay() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ak();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ay():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces$SearchResultsArticleExternalUrl$LinkMedia");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel m9675c() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.aa();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.c():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.AllShareStories mo588d() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.aa();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.d():com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces$SearchResultsWebVideo$AllShareStories");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel jj_() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.af();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.jj_():com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels$SphericalMetadataModel$GuidedTourModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels.PulseEmotionAnalysisExternalUrlModel.EmotionalAnalysisModel jk_() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ac();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.jk_():com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels$PulseEmotionAnalysisExternalUrlModel$EmotionalAnalysisModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels.SearchResultsWikiModulePageModel.BestDescriptionModel jl_() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ab();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.jl_():com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels$SearchResultsWikiModulePageModel$BestDescriptionModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields m9680l() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ag();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.l():com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageFields");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields m9681m() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ah();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.m():com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageFields");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.InstantArticleModel m9688t() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.aj();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.t():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$InstantArticleModel");
                        }

                        @javax.annotation.Nullable
                        public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel m9693y() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.ak();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.y():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel");
                        }

                        public EdgesNodeModel() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = 50;
                            r1.<init>(r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.<init>():void");
                        }

                        public EdgesNodeModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 50;
                            r2.<init>(r0);
                            r1 = r3.a;
                            r0 = r1;
                            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r2.a(r3, r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                        }

                        public final void m9672a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            r2.a();
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                        }

                        public final void m9673a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.a(java.lang.String, java.lang.Object, boolean):void");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.graphql.enums.GraphQLObjectType m9674b() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r4 = this;
                            r0 = r4.b;
                            if (r0 == 0) goto L_0x0017;
                        L_0x0004:
                            r0 = r4.f8481d;
                            if (r0 != 0) goto L_0x0017;
                        L_0x0008:
                            r0 = r4.b;
                            r1 = r4.c;
                            r2 = 0;
                            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                            r0 = r0.d(r1, r2, r3);
                            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                            r4.f8481d = r0;
                        L_0x0017:
                            r0 = r4.f8481d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.b():com.facebook.graphql.enums.GraphQLObjectType");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel aa() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8482e;
                            r1 = 1;
                            r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel) r0;
                            r3.f8482e = r0;
                            r0 = r3.f8482e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.aa():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$AllShareStoriesModel");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels.SearchResultsWikiModulePageModel.BestDescriptionModel ab() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8483f;
                            r1 = 2;
                            r2 = com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels.SearchResultsWikiModulePageModel.BestDescriptionModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels.SearchResultsWikiModulePageModel.BestDescriptionModel) r0;
                            r3.f8483f = r0;
                            r0 = r3.f8483f;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ab():com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels$SearchResultsWikiModulePageModel$BestDescriptionModel");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.graphql.enums.GraphQLVideoBroadcastStatus m9677g() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r4 = this;
                            r0 = r4.f8484g;
                            r1 = 3;
                            r2 = com.facebook.graphql.enums.GraphQLVideoBroadcastStatus.class;
                            r3 = com.facebook.graphql.enums.GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                            r0 = super.b(r0, r1, r2, r3);
                            r0 = (com.facebook.graphql.enums.GraphQLVideoBroadcastStatus) r0;
                            r4.f8484g = r0;
                            r0 = r4.f8484g;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.g():com.facebook.graphql.enums.GraphQLVideoBroadcastStatus");
                        }

                        public final long mo590o() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 0;
                            r1 = 4;
                            r2.a(r0, r1);
                            r0 = r2.f8485h;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.o():long");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.graphql.model.GraphQLStory mo591p() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8486i;
                            r1 = 5;
                            r2 = com.facebook.graphql.model.GraphQLStory.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.graphql.model.GraphQLStory) r0;
                            r3.f8486i = r0;
                            r0 = r3.f8486i;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.p():com.facebook.graphql.model.GraphQLStory");
                        }

                        public final long mo592q() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 0;
                            r1 = 6;
                            r2.a(r0, r1);
                            r0 = r2.f8487j;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.q():long");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels.PulseEmotionAnalysisExternalUrlModel.EmotionalAnalysisModel ac() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8488k;
                            r1 = 7;
                            r2 = com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels.PulseEmotionAnalysisExternalUrlModel.EmotionalAnalysisModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels.PulseEmotionAnalysisExternalUrlModel.EmotionalAnalysisModel) r0;
                            r3.f8488k = r0;
                            r0 = r3.f8488k;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ac():com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels$PulseEmotionAnalysisExternalUrlModel$EmotionalAnalysisModel");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String mo593v() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8489l;
                            r1 = 8;
                            r0 = super.a(r0, r1);
                            r2.f8489l = r0;
                            r0 = r2.f8489l;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.v():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel af() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8490m;
                            r1 = 9;
                            r2 = com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel) r0;
                            r3.f8490m = r0;
                            r0 = r3.f8490m;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.af():com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels$SphericalMetadataModel$GuidedTourModel");
                        }

                        public final boolean m9678j() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 1;
                            r1 = 2;
                            r2.a(r0, r1);
                            r0 = r2.f8491n;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.j():boolean");
                        }

                        public final boolean mo571A() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 1;
                            r1 = 3;
                            r2.a(r0, r1);
                            r0 = r2.f8492o;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.A():boolean");
                        }

                        public final int m9679k() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 1;
                            r1 = 4;
                            r2.a(r0, r1);
                            r0 = r2.f8493p;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.k():int");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String mo572C() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8494q;
                            r1 = 13;
                            r0 = super.a(r0, r1);
                            r2.f8494q = r0;
                            r0 = r2.f8494q;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.C():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel ag() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8495r;
                            r1 = 14;
                            r2 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                            r3.f8495r = r0;
                            r0 = r3.f8495r;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ag():com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel ah() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8496s;
                            r1 = 15;
                            r2 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                            r3.f8496s = r0;
                            r0 = r3.f8496s;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ah():com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel ai() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8497t;
                            r1 = 16;
                            r2 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                            r3.f8497t = r0;
                            r0 = r3.f8497t;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ai():com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel");
                        }

                        public final int m9682n() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 2;
                            r1 = 1;
                            r2.a(r0, r1);
                            r0 = r2.f8498u;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.n():int");
                        }

                        public final int m9686r() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = 2;
                            r1.a(r0, r0);
                            r0 = r1.f8499v;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.r():int");
                        }

                        public final int m9687s() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 2;
                            r1 = 3;
                            r2.a(r0, r1);
                            r0 = r2.f8500w;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.s():int");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.InstantArticleModel aj() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8501x;
                            r1 = 20;
                            r2 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.InstantArticleModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.InstantArticleModel) r0;
                            r3.f8501x = r0;
                            r0 = r3.f8501x;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.aj():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$InstantArticleModel");
                        }

                        public final boolean mo576J() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 2;
                            r1 = 5;
                            r2.a(r0, r1);
                            r0 = r2.f8502y;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.J():boolean");
                        }

                        public final boolean m9689u() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 2;
                            r1 = 6;
                            r2.a(r0, r1);
                            r0 = r2.f8503z;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.u():boolean");
                        }

                        public final boolean m9691w() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 2;
                            r1 = 7;
                            r2.a(r0, r1);
                            r0 = r2.f8455A;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.w():boolean");
                        }

                        public final boolean m9692x() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 3;
                            r1 = 0;
                            r2.a(r0, r1);
                            r0 = r2.f8456B;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.x():boolean");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel ak() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8457C;
                            r1 = 25;
                            r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel) r0;
                            r3.f8457C = r0;
                            r0 = r3.f8457C;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ak():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$LinkMediaModel");
                        }

                        public final int m9694z() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 3;
                            r1 = 2;
                            r2.a(r0, r1);
                            r0 = r2.f8458D;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.z():int");
                        }

                        public final int m9643B() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = 3;
                            r1.a(r0, r0);
                            r0 = r1.f8459E;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.B():int");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel am() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8460F;
                            r1 = 28;
                            r2 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel) r0;
                            r3.f8460F = r0;
                            r0 = r3.f8460F;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.am():com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels$DefaultTextWithEntitiesLongFieldsModel");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String mo573D() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8461G;
                            r1 = 29;
                            r0 = super.a(r0, r1);
                            r2.f8461G = r0;
                            r0 = r2.f8461G;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.D():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel an() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8462H;
                            r1 = 30;
                            r2 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel) r0;
                            r3.f8462H = r0;
                            r0 = r3.f8462H;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.an():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$OpenGraphNodeModel");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel ao() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8463I;
                            r1 = 31;
                            r2 = com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel) r0;
                            r3.f8463I = r0;
                            r0 = r3.f8463I;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ao():com.facebook.search.results.protocol.video.SearchResultsVideoModels$SearchResultsVideoModel$OwnerModel");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels.PulsePhrasesAnalysisExternalUrlModel.PhrasesAnalysisModel ap() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8464J;
                            r1 = 32;
                            r2 = com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels.PulsePhrasesAnalysisExternalUrlModel.PhrasesAnalysisModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels.PulsePhrasesAnalysisExternalUrlModel.PhrasesAnalysisModel) r0;
                            r3.f8464J = r0;
                            r0 = r3.f8464J;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ap():com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels$PulsePhrasesAnalysisExternalUrlModel$PhrasesAnalysisModel");
                        }

                        public final int ad() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 4;
                            r1 = 1;
                            r2.a(r0, r1);
                            r0 = r2.f8465K;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ad():int");
                        }

                        public final int ae() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 4;
                            r1 = 2;
                            r2.a(r0, r1);
                            r0 = r2.f8466L;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ae():int");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m9649H() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8467M;
                            r1 = 35;
                            r0 = super.a(r0, r1);
                            r2.f8467M = r0;
                            r0 = r2.f8467M;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.H():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m9650I() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8468N;
                            r1 = 36;
                            r0 = super.a(r0, r1);
                            r2.f8468N = r0;
                            r0 = r2.f8468N;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.I():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels.PulseQuotesAnalysisExternalUrlModel.QuotesAnalysisModel aq() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8469O;
                            r1 = 37;
                            r2 = com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels.PulseQuotesAnalysisExternalUrlModel.QuotesAnalysisModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels.PulseQuotesAnalysisExternalUrlModel.QuotesAnalysisModel) r0;
                            r3.f8469O = r0;
                            r0 = r3.f8469O;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.aq():com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels$PulseQuotesAnalysisExternalUrlModel$QuotesAnalysisModel");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel ar() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8470P;
                            r1 = 38;
                            r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel) r0;
                            r3.f8470P = r0;
                            r0 = r3.f8470P;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.ar():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$SourceModel");
                        }

                        public final double m9654M() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 4;
                            r1 = 7;
                            r2.a(r0, r1);
                            r0 = r2.f8471Q;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.M():double");
                        }

                        public final double m9656O() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 5;
                            r1 = 0;
                            r2.a(r0, r1);
                            r0 = r2.f8472R;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.O():double");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m9657P() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8473S;
                            r1 = 41;
                            r0 = super.a(r0, r1);
                            r2.f8473S = r0;
                            r0 = r2.f8473S;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.P():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m9658Q() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8474T;
                            r1 = 42;
                            r0 = super.a(r0, r1);
                            r2.f8474T = r0;
                            r0 = r2.f8474T;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Q():java.lang.String");
                        }

                        public final int m9660S() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 5;
                            r1 = 3;
                            r2.a(r0, r1);
                            r0 = r2.f8475U;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.S():int");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel as() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8476V;
                            r1 = 44;
                            r2 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel) r0;
                            r3.f8476V = r0;
                            r0 = r3.f8476V;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.as():com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels$SearchResultsArticleExternalUrlModel$SummaryModel");
                        }

                        public final boolean m9662U() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = 5;
                            r1.a(r0, r0);
                            r0 = r1.f8477W;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.U():boolean");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel au() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8478X;
                            r1 = 46;
                            r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel) r0;
                            r3.f8478X = r0;
                            r0 = r3.f8478X;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.au():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$TitleModel");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m9664W() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f8479Y;
                            r1 = 47;
                            r0 = super.a(r0, r1);
                            r2.f8479Y = r0;
                            r0 = r2.f8479Y;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.W():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel aw() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r0 = r3.f8480Z;
                            r1 = 48;
                            r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel) r0;
                            r3.f8480Z = r0;
                            r0 = r3.f8480Z;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.aw():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$VideoShareModel");
                        }

                        public final int m9667Z() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = 6;
                            r1 = 1;
                            r2.a(r0, r1);
                            r0 = r2.aa;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.Z():int");
                        }

                        public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel m9641a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel r4) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            if (r4 != 0) goto L_0x0004;
                        L_0x0002:
                            r4 = 0;
                        L_0x0003:
                            return r4;
                        L_0x0004:
                            r0 = r4 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel;
                            if (r0 == 0) goto L_0x000b;
                        L_0x0008:
                            r4 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r4;
                            goto L_0x0003;
                        L_0x000b:
                            r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel$Builder;
                            r0.<init>();
                            r1 = r4.m9674b();
                            r0.f8405a = r1;
                            r1 = r4.m9675c();
                            r1 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel.m9590a(r1);
                            r0.f8406b = r1;
                            r1 = r4.jl_();
                            r1 = com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels.SearchResultsWikiModulePageModel.BestDescriptionModel.m10622a(r1);
                            r0.f8407c = r1;
                            r1 = r4.m9677g();
                            r0.f8408d = r1;
                            r2 = r4.mo590o();
                            r0.f8409e = r2;
                            r1 = r4.mo591p();
                            r0.f8410f = r1;
                            r2 = r4.mo592q();
                            r0.f8411g = r2;
                            r1 = r4.jk_();
                            r1 = com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels.PulseEmotionAnalysisExternalUrlModel.EmotionalAnalysisModel.m10264a(r1);
                            r0.f8412h = r1;
                            r1 = r4.mo593v();
                            r0.f8413i = r1;
                            r1 = r4.jj_();
                            r1 = com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel.a(r1);
                            r0.f8414j = r1;
                            r1 = r4.m9678j();
                            r0.f8415k = r1;
                            r1 = r4.mo571A();
                            r0.f8416l = r1;
                            r1 = r4.m9679k();
                            r0.f8417m = r1;
                            r1 = r4.mo572C();
                            r0.f8418n = r1;
                            r1 = r4.m9680l();
                            r1 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.a(r1);
                            r0.f8419o = r1;
                            r1 = r4.m9681m();
                            r1 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.a(r1);
                            r0.f8420p = r1;
                            r1 = r4.mo575F();
                            r1 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.a(r1);
                            r0.f8421q = r1;
                            r1 = r4.m9682n();
                            r0.f8422r = r1;
                            r1 = r4.m9686r();
                            r0.f8423s = r1;
                            r1 = r4.m9687s();
                            r0.f8424t = r1;
                            r1 = r4.m9688t();
                            r1 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.InstantArticleModel.m10431a(r1);
                            r0.f8425u = r1;
                            r1 = r4.mo576J();
                            r0.f8426v = r1;
                            r1 = r4.m9689u();
                            r0.f8427w = r1;
                            r1 = r4.m9691w();
                            r0.f8428x = r1;
                            r1 = r4.m9692x();
                            r0.f8429y = r1;
                            r1 = r4.m9693y();
                            r1 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel.m9609a(r1);
                            r0.f8430z = r1;
                            r1 = r4.m9694z();
                            r0.f8381A = r1;
                            r1 = r4.m9643B();
                            r0.f8382B = r1;
                            r1 = r4.mo578R();
                            r1 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.a(r1);
                            r0.f8383C = r1;
                            r1 = r4.mo573D();
                            r0.f8384D = r1;
                            r1 = r4.mo574E();
                            r1 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel.m10460a(r1);
                            r0.f8385E = r1;
                            r1 = r4.mo580Y();
                            r1 = com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel.m10537a(r1);
                            r0.f8386F = r1;
                            r1 = r4.m9648G();
                            r1 = com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels.PulsePhrasesAnalysisExternalUrlModel.PhrasesAnalysisModel.m10347a(r1);
                            r0.f8387G = r1;
                            r1 = r4.ad();
                            r0.f8388H = r1;
                            r1 = r4.ae();
                            r0.f8389I = r1;
                            r1 = r4.m9649H();
                            r0.f8390J = r1;
                            r1 = r4.m9650I();
                            r0.f8391K = r1;
                            r1 = r4.m9652K();
                            r1 = com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels.PulseQuotesAnalysisExternalUrlModel.QuotesAnalysisModel.m10397a(r1);
                            r0.f8392L = r1;
                            r1 = r4.m9653L();
                            r1 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel.m9621a(r1);
                            r0.f8393M = r1;
                            r2 = r4.m9654M();
                            r0.f8394N = r2;
                            r2 = r4.m9656O();
                            r0.f8395O = r2;
                            r1 = r4.m9657P();
                            r0.f8396P = r1;
                            r1 = r4.m9658Q();
                            r0.f8397Q = r1;
                            r1 = r4.m9660S();
                            r0.f8398R = r1;
                            r1 = r4.mo579T();
                            r1 = com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel.m10478a(r1);
                            r0.f8399S = r1;
                            r1 = r4.m9662U();
                            r0.f8400T = r1;
                            r1 = r4.m9663V();
                            r1 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel.m9628a(r1);
                            r0.f8401U = r1;
                            r1 = r4.m9664W();
                            r0.f8402V = r1;
                            r1 = r4.m9665X();
                            r1 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel.m9635a(r1);
                            r0.f8403W = r1;
                            r1 = r4.m9667Z();
                            r0.f8404X = r1;
                            r4 = r0.m9596a();
                            goto L_0x0003;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m9670a() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = r1.mo572C();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.a():java.lang.String");
                        }

                        public final int jK_() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = 242192389; // 0xe6f9005 float:2.9528367E-30 double:1.19658939E-315;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m9669a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r3 = this;
                            r1 = 0;
                            r3.h();
                            r0 = r3.aa();
                            if (r0 == 0) goto L_0x0022;
                        L_0x000a:
                            r0 = r3.aa();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.AllShareStoriesModel) r0;
                            r2 = r3.aa();
                            if (r2 == r0) goto L_0x0022;
                        L_0x001a:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8482e = r0;
                        L_0x0022:
                            r0 = r3.ab();
                            if (r0 == 0) goto L_0x0040;
                        L_0x0028:
                            r0 = r3.ab();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleModels.SearchResultsWikiModulePageModel.BestDescriptionModel) r0;
                            r2 = r3.ab();
                            if (r2 == r0) goto L_0x0040;
                        L_0x0038:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8483f = r0;
                        L_0x0040:
                            r0 = r3.mo591p();
                            if (r0 == 0) goto L_0x005e;
                        L_0x0046:
                            r0 = r3.mo591p();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.graphql.model.GraphQLStory) r0;
                            r2 = r3.mo591p();
                            if (r2 == r0) goto L_0x005e;
                        L_0x0056:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8486i = r0;
                        L_0x005e:
                            r0 = r3.ac();
                            if (r0 == 0) goto L_0x007c;
                        L_0x0064:
                            r0 = r3.ac();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlModels.PulseEmotionAnalysisExternalUrlModel.EmotionalAnalysisModel) r0;
                            r2 = r3.ac();
                            if (r2 == r0) goto L_0x007c;
                        L_0x0074:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8488k = r0;
                        L_0x007c:
                            r0 = r3.af();
                            if (r0 == 0) goto L_0x009a;
                        L_0x0082:
                            r0 = r3.af();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel) r0;
                            r2 = r3.af();
                            if (r2 == r0) goto L_0x009a;
                        L_0x0092:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8490m = r0;
                        L_0x009a:
                            r0 = r3.ag();
                            if (r0 == 0) goto L_0x00b8;
                        L_0x00a0:
                            r0 = r3.ag();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                            r2 = r3.ag();
                            if (r2 == r0) goto L_0x00b8;
                        L_0x00b0:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8495r = r0;
                        L_0x00b8:
                            r0 = r3.ah();
                            if (r0 == 0) goto L_0x00d6;
                        L_0x00be:
                            r0 = r3.ah();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                            r2 = r3.ah();
                            if (r2 == r0) goto L_0x00d6;
                        L_0x00ce:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8496s = r0;
                        L_0x00d6:
                            r0 = r3.ai();
                            if (r0 == 0) goto L_0x00f4;
                        L_0x00dc:
                            r0 = r3.ai();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                            r2 = r3.ai();
                            if (r2 == r0) goto L_0x00f4;
                        L_0x00ec:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8497t = r0;
                        L_0x00f4:
                            r0 = r3.aj();
                            if (r0 == 0) goto L_0x0112;
                        L_0x00fa:
                            r0 = r3.aj();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.InstantArticleModel) r0;
                            r2 = r3.aj();
                            if (r2 == r0) goto L_0x0112;
                        L_0x010a:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8501x = r0;
                        L_0x0112:
                            r0 = r3.ak();
                            if (r0 == 0) goto L_0x0130;
                        L_0x0118:
                            r0 = r3.ak();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.LinkMediaModel) r0;
                            r2 = r3.ak();
                            if (r2 == r0) goto L_0x0130;
                        L_0x0128:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8457C = r0;
                        L_0x0130:
                            r0 = r3.am();
                            if (r0 == 0) goto L_0x014e;
                        L_0x0136:
                            r0 = r3.am();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel) r0;
                            r2 = r3.am();
                            if (r2 == r0) goto L_0x014e;
                        L_0x0146:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8460F = r0;
                        L_0x014e:
                            r0 = r3.an();
                            if (r0 == 0) goto L_0x016c;
                        L_0x0154:
                            r0 = r3.an();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel) r0;
                            r2 = r3.an();
                            if (r2 == r0) goto L_0x016c;
                        L_0x0164:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8462H = r0;
                        L_0x016c:
                            r0 = r3.ao();
                            if (r0 == 0) goto L_0x018a;
                        L_0x0172:
                            r0 = r3.ao();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel) r0;
                            r2 = r3.ao();
                            if (r2 == r0) goto L_0x018a;
                        L_0x0182:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8463I = r0;
                        L_0x018a:
                            r0 = r3.ap();
                            if (r0 == 0) goto L_0x01a8;
                        L_0x0190:
                            r0 = r3.ap();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlModels.PulsePhrasesAnalysisExternalUrlModel.PhrasesAnalysisModel) r0;
                            r2 = r3.ap();
                            if (r2 == r0) goto L_0x01a8;
                        L_0x01a0:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8464J = r0;
                        L_0x01a8:
                            r0 = r3.aq();
                            if (r0 == 0) goto L_0x01c6;
                        L_0x01ae:
                            r0 = r3.aq();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlModels.PulseQuotesAnalysisExternalUrlModel.QuotesAnalysisModel) r0;
                            r2 = r3.aq();
                            if (r2 == r0) goto L_0x01c6;
                        L_0x01be:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8469O = r0;
                        L_0x01c6:
                            r0 = r3.ar();
                            if (r0 == 0) goto L_0x01e4;
                        L_0x01cc:
                            r0 = r3.ar();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.SourceModel) r0;
                            r2 = r3.ar();
                            if (r2 == r0) goto L_0x01e4;
                        L_0x01dc:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8470P = r0;
                        L_0x01e4:
                            r0 = r3.as();
                            if (r0 == 0) goto L_0x0202;
                        L_0x01ea:
                            r0 = r3.as();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel) r0;
                            r2 = r3.as();
                            if (r2 == r0) goto L_0x0202;
                        L_0x01fa:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8476V = r0;
                        L_0x0202:
                            r0 = r3.au();
                            if (r0 == 0) goto L_0x0220;
                        L_0x0208:
                            r0 = r3.au();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.TitleModel) r0;
                            r2 = r3.au();
                            if (r2 == r0) goto L_0x0220;
                        L_0x0218:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8478X = r0;
                        L_0x0220:
                            r0 = r3.aw();
                            if (r0 == 0) goto L_0x023e;
                        L_0x0226:
                            r0 = r3.aw();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.VideoShareModel) r0;
                            r2 = r3.aw();
                            if (r2 == r0) goto L_0x023e;
                        L_0x0236:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r1;
                            r1.f8480Z = r0;
                        L_0x023e:
                            r3.i();
                            if (r1 != 0) goto L_0x0244;
                        L_0x0243:
                            return r3;
                        L_0x0244:
                            r3 = r1;
                            goto L_0x0243;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m9668a(com.facebook.flatbuffers.FlatBufferBuilder r34) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r33 = this;
                            r33.h();
                            r2 = r33.m9674b();
                            r0 = r34;
                            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                            r3 = r33.aa();
                            r0 = r34;
                            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                            r4 = r33.ab();
                            r0 = r34;
                            r4 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r4);
                            r5 = r33.m9677g();
                            r0 = r34;
                            r5 = r0.a(r5);
                            r6 = r33.mo591p();
                            r0 = r34;
                            r8 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.ac();
                            r0 = r34;
                            r9 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.mo593v();
                            r0 = r34;
                            r10 = r0.b(r6);
                            r6 = r33.af();
                            r0 = r34;
                            r11 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.mo572C();
                            r0 = r34;
                            r12 = r0.b(r6);
                            r6 = r33.ag();
                            r0 = r34;
                            r13 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.ah();
                            r0 = r34;
                            r14 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.ai();
                            r0 = r34;
                            r15 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.aj();
                            r0 = r34;
                            r16 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.ak();
                            r0 = r34;
                            r17 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.am();
                            r0 = r34;
                            r18 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.mo573D();
                            r0 = r34;
                            r19 = r0.b(r6);
                            r6 = r33.an();
                            r0 = r34;
                            r20 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.ao();
                            r0 = r34;
                            r21 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.ap();
                            r0 = r34;
                            r22 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.m9649H();
                            r0 = r34;
                            r23 = r0.b(r6);
                            r6 = r33.m9650I();
                            r0 = r34;
                            r24 = r0.b(r6);
                            r6 = r33.aq();
                            r0 = r34;
                            r25 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.ar();
                            r0 = r34;
                            r26 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.m9657P();
                            r0 = r34;
                            r27 = r0.b(r6);
                            r6 = r33.m9658Q();
                            r0 = r34;
                            r28 = r0.b(r6);
                            r6 = r33.as();
                            r0 = r34;
                            r29 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.au();
                            r0 = r34;
                            r30 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = r33.m9664W();
                            r0 = r34;
                            r31 = r0.b(r6);
                            r6 = r33.aw();
                            r0 = r34;
                            r32 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r6 = 50;
                            r0 = r34;
                            r0.c(r6);
                            r6 = 0;
                            r0 = r34;
                            r0.b(r6, r2);
                            r2 = 1;
                            r0 = r34;
                            r0.b(r2, r3);
                            r2 = 2;
                            r0 = r34;
                            r0.b(r2, r4);
                            r2 = 3;
                            r0 = r34;
                            r0.b(r2, r5);
                            r3 = 4;
                            r0 = r33;
                            r4 = r0.f8485h;
                            r6 = 0;
                            r2 = r34;
                            r2.a(r3, r4, r6);
                            r2 = 5;
                            r0 = r34;
                            r0.b(r2, r8);
                            r3 = 6;
                            r0 = r33;
                            r4 = r0.f8487j;
                            r6 = 0;
                            r2 = r34;
                            r2.a(r3, r4, r6);
                            r2 = 7;
                            r0 = r34;
                            r0.b(r2, r9);
                            r2 = 8;
                            r0 = r34;
                            r0.b(r2, r10);
                            r2 = 9;
                            r0 = r34;
                            r0.b(r2, r11);
                            r2 = 10;
                            r0 = r33;
                            r3 = r0.f8491n;
                            r0 = r34;
                            r0.a(r2, r3);
                            r2 = 11;
                            r0 = r33;
                            r3 = r0.f8492o;
                            r0 = r34;
                            r0.a(r2, r3);
                            r2 = 12;
                            r0 = r33;
                            r3 = r0.f8493p;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 13;
                            r0 = r34;
                            r0.b(r2, r12);
                            r2 = 14;
                            r0 = r34;
                            r0.b(r2, r13);
                            r2 = 15;
                            r0 = r34;
                            r0.b(r2, r14);
                            r2 = 16;
                            r0 = r34;
                            r0.b(r2, r15);
                            r2 = 17;
                            r0 = r33;
                            r3 = r0.f8498u;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 18;
                            r0 = r33;
                            r3 = r0.f8499v;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 19;
                            r0 = r33;
                            r3 = r0.f8500w;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 20;
                            r0 = r34;
                            r1 = r16;
                            r0.b(r2, r1);
                            r2 = 21;
                            r0 = r33;
                            r3 = r0.f8502y;
                            r0 = r34;
                            r0.a(r2, r3);
                            r2 = 22;
                            r0 = r33;
                            r3 = r0.f8503z;
                            r0 = r34;
                            r0.a(r2, r3);
                            r2 = 23;
                            r0 = r33;
                            r3 = r0.f8455A;
                            r0 = r34;
                            r0.a(r2, r3);
                            r2 = 24;
                            r0 = r33;
                            r3 = r0.f8456B;
                            r0 = r34;
                            r0.a(r2, r3);
                            r2 = 25;
                            r0 = r34;
                            r1 = r17;
                            r0.b(r2, r1);
                            r2 = 26;
                            r0 = r33;
                            r3 = r0.f8458D;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 27;
                            r0 = r33;
                            r3 = r0.f8459E;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 28;
                            r0 = r34;
                            r1 = r18;
                            r0.b(r2, r1);
                            r2 = 29;
                            r0 = r34;
                            r1 = r19;
                            r0.b(r2, r1);
                            r2 = 30;
                            r0 = r34;
                            r1 = r20;
                            r0.b(r2, r1);
                            r2 = 31;
                            r0 = r34;
                            r1 = r21;
                            r0.b(r2, r1);
                            r2 = 32;
                            r0 = r34;
                            r1 = r22;
                            r0.b(r2, r1);
                            r2 = 33;
                            r0 = r33;
                            r3 = r0.f8465K;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 34;
                            r0 = r33;
                            r3 = r0.f8466L;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 35;
                            r0 = r34;
                            r1 = r23;
                            r0.b(r2, r1);
                            r2 = 36;
                            r0 = r34;
                            r1 = r24;
                            r0.b(r2, r1);
                            r2 = 37;
                            r0 = r34;
                            r1 = r25;
                            r0.b(r2, r1);
                            r2 = 38;
                            r0 = r34;
                            r1 = r26;
                            r0.b(r2, r1);
                            r3 = 39;
                            r0 = r33;
                            r4 = r0.f8471Q;
                            r6 = 0;
                            r2 = r34;
                            r2.a(r3, r4, r6);
                            r3 = 40;
                            r0 = r33;
                            r4 = r0.f8472R;
                            r6 = 0;
                            r2 = r34;
                            r2.a(r3, r4, r6);
                            r2 = 41;
                            r0 = r34;
                            r1 = r27;
                            r0.b(r2, r1);
                            r2 = 42;
                            r0 = r34;
                            r1 = r28;
                            r0.b(r2, r1);
                            r2 = 43;
                            r0 = r33;
                            r3 = r0.f8475U;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r2 = 44;
                            r0 = r34;
                            r1 = r29;
                            r0.b(r2, r1);
                            r2 = 45;
                            r0 = r33;
                            r3 = r0.f8477W;
                            r0 = r34;
                            r0.a(r2, r3);
                            r2 = 46;
                            r0 = r34;
                            r1 = r30;
                            r0.b(r2, r1);
                            r2 = 47;
                            r0 = r34;
                            r1 = r31;
                            r0.b(r2, r1);
                            r2 = 48;
                            r0 = r34;
                            r1 = r32;
                            r0.b(r2, r1);
                            r2 = 49;
                            r0 = r33;
                            r3 = r0.aa;
                            r4 = 0;
                            r0 = r34;
                            r0.a(r2, r3, r4);
                            r33.i();
                            r2 = r34.d();
                            return r2;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }

                        public final void m9671a(com.facebook.flatbuffers.MutableFlatBuffer r9, int r10, java.lang.Object r11) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r8 = this;
                            r6 = 0;
                            r4 = 0;
                            r2 = 0;
                            super.a(r9, r10, r11);
                            r0 = 4;
                            r0 = r9.a(r10, r0, r6);
                            r8.f8485h = r0;
                            r0 = 6;
                            r0 = r9.a(r10, r0, r6);
                            r8.f8487j = r0;
                            r0 = 10;
                            r0 = r9.a(r10, r0);
                            r8.f8491n = r0;
                            r0 = 11;
                            r0 = r9.a(r10, r0);
                            r8.f8492o = r0;
                            r0 = 12;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8493p = r0;
                            r0 = 17;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8498u = r0;
                            r0 = 18;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8499v = r0;
                            r0 = 19;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8500w = r0;
                            r0 = 21;
                            r0 = r9.a(r10, r0);
                            r8.f8502y = r0;
                            r0 = 22;
                            r0 = r9.a(r10, r0);
                            r8.f8503z = r0;
                            r0 = 23;
                            r0 = r9.a(r10, r0);
                            r8.f8455A = r0;
                            r0 = 24;
                            r0 = r9.a(r10, r0);
                            r8.f8456B = r0;
                            r0 = 26;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8458D = r0;
                            r0 = 27;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8459E = r0;
                            r0 = 33;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8465K = r0;
                            r0 = 34;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8466L = r0;
                            r0 = 39;
                            r0 = r9.a(r10, r0, r4);
                            r8.f8471Q = r0;
                            r0 = 40;
                            r0 = r9.a(r10, r0, r4);
                            r8.f8472R = r0;
                            r0 = 43;
                            r0 = r9.a(r10, r0, r2);
                            r8.f8475U = r0;
                            r0 = 45;
                            r0 = r9.a(r10, r0);
                            r8.f8477W = r0;
                            r0 = 49;
                            r0 = r9.a(r10, r0, r2);
                            r8.aa = r0;
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                        }
                    }

                    /* compiled from: module_role */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public Serializer() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            r0.<init>();
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Serializer.<init>():void");
                        }

                        public final void m9695a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m9697a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.EdgesParser.m9791b(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.class;
                            r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Serializer.<clinit>():void");
                        }
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel m9699a() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m9701j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.a():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel");
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel m9702k() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m9701j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.k():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel");
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.search.results.protocol.video.SearchResultsVideoInterfaces.SearchResultsVideo m9703l() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m9701j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.l():com.facebook.search.results.protocol.video.SearchResultsVideoInterfaces$SearchResultsVideo");
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo m9704m() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m9701j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.m():com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces$SearchResultsWebVideo");
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage m9705n() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m9701j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.n():com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces$SearchResultsWikiModulePage");
                    }

                    public EdgesModel() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 2;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.<init>():void");
                    }

                    public EdgesModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = 2;
                        r2.<init>(r0);
                        r1 = r3.a;
                        r0 = r1;
                        r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r2.a(r3, r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel m9701j() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r0 = r3.f8504d;
                        r1 = 0;
                        r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r0;
                        r3.f8504d = r0;
                        r0 = r3.f8504d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.j():com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$EdgesNodeModel");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.graphql.enums.GraphQLGraphSearchResultRole m9700b() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r4 = this;
                        r0 = r4.f8505e;
                        r1 = 1;
                        r2 = com.facebook.graphql.enums.GraphQLGraphSearchResultRole.class;
                        r3 = com.facebook.graphql.enums.GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                        r0 = super.b(r0, r1, r2, r3);
                        r0 = (com.facebook.graphql.enums.GraphQLGraphSearchResultRole) r0;
                        r4.f8505e = r0;
                        r0 = r4.f8505e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.b():com.facebook.graphql.enums.GraphQLGraphSearchResultRole");
                    }

                    public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel m9696a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel r2) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        if (r2 != 0) goto L_0x0004;
                    L_0x0002:
                        r2 = 0;
                    L_0x0003:
                        return r2;
                    L_0x0004:
                        r0 = r2 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
                        if (r0 == 0) goto L_0x000b;
                    L_0x0008:
                        r2 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel) r2;
                        goto L_0x0003;
                    L_0x000b:
                        r0 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel$Builder;
                        r0.<init>();
                        r1 = r2.m9699a();
                        r1 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel.m9641a(r1);
                        r0.f8377a = r1;
                        r1 = r2.m9700b();
                        r0.f8378b = r1;
                        r2 = r0.m9586a();
                        goto L_0x0003;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = -645190812; // 0xffffffffd98b2b64 float:-4.8965913E15 double:NaN;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m9698a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r1 = 0;
                        r3.h();
                        r0 = r3.m9701j();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m9701j();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel) r0;
                        r2 = r3.m9701j();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel) r1;
                        r1.f8504d = r0;
                    L_0x0022:
                        r3.i();
                        if (r1 != 0) goto L_0x0028;
                    L_0x0027:
                        return r3;
                    L_0x0028:
                        r3 = r1;
                        goto L_0x0027;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m9697a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r3.h();
                        r0 = r3.m9701j();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                        r1 = r3.m9700b();
                        r1 = r4.a(r1);
                        r2 = 2;
                        r4.c(r2);
                        r2 = 0;
                        r4.b(r2, r0);
                        r0 = 1;
                        r4.b(r0, r1);
                        r3.i();
                        r0 = r4.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: module_role */
                public class Serializer extends JsonSerializer<ModuleResultsModel> {
                    public Serializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Serializer.<init>():void");
                    }

                    public final void m9706a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m9708a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.search.results.protocol.SearchResultsEdgeParsers.SearchResultsEdgeParser.NodeParser.ModuleResultsParser.m9793a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.class;
                        r1 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.Serializer.<clinit>():void");
                    }
                }

                public ModuleResultsModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.<init>():void");
                }

                public ModuleResultsModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 1;
                    r2.<init>(r0);
                    r1 = r3.a;
                    r0 = r1;
                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r2.a(r3, r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel> m9710a() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f8506d;
                    r1 = 0;
                    r2 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f8506d = r0;
                    r0 = r3.f8506d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.a():com.google.common.collect.ImmutableList<com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$EdgesModel>");
                }

                public static com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel m9707a(com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    if (r4 != 0) goto L_0x0004;
                L_0x0002:
                    r4 = 0;
                L_0x0003:
                    return r4;
                L_0x0004:
                    r0 = r4 instanceof com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;
                    if (r0 == 0) goto L_0x000b;
                L_0x0008:
                    r4 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel) r4;
                    goto L_0x0003;
                L_0x000b:
                    r2 = new com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel$Builder;
                    r2.<init>();
                    r3 = com.google.common.collect.ImmutableList.builder();
                    r0 = 0;
                    r1 = r0;
                L_0x0016:
                    r0 = r4.m9710a();
                    r0 = r0.size();
                    if (r1 >= r0) goto L_0x0035;
                L_0x0020:
                    r0 = r4.m9710a();
                    r0 = r0.get(r1);
                    r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel) r0;
                    r0 = com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.m9696a(r0);
                    r3.c(r0);
                    r0 = r1 + 1;
                    r1 = r0;
                    goto L_0x0016;
                L_0x0035:
                    r0 = r3.b();
                    r2.f8376a = r0;
                    r4 = r2.m9583a();
                    goto L_0x0003;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.a(com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel):com.facebook.search.results.protocol.SearchResultsEdgeModels$SearchResultsEdgeModel$NodeModel$ModuleResultsModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1993286469; // 0x76cf2345 float:2.1006266E33 double:9.848143667E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m9709a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r2.h();
                    r1 = r2.m9710a();
                    if (r1 == 0) goto L_0x0020;
                L_0x000a:
                    r1 = r2.m9710a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    if (r1 == 0) goto L_0x0020;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                    r0 = (com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel) r0;
                    r1 = r1.b();
                    r0.f8506d = r1;
                L_0x0020:
                    r2.i();
                    if (r0 != 0) goto L_0x0026;
                L_0x0025:
                    return r2;
                L_0x0026:
                    r2 = r0;
                    goto L_0x0025;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m9708a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.checkInstructions(MethodNode.java:122)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:41)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m9710a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: module_role */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m9711a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m9739a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m9795a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m9716D() {
                return aI();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m9717E() {
                return aJ();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields mo575F() {
                return aK();
            }

            @Nullable
            public final /* synthetic */ SearchResultsWebVideo.LinkMedia mo577N() {
                return aL();
            }

            @Nullable
            public final /* synthetic */ LocationModel m9728P() {
                return aM();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesLongFields mo578R() {
                return aN();
            }

            @Nullable
            public final /* synthetic */ ModuleResultsModel m9731S() {
                return aO();
            }

            @Nullable
            public final /* synthetic */ MutualFriendsModel m9735W() {
                return aP();
            }

            @Nullable
            public final /* synthetic */ OverallStarRatingModel m9736X() {
                return aQ();
            }

            @Nullable
            public final /* synthetic */ OwnerModel mo580Y() {
                return aR();
            }

            @Nullable
            public final /* synthetic */ SearchResultsPageCTAModel m9738Z() {
                return aS();
            }

            @Nullable
            public final /* synthetic */ PageLikersModel aa() {
                return aT();
            }

            @Nullable
            public final /* synthetic */ PlaceOpenStatusModel ab() {
                return aU();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields ah() {
                return aV();
            }

            @Nullable
            public final /* synthetic */ SearchResultsSeeMoreQueryModel aj() {
                return aW();
            }

            @Nullable
            public final /* synthetic */ SocialContextModel ak() {
                return aX();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesLongFields al() {
                return aY();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesLongFields at() {
                return aZ();
            }

            @Nullable
            public final /* synthetic */ VideoShare av() {
                return ba();
            }

            @Nullable
            public final /* synthetic */ VisibilitySentenceModel az() {
                return bb();
            }

            @Nullable
            public final /* synthetic */ ModuleResultsModel bc() {
                return aO();
            }

            @Nullable
            public final /* synthetic */ ModuleResultsModel bd() {
                return aO();
            }

            @Nullable
            public final /* synthetic */ ModuleResultsModel be() {
                return aO();
            }

            @Nullable
            public final /* synthetic */ ModuleResultsModel bf() {
                return aO();
            }

            @Nullable
            public final /* synthetic */ AddressModel m9746c() {
                return aB();
            }

            @Nullable
            public final /* synthetic */ AllShareStories mo588d() {
                return aC();
            }

            @Nullable
            public final /* synthetic */ BioTextModel m9748g() {
                return aD();
            }

            @Nullable
            public final /* synthetic */ CoverPhotoModel m9753n() {
                return aE();
            }

            @Nullable
            public final /* synthetic */ EventPlaceModel m9759t() {
                return aF();
            }

            @Nullable
            public final /* synthetic */ GroupMembersModel m9763x() {
                return aG();
            }

            @Nullable
            public final /* synthetic */ GuidedTourModel m9764y() {
                return aH();
            }

            public NodeModel() {
                super(77);
            }

            public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(77);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m9743a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m9744a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m9745b() {
                if (this.b != null && this.f8533d == null) {
                    this.f8533d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8533d;
            }

            @Nullable
            public final AddressModel aB() {
                this.f8534e = (AddressModel) super.a(this.f8534e, 1, AddressModel.class);
                return this.f8534e;
            }

            @Nullable
            public final AllShareStoriesModel aC() {
                this.f8535f = (AllShareStoriesModel) super.a(this.f8535f, 2, AllShareStoriesModel.class);
                return this.f8535f;
            }

            @Nonnull
            public final ImmutableList<String> jg_() {
                this.f8536g = super.a(this.f8536g, 3);
                return (ImmutableList) this.f8536g;
            }

            @Nullable
            public final BioTextModel aD() {
                this.f8537h = (BioTextModel) super.a(this.f8537h, 4, BioTextModel.class);
                return this.f8537h;
            }

            @Nullable
            public final GraphQLVideoBroadcastStatus jh_() {
                this.f8538i = (GraphQLVideoBroadcastStatus) super.b(this.f8538i, 5, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8538i;
            }

            public final boolean ji_() {
                a(0, 6);
                return this.f8539j;
            }

            public final boolean m9751l() {
                a(0, 7);
                return this.f8540k;
            }

            @Nonnull
            public final ImmutableList<String> m9752m() {
                this.f8541l = super.a(this.f8541l, 8);
                return (ImmutableList) this.f8541l;
            }

            @Nullable
            public final CoverPhotoModel aE() {
                this.f8542m = (CoverPhotoModel) super.a(this.f8542m, 9, CoverPhotoModel.class);
                return this.f8542m;
            }

            public final long mo590o() {
                a(1, 2);
                return this.f8543n;
            }

            @Nullable
            public final GraphQLStory mo591p() {
                this.f8544o = (GraphQLStory) super.a(this.f8544o, 11, GraphQLStory.class);
                return this.f8544o;
            }

            public final long mo592q() {
                a(1, 4);
                return this.f8545p;
            }

            @Nonnull
            public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m9757r() {
                this.f8546q = super.c(this.f8546q, 13, GraphQLGraphSearchResultsDisplayStyle.class);
                return (ImmutableList) this.f8546q;
            }

            public final boolean m9758s() {
                a(1, 6);
                return this.f8547r;
            }

            @Nullable
            public final EventPlaceModel aF() {
                this.f8548s = (EventPlaceModel) super.a(this.f8548s, 15, EventPlaceModel.class);
                return this.f8548s;
            }

            public final boolean m9760u() {
                a(2, 0);
                return this.f8549t;
            }

            @Nullable
            public final String mo593v() {
                this.f8550u = super.a(this.f8550u, 17);
                return this.f8550u;
            }

            @Nullable
            public final GraphQLFriendshipStatus m9762w() {
                this.f8551v = (GraphQLFriendshipStatus) super.b(this.f8551v, 18, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8551v;
            }

            @Nullable
            public final GroupMembersModel aG() {
                this.f8552w = (GroupMembersModel) super.a(this.f8552w, 19, GroupMembersModel.class);
                return this.f8552w;
            }

            @Nullable
            public final GuidedTourModel aH() {
                this.f8553x = (GuidedTourModel) super.a(this.f8553x, 20, GuidedTourModel.class);
                return this.f8553x;
            }

            public final boolean m9765z() {
                a(2, 5);
                return this.f8554y;
            }

            public final boolean mo571A() {
                a(2, 6);
                return this.f8555z;
            }

            public final int m9714B() {
                a(2, 7);
                return this.f8507A;
            }

            @Nullable
            public final String mo572C() {
                this.f8508B = super.a(this.f8508B, 24);
                return this.f8508B;
            }

            @Nullable
            public final DefaultImageFieldsModel aI() {
                this.f8509C = (DefaultImageFieldsModel) super.a(this.f8509C, 25, DefaultImageFieldsModel.class);
                return this.f8509C;
            }

            @Nullable
            public final DefaultImageFieldsModel aJ() {
                this.f8510D = (DefaultImageFieldsModel) super.a(this.f8510D, 26, DefaultImageFieldsModel.class);
                return this.f8510D;
            }

            @Nullable
            public final DefaultImageFieldsModel aK() {
                this.f8511E = (DefaultImageFieldsModel) super.a(this.f8511E, 27, DefaultImageFieldsModel.class);
                return this.f8511E;
            }

            public final int m9719G() {
                a(3, 4);
                return this.f8512F;
            }

            public final int m9720H() {
                a(3, 5);
                return this.f8513G;
            }

            public final int m9721I() {
                a(3, 6);
                return this.f8514H;
            }

            public final boolean mo576J() {
                a(3, 7);
                return this.f8515I;
            }

            public final boolean m9723K() {
                a(4, 0);
                return this.f8516J;
            }

            public final boolean m9724L() {
                a(4, 1);
                return this.f8517K;
            }

            public final boolean mo562j() {
                a(4, 2);
                return this.f8518L;
            }

            public final boolean m9725M() {
                a(4, 3);
                return this.f8519M;
            }

            @Nullable
            public final LinkMediaModel aL() {
                this.f8520N = (LinkMediaModel) super.a(this.f8520N, 36, LinkMediaModel.class);
                return this.f8520N;
            }

            public final int m9727O() {
                a(4, 5);
                return this.f8521O;
            }

            @Nullable
            public final LocationModel aM() {
                this.f8522P = (LocationModel) super.a(this.f8522P, 38, LocationModel.class);
                return this.f8522P;
            }

            public final int m9729Q() {
                a(4, 7);
                return this.f8523Q;
            }

            @Nullable
            public final DefaultTextWithEntitiesLongFieldsModel aN() {
                this.f8524R = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f8524R, 40, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f8524R;
            }

            @Nullable
            public final ModuleResultsModel aO() {
                this.f8525S = (ModuleResultsModel) super.a(this.f8525S, 41, ModuleResultsModel.class);
                return this.f8525S;
            }

            @Nullable
            public final GraphQLGraphSearchResultRole m9732T() {
                this.f8526T = (GraphQLGraphSearchResultRole) super.b(this.f8526T, 42, GraphQLGraphSearchResultRole.class, GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8526T;
            }

            public final int m9733U() {
                a(5, 3);
                return this.f8527U;
            }

            @Nullable
            public final String m9734V() {
                this.f8528V = super.a(this.f8528V, 44);
                return this.f8528V;
            }

            @Nullable
            public final MutualFriendsModel aP() {
                this.f8529W = (MutualFriendsModel) super.a(this.f8529W, 45, MutualFriendsModel.class);
                return this.f8529W;
            }

            @Nullable
            public final String mo563k() {
                this.f8530X = super.a(this.f8530X, 46);
                return this.f8530X;
            }

            @Nullable
            public final OverallStarRatingModel aQ() {
                this.f8531Y = (OverallStarRatingModel) super.a(this.f8531Y, 47, OverallStarRatingModel.class);
                return this.f8531Y;
            }

            @Nullable
            public final OwnerModel aR() {
                this.f8532Z = (OwnerModel) super.a(this.f8532Z, 48, OwnerModel.class);
                return this.f8532Z;
            }

            @Nullable
            public final SearchResultsPageCTAModel aS() {
                this.aa = (SearchResultsPageCTAModel) super.a(this.aa, 49, SearchResultsPageCTAModel.class);
                return this.aa;
            }

            @Nullable
            public final PageLikersModel aT() {
                this.ab = (PageLikersModel) super.a(this.ab, 50, PageLikersModel.class);
                return this.ab;
            }

            @Nullable
            public final PlaceOpenStatusModel aU() {
                this.ac = (PlaceOpenStatusModel) super.a(this.ac, 51, PlaceOpenStatusModel.class);
                return this.ac;
            }

            @Nullable
            public final GraphQLPageOpenHoursDisplayDecisionEnum ac() {
                this.ad = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.ad, 52, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.ad;
            }

            public final int ad() {
                a(6, 5);
                return this.ae;
            }

            public final int ae() {
                a(6, 6);
                return this.af;
            }

            @Nullable
            public final String af() {
                this.ag = super.a(this.ag, 55);
                return this.ag;
            }

            @Nullable
            public final String ag() {
                this.ah = super.a(this.ah, 56);
                return this.ah;
            }

            @Nullable
            public final DefaultImageFieldsModel aV() {
                this.ai = (DefaultImageFieldsModel) super.a(this.ai, 57, DefaultImageFieldsModel.class);
                return this.ai;
            }

            @Nullable
            public final String ai() {
                this.aj = super.a(this.aj, 58);
                return this.aj;
            }

            @Nullable
            public final SearchResultsSeeMoreQueryModel aW() {
                this.ak = (SearchResultsSeeMoreQueryModel) super.a(this.ak, 59, SearchResultsSeeMoreQueryModel.class);
                return this.ak;
            }

            @Nullable
            public final SocialContextModel aX() {
                this.al = (SocialContextModel) super.a(this.al, 60, SocialContextModel.class);
                return this.al;
            }

            @Nullable
            public final DefaultTextWithEntitiesLongFieldsModel aY() {
                this.am = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.am, 61, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.am;
            }

            public final double am() {
                a(7, 6);
                return this.an;
            }

            public final double an() {
                a(7, 7);
                return this.ao;
            }

            @Nullable
            public final String ao() {
                this.ap = super.a(this.ap, 64);
                return this.ap;
            }

            @Nullable
            public final String ap() {
                this.aq = super.a(this.aq, 65);
                return this.aq;
            }

            public final int aq() {
                a(8, 2);
                return this.ar;
            }

            public final boolean ar() {
                a(8, 3);
                return this.as;
            }

            @Nullable
            public final String as() {
                this.at = super.a(this.at, 68);
                return this.at;
            }

            @Nullable
            public final DefaultTextWithEntitiesLongFieldsModel aZ() {
                this.au = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.au, 69, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.au;
            }

            @Nullable
            public final String au() {
                this.av = super.a(this.av, 70);
                return this.av;
            }

            @Nullable
            public final VideoShareModel ba() {
                this.aw = (VideoShareModel) super.a(this.aw, 71, VideoShareModel.class);
                return this.aw;
            }

            @Nullable
            public final GraphQLEventGuestStatus aw() {
                this.ax = (GraphQLEventGuestStatus) super.b(this.ax, 72, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.ax;
            }

            @Nullable
            public final GraphQLGroupJoinState ax() {
                this.ay = (GraphQLGroupJoinState) super.b(this.ay, 73, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.ay;
            }

            @Nullable
            public final GraphQLSavedState ay() {
                this.az = (GraphQLSavedState) super.b(this.az, 74, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.az;
            }

            @Nullable
            public final VisibilitySentenceModel bb() {
                this.aA = (VisibilitySentenceModel) super.a(this.aA, 75, VisibilitySentenceModel.class);
                return this.aA;
            }

            public final int aA() {
                a(9, 4);
                return this.aB;
            }

            public static NodeModel m9712a(NodeModel nodeModel) {
                int i = 0;
                if (nodeModel == null) {
                    return null;
                }
                if (nodeModel instanceof NodeModel) {
                    return nodeModel;
                }
                int i2;
                Builder builder = new Builder();
                builder.f8350a = nodeModel.m9745b();
                builder.f8351b = AddressModel.m10044a(nodeModel.m9746c());
                builder.f8352c = AllShareStoriesModel.m10574a(nodeModel.mo588d());
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (i2 = 0; i2 < nodeModel.jg_().size(); i2++) {
                    builder2.c(nodeModel.jg_().get(i2));
                }
                builder.f8353d = builder2.b();
                builder.f8354e = BioTextModel.m10102a(nodeModel.m9748g());
                builder.f8355f = nodeModel.jh_();
                builder.f8356g = nodeModel.ji_();
                builder.f8357h = nodeModel.m9751l();
                builder2 = ImmutableList.builder();
                for (i2 = 0; i2 < nodeModel.m9752m().size(); i2++) {
                    builder2.c(nodeModel.m9752m().get(i2));
                }
                builder.f8358i = builder2.b();
                builder.f8359j = CoverPhotoModel.m9998a(nodeModel.m9753n());
                builder.f8360k = nodeModel.mo590o();
                builder.f8361l = nodeModel.mo591p();
                builder.f8362m = nodeModel.mo592q();
                com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
                while (i < nodeModel.m9757r().size()) {
                    builder3.c(nodeModel.m9757r().get(i));
                    i++;
                }
                builder.f8363n = builder3.b();
                builder.f8364o = nodeModel.m9758s();
                builder.f8365p = EventPlaceModel.m9888a(nodeModel.m9759t());
                builder.f8366q = nodeModel.m9760u();
                builder.f8367r = nodeModel.mo593v();
                builder.f8368s = nodeModel.m9762w();
                builder.f8369t = GroupMembersModel.m9927a(nodeModel.m9763x());
                builder.f8370u = GuidedTourModel.a(nodeModel.m9764y());
                builder.f8371v = nodeModel.m9765z();
                builder.f8372w = nodeModel.mo571A();
                builder.f8373x = nodeModel.m9714B();
                builder.f8374y = nodeModel.mo572C();
                builder.f8375z = DefaultImageFieldsModel.a(nodeModel.m9716D());
                builder.f8324A = DefaultImageFieldsModel.a(nodeModel.m9717E());
                builder.f8325B = DefaultImageFieldsModel.a(nodeModel.mo575F());
                builder.f8326C = nodeModel.m9719G();
                builder.f8327D = nodeModel.m9720H();
                builder.f8328E = nodeModel.m9721I();
                builder.f8329F = nodeModel.mo576J();
                builder.f8330G = nodeModel.m9723K();
                builder.f8331H = nodeModel.m9724L();
                builder.f8332I = nodeModel.mo562j();
                builder.f8333J = nodeModel.m9725M();
                builder.f8334K = LinkMediaModel.m10582a(nodeModel.mo577N());
                builder.f8335L = nodeModel.m9727O();
                builder.f8336M = LocationModel.m10052a(nodeModel.m9728P());
                builder.f8337N = nodeModel.m9729Q();
                builder.f8338O = DefaultTextWithEntitiesLongFieldsModel.a(nodeModel.mo578R());
                builder.f8339P = ModuleResultsModel.m9707a(nodeModel.m9731S());
                builder.f8340Q = nodeModel.m9732T();
                builder.f8341R = nodeModel.m9733U();
                builder.f8342S = nodeModel.m9734V();
                builder.f8343T = MutualFriendsModel.m10109a(nodeModel.m9735W());
                builder.f8344U = nodeModel.mo563k();
                builder.f8345V = OverallStarRatingModel.m10060a(nodeModel.m9736X());
                builder.f8346W = OwnerModel.m10537a(nodeModel.mo580Y());
                builder.f8347X = SearchResultsPageCTAModel.m9975a(nodeModel.m9738Z());
                builder.f8348Y = PageLikersModel.m10006a(nodeModel.aa());
                builder.f8349Z = PlaceOpenStatusModel.m10068a(nodeModel.ab());
                builder.aa = nodeModel.ac();
                builder.ab = nodeModel.ad();
                builder.ac = nodeModel.ae();
                builder.ad = nodeModel.af();
                builder.ae = nodeModel.ag();
                builder.af = DefaultImageFieldsModel.a(nodeModel.ah());
                builder.ag = nodeModel.ai();
                builder.ah = SearchResultsSeeMoreQueryModel.m9840a(nodeModel.aj());
                builder.ai = SocialContextModel.m9934a(nodeModel.ak());
                builder.aj = DefaultTextWithEntitiesLongFieldsModel.a(nodeModel.al());
                builder.ak = nodeModel.am();
                builder.al = nodeModel.an();
                builder.am = nodeModel.ao();
                builder.an = nodeModel.ap();
                builder.ao = nodeModel.aq();
                builder.ap = nodeModel.ar();
                builder.aq = nodeModel.as();
                builder.ar = DefaultTextWithEntitiesLongFieldsModel.a(nodeModel.at());
                builder.as = nodeModel.au();
                builder.at = VideoShareModel.m10591a(nodeModel.av());
                builder.au = nodeModel.aw();
                builder.av = nodeModel.ax();
                builder.aw = nodeModel.ay();
                builder.ax = VisibilitySentenceModel.m9940a(nodeModel.az());
                builder.ay = nodeModel.aA();
                return builder.m9580a();
            }

            @Nullable
            public final String m9741a() {
                return mo572C();
            }

            public final int jK_() {
                return 1312008042;
            }

            public final GraphQLVisitableModel m9740a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (aB() != null) {
                    AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(aB());
                    if (aB() != addressModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8534e = addressModel;
                    }
                }
                if (aC() != null) {
                    AllShareStoriesModel allShareStoriesModel = (AllShareStoriesModel) graphQLModelMutatingVisitor.b(aC());
                    if (aC() != allShareStoriesModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8535f = allShareStoriesModel;
                    }
                }
                if (aD() != null) {
                    BioTextModel bioTextModel = (BioTextModel) graphQLModelMutatingVisitor.b(aD());
                    if (aD() != bioTextModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8537h = bioTextModel;
                    }
                }
                if (aE() != null) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(aE());
                    if (aE() != coverPhotoModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8542m = coverPhotoModel;
                    }
                }
                if (mo591p() != null) {
                    GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(mo591p());
                    if (mo591p() != graphQLStory) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8544o = graphQLStory;
                    }
                }
                if (aF() != null) {
                    EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(aF());
                    if (aF() != eventPlaceModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8548s = eventPlaceModel;
                    }
                }
                if (aG() != null) {
                    GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(aG());
                    if (aG() != groupMembersModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8552w = groupMembersModel;
                    }
                }
                if (aH() != null) {
                    GuidedTourModel guidedTourModel = (GuidedTourModel) graphQLModelMutatingVisitor.b(aH());
                    if (aH() != guidedTourModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8553x = guidedTourModel;
                    }
                }
                if (aI() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aI());
                    if (aI() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8509C = defaultImageFieldsModel;
                    }
                }
                if (aJ() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aJ());
                    if (aJ() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8510D = defaultImageFieldsModel;
                    }
                }
                if (aK() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aK());
                    if (aK() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8511E = defaultImageFieldsModel;
                    }
                }
                if (aL() != null) {
                    LinkMediaModel linkMediaModel = (LinkMediaModel) graphQLModelMutatingVisitor.b(aL());
                    if (aL() != linkMediaModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8520N = linkMediaModel;
                    }
                }
                if (aM() != null) {
                    LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(aM());
                    if (aM() != locationModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8522P = locationModel;
                    }
                }
                if (aN() != null) {
                    defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(aN());
                    if (aN() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8524R = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (aO() != null) {
                    ModuleResultsModel moduleResultsModel = (ModuleResultsModel) graphQLModelMutatingVisitor.b(aO());
                    if (aO() != moduleResultsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8525S = moduleResultsModel;
                    }
                }
                if (aP() != null) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(aP());
                    if (aP() != mutualFriendsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8529W = mutualFriendsModel;
                    }
                }
                if (aQ() != null) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(aQ());
                    if (aQ() != overallStarRatingModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8531Y = overallStarRatingModel;
                    }
                }
                if (aR() != null) {
                    OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(aR());
                    if (aR() != ownerModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8532Z = ownerModel;
                    }
                }
                if (aS() != null) {
                    SearchResultsPageCTAModel searchResultsPageCTAModel = (SearchResultsPageCTAModel) graphQLModelMutatingVisitor.b(aS());
                    if (aS() != searchResultsPageCTAModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aa = searchResultsPageCTAModel;
                    }
                }
                if (aT() != null) {
                    PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(aT());
                    if (aT() != pageLikersModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ab = pageLikersModel;
                    }
                }
                if (aU() != null) {
                    PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(aU());
                    if (aU() != placeOpenStatusModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ac = placeOpenStatusModel;
                    }
                }
                if (aV() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aV());
                    if (aV() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ai = defaultImageFieldsModel;
                    }
                }
                if (aW() != null) {
                    SearchResultsSeeMoreQueryModel searchResultsSeeMoreQueryModel = (SearchResultsSeeMoreQueryModel) graphQLModelMutatingVisitor.b(aW());
                    if (aW() != searchResultsSeeMoreQueryModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ak = searchResultsSeeMoreQueryModel;
                    }
                }
                if (aX() != null) {
                    SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(aX());
                    if (aX() != socialContextModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.al = socialContextModel;
                    }
                }
                if (aY() != null) {
                    defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(aY());
                    if (aY() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.am = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (aZ() != null) {
                    defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(aZ());
                    if (aZ() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.au = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (ba() != null) {
                    VideoShareModel videoShareModel = (VideoShareModel) graphQLModelMutatingVisitor.b(ba());
                    if (ba() != videoShareModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aw = videoShareModel;
                    }
                }
                if (bb() != null) {
                    VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) graphQLModelMutatingVisitor.b(bb());
                    if (bb() != visibilitySentenceModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aA = visibilitySentenceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9739a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9745b());
                int a2 = ModelHelper.a(flatBufferBuilder, aB());
                int a3 = ModelHelper.a(flatBufferBuilder, aC());
                int c = flatBufferBuilder.c(jg_());
                int a4 = ModelHelper.a(flatBufferBuilder, aD());
                int a5 = flatBufferBuilder.a(jh_());
                int c2 = flatBufferBuilder.c(m9752m());
                int a6 = ModelHelper.a(flatBufferBuilder, aE());
                int a7 = ModelHelper.a(flatBufferBuilder, mo591p());
                int d = flatBufferBuilder.d(m9757r());
                int a8 = ModelHelper.a(flatBufferBuilder, aF());
                int b = flatBufferBuilder.b(mo593v());
                int a9 = flatBufferBuilder.a(m9762w());
                int a10 = ModelHelper.a(flatBufferBuilder, aG());
                int a11 = ModelHelper.a(flatBufferBuilder, aH());
                int b2 = flatBufferBuilder.b(mo572C());
                int a12 = ModelHelper.a(flatBufferBuilder, aI());
                int a13 = ModelHelper.a(flatBufferBuilder, aJ());
                int a14 = ModelHelper.a(flatBufferBuilder, aK());
                int a15 = ModelHelper.a(flatBufferBuilder, aL());
                int a16 = ModelHelper.a(flatBufferBuilder, aM());
                int a17 = ModelHelper.a(flatBufferBuilder, aN());
                int a18 = ModelHelper.a(flatBufferBuilder, aO());
                int a19 = flatBufferBuilder.a(m9732T());
                int b3 = flatBufferBuilder.b(m9734V());
                int a20 = ModelHelper.a(flatBufferBuilder, aP());
                int b4 = flatBufferBuilder.b(mo563k());
                int a21 = ModelHelper.a(flatBufferBuilder, aQ());
                int a22 = ModelHelper.a(flatBufferBuilder, aR());
                int a23 = ModelHelper.a(flatBufferBuilder, aS());
                int a24 = ModelHelper.a(flatBufferBuilder, aT());
                int a25 = ModelHelper.a(flatBufferBuilder, aU());
                int a26 = flatBufferBuilder.a(ac());
                int b5 = flatBufferBuilder.b(af());
                int b6 = flatBufferBuilder.b(ag());
                int a27 = ModelHelper.a(flatBufferBuilder, aV());
                int b7 = flatBufferBuilder.b(ai());
                int a28 = ModelHelper.a(flatBufferBuilder, aW());
                int a29 = ModelHelper.a(flatBufferBuilder, aX());
                int a30 = ModelHelper.a(flatBufferBuilder, aY());
                int b8 = flatBufferBuilder.b(ao());
                int b9 = flatBufferBuilder.b(ap());
                int b10 = flatBufferBuilder.b(as());
                int a31 = ModelHelper.a(flatBufferBuilder, aZ());
                int b11 = flatBufferBuilder.b(au());
                int a32 = ModelHelper.a(flatBufferBuilder, ba());
                int a33 = flatBufferBuilder.a(aw());
                int a34 = flatBufferBuilder.a(ax());
                int a35 = flatBufferBuilder.a(ay());
                int a36 = ModelHelper.a(flatBufferBuilder, bb());
                flatBufferBuilder.c(77);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, c);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.a(6, this.f8539j);
                flatBufferBuilder.a(7, this.f8540k);
                flatBufferBuilder.b(8, c2);
                flatBufferBuilder.b(9, a6);
                flatBufferBuilder.a(10, this.f8543n, 0);
                flatBufferBuilder.b(11, a7);
                flatBufferBuilder.a(12, this.f8545p, 0);
                flatBufferBuilder.b(13, d);
                flatBufferBuilder.a(14, this.f8547r);
                flatBufferBuilder.b(15, a8);
                flatBufferBuilder.a(16, this.f8549t);
                flatBufferBuilder.b(17, b);
                flatBufferBuilder.b(18, a9);
                flatBufferBuilder.b(19, a10);
                flatBufferBuilder.b(20, a11);
                flatBufferBuilder.a(21, this.f8554y);
                flatBufferBuilder.a(22, this.f8555z);
                flatBufferBuilder.a(23, this.f8507A, 0);
                flatBufferBuilder.b(24, b2);
                flatBufferBuilder.b(25, a12);
                flatBufferBuilder.b(26, a13);
                flatBufferBuilder.b(27, a14);
                flatBufferBuilder.a(28, this.f8512F, 0);
                flatBufferBuilder.a(29, this.f8513G, 0);
                flatBufferBuilder.a(30, this.f8514H, 0);
                flatBufferBuilder.a(31, this.f8515I);
                flatBufferBuilder.a(32, this.f8516J);
                flatBufferBuilder.a(33, this.f8517K);
                flatBufferBuilder.a(34, this.f8518L);
                flatBufferBuilder.a(35, this.f8519M);
                flatBufferBuilder.b(36, a15);
                flatBufferBuilder.a(37, this.f8521O, 0);
                flatBufferBuilder.b(38, a16);
                flatBufferBuilder.a(39, this.f8523Q, 0);
                flatBufferBuilder.b(40, a17);
                flatBufferBuilder.b(41, a18);
                flatBufferBuilder.b(42, a19);
                flatBufferBuilder.a(43, this.f8527U, 0);
                flatBufferBuilder.b(44, b3);
                flatBufferBuilder.b(45, a20);
                flatBufferBuilder.b(46, b4);
                flatBufferBuilder.b(47, a21);
                flatBufferBuilder.b(48, a22);
                flatBufferBuilder.b(49, a23);
                flatBufferBuilder.b(50, a24);
                flatBufferBuilder.b(51, a25);
                flatBufferBuilder.b(52, a26);
                flatBufferBuilder.a(53, this.ae, 0);
                flatBufferBuilder.a(54, this.af, 0);
                flatBufferBuilder.b(55, b5);
                flatBufferBuilder.b(56, b6);
                flatBufferBuilder.b(57, a27);
                flatBufferBuilder.b(58, b7);
                flatBufferBuilder.b(59, a28);
                flatBufferBuilder.b(60, a29);
                flatBufferBuilder.b(61, a30);
                flatBufferBuilder.a(62, this.an, 0.0d);
                flatBufferBuilder.a(63, this.ao, 0.0d);
                flatBufferBuilder.b(64, b8);
                flatBufferBuilder.b(65, b9);
                flatBufferBuilder.a(66, this.ar, 0);
                flatBufferBuilder.a(67, this.as);
                flatBufferBuilder.b(68, b10);
                flatBufferBuilder.b(69, a31);
                flatBufferBuilder.b(70, b11);
                flatBufferBuilder.b(71, a32);
                flatBufferBuilder.b(72, a33);
                flatBufferBuilder.b(73, a34);
                flatBufferBuilder.b(74, a35);
                flatBufferBuilder.b(75, a36);
                flatBufferBuilder.a(76, this.aB, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9742a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8539j = mutableFlatBuffer.a(i, 6);
                this.f8540k = mutableFlatBuffer.a(i, 7);
                this.f8543n = mutableFlatBuffer.a(i, 10, 0);
                this.f8545p = mutableFlatBuffer.a(i, 12, 0);
                this.f8547r = mutableFlatBuffer.a(i, 14);
                this.f8549t = mutableFlatBuffer.a(i, 16);
                this.f8554y = mutableFlatBuffer.a(i, 21);
                this.f8555z = mutableFlatBuffer.a(i, 22);
                this.f8507A = mutableFlatBuffer.a(i, 23, 0);
                this.f8512F = mutableFlatBuffer.a(i, 28, 0);
                this.f8513G = mutableFlatBuffer.a(i, 29, 0);
                this.f8514H = mutableFlatBuffer.a(i, 30, 0);
                this.f8515I = mutableFlatBuffer.a(i, 31);
                this.f8516J = mutableFlatBuffer.a(i, 32);
                this.f8517K = mutableFlatBuffer.a(i, 33);
                this.f8518L = mutableFlatBuffer.a(i, 34);
                this.f8519M = mutableFlatBuffer.a(i, 35);
                this.f8521O = mutableFlatBuffer.a(i, 37, 0);
                this.f8523Q = mutableFlatBuffer.a(i, 39, 0);
                this.f8527U = mutableFlatBuffer.a(i, 43, 0);
                this.ae = mutableFlatBuffer.a(i, 53, 0);
                this.af = mutableFlatBuffer.a(i, 54, 0);
                this.an = mutableFlatBuffer.a(i, 62, 0.0d);
                this.ao = mutableFlatBuffer.a(i, 63, 0.0d);
                this.ar = mutableFlatBuffer.a(i, 66, 0);
                this.as = mutableFlatBuffer.a(i, 67);
                this.aB = mutableFlatBuffer.a(i, 76, 0);
            }
        }

        /* compiled from: module_role */
        public class Serializer extends JsonSerializer<SearchResultsEdgeModel> {
            public final void m9766a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsEdgeModel searchResultsEdgeModel = (SearchResultsEdgeModel) obj;
                if (searchResultsEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsEdgeModel.m9768a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsEdgeParser.m9797b(searchResultsEdgeModel.w_(), searchResultsEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NodeModel m9770a() {
            return m9774j();
        }

        @Nullable
        public final /* synthetic */ SearchResultsDecorationModel m9771b() {
            return m9775k();
        }

        public SearchResultsEdgeModel() {
            super(4);
        }

        public SearchResultsEdgeModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final NodeModel m9774j() {
            this.f8556d = (NodeModel) super.a(this.f8556d, 0, NodeModel.class);
            return this.f8556d;
        }

        @Nullable
        public final SearchResultsDecorationModel m9775k() {
            this.f8557e = (SearchResultsDecorationModel) super.a(this.f8557e, 1, SearchResultsDecorationModel.class);
            return this.f8557e;
        }

        @Nonnull
        public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m9772c() {
            this.f8558f = super.c(this.f8558f, 2, GraphQLGraphSearchResultsDisplayStyle.class);
            return (ImmutableList) this.f8558f;
        }

        @Nullable
        public final GraphQLGraphSearchResultRole m9773d() {
            this.f8559g = (GraphQLGraphSearchResultRole) super.b(this.f8559g, 3, GraphQLGraphSearchResultRole.class, GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8559g;
        }

        public static SearchResultsEdgeModel m9767a(SearchResultsEdgeModel searchResultsEdgeModel) {
            if (searchResultsEdgeModel == null) {
                return null;
            }
            if (searchResultsEdgeModel instanceof SearchResultsEdgeModel) {
                return searchResultsEdgeModel;
            }
            Builder builder = new Builder();
            builder.f8320a = NodeModel.m9712a(searchResultsEdgeModel.m9770a());
            builder.f8321b = SearchResultsDecorationModel.m9854a(searchResultsEdgeModel.m9771b());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < searchResultsEdgeModel.m9772c().size(); i++) {
                builder2.c(searchResultsEdgeModel.m9772c().get(i));
            }
            builder.f8322c = builder2.b();
            builder.f8323d = searchResultsEdgeModel.m9773d();
            return builder.m9577a();
        }

        public final int jK_() {
            return 1314118566;
        }

        public final GraphQLVisitableModel m9769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9774j() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m9774j());
                if (m9774j() != nodeModel) {
                    graphQLVisitableModel = (SearchResultsEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8556d = nodeModel;
                }
            }
            if (m9775k() != null) {
                SearchResultsDecorationModel searchResultsDecorationModel = (SearchResultsDecorationModel) graphQLModelMutatingVisitor.b(m9775k());
                if (m9775k() != searchResultsDecorationModel) {
                    graphQLVisitableModel = (SearchResultsEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8557e = searchResultsDecorationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9768a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9774j());
            int a2 = ModelHelper.a(flatBufferBuilder, m9775k());
            int d = flatBufferBuilder.d(m9772c());
            int a3 = flatBufferBuilder.a(m9773d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, d);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
