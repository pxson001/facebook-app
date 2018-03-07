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
/* compiled from: ko_KR */
public final class GraphQLQuickPromotionPeopleYouMayKnowFeedUnit extends BaseModel implements FeedUnit, PeopleYouMayKnowFeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18333d = new GraphQLObjectType(-1012424648);
    @Nullable
    public String f18334e;
    @Nullable
    public String f18335f;
    public long f18336g;
    public List<GraphQLPeopleYouMayKnowFeedUnitItem> f18337h;
    public List<GraphQLPeopleYouMayKnowFeedUnitItem> f18338i;
    @Nullable
    public GraphQLTextWithEntities f18339j;
    @Nullable
    public String f18340k;
    @Nullable
    public GraphQLTextWithEntities f18341l;
    @Nullable
    public String f18342m;
    private QuickPromotionPeopleYouMayKnowFeedUnitExtra f18343n;
    @Nullable
    private PropertyBag f18344o = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25705u();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18333d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30151a(this);
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
        this.f18334e = super.m9948a(this.f18334e, 0);
        return this.f18334e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18335f = super.m9948a(this.f18335f, 1);
        return this.f18335f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18336g;
    }

    public final void mo2872a(long j) {
        this.f18336g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> m25715l() {
        this.f18337h = super.m9944a(this.f18337h, 3, GraphQLPeopleYouMayKnowFeedUnitItem.class);
        return (ImmutableList) this.f18337h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> m25717o() {
        this.f18338i = super.m9944a(this.f18338i, 4, GraphQLPeopleYouMayKnowFeedUnitItem.class);
        return (ImmutableList) this.f18338i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25718p() {
        this.f18339j = (GraphQLTextWithEntities) super.m9947a(this.f18339j, 5, GraphQLTextWithEntities.class);
        return this.f18339j;
    }

    @FieldOffset
    @Nullable
    public final String m25719q() {
        this.f18340k = super.m9948a(this.f18340k, 6);
        return this.f18340k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25720r() {
        this.f18341l = (GraphQLTextWithEntities) super.m9947a(this.f18341l, 7, GraphQLTextWithEntities.class);
        return this.f18341l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18342m = super.m9948a(this.f18342m, 8);
        return this.f18342m;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -1012424648;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25715l() != null) {
            a = ModelHelper.m23097a(m25715l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18337h = a.m1068b();
            }
        }
        if (m25717o() != null) {
            a = ModelHelper.m23097a(m25717o(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18338i = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m25718p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25718p());
            if (m25718p() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18339j = graphQLTextWithEntities;
            }
        }
        if (m25720r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25720r());
            if (m25720r() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18341l = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLQuickPromotionPeopleYouMayKnowFeedUnit() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18336g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25715l());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m25717o());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25718p());
        int b3 = flatBufferBuilder.m21502b(m25719q());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25720r());
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

    public GraphQLQuickPromotionPeopleYouMayKnowFeedUnit(Parcel parcel) {
        super(10);
        this.f18334e = parcel.readString();
        this.f18335f = parcel.readString();
        this.f18336g = parcel.readLong();
        this.f18337h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPeopleYouMayKnowFeedUnitItem.class.getClassLoader()));
        this.f18338i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPeopleYouMayKnowFeedUnitItem.class.getClassLoader()));
        this.f18339j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18340k = parcel.readString();
        this.f18341l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18342m = parcel.readString();
        this.f18343n = (QuickPromotionPeopleYouMayKnowFeedUnitExtra) ParcelUtil.b(parcel, QuickPromotionPeopleYouMayKnowFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m25715l());
        parcel.writeList(m25717o());
        parcel.writeValue(m25718p());
        parcel.writeString(m25719q());
        parcel.writeValue(m25720r());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25705u(), i);
    }

    public GraphQLQuickPromotionPeopleYouMayKnowFeedUnit(Builder builder) {
        super(10);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18334e = builder.d;
        this.f18335f = builder.e;
        this.f18336g = builder.f;
        this.f18337h = builder.g;
        this.f18338i = builder.h;
        this.f18339j = builder.i;
        this.f18340k = builder.j;
        this.f18341l = builder.k;
        this.f18342m = builder.l;
        this.f18344o = builder.m;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25718p();
    }

    private QuickPromotionPeopleYouMayKnowFeedUnitExtra m25705u() {
        if (this.f18343n == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18343n = new QuickPromotionPeopleYouMayKnowFeedUnitExtra();
            } else {
                this.f18343n = (QuickPromotionPeopleYouMayKnowFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, QuickPromotionPeopleYouMayKnowFeedUnitExtra.class);
            }
        }
        return this.f18343n;
    }

    public final PropertyBag U_() {
        if (this.f18344o == null) {
            this.f18344o = new PropertyBag();
        }
        return this.f18344o;
    }
}
