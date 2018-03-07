package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.CollectionUtil;
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
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: jewel_lit_up */
public final class GraphQLWorkCommunityTrendingFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLWorkCommunityTrendingFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18638d = new GraphQLObjectType(-1646008225);
    @Nullable
    public String f18639e;
    @Nullable
    public String f18640f;
    public long f18641g;
    @Nullable
    public String f18642h;
    @Nullable
    public GraphQLTextWithEntities f18643i;
    @Nullable
    public String f18644j;
    public List<GraphQLWorkCommunityTrendingFeedUnitItem> f18645k;
    private WorkCommunityTrendingFeedUnitExtra f18646l;
    @Nullable
    private PropertyBag f18647m = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m26135s();
    }

    public final /* synthetic */ List mo2882v() {
        return m26147o();
    }

    public final /* synthetic */ List mo2883w() {
        return m26145l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18638d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final ImmutableList m26145l() {
        return m26150r();
    }

    public final ImmutableList m26147o() {
        Builder builder = ImmutableList.builder();
        Collection r = m26150r();
        if (CollectionUtil.m29342a(r)) {
            ImmutableList l = m26145l();
        } else {
            Collection collection = r;
        }
        if (CollectionUtil.m29343b(l)) {
            int size = l.size();
            for (int i = 0; i < size; i++) {
                Object obj;
                GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem = (GraphQLWorkCommunityTrendingFeedUnitItem) l.get(i);
                if (graphQLWorkCommunityTrendingFeedUnitItem.j() != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    builder.m1069c(graphQLWorkCommunityTrendingFeedUnitItem);
                }
            }
        }
        return builder.m1068b();
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18639e = super.m9948a(this.f18639e, 0);
        return this.f18639e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18640f = super.m9948a(this.f18640f, 1);
        return this.f18640f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18641g;
    }

    public final void mo2872a(long j) {
        this.f18641g = j;
    }

    @FieldOffset
    @Nullable
    public final String m26148p() {
        this.f18642h = super.m9948a(this.f18642h, 3);
        return this.f18642h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m26149q() {
        this.f18643i = (GraphQLTextWithEntities) super.m9947a(this.f18643i, 4, GraphQLTextWithEntities.class);
        return this.f18643i;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18644j = super.m9948a(this.f18644j, 5);
        return this.f18644j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLWorkCommunityTrendingFeedUnitItem> m26150r() {
        this.f18645k = super.m9944a(this.f18645k, 6, GraphQLWorkCommunityTrendingFeedUnitItem.class);
        return (ImmutableList) this.f18645k;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -1646008225;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m26149q() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m26149q());
            if (m26149q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLWorkCommunityTrendingFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18643i = graphQLTextWithEntities;
            }
        }
        if (m26150r() != null) {
            Builder a = ModelHelper.m23097a(m26150r(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit = (GraphQLWorkCommunityTrendingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLWorkCommunityTrendingFeedUnit.f18645k = a.m1068b();
                graphQLVisitableModel = graphQLWorkCommunityTrendingFeedUnit;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLWorkCommunityTrendingFeedUnit() {
        super(8);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18641g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m26148p());
        int a = ModelHelper.m23093a(flatBufferBuilder, m26149q());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m26150r());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, a);
        flatBufferBuilder.m21507b(5, b4);
        flatBufferBuilder.m21507b(6, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLWorkCommunityTrendingFeedUnit(Parcel parcel) {
        super(8);
        this.f18639e = parcel.readString();
        this.f18640f = parcel.readString();
        this.f18641g = parcel.readLong();
        this.f18642h = parcel.readString();
        this.f18643i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18644j = parcel.readString();
        this.f18645k = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLWorkCommunityTrendingFeedUnitItem.class.getClassLoader()));
        this.f18646l = (WorkCommunityTrendingFeedUnitExtra) ParcelUtil.b(parcel, WorkCommunityTrendingFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m26148p());
        parcel.writeValue(m26149q());
        parcel.writeString(mo2877k());
        parcel.writeList(m26150r());
        parcel.writeParcelable(m26135s(), i);
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m26149q();
    }

    private WorkCommunityTrendingFeedUnitExtra m26135s() {
        if (this.f18646l == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18646l = new WorkCommunityTrendingFeedUnitExtra();
            } else {
                this.f18646l = (WorkCommunityTrendingFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, WorkCommunityTrendingFeedUnitExtra.class);
            }
        }
        return this.f18646l;
    }

    public final PropertyBag U_() {
        if (this.f18647m == null) {
            this.f18647m = new PropertyBag();
        }
        return this.f18647m;
    }
}
