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
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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
/* compiled from: invalid parent pointer */
public final class GraphQLCelebrationsFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLCelebrationsFeedUnit> CREATOR = new 1();
    GraphQLObjectType f19597d = new GraphQLObjectType(-875190709);
    @Nullable
    String f19598e;
    List<GraphQLCelebrationsFeedUnitItem> f19599f;
    @Nullable
    GraphQLTextWithEntities f19600g;
    @Nullable
    String f19601h;
    long f19602i;
    List<GraphQLCelebrationsFeedUnitItem> f19603j;
    @Nullable
    String f19604k;
    @Nullable
    GraphQLTextWithEntities f19605l;
    @Nullable
    String f19606m;
    private CelebrationsFeedUnitExtra f19607n;
    @Nullable
    private PropertyBag f19608o = null;

    public final List mo2882v() {
        return m27319o();
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m27307u();
    }

    public final /* synthetic */ List mo2883w() {
        return m27317l();
    }

    public final GraphQLObjectType getType() {
        return this.f19597d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final ImmutableList m27317l() {
        return ItemListFeedUnitImpl.m30138a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f19598e = super.m9948a(this.f19598e, 0);
        return this.f19598e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLCelebrationsFeedUnitItem> m27319o() {
        this.f19599f = super.m9944a(this.f19599f, 1, GraphQLCelebrationsFeedUnitItem.class);
        return (ImmutableList) this.f19599f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27320p() {
        this.f19600g = (GraphQLTextWithEntities) super.m9947a(this.f19600g, 2, GraphQLTextWithEntities.class);
        return this.f19600g;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f19601h = super.m9948a(this.f19601h, 3);
        return this.f19601h;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 4);
        return this.f19602i;
    }

    public final void mo2872a(long j) {
        this.f19602i = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLCelebrationsFeedUnitItem> m27321q() {
        this.f19603j = super.m9944a(this.f19603j, 5, GraphQLCelebrationsFeedUnitItem.class);
        return (ImmutableList) this.f19603j;
    }

    @FieldOffset
    @Nullable
    public final String m27322r() {
        this.f19604k = super.m9948a(this.f19604k, 6);
        return this.f19604k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27323s() {
        this.f19605l = (GraphQLTextWithEntities) super.m9947a(this.f19605l, 7, GraphQLTextWithEntities.class);
        return this.f19605l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f19606m = super.m9948a(this.f19606m, 8);
        return this.f19606m;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -875190709;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLCelebrationsFeedUnit graphQLCelebrationsFeedUnit;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        m9958h();
        if (m27319o() != null) {
            Builder a2 = ModelHelper.m23097a(m27319o(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLCelebrationsFeedUnit = (GraphQLCelebrationsFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLCelebrationsFeedUnit.f19599f = a2.m1068b();
                graphQLVisitableModel = graphQLCelebrationsFeedUnit;
                if (m27320p() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27320p());
                    if (m27320p() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLCelebrationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f19600g = graphQLTextWithEntities;
                    }
                }
                if (m27321q() != null) {
                    a = ModelHelper.m23097a(m27321q(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLCelebrationsFeedUnit = (GraphQLCelebrationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLCelebrationsFeedUnit.f19603j = a.m1068b();
                        graphQLVisitableModel = graphQLCelebrationsFeedUnit;
                    }
                }
                if (m27323s() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27323s());
                    if (m27323s() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLCelebrationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f19605l = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m27320p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27320p());
            if (m27320p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCelebrationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19600g = graphQLTextWithEntities;
            }
        }
        if (m27321q() != null) {
            a = ModelHelper.m23097a(m27321q(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLCelebrationsFeedUnit = (GraphQLCelebrationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLCelebrationsFeedUnit.f19603j = a.m1068b();
                graphQLVisitableModel = graphQLCelebrationsFeedUnit;
            }
        }
        if (m27323s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27323s());
            if (m27323s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCelebrationsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19605l = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLCelebrationsFeedUnit() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19602i = mutableFlatBuffer.m21525a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int a = ModelHelper.m23094a(flatBufferBuilder, m27319o());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27320p());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m27321q());
        int b3 = flatBufferBuilder.m21502b(m27322r());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27323s());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21495a(4, T_(), 0);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, b3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m27320p();
    }

    public GraphQLCelebrationsFeedUnit(Parcel parcel) {
        super(10);
        this.f19598e = parcel.readString();
        this.f19599f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLCelebrationsFeedUnitItem.class.getClassLoader()));
        this.f19600g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19601h = parcel.readString();
        this.f19602i = parcel.readLong();
        this.f19603j = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLCelebrationsFeedUnitItem.class.getClassLoader()));
        this.f19604k = parcel.readString();
        this.f19605l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19606m = parcel.readString();
        this.f19607n = (CelebrationsFeedUnitExtra) ParcelUtil.b(parcel, CelebrationsFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeList(m27319o());
        parcel.writeValue(m27320p());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m27321q());
        parcel.writeString(m27322r());
        parcel.writeValue(m27323s());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m27307u(), i);
    }

    private CelebrationsFeedUnitExtra m27307u() {
        if (this.f19607n == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f19607n = new CelebrationsFeedUnitExtra();
            } else {
                this.f19607n = (CelebrationsFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, CelebrationsFeedUnitExtra.class);
            }
        }
        return this.f19607n;
    }

    public final PropertyBag U_() {
        if (this.f19608o == null) {
            this.f19608o = new PropertyBag();
        }
        return this.f19608o;
    }
}
