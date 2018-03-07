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
import com.facebook.graphql.enums.GraphQLFriendsLocationsFeedType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: login_broadcasted_cross_app */
public final class GraphQLFriendsLocationsFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendsLocationsFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f15988d = new GraphQLObjectType(-1375500085);
    @Nullable
    public String f15989e;
    public long f15990f;
    @Nullable
    public String f15991g;
    @Nullable
    public GraphQLTextWithEntities f15992h;
    public long f15993i;
    @Nullable
    public GraphQLTextWithEntities f15994j;
    public List<GraphQLFriendLocationFeedUnitItem> f15995k;
    public List<GraphQLFriendLocationFeedUnitItem> f15996l;
    @Nullable
    public String f15997m;
    @Nullable
    public GraphQLTextWithEntities f15998n;
    @Nullable
    public String f15999o;
    public GraphQLFriendsLocationsFeedType f16000p;
    private FriendsLocationsFeedUnitExtra f16001q;
    @Nullable
    private PropertyBag f16002r = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m22789z();
    }

    public final List mo2883w() {
        return m22803q();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f15988d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final List mo2882v() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f15989e = super.m9948a(this.f15989e, 0);
        return this.f15989e;
    }

    @FieldOffset
    public final long m22799l() {
        m9949a(0, 1);
        return this.f15990f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f15991g = super.m9948a(this.f15991g, 2);
        return this.f15991g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22801o() {
        this.f15992h = (GraphQLTextWithEntities) super.m9947a(this.f15992h, 3, GraphQLTextWithEntities.class);
        return this.f15992h;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 4);
        return this.f15993i;
    }

    public final void mo2872a(long j) {
        this.f15993i = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22802p() {
        this.f15994j = (GraphQLTextWithEntities) super.m9947a(this.f15994j, 5, GraphQLTextWithEntities.class);
        return this.f15994j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFriendLocationFeedUnitItem> m22803q() {
        this.f15995k = super.m9944a(this.f15995k, 6, GraphQLFriendLocationFeedUnitItem.class);
        return (ImmutableList) this.f15995k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFriendLocationFeedUnitItem> m22804r() {
        this.f15996l = super.m9944a(this.f15996l, 7, GraphQLFriendLocationFeedUnitItem.class);
        return (ImmutableList) this.f15996l;
    }

    @FieldOffset
    @Nullable
    public final String m22805s() {
        this.f15997m = super.m9948a(this.f15997m, 8);
        return this.f15997m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22806t() {
        this.f15998n = (GraphQLTextWithEntities) super.m9947a(this.f15998n, 9, GraphQLTextWithEntities.class);
        return this.f15998n;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f15999o = super.m9948a(this.f15999o, 10);
        return this.f15999o;
    }

    @FieldOffset
    public final GraphQLFriendsLocationsFeedType m22807u() {
        this.f16000p = (GraphQLFriendsLocationsFeedType) super.m9945a(this.f16000p, 11, GraphQLFriendsLocationsFeedType.class, GraphQLFriendsLocationsFeedType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16000p;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -1375500085;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22801o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22801o());
            if (m22801o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFriendsLocationsFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15992h = graphQLTextWithEntities;
            }
        }
        if (m22802p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22802p());
            if (m22802p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFriendsLocationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15994j = graphQLTextWithEntities;
            }
        }
        if (m22803q() != null) {
            a = ModelHelper.m23097a(m22803q(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLFriendsLocationsFeedUnit.f15995k = a.m1068b();
                graphQLVisitableModel = graphQLFriendsLocationsFeedUnit;
            }
        }
        if (m22804r() != null) {
            a = ModelHelper.m23097a(m22804r(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLFriendsLocationsFeedUnit.f15996l = a.m1068b();
                graphQLVisitableModel = graphQLFriendsLocationsFeedUnit;
            }
        }
        if (m22806t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22806t());
            if (m22806t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFriendsLocationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15998n = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m22806t();
    }

    public GraphQLFriendsLocationsFeedUnit() {
        super(13);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15990f = mutableFlatBuffer.m21525a(i, 1, 0);
        this.f15993i = mutableFlatBuffer.m21525a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23093a(flatBufferBuilder, m22801o());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22802p());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m22803q());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m22804r());
        int b3 = flatBufferBuilder.m21502b(m22805s());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m22806t());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(12);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21495a(1, m22799l(), 0);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21495a(4, T_(), 0);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, b3);
        flatBufferBuilder.m21507b(9, a5);
        flatBufferBuilder.m21507b(10, b4);
        flatBufferBuilder.m21496a(11, m22807u() == GraphQLFriendsLocationsFeedType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22807u());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFriendsLocationsFeedUnit(Parcel parcel) {
        super(13);
        this.f15989e = parcel.readString();
        this.f15990f = parcel.readLong();
        this.f15991g = parcel.readString();
        this.f15992h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16000p = GraphQLFriendsLocationsFeedType.fromString(parcel.readString());
        this.f15993i = parcel.readLong();
        this.f15994j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15995k = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFriendLocationFeedUnitItem.class.getClassLoader()));
        this.f15996l = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFriendLocationFeedUnitItem.class.getClassLoader()));
        this.f15997m = parcel.readString();
        this.f15998n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15999o = parcel.readString();
        this.f16001q = (FriendsLocationsFeedUnitExtra) ParcelUtil.b(parcel, FriendsLocationsFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeLong(m22799l());
        parcel.writeString(S_());
        parcel.writeValue(m22801o());
        parcel.writeString(m22807u().name());
        parcel.writeLong(T_());
        parcel.writeValue(m22802p());
        parcel.writeList(m22803q());
        parcel.writeList(m22804r());
        parcel.writeString(m22805s());
        parcel.writeValue(m22806t());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m22789z(), i);
    }

    private FriendsLocationsFeedUnitExtra m22789z() {
        if (this.f16001q == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f16001q = new FriendsLocationsFeedUnitExtra();
            } else {
                this.f16001q = (FriendsLocationsFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, FriendsLocationsFeedUnitExtra.class);
            }
        }
        return this.f16001q;
    }

    public final PropertyBag U_() {
        if (this.f16002r == null) {
            this.f16002r = new PropertyBag();
        }
        return this.f16002r;
    }
}
