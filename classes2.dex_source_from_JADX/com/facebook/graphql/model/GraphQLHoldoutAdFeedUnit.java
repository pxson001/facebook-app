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
/* compiled from: last_name */
public final class GraphQLHoldoutAdFeedUnit extends BaseModel implements FeedUnit, HasCachedSponsoredImpression, HasSponsoredData, HideableUnit, HasProperty, Sponsorable, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLHoldoutAdFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f17947d = new GraphQLObjectType(-240759564);
    @Nullable
    public String f17948e;
    @Nullable
    public String f17949f;
    public long f17950g;
    @Nullable
    public String f17951h;
    @Nullable
    public GraphQLSponsoredData f17952i;
    @Nullable
    public String f17953j;
    @Nullable
    public String f17954k;
    @Nullable
    public String f17955l;
    public int f17956m;
    private HoldoutAdFeedUnitExtra f17957n;
    @Nullable
    private PropertyBag f17958o = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25174t();
    }

    public final String mo2881q() {
        return null;
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final int mo2880p() {
        return 0;
    }

    public final GraphQLObjectType getType() {
        return this.f17947d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final SponsoredImpression Z_() {
        return ImpressionUtil.m29320a((HasSponsoredData) this);
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return ImpressionUtil.m29319a((HasCachedSponsoredImpression) this);
    }

    public final StoryVisibility mo2879o() {
        return HideableUnitUtil.m26319a((HideableUnit) this);
    }

    public final boolean mo2895u() {
        return ImpressionUtil.m29324a((Sponsorable) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f17948e = super.m9948a(this.f17948e, 0);
        return this.f17948e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f17949f = super.m9948a(this.f17949f, 1);
        return this.f17949f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f17950g;
    }

    public final void mo2872a(long j) {
        this.f17950g = j;
    }

    @FieldOffset
    @Nullable
    public final String m25187m() {
        this.f17951h = super.m9948a(this.f17951h, 3);
        return this.f17951h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData mo2994A() {
        this.f17952i = (GraphQLSponsoredData) super.m9947a(this.f17952i, 4, GraphQLSponsoredData.class);
        return this.f17952i;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f17953j = super.m9948a(this.f17953j, 5);
        return this.f17953j;
    }

    @FieldOffset
    @Nullable
    public final String m25188n() {
        this.f17954k = super.m9948a(this.f17954k, 6);
        return this.f17954k;
    }

    @FieldOffset
    @Nullable
    public final String m25192r() {
        this.f17955l = super.m9948a(this.f17955l, 7);
        return this.f17955l;
    }

    @FieldOffset
    public final int m25193s() {
        m9949a(1, 0);
        return this.f17956m;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -240759564;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (mo2994A() != null) {
            GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.mo2928b(mo2994A());
            if (mo2994A() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLHoldoutAdFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17952i = graphQLSponsoredData;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25188n();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 6;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25192r();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 7;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25193s());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 8;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f17954k = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 6, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f17955l = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 7, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f17956m = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 8, intValue);
            }
        }
    }

    public GraphQLHoldoutAdFeedUnit() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17950g = mutableFlatBuffer.m21525a(i, 2, 0);
        this.f17956m = mutableFlatBuffer.m21524a(i, 8, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25187m());
        int a = ModelHelper.m23093a(flatBufferBuilder, mo2994A());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        int b5 = flatBufferBuilder.m21502b(m25188n());
        int b6 = flatBufferBuilder.m21502b(m25192r());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, a);
        flatBufferBuilder.m21507b(5, b4);
        flatBufferBuilder.m21507b(6, b5);
        flatBufferBuilder.m21507b(7, b6);
        flatBufferBuilder.m21494a(8, m25193s(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLHoldoutAdFeedUnit(Parcel parcel) {
        super(10);
        this.f17948e = parcel.readString();
        this.f17949f = parcel.readString();
        this.f17950g = parcel.readLong();
        this.f17954k = parcel.readString();
        this.f17955l = parcel.readString();
        this.f17956m = parcel.readInt();
        this.f17951h = parcel.readString();
        this.f17952i = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f17953j = parcel.readString();
        this.f17957n = (HoldoutAdFeedUnitExtra) ParcelUtil.b(parcel, HoldoutAdFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25188n());
        parcel.writeString(m25192r());
        parcel.writeInt(m25193s());
        parcel.writeString(m25187m());
        parcel.writeValue(mo2994A());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25174t(), i);
    }

    private HoldoutAdFeedUnitExtra m25174t() {
        if (this.f17957n == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f17957n = new HoldoutAdFeedUnitExtra();
            } else {
                this.f17957n = (HoldoutAdFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, HoldoutAdFeedUnitExtra.class);
            }
        }
        return this.f17957n;
    }

    public final PropertyBag U_() {
        if (this.f17958o == null) {
            this.f17958o = new PropertyBag();
        }
        return this.f17958o;
    }
}
