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
/* compiled from: km */
public final class GraphQLPeopleYouShouldFollowFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPeopleYouShouldFollowFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18386d = new GraphQLObjectType(-1231984970);
    @Nullable
    public String f18387e;
    @Nullable
    public String f18388f;
    public long f18389g;
    @Nullable
    public String f18390h;
    @Nullable
    public GraphQLPeopleToFollowConnection f18391i;
    @Nullable
    public String f18392j;
    @Nullable
    public GraphQLTextWithEntities f18393k;
    @Nullable
    public GraphQLTextWithEntities f18394l;
    @Nullable
    public String f18395m;
    @Nullable
    public String f18396n;
    private PeopleYouShouldFollowFeedUnitExtra f18397o;
    @Nullable
    private PropertyBag f18398p = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25796x();
    }

    public final /* synthetic */ List mo2882v() {
        return m25808o();
    }

    public final /* synthetic */ List mo2883w() {
        return m25806l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final ImmutableList m25808o() {
        Builder builder = ImmutableList.builder();
        Collection a = m25810q().a();
        if (CollectionUtil.m29342a(a)) {
            ImmutableList l = m25806l();
        } else {
            Collection collection = a;
        }
        if (CollectionUtil.m29343b(l)) {
            int size = l.size();
            for (int i = 0; i < size; i++) {
                GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem = (GraphQLPeopleYouShouldFollowFeedUnitItem) l.get(i);
                if (IsValidUtil.m22963a(graphQLPeopleYouShouldFollowFeedUnitItem)) {
                    builder.m1069c(graphQLPeopleYouShouldFollowFeedUnitItem);
                }
            }
        }
        return builder.m1068b();
    }

    public final GraphQLObjectType getType() {
        return this.f18386d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final ImmutableList m25806l() {
        return ItemListFeedUnitImpl.m30149a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18387e = super.m9948a(this.f18387e, 0);
        return this.f18387e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18388f = super.m9948a(this.f18388f, 1);
        return this.f18388f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18389g;
    }

    public final void mo2872a(long j) {
        this.f18389g = j;
    }

    @FieldOffset
    @Nullable
    public final String m25809p() {
        this.f18390h = super.m9948a(this.f18390h, 3);
        return this.f18390h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPeopleToFollowConnection m25810q() {
        this.f18391i = (GraphQLPeopleToFollowConnection) super.m9947a(this.f18391i, 4, GraphQLPeopleToFollowConnection.class);
        return this.f18391i;
    }

    @FieldOffset
    @Nullable
    public final String m25811r() {
        this.f18392j = super.m9948a(this.f18392j, 6);
        return this.f18392j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25812s() {
        this.f18393k = (GraphQLTextWithEntities) super.m9947a(this.f18393k, 7, GraphQLTextWithEntities.class);
        return this.f18393k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25813t() {
        this.f18394l = (GraphQLTextWithEntities) super.m9947a(this.f18394l, 8, GraphQLTextWithEntities.class);
        return this.f18394l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18395m = super.m9948a(this.f18395m, 9);
        return this.f18395m;
    }

    @FieldOffset
    @Nullable
    public final String m25814u() {
        this.f18396n = super.m9948a(this.f18396n, 10);
        return this.f18396n;
    }

    @Nullable
    public final String mo2834a() {
        return m25809p();
    }

    public final int jK_() {
        return -1231984970;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25810q() != null) {
            GraphQLPeopleToFollowConnection graphQLPeopleToFollowConnection = (GraphQLPeopleToFollowConnection) graphQLModelMutatingVisitor.mo2928b(m25810q());
            if (m25810q() != graphQLPeopleToFollowConnection) {
                graphQLVisitableModel = (GraphQLPeopleYouShouldFollowFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18391i = graphQLPeopleToFollowConnection;
            }
        }
        if (m25812s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25812s());
            if (m25812s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPeopleYouShouldFollowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18393k = graphQLTextWithEntities;
            }
        }
        if (m25813t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25813t());
            if (m25813t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPeopleYouShouldFollowFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18394l = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPeopleYouShouldFollowFeedUnit() {
        super(12);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18389g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25809p());
        int a = ModelHelper.m23093a(flatBufferBuilder, m25810q());
        int b4 = flatBufferBuilder.m21502b(m25811r());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25812s());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25813t());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m25814u());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, a);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, a2);
        flatBufferBuilder.m21507b(8, a3);
        flatBufferBuilder.m21507b(9, b5);
        flatBufferBuilder.m21507b(10, b6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25812s();
    }

    public GraphQLPeopleYouShouldFollowFeedUnit(Parcel parcel) {
        super(12);
        this.f18387e = parcel.readString();
        this.f18388f = parcel.readString();
        this.f18389g = parcel.readLong();
        this.f18390h = parcel.readString();
        this.f18391i = (GraphQLPeopleToFollowConnection) parcel.readValue(GraphQLPeopleToFollowConnection.class.getClassLoader());
        this.f18392j = parcel.readString();
        this.f18393k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18394l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18395m = parcel.readString();
        this.f18396n = parcel.readString();
        this.f18397o = (PeopleYouShouldFollowFeedUnitExtra) ParcelUtil.b(parcel, PeopleYouShouldFollowFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25809p());
        parcel.writeValue(m25810q());
        parcel.writeString(m25811r());
        parcel.writeValue(m25812s());
        parcel.writeValue(m25813t());
        parcel.writeString(mo2877k());
        parcel.writeString(m25814u());
        parcel.writeParcelable(m25796x(), i);
    }

    public GraphQLPeopleYouShouldFollowFeedUnit(Builder builder) {
        super(12);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18387e = builder.d;
        this.f18388f = builder.e;
        this.f18389g = builder.f;
        this.f18390h = builder.g;
        this.f18391i = builder.h;
        this.f18392j = builder.i;
        this.f18393k = builder.j;
        this.f18394l = builder.k;
        this.f18395m = builder.l;
        this.f18396n = builder.m;
        this.f18398p = builder.n;
    }

    private PeopleYouShouldFollowFeedUnitExtra m25796x() {
        if (this.f18397o == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18397o = new PeopleYouShouldFollowFeedUnitExtra();
            } else {
                this.f18397o = (PeopleYouShouldFollowFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PeopleYouShouldFollowFeedUnitExtra.class);
            }
        }
        return this.f18397o;
    }

    public final PropertyBag U_() {
        if (this.f18398p == null) {
            this.f18398p = new PropertyBag();
        }
        return this.f18398p;
    }
}
