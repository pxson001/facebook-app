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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: last_bundle_end_timestamp */
public final class GraphQLGreetingCardPromotionFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HasNegativeFeedbackActions, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, CachedFeedTrackable, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLGreetingCardPromotionFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18129d = new GraphQLObjectType(422860284);
    @Nullable
    String f18130e;
    @Nullable
    GraphQLTextWithEntities f18131f;
    @Nullable
    String f18132g;
    long f18133h;
    @Nullable
    String f18134i;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f18135j;
    @Nullable
    GraphQLGreetingCard f18136k;
    @Nullable
    GraphQLPrivacyScope f18137l;
    @Nullable
    String f18138m;
    @Nullable
    GraphQLTextWithEntities f18139n;
    @Nullable
    GraphQLTextWithEntities f18140o;
    @Nullable
    public String f18141p;
    @Nullable
    public String f18142q;
    public int f18143r;
    private GreetingCardPromotionFeedUnitExtra f18144s;
    @Nullable
    private PropertyBag f18145t = null;

    public final String mo2892r() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25419A();
    }

    @Nullable
    public final ArrayNode R_() {
        return new ArrayNode(JsonNodeFactory.f3121a);
    }

    public final GraphQLObjectType getType() {
        return this.f18129d;
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
    public final String mo2507g() {
        this.f18130e = super.m9948a(this.f18130e, 0);
        return this.f18130e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25431k() {
        this.f18131f = (GraphQLTextWithEntities) super.m9947a(this.f18131f, 1, GraphQLTextWithEntities.class);
        return this.f18131f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18132g = super.m9948a(this.f18132g, 2);
        return this.f18132g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f18133h;
    }

    public final void mo2872a(long j) {
        this.f18133h = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f18134i = super.m9948a(this.f18134i, 4);
        return this.f18134i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection mo2885C() {
        this.f18135j = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18135j, 5, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18135j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGreetingCard m25432l() {
        this.f18136k = (GraphQLGreetingCard) super.m9947a(this.f18136k, 6, GraphQLGreetingCard.class);
        return this.f18136k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m25433m() {
        this.f18137l = (GraphQLPrivacyScope) super.m9947a(this.f18137l, 7, GraphQLPrivacyScope.class);
        return this.f18137l;
    }

    @FieldOffset
    @Nullable
    public final String m25434n() {
        this.f18138m = super.m9948a(this.f18138m, 8);
        return this.f18138m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25441u() {
        this.f18139n = (GraphQLTextWithEntities) super.m9947a(this.f18139n, 9, GraphQLTextWithEntities.class);
        return this.f18139n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25442v() {
        this.f18140o = (GraphQLTextWithEntities) super.m9947a(this.f18140o, 10, GraphQLTextWithEntities.class);
        return this.f18140o;
    }

    @FieldOffset
    @Nullable
    public final String m25443w() {
        this.f18141p = super.m9948a(this.f18141p, 11);
        return this.f18141p;
    }

    @FieldOffset
    @Nullable
    public final String m25444x() {
        this.f18142q = super.m9948a(this.f18142q, 12);
        return this.f18142q;
    }

    @FieldOffset
    public final int m25446z() {
        m9949a(1, 5);
        return this.f18143r;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return 422860284;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25431k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25431k());
            if (m25431k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGreetingCardPromotionFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18131f = graphQLTextWithEntities;
            }
        }
        if (mo2885C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(mo2885C());
            if (mo2885C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLGreetingCardPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18135j = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m25432l() != null) {
            GraphQLGreetingCard graphQLGreetingCard = (GraphQLGreetingCard) graphQLModelMutatingVisitor.mo2928b(m25432l());
            if (m25432l() != graphQLGreetingCard) {
                graphQLVisitableModel = (GraphQLGreetingCardPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18136k = graphQLGreetingCard;
            }
        }
        if (m25433m() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m25433m());
            if (m25433m() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLGreetingCardPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18137l = graphQLPrivacyScope;
            }
        }
        if (m25441u() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25441u());
            if (m25441u() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGreetingCardPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18139n = graphQLTextWithEntities;
            }
        }
        if (m25442v() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25442v());
            if (m25442v() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGreetingCardPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18140o = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25443w();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 11;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25444x();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 12;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25446z());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 13;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18141p = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 11, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18142q = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 12, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18143r = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 13, intValue);
            }
        }
    }

    public GraphQLGreetingCardPromotionFeedUnit() {
        super(15);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18133h = mutableFlatBuffer.m21525a(i, 3, 0);
        this.f18143r = mutableFlatBuffer.m21524a(i, 13, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int a = ModelHelper.m23093a(flatBufferBuilder, m25431k());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, mo2885C());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25432l());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25433m());
        int b4 = flatBufferBuilder.m21502b(m25434n());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m25441u());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m25442v());
        int b5 = flatBufferBuilder.m21502b(m25443w());
        int b6 = flatBufferBuilder.m21502b(m25444x());
        flatBufferBuilder.m21510c(14);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21495a(3, T_(), 0);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, b4);
        flatBufferBuilder.m21507b(9, a5);
        flatBufferBuilder.m21507b(10, a6);
        flatBufferBuilder.m21507b(11, b5);
        flatBufferBuilder.m21507b(12, b6);
        flatBufferBuilder.m21494a(13, m25446z(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGreetingCardPromotionFeedUnit(Parcel parcel) {
        super(15);
        this.f18130e = parcel.readString();
        this.f18131f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18132g = parcel.readString();
        this.f18133h = parcel.readLong();
        this.f18134i = parcel.readString();
        this.f18141p = parcel.readString();
        this.f18142q = parcel.readString();
        this.f18143r = parcel.readInt();
        this.f18135j = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18136k = (GraphQLGreetingCard) parcel.readValue(GraphQLGreetingCard.class.getClassLoader());
        this.f18137l = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f18138m = parcel.readString();
        this.f18139n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18140o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18144s = (GreetingCardPromotionFeedUnitExtra) ParcelUtil.b(parcel, GreetingCardPromotionFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeValue(m25431k());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeString(m25443w());
        parcel.writeString(m25444x());
        parcel.writeInt(m25446z());
        parcel.writeValue(mo2885C());
        parcel.writeValue(m25432l());
        parcel.writeValue(m25433m());
        parcel.writeString(m25434n());
        parcel.writeValue(m25441u());
        parcel.writeValue(m25442v());
        parcel.writeParcelable(m25419A(), i);
    }

    private GreetingCardPromotionFeedUnitExtra m25419A() {
        if (this.f18144s == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18144s = new GreetingCardPromotionFeedUnitExtra();
            } else {
                this.f18144s = (GreetingCardPromotionFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, GreetingCardPromotionFeedUnitExtra.class);
            }
        }
        return this.f18144s;
    }

    public final PropertyBag U_() {
        if (this.f18145t == null) {
            this.f18145t = new PropertyBag();
        }
        return this.f18145t;
    }
}
