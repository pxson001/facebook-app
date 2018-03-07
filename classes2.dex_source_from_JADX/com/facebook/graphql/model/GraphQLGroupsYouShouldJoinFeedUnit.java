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
/* compiled from: last_fetch_time */
public final class GraphQLGroupsYouShouldJoinFeedUnit extends BaseModel implements FeedUnit, GroupsYouShouldJoinFeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupsYouShouldJoinFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18010d = new GraphQLObjectType(1710363082);
    @Nullable
    public String f18011e;
    @Nullable
    public String f18012f;
    public long f18013g;
    public List<GraphQLGroupsYouShouldJoinFeedUnitItem> f18014h;
    @Nullable
    public GraphQLTextWithEntities f18015i;
    public List<GraphQLGroupsYouShouldJoinFeedUnitItem> f18016j;
    @Nullable
    public String f18017k;
    @Nullable
    public GraphQLTextWithEntities f18018l;
    @Nullable
    public String f18019m;
    private GroupsYouShouldJoinFeedUnitExtra f18020n;
    @Nullable
    private PropertyBag f18021o = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25286s();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18010d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30141a(this);
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
        this.f18011e = super.m9948a(this.f18011e, 0);
        return this.f18011e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18012f = super.m9948a(this.f18012f, 1);
        return this.f18012f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18013g;
    }

    public final void mo2872a(long j) {
        this.f18013g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGroupsYouShouldJoinFeedUnitItem> m25280l() {
        this.f18014h = super.m9944a(this.f18014h, 3, GraphQLGroupsYouShouldJoinFeedUnitItem.class);
        return (ImmutableList) this.f18014h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25282o() {
        this.f18015i = (GraphQLTextWithEntities) super.m9947a(this.f18015i, 4, GraphQLTextWithEntities.class);
        return this.f18015i;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGroupsYouShouldJoinFeedUnitItem> m25283p() {
        this.f18016j = super.m9944a(this.f18016j, 5, GraphQLGroupsYouShouldJoinFeedUnitItem.class);
        return (ImmutableList) this.f18016j;
    }

    @FieldOffset
    @Nullable
    public final String m25284q() {
        this.f18017k = super.m9948a(this.f18017k, 6);
        return this.f18017k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25285r() {
        this.f18018l = (GraphQLTextWithEntities) super.m9947a(this.f18018l, 7, GraphQLTextWithEntities.class);
        return this.f18018l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18019m = super.m9948a(this.f18019m, 8);
        return this.f18019m;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return 1710363082;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        m9958h();
        if (m25280l() != null) {
            Builder a2 = ModelHelper.m23097a(m25280l(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLGroupsYouShouldJoinFeedUnit = (GraphQLGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLGroupsYouShouldJoinFeedUnit.f18014h = a2.m1068b();
                graphQLVisitableModel = graphQLGroupsYouShouldJoinFeedUnit;
                if (m25282o() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25282o());
                    if (m25282o() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18015i = graphQLTextWithEntities;
                    }
                }
                if (m25283p() != null) {
                    a = ModelHelper.m23097a(m25283p(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLGroupsYouShouldJoinFeedUnit = (GraphQLGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLGroupsYouShouldJoinFeedUnit.f18016j = a.m1068b();
                        graphQLVisitableModel = graphQLGroupsYouShouldJoinFeedUnit;
                    }
                }
                if (m25285r() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25285r());
                    if (m25285r() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18018l = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m25282o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25282o());
            if (m25282o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18015i = graphQLTextWithEntities;
            }
        }
        if (m25283p() != null) {
            a = ModelHelper.m23097a(m25283p(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGroupsYouShouldJoinFeedUnit = (GraphQLGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLGroupsYouShouldJoinFeedUnit.f18016j = a.m1068b();
                graphQLVisitableModel = graphQLGroupsYouShouldJoinFeedUnit;
            }
        }
        if (m25285r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25285r());
            if (m25285r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldJoinFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18018l = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGroupsYouShouldJoinFeedUnit() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18013g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25280l());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25282o());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m25283p());
        int b3 = flatBufferBuilder.m21502b(m25284q());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25285r());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, b3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGroupsYouShouldJoinFeedUnit(Parcel parcel) {
        super(10);
        this.f18011e = parcel.readString();
        this.f18012f = parcel.readString();
        this.f18013g = parcel.readLong();
        this.f18014h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGroupsYouShouldJoinFeedUnitItem.class.getClassLoader()));
        this.f18015i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18016j = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGroupsYouShouldJoinFeedUnitItem.class.getClassLoader()));
        this.f18017k = parcel.readString();
        this.f18018l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18019m = parcel.readString();
        this.f18020n = (GroupsYouShouldJoinFeedUnitExtra) ParcelUtil.b(parcel, GroupsYouShouldJoinFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m25280l());
        parcel.writeValue(m25282o());
        parcel.writeList(m25283p());
        parcel.writeString(m25284q());
        parcel.writeValue(m25285r());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25286s(), i);
    }

    public GraphQLGroupsYouShouldJoinFeedUnit(Builder builder) {
        super(10);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18011e = builder.d;
        this.f18012f = builder.e;
        this.f18013g = builder.f;
        this.f18014h = builder.g;
        this.f18015i = builder.h;
        this.f18016j = builder.i;
        this.f18017k = builder.j;
        this.f18018l = builder.k;
        this.f18019m = builder.l;
        this.f18021o = builder.m;
    }

    public final GraphQLTextWithEntities mo2878m() {
        GraphQLTextWithEntities o = m25282o();
        if (o == null) {
            o = m25285r();
        }
        return o;
    }

    public final GroupsYouShouldJoinFeedUnitExtra m25286s() {
        if (this.f18020n == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18020n = new GroupsYouShouldJoinFeedUnitExtra();
            } else {
                this.f18020n = (GroupsYouShouldJoinFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, GroupsYouShouldJoinFeedUnitExtra.class);
            }
        }
        return this.f18020n;
    }

    public final PropertyBag U_() {
        if (this.f18021o == null) {
            this.f18021o = new PropertyBag();
        }
        return this.f18021o;
    }
}
