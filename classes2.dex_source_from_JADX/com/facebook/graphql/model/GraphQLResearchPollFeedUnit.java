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
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: key_value */
public final class GraphQLResearchPollFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HasNegativeFeedbackActions, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, ScrollableItemListFeedUnit, Sponsorable, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLResearchPollFeedUnit> CREATOR = new 1();
    @Nullable
    String f18425A;
    @Nullable
    public String f18426B;
    @Nullable
    public String f18427C;
    public int f18428D;
    private ResearchPollFeedUnitExtra f18429E;
    @Nullable
    private PropertyBag f18430F = null;
    GraphQLObjectType f18431d = new GraphQLObjectType(-1148667268);
    @Nullable
    GraphQLSponsoredData f18432e;
    @Nullable
    String f18433f;
    @Nullable
    String f18434g;
    @Nullable
    String f18435h;
    @Nullable
    String f18436i;
    long f18437j;
    @Nullable
    String f18438k;
    @Nullable
    String f18439l;
    @Nullable
    String f18440m;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f18441n;
    @Nullable
    String f18442o;
    @Nullable
    String f18443p;
    @Nullable
    GraphQLResearchPollSurvey f18444q;
    @Nullable
    String f18445r;
    @Nullable
    String f18446s;
    boolean f18447t;
    boolean f18448u;
    @Nullable
    String f18449v;
    @Nullable
    String f18450w;
    @Nullable
    GraphQLTextWithEntities f18451x;
    @Nullable
    GraphQLTextWithEntities f18452y;
    @Nullable
    String f18453z;

    public final String mo2892r() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25874U();
    }

    public final /* synthetic */ List mo2883w() {
        return m25896x();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18431d;
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

    public final ImmutableList m25896x() {
        return ItemListFeedUnitImpl.m30152a(this);
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return SponsoredImpression.m29328a(m25898z());
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

    public final List mo2882v() {
        return ItemListFeedUnitImpl.m30152a(this);
    }

    public final boolean mo2895u() {
        return ImpressionUtil.m29324a((Sponsorable) this);
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData m25898z() {
        this.f18432e = (GraphQLSponsoredData) super.m9947a(this.f18432e, 0, GraphQLSponsoredData.class);
        return this.f18432e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18433f = super.m9948a(this.f18433f, 1);
        return this.f18433f;
    }

    @FieldOffset
    @Nullable
    public final String m25854A() {
        this.f18434g = super.m9948a(this.f18434g, 2);
        return this.f18434g;
    }

    @FieldOffset
    @Nullable
    public final String m25855B() {
        this.f18435h = super.m9948a(this.f18435h, 3);
        return this.f18435h;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18436i = super.m9948a(this.f18436i, 4);
        return this.f18436i;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 5);
        return this.f18437j;
    }

    public final void mo2872a(long j) {
        this.f18437j = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f18438k = super.m9948a(this.f18438k, 6);
        return this.f18438k;
    }

    @FieldOffset
    @Nullable
    public final String m25857D() {
        this.f18439l = super.m9948a(this.f18439l, 7);
        return this.f18439l;
    }

    @FieldOffset
    @Nullable
    public final String m25858E() {
        this.f18440m = super.m9948a(this.f18440m, 8);
        return this.f18440m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection mo2885C() {
        this.f18441n = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18441n, 9, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18441n;
    }

    @FieldOffset
    @Nullable
    public final String m25859F() {
        this.f18442o = super.m9948a(this.f18442o, 10);
        return this.f18442o;
    }

    @FieldOffset
    @Nullable
    public final String m25860G() {
        this.f18443p = super.m9948a(this.f18443p, 11);
        return this.f18443p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollSurvey m25861H() {
        this.f18444q = (GraphQLResearchPollSurvey) super.m9947a(this.f18444q, 12, GraphQLResearchPollSurvey.class);
        return this.f18444q;
    }

    @FieldOffset
    @Nullable
    public final String m25862I() {
        this.f18445r = super.m9948a(this.f18445r, 13);
        return this.f18445r;
    }

    @FieldOffset
    @Nullable
    public final String m25863J() {
        this.f18446s = super.m9948a(this.f18446s, 15);
        return this.f18446s;
    }

    @FieldOffset
    public final boolean m25864K() {
        m9949a(2, 0);
        return this.f18447t;
    }

    @FieldOffset
    public final boolean m25865L() {
        m9949a(2, 1);
        return this.f18448u;
    }

    @FieldOffset
    @Nullable
    public final String m25866M() {
        this.f18449v = super.m9948a(this.f18449v, 18);
        return this.f18449v;
    }

    @FieldOffset
    @Nullable
    public final String m25867N() {
        this.f18450w = super.m9948a(this.f18450w, 19);
        return this.f18450w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25868O() {
        this.f18451x = (GraphQLTextWithEntities) super.m9947a(this.f18451x, 20, GraphQLTextWithEntities.class);
        return this.f18451x;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25868O();
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25869P() {
        this.f18452y = (GraphQLTextWithEntities) super.m9947a(this.f18452y, 21, GraphQLTextWithEntities.class);
        return this.f18452y;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18453z = super.m9948a(this.f18453z, 22);
        return this.f18453z;
    }

    @FieldOffset
    @Nullable
    public final String m25870Q() {
        this.f18425A = super.m9948a(this.f18425A, 23);
        return this.f18425A;
    }

    @FieldOffset
    @Nullable
    public final String m25871R() {
        this.f18426B = super.m9948a(this.f18426B, 24);
        return this.f18426B;
    }

    @FieldOffset
    @Nullable
    public final String m25872S() {
        this.f18427C = super.m9948a(this.f18427C, 25);
        return this.f18427C;
    }

    @FieldOffset
    public final int m25873T() {
        m9949a(3, 2);
        return this.f18428D;
    }

    @Nullable
    public final String mo2834a() {
        return m25857D();
    }

    public final int jK_() {
        return -1148667268;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25898z() != null) {
            GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.mo2928b(m25898z());
            if (m25898z() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLResearchPollFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18432e = graphQLSponsoredData;
            }
        }
        if (mo2885C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(mo2885C());
            if (mo2885C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLResearchPollFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18441n = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m25861H() != null) {
            GraphQLResearchPollSurvey graphQLResearchPollSurvey = (GraphQLResearchPollSurvey) graphQLModelMutatingVisitor.mo2928b(m25861H());
            if (m25861H() != graphQLResearchPollSurvey) {
                graphQLVisitableModel = (GraphQLResearchPollFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18444q = graphQLResearchPollSurvey;
            }
        }
        if (m25868O() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25868O());
            if (m25868O() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLResearchPollFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18451x = graphQLTextWithEntities;
            }
        }
        if (m25869P() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25869P());
            if (m25869P() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLResearchPollFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18452y = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25871R();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 24;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25872S();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 25;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25873T());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 26;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18426B = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 24, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18427C = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 25, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18428D = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 26, intValue);
            }
        }
    }

    public GraphQLResearchPollFeedUnit() {
        super(28);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18437j = mutableFlatBuffer.m21525a(i, 5, 0);
        this.f18447t = mutableFlatBuffer.m21540a(i, 16);
        this.f18448u = mutableFlatBuffer.m21540a(i, 17);
        this.f18428D = mutableFlatBuffer.m21524a(i, 26, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m25898z());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(m25854A());
        int b3 = flatBufferBuilder.m21502b(m25855B());
        int b4 = flatBufferBuilder.m21502b(S_());
        int b5 = flatBufferBuilder.m21502b(mo2896y());
        int b6 = flatBufferBuilder.m21502b(m25857D());
        int b7 = flatBufferBuilder.m21502b(m25858E());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, mo2885C());
        int b8 = flatBufferBuilder.m21502b(m25859F());
        int b9 = flatBufferBuilder.m21502b(m25860G());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25861H());
        int b10 = flatBufferBuilder.m21502b(m25862I());
        int b11 = flatBufferBuilder.m21502b(m25863J());
        int b12 = flatBufferBuilder.m21502b(m25866M());
        int b13 = flatBufferBuilder.m21502b(m25867N());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25868O());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m25869P());
        int b14 = flatBufferBuilder.m21502b(mo2877k());
        int b15 = flatBufferBuilder.m21502b(m25870Q());
        int b16 = flatBufferBuilder.m21502b(m25871R());
        int b17 = flatBufferBuilder.m21502b(m25872S());
        flatBufferBuilder.m21510c(27);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        flatBufferBuilder.m21495a(5, T_(), 0);
        flatBufferBuilder.m21507b(6, b5);
        flatBufferBuilder.m21507b(7, b6);
        flatBufferBuilder.m21507b(8, b7);
        flatBufferBuilder.m21507b(9, a2);
        flatBufferBuilder.m21507b(10, b8);
        flatBufferBuilder.m21507b(11, b9);
        flatBufferBuilder.m21507b(12, a3);
        flatBufferBuilder.m21507b(13, b10);
        flatBufferBuilder.m21507b(15, b11);
        flatBufferBuilder.m21498a(16, m25864K());
        flatBufferBuilder.m21498a(17, m25865L());
        flatBufferBuilder.m21507b(18, b12);
        flatBufferBuilder.m21507b(19, b13);
        flatBufferBuilder.m21507b(20, a4);
        flatBufferBuilder.m21507b(21, a5);
        flatBufferBuilder.m21507b(22, b14);
        flatBufferBuilder.m21507b(23, b15);
        flatBufferBuilder.m21507b(24, b16);
        flatBufferBuilder.m21507b(25, b17);
        flatBufferBuilder.m21494a(26, m25873T(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLResearchPollFeedUnit(Parcel parcel) {
        boolean z = true;
        super(28);
        this.f18432e = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f18433f = parcel.readString();
        this.f18434g = parcel.readString();
        this.f18435h = parcel.readString();
        this.f18436i = parcel.readString();
        this.f18437j = parcel.readLong();
        this.f18438k = parcel.readString();
        this.f18439l = parcel.readString();
        this.f18440m = parcel.readString();
        this.f18426B = parcel.readString();
        this.f18427C = parcel.readString();
        this.f18428D = parcel.readInt();
        this.f18441n = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18442o = parcel.readString();
        this.f18443p = parcel.readString();
        this.f18444q = (GraphQLResearchPollSurvey) parcel.readValue(GraphQLResearchPollSurvey.class.getClassLoader());
        this.f18445r = parcel.readString();
        this.f18446s = parcel.readString();
        this.f18447t = parcel.readByte() == (byte) 1;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f18448u = z;
        this.f18449v = parcel.readString();
        this.f18450w = parcel.readString();
        this.f18451x = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18452y = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18453z = parcel.readString();
        this.f18425A = parcel.readString();
        this.f18429E = (ResearchPollFeedUnitExtra) ParcelUtil.b(parcel, ResearchPollFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeValue(m25898z());
        parcel.writeString(mo2507g());
        parcel.writeString(m25854A());
        parcel.writeString(m25855B());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeString(m25857D());
        parcel.writeString(m25858E());
        parcel.writeString(m25871R());
        parcel.writeString(m25872S());
        parcel.writeInt(m25873T());
        parcel.writeValue(mo2885C());
        parcel.writeString(m25859F());
        parcel.writeString(m25860G());
        parcel.writeValue(m25861H());
        parcel.writeString(m25862I());
        parcel.writeString(m25863J());
        parcel.writeByte((byte) (m25864K() ? 1 : 0));
        if (!m25865L()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m25866M());
        parcel.writeString(m25867N());
        parcel.writeValue(m25868O());
        parcel.writeValue(m25869P());
        parcel.writeString(mo2877k());
        parcel.writeString(m25870Q());
        parcel.writeParcelable(m25874U(), i);
    }

    public final ResearchPollFeedUnitExtra m25874U() {
        if (this.f18429E == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18429E = new ResearchPollFeedUnitExtra();
            } else {
                this.f18429E = (ResearchPollFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, ResearchPollFeedUnitExtra.class);
            }
        }
        return this.f18429E;
    }

    public final PropertyBag U_() {
        if (this.f18430F == null) {
            this.f18430F = new PropertyBag();
        }
        return this.f18430F;
    }
}
