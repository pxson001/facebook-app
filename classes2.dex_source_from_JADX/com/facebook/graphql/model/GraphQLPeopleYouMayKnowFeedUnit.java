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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
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
/* compiled from: invalid_fbtrace_metadata */
public final class GraphQLPeopleYouMayKnowFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HideableUnit, PeopleYouMayKnowFeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, FollowUpFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLPeopleYouMayKnowFeedUnit> CREATOR = new 1();
    @Nullable
    String f19539A;
    @Nullable
    public String f19540B;
    @Nullable
    public String f19541C;
    public int f19542D;
    private PeopleYouMayKnowFeedUnitExtra f19543E;
    @Nullable
    private PropertyBag f19544F = null;
    GraphQLObjectType f19545d = new GraphQLObjectType(-2066307870);
    @Deprecated
    List<GraphQLStoryActionLink> f19546e;
    @Deprecated
    List<GraphQLActor> f19547f;
    @Deprecated
    List<GraphQLStoryAttachment> f19548g;
    @Nullable
    String f19549h;
    @Deprecated
    long f19550i;
    @Nullable
    String f19551j;
    @Deprecated
    @Nullable
    GraphQLFeedback f19552k;
    @Deprecated
    @Nullable
    GraphQLFeedbackContext f19553l;
    long f19554m;
    @Deprecated
    @Nullable
    String f19555n;
    List<GraphQLPeopleYouMayKnowFeedUnitItem> f19556o;
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f19557p;
    @Deprecated
    List<GraphQLStoryAttachment> f19558q;
    @Deprecated
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f19559r;
    @Deprecated
    @Nullable
    GraphQLPrivacyScope f19560s;
    List<GraphQLPeopleYouMayKnowFeedUnitItem> f19561t;
    @Deprecated
    GraphQLStorySeenState f19562u;
    @Deprecated
    @Nullable
    GraphQLEntity f19563v;
    @Nullable
    String f19564w;
    @Deprecated
    @Nullable
    GraphQLStoryHeader f19565x;
    @Deprecated
    List<GraphQLSubstoriesGroupingReason> f19566y;
    @Nullable
    GraphQLTextWithEntities f19567z;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m27224Q();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f19545d;
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

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30148a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m27250l() {
        this.f19546e = super.m9944a(this.f19546e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f19546e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m27255r() {
        this.f19547f = super.m9944a(this.f19547f, 1, GraphQLActor.class);
        return (ImmutableList) this.f19547f;
    }

    public final List mo2882v() {
        Builder builder = new Builder();
        ImmutableList a = ItemListFeedUnitImpl.m30148a(this);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem = (GraphQLPeopleYouMayKnowFeedUnitItem) a.get(i);
            if (IsValidUtil.m22961a(graphQLPeopleYouMayKnowFeedUnitItem)) {
                builder.m1069c(graphQLPeopleYouMayKnowFeedUnitItem);
            }
        }
        return builder.m1068b();
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m27256s() {
        this.f19548g = super.m9944a(this.f19548g, 2, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f19548g;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f19549h = super.m9948a(this.f19549h, 3);
        return this.f19549h;
    }

    @FieldOffset
    public final long m27257t() {
        m9949a(0, 4);
        return this.f19550i;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f19551j = super.m9948a(this.f19551j, 5);
        return this.f19551j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m27258u() {
        this.f19552k = (GraphQLFeedback) super.m9947a(this.f19552k, 6, GraphQLFeedback.class);
        return this.f19552k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackContext m27261x() {
        this.f19553l = (GraphQLFeedbackContext) super.m9947a(this.f19553l, 7, GraphQLFeedbackContext.class);
        return this.f19553l;
    }

    @FieldOffset
    public final long T_() {
        m9949a(1, 0);
        return this.f19554m;
    }

    public final void mo2872a(long j) {
        this.f19554m = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f19555n = super.m9948a(this.f19555n, 9);
        return this.f19555n;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> m27263z() {
        this.f19556o = super.m9944a(this.f19556o, 10, GraphQLPeopleYouMayKnowFeedUnitItem.class);
        return (ImmutableList) this.f19556o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27225A() {
        this.f19557p = (GraphQLTextWithEntities) super.m9947a(this.f19557p, 11, GraphQLTextWithEntities.class);
        return this.f19557p;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m27226B() {
        this.f19558q = super.m9944a(this.f19558q, 12, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f19558q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m27227C() {
        this.f19559r = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f19559r, 13, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f19559r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m27228D() {
        this.f19560s = (GraphQLPrivacyScope) super.m9947a(this.f19560s, 14, GraphQLPrivacyScope.class);
        return this.f19560s;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> m27229E() {
        this.f19561t = super.m9944a(this.f19561t, 15, GraphQLPeopleYouMayKnowFeedUnitItem.class);
        return (ImmutableList) this.f19561t;
    }

    @FieldOffset
    public final GraphQLStorySeenState m27230F() {
        this.f19562u = (GraphQLStorySeenState) super.m9945a(this.f19562u, 16, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19562u;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity m27231G() {
        this.f19563v = (GraphQLEntity) super.m9947a(this.f19563v, 17, GraphQLEntity.class);
        return this.f19563v;
    }

    @FieldOffset
    @Nullable
    public final String m27232H() {
        this.f19564w = super.m9948a(this.f19564w, 18);
        return this.f19564w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryHeader m27233I() {
        this.f19565x = (GraphQLStoryHeader) super.m9947a(this.f19565x, 20, GraphQLStoryHeader.class);
        return this.f19565x;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSubstoriesGroupingReason> m27234J() {
        this.f19566y = super.m9953b(this.f19566y, 21, GraphQLSubstoriesGroupingReason.class);
        return (ImmutableList) this.f19566y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27235K() {
        this.f19567z = (GraphQLTextWithEntities) super.m9947a(this.f19567z, 23, GraphQLTextWithEntities.class);
        return this.f19567z;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f19539A = super.m9948a(this.f19539A, 24);
        return this.f19539A;
    }

    @FieldOffset
    @Nullable
    public final String m27236L() {
        this.f19540B = super.m9948a(this.f19540B, 25);
        return this.f19540B;
    }

    @FieldOffset
    @Nullable
    public final String m27237M() {
        this.f19541C = super.m9948a(this.f19541C, 26);
        return this.f19541C;
    }

    @FieldOffset
    public final int m27238N() {
        m9949a(3, 3);
        return this.f19542D;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -2066307870;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        Builder a2;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27250l() != null) {
            a = ModelHelper.m23097a(m27250l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19546e = a.m1068b();
            }
        }
        if (m27255r() != null) {
            a = ModelHelper.m23097a(m27255r(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19547f = a.m1068b();
            }
        }
        if (m27256s() != null) {
            a = ModelHelper.m23097a(m27256s(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19548g = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m27258u() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m27258u());
            if (m27258u() != graphQLFeedback) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19552k = graphQLFeedback;
            }
        }
        if (m27261x() != null) {
            GraphQLFeedbackContext graphQLFeedbackContext = (GraphQLFeedbackContext) graphQLModelMutatingVisitor.mo2928b(m27261x());
            if (m27261x() != graphQLFeedbackContext) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19553l = graphQLFeedbackContext;
            }
        }
        if (m27263z() != null) {
            a2 = ModelHelper.m23097a(m27263z(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                GraphQLPeopleYouMayKnowFeedUnit graphQLPeopleYouMayKnowFeedUnit = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLPeopleYouMayKnowFeedUnit.f19556o = a2.m1068b();
                graphQLVisitableModel2 = graphQLPeopleYouMayKnowFeedUnit;
            }
        }
        if (m27225A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27225A());
            if (m27225A() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19557p = graphQLTextWithEntities;
            }
        }
        if (m27226B() != null) {
            a2 = ModelHelper.m23097a(m27226B(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLPeopleYouMayKnowFeedUnit = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLPeopleYouMayKnowFeedUnit.f19558q = a2.m1068b();
                graphQLVisitableModel2 = graphQLPeopleYouMayKnowFeedUnit;
            }
        }
        if (m27227C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m27227C());
            if (m27227C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19559r = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m27228D() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m27228D());
            if (m27228D() != graphQLPrivacyScope) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19560s = graphQLPrivacyScope;
            }
        }
        if (m27229E() != null) {
            a2 = ModelHelper.m23097a(m27229E(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLPeopleYouMayKnowFeedUnit = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLPeopleYouMayKnowFeedUnit.f19561t = a2.m1068b();
                graphQLVisitableModel2 = graphQLPeopleYouMayKnowFeedUnit;
            }
        }
        if (m27231G() != null) {
            GraphQLEntity graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.mo2928b(m27231G());
            if (m27231G() != graphQLEntity) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19563v = graphQLEntity;
            }
        }
        if (m27233I() != null) {
            GraphQLStoryHeader graphQLStoryHeader = (GraphQLStoryHeader) graphQLModelMutatingVisitor.mo2928b(m27233I());
            if (m27233I() != graphQLStoryHeader) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19565x = graphQLStoryHeader;
            }
        }
        if (m27235K() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27235K());
            if (m27235K() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f19567z = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m27236L();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 25;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m27237M();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 26;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m27238N());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 27;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f19540B = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 25, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f19541C = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 26, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f19542D = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 27, intValue);
            }
        }
    }

    public GraphQLPeopleYouMayKnowFeedUnit() {
        super(29);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19550i = mutableFlatBuffer.m21525a(i, 4, 0);
        this.f19554m = mutableFlatBuffer.m21525a(i, 8, 0);
        this.f19542D = mutableFlatBuffer.m21524a(i, 27, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27250l());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m27255r());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m27256s());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27258u());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m27261x());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int a6 = ModelHelper.m23094a(flatBufferBuilder, m27263z());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m27225A());
        int a8 = ModelHelper.m23094a(flatBufferBuilder, m27226B());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m27227C());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m27228D());
        int a11 = ModelHelper.m23094a(flatBufferBuilder, m27229E());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m27231G());
        int b4 = flatBufferBuilder.m21502b(m27232H());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m27233I());
        int e = flatBufferBuilder.m21514e(m27234J());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m27235K());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m27236L());
        int b7 = flatBufferBuilder.m21502b(m27237M());
        flatBufferBuilder.m21510c(28);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21495a(4, m27257t(), 0);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, a5);
        flatBufferBuilder.m21495a(8, T_(), 0);
        flatBufferBuilder.m21507b(9, b3);
        flatBufferBuilder.m21507b(10, a6);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21507b(13, a9);
        flatBufferBuilder.m21507b(14, a10);
        flatBufferBuilder.m21507b(15, a11);
        flatBufferBuilder.m21496a(16, m27230F() == GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m27230F());
        flatBufferBuilder.m21507b(17, a12);
        flatBufferBuilder.m21507b(18, b4);
        flatBufferBuilder.m21507b(20, a13);
        flatBufferBuilder.m21507b(21, e);
        flatBufferBuilder.m21507b(23, a14);
        flatBufferBuilder.m21507b(24, b5);
        flatBufferBuilder.m21507b(25, b6);
        flatBufferBuilder.m21507b(26, b7);
        flatBufferBuilder.m21494a(27, m27238N(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPeopleYouMayKnowFeedUnit(Parcel parcel) {
        super(29);
        this.f19546e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f19547f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f19548g = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f19549h = parcel.readString();
        this.f19550i = parcel.readLong();
        this.f19551j = parcel.readString();
        this.f19552k = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f19553l = (GraphQLFeedbackContext) parcel.readValue(GraphQLFeedbackContext.class.getClassLoader());
        this.f19554m = parcel.readLong();
        this.f19555n = parcel.readString();
        this.f19556o = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPeopleYouMayKnowFeedUnitItem.class.getClassLoader()));
        this.f19540B = parcel.readString();
        this.f19541C = parcel.readString();
        this.f19542D = parcel.readInt();
        this.f19557p = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19558q = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f19559r = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f19560s = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f19561t = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPeopleYouMayKnowFeedUnitItem.class.getClassLoader()));
        this.f19562u = GraphQLStorySeenState.fromString(parcel.readString());
        this.f19563v = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.f19564w = parcel.readString();
        this.f19565x = (GraphQLStoryHeader) parcel.readValue(GraphQLStoryHeader.class.getClassLoader());
        this.f19566y = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSubstoriesGroupingReason.class.getClassLoader()));
        this.f19567z = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19539A = parcel.readString();
        this.f19543E = (PeopleYouMayKnowFeedUnitExtra) ParcelUtil.b(parcel, PeopleYouMayKnowFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m27250l());
        parcel.writeList(m27255r());
        parcel.writeList(m27256s());
        parcel.writeString(mo2507g());
        parcel.writeLong(m27257t());
        parcel.writeString(S_());
        parcel.writeValue(m27258u());
        parcel.writeValue(m27261x());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeList(m27263z());
        parcel.writeString(m27236L());
        parcel.writeString(m27237M());
        parcel.writeInt(m27238N());
        parcel.writeValue(m27225A());
        parcel.writeList(m27226B());
        parcel.writeValue(m27227C());
        parcel.writeValue(m27228D());
        parcel.writeList(m27229E());
        parcel.writeString(m27230F().name());
        parcel.writeValue(m27231G());
        parcel.writeString(m27232H());
        parcel.writeValue(m27233I());
        parcel.writeList(m27234J());
        parcel.writeValue(m27235K());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m27224Q(), i);
    }

    private PeopleYouMayKnowFeedUnitExtra m27224Q() {
        if (this.f19543E == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f19543E = new PeopleYouMayKnowFeedUnitExtra();
            } else {
                this.f19543E = (PeopleYouMayKnowFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PeopleYouMayKnowFeedUnitExtra.class);
            }
        }
        return this.f19543E;
    }

    public final PropertyBag U_() {
        if (this.f19544F == null) {
            this.f19544F = new PropertyBag();
        }
        return this.f19544F;
    }
}
