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
/* compiled from: key_frames */
public final class GraphQLSaleGroupsNearYouFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSaleGroupsNearYouFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18473d = new GraphQLObjectType(-1275526754);
    @Nullable
    GraphQLSaleGroupsNearYouFeedUnitGroupsConnection f18474e;
    @Nullable
    String f18475f;
    @Nullable
    String f18476g;
    long f18477h;
    @Nullable
    String f18478i;
    @Nullable
    String f18479j;
    @Nullable
    GraphQLTextWithEntities f18480k;
    @Nullable
    GraphQLTextWithEntities f18481l;
    @Nullable
    String f18482m;
    @Nullable
    String f18483n;
    private SaleGroupsNearYouFeedUnitExtra f18484o;
    @Nullable
    private PropertyBag f18485p = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25947u();
    }

    public final /* synthetic */ List mo2882v() {
        return m25939l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18473d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30153a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m25939l() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final GraphQLSaleGroupsNearYouFeedUnitGroupsConnection m25941o() {
        this.f18474e = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) super.m9947a(this.f18474e, 0, GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class);
        return this.f18474e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18475f = super.m9948a(this.f18475f, 1);
        return this.f18475f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18476g = super.m9948a(this.f18476g, 2);
        return this.f18476g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f18477h;
    }

    public final void mo2872a(long j) {
        this.f18477h = j;
    }

    @FieldOffset
    @Nullable
    public final String m25942p() {
        this.f18478i = super.m9948a(this.f18478i, 4);
        return this.f18478i;
    }

    @FieldOffset
    @Nullable
    public final String m25943q() {
        this.f18479j = super.m9948a(this.f18479j, 6);
        return this.f18479j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25944r() {
        this.f18480k = (GraphQLTextWithEntities) super.m9947a(this.f18480k, 7, GraphQLTextWithEntities.class);
        return this.f18480k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25945s() {
        this.f18481l = (GraphQLTextWithEntities) super.m9947a(this.f18481l, 8, GraphQLTextWithEntities.class);
        return this.f18481l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18482m = super.m9948a(this.f18482m, 9);
        return this.f18482m;
    }

    @FieldOffset
    @Nullable
    public final String m25946t() {
        this.f18483n = super.m9948a(this.f18483n, 10);
        return this.f18483n;
    }

    @Nullable
    public final String mo2834a() {
        return m25942p();
    }

    public final int jK_() {
        return -1275526754;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25941o() != null) {
            GraphQLSaleGroupsNearYouFeedUnitGroupsConnection graphQLSaleGroupsNearYouFeedUnitGroupsConnection = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) graphQLModelMutatingVisitor.mo2928b(m25941o());
            if (m25941o() != graphQLSaleGroupsNearYouFeedUnitGroupsConnection) {
                graphQLVisitableModel = (GraphQLSaleGroupsNearYouFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18474e = graphQLSaleGroupsNearYouFeedUnitGroupsConnection;
            }
        }
        if (m25944r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25944r());
            if (m25944r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSaleGroupsNearYouFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18480k = graphQLTextWithEntities;
            }
        }
        if (m25945s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25945s());
            if (m25945s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSaleGroupsNearYouFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18481l = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSaleGroupsNearYouFeedUnit() {
        super(12);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18477h = mutableFlatBuffer.m21525a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m25941o());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25942p());
        int b4 = flatBufferBuilder.m21502b(m25943q());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25944r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25945s());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m25946t());
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

    public GraphQLSaleGroupsNearYouFeedUnit(Parcel parcel) {
        super(12);
        this.f18474e = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) parcel.readValue(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class.getClassLoader());
        this.f18475f = parcel.readString();
        this.f18476g = parcel.readString();
        this.f18477h = parcel.readLong();
        this.f18478i = parcel.readString();
        this.f18479j = parcel.readString();
        this.f18480k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18481l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18482m = parcel.readString();
        this.f18483n = parcel.readString();
        this.f18484o = (SaleGroupsNearYouFeedUnitExtra) ParcelUtil.b(parcel, SaleGroupsNearYouFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m25941o());
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25942p());
        parcel.writeString(m25943q());
        parcel.writeValue(m25944r());
        parcel.writeValue(m25945s());
        parcel.writeString(mo2877k());
        parcel.writeString(m25946t());
        parcel.writeParcelable(m25947u(), i);
    }

    public GraphQLSaleGroupsNearYouFeedUnit(Builder builder) {
        super(12);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18474e = builder.d;
        this.f18475f = builder.e;
        this.f18476g = builder.f;
        this.f18477h = builder.g;
        this.f18478i = builder.h;
        this.f18479j = builder.i;
        this.f18480k = builder.j;
        this.f18481l = builder.k;
        this.f18482m = builder.l;
        this.f18483n = builder.m;
        this.f18485p = builder.n;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25944r();
    }

    public final SaleGroupsNearYouFeedUnitExtra m25947u() {
        if (this.f18484o == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18484o = new SaleGroupsNearYouFeedUnitExtra();
            } else {
                this.f18484o = (SaleGroupsNearYouFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, SaleGroupsNearYouFeedUnitExtra.class);
            }
        }
        return this.f18484o;
    }

    public final PropertyBag U_() {
        if (this.f18485p == null) {
            this.f18485p = new PropertyBag();
        }
        return this.f18485p;
    }
}
