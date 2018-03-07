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
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: last_fetch_hash */
public final class GraphQLPaginatedGroupsYouShouldJoinFeedUnit extends BaseModel implements FeedUnit, GroupsYouShouldJoinFeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPaginatedGroupsYouShouldJoinFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18022d = new GraphQLObjectType(74545917);
    @Nullable
    GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection f18023e;
    @Nullable
    String f18024f;
    @Nullable
    String f18025g;
    long f18026h;
    @Nullable
    String f18027i;
    @Nullable
    String f18028j;
    @Nullable
    GraphQLTextWithEntities f18029k;
    @Nullable
    GraphQLTextWithEntities f18030l;
    @Nullable
    String f18031m;
    @Nullable
    String f18032n;
    private PaginatedGroupsYouShouldJoinFeedUnitExtra f18033o;
    @Nullable
    private PropertyBag f18034p = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25306u();
    }

    public final /* synthetic */ List mo2882v() {
        return m25298l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18022d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30145a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m25298l() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection m25300o() {
        this.f18023e = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) super.m9947a(this.f18023e, 0, GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.class);
        return this.f18023e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18024f = super.m9948a(this.f18024f, 1);
        return this.f18024f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18025g = super.m9948a(this.f18025g, 2);
        return this.f18025g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f18026h;
    }

    public final void mo2872a(long j) {
        this.f18026h = j;
    }

    @FieldOffset
    @Nullable
    public final String m25301p() {
        this.f18027i = super.m9948a(this.f18027i, 4);
        return this.f18027i;
    }

    @FieldOffset
    @Nullable
    public final String m25302q() {
        this.f18028j = super.m9948a(this.f18028j, 6);
        return this.f18028j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25303r() {
        this.f18029k = (GraphQLTextWithEntities) super.m9947a(this.f18029k, 7, GraphQLTextWithEntities.class);
        return this.f18029k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25304s() {
        this.f18030l = (GraphQLTextWithEntities) super.m9947a(this.f18030l, 8, GraphQLTextWithEntities.class);
        return this.f18030l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18031m = super.m9948a(this.f18031m, 9);
        return this.f18031m;
    }

    @FieldOffset
    @Nullable
    public final String m25305t() {
        this.f18032n = super.m9948a(this.f18032n, 10);
        return this.f18032n;
    }

    @Nullable
    public final String mo2834a() {
        return m25301p();
    }

    public final int jK_() {
        return 74545917;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25300o() != null) {
            GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) graphQLModelMutatingVisitor.mo2928b(m25300o());
            if (m25300o() != graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) {
                graphQLVisitableModel = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18023e = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection;
            }
        }
        if (m25303r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25303r());
            if (m25303r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18029k = graphQLTextWithEntities;
            }
        }
        if (m25304s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25304s());
            if (m25304s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18030l = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnit() {
        super(12);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18026h = mutableFlatBuffer.m21525a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m25300o());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25301p());
        int b4 = flatBufferBuilder.m21502b(m25302q());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25303r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25304s());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m25305t());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21495a(3, T_(), 0);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, a2);
        flatBufferBuilder.m21507b(8, a3);
        flatBufferBuilder.m21507b(9, b5);
        flatBufferBuilder.m21507b(10, b6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnit(Parcel parcel) {
        super(12);
        this.f18023e = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) parcel.readValue(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.class.getClassLoader());
        this.f18024f = parcel.readString();
        this.f18025g = parcel.readString();
        this.f18026h = parcel.readLong();
        this.f18027i = parcel.readString();
        this.f18028j = parcel.readString();
        this.f18029k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18030l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18031m = parcel.readString();
        this.f18032n = parcel.readString();
        this.f18033o = (PaginatedGroupsYouShouldJoinFeedUnitExtra) ParcelUtil.b(parcel, PaginatedGroupsYouShouldJoinFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m25300o());
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25301p());
        parcel.writeString(m25302q());
        parcel.writeValue(m25303r());
        parcel.writeValue(m25304s());
        parcel.writeString(mo2877k());
        parcel.writeString(m25305t());
        parcel.writeParcelable(m25306u(), i);
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnit(Builder builder) {
        super(12);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18023e = builder.d;
        this.f18024f = builder.e;
        this.f18025g = builder.f;
        this.f18026h = builder.g;
        this.f18027i = builder.h;
        this.f18028j = builder.i;
        this.f18029k = builder.j;
        this.f18030l = builder.k;
        this.f18031m = builder.l;
        this.f18032n = builder.m;
        this.f18034p = builder.n;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25303r();
    }

    public final PaginatedGroupsYouShouldJoinFeedUnitExtra m25306u() {
        if (this.f18033o == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18033o = new PaginatedGroupsYouShouldJoinFeedUnitExtra();
            } else {
                this.f18033o = (PaginatedGroupsYouShouldJoinFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PaginatedGroupsYouShouldJoinFeedUnitExtra.class);
            }
        }
        return this.f18033o;
    }

    public final PropertyBag U_() {
        if (this.f18034p == null) {
            this.f18034p = new PropertyBag();
        }
        return this.f18034p;
    }
}
