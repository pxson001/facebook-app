package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLStoryTimestampStyle;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: mConnectionState */
public final class GraphQLStory extends BaseModel implements FeedAttachable, FeedUnit, Feedbackable, HasCachedSponsoredImpression, HasHideableToken, HasNegativeFeedbackActions, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, ScrollableItemListFeedUnit, Sponsorable, CachedFeedTrackable, ItemListFeedUnitItem, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLStory> CREATOR = new C07771();
    @Nullable
    GraphQLEditHistoryConnection f15659A;
    @Nullable
    GraphQLPlace f15660B;
    @Nullable
    GraphQLFeedTopicContent f15661C;
    @Nullable
    GraphQLFeedback f15662D;
    @Nullable
    GraphQLFeedbackContext f15663E;
    long f15664F;
    @Nullable
    GraphQLFollowUpFeedUnitsConnection f15665G;
    boolean f15666H;
    @Nullable
    String f15667I;
    @Deprecated
    @Nullable
    GraphQLIcon f15668J;
    @Nullable
    String f15669K;
    @Nullable
    GraphQLPlace f15670L;
    @Nullable
    GraphQLInlineActivitiesConnection f15671M;
    @Nullable
    GraphQLStoryInsights f15672N;
    boolean f15673O;
    @Deprecated
    @Nullable
    String f15674P;
    @Nullable
    GraphQLTextWithEntities f15675Q;
    List<GraphQLStoryAttachment> f15676R;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f15677S;
    @Deprecated
    @Nullable
    GraphQLPlace f15678T;
    @Nullable
    GraphQLPlaceRecommendationPostInfo f15679U;
    @Nullable
    GraphQLBoostedComponent f15680V;
    @Nullable
    GraphQLPrivacyScope f15681W;
    @Deprecated
    @Nullable
    GraphQLPagePostPromotionInfo f15682X;
    @Nullable
    GraphQLRedSpaceStoryInfo f15683Y;
    @Nullable
    GraphQLSticker f15684Z;
    @Nullable
    GraphQLWithTagsConnection aA;
    List<GraphQLEditPostFeatureCapability> aB;
    public boolean aC;
    public boolean aD;
    public boolean aE;
    public boolean aF;
    @Nullable
    public String aG;
    @Nullable
    public String aH;
    long aI;
    @Nullable
    GraphQLTextWithEntities aJ;
    public int aK;
    @Nullable
    GraphQLBackdatedTime aL;
    private StoryExtra aM;
    @Nullable
    public PropertyBag aN = null;
    @Nullable
    GraphQLStorySaveInfo aa;
    List<GraphQLActor> ab;
    public GraphQLStorySeenState ac;
    @Nullable
    GraphQLEntity ad;
    @Nullable
    GraphQLTextWithEntities ae;
    @Nullable
    String af;
    @Nullable
    GraphQLSponsoredData ag;
    List<GraphQLStoryAttachment> ah;
    @Nullable
    GraphQLStoryHeader ai;
    List<GraphQLStoryTimestampStyle> aj;
    List<GraphQLSubstoriesGroupingReason> ak;
    int al;
    @Nullable
    GraphQLTextWithEntities am;
    @Nullable
    GraphQLTextWithEntities an;
    @Nullable
    GraphQLStory ao;
    @Nullable
    GraphQLTextWithEntities ap;
    @Nullable
    GraphQLTextWithEntities aq;
    @Nullable
    GraphQLProfile ar;
    @Nullable
    GraphQLStoryTopicsContext as;
    @Nullable
    String at;
    @Nullable
    GraphQLPostTranslatability au;
    @Nullable
    GraphQLTextWithEntities av;
    @Nullable
    GraphQLTranslationMetaData aw;
    @Nullable
    String ax;
    @Nullable
    GraphQLActor ay;
    boolean az;
    GraphQLObjectType f15685d = new GraphQLObjectType(80218325);
    List<GraphQLStoryActionLink> f15686e;
    List<GraphQLOpenGraphAction> f15687f;
    List<GraphQLActor> f15688g;
    @Nullable
    GraphQLSubstoriesConnection f15689h;
    List<String> f15690i;
    @Nullable
    GraphQLImage f15691j;
    @Nullable
    GraphQLApplication f15692k;
    List<GraphQLStoryActionLink> f15693l;
    @Nullable
    GraphQLStory f15694m;
    List<GraphQLStoryAttachment> f15695n;
    @Nullable
    String f15696o;
    boolean f15697p;
    boolean f15698q;
    boolean f15699r;
    @Deprecated
    boolean f15700s;
    boolean f15701t;
    @Deprecated
    boolean f15702u;
    @Nullable
    String f15703v;
    @Nullable
    GraphQLStory f15704w;
    long f15705x;
    @Nullable
    String f15706y;
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f15707z;

    /* compiled from: mConnectionState */
    final class C07771 implements Creator<GraphQLStory> {
        C07771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStory(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStory[i];
        }
    }

    /* compiled from: mConnectionState */
    public class StoryExtra extends FeedUnitExtra {
        public static final Creator<StoryExtra> CREATOR = new C08361();
        public GraphQLPrivacyScope f20928a = null;
        public GraphQLTextWithEntities f20929b = null;

        /* compiled from: mConnectionState */
        final class C08361 implements Creator<StoryExtra> {
            C08361() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new StoryExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new StoryExtra[i];
            }
        }

        protected StoryExtra(Parcel parcel) {
            super(parcel);
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            int a = super.mo1403a(flatBufferBuilder);
            int a2 = flatBufferBuilder.m21475a(this.f20928a);
            int a3 = flatBufferBuilder.m21475a(this.f20929b);
            flatBufferBuilder.m21510c(3);
            if (a > 0) {
                flatBufferBuilder.m21507b(0, a);
            }
            flatBufferBuilder.m21507b(1, a2);
            flatBufferBuilder.m21507b(2, a3);
            return flatBufferBuilder.m21511d();
        }

        public final void mo1412a(MutableFlatBuffer mutableFlatBuffer, int i) {
            super.mo1412a(mutableFlatBuffer, mutableFlatBuffer.m21560g(i, 0));
            this.f20928a = (GraphQLPrivacyScope) mutableFlatBuffer.m21551d(i, 1, GraphQLPrivacyScope.class);
            this.f20929b = (GraphQLTextWithEntities) mutableFlatBuffer.m21551d(i, 2, GraphQLTextWithEntities.class);
        }
    }

    public final boolean m22369z() {
        GraphQLFeedback l = mo2890l();
        boolean z = l != null && l.mo2932g();
        return z;
    }

    public final List<GraphQLStoryAttachment> m22367x() {
        ImmutableList M = m22327M();
        if (M == null) {
            M = RegularImmutableList.f535a;
        }
        return M;
    }

    public final boolean mo2895u() {
        return ay() != null;
    }

    public final String mo2892r() {
        return m22350c();
    }

    public final int m22318D() {
        int a;
        GraphQLFeedback l = mo2890l();
        if (l != null) {
            a = l.m23215I() == null ? 0 : l.m23215I().m24792a();
        } else {
            a = 0;
        }
        return a;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return bd();
    }

    public final List mo2882v() {
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return RegularImmutableList.f535a;
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27156d();
    }

    public final GraphQLObjectType getType() {
        return this.f15685d;
    }

    public final ImmutableList<String> mo2874d() {
        Builder builder = new Builder();
        if (mo2507g() != null) {
            builder.m1069c(mo2507g());
        }
        if (ai() != null) {
            builder.m1069c(ai());
        }
        return builder.m1068b();
    }

    public final boolean m22315A() {
        return FeedbackableUtil.m29215b(this);
    }

    public final boolean m22316B() {
        return FeedbackableUtil.m29216c(this);
    }

    public final int aa_() {
        return FeedbackableUtil.m29217d(this);
    }

    public final int mo2891n() {
        return FeedbackableUtil.m29218e(this);
    }

    public final SponsoredImpression Z_() {
        int i = 0;
        if (this != null) {
            int i2 = (ay() == null || !IsValidUtil.m22943a(ay())) ? 0 : 1;
            int i3 = i2 | 0;
            if (m22326L() == null || m22326L().ay() == null || !IsValidUtil.m22943a(m22326L().ay())) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            i2 |= i3;
            if (StoryHierarchyHelper.m27434a(this) != null) {
                ImmutableList j = StoryHierarchyHelper.m27434a(this).m22608j();
                int size = j.size();
                i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    GraphQLStory graphQLStory = (GraphQLStory) j.get(i4);
                    if (graphQLStory.ay() == null || !IsValidUtil.m22943a(graphQLStory.ay())) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    i3 |= i2;
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        return i != 0 ? new SponsoredImpression(this) : SponsoredImpression.f21615n;
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return ImpressionUtil.m29319a((HasCachedSponsoredImpression) this);
    }

    public final StoryVisibility mo2879o() {
        return HideableUnitUtil.m26319a((HideableUnit) this);
    }

    public final int mo2880p() {
        return HideableUnitUtil.m26321b(this);
    }

    public final String mo2881q() {
        return HideableUnitUtil.m26320a((HasHideableToken) this);
    }

    public final GraphQLNegativeFeedbackActionType mo2893s() {
        return NegativeFeedbackActionsUnitImpl.m29497a((NegativeFeedbackActionsUnit) this);
    }

    public final GraphQLNegativeFeedbackActionsConnection mo2894t() {
        return NegativeFeedbackActionsUnitImpl.m29498a((HasNegativeFeedbackActions) this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(m22350c());
        stringBuilder.append(',');
        if (aH() != null) {
            stringBuilder.append(aH().mo2911a());
            stringBuilder.append(',');
        }
        if (m22349b() != null && m22349b().size() > 0) {
            stringBuilder.append(((GraphQLActor) m22349b().get(0)).aa());
            stringBuilder.append(", ProfilePics: [");
            ImmutableList b = m22349b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                GraphQLActor graphQLActor = (GraphQLActor) b.get(i);
                if (graphQLActor.ai() != null) {
                    stringBuilder.append(graphQLActor.ai().mo2924b());
                    stringBuilder.append("|");
                }
            }
            stringBuilder.append("]");
        }
        GraphQLTextWithEntities b2 = StoryHierarchyHelper.m27435b(this);
        if (b2 != null) {
            stringBuilder.append(b2.mo2911a());
            stringBuilder.append(',');
        } else {
            stringBuilder.append("NULL");
            stringBuilder.append(',');
        }
        if (aF() != null) {
            stringBuilder.append(aF().mo2911a());
        } else {
            stringBuilder.append("NULL");
        }
        stringBuilder.append(',');
        stringBuilder.append(m22336V());
        if (m22327M() != null && m22327M().size() > 0) {
            stringBuilder.append(", attachment 0:");
            stringBuilder.append(((GraphQLStoryAttachment) m22327M().get(0)).m23964A());
        }
        if (av() != null) {
            stringBuilder.append(", shareable: { id: ").append(av().mo2906d());
            if (av().mo2904b() != null) {
                stringBuilder.append(", __type__: ").append(av().mo2904b().m22299e());
            }
            stringBuilder.append("}");
        }
        if (ai() != null) {
            stringBuilder.append(", legacyApiStoryId: ").append(ai());
        }
        if (mo2896y() != null) {
            stringBuilder.append(", hideableToken: ").append(mo2896y());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m22319E() {
        this.f15686e = super.m9944a(this.f15686e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f15686e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLOpenGraphAction> m22320F() {
        this.f15687f = super.m9944a(this.f15687f, 1, GraphQLOpenGraphAction.class);
        return (ImmutableList) this.f15687f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m22349b() {
        this.f15688g = super.m9944a(this.f15688g, 3, GraphQLActor.class);
        return (ImmutableList) this.f15688g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSubstoriesConnection m22321G() {
        this.f15689h = (GraphQLSubstoriesConnection) super.m9947a(this.f15689h, 4, GraphQLSubstoriesConnection.class);
        return this.f15689h;
    }

    @FieldOffset
    public final ImmutableList<String> m22322H() {
        this.f15690i = super.m9943a(this.f15690i, 5);
        return (ImmutableList) this.f15690i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22323I() {
        this.f15691j = (GraphQLImage) super.m9947a(this.f15691j, 6, GraphQLImage.class);
        return this.f15691j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m22324J() {
        this.f15692k = (GraphQLApplication) super.m9947a(this.f15692k, 7, GraphQLApplication.class);
        return this.f15692k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m22325K() {
        this.f15693l = super.m9944a(this.f15693l, 8, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f15693l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m22326L() {
        this.f15694m = (GraphQLStory) super.m9947a(this.f15694m, 9, GraphQLStory.class);
        return this.f15694m;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m22327M() {
        this.f15695n = super.m9944a(this.f15695n, 10, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f15695n;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f15696o = super.m9948a(this.f15696o, 11);
        return this.f15696o;
    }

    @FieldOffset
    public final boolean m22328N() {
        m9949a(1, 4);
        return this.f15697p;
    }

    @FieldOffset
    public final boolean m22329O() {
        m9949a(1, 5);
        return this.f15698q;
    }

    @FieldOffset
    public final boolean m22330P() {
        m9949a(1, 6);
        return this.f15699r;
    }

    @FieldOffset
    public final boolean m22331Q() {
        m9949a(1, 7);
        return this.f15700s;
    }

    @FieldOffset
    public final boolean m22332R() {
        m9949a(2, 0);
        return this.f15701t;
    }

    @FieldOffset
    public final boolean m22333S() {
        m9949a(2, 1);
        return this.f15702u;
    }

    @FieldOffset
    @Nullable
    public final String m22334T() {
        this.f15703v = super.m9948a(this.f15703v, 18);
        return this.f15703v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m22335U() {
        this.f15704w = (GraphQLStory) super.m9947a(this.f15704w, 19, GraphQLStory.class);
        return this.f15704w;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return aH();
    }

    @FieldOffset
    public final long m22336V() {
        m9949a(2, 4);
        return this.f15705x;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f15706y = super.m9948a(this.f15706y, 21);
        return this.f15706y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22337W() {
        this.f15707z = (GraphQLTextWithEntities) super.m9947a(this.f15707z, 22, GraphQLTextWithEntities.class);
        return this.f15707z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEditHistoryConnection m22338X() {
        this.f15659A = (GraphQLEditHistoryConnection) super.m9947a(this.f15659A, 23, GraphQLEditHistoryConnection.class);
        return this.f15659A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m22339Y() {
        this.f15660B = (GraphQLPlace) super.m9947a(this.f15660B, 24, GraphQLPlace.class);
        return this.f15660B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedTopicContent m22340Z() {
        this.f15661C = (GraphQLFeedTopicContent) super.m9947a(this.f15661C, 25, GraphQLFeedTopicContent.class);
        return this.f15661C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback mo2890l() {
        this.f15662D = (GraphQLFeedback) super.m9947a(this.f15662D, 26, GraphQLFeedback.class);
        return this.f15662D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackContext aa() {
        this.f15663E = (GraphQLFeedbackContext) super.m9947a(this.f15663E, 27, GraphQLFeedbackContext.class);
        return this.f15663E;
    }

    @FieldOffset
    public final long T_() {
        m9949a(3, 4);
        return this.f15664F;
    }

    public final void mo2872a(long j) {
        this.f15664F = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFollowUpFeedUnitsConnection ab() {
        this.f15665G = (GraphQLFollowUpFeedUnitsConnection) super.m9947a(this.f15665G, 29, GraphQLFollowUpFeedUnitsConnection.class);
        return this.f15665G;
    }

    @FieldOffset
    public final boolean ac() {
        m9949a(3, 6);
        return this.f15666H;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f15667I = super.m9948a(this.f15667I, 31);
        return this.f15667I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLIcon ad() {
        this.f15668J = (GraphQLIcon) super.m9947a(this.f15668J, 33, GraphQLIcon.class);
        return this.f15668J;
    }

    @FieldOffset
    @Nullable
    public final String m22350c() {
        this.f15669K = super.m9948a(this.f15669K, 34);
        return this.f15669K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace ae() {
        this.f15670L = (GraphQLPlace) super.m9947a(this.f15670L, 35, GraphQLPlace.class);
        return this.f15670L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection af() {
        this.f15671M = (GraphQLInlineActivitiesConnection) super.m9947a(this.f15671M, 36, GraphQLInlineActivitiesConnection.class);
        return this.f15671M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryInsights ag() {
        this.f15672N = (GraphQLStoryInsights) super.m9947a(this.f15672N, 37, GraphQLStoryInsights.class);
        return this.f15672N;
    }

    @FieldOffset
    public final boolean ah() {
        m9949a(4, 6);
        return this.f15673O;
    }

    @FieldOffset
    @Nullable
    public final String ai() {
        this.f15674P = super.m9948a(this.f15674P, 39);
        return this.f15674P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aj() {
        this.f15675Q = (GraphQLTextWithEntities) super.m9947a(this.f15675Q, 40, GraphQLTextWithEntities.class);
        return this.f15675Q;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> ak() {
        this.f15676R = super.m9944a(this.f15676R, 41, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f15676R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection mo2885C() {
        this.f15677S = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f15677S, 42, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f15677S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace al() {
        this.f15678T = (GraphQLPlace) super.m9947a(this.f15678T, 43, GraphQLPlace.class);
        return this.f15678T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlaceRecommendationPostInfo am() {
        this.f15679U = (GraphQLPlaceRecommendationPostInfo) super.m9947a(this.f15679U, 44, GraphQLPlaceRecommendationPostInfo.class);
        return this.f15679U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLBoostedComponent an() {
        this.f15680V = (GraphQLBoostedComponent) super.m9947a(this.f15680V, 45, GraphQLBoostedComponent.class);
        return this.f15680V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope ao() {
        this.f15681W = (GraphQLPrivacyScope) super.m9947a(this.f15681W, 47, GraphQLPrivacyScope.class);
        return this.f15681W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPagePostPromotionInfo ap() {
        this.f15682X = (GraphQLPagePostPromotionInfo) super.m9947a(this.f15682X, 48, GraphQLPagePostPromotionInfo.class);
        return this.f15682X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRedSpaceStoryInfo aq() {
        this.f15683Y = (GraphQLRedSpaceStoryInfo) super.m9947a(this.f15683Y, 49, GraphQLRedSpaceStoryInfo.class);
        return this.f15683Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSticker ar() {
        this.f15684Z = (GraphQLSticker) super.m9947a(this.f15684Z, 50, GraphQLSticker.class);
        return this.f15684Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStorySaveInfo as() {
        this.aa = (GraphQLStorySaveInfo) super.m9947a(this.aa, 51, GraphQLStorySaveInfo.class);
        return this.aa;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> at() {
        this.ab = super.m9944a(this.ab, 52, GraphQLActor.class);
        return (ImmutableList) this.ab;
    }

    @FieldOffset
    public final GraphQLStorySeenState au() {
        this.ac = (GraphQLStorySeenState) super.m9945a(this.ac, 53, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity av() {
        this.ad = (GraphQLEntity) super.m9947a(this.ad, 54, GraphQLEntity.class);
        return this.ad;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aw() {
        this.ae = (GraphQLTextWithEntities) super.m9947a(this.ae, 55, GraphQLTextWithEntities.class);
        return this.ae;
    }

    @FieldOffset
    @Nullable
    public final String ax() {
        this.af = super.m9948a(this.af, 56);
        return this.af;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData ay() {
        this.ag = (GraphQLSponsoredData) super.m9947a(this.ag, 57, GraphQLSponsoredData.class);
        return this.ag;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> az() {
        this.ah = super.m9944a(this.ah, 58, GraphQLStoryAttachment.class);
        return (ImmutableList) this.ah;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryHeader aA() {
        this.ai = (GraphQLStoryHeader) super.m9947a(this.ai, 59, GraphQLStoryHeader.class);
        return this.ai;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryTimestampStyle> aB() {
        this.aj = super.m9953b(this.aj, 60, GraphQLStoryTimestampStyle.class);
        return (ImmutableList) this.aj;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSubstoriesGroupingReason> aC() {
        this.ak = super.m9953b(this.ak, 61, GraphQLSubstoriesGroupingReason.class);
        return (ImmutableList) this.ak;
    }

    @FieldOffset
    public final int aD() {
        m9949a(7, 6);
        return this.al;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aE() {
        this.am = (GraphQLTextWithEntities) super.m9947a(this.am, 63, GraphQLTextWithEntities.class);
        return this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aF() {
        this.an = (GraphQLTextWithEntities) super.m9947a(this.an, 64, GraphQLTextWithEntities.class);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory aG() {
        this.ao = (GraphQLStory) super.m9947a(this.ao, 65, GraphQLStory.class);
        return this.ao;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aH() {
        this.ap = (GraphQLTextWithEntities) super.m9947a(this.ap, 66, GraphQLTextWithEntities.class);
        return this.ap;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aI() {
        this.aq = (GraphQLTextWithEntities) super.m9947a(this.aq, 67, GraphQLTextWithEntities.class);
        return this.aq;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile aJ() {
        this.ar = (GraphQLProfile) super.m9947a(this.ar, 69, GraphQLProfile.class);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryTopicsContext aK() {
        this.as = (GraphQLStoryTopicsContext) super.m9947a(this.as, 70, GraphQLStoryTopicsContext.class);
        return this.as;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.at = super.m9948a(this.at, 71);
        return this.at;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPostTranslatability aL() {
        this.au = (GraphQLPostTranslatability) super.m9947a(this.au, 72, GraphQLPostTranslatability.class);
        return this.au;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aM() {
        this.av = (GraphQLTextWithEntities) super.m9947a(this.av, 73, GraphQLTextWithEntities.class);
        return this.av;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTranslationMetaData aN() {
        this.aw = (GraphQLTranslationMetaData) super.m9947a(this.aw, 74, GraphQLTranslationMetaData.class);
        return this.aw;
    }

    @FieldOffset
    @Nullable
    public final String aO() {
        this.ax = super.m9948a(this.ax, 76);
        return this.ax;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor aP() {
        this.ay = (GraphQLActor) super.m9947a(this.ay, 77, GraphQLActor.class);
        return this.ay;
    }

    @FieldOffset
    public final boolean aQ() {
        m9949a(9, 6);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLWithTagsConnection aR() {
        this.aA = (GraphQLWithTagsConnection) super.m9947a(this.aA, 79, GraphQLWithTagsConnection.class);
        return this.aA;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEditPostFeatureCapability> aS() {
        this.aB = super.m9953b(this.aB, 80, GraphQLEditPostFeatureCapability.class);
        return (ImmutableList) this.aB;
    }

    @FieldOffset
    public final boolean aT() {
        m9949a(10, 1);
        return this.aC;
    }

    @FieldOffset
    public final boolean aU() {
        m9949a(10, 2);
        return this.aD;
    }

    @FieldOffset
    public final boolean aV() {
        m9949a(10, 3);
        return this.aE;
    }

    @FieldOffset
    public final boolean aW() {
        m9949a(10, 4);
        return this.aF;
    }

    @FieldOffset
    @Nullable
    public final String aX() {
        this.aG = super.m9948a(this.aG, 85);
        return this.aG;
    }

    @FieldOffset
    @Nullable
    public final String aY() {
        this.aH = super.m9948a(this.aH, 86);
        return this.aH;
    }

    @FieldOffset
    public final long aZ() {
        m9949a(10, 7);
        return this.aI;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities ba() {
        this.aJ = (GraphQLTextWithEntities) super.m9947a(this.aJ, 88, GraphQLTextWithEntities.class);
        return this.aJ;
    }

    @FieldOffset
    public final int bb() {
        m9949a(11, 1);
        return this.aK;
    }

    @FieldOffset
    @Nullable
    public final GraphQLBackdatedTime bc() {
        this.aL = (GraphQLBackdatedTime) super.m9947a(this.aL, 90, GraphQLBackdatedTime.class);
        return this.aL;
    }

    @Nullable
    public final String mo2834a() {
        return m22350c();
    }

    public final int jK_() {
        return 80218325;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        Builder a2;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLPlace graphQLPlace;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22319E() != null) {
            a = ModelHelper.m23097a(m22319E(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLStory) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15686e = a.m1068b();
            }
        }
        if (m22320F() != null) {
            a = ModelHelper.m23097a(m22320F(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15687f = a.m1068b();
            }
        }
        if (m22349b() != null) {
            a = ModelHelper.m23097a(m22349b(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15688g = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m22321G() != null) {
            GraphQLSubstoriesConnection graphQLSubstoriesConnection = (GraphQLSubstoriesConnection) graphQLModelMutatingVisitor.mo2928b(m22321G());
            if (m22321G() != graphQLSubstoriesConnection) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15689h = graphQLSubstoriesConnection;
            }
        }
        if (m22323I() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22323I());
            if (m22323I() != graphQLImage) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15691j = graphQLImage;
            }
        }
        if (m22324J() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m22324J());
            if (m22324J() != graphQLApplication) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15692k = graphQLApplication;
            }
        }
        if (m22325K() != null) {
            a2 = ModelHelper.m23097a(m22325K(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                GraphQLStory graphQLStory = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLStory.f15693l = a2.m1068b();
                graphQLVisitableModel2 = graphQLStory;
            }
        }
        if (m22326L() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m22326L());
            if (m22326L() != graphQLStory) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15694m = graphQLStory;
            }
        }
        if (m22327M() != null) {
            a2 = ModelHelper.m23097a(m22327M(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLStory = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLStory.f15695n = a2.m1068b();
                graphQLVisitableModel2 = graphQLStory;
            }
        }
        if (bc() != null) {
            GraphQLBackdatedTime graphQLBackdatedTime = (GraphQLBackdatedTime) graphQLModelMutatingVisitor.mo2928b(bc());
            if (bc() != graphQLBackdatedTime) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.aL = graphQLBackdatedTime;
            }
        }
        if (m22335U() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m22335U());
            if (m22335U() != graphQLStory) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15704w = graphQLStory;
            }
        }
        if (m22337W() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22337W());
            if (m22337W() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15707z = graphQLTextWithEntities;
            }
        }
        if (m22338X() != null) {
            GraphQLEditHistoryConnection graphQLEditHistoryConnection = (GraphQLEditHistoryConnection) graphQLModelMutatingVisitor.mo2928b(m22338X());
            if (m22338X() != graphQLEditHistoryConnection) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15659A = graphQLEditHistoryConnection;
            }
        }
        if (m22339Y() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m22339Y());
            if (m22339Y() != graphQLPlace) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15660B = graphQLPlace;
            }
        }
        if (m22340Z() != null) {
            GraphQLFeedTopicContent graphQLFeedTopicContent = (GraphQLFeedTopicContent) graphQLModelMutatingVisitor.mo2928b(m22340Z());
            if (m22340Z() != graphQLFeedTopicContent) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15661C = graphQLFeedTopicContent;
            }
        }
        if (mo2890l() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(mo2890l());
            if (mo2890l() != graphQLFeedback) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15662D = graphQLFeedback;
            }
        }
        if (aa() != null) {
            GraphQLFeedbackContext graphQLFeedbackContext = (GraphQLFeedbackContext) graphQLModelMutatingVisitor.mo2928b(aa());
            if (aa() != graphQLFeedbackContext) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15663E = graphQLFeedbackContext;
            }
        }
        if (ab() != null) {
            GraphQLFollowUpFeedUnitsConnection graphQLFollowUpFeedUnitsConnection = (GraphQLFollowUpFeedUnitsConnection) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLFollowUpFeedUnitsConnection) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15665G = graphQLFollowUpFeedUnitsConnection;
            }
        }
        if (ad() != null) {
            GraphQLIcon graphQLIcon = (GraphQLIcon) graphQLModelMutatingVisitor.mo2928b(ad());
            if (ad() != graphQLIcon) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15668J = graphQLIcon;
            }
        }
        if (ae() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLPlace) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15670L = graphQLPlace;
            }
        }
        if (af() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15671M = graphQLInlineActivitiesConnection;
            }
        }
        if (ag() != null) {
            GraphQLStoryInsights graphQLStoryInsights = (GraphQLStoryInsights) graphQLModelMutatingVisitor.mo2928b(ag());
            if (ag() != graphQLStoryInsights) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15672N = graphQLStoryInsights;
            }
        }
        if (aj() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aj());
            if (aj() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15675Q = graphQLTextWithEntities;
            }
        }
        if (ba() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(ba());
            if (ba() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.aJ = graphQLTextWithEntities;
            }
        }
        if (ak() != null) {
            a2 = ModelHelper.m23097a(ak(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLStory = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLStory.f15676R = a2.m1068b();
                graphQLVisitableModel2 = graphQLStory;
            }
        }
        if (mo2885C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(mo2885C());
            if (mo2885C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15677S = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (al() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(al());
            if (al() != graphQLPlace) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15678T = graphQLPlace;
            }
        }
        if (am() != null) {
            GraphQLPlaceRecommendationPostInfo graphQLPlaceRecommendationPostInfo = (GraphQLPlaceRecommendationPostInfo) graphQLModelMutatingVisitor.mo2928b(am());
            if (am() != graphQLPlaceRecommendationPostInfo) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15679U = graphQLPlaceRecommendationPostInfo;
            }
        }
        if (an() != null) {
            GraphQLBoostedComponent graphQLBoostedComponent = (GraphQLBoostedComponent) graphQLModelMutatingVisitor.mo2928b(an());
            if (an() != graphQLBoostedComponent) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15680V = graphQLBoostedComponent;
            }
        }
        if (ao() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(ao());
            if (ao() != graphQLPrivacyScope) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15681W = graphQLPrivacyScope;
            }
        }
        if (ap() != null) {
            GraphQLPagePostPromotionInfo graphQLPagePostPromotionInfo = (GraphQLPagePostPromotionInfo) graphQLModelMutatingVisitor.mo2928b(ap());
            if (ap() != graphQLPagePostPromotionInfo) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15682X = graphQLPagePostPromotionInfo;
            }
        }
        if (aq() != null) {
            GraphQLRedSpaceStoryInfo graphQLRedSpaceStoryInfo = (GraphQLRedSpaceStoryInfo) graphQLModelMutatingVisitor.mo2928b(aq());
            if (aq() != graphQLRedSpaceStoryInfo) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15683Y = graphQLRedSpaceStoryInfo;
            }
        }
        if (ar() != null) {
            GraphQLSticker graphQLSticker = (GraphQLSticker) graphQLModelMutatingVisitor.mo2928b(ar());
            if (ar() != graphQLSticker) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15684Z = graphQLSticker;
            }
        }
        if (as() != null) {
            GraphQLStorySaveInfo graphQLStorySaveInfo = (GraphQLStorySaveInfo) graphQLModelMutatingVisitor.mo2928b(as());
            if (as() != graphQLStorySaveInfo) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.aa = graphQLStorySaveInfo;
            }
        }
        if (at() != null) {
            a2 = ModelHelper.m23097a(at(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLStory = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLStory.ab = a2.m1068b();
                graphQLVisitableModel2 = graphQLStory;
            }
        }
        if (av() != null) {
            GraphQLEntity graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.mo2928b(av());
            if (av() != graphQLEntity) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ad = graphQLEntity;
            }
        }
        if (aw() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aw());
            if (aw() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ae = graphQLTextWithEntities;
            }
        }
        if (ay() != null) {
            GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.mo2928b(ay());
            if (ay() != graphQLSponsoredData) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ag = graphQLSponsoredData;
            }
        }
        if (az() != null) {
            a2 = ModelHelper.m23097a(az(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLStory = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLStory.ah = a2.m1068b();
                graphQLVisitableModel2 = graphQLStory;
            }
        }
        if (aA() != null) {
            GraphQLStoryHeader graphQLStoryHeader = (GraphQLStoryHeader) graphQLModelMutatingVisitor.mo2928b(aA());
            if (aA() != graphQLStoryHeader) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ai = graphQLStoryHeader;
            }
        }
        if (aE() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aE());
            if (aE() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.am = graphQLTextWithEntities;
            }
        }
        if (aF() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aF());
            if (aF() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.an = graphQLTextWithEntities;
            }
        }
        if (aG() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(aG());
            if (aG() != graphQLStory) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ao = graphQLStory;
            }
        }
        if (aH() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aH());
            if (aH() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ap = graphQLTextWithEntities;
            }
        }
        if (aI() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aI());
            if (aI() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.aq = graphQLTextWithEntities;
            }
        }
        if (aJ() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(aJ());
            if (aJ() != graphQLProfile) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ar = graphQLProfile;
            }
        }
        if (aK() != null) {
            GraphQLStoryTopicsContext graphQLStoryTopicsContext = (GraphQLStoryTopicsContext) graphQLModelMutatingVisitor.mo2928b(aK());
            if (aK() != graphQLStoryTopicsContext) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.as = graphQLStoryTopicsContext;
            }
        }
        if (aL() != null) {
            GraphQLPostTranslatability graphQLPostTranslatability = (GraphQLPostTranslatability) graphQLModelMutatingVisitor.mo2928b(aL());
            if (aL() != graphQLPostTranslatability) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.au = graphQLPostTranslatability;
            }
        }
        if (aM() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aM());
            if (aM() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.av = graphQLTextWithEntities;
            }
        }
        if (aN() != null) {
            GraphQLTranslationMetaData graphQLTranslationMetaData = (GraphQLTranslationMetaData) graphQLModelMutatingVisitor.mo2928b(aN());
            if (aN() != graphQLTranslationMetaData) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.aw = graphQLTranslationMetaData;
            }
        }
        if (aP() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(aP());
            if (aP() != graphQLActor) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.ay = graphQLActor;
            }
        }
        if (aR() != null) {
            GraphQLWithTagsConnection graphQLWithTagsConnection = (GraphQLWithTagsConnection) graphQLModelMutatingVisitor.mo2928b(aR());
            if (aR() != graphQLWithTagsConnection) {
                graphQLVisitableModel2 = (GraphQLStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.aA = graphQLWithTagsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_group_did_approve".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aT());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 81;
        } else if ("local_group_did_ignore_report".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aU());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 82;
        } else if ("local_group_did_pin".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aV());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 83;
        } else if ("local_group_did_unpin".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aW());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 84;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = aX();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 85;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = aY();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 86;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(bb());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 89;
        } else {
            BaseModel ao;
            if ("privacy_scope.type".equals(str)) {
                ao = ao();
                if (ao != null) {
                    consistencyTuple.f18727a = ao.m23522s();
                    consistencyTuple.f18728b = ao.u_();
                    consistencyTuple.f18729c = 10;
                    return;
                }
            } else if ("save_info.viewer_save_state".equals(str)) {
                ao = as();
                if (ao != null) {
                    consistencyTuple.f18727a = ao.m24778m();
                    consistencyTuple.f18728b = ao.u_();
                    consistencyTuple.f18729c = 4;
                    return;
                }
            } else if ("seen_state".equals(str)) {
                consistencyTuple.f18727a = au();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 53;
                return;
            }
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("local_group_did_approve".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.aC = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 81, booleanValue);
            }
        } else if ("local_group_did_ignore_report".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.aD = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 82, booleanValue);
            }
        } else if ("local_group_did_pin".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.aE = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 83, booleanValue);
            }
        } else if ("local_group_did_unpin".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.aF = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 84, booleanValue);
            }
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            r7 = (String) obj;
            this.aG = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 85, r7);
            }
        } else if ("local_story_visibility".equals(str)) {
            r7 = (String) obj;
            this.aH = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 86, r7);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.aK = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 89, intValue);
            }
        } else if ("privacy_scope.type".equals(str)) {
            r0 = ao();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) r0.clone();
                graphQLPrivacyScope.m23511a((String) obj);
                this.f15681W = graphQLPrivacyScope;
                return;
            }
            r0.m23511a((String) obj);
        } else if ("save_info.viewer_save_state".equals(str)) {
            r0 = as();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLStorySaveInfo graphQLStorySaveInfo = (GraphQLStorySaveInfo) r0.clone();
                graphQLStorySaveInfo.m24774a((GraphQLSavedState) obj);
                this.aa = graphQLStorySaveInfo;
                return;
            }
            r0.m24774a((GraphQLSavedState) obj);
        } else if ("seen_state".equals(str)) {
            Enum enumR = (GraphQLStorySeenState) obj;
            this.ac = enumR;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 53, enumR);
            }
        }
    }

    public GraphQLStory() {
        super(92);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15697p = mutableFlatBuffer.m21540a(i, 12);
        this.f15698q = mutableFlatBuffer.m21540a(i, 13);
        this.f15699r = mutableFlatBuffer.m21540a(i, 14);
        this.f15700s = mutableFlatBuffer.m21540a(i, 15);
        this.f15701t = mutableFlatBuffer.m21540a(i, 16);
        this.f15702u = mutableFlatBuffer.m21540a(i, 17);
        this.f15705x = mutableFlatBuffer.m21525a(i, 20, 0);
        this.f15664F = mutableFlatBuffer.m21525a(i, 28, 0);
        this.f15666H = mutableFlatBuffer.m21540a(i, 30);
        this.f15673O = mutableFlatBuffer.m21540a(i, 38);
        this.al = mutableFlatBuffer.m21524a(i, 62, 0);
        this.az = mutableFlatBuffer.m21540a(i, 78);
        this.aC = mutableFlatBuffer.m21540a(i, 81);
        this.aD = mutableFlatBuffer.m21540a(i, 82);
        this.aE = mutableFlatBuffer.m21540a(i, 83);
        this.aF = mutableFlatBuffer.m21540a(i, 84);
        this.aI = mutableFlatBuffer.m21525a(i, 87, 0);
        this.aK = mutableFlatBuffer.m21524a(i, 89, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22319E());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m22320F());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m22349b());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m22321G());
        int c = flatBufferBuilder.m21509c(m22322H());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m22323I());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m22324J());
        int a7 = ModelHelper.m23094a(flatBufferBuilder, m22325K());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m22326L());
        int a9 = ModelHelper.m23094a(flatBufferBuilder, m22327M());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(m22334T());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m22335U());
        int b3 = flatBufferBuilder.m21502b(S_());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22337W());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22338X());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22339Y());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22340Z());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) mo2890l());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aa());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ab());
        int b4 = flatBufferBuilder.m21502b(mo2896y());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ad());
        int b5 = flatBufferBuilder.m21502b(m22350c());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ae());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) af());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ag());
        int b6 = flatBufferBuilder.m21502b(ai());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aj());
        int a23 = ModelHelper.m23094a(flatBufferBuilder, (List) ak());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) mo2885C());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) al());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) am());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) an());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ao());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ap());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aq());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ar());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) as());
        int a33 = ModelHelper.m23094a(flatBufferBuilder, (List) at());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) av());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aw());
        int b7 = flatBufferBuilder.m21502b(ax());
        int a36 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ay());
        int a37 = ModelHelper.m23094a(flatBufferBuilder, (List) az());
        int a38 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aA());
        int e = flatBufferBuilder.m21514e((List) aB());
        int e2 = flatBufferBuilder.m21514e((List) aC());
        int a39 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aE());
        int a40 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aF());
        int a41 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aG());
        int a42 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aH());
        int a43 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aI());
        int a44 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aJ());
        int a45 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aK());
        int b8 = flatBufferBuilder.m21502b(mo2877k());
        int a46 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aL());
        int a47 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aM());
        int a48 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aN());
        int b9 = flatBufferBuilder.m21502b(aO());
        int a49 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aP());
        int a50 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aR());
        int e3 = flatBufferBuilder.m21514e((List) aS());
        int b10 = flatBufferBuilder.m21502b(aX());
        int b11 = flatBufferBuilder.m21502b(aY());
        int a51 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ba());
        int a52 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bc());
        flatBufferBuilder.m21510c(91);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, c);
        flatBufferBuilder.m21507b(6, a5);
        flatBufferBuilder.m21507b(7, a6);
        flatBufferBuilder.m21507b(8, a7);
        flatBufferBuilder.m21507b(9, a8);
        flatBufferBuilder.m21507b(10, a9);
        flatBufferBuilder.m21507b(11, b);
        flatBufferBuilder.m21498a(12, m22328N());
        flatBufferBuilder.m21498a(13, m22329O());
        flatBufferBuilder.m21498a(14, m22330P());
        flatBufferBuilder.m21498a(15, m22331Q());
        flatBufferBuilder.m21498a(16, m22332R());
        flatBufferBuilder.m21498a(17, m22333S());
        flatBufferBuilder.m21507b(18, b2);
        flatBufferBuilder.m21507b(19, a10);
        flatBufferBuilder.m21495a(20, m22336V(), 0);
        flatBufferBuilder.m21507b(21, b3);
        flatBufferBuilder.m21507b(22, a11);
        flatBufferBuilder.m21507b(23, a12);
        flatBufferBuilder.m21507b(24, a13);
        flatBufferBuilder.m21507b(25, a14);
        flatBufferBuilder.m21507b(26, a15);
        flatBufferBuilder.m21507b(27, a16);
        flatBufferBuilder.m21495a(28, T_(), 0);
        flatBufferBuilder.m21507b(29, a17);
        flatBufferBuilder.m21498a(30, ac());
        flatBufferBuilder.m21507b(31, b4);
        flatBufferBuilder.m21507b(33, a18);
        flatBufferBuilder.m21507b(34, b5);
        flatBufferBuilder.m21507b(35, a19);
        flatBufferBuilder.m21507b(36, a20);
        flatBufferBuilder.m21507b(37, a21);
        flatBufferBuilder.m21498a(38, ah());
        flatBufferBuilder.m21507b(39, b6);
        flatBufferBuilder.m21507b(40, a22);
        flatBufferBuilder.m21507b(41, a23);
        flatBufferBuilder.m21507b(42, a24);
        flatBufferBuilder.m21507b(43, a25);
        flatBufferBuilder.m21507b(44, a26);
        flatBufferBuilder.m21507b(45, a27);
        flatBufferBuilder.m21507b(47, a28);
        flatBufferBuilder.m21507b(48, a29);
        flatBufferBuilder.m21507b(49, a30);
        flatBufferBuilder.m21507b(50, a31);
        flatBufferBuilder.m21507b(51, a32);
        flatBufferBuilder.m21507b(52, a33);
        flatBufferBuilder.m21496a(53, au() == GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : au());
        flatBufferBuilder.m21507b(54, a34);
        flatBufferBuilder.m21507b(55, a35);
        flatBufferBuilder.m21507b(56, b7);
        flatBufferBuilder.m21507b(57, a36);
        flatBufferBuilder.m21507b(58, a37);
        flatBufferBuilder.m21507b(59, a38);
        flatBufferBuilder.m21507b(60, e);
        flatBufferBuilder.m21507b(61, e2);
        flatBufferBuilder.m21494a(62, aD(), 0);
        flatBufferBuilder.m21507b(63, a39);
        flatBufferBuilder.m21507b(64, a40);
        flatBufferBuilder.m21507b(65, a41);
        flatBufferBuilder.m21507b(66, a42);
        flatBufferBuilder.m21507b(67, a43);
        flatBufferBuilder.m21507b(69, a44);
        flatBufferBuilder.m21507b(70, a45);
        flatBufferBuilder.m21507b(71, b8);
        flatBufferBuilder.m21507b(72, a46);
        flatBufferBuilder.m21507b(73, a47);
        flatBufferBuilder.m21507b(74, a48);
        flatBufferBuilder.m21507b(76, b9);
        flatBufferBuilder.m21507b(77, a49);
        flatBufferBuilder.m21498a(78, aQ());
        flatBufferBuilder.m21507b(79, a50);
        flatBufferBuilder.m21507b(80, e3);
        flatBufferBuilder.m21498a(81, aT());
        flatBufferBuilder.m21498a(82, aU());
        flatBufferBuilder.m21498a(83, aV());
        flatBufferBuilder.m21498a(84, aW());
        flatBufferBuilder.m21507b(85, b10);
        flatBufferBuilder.m21507b(86, b11);
        flatBufferBuilder.m21495a(87, aZ(), 0);
        flatBufferBuilder.m21507b(88, a51);
        flatBufferBuilder.m21494a(89, bb(), 0);
        flatBufferBuilder.m21507b(90, a52);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStory(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(92);
        this.f15686e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f15687f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLOpenGraphAction.class.getClassLoader()));
        this.f15688g = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f15689h = (GraphQLSubstoriesConnection) parcel.readValue(GraphQLSubstoriesConnection.class.getClassLoader());
        this.f15690i = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f15691j = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f15692k = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f15693l = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f15694m = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f15695n = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.aL = (GraphQLBackdatedTime) parcel.readValue(GraphQLBackdatedTime.class.getClassLoader());
        this.f15696o = parcel.readString();
        this.f15697p = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f15698q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f15699r = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f15700s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f15701t = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f15702u = z;
        this.f15703v = parcel.readString();
        this.f15704w = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f15705x = parcel.readLong();
        this.f15706y = parcel.readString();
        this.f15707z = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15659A = (GraphQLEditHistoryConnection) parcel.readValue(GraphQLEditHistoryConnection.class.getClassLoader());
        this.f15660B = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f15661C = (GraphQLFeedTopicContent) parcel.readValue(GraphQLFeedTopicContent.class.getClassLoader());
        this.f15662D = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f15663E = (GraphQLFeedbackContext) parcel.readValue(GraphQLFeedbackContext.class.getClassLoader());
        this.f15664F = parcel.readLong();
        this.f15665G = (GraphQLFollowUpFeedUnitsConnection) parcel.readValue(GraphQLFollowUpFeedUnitsConnection.class.getClassLoader());
        this.f15666H = parcel.readByte() == (byte) 1;
        this.f15667I = parcel.readString();
        this.f15668J = (GraphQLIcon) parcel.readValue(GraphQLIcon.class.getClassLoader());
        this.f15669K = parcel.readString();
        this.f15670L = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f15671M = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f15672N = (GraphQLStoryInsights) parcel.readValue(GraphQLStoryInsights.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f15673O = z;
        this.f15674P = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aC = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aD = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aE = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aF = z;
        this.aG = parcel.readString();
        this.aH = parcel.readString();
        this.aK = parcel.readInt();
        this.f15675Q = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aJ = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15676R = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f15677S = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f15678T = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f15679U = (GraphQLPlaceRecommendationPostInfo) parcel.readValue(GraphQLPlaceRecommendationPostInfo.class.getClassLoader());
        this.f15680V = (GraphQLBoostedComponent) parcel.readValue(GraphQLBoostedComponent.class.getClassLoader());
        this.f15681W = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f15682X = (GraphQLPagePostPromotionInfo) parcel.readValue(GraphQLPagePostPromotionInfo.class.getClassLoader());
        this.f15683Y = (GraphQLRedSpaceStoryInfo) parcel.readValue(GraphQLRedSpaceStoryInfo.class.getClassLoader());
        this.f15684Z = (GraphQLSticker) parcel.readValue(GraphQLSticker.class.getClassLoader());
        this.aa = (GraphQLStorySaveInfo) parcel.readValue(GraphQLStorySaveInfo.class.getClassLoader());
        this.ab = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.ac = GraphQLStorySeenState.fromString(parcel.readString());
        this.ad = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.ae = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.af = parcel.readString();
        this.ag = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.ah = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.ai = (GraphQLStoryHeader) parcel.readValue(GraphQLStoryHeader.class.getClassLoader());
        this.aI = parcel.readLong();
        this.aj = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryTimestampStyle.class.getClassLoader()));
        this.ak = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSubstoriesGroupingReason.class.getClassLoader()));
        this.al = parcel.readInt();
        this.am = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.an = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ao = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.ap = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aq = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ar = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.as = (GraphQLStoryTopicsContext) parcel.readValue(GraphQLStoryTopicsContext.class.getClassLoader());
        this.at = parcel.readString();
        this.au = (GraphQLPostTranslatability) parcel.readValue(GraphQLPostTranslatability.class.getClassLoader());
        this.av = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aw = (GraphQLTranslationMetaData) parcel.readValue(GraphQLTranslationMetaData.class.getClassLoader());
        this.ax = parcel.readString();
        this.ay = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.aB = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEditPostFeatureCapability.class.getClassLoader()));
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.az = z2;
        this.aA = (GraphQLWithTagsConnection) parcel.readValue(GraphQLWithTagsConnection.class.getClassLoader());
        this.aM = (StoryExtra) ParcelUtil.b(parcel, StoryExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeList(m22319E());
        parcel.writeList(m22320F());
        parcel.writeList(m22349b());
        parcel.writeValue(m22321G());
        parcel.writeList(m22322H());
        parcel.writeValue(m22323I());
        parcel.writeValue(m22324J());
        parcel.writeList(m22325K());
        parcel.writeValue(m22326L());
        parcel.writeList(m22327M());
        parcel.writeValue(bc());
        parcel.writeString(mo2507g());
        parcel.writeByte((byte) (m22328N() ? 1 : 0));
        if (m22329O()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22330P()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22331Q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22332R()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22333S()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m22334T());
        parcel.writeValue(m22335U());
        parcel.writeLong(m22336V());
        parcel.writeString(S_());
        parcel.writeValue(m22337W());
        parcel.writeValue(m22338X());
        parcel.writeValue(m22339Y());
        parcel.writeValue(m22340Z());
        parcel.writeValue(mo2890l());
        parcel.writeValue(aa());
        parcel.writeLong(T_());
        parcel.writeValue(ab());
        parcel.writeByte((byte) (ac() ? 1 : 0));
        parcel.writeString(mo2896y());
        parcel.writeValue(ad());
        parcel.writeString(m22350c());
        parcel.writeValue(ae());
        parcel.writeValue(af());
        parcel.writeValue(ag());
        if (ah()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(ai());
        if (aT()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aU()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aV()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aW()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(aX());
        parcel.writeString(aY());
        parcel.writeInt(bb());
        parcel.writeValue(aj());
        parcel.writeValue(ba());
        parcel.writeList(ak());
        parcel.writeValue(mo2885C());
        parcel.writeValue(al());
        parcel.writeValue(am());
        parcel.writeValue(an());
        parcel.writeValue(ao());
        parcel.writeValue(ap());
        parcel.writeValue(aq());
        parcel.writeValue(ar());
        parcel.writeValue(as());
        parcel.writeList(at());
        parcel.writeString(au().name());
        parcel.writeValue(av());
        parcel.writeValue(aw());
        parcel.writeString(ax());
        parcel.writeValue(ay());
        parcel.writeList(az());
        parcel.writeValue(aA());
        parcel.writeLong(aZ());
        parcel.writeList(aB());
        parcel.writeList(aC());
        parcel.writeInt(aD());
        parcel.writeValue(aE());
        parcel.writeValue(aF());
        parcel.writeValue(aG());
        parcel.writeValue(aH());
        parcel.writeValue(aI());
        parcel.writeValue(aJ());
        parcel.writeValue(aK());
        parcel.writeString(mo2877k());
        parcel.writeValue(aL());
        parcel.writeValue(aM());
        parcel.writeValue(aN());
        parcel.writeString(aO());
        parcel.writeValue(aP());
        parcel.writeList(aS());
        if (!aQ()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(aR());
        parcel.writeParcelable(bd(), i);
    }

    public GraphQLStory(Builder builder) {
        super(92);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15686e = builder.d;
        this.f15687f = builder.e;
        this.f15688g = builder.f;
        this.f15689h = builder.g;
        this.f15690i = builder.h;
        this.f15691j = builder.i;
        this.f15692k = builder.j;
        this.f15693l = builder.k;
        this.f15694m = builder.l;
        this.f15695n = builder.m;
        this.aL = builder.n;
        this.f15696o = builder.o;
        this.f15697p = builder.p;
        this.f15698q = builder.q;
        this.f15699r = builder.r;
        this.f15700s = builder.s;
        this.f15701t = builder.t;
        this.f15702u = builder.u;
        this.f15703v = builder.v;
        this.f15704w = builder.w;
        this.f15705x = builder.x;
        this.f15706y = builder.y;
        this.f15707z = builder.z;
        this.f15659A = builder.A;
        this.f15660B = builder.B;
        this.f15661C = builder.C;
        this.f15662D = builder.D;
        this.f15663E = builder.E;
        this.f15664F = builder.F;
        this.f15665G = builder.G;
        this.f15666H = builder.H;
        this.f15667I = builder.I;
        this.f15668J = builder.J;
        this.f15669K = builder.K;
        this.f15670L = builder.L;
        this.f15671M = builder.M;
        this.f15672N = builder.N;
        this.f15673O = builder.O;
        this.f15674P = builder.P;
        this.aC = builder.Q;
        this.aD = builder.R;
        this.aE = builder.S;
        this.aF = builder.T;
        this.aG = builder.U;
        this.aH = builder.V;
        this.aK = builder.W;
        this.f15675Q = builder.X;
        this.aJ = builder.Y;
        this.f15676R = builder.Z;
        this.f15677S = builder.aa;
        this.f15678T = builder.ab;
        this.f15679U = builder.ac;
        this.f15680V = builder.ad;
        this.f15681W = builder.ae;
        this.f15682X = builder.af;
        this.f15683Y = builder.ag;
        this.f15684Z = builder.ah;
        this.aa = builder.ai;
        this.ab = builder.aj;
        this.ac = builder.ak;
        this.ad = builder.al;
        this.ae = builder.am;
        this.af = builder.an;
        this.ag = builder.ao;
        this.ah = builder.ap;
        this.ai = builder.aq;
        this.aI = builder.ar;
        this.aj = builder.as;
        this.ak = builder.at;
        this.al = builder.au;
        this.am = builder.av;
        this.an = builder.aw;
        this.ao = builder.ax;
        this.ap = builder.ay;
        this.aq = builder.az;
        this.ar = builder.aA;
        this.as = builder.aB;
        this.at = builder.aC;
        this.au = builder.aD;
        this.av = builder.aE;
        this.aw = builder.aF;
        this.ax = builder.aG;
        this.ay = builder.aH;
        this.aB = builder.aI;
        this.az = builder.aJ;
        this.aA = builder.aK;
        this.aN = builder.aL;
    }

    public final StoryExtra bd() {
        if (this.aM == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.aM = new StoryExtra();
            } else {
                this.aM = (StoryExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, StoryExtra.class);
            }
        }
        return this.aM;
    }

    public final PropertyBag U_() {
        if (this.aN == null) {
            this.aN = new PropertyBag();
        }
        return this.aN;
    }

    @Deprecated
    public final void m22346a(PropertyBag propertyBag) {
        this.aN = propertyBag;
    }
}
