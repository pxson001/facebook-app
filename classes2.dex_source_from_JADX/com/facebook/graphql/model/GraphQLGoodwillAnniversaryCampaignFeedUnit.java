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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: last_clear_data_date/ */
public final class GraphQLGoodwillAnniversaryCampaignFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HideableUnit, HasProperty, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLGoodwillAnniversaryCampaignFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18053d = new GraphQLObjectType(1700442483);
    @Nullable
    GraphQLGoodwillAnniversaryCampaign f18054e;
    @Nullable
    String f18055f;
    @Nullable
    String f18056g;
    long f18057h;
    @Nullable
    String f18058i;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f18059j;
    @Nullable
    String f18060k;
    @Nullable
    String f18061l;
    @Nullable
    String f18062m;
    @Nullable
    public String f18063n;
    @Nullable
    public String f18064o;
    public int f18065p;
    private GoodwillAnniversaryCampaignFeedUnitExtra f18066q;
    @Nullable
    private PropertyBag f18067r = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25338v();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18053d;
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

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillAnniversaryCampaign m25350l() {
        this.f18054e = (GraphQLGoodwillAnniversaryCampaign) super.m9947a(this.f18054e, 0, GraphQLGoodwillAnniversaryCampaign.class);
        return this.f18054e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18055f = super.m9948a(this.f18055f, 1);
        return this.f18055f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18056g = super.m9948a(this.f18056g, 2);
        return this.f18056g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f18057h;
    }

    public final void mo2872a(long j) {
        this.f18057h = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f18058i = super.m9948a(this.f18058i, 4);
        return this.f18058i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m25351m() {
        this.f18059j = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18059j, 5, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18059j;
    }

    @FieldOffset
    @Nullable
    public final String m25352n() {
        this.f18060k = super.m9948a(this.f18060k, 6);
        return this.f18060k;
    }

    @FieldOffset
    @Nullable
    public final String m25356r() {
        this.f18061l = super.m9948a(this.f18061l, 7);
        return this.f18061l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18062m = super.m9948a(this.f18062m, 8);
        return this.f18062m;
    }

    @FieldOffset
    @Nullable
    public final String m25357s() {
        this.f18063n = super.m9948a(this.f18063n, 9);
        return this.f18063n;
    }

    @FieldOffset
    @Nullable
    public final String m25358t() {
        this.f18064o = super.m9948a(this.f18064o, 10);
        return this.f18064o;
    }

    @FieldOffset
    public final int m25359u() {
        m9949a(1, 3);
        return this.f18065p;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return 1700442483;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25350l() != null) {
            GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign = (GraphQLGoodwillAnniversaryCampaign) graphQLModelMutatingVisitor.mo2928b(m25350l());
            if (m25350l() != graphQLGoodwillAnniversaryCampaign) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaignFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18054e = graphQLGoodwillAnniversaryCampaign;
            }
        }
        if (m25351m() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m25351m());
            if (m25351m() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaignFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18059j = graphQLNegativeFeedbackActionsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25357s();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 9;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25358t();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 10;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25359u());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 11;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18063n = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 9, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18064o = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 10, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18065p = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 11, intValue);
            }
        }
    }

    public GraphQLGoodwillAnniversaryCampaignFeedUnit() {
        super(13);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18057h = mutableFlatBuffer.m21525a(i, 3, 0);
        this.f18065p = mutableFlatBuffer.m21524a(i, 11, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m25350l());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25351m());
        int b4 = flatBufferBuilder.m21502b(m25352n());
        int b5 = flatBufferBuilder.m21502b(m25356r());
        int b6 = flatBufferBuilder.m21502b(mo2877k());
        int b7 = flatBufferBuilder.m21502b(m25357s());
        int b8 = flatBufferBuilder.m21502b(m25358t());
        flatBufferBuilder.m21510c(12);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21495a(3, T_(), 0);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, b5);
        flatBufferBuilder.m21507b(8, b6);
        flatBufferBuilder.m21507b(9, b7);
        flatBufferBuilder.m21507b(10, b8);
        flatBufferBuilder.m21494a(11, m25359u(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGoodwillAnniversaryCampaignFeedUnit(Parcel parcel) {
        super(13);
        this.f18054e = (GraphQLGoodwillAnniversaryCampaign) parcel.readValue(GraphQLGoodwillAnniversaryCampaign.class.getClassLoader());
        this.f18055f = parcel.readString();
        this.f18056g = parcel.readString();
        this.f18057h = parcel.readLong();
        this.f18058i = parcel.readString();
        this.f18063n = parcel.readString();
        this.f18064o = parcel.readString();
        this.f18065p = parcel.readInt();
        this.f18059j = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18060k = parcel.readString();
        this.f18061l = parcel.readString();
        this.f18062m = parcel.readString();
        this.f18066q = (GoodwillAnniversaryCampaignFeedUnitExtra) ParcelUtil.b(parcel, GoodwillAnniversaryCampaignFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m25350l());
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeString(m25357s());
        parcel.writeString(m25358t());
        parcel.writeInt(m25359u());
        parcel.writeValue(m25351m());
        parcel.writeString(m25352n());
        parcel.writeString(m25356r());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25338v(), i);
    }

    private GoodwillAnniversaryCampaignFeedUnitExtra m25338v() {
        if (this.f18066q == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18066q = new GoodwillAnniversaryCampaignFeedUnitExtra();
            } else {
                this.f18066q = (GoodwillAnniversaryCampaignFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, GoodwillAnniversaryCampaignFeedUnitExtra.class);
            }
        }
        return this.f18066q;
    }

    public final PropertyBag U_() {
        if (this.f18067r == null) {
            this.f18067r = new PropertyBag();
        }
        return this.f18067r;
    }
}
