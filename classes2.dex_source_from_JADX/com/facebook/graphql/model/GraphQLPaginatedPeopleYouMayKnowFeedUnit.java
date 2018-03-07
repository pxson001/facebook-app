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
/* compiled from: ku_TR */
public final class GraphQLPaginatedPeopleYouMayKnowFeedUnit extends BaseModel implements FeedUnit, PeopleYouMayKnowFeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPaginatedPeopleYouMayKnowFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18320d = new GraphQLObjectType(2028208271);
    @Nullable
    GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection f18321e;
    @Nullable
    String f18322f;
    @Nullable
    String f18323g;
    long f18324h;
    @Nullable
    String f18325i;
    @Nullable
    String f18326j;
    @Nullable
    GraphQLTextWithEntities f18327k;
    @Nullable
    GraphQLTextWithEntities f18328l;
    @Nullable
    String f18329m;
    @Nullable
    String f18330n;
    private PaginatedPeopleYouMayKnowFeedUnitExtra f18331o;
    @Nullable
    private PropertyBag f18332p = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25702u();
    }

    public final /* synthetic */ List mo2882v() {
        return m25694l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18320d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30146a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m25694l() {
        return ItemListFeedUnitImpl.m30146a(this);
    }

    @FieldOffset
    @Nullable
    public final GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection m25696o() {
        this.f18321e = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) super.m9947a(this.f18321e, 0, GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.class);
        return this.f18321e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18322f = super.m9948a(this.f18322f, 1);
        return this.f18322f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18323g = super.m9948a(this.f18323g, 2);
        return this.f18323g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f18324h;
    }

    public final void mo2872a(long j) {
        this.f18324h = j;
    }

    @FieldOffset
    @Nullable
    public final String m25697p() {
        this.f18325i = super.m9948a(this.f18325i, 4);
        return this.f18325i;
    }

    @FieldOffset
    @Nullable
    public final String m25698q() {
        this.f18326j = super.m9948a(this.f18326j, 6);
        return this.f18326j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25699r() {
        this.f18327k = (GraphQLTextWithEntities) super.m9947a(this.f18327k, 7, GraphQLTextWithEntities.class);
        return this.f18327k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25700s() {
        this.f18328l = (GraphQLTextWithEntities) super.m9947a(this.f18328l, 8, GraphQLTextWithEntities.class);
        return this.f18328l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18329m = super.m9948a(this.f18329m, 9);
        return this.f18329m;
    }

    @FieldOffset
    @Nullable
    public final String m25701t() {
        this.f18330n = super.m9948a(this.f18330n, 10);
        return this.f18330n;
    }

    @Nullable
    public final String mo2834a() {
        return m25697p();
    }

    public final int jK_() {
        return 2028208271;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25696o() != null) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) graphQLModelMutatingVisitor.mo2928b(m25696o());
            if (m25696o() != graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) {
                graphQLVisitableModel = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18321e = graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection;
            }
        }
        if (m25699r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25699r());
            if (m25699r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18327k = graphQLTextWithEntities;
            }
        }
        if (m25700s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25700s());
            if (m25700s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18328l = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnit() {
        super(12);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18324h = mutableFlatBuffer.m21525a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m25696o());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25697p());
        int b4 = flatBufferBuilder.m21502b(m25698q());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25699r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25700s());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m25701t());
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

    public GraphQLPaginatedPeopleYouMayKnowFeedUnit(Parcel parcel) {
        super(12);
        this.f18321e = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) parcel.readValue(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.class.getClassLoader());
        this.f18322f = parcel.readString();
        this.f18323g = parcel.readString();
        this.f18324h = parcel.readLong();
        this.f18325i = parcel.readString();
        this.f18326j = parcel.readString();
        this.f18327k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18328l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18329m = parcel.readString();
        this.f18330n = parcel.readString();
        this.f18331o = (PaginatedPeopleYouMayKnowFeedUnitExtra) ParcelUtil.b(parcel, PaginatedPeopleYouMayKnowFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m25696o());
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25697p());
        parcel.writeString(m25698q());
        parcel.writeValue(m25699r());
        parcel.writeValue(m25700s());
        parcel.writeString(mo2877k());
        parcel.writeString(m25701t());
        parcel.writeParcelable(m25702u(), i);
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnit(Builder builder) {
        super(12);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18321e = builder.d;
        this.f18322f = builder.e;
        this.f18323g = builder.f;
        this.f18324h = builder.g;
        this.f18325i = builder.h;
        this.f18326j = builder.i;
        this.f18327k = builder.j;
        this.f18328l = builder.k;
        this.f18329m = builder.l;
        this.f18330n = builder.m;
        this.f18332p = builder.n;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return null;
    }

    public final PaginatedPeopleYouMayKnowFeedUnitExtra m25702u() {
        if (this.f18331o == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18331o = new PaginatedPeopleYouMayKnowFeedUnitExtra();
            } else {
                this.f18331o = (PaginatedPeopleYouMayKnowFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PaginatedPeopleYouMayKnowFeedUnitExtra.class);
            }
        }
        return this.f18331o;
    }

    public final PropertyBag U_() {
        if (this.f18332p == null) {
            this.f18332p = new PropertyBag();
        }
        return this.f18332p;
    }
}
