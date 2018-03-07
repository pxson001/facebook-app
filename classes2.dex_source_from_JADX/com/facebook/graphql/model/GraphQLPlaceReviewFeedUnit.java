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
/* compiled from: key_pid */
public final class GraphQLPlaceReviewFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceReviewFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18457d = new GraphQLObjectType(-943698815);
    @Nullable
    public String f18458e;
    @Nullable
    public String f18459f;
    public long f18460g;
    public List<GraphQLPlaceReviewFeedUnitItem> f18461h;
    @Nullable
    public String f18462i;
    @Nullable
    public GraphQLTextWithEntities f18463j;
    @Nullable
    public String f18464k;
    private PlaceReviewFeedUnitExtra f18465l;
    @Nullable
    private PropertyBag f18466m = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25917q();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18457d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30150a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final List mo2882v() {
        return ItemListFeedUnitImpl.m30150a(this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18458e = super.m9948a(this.f18458e, 0);
        return this.f18458e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18459f = super.m9948a(this.f18459f, 1);
        return this.f18459f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18460g;
    }

    public final void mo2872a(long j) {
        this.f18460g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPlaceReviewFeedUnitItem> m25913l() {
        this.f18461h = super.m9944a(this.f18461h, 3, GraphQLPlaceReviewFeedUnitItem.class);
        return (ImmutableList) this.f18461h;
    }

    @FieldOffset
    @Nullable
    public final String m25915o() {
        this.f18462i = super.m9948a(this.f18462i, 4);
        return this.f18462i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25916p() {
        this.f18463j = (GraphQLTextWithEntities) super.m9947a(this.f18463j, 5, GraphQLTextWithEntities.class);
        return this.f18463j;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18464k = super.m9948a(this.f18464k, 6);
        return this.f18464k;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -943698815;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        m9958h();
        if (m25913l() != null) {
            Builder a = ModelHelper.m23097a(m25913l(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLPlaceReviewFeedUnit.f18461h = a.m1068b();
                graphQLVisitableModel = graphQLPlaceReviewFeedUnit;
                if (m25916p() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25916p());
                    if (m25916p() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLPlaceReviewFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18463j = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m25916p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25916p());
            if (m25916p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPlaceReviewFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18463j = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLPlaceReviewFeedUnit() {
        super(8);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18460g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25913l());
        int b3 = flatBufferBuilder.m21502b(m25915o());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25916p());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPlaceReviewFeedUnit(Parcel parcel) {
        super(8);
        this.f18458e = parcel.readString();
        this.f18459f = parcel.readString();
        this.f18460g = parcel.readLong();
        this.f18461h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPlaceReviewFeedUnitItem.class.getClassLoader()));
        this.f18462i = parcel.readString();
        this.f18463j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18464k = parcel.readString();
        this.f18465l = (PlaceReviewFeedUnitExtra) ParcelUtil.b(parcel, PlaceReviewFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m25913l());
        parcel.writeString(m25915o());
        parcel.writeValue(m25916p());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25917q(), i);
    }

    public GraphQLPlaceReviewFeedUnit(Builder builder) {
        super(8);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18458e = builder.d;
        this.f18459f = builder.e;
        this.f18460g = builder.f;
        this.f18461h = builder.g;
        this.f18462i = builder.h;
        this.f18463j = builder.i;
        this.f18464k = builder.j;
        this.f18466m = builder.k;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25916p();
    }

    public final PlaceReviewFeedUnitExtra m25917q() {
        if (this.f18465l == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18465l = new PlaceReviewFeedUnitExtra();
            } else {
                this.f18465l = (PlaceReviewFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PlaceReviewFeedUnitExtra.class);
            }
        }
        return this.f18465l;
    }

    public final PropertyBag U_() {
        if (this.f18466m == null) {
            this.f18466m = new PropertyBag();
        }
        return this.f18466m;
    }
}
