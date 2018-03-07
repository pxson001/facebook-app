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
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
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
/* compiled from: last_cleanup */
public final class GraphQLGoodwillThrowbackPromotionFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HasNegativeFeedbackActions, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLGoodwillThrowbackPromotionFeedUnit> CREATOR = new 1();
    @Nullable
    String f18068A;
    @Nullable
    String f18069B;
    int f18070C;
    @Nullable
    public String f18071D;
    @Nullable
    public String f18072E;
    public int f18073F;
    private GoodwillThrowbackPromotionFeedUnitExtra f18074G;
    @Nullable
    private PropertyBag f18075H = null;
    GraphQLObjectType f18076d = new GraphQLObjectType(-1526076857);
    @Nullable
    GraphQLImage f18077e;
    List<GraphQLStoryActionLink> f18078f;
    List<GraphQLImage> f18079g;
    @Nullable
    String f18080h;
    @Nullable
    GraphQLTextWithEntities f18081i;
    @Nullable
    GraphQLGoodwillThrowbackPromotedCampaignsConnection f18082j;
    @Nullable
    GraphQLGoodwillThrowbackPromotionColorPalette f18083k;
    @Nullable
    GraphQLTextWithEntities f18084l;
    @Nullable
    String f18085m;
    @Nullable
    GraphQLImage f18086n;
    long f18087o;
    @Nullable
    GraphQLImage f18088p;
    @Nullable
    String f18089q;
    @Nullable
    String f18090r;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f18091s;
    @Nullable
    GraphQLPrivacyScope f18092t;
    @Nullable
    GraphQLGoodwillThrowbackPromotedStoriesConnection f18093u;
    @Nullable
    String f18094v;
    @Nullable
    String f18095w;
    List<GraphQLStoryActionLink> f18096x;
    @Nullable
    GraphQLTextWithEntities f18097y;
    @Nullable
    GraphQLTextWithEntities f18098z;

    public final String mo2892r() {
        return m25363B();
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25361P();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18076d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
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

    @FieldOffset
    @Nullable
    public final GraphQLImage m25388l() {
        this.f18077e = (GraphQLImage) super.m9947a(this.f18077e, 0, GraphQLImage.class);
        return this.f18077e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m25389m() {
        this.f18078f = super.m9944a(this.f18078f, 1, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f18078f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImage> m25390n() {
        this.f18079g = super.m9944a(this.f18079g, 2, GraphQLImage.class);
        return (ImmutableList) this.f18079g;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18080h = super.m9948a(this.f18080h, 3);
        return this.f18080h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25397u() {
        this.f18081i = (GraphQLTextWithEntities) super.m9947a(this.f18081i, 4, GraphQLTextWithEntities.class);
        return this.f18081i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackPromotedCampaignsConnection m25398v() {
        this.f18082j = (GraphQLGoodwillThrowbackPromotedCampaignsConnection) super.m9947a(this.f18082j, 5, GraphQLGoodwillThrowbackPromotedCampaignsConnection.class);
        return this.f18082j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackPromotionColorPalette m25399w() {
        this.f18083k = (GraphQLGoodwillThrowbackPromotionColorPalette) super.m9947a(this.f18083k, 6, GraphQLGoodwillThrowbackPromotionColorPalette.class);
        return this.f18083k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25400x() {
        this.f18084l = (GraphQLTextWithEntities) super.m9947a(this.f18084l, 7, GraphQLTextWithEntities.class);
        return this.f18084l;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18085m = super.m9948a(this.f18085m, 8);
        return this.f18085m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m25402z() {
        this.f18086n = (GraphQLImage) super.m9947a(this.f18086n, 9, GraphQLImage.class);
        return this.f18086n;
    }

    @FieldOffset
    public final long T_() {
        m9949a(1, 2);
        return this.f18087o;
    }

    public final void mo2872a(long j) {
        this.f18087o = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m25362A() {
        this.f18088p = (GraphQLImage) super.m9947a(this.f18088p, 11, GraphQLImage.class);
        return this.f18088p;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f18089q = super.m9948a(this.f18089q, 12);
        return this.f18089q;
    }

    @FieldOffset
    @Nullable
    public final String m25363B() {
        this.f18090r = super.m9948a(this.f18090r, 13);
        return this.f18090r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection mo2885C() {
        this.f18091s = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18091s, 14, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18091s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m25365D() {
        this.f18092t = (GraphQLPrivacyScope) super.m9947a(this.f18092t, 15, GraphQLPrivacyScope.class);
        return this.f18092t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackPromotedStoriesConnection m25366E() {
        this.f18093u = (GraphQLGoodwillThrowbackPromotedStoriesConnection) super.m9947a(this.f18093u, 16, GraphQLGoodwillThrowbackPromotedStoriesConnection.class);
        return this.f18093u;
    }

    @FieldOffset
    @Nullable
    public final String m25367F() {
        this.f18094v = super.m9948a(this.f18094v, 17);
        return this.f18094v;
    }

    @FieldOffset
    @Nullable
    public final String m25368G() {
        this.f18095w = super.m9948a(this.f18095w, 19);
        return this.f18095w;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m25369H() {
        this.f18096x = super.m9944a(this.f18096x, 20, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f18096x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25370I() {
        this.f18097y = (GraphQLTextWithEntities) super.m9947a(this.f18097y, 21, GraphQLTextWithEntities.class);
        return this.f18097y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25371J() {
        this.f18098z = (GraphQLTextWithEntities) super.m9947a(this.f18098z, 22, GraphQLTextWithEntities.class);
        return this.f18098z;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18068A = super.m9948a(this.f18068A, 23);
        return this.f18068A;
    }

    @FieldOffset
    @Nullable
    public final String m25372K() {
        this.f18069B = super.m9948a(this.f18069B, 24);
        return this.f18069B;
    }

    @FieldOffset
    public final int m25373L() {
        m9949a(3, 1);
        return this.f18070C;
    }

    @FieldOffset
    @Nullable
    public final String m25374M() {
        this.f18071D = super.m9948a(this.f18071D, 26);
        return this.f18071D;
    }

    @FieldOffset
    @Nullable
    public final String m25375N() {
        this.f18072E = super.m9948a(this.f18072E, 27);
        return this.f18072E;
    }

    @FieldOffset
    public final int m25376O() {
        m9949a(3, 4);
        return this.f18073F;
    }

    @Nullable
    public final String mo2834a() {
        return m25363B();
    }

    public final int jK_() {
        return -1526076857;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25388l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m25388l());
            if (m25388l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18077e = graphQLImage;
            }
        }
        if (m25389m() != null) {
            a = ModelHelper.m23097a(m25389m(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLGoodwillThrowbackPromotionFeedUnit.f18078f = a.m1068b();
                graphQLVisitableModel = graphQLGoodwillThrowbackPromotionFeedUnit;
            }
        }
        if (m25390n() != null) {
            a = ModelHelper.m23097a(m25390n(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLGoodwillThrowbackPromotionFeedUnit.f18079g = a.m1068b();
                graphQLVisitableModel = graphQLGoodwillThrowbackPromotionFeedUnit;
            }
        }
        if (m25397u() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25397u());
            if (m25397u() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18081i = graphQLTextWithEntities;
            }
        }
        if (m25398v() != null) {
            GraphQLGoodwillThrowbackPromotedCampaignsConnection graphQLGoodwillThrowbackPromotedCampaignsConnection = (GraphQLGoodwillThrowbackPromotedCampaignsConnection) graphQLModelMutatingVisitor.mo2928b(m25398v());
            if (m25398v() != graphQLGoodwillThrowbackPromotedCampaignsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18082j = graphQLGoodwillThrowbackPromotedCampaignsConnection;
            }
        }
        if (m25399w() != null) {
            GraphQLGoodwillThrowbackPromotionColorPalette graphQLGoodwillThrowbackPromotionColorPalette = (GraphQLGoodwillThrowbackPromotionColorPalette) graphQLModelMutatingVisitor.mo2928b(m25399w());
            if (m25399w() != graphQLGoodwillThrowbackPromotionColorPalette) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18083k = graphQLGoodwillThrowbackPromotionColorPalette;
            }
        }
        if (m25400x() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25400x());
            if (m25400x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18084l = graphQLTextWithEntities;
            }
        }
        if (m25402z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m25402z());
            if (m25402z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18086n = graphQLImage;
            }
        }
        if (m25362A() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m25362A());
            if (m25362A() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18088p = graphQLImage;
            }
        }
        if (mo2885C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(mo2885C());
            if (mo2885C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18091s = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m25365D() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m25365D());
            if (m25365D() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18092t = graphQLPrivacyScope;
            }
        }
        if (m25366E() != null) {
            GraphQLGoodwillThrowbackPromotedStoriesConnection graphQLGoodwillThrowbackPromotedStoriesConnection = (GraphQLGoodwillThrowbackPromotedStoriesConnection) graphQLModelMutatingVisitor.mo2928b(m25366E());
            if (m25366E() != graphQLGoodwillThrowbackPromotedStoriesConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18093u = graphQLGoodwillThrowbackPromotedStoriesConnection;
            }
        }
        if (m25369H() != null) {
            a = ModelHelper.m23097a(m25369H(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLGoodwillThrowbackPromotionFeedUnit.f18096x = a.m1068b();
                graphQLVisitableModel = graphQLGoodwillThrowbackPromotionFeedUnit;
            }
        }
        if (m25370I() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25370I());
            if (m25370I() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18097y = graphQLTextWithEntities;
            }
        }
        if (m25371J() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25371J());
            if (m25371J() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18098z = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25374M();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 26;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25375N();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 27;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25376O());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 28;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18071D = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 26, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18072E = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 27, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18073F = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 28, intValue);
            }
        }
    }

    public GraphQLGoodwillThrowbackPromotionFeedUnit() {
        super(30);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18087o = mutableFlatBuffer.m21525a(i, 10, 0);
        this.f18070C = mutableFlatBuffer.m21524a(i, 25, 0);
        this.f18073F = mutableFlatBuffer.m21524a(i, 28, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m25388l());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m25389m());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m25390n());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25397u());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m25398v());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m25399w());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m25400x());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m25402z());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m25362A());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int b4 = flatBufferBuilder.m21502b(m25363B());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, mo2885C());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25365D());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25366E());
        int b5 = flatBufferBuilder.m21502b(m25367F());
        int b6 = flatBufferBuilder.m21502b(m25368G());
        int a13 = ModelHelper.m23094a(flatBufferBuilder, (List) m25369H());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25370I());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25371J());
        int b7 = flatBufferBuilder.m21502b(mo2877k());
        int b8 = flatBufferBuilder.m21502b(m25372K());
        int b9 = flatBufferBuilder.m21502b(m25374M());
        int b10 = flatBufferBuilder.m21502b(m25375N());
        flatBufferBuilder.m21510c(29);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, a5);
        flatBufferBuilder.m21507b(6, a6);
        flatBufferBuilder.m21507b(7, a7);
        flatBufferBuilder.m21507b(8, b2);
        flatBufferBuilder.m21507b(9, a8);
        flatBufferBuilder.m21495a(10, T_(), 0);
        flatBufferBuilder.m21507b(11, a9);
        flatBufferBuilder.m21507b(12, b3);
        flatBufferBuilder.m21507b(13, b4);
        flatBufferBuilder.m21507b(14, a10);
        flatBufferBuilder.m21507b(15, a11);
        flatBufferBuilder.m21507b(16, a12);
        flatBufferBuilder.m21507b(17, b5);
        flatBufferBuilder.m21507b(19, b6);
        flatBufferBuilder.m21507b(20, a13);
        flatBufferBuilder.m21507b(21, a14);
        flatBufferBuilder.m21507b(22, a15);
        flatBufferBuilder.m21507b(23, b7);
        flatBufferBuilder.m21507b(24, b8);
        flatBufferBuilder.m21494a(25, m25373L(), 0);
        flatBufferBuilder.m21507b(26, b9);
        flatBufferBuilder.m21507b(27, b10);
        flatBufferBuilder.m21494a(28, m25376O(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGoodwillThrowbackPromotionFeedUnit(Parcel parcel) {
        super(30);
        this.f18077e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f18078f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f18079g = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLImage.class.getClassLoader()));
        this.f18080h = parcel.readString();
        this.f18081i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18082j = (GraphQLGoodwillThrowbackPromotedCampaignsConnection) parcel.readValue(GraphQLGoodwillThrowbackPromotedCampaignsConnection.class.getClassLoader());
        this.f18083k = (GraphQLGoodwillThrowbackPromotionColorPalette) parcel.readValue(GraphQLGoodwillThrowbackPromotionColorPalette.class.getClassLoader());
        this.f18084l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18085m = parcel.readString();
        this.f18086n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f18087o = parcel.readLong();
        this.f18088p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f18089q = parcel.readString();
        this.f18090r = parcel.readString();
        this.f18071D = parcel.readString();
        this.f18072E = parcel.readString();
        this.f18073F = parcel.readInt();
        this.f18091s = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18092t = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f18093u = (GraphQLGoodwillThrowbackPromotedStoriesConnection) parcel.readValue(GraphQLGoodwillThrowbackPromotedStoriesConnection.class.getClassLoader());
        this.f18094v = parcel.readString();
        this.f18095w = parcel.readString();
        this.f18096x = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f18097y = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18098z = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18068A = parcel.readString();
        this.f18069B = parcel.readString();
        this.f18070C = parcel.readInt();
        this.f18074G = (GoodwillThrowbackPromotionFeedUnitExtra) ParcelUtil.b(parcel, GoodwillThrowbackPromotionFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m25388l());
        parcel.writeList(m25389m());
        parcel.writeList(m25390n());
        parcel.writeString(mo2507g());
        parcel.writeValue(m25397u());
        parcel.writeValue(m25398v());
        parcel.writeValue(m25399w());
        parcel.writeValue(m25400x());
        parcel.writeString(S_());
        parcel.writeValue(m25402z());
        parcel.writeLong(T_());
        parcel.writeValue(m25362A());
        parcel.writeString(mo2896y());
        parcel.writeString(m25363B());
        parcel.writeString(m25374M());
        parcel.writeString(m25375N());
        parcel.writeInt(m25376O());
        parcel.writeValue(mo2885C());
        parcel.writeValue(m25365D());
        parcel.writeValue(m25366E());
        parcel.writeString(m25367F());
        parcel.writeString(m25368G());
        parcel.writeList(m25369H());
        parcel.writeValue(m25370I());
        parcel.writeValue(m25371J());
        parcel.writeString(mo2877k());
        parcel.writeString(m25372K());
        parcel.writeInt(m25373L());
        parcel.writeParcelable(m25361P(), i);
    }

    private GoodwillThrowbackPromotionFeedUnitExtra m25361P() {
        if (this.f18074G == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18074G = new GoodwillThrowbackPromotionFeedUnitExtra();
            } else {
                this.f18074G = (GoodwillThrowbackPromotionFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, GoodwillThrowbackPromotionFeedUnitExtra.class);
            }
        }
        return this.f18074G;
    }

    public final PropertyBag U_() {
        if (this.f18075H == null) {
            this.f18075H = new PropertyBag();
        }
        return this.f18075H;
    }
}
