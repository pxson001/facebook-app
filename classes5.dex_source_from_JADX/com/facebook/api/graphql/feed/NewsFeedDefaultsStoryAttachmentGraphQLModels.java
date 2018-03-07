package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLModels.NewsFeedDefaultsStoryActionLinkFieldsModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.AttachmentPropertiesModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.SourceModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.StyleInfosModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.TargetModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLModels.AttachmentMediaModel.CreationStoryModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLModels.AttachmentMediaModel.OwnerModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLModels.AttachmentMediaModel.PairedVideoModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLModels.Photo360FieldsModel.PhotoEncodingsModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsStoryAttachmentGraphQLParsers.StoryAttachmentFieldsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsStoryAttachmentGraphQLParsers.StoryAttachmentFieldsParser.MediaParser;
import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLModels.NewsFeedDefaultsFeedbackModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.AttributionAppMediaMetadataModel.AttributionAppModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.VideoChannelIdForVideoFragmentModel.VideoChannelModel;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLModels.AppStoreApplicationFragmentModel;
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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: api_contacts_upload */
public class NewsFeedDefaultsStoryAttachmentGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 317138471)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: api_contacts_upload */
    public final class StoryAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<NewsFeedDefaultsStoryActionLinkFieldsModel> f9452d;
        @Nullable
        private AppStoreApplicationFragmentModel f9453e;
        @Nullable
        private List<AttachmentPropertiesModel> f9454f;
        @Nullable
        private String f9455g;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9456h;
        @Nullable
        private MediaModel f9457i;
        @Nullable
        private String f9458j;
        @Nullable
        private SourceModel f9459k;
        @Nullable
        private List<StyleInfosModel> f9460l;
        @Nullable
        private List<GraphQLStoryAttachmentStyle> f9461m;
        @Nullable
        private String f9462n;
        @Nullable
        private TargetModel f9463o;
        @Nullable
        private String f9464p;
        @Nullable
        private String f9465q;
        @Nullable
        private String f9466r;

        /* compiled from: api_contacts_upload */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m16075a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StoryAttachmentFieldsParser.m16138b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object storyAttachmentFieldsModel = new StoryAttachmentFieldsModel();
                ((BaseModel) storyAttachmentFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (storyAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) storyAttachmentFieldsModel).a();
                }
                return storyAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -678068172)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api_contacts_upload */
        public final class MediaModel extends BaseModel implements NewsFeedDefaultsMediaGraphQLInterfaces$AttachmentMedia, GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private DefaultImageFieldsModel f9403A;
            @Nullable
            private DefaultImageFieldsModel f9404B;
            @Nullable
            private DefaultImageFieldsModel f9405C;
            @Nullable
            private DefaultImageFieldsModel f9406D;
            @Nullable
            private DefaultImageFieldsModel f9407E;
            @Nullable
            private DefaultImageFieldsModel f9408F;
            private int f9409G;
            private int f9410H;
            private int f9411I;
            private boolean f9412J;
            private boolean f9413K;
            private boolean f9414L;
            private boolean f9415M;
            private boolean f9416N;
            private boolean f9417O;
            private boolean f9418P;
            private boolean f9419Q;
            private boolean f9420R;
            private int f9421S;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f9422T;
            @Nullable
            private OwnerModel f9423U;
            @Nullable
            private PairedVideoModel f9424V;
            @Nullable
            private List<PhotoEncodingsModel> f9425W;
            private int f9426X;
            @Nullable
            private String f9427Y;
            @Nullable
            private String f9428Z;
            private int aa;
            @Nullable
            private String ab;
            @Nullable
            private String ac;
            private int ad;
            @Nullable
            private String ae;
            @Nullable
            private String af;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel ag;
            private boolean ah;
            private boolean ai;
            private boolean aj;
            private boolean ak;
            private double al;
            private double am;
            @Nullable
            private String an;
            @Nullable
            private String ao;
            private int ap;
            private boolean aq;
            private int ar;
            @Nullable
            private List<String> as;
            @Nullable
            private VideoChannelModel at;
            private int au;
            @Nullable
            private GraphQLVideoStatusType av;
            private int aw;
            @Nullable
            private GraphQLObjectType f9429d;
            @Nullable
            private String f9430e;
            @Nullable
            private DefaultImageFieldsModel f9431f;
            private int f9432g;
            @Nullable
            private AttributionAppModel f9433h;
            @Nullable
            private String f9434i;
            private int f9435j;
            @Nullable
            private GraphQLVideoBroadcastStatus f9436k;
            private boolean f9437l;
            private boolean f9438m;
            private boolean f9439n;
            private boolean f9440o;
            @Nullable
            private String f9441p;
            private long f9442q;
            @Nullable
            private CreationStoryModel f9443r;
            @Nullable
            private NewsFeedDefaultsFeedbackModel f9444s;
            @Nullable
            private DefaultVect2FieldsModel f9445t;
            @Nullable
            private GuidedTourModel f9446u;
            private boolean f9447v;
            private int f9448w;
            private int f9449x;
            private int f9450y;
            @Nullable
            private String f9451z;

            /* compiled from: api_contacts_upload */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m16076a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaParser.m16136a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaModel = new MediaModel();
                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaModel).a();
                    }
                    return mediaModel;
                }
            }

            /* compiled from: api_contacts_upload */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m16077a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m16110a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaParser.m16137a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bc_() {
                return m16107x();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bd_() {
                return m16106w();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields be_() {
                return m16103t();
            }

            @Nullable
            public final /* synthetic */ DefaultVect2Fields m16115c() {
                return m16101r();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m16117g() {
                return m16104u();
            }

            public MediaModel() {
                super(72);
            }

            @Nullable
            public final GraphQLObjectType m16114b() {
                if (this.b != null && this.f9429d == null) {
                    this.f9429d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9429d;
            }

            @Nullable
            private String m16093j() {
                this.f9430e = super.a(this.f9430e, 1);
                return this.f9430e;
            }

            @Nullable
            private DefaultImageFieldsModel m16094k() {
                this.f9431f = (DefaultImageFieldsModel) super.a(this.f9431f, 2, DefaultImageFieldsModel.class);
                return this.f9431f;
            }

            @Nullable
            private AttributionAppModel m16095l() {
                this.f9433h = (AttributionAppModel) super.a(this.f9433h, 4, AttributionAppModel.class);
                return this.f9433h;
            }

            @Nullable
            private String m16096m() {
                this.f9434i = super.a(this.f9434i, 5);
                return this.f9434i;
            }

            @Nullable
            private GraphQLVideoBroadcastStatus m16097n() {
                this.f9436k = (GraphQLVideoBroadcastStatus) super.b(this.f9436k, 7, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9436k;
            }

            @Nullable
            private String m16098o() {
                this.f9441p = super.a(this.f9441p, 12);
                return this.f9441p;
            }

            @Nullable
            private CreationStoryModel m16099p() {
                this.f9443r = (CreationStoryModel) super.a(this.f9443r, 14, CreationStoryModel.class);
                return this.f9443r;
            }

            @Nullable
            private NewsFeedDefaultsFeedbackModel m16100q() {
                this.f9444s = (NewsFeedDefaultsFeedbackModel) super.a(this.f9444s, 15, NewsFeedDefaultsFeedbackModel.class);
                return this.f9444s;
            }

            @Nullable
            private DefaultVect2FieldsModel m16101r() {
                this.f9445t = (DefaultVect2FieldsModel) super.a(this.f9445t, 16, DefaultVect2FieldsModel.class);
                return this.f9445t;
            }

            @Nullable
            private GuidedTourModel m16102s() {
                this.f9446u = (GuidedTourModel) super.a(this.f9446u, 17, GuidedTourModel.class);
                return this.f9446u;
            }

            @Nullable
            public final String m16116d() {
                this.f9451z = super.a(this.f9451z, 22);
                return this.f9451z;
            }

            @Nullable
            private DefaultImageFieldsModel m16103t() {
                this.f9403A = (DefaultImageFieldsModel) super.a(this.f9403A, 23, DefaultImageFieldsModel.class);
                return this.f9403A;
            }

            @Nullable
            private DefaultImageFieldsModel m16104u() {
                this.f9404B = (DefaultImageFieldsModel) super.a(this.f9404B, 24, DefaultImageFieldsModel.class);
                return this.f9404B;
            }

            @Nullable
            private DefaultImageFieldsModel m16105v() {
                this.f9405C = (DefaultImageFieldsModel) super.a(this.f9405C, 25, DefaultImageFieldsModel.class);
                return this.f9405C;
            }

            @Nullable
            private DefaultImageFieldsModel m16106w() {
                this.f9406D = (DefaultImageFieldsModel) super.a(this.f9406D, 26, DefaultImageFieldsModel.class);
                return this.f9406D;
            }

            @Nullable
            private DefaultImageFieldsModel m16107x() {
                this.f9407E = (DefaultImageFieldsModel) super.a(this.f9407E, 27, DefaultImageFieldsModel.class);
                return this.f9407E;
            }

            @Nullable
            private DefaultImageFieldsModel m16108y() {
                this.f9408F = (DefaultImageFieldsModel) super.a(this.f9408F, 28, DefaultImageFieldsModel.class);
                return this.f9408F;
            }

            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel m16109z() {
                this.f9422T = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9422T, 42, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f9422T;
            }

            @Nullable
            private OwnerModel m16078A() {
                this.f9423U = (OwnerModel) super.a(this.f9423U, 43, OwnerModel.class);
                return this.f9423U;
            }

            @Nullable
            private PairedVideoModel m16079B() {
                this.f9424V = (PairedVideoModel) super.a(this.f9424V, 44, PairedVideoModel.class);
                return this.f9424V;
            }

            @Nonnull
            private ImmutableList<PhotoEncodingsModel> m16080C() {
                this.f9425W = super.a(this.f9425W, 45, PhotoEncodingsModel.class);
                return (ImmutableList) this.f9425W;
            }

            @Nullable
            private String m16081D() {
                this.f9427Y = super.a(this.f9427Y, 47);
                return this.f9427Y;
            }

            @Nullable
            private String m16082E() {
                this.f9428Z = super.a(this.f9428Z, 48);
                return this.f9428Z;
            }

            @Nullable
            private String m16083F() {
                this.ab = super.a(this.ab, 50);
                return this.ab;
            }

            @Nullable
            private String m16084G() {
                this.ac = super.a(this.ac, 51);
                return this.ac;
            }

            @Nullable
            private String m16085H() {
                this.ae = super.a(this.ae, 53);
                return this.ae;
            }

            @Nullable
            private String m16086I() {
                this.af = super.a(this.af, 54);
                return this.af;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m16087J() {
                this.ag = (DefaultTextWithEntitiesFieldsModel) super.a(this.ag, 55, DefaultTextWithEntitiesFieldsModel.class);
                return this.ag;
            }

            @Nullable
            private String m16088K() {
                this.an = super.a(this.an, 62);
                return this.an;
            }

            @Nullable
            private String m16089L() {
                this.ao = super.a(this.ao, 63);
                return this.ao;
            }

            @Nonnull
            private ImmutableList<String> m16090M() {
                this.as = super.a(this.as, 67);
                return (ImmutableList) this.as;
            }

            @Nullable
            private VideoChannelModel m16091N() {
                this.at = (VideoChannelModel) super.a(this.at, 68, VideoChannelModel.class);
                return this.at;
            }

            @Nullable
            private GraphQLVideoStatusType m16092O() {
                this.av = (GraphQLVideoStatusType) super.b(this.av, 70, GraphQLVideoStatusType.class, GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.av;
            }

            @Nullable
            public final String m16112a() {
                return m16116d();
            }

            public final int jK_() {
                return 74219460;
            }

            public final GraphQLVisitableModel m16111a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16094k() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16094k());
                    if (m16094k() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9431f = defaultImageFieldsModel;
                    }
                }
                if (m16095l() != null) {
                    AttributionAppModel attributionAppModel = (AttributionAppModel) graphQLModelMutatingVisitor.b(m16095l());
                    if (m16095l() != attributionAppModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9433h = attributionAppModel;
                    }
                }
                if (m16099p() != null) {
                    CreationStoryModel creationStoryModel = (CreationStoryModel) graphQLModelMutatingVisitor.b(m16099p());
                    if (m16099p() != creationStoryModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9443r = creationStoryModel;
                    }
                }
                if (m16100q() != null) {
                    NewsFeedDefaultsFeedbackModel newsFeedDefaultsFeedbackModel = (NewsFeedDefaultsFeedbackModel) graphQLModelMutatingVisitor.b(m16100q());
                    if (m16100q() != newsFeedDefaultsFeedbackModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9444s = newsFeedDefaultsFeedbackModel;
                    }
                }
                if (m16101r() != null) {
                    DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m16101r());
                    if (m16101r() != defaultVect2FieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9445t = defaultVect2FieldsModel;
                    }
                }
                if (m16102s() != null) {
                    GuidedTourModel guidedTourModel = (GuidedTourModel) graphQLModelMutatingVisitor.b(m16102s());
                    if (m16102s() != guidedTourModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9446u = guidedTourModel;
                    }
                }
                if (m16103t() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16103t());
                    if (m16103t() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9403A = defaultImageFieldsModel;
                    }
                }
                if (m16104u() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16104u());
                    if (m16104u() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9404B = defaultImageFieldsModel;
                    }
                }
                if (m16105v() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16105v());
                    if (m16105v() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9405C = defaultImageFieldsModel;
                    }
                }
                if (m16106w() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16106w());
                    if (m16106w() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9406D = defaultImageFieldsModel;
                    }
                }
                if (m16107x() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16107x());
                    if (m16107x() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9407E = defaultImageFieldsModel;
                    }
                }
                if (m16108y() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16108y());
                    if (m16108y() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9408F = defaultImageFieldsModel;
                    }
                }
                if (m16109z() != null) {
                    DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16109z());
                    if (m16109z() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9422T = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (m16078A() != null) {
                    OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m16078A());
                    if (m16078A() != ownerModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9423U = ownerModel;
                    }
                }
                if (m16079B() != null) {
                    PairedVideoModel pairedVideoModel = (PairedVideoModel) graphQLModelMutatingVisitor.b(m16079B());
                    if (m16079B() != pairedVideoModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9424V = pairedVideoModel;
                    }
                }
                if (m16080C() != null) {
                    Builder a = ModelHelper.a(m16080C(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MediaModel mediaModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        mediaModel.f9425W = a.b();
                        graphQLVisitableModel = mediaModel;
                    }
                }
                if (m16087J() != null) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m16087J());
                    if (m16087J() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ag = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m16091N() != null) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m16091N());
                    if (m16091N() != videoChannelModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.at = videoChannelModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16110a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16114b());
                int b = flatBufferBuilder.b(m16093j());
                int a2 = ModelHelper.a(flatBufferBuilder, m16094k());
                int a3 = ModelHelper.a(flatBufferBuilder, m16095l());
                int b2 = flatBufferBuilder.b(m16096m());
                int a4 = flatBufferBuilder.a(m16097n());
                int b3 = flatBufferBuilder.b(m16098o());
                int a5 = ModelHelper.a(flatBufferBuilder, m16099p());
                int a6 = ModelHelper.a(flatBufferBuilder, m16100q());
                int a7 = ModelHelper.a(flatBufferBuilder, m16101r());
                int a8 = ModelHelper.a(flatBufferBuilder, m16102s());
                int b4 = flatBufferBuilder.b(m16116d());
                int a9 = ModelHelper.a(flatBufferBuilder, m16103t());
                int a10 = ModelHelper.a(flatBufferBuilder, m16104u());
                int a11 = ModelHelper.a(flatBufferBuilder, m16105v());
                int a12 = ModelHelper.a(flatBufferBuilder, m16106w());
                int a13 = ModelHelper.a(flatBufferBuilder, m16107x());
                int a14 = ModelHelper.a(flatBufferBuilder, m16108y());
                int a15 = ModelHelper.a(flatBufferBuilder, m16109z());
                int a16 = ModelHelper.a(flatBufferBuilder, m16078A());
                int a17 = ModelHelper.a(flatBufferBuilder, m16079B());
                int a18 = ModelHelper.a(flatBufferBuilder, m16080C());
                int b5 = flatBufferBuilder.b(m16081D());
                int b6 = flatBufferBuilder.b(m16082E());
                int b7 = flatBufferBuilder.b(m16083F());
                int b8 = flatBufferBuilder.b(m16084G());
                int b9 = flatBufferBuilder.b(m16085H());
                int b10 = flatBufferBuilder.b(m16086I());
                int a19 = ModelHelper.a(flatBufferBuilder, m16087J());
                int b11 = flatBufferBuilder.b(m16088K());
                int b12 = flatBufferBuilder.b(m16089L());
                int c = flatBufferBuilder.c(m16090M());
                int a20 = ModelHelper.a(flatBufferBuilder, m16091N());
                int a21 = flatBufferBuilder.a(m16092O());
                flatBufferBuilder.c(72);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.a(3, this.f9432g, 0);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.a(6, this.f9435j, 0);
                flatBufferBuilder.b(7, a4);
                flatBufferBuilder.a(8, this.f9437l);
                flatBufferBuilder.a(9, this.f9438m);
                flatBufferBuilder.a(10, this.f9439n);
                flatBufferBuilder.a(11, this.f9440o);
                flatBufferBuilder.b(12, b3);
                flatBufferBuilder.a(13, this.f9442q, 0);
                flatBufferBuilder.b(14, a5);
                flatBufferBuilder.b(15, a6);
                flatBufferBuilder.b(16, a7);
                flatBufferBuilder.b(17, a8);
                flatBufferBuilder.a(18, this.f9447v);
                flatBufferBuilder.a(19, this.f9448w, 0);
                flatBufferBuilder.a(20, this.f9449x, 0);
                flatBufferBuilder.a(21, this.f9450y, 0);
                flatBufferBuilder.b(22, b4);
                flatBufferBuilder.b(23, a9);
                flatBufferBuilder.b(24, a10);
                flatBufferBuilder.b(25, a11);
                flatBufferBuilder.b(26, a12);
                flatBufferBuilder.b(27, a13);
                flatBufferBuilder.b(28, a14);
                flatBufferBuilder.a(29, this.f9409G, 0);
                flatBufferBuilder.a(30, this.f9410H, 0);
                flatBufferBuilder.a(31, this.f9411I, 0);
                flatBufferBuilder.a(32, this.f9412J);
                flatBufferBuilder.a(33, this.f9413K);
                flatBufferBuilder.a(34, this.f9414L);
                flatBufferBuilder.a(35, this.f9415M);
                flatBufferBuilder.a(36, this.f9416N);
                flatBufferBuilder.a(37, this.f9417O);
                flatBufferBuilder.a(38, this.f9418P);
                flatBufferBuilder.a(39, this.f9419Q);
                flatBufferBuilder.a(40, this.f9420R);
                flatBufferBuilder.a(41, this.f9421S, 0);
                flatBufferBuilder.b(42, a15);
                flatBufferBuilder.b(43, a16);
                flatBufferBuilder.b(44, a17);
                flatBufferBuilder.b(45, a18);
                flatBufferBuilder.a(46, this.f9426X, 0);
                flatBufferBuilder.b(47, b5);
                flatBufferBuilder.b(48, b6);
                flatBufferBuilder.a(49, this.aa, 0);
                flatBufferBuilder.b(50, b7);
                flatBufferBuilder.b(51, b8);
                flatBufferBuilder.a(52, this.ad, 0);
                flatBufferBuilder.b(53, b9);
                flatBufferBuilder.b(54, b10);
                flatBufferBuilder.b(55, a19);
                flatBufferBuilder.a(56, this.ah);
                flatBufferBuilder.a(57, this.ai);
                flatBufferBuilder.a(58, this.aj);
                flatBufferBuilder.a(59, this.ak);
                flatBufferBuilder.a(60, this.al, 0.0d);
                flatBufferBuilder.a(61, this.am, 0.0d);
                flatBufferBuilder.b(62, b11);
                flatBufferBuilder.b(63, b12);
                flatBufferBuilder.a(64, this.ap, 0);
                flatBufferBuilder.a(65, this.aq);
                flatBufferBuilder.a(66, this.ar, 0);
                flatBufferBuilder.b(67, c);
                flatBufferBuilder.b(68, a20);
                flatBufferBuilder.a(69, this.au, 0);
                flatBufferBuilder.b(70, a21);
                flatBufferBuilder.a(71, this.aw, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16113a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9432g = mutableFlatBuffer.a(i, 3, 0);
                this.f9435j = mutableFlatBuffer.a(i, 6, 0);
                this.f9437l = mutableFlatBuffer.a(i, 8);
                this.f9438m = mutableFlatBuffer.a(i, 9);
                this.f9439n = mutableFlatBuffer.a(i, 10);
                this.f9440o = mutableFlatBuffer.a(i, 11);
                this.f9442q = mutableFlatBuffer.a(i, 13, 0);
                this.f9447v = mutableFlatBuffer.a(i, 18);
                this.f9448w = mutableFlatBuffer.a(i, 19, 0);
                this.f9449x = mutableFlatBuffer.a(i, 20, 0);
                this.f9450y = mutableFlatBuffer.a(i, 21, 0);
                this.f9409G = mutableFlatBuffer.a(i, 29, 0);
                this.f9410H = mutableFlatBuffer.a(i, 30, 0);
                this.f9411I = mutableFlatBuffer.a(i, 31, 0);
                this.f9412J = mutableFlatBuffer.a(i, 32);
                this.f9413K = mutableFlatBuffer.a(i, 33);
                this.f9414L = mutableFlatBuffer.a(i, 34);
                this.f9415M = mutableFlatBuffer.a(i, 35);
                this.f9416N = mutableFlatBuffer.a(i, 36);
                this.f9417O = mutableFlatBuffer.a(i, 37);
                this.f9418P = mutableFlatBuffer.a(i, 38);
                this.f9419Q = mutableFlatBuffer.a(i, 39);
                this.f9420R = mutableFlatBuffer.a(i, 40);
                this.f9421S = mutableFlatBuffer.a(i, 41, 0);
                this.f9426X = mutableFlatBuffer.a(i, 46, 0);
                this.aa = mutableFlatBuffer.a(i, 49, 0);
                this.ad = mutableFlatBuffer.a(i, 52, 0);
                this.ah = mutableFlatBuffer.a(i, 56);
                this.ai = mutableFlatBuffer.a(i, 57);
                this.aj = mutableFlatBuffer.a(i, 58);
                this.ak = mutableFlatBuffer.a(i, 59);
                this.al = mutableFlatBuffer.a(i, 60, 0.0d);
                this.am = mutableFlatBuffer.a(i, 61, 0.0d);
                this.ap = mutableFlatBuffer.a(i, 64, 0);
                this.aq = mutableFlatBuffer.a(i, 65);
                this.ar = mutableFlatBuffer.a(i, 66, 0);
                this.au = mutableFlatBuffer.a(i, 69, 0);
                this.aw = mutableFlatBuffer.a(i, 71, 0);
            }
        }

        /* compiled from: api_contacts_upload */
        public class Serializer extends JsonSerializer<StoryAttachmentFieldsModel> {
            public final void m16118a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StoryAttachmentFieldsModel storyAttachmentFieldsModel = (StoryAttachmentFieldsModel) obj;
                if (storyAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyAttachmentFieldsModel.m16134a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StoryAttachmentFieldsParser.m16139b(storyAttachmentFieldsModel.w_(), storyAttachmentFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StoryAttachmentFieldsModel.class, new Serializer());
            }
        }

        public StoryAttachmentFieldsModel() {
            super(15);
        }

        @Nonnull
        private ImmutableList<NewsFeedDefaultsStoryActionLinkFieldsModel> m16119a() {
            this.f9452d = super.a(this.f9452d, 0, NewsFeedDefaultsStoryActionLinkFieldsModel.class);
            return (ImmutableList) this.f9452d;
        }

        @Nullable
        private AppStoreApplicationFragmentModel m16120j() {
            this.f9453e = (AppStoreApplicationFragmentModel) super.a(this.f9453e, 1, AppStoreApplicationFragmentModel.class);
            return this.f9453e;
        }

        @Nonnull
        private ImmutableList<AttachmentPropertiesModel> m16121k() {
            this.f9454f = super.a(this.f9454f, 2, AttachmentPropertiesModel.class);
            return (ImmutableList) this.f9454f;
        }

        @Nullable
        private String m16122l() {
            this.f9455g = super.a(this.f9455g, 3);
            return this.f9455g;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m16123m() {
            this.f9456h = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9456h, 4, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9456h;
        }

        @Nullable
        private MediaModel m16124n() {
            this.f9457i = (MediaModel) super.a(this.f9457i, 5, MediaModel.class);
            return this.f9457i;
        }

        @Nullable
        private String m16125o() {
            this.f9458j = super.a(this.f9458j, 6);
            return this.f9458j;
        }

        @Nullable
        private SourceModel m16126p() {
            this.f9459k = (SourceModel) super.a(this.f9459k, 7, SourceModel.class);
            return this.f9459k;
        }

        @Nonnull
        private ImmutableList<StyleInfosModel> m16127q() {
            this.f9460l = super.a(this.f9460l, 8, StyleInfosModel.class);
            return (ImmutableList) this.f9460l;
        }

        @Nonnull
        private ImmutableList<GraphQLStoryAttachmentStyle> m16128r() {
            this.f9461m = super.c(this.f9461m, 9, GraphQLStoryAttachmentStyle.class);
            return (ImmutableList) this.f9461m;
        }

        @Nullable
        private String m16129s() {
            this.f9462n = super.a(this.f9462n, 10);
            return this.f9462n;
        }

        @Nullable
        private TargetModel m16130t() {
            this.f9463o = (TargetModel) super.a(this.f9463o, 11, TargetModel.class);
            return this.f9463o;
        }

        @Nullable
        private String m16131u() {
            this.f9464p = super.a(this.f9464p, 12);
            return this.f9464p;
        }

        @Nullable
        private String m16132v() {
            this.f9465q = super.a(this.f9465q, 13);
            return this.f9465q;
        }

        @Nullable
        private String m16133w() {
            this.f9466r = super.a(this.f9466r, 14);
            return this.f9466r;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m16135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            StoryAttachmentFieldsModel storyAttachmentFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel;
            AppStoreApplicationFragmentModel appStoreApplicationFragmentModel;
            Builder a;
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            MediaModel mediaModel;
            SourceModel sourceModel;
            TargetModel targetModel;
            h();
            if (m16119a() != null) {
                Builder a2 = ModelHelper.a(m16119a(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    storyAttachmentFieldsModel = (StoryAttachmentFieldsModel) ModelHelper.a(null, this);
                    storyAttachmentFieldsModel.f9452d = a2.b();
                    graphQLVisitableModel = storyAttachmentFieldsModel;
                    if (m16120j() != null) {
                        appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m16120j());
                        if (m16120j() != appStoreApplicationFragmentModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9453e = appStoreApplicationFragmentModel;
                        }
                    }
                    if (m16121k() != null) {
                        a = ModelHelper.a(m16121k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            storyAttachmentFieldsModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            storyAttachmentFieldsModel.f9454f = a.b();
                            graphQLVisitableModel = storyAttachmentFieldsModel;
                        }
                    }
                    if (m16123m() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16123m());
                        if (m16123m() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9456h = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m16124n() != null) {
                        mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m16124n());
                        if (m16124n() != mediaModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9457i = mediaModel;
                        }
                    }
                    if (m16126p() != null) {
                        sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m16126p());
                        if (m16126p() != sourceModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9459k = sourceModel;
                        }
                    }
                    if (m16127q() != null) {
                        a = ModelHelper.a(m16127q(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            storyAttachmentFieldsModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            storyAttachmentFieldsModel.f9460l = a.b();
                            graphQLVisitableModel = storyAttachmentFieldsModel;
                        }
                    }
                    if (m16130t() != null) {
                        targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m16130t());
                        if (m16130t() != targetModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9463o = targetModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m16120j() != null) {
                appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m16120j());
                if (m16120j() != appStoreApplicationFragmentModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9453e = appStoreApplicationFragmentModel;
                }
            }
            if (m16121k() != null) {
                a = ModelHelper.a(m16121k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentFieldsModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentFieldsModel.f9454f = a.b();
                    graphQLVisitableModel = storyAttachmentFieldsModel;
                }
            }
            if (m16123m() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16123m());
                if (m16123m() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9456h = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m16124n() != null) {
                mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m16124n());
                if (m16124n() != mediaModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9457i = mediaModel;
                }
            }
            if (m16126p() != null) {
                sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m16126p());
                if (m16126p() != sourceModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9459k = sourceModel;
                }
            }
            if (m16127q() != null) {
                a = ModelHelper.a(m16127q(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentFieldsModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentFieldsModel.f9460l = a.b();
                    graphQLVisitableModel = storyAttachmentFieldsModel;
                }
            }
            if (m16130t() != null) {
                targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m16130t());
                if (m16130t() != targetModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9463o = targetModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m16134a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16119a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16120j());
            int a3 = ModelHelper.a(flatBufferBuilder, m16121k());
            int b = flatBufferBuilder.b(m16122l());
            int a4 = ModelHelper.a(flatBufferBuilder, m16123m());
            int a5 = ModelHelper.a(flatBufferBuilder, m16124n());
            int b2 = flatBufferBuilder.b(m16125o());
            int a6 = ModelHelper.a(flatBufferBuilder, m16126p());
            int a7 = ModelHelper.a(flatBufferBuilder, m16127q());
            int d = flatBufferBuilder.d(m16128r());
            int b3 = flatBufferBuilder.b(m16129s());
            int a8 = ModelHelper.a(flatBufferBuilder, m16130t());
            int b4 = flatBufferBuilder.b(m16131u());
            int b5 = flatBufferBuilder.b(m16132v());
            int b6 = flatBufferBuilder.b(m16133w());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, d);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a8);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, b5);
            flatBufferBuilder.b(14, b6);
            i();
            return flatBufferBuilder.d();
        }
    }
}
