package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFeedUnitDeserializer;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: good_friends_composer */
public final class GraphQLGoodwillThrowbackFeedUnit extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackFeedUnit> CREATOR = new C03531();
    @Nullable
    GraphQLPlace f3940A;
    @Nullable
    GraphQLFeedTopicContent f3941B;
    @Nullable
    GraphQLFeedback f3942C;
    @Nullable
    GraphQLTextWithEntities f3943D;
    @Nullable
    GraphQLGoodwillThrowbackFriendListConnection f3944E;
    @Nullable
    GraphQLGoodwillFriendversaryCampaign f3945F;
    boolean f3946G;
    @Nullable
    String f3947H;
    @Nullable
    String f3948I;
    @Nullable
    GraphQLPlace f3949J;
    @Nullable
    GraphQLInlineActivitiesConnection f3950K;
    @Deprecated
    @Nullable
    String f3951L;
    @Nullable
    GraphQLTextWithEntities f3952M;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f3953N;
    List<GraphQLStoryAttachment> f3954O;
    List<GraphQLStory> f3955P;
    @Nullable
    GraphQLPlaceRecommendationPostInfo f3956Q;
    @Nullable
    GraphQLPrivacyScope f3957R;
    @Nullable
    GraphQLSticker f3958S;
    @Nullable
    GraphQLStorySaveInfo f3959T;
    @Nullable
    GraphQLGoodwillThrowbackSection f3960U;
    @Nullable
    GraphQLEntity f3961V;
    @Nullable
    GraphQLSponsoredData f3962W;
    @Nullable
    GraphQLStoryHeader f3963X;
    List<GraphQLSubstoriesGroupingReason> f3964Y;
    int f3965Z;
    @Nullable
    GraphQLTextWithEntities aa;
    @Nullable
    GraphQLTextWithEntities ab;
    @Nullable
    GraphQLStory ac;
    @Nullable
    GraphQLTextWithEntities ad;
    @Nullable
    GraphQLProfile ae;
    @Nullable
    GraphQLStoryTopicsContext af;
    @Nullable
    String ag;
    @Nullable
    GraphQLPostTranslatability ah;
    @Nullable
    String ai;
    @Nullable
    GraphQLActor aj;
    @Nullable
    GraphQLWithTagsConnection ak;
    @Nullable
    String al;
    List<GraphQLEditPostFeatureCapability> am;
    @Nullable
    GraphQLTextWithEntities an;
    @Nullable
    GraphQLObjectType f3966d;
    @Nullable
    GraphQLImage f3967e;
    List<GraphQLStoryActionLink> f3968f;
    List<GraphQLOpenGraphAction> f3969g;
    List<GraphQLActor> f3970h;
    @Nullable
    GraphQLSubstoriesConnection f3971i;
    @Nullable
    GraphQLGoodwillAnniversaryCampaign f3972j;
    @Nullable
    GraphQLApplication f3973k;
    List<GraphQLStoryActionLink> f3974l;
    @Nullable
    GraphQLStory f3975m;
    List<GraphQLStoryAttachment> f3976n;
    @Nullable
    String f3977o;
    boolean f3978p;
    boolean f3979q;
    boolean f3980r;
    @Deprecated
    boolean f3981s;
    boolean f3982t;
    @Deprecated
    boolean f3983u;
    @Nullable
    GraphQLGoodwillThrowbackPermalinkColorPalette f3984v;
    long f3985w;
    @Nullable
    String f3986x;
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f3987y;
    @Nullable
    GraphQLEditHistoryConnection f3988z;

    /* compiled from: good_friends_composer */
    final class C03531 implements Creator<GraphQLGoodwillThrowbackFeedUnit> {
        C03531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackFeedUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackFeedUnit[i];
        }
    }

    /* compiled from: good_friends_composer */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFeedUnit.class, new Deserializer());
        }

        public Object m7942a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackFeedUnitDeserializer.m5033a(jsonParser, (short) 506);
            Object graphQLGoodwillThrowbackFeedUnit = new GraphQLGoodwillThrowbackFeedUnit();
            ((BaseModel) graphQLGoodwillThrowbackFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackFeedUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackFeedUnit).a();
            }
            return graphQLGoodwillThrowbackFeedUnit;
        }
    }

    /* compiled from: good_friends_composer */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackFeedUnit> {
        public final void m7943a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackFeedUnit graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) obj;
            GraphQLGoodwillThrowbackFeedUnitDeserializer.m5034a(graphQLGoodwillThrowbackFeedUnit.w_(), graphQLGoodwillThrowbackFeedUnit.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFeedUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFeedUnit.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m7974j() {
        if (this.b != null && this.f3966d == null) {
            this.f3966d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f3966d == null || this.f3966d.g() != 0) {
            return this.f3966d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7975k() {
        this.f3967e = (GraphQLImage) super.a(this.f3967e, 1, GraphQLImage.class);
        return this.f3967e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m7976l() {
        this.f3968f = super.a(this.f3968f, 2, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f3968f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLOpenGraphAction> m7977m() {
        this.f3969g = super.a(this.f3969g, 3, GraphQLOpenGraphAction.class);
        return (ImmutableList) this.f3969g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m7978n() {
        this.f3970h = super.a(this.f3970h, 4, GraphQLActor.class);
        return (ImmutableList) this.f3970h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSubstoriesConnection m7979o() {
        this.f3971i = (GraphQLSubstoriesConnection) super.a(this.f3971i, 5, GraphQLSubstoriesConnection.class);
        return this.f3971i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillAnniversaryCampaign m7980p() {
        this.f3972j = (GraphQLGoodwillAnniversaryCampaign) super.a(this.f3972j, 6, GraphQLGoodwillAnniversaryCampaign.class);
        return this.f3972j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m7981q() {
        this.f3973k = (GraphQLApplication) super.a(this.f3973k, 7, GraphQLApplication.class);
        return this.f3973k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m7982r() {
        this.f3974l = super.a(this.f3974l, 8, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f3974l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m7983s() {
        this.f3975m = (GraphQLStory) super.a(this.f3975m, 9, GraphQLStory.class);
        return this.f3975m;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7984t() {
        this.f3976n = super.a(this.f3976n, 10, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3976n;
    }

    @FieldOffset
    @Nullable
    public final String m7985u() {
        this.f3977o = super.a(this.f3977o, 11);
        return this.f3977o;
    }

    @FieldOffset
    public final boolean m7986v() {
        a(1, 4);
        return this.f3978p;
    }

    @FieldOffset
    public final boolean m7987w() {
        a(1, 5);
        return this.f3979q;
    }

    @FieldOffset
    public final boolean m7988x() {
        a(1, 6);
        return this.f3980r;
    }

    @FieldOffset
    public final boolean m7989y() {
        a(1, 7);
        return this.f3981s;
    }

    @FieldOffset
    public final boolean m7990z() {
        a(2, 0);
        return this.f3982t;
    }

    @FieldOffset
    public final boolean m7944A() {
        a(2, 1);
        return this.f3983u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackPermalinkColorPalette m7945B() {
        this.f3984v = (GraphQLGoodwillThrowbackPermalinkColorPalette) super.a(this.f3984v, 18, GraphQLGoodwillThrowbackPermalinkColorPalette.class);
        return this.f3984v;
    }

    @FieldOffset
    public final long m7946C() {
        a(2, 3);
        return this.f3985w;
    }

    @FieldOffset
    @Nullable
    public final String m7947D() {
        this.f3986x = super.a(this.f3986x, 20);
        return this.f3986x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7948E() {
        this.f3987y = (GraphQLTextWithEntities) super.a(this.f3987y, 21, GraphQLTextWithEntities.class);
        return this.f3987y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEditHistoryConnection m7949F() {
        this.f3988z = (GraphQLEditHistoryConnection) super.a(this.f3988z, 22, GraphQLEditHistoryConnection.class);
        return this.f3988z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m7950G() {
        this.f3940A = (GraphQLPlace) super.a(this.f3940A, 23, GraphQLPlace.class);
        return this.f3940A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedTopicContent m7951H() {
        this.f3941B = (GraphQLFeedTopicContent) super.a(this.f3941B, 24, GraphQLFeedTopicContent.class);
        return this.f3941B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m7952I() {
        this.f3942C = (GraphQLFeedback) super.a(this.f3942C, 25, GraphQLFeedback.class);
        return this.f3942C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7953J() {
        this.f3943D = (GraphQLTextWithEntities) super.a(this.f3943D, 26, GraphQLTextWithEntities.class);
        return this.f3943D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackFriendListConnection m7954K() {
        this.f3944E = (GraphQLGoodwillThrowbackFriendListConnection) super.a(this.f3944E, 27, GraphQLGoodwillThrowbackFriendListConnection.class);
        return this.f3944E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillFriendversaryCampaign m7955L() {
        this.f3945F = (GraphQLGoodwillFriendversaryCampaign) super.a(this.f3945F, 28, GraphQLGoodwillFriendversaryCampaign.class);
        return this.f3945F;
    }

    @FieldOffset
    public final boolean m7956M() {
        a(3, 5);
        return this.f3946G;
    }

    @FieldOffset
    @Nullable
    public final String m7957N() {
        this.f3947H = super.a(this.f3947H, 30);
        return this.f3947H;
    }

    @FieldOffset
    @Nullable
    public final String m7958O() {
        this.f3948I = super.a(this.f3948I, 31);
        return this.f3948I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m7959P() {
        this.f3949J = (GraphQLPlace) super.a(this.f3949J, 32, GraphQLPlace.class);
        return this.f3949J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m7960Q() {
        this.f3950K = (GraphQLInlineActivitiesConnection) super.a(this.f3950K, 33, GraphQLInlineActivitiesConnection.class);
        return this.f3950K;
    }

    @FieldOffset
    @Nullable
    public final String m7961R() {
        this.f3951L = super.a(this.f3951L, 34);
        return this.f3951L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7962S() {
        this.f3952M = (GraphQLTextWithEntities) super.a(this.f3952M, 35, GraphQLTextWithEntities.class);
        return this.f3952M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m7963T() {
        this.f3953N = (GraphQLNegativeFeedbackActionsConnection) super.a(this.f3953N, 36, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f3953N;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7964U() {
        this.f3954O = super.a(this.f3954O, 37, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3954O;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStory> m7965V() {
        this.f3955P = super.a(this.f3955P, 38, GraphQLStory.class);
        return (ImmutableList) this.f3955P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlaceRecommendationPostInfo m7966W() {
        this.f3956Q = (GraphQLPlaceRecommendationPostInfo) super.a(this.f3956Q, 39, GraphQLPlaceRecommendationPostInfo.class);
        return this.f3956Q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m7967X() {
        this.f3957R = (GraphQLPrivacyScope) super.a(this.f3957R, 41, GraphQLPrivacyScope.class);
        return this.f3957R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSticker m7968Y() {
        this.f3958S = (GraphQLSticker) super.a(this.f3958S, 42, GraphQLSticker.class);
        return this.f3958S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStorySaveInfo m7969Z() {
        this.f3959T = (GraphQLStorySaveInfo) super.a(this.f3959T, 43, GraphQLStorySaveInfo.class);
        return this.f3959T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackSection aa() {
        this.f3960U = (GraphQLGoodwillThrowbackSection) super.a(this.f3960U, 44, GraphQLGoodwillThrowbackSection.class);
        return this.f3960U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity ab() {
        this.f3961V = (GraphQLEntity) super.a(this.f3961V, 45, GraphQLEntity.class);
        return this.f3961V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData ac() {
        this.f3962W = (GraphQLSponsoredData) super.a(this.f3962W, 46, GraphQLSponsoredData.class);
        return this.f3962W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryHeader ad() {
        this.f3963X = (GraphQLStoryHeader) super.a(this.f3963X, 47, GraphQLStoryHeader.class);
        return this.f3963X;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSubstoriesGroupingReason> ae() {
        this.f3964Y = super.b(this.f3964Y, 48, GraphQLSubstoriesGroupingReason.class);
        return (ImmutableList) this.f3964Y;
    }

    @FieldOffset
    public final int af() {
        a(6, 1);
        return this.f3965Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities ag() {
        this.aa = (GraphQLTextWithEntities) super.a(this.aa, 50, GraphQLTextWithEntities.class);
        return this.aa;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities ah() {
        this.ab = (GraphQLTextWithEntities) super.a(this.ab, 51, GraphQLTextWithEntities.class);
        return this.ab;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory ai() {
        this.ac = (GraphQLStory) super.a(this.ac, 52, GraphQLStory.class);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aj() {
        this.ad = (GraphQLTextWithEntities) super.a(this.ad, 53, GraphQLTextWithEntities.class);
        return this.ad;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile ak() {
        this.ae = (GraphQLProfile) super.a(this.ae, 54, GraphQLProfile.class);
        return this.ae;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryTopicsContext al() {
        this.af = (GraphQLStoryTopicsContext) super.a(this.af, 55, GraphQLStoryTopicsContext.class);
        return this.af;
    }

    @FieldOffset
    @Nullable
    public final String am() {
        this.ag = super.a(this.ag, 56);
        return this.ag;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPostTranslatability an() {
        this.ah = (GraphQLPostTranslatability) super.a(this.ah, 57, GraphQLPostTranslatability.class);
        return this.ah;
    }

    @FieldOffset
    @Nullable
    public final String ao() {
        this.ai = super.a(this.ai, 59);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor ap() {
        this.aj = (GraphQLActor) super.a(this.aj, 60, GraphQLActor.class);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLWithTagsConnection aq() {
        this.ak = (GraphQLWithTagsConnection) super.a(this.ak, 61, GraphQLWithTagsConnection.class);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final String ar() {
        this.al = super.a(this.al, 62);
        return this.al;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEditPostFeatureCapability> as() {
        this.am = super.b(this.am, 63, GraphQLEditPostFeatureCapability.class);
        return (ImmutableList) this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities at() {
        this.an = (GraphQLTextWithEntities) super.a(this.an, 64, GraphQLTextWithEntities.class);
        return this.an;
    }

    @Nullable
    public final String m7972a() {
        return m7958O();
    }

    public final int jK_() {
        return -426518080;
    }

    public final GraphQLVisitableModel m7971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLStory graphQLStory;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLPlace graphQLPlace;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7975k() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7975k());
            if (m7975k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(null, this);
                graphQLVisitableModel.f3967e = graphQLImage;
            }
        }
        if (m7976l() != null) {
            a = ModelHelper.a(m7976l(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillThrowbackFeedUnit graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillThrowbackFeedUnit.f3968f = a.b();
                graphQLVisitableModel = graphQLGoodwillThrowbackFeedUnit;
            }
        }
        if (m7977m() != null) {
            a = ModelHelper.a(m7977m(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillThrowbackFeedUnit.f3969g = a.b();
                graphQLVisitableModel = graphQLGoodwillThrowbackFeedUnit;
            }
        }
        if (m7978n() != null) {
            a = ModelHelper.a(m7978n(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillThrowbackFeedUnit.f3970h = a.b();
                graphQLVisitableModel = graphQLGoodwillThrowbackFeedUnit;
            }
        }
        if (m7979o() != null) {
            GraphQLSubstoriesConnection graphQLSubstoriesConnection = (GraphQLSubstoriesConnection) graphQLModelMutatingVisitor.b(m7979o());
            if (m7979o() != graphQLSubstoriesConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3971i = graphQLSubstoriesConnection;
            }
        }
        if (m7980p() != null) {
            GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign = (GraphQLGoodwillAnniversaryCampaign) graphQLModelMutatingVisitor.b(m7980p());
            if (m7980p() != graphQLGoodwillAnniversaryCampaign) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3972j = graphQLGoodwillAnniversaryCampaign;
            }
        }
        if (m7981q() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.b(m7981q());
            if (m7981q() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3973k = graphQLApplication;
            }
        }
        if (m7982r() != null) {
            a = ModelHelper.a(m7982r(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillThrowbackFeedUnit.f3974l = a.b();
                graphQLVisitableModel = graphQLGoodwillThrowbackFeedUnit;
            }
        }
        if (m7983s() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m7983s());
            if (m7983s() != graphQLStory) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3975m = graphQLStory;
            }
        }
        if (m7984t() != null) {
            a = ModelHelper.a(m7984t(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillThrowbackFeedUnit.f3976n = a.b();
                graphQLVisitableModel = graphQLGoodwillThrowbackFeedUnit;
            }
        }
        if (m7945B() != null) {
            GraphQLGoodwillThrowbackPermalinkColorPalette graphQLGoodwillThrowbackPermalinkColorPalette = (GraphQLGoodwillThrowbackPermalinkColorPalette) graphQLModelMutatingVisitor.b(m7945B());
            if (m7945B() != graphQLGoodwillThrowbackPermalinkColorPalette) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3984v = graphQLGoodwillThrowbackPermalinkColorPalette;
            }
        }
        if (m7948E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7948E());
            if (m7948E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3987y = graphQLTextWithEntities;
            }
        }
        if (m7949F() != null) {
            GraphQLEditHistoryConnection graphQLEditHistoryConnection = (GraphQLEditHistoryConnection) graphQLModelMutatingVisitor.b(m7949F());
            if (m7949F() != graphQLEditHistoryConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3988z = graphQLEditHistoryConnection;
            }
        }
        if (m7950G() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.b(m7950G());
            if (m7950G() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3940A = graphQLPlace;
            }
        }
        if (m7951H() != null) {
            GraphQLFeedTopicContent graphQLFeedTopicContent = (GraphQLFeedTopicContent) graphQLModelMutatingVisitor.b(m7951H());
            if (m7951H() != graphQLFeedTopicContent) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3941B = graphQLFeedTopicContent;
            }
        }
        if (m7952I() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m7952I());
            if (m7952I() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3942C = graphQLFeedback;
            }
        }
        if (m7953J() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7953J());
            if (m7953J() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3943D = graphQLTextWithEntities;
            }
        }
        if (m7954K() != null) {
            GraphQLGoodwillThrowbackFriendListConnection graphQLGoodwillThrowbackFriendListConnection = (GraphQLGoodwillThrowbackFriendListConnection) graphQLModelMutatingVisitor.b(m7954K());
            if (m7954K() != graphQLGoodwillThrowbackFriendListConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3944E = graphQLGoodwillThrowbackFriendListConnection;
            }
        }
        if (m7955L() != null) {
            GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign = (GraphQLGoodwillFriendversaryCampaign) graphQLModelMutatingVisitor.b(m7955L());
            if (m7955L() != graphQLGoodwillFriendversaryCampaign) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3945F = graphQLGoodwillFriendversaryCampaign;
            }
        }
        if (m7959P() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.b(m7959P());
            if (m7959P() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3949J = graphQLPlace;
            }
        }
        if (m7960Q() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.b(m7960Q());
            if (m7960Q() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3950K = graphQLInlineActivitiesConnection;
            }
        }
        if (m7962S() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7962S());
            if (m7962S() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3952M = graphQLTextWithEntities;
            }
        }
        if (at() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(at());
            if (at() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.an = graphQLTextWithEntities;
            }
        }
        if (m7963T() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.b(m7963T());
            if (m7963T() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3953N = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m7964U() != null) {
            a = ModelHelper.a(m7964U(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillThrowbackFeedUnit.f3954O = a.b();
                graphQLVisitableModel = graphQLGoodwillThrowbackFeedUnit;
            }
        }
        if (m7965V() != null) {
            a = ModelHelper.a(m7965V(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillThrowbackFeedUnit.f3955P = a.b();
                graphQLVisitableModel = graphQLGoodwillThrowbackFeedUnit;
            }
        }
        if (m7966W() != null) {
            GraphQLPlaceRecommendationPostInfo graphQLPlaceRecommendationPostInfo = (GraphQLPlaceRecommendationPostInfo) graphQLModelMutatingVisitor.b(m7966W());
            if (m7966W() != graphQLPlaceRecommendationPostInfo) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3956Q = graphQLPlaceRecommendationPostInfo;
            }
        }
        if (m7967X() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.b(m7967X());
            if (m7967X() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3957R = graphQLPrivacyScope;
            }
        }
        if (m7968Y() != null) {
            GraphQLSticker graphQLSticker = (GraphQLSticker) graphQLModelMutatingVisitor.b(m7968Y());
            if (m7968Y() != graphQLSticker) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3958S = graphQLSticker;
            }
        }
        if (m7969Z() != null) {
            GraphQLStorySaveInfo graphQLStorySaveInfo = (GraphQLStorySaveInfo) graphQLModelMutatingVisitor.b(m7969Z());
            if (m7969Z() != graphQLStorySaveInfo) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3959T = graphQLStorySaveInfo;
            }
        }
        if (aa() != null) {
            GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = (GraphQLGoodwillThrowbackSection) graphQLModelMutatingVisitor.b(aa());
            if (aa() != graphQLGoodwillThrowbackSection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3960U = graphQLGoodwillThrowbackSection;
            }
        }
        if (ab() != null) {
            GraphQLEntity graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.b(ab());
            if (ab() != graphQLEntity) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3961V = graphQLEntity;
            }
        }
        if (ac() != null) {
            GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.b(ac());
            if (ac() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3962W = graphQLSponsoredData;
            }
        }
        if (ad() != null) {
            GraphQLStoryHeader graphQLStoryHeader = (GraphQLStoryHeader) graphQLModelMutatingVisitor.b(ad());
            if (ad() != graphQLStoryHeader) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3963X = graphQLStoryHeader;
            }
        }
        if (ag() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(ag());
            if (ag() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.aa = graphQLTextWithEntities;
            }
        }
        if (ah() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(ah());
            if (ah() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.ab = graphQLTextWithEntities;
            }
        }
        if (ai() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(ai());
            if (ai() != graphQLStory) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.ac = graphQLStory;
            }
        }
        if (aj() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(aj());
            if (aj() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.ad = graphQLTextWithEntities;
            }
        }
        if (ak() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(ak());
            if (ak() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.ae = graphQLProfile;
            }
        }
        if (al() != null) {
            GraphQLStoryTopicsContext graphQLStoryTopicsContext = (GraphQLStoryTopicsContext) graphQLModelMutatingVisitor.b(al());
            if (al() != graphQLStoryTopicsContext) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.af = graphQLStoryTopicsContext;
            }
        }
        if (an() != null) {
            GraphQLPostTranslatability graphQLPostTranslatability = (GraphQLPostTranslatability) graphQLModelMutatingVisitor.b(an());
            if (an() != graphQLPostTranslatability) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.ah = graphQLPostTranslatability;
            }
        }
        if (ap() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(ap());
            if (ap() != graphQLActor) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.aj = graphQLActor;
            }
        }
        if (aq() != null) {
            GraphQLWithTagsConnection graphQLWithTagsConnection = (GraphQLWithTagsConnection) graphQLModelMutatingVisitor.b(aq());
            if (aq() != graphQLWithTagsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.ak = graphQLWithTagsConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackFeedUnit() {
        super(66);
    }

    public final void m7973a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3978p = mutableFlatBuffer.a(i, 12);
        this.f3979q = mutableFlatBuffer.a(i, 13);
        this.f3980r = mutableFlatBuffer.a(i, 14);
        this.f3981s = mutableFlatBuffer.a(i, 15);
        this.f3982t = mutableFlatBuffer.a(i, 16);
        this.f3983u = mutableFlatBuffer.a(i, 17);
        this.f3985w = mutableFlatBuffer.a(i, 19, 0);
        this.f3946G = mutableFlatBuffer.a(i, 29);
        this.f3965Z = mutableFlatBuffer.a(i, 49, 0);
    }

    public final int m7970a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m7974j() != null ? m7974j().e() : null);
        int a2 = ModelHelper.a(flatBufferBuilder, m7975k());
        int a3 = ModelHelper.a(flatBufferBuilder, m7976l());
        int a4 = ModelHelper.a(flatBufferBuilder, m7977m());
        int a5 = ModelHelper.a(flatBufferBuilder, m7978n());
        int a6 = ModelHelper.a(flatBufferBuilder, m7979o());
        int a7 = ModelHelper.a(flatBufferBuilder, m7980p());
        int a8 = ModelHelper.a(flatBufferBuilder, m7981q());
        int a9 = ModelHelper.a(flatBufferBuilder, m7982r());
        int a10 = ModelHelper.a(flatBufferBuilder, m7983s());
        int a11 = ModelHelper.a(flatBufferBuilder, m7984t());
        int b = flatBufferBuilder.b(m7985u());
        int a12 = ModelHelper.a(flatBufferBuilder, m7945B());
        int b2 = flatBufferBuilder.b(m7947D());
        int a13 = ModelHelper.a(flatBufferBuilder, m7948E());
        int a14 = ModelHelper.a(flatBufferBuilder, m7949F());
        int a15 = ModelHelper.a(flatBufferBuilder, m7950G());
        int a16 = ModelHelper.a(flatBufferBuilder, m7951H());
        int a17 = ModelHelper.a(flatBufferBuilder, m7952I());
        int a18 = ModelHelper.a(flatBufferBuilder, m7953J());
        int a19 = ModelHelper.a(flatBufferBuilder, m7954K());
        int a20 = ModelHelper.a(flatBufferBuilder, m7955L());
        int b3 = flatBufferBuilder.b(m7957N());
        int b4 = flatBufferBuilder.b(m7958O());
        int a21 = ModelHelper.a(flatBufferBuilder, m7959P());
        int a22 = ModelHelper.a(flatBufferBuilder, m7960Q());
        int b5 = flatBufferBuilder.b(m7961R());
        int a23 = ModelHelper.a(flatBufferBuilder, m7962S());
        int a24 = ModelHelper.a(flatBufferBuilder, m7963T());
        int a25 = ModelHelper.a(flatBufferBuilder, m7964U());
        int a26 = ModelHelper.a(flatBufferBuilder, m7965V());
        int a27 = ModelHelper.a(flatBufferBuilder, m7966W());
        int a28 = ModelHelper.a(flatBufferBuilder, m7967X());
        int a29 = ModelHelper.a(flatBufferBuilder, m7968Y());
        int a30 = ModelHelper.a(flatBufferBuilder, m7969Z());
        int a31 = ModelHelper.a(flatBufferBuilder, aa());
        int a32 = ModelHelper.a(flatBufferBuilder, ab());
        int a33 = ModelHelper.a(flatBufferBuilder, ac());
        int a34 = ModelHelper.a(flatBufferBuilder, ad());
        int e = flatBufferBuilder.e(ae());
        int a35 = ModelHelper.a(flatBufferBuilder, ag());
        int a36 = ModelHelper.a(flatBufferBuilder, ah());
        int a37 = ModelHelper.a(flatBufferBuilder, ai());
        int a38 = ModelHelper.a(flatBufferBuilder, aj());
        int a39 = ModelHelper.a(flatBufferBuilder, ak());
        int a40 = ModelHelper.a(flatBufferBuilder, al());
        int b6 = flatBufferBuilder.b(am());
        int a41 = ModelHelper.a(flatBufferBuilder, an());
        int b7 = flatBufferBuilder.b(ao());
        int a42 = ModelHelper.a(flatBufferBuilder, ap());
        int a43 = ModelHelper.a(flatBufferBuilder, aq());
        int b8 = flatBufferBuilder.b(ar());
        int e2 = flatBufferBuilder.e(as());
        int a44 = ModelHelper.a(flatBufferBuilder, at());
        flatBufferBuilder.c(65);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        flatBufferBuilder.b(5, a6);
        flatBufferBuilder.b(6, a7);
        flatBufferBuilder.b(7, a8);
        flatBufferBuilder.b(8, a9);
        flatBufferBuilder.b(9, a10);
        flatBufferBuilder.b(10, a11);
        flatBufferBuilder.b(11, b);
        flatBufferBuilder.a(12, m7986v());
        flatBufferBuilder.a(13, m7987w());
        flatBufferBuilder.a(14, m7988x());
        flatBufferBuilder.a(15, m7989y());
        flatBufferBuilder.a(16, m7990z());
        flatBufferBuilder.a(17, m7944A());
        flatBufferBuilder.b(18, a12);
        flatBufferBuilder.a(19, m7946C(), 0);
        flatBufferBuilder.b(20, b2);
        flatBufferBuilder.b(21, a13);
        flatBufferBuilder.b(22, a14);
        flatBufferBuilder.b(23, a15);
        flatBufferBuilder.b(24, a16);
        flatBufferBuilder.b(25, a17);
        flatBufferBuilder.b(26, a18);
        flatBufferBuilder.b(27, a19);
        flatBufferBuilder.b(28, a20);
        flatBufferBuilder.a(29, m7956M());
        flatBufferBuilder.b(30, b3);
        flatBufferBuilder.b(31, b4);
        flatBufferBuilder.b(32, a21);
        flatBufferBuilder.b(33, a22);
        flatBufferBuilder.b(34, b5);
        flatBufferBuilder.b(35, a23);
        flatBufferBuilder.b(36, a24);
        flatBufferBuilder.b(37, a25);
        flatBufferBuilder.b(38, a26);
        flatBufferBuilder.b(39, a27);
        flatBufferBuilder.b(41, a28);
        flatBufferBuilder.b(42, a29);
        flatBufferBuilder.b(43, a30);
        flatBufferBuilder.b(44, a31);
        flatBufferBuilder.b(45, a32);
        flatBufferBuilder.b(46, a33);
        flatBufferBuilder.b(47, a34);
        flatBufferBuilder.b(48, e);
        flatBufferBuilder.a(49, af(), 0);
        flatBufferBuilder.b(50, a35);
        flatBufferBuilder.b(51, a36);
        flatBufferBuilder.b(52, a37);
        flatBufferBuilder.b(53, a38);
        flatBufferBuilder.b(54, a39);
        flatBufferBuilder.b(55, a40);
        flatBufferBuilder.b(56, b6);
        flatBufferBuilder.b(57, a41);
        flatBufferBuilder.b(59, b7);
        flatBufferBuilder.b(60, a42);
        flatBufferBuilder.b(61, a43);
        flatBufferBuilder.b(62, b8);
        flatBufferBuilder.b(63, e2);
        flatBufferBuilder.b(64, a44);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackFeedUnit(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(66);
        this.f3967e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3968f = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f3969g = ImmutableListHelper.a(parcel.readArrayList(GraphQLOpenGraphAction.class.getClassLoader()));
        this.f3970h = ImmutableListHelper.a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f3971i = (GraphQLSubstoriesConnection) parcel.readValue(GraphQLSubstoriesConnection.class.getClassLoader());
        this.f3972j = (GraphQLGoodwillAnniversaryCampaign) parcel.readValue(GraphQLGoodwillAnniversaryCampaign.class.getClassLoader());
        this.f3973k = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f3974l = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f3975m = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f3976n = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f3977o = parcel.readString();
        this.f3978p = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3979q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3980r = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3981s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3982t = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3983u = z;
        this.f3984v = (GraphQLGoodwillThrowbackPermalinkColorPalette) parcel.readValue(GraphQLGoodwillThrowbackPermalinkColorPalette.class.getClassLoader());
        this.f3985w = parcel.readLong();
        this.f3986x = parcel.readString();
        this.f3987y = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3988z = (GraphQLEditHistoryConnection) parcel.readValue(GraphQLEditHistoryConnection.class.getClassLoader());
        this.f3940A = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f3941B = (GraphQLFeedTopicContent) parcel.readValue(GraphQLFeedTopicContent.class.getClassLoader());
        this.f3942C = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f3943D = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3944E = (GraphQLGoodwillThrowbackFriendListConnection) parcel.readValue(GraphQLGoodwillThrowbackFriendListConnection.class.getClassLoader());
        this.f3945F = (GraphQLGoodwillFriendversaryCampaign) parcel.readValue(GraphQLGoodwillFriendversaryCampaign.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f3946G = z2;
        this.f3947H = parcel.readString();
        this.f3948I = parcel.readString();
        this.f3949J = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f3950K = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f3951L = parcel.readString();
        this.f3952M = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.an = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3953N = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f3954O = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f3955P = ImmutableListHelper.a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
        this.f3956Q = (GraphQLPlaceRecommendationPostInfo) parcel.readValue(GraphQLPlaceRecommendationPostInfo.class.getClassLoader());
        this.f3957R = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f3958S = (GraphQLSticker) parcel.readValue(GraphQLSticker.class.getClassLoader());
        this.al = parcel.readString();
        this.f3959T = (GraphQLStorySaveInfo) parcel.readValue(GraphQLStorySaveInfo.class.getClassLoader());
        this.f3960U = (GraphQLGoodwillThrowbackSection) parcel.readValue(GraphQLGoodwillThrowbackSection.class.getClassLoader());
        this.f3961V = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.f3962W = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f3963X = (GraphQLStoryHeader) parcel.readValue(GraphQLStoryHeader.class.getClassLoader());
        this.f3964Y = ImmutableListHelper.a(parcel.readArrayList(GraphQLSubstoriesGroupingReason.class.getClassLoader()));
        this.f3965Z = parcel.readInt();
        this.aa = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ab = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ac = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.ad = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ae = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.af = (GraphQLStoryTopicsContext) parcel.readValue(GraphQLStoryTopicsContext.class.getClassLoader());
        this.ag = parcel.readString();
        this.ah = (GraphQLPostTranslatability) parcel.readValue(GraphQLPostTranslatability.class.getClassLoader());
        this.ai = parcel.readString();
        this.aj = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.am = ImmutableListHelper.a(parcel.readArrayList(GraphQLEditPostFeatureCapability.class.getClassLoader()));
        this.ak = (GraphQLWithTagsConnection) parcel.readValue(GraphQLWithTagsConnection.class.getClassLoader());
        this.f3966d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m7975k());
        parcel.writeList(m7976l());
        parcel.writeList(m7977m());
        parcel.writeList(m7978n());
        parcel.writeValue(m7979o());
        parcel.writeValue(m7980p());
        parcel.writeValue(m7981q());
        parcel.writeList(m7982r());
        parcel.writeValue(m7983s());
        parcel.writeList(m7984t());
        parcel.writeString(m7985u());
        parcel.writeByte((byte) (m7986v() ? 1 : 0));
        if (m7987w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7988x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7989y()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7990z()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7944A()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m7945B());
        parcel.writeLong(m7946C());
        parcel.writeString(m7947D());
        parcel.writeValue(m7948E());
        parcel.writeValue(m7949F());
        parcel.writeValue(m7950G());
        parcel.writeValue(m7951H());
        parcel.writeValue(m7952I());
        parcel.writeValue(m7953J());
        parcel.writeValue(m7954K());
        parcel.writeValue(m7955L());
        if (!m7956M()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m7957N());
        parcel.writeString(m7958O());
        parcel.writeValue(m7959P());
        parcel.writeValue(m7960Q());
        parcel.writeString(m7961R());
        parcel.writeValue(m7962S());
        parcel.writeValue(at());
        parcel.writeValue(m7963T());
        parcel.writeList(m7964U());
        parcel.writeList(m7965V());
        parcel.writeValue(m7966W());
        parcel.writeValue(m7967X());
        parcel.writeValue(m7968Y());
        parcel.writeString(ar());
        parcel.writeValue(m7969Z());
        parcel.writeValue(aa());
        parcel.writeValue(ab());
        parcel.writeValue(ac());
        parcel.writeValue(ad());
        parcel.writeList(ae());
        parcel.writeInt(af());
        parcel.writeValue(ag());
        parcel.writeValue(ah());
        parcel.writeValue(ai());
        parcel.writeValue(aj());
        parcel.writeValue(ak());
        parcel.writeValue(al());
        parcel.writeString(am());
        parcel.writeValue(an());
        parcel.writeString(ao());
        parcel.writeValue(ap());
        parcel.writeList(as());
        parcel.writeValue(aq());
        parcel.writeParcelable(this.f3966d, i);
    }
}
