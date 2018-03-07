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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
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
/* compiled from: l */
public final class GraphQLPeopleYouMayInviteFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HideableUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLPeopleYouMayInviteFeedUnit> CREATOR = new 1();
    List<GraphQLSubstoriesGroupingReason> f18283A;
    @Nullable
    GraphQLTextWithEntities f18284B;
    @Nullable
    GraphQLTextWithEntities f18285C;
    @Nullable
    String f18286D;
    @Nullable
    String f18287E;
    @Nullable
    public String f18288F;
    @Nullable
    public String f18289G;
    public int f18290H;
    private PeopleYouMayInviteFeedUnitExtra f18291I;
    @Nullable
    private PropertyBag f18292J = null;
    GraphQLObjectType f18293d = new GraphQLObjectType(-1746223584);
    List<GraphQLStoryActionLink> f18294e;
    List<GraphQLActor> f18295f;
    @Nullable
    GraphQLPeopleYouMayInviteFeedUnitContactsConnection f18296g;
    @Nullable
    GraphQLImage f18297h;
    List<GraphQLStoryAttachment> f18298i;
    @Nullable
    String f18299j;
    long f18300k;
    @Nullable
    String f18301l;
    @Nullable
    GraphQLFeedback f18302m;
    @Nullable
    GraphQLFeedbackContext f18303n;
    long f18304o;
    @Nullable
    String f18305p;
    @Nullable
    String f18306q;
    @Nullable
    GraphQLTextWithEntities f18307r;
    List<GraphQLStoryAttachment> f18308s;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f18309t;
    @Nullable
    GraphQLTextWithEntities f18310u;
    @Nullable
    GraphQLPrivacyScope f18311v;
    GraphQLStorySeenState f18312w;
    @Nullable
    GraphQLEntity f18313x;
    @Nullable
    String f18314y;
    @Nullable
    GraphQLStoryHeader f18315z;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25654U();
    }

    public final /* synthetic */ List mo2882v() {
        return m25671r();
    }

    public final /* synthetic */ List mo2883w() {
        return m25666l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18293d;
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

    public final ImmutableList m25666l() {
        return ItemListFeedUnitImpl.m30147a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m25671r() {
        return ItemListFeedUnitImpl.m30147a(this);
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m25672s() {
        this.f18294e = super.m9944a(this.f18294e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f18294e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m25673t() {
        this.f18295f = super.m9944a(this.f18295f, 1, GraphQLActor.class);
        return (ImmutableList) this.f18295f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPeopleYouMayInviteFeedUnitContactsConnection m25674u() {
        this.f18296g = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) super.m9947a(this.f18296g, 2, GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class);
        return this.f18296g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m25677x() {
        this.f18297h = (GraphQLImage) super.m9947a(this.f18297h, 3, GraphQLImage.class);
        return this.f18297h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m25679z() {
        this.f18298i = super.m9944a(this.f18298i, 4, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f18298i;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18299j = super.m9948a(this.f18299j, 5);
        return this.f18299j;
    }

    @FieldOffset
    public final long m25634A() {
        m9949a(0, 6);
        return this.f18300k;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18301l = super.m9948a(this.f18301l, 7);
        return this.f18301l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m25635B() {
        this.f18302m = (GraphQLFeedback) super.m9947a(this.f18302m, 8, GraphQLFeedback.class);
        return this.f18302m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackContext m25636C() {
        this.f18303n = (GraphQLFeedbackContext) super.m9947a(this.f18303n, 9, GraphQLFeedbackContext.class);
        return this.f18303n;
    }

    @FieldOffset
    public final long T_() {
        m9949a(1, 2);
        return this.f18304o;
    }

    public final void mo2872a(long j) {
        this.f18304o = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f18305p = super.m9948a(this.f18305p, 11);
        return this.f18305p;
    }

    @FieldOffset
    @Nullable
    public final String m25637D() {
        this.f18306q = super.m9948a(this.f18306q, 12);
        return this.f18306q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25638E() {
        this.f18307r = (GraphQLTextWithEntities) super.m9947a(this.f18307r, 13, GraphQLTextWithEntities.class);
        return this.f18307r;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m25639F() {
        this.f18308s = super.m9944a(this.f18308s, 14, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f18308s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m25640G() {
        this.f18309t = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18309t, 15, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18309t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25641H() {
        this.f18310u = (GraphQLTextWithEntities) super.m9947a(this.f18310u, 16, GraphQLTextWithEntities.class);
        return this.f18310u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m25642I() {
        this.f18311v = (GraphQLPrivacyScope) super.m9947a(this.f18311v, 17, GraphQLPrivacyScope.class);
        return this.f18311v;
    }

    @FieldOffset
    public final GraphQLStorySeenState m25643J() {
        this.f18312w = (GraphQLStorySeenState) super.m9945a(this.f18312w, 18, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f18312w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity m25644K() {
        this.f18313x = (GraphQLEntity) super.m9947a(this.f18313x, 19, GraphQLEntity.class);
        return this.f18313x;
    }

    @FieldOffset
    @Nullable
    public final String m25645L() {
        this.f18314y = super.m9948a(this.f18314y, 21);
        return this.f18314y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryHeader m25646M() {
        this.f18315z = (GraphQLStoryHeader) super.m9947a(this.f18315z, 23, GraphQLStoryHeader.class);
        return this.f18315z;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSubstoriesGroupingReason> m25647N() {
        this.f18283A = super.m9953b(this.f18283A, 24, GraphQLSubstoriesGroupingReason.class);
        return (ImmutableList) this.f18283A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25648O() {
        this.f18284B = (GraphQLTextWithEntities) super.m9947a(this.f18284B, 26, GraphQLTextWithEntities.class);
        return this.f18284B;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25648O();
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25649P() {
        this.f18285C = (GraphQLTextWithEntities) super.m9947a(this.f18285C, 27, GraphQLTextWithEntities.class);
        return this.f18285C;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18286D = super.m9948a(this.f18286D, 28);
        return this.f18286D;
    }

    @FieldOffset
    @Nullable
    public final String m25650Q() {
        this.f18287E = super.m9948a(this.f18287E, 29);
        return this.f18287E;
    }

    @FieldOffset
    @Nullable
    public final String m25651R() {
        this.f18288F = super.m9948a(this.f18288F, 30);
        return this.f18288F;
    }

    @FieldOffset
    @Nullable
    public final String m25652S() {
        this.f18289G = super.m9948a(this.f18289G, 31);
        return this.f18289G;
    }

    @FieldOffset
    public final int m25653T() {
        m9949a(4, 0);
        return this.f18290H;
    }

    @Nullable
    public final String mo2834a() {
        return m25637D();
    }

    public final int jK_() {
        return -1746223584;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        Builder a2;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25672s() != null) {
            a = ModelHelper.m23097a(m25672s(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18294e = a.m1068b();
            }
        }
        if (m25673t() != null) {
            a = ModelHelper.m23097a(m25673t(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18295f = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m25674u() != null) {
            GraphQLPeopleYouMayInviteFeedUnitContactsConnection graphQLPeopleYouMayInviteFeedUnitContactsConnection = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) graphQLModelMutatingVisitor.mo2928b(m25674u());
            if (m25674u() != graphQLPeopleYouMayInviteFeedUnitContactsConnection) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18296g = graphQLPeopleYouMayInviteFeedUnitContactsConnection;
            }
        }
        if (m25677x() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m25677x());
            if (m25677x() != graphQLImage) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18297h = graphQLImage;
            }
        }
        if (m25679z() != null) {
            a2 = ModelHelper.m23097a(m25679z(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLPeopleYouMayInviteFeedUnit.f18298i = a2.m1068b();
                graphQLVisitableModel2 = graphQLPeopleYouMayInviteFeedUnit;
            }
        }
        if (m25635B() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m25635B());
            if (m25635B() != graphQLFeedback) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18302m = graphQLFeedback;
            }
        }
        if (m25636C() != null) {
            GraphQLFeedbackContext graphQLFeedbackContext = (GraphQLFeedbackContext) graphQLModelMutatingVisitor.mo2928b(m25636C());
            if (m25636C() != graphQLFeedbackContext) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18303n = graphQLFeedbackContext;
            }
        }
        if (m25638E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25638E());
            if (m25638E() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18307r = graphQLTextWithEntities;
            }
        }
        if (m25639F() != null) {
            a2 = ModelHelper.m23097a(m25639F(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLPeopleYouMayInviteFeedUnit.f18308s = a2.m1068b();
                graphQLVisitableModel2 = graphQLPeopleYouMayInviteFeedUnit;
            }
        }
        if (m25640G() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m25640G());
            if (m25640G() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18309t = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m25641H() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25641H());
            if (m25641H() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18310u = graphQLTextWithEntities;
            }
        }
        if (m25642I() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m25642I());
            if (m25642I() != graphQLPrivacyScope) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18311v = graphQLPrivacyScope;
            }
        }
        if (m25644K() != null) {
            GraphQLEntity graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.mo2928b(m25644K());
            if (m25644K() != graphQLEntity) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18313x = graphQLEntity;
            }
        }
        if (m25646M() != null) {
            GraphQLStoryHeader graphQLStoryHeader = (GraphQLStoryHeader) graphQLModelMutatingVisitor.mo2928b(m25646M());
            if (m25646M() != graphQLStoryHeader) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18315z = graphQLStoryHeader;
            }
        }
        if (m25648O() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25648O());
            if (m25648O() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18284B = graphQLTextWithEntities;
            }
        }
        if (m25649P() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25649P());
            if (m25649P() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayInviteFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18285C = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25651R();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 30;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25652S();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 31;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25653T());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 32;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18288F = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 30, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18289G = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 31, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18290H = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 32, intValue);
            }
        }
    }

    public GraphQLPeopleYouMayInviteFeedUnit() {
        super(34);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18300k = mutableFlatBuffer.m21525a(i, 6, 0);
        this.f18304o = mutableFlatBuffer.m21525a(i, 10, 0);
        this.f18290H = mutableFlatBuffer.m21524a(i, 32, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m25672s());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m25673t());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25674u());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25677x());
        int a5 = ModelHelper.m23094a(flatBufferBuilder, m25679z());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m25635B());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m25636C());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int b4 = flatBufferBuilder.m21502b(m25637D());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m25638E());
        int a9 = ModelHelper.m23094a(flatBufferBuilder, m25639F());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m25640G());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25641H());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25642I());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25644K());
        int b5 = flatBufferBuilder.m21502b(m25645L());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25646M());
        int e = flatBufferBuilder.m21514e((List) m25647N());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25648O());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m25649P());
        int b6 = flatBufferBuilder.m21502b(mo2877k());
        int b7 = flatBufferBuilder.m21502b(m25650Q());
        int b8 = flatBufferBuilder.m21502b(m25651R());
        int b9 = flatBufferBuilder.m21502b(m25652S());
        flatBufferBuilder.m21510c(33);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, a5);
        flatBufferBuilder.m21507b(5, b);
        flatBufferBuilder.m21495a(6, m25634A(), 0);
        flatBufferBuilder.m21507b(7, b2);
        flatBufferBuilder.m21507b(8, a6);
        flatBufferBuilder.m21507b(9, a7);
        flatBufferBuilder.m21495a(10, T_(), 0);
        flatBufferBuilder.m21507b(11, b3);
        flatBufferBuilder.m21507b(12, b4);
        flatBufferBuilder.m21507b(13, a8);
        flatBufferBuilder.m21507b(14, a9);
        flatBufferBuilder.m21507b(15, a10);
        flatBufferBuilder.m21507b(16, a11);
        flatBufferBuilder.m21507b(17, a12);
        flatBufferBuilder.m21496a(18, m25643J() == GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m25643J());
        flatBufferBuilder.m21507b(19, a13);
        flatBufferBuilder.m21507b(21, b5);
        flatBufferBuilder.m21507b(23, a14);
        flatBufferBuilder.m21507b(24, e);
        flatBufferBuilder.m21507b(26, a15);
        flatBufferBuilder.m21507b(27, a16);
        flatBufferBuilder.m21507b(28, b6);
        flatBufferBuilder.m21507b(29, b7);
        flatBufferBuilder.m21507b(30, b8);
        flatBufferBuilder.m21507b(31, b9);
        flatBufferBuilder.m21494a(32, m25653T(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPeopleYouMayInviteFeedUnit(Parcel parcel) {
        super(34);
        this.f18294e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f18295f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f18296g = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) parcel.readValue(GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class.getClassLoader());
        this.f18297h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f18298i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f18299j = parcel.readString();
        this.f18300k = parcel.readLong();
        this.f18301l = parcel.readString();
        this.f18302m = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f18303n = (GraphQLFeedbackContext) parcel.readValue(GraphQLFeedbackContext.class.getClassLoader());
        this.f18304o = parcel.readLong();
        this.f18305p = parcel.readString();
        this.f18306q = parcel.readString();
        this.f18288F = parcel.readString();
        this.f18289G = parcel.readString();
        this.f18290H = parcel.readInt();
        this.f18307r = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18308s = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f18309t = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18310u = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18311v = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f18312w = GraphQLStorySeenState.fromString(parcel.readString());
        this.f18313x = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.f18314y = parcel.readString();
        this.f18315z = (GraphQLStoryHeader) parcel.readValue(GraphQLStoryHeader.class.getClassLoader());
        this.f18283A = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSubstoriesGroupingReason.class.getClassLoader()));
        this.f18284B = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18285C = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18286D = parcel.readString();
        this.f18287E = parcel.readString();
        this.f18291I = (PeopleYouMayInviteFeedUnitExtra) ParcelUtil.b(parcel, PeopleYouMayInviteFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m25672s());
        parcel.writeList(m25673t());
        parcel.writeValue(m25674u());
        parcel.writeValue(m25677x());
        parcel.writeList(m25679z());
        parcel.writeString(mo2507g());
        parcel.writeLong(m25634A());
        parcel.writeString(S_());
        parcel.writeValue(m25635B());
        parcel.writeValue(m25636C());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeString(m25637D());
        parcel.writeString(m25651R());
        parcel.writeString(m25652S());
        parcel.writeInt(m25653T());
        parcel.writeValue(m25638E());
        parcel.writeList(m25639F());
        parcel.writeValue(m25640G());
        parcel.writeValue(m25641H());
        parcel.writeValue(m25642I());
        parcel.writeString(m25643J().name());
        parcel.writeValue(m25644K());
        parcel.writeString(m25645L());
        parcel.writeValue(m25646M());
        parcel.writeList(m25647N());
        parcel.writeValue(m25648O());
        parcel.writeValue(m25649P());
        parcel.writeString(mo2877k());
        parcel.writeString(m25650Q());
        parcel.writeParcelable(m25654U(), i);
    }

    public GraphQLPeopleYouMayInviteFeedUnit(Builder builder) {
        super(34);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18294e = builder.d;
        this.f18295f = builder.e;
        this.f18296g = builder.f;
        this.f18297h = builder.g;
        this.f18298i = builder.h;
        this.f18299j = builder.i;
        this.f18300k = builder.j;
        this.f18301l = builder.k;
        this.f18302m = builder.l;
        this.f18303n = builder.m;
        this.f18304o = builder.n;
        this.f18305p = builder.o;
        this.f18306q = builder.p;
        this.f18288F = builder.q;
        this.f18289G = builder.r;
        this.f18290H = builder.s;
        this.f18307r = builder.t;
        this.f18308s = builder.u;
        this.f18309t = builder.v;
        this.f18310u = builder.w;
        this.f18311v = builder.x;
        this.f18312w = builder.y;
        this.f18313x = builder.z;
        this.f18314y = builder.A;
        this.f18315z = builder.B;
        this.f18283A = builder.C;
        this.f18284B = builder.D;
        this.f18285C = builder.E;
        this.f18286D = builder.F;
        this.f18287E = builder.G;
        this.f18292J = builder.H;
    }

    public final PeopleYouMayInviteFeedUnitExtra m25654U() {
        if (this.f18291I == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18291I = new PeopleYouMayInviteFeedUnitExtra();
            } else {
                this.f18291I = (PeopleYouMayInviteFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PeopleYouMayInviteFeedUnitExtra.class);
            }
        }
        return this.f18291I;
    }

    public final PropertyBag U_() {
        if (this.f18292J == null) {
            this.f18292J = new PropertyBag();
        }
        return this.f18292J;
    }
}
