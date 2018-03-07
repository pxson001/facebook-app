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
import com.facebook.graphql.enums.GraphQLGroupCreationSuggestionType;
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
/* compiled from: last_activity_time */
public final class GraphQLGroupsYouShouldCreateFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupsYouShouldCreateFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18177d = new GraphQLObjectType(1112886300);
    @Nullable
    public String f18178e;
    @Nullable
    public String f18179f;
    public long f18180g;
    public List<GraphQLGroupsYouShouldCreateFeedUnitItem> f18181h;
    @Nullable
    public GraphQLTextWithEntities f18182i;
    public List<GraphQLGroupsYouShouldCreateFeedUnitItem> f18183j;
    @Nullable
    public String f18184k;
    @Nullable
    public GraphQLTextWithEntities f18185l;
    @Nullable
    public String f18186m;
    private GroupsYouShouldCreateFeedUnitExtra f18187n;
    @Nullable
    private PropertyBag f18188o = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25500u();
    }

    public final /* synthetic */ List mo2882v() {
        return m25510l();
    }

    public final List mo2883w() {
        return m25514q();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18177d;
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

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18178e = super.m9948a(this.f18178e, 0);
        return this.f18178e;
    }

    public final ImmutableList m25510l() {
        Builder builder = ImmutableList.builder();
        Collection q = m25514q();
        if (CollectionUtil.m29342a(q)) {
            ImmutableList o = m25512o();
        } else {
            Collection collection = q;
        }
        if (CollectionUtil.m29343b(o)) {
            int size = o.size();
            for (int i = 0; i < size; i++) {
                Object obj;
                GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem = (GraphQLGroupsYouShouldCreateFeedUnitItem) o.get(i);
                if (graphQLGroupsYouShouldCreateFeedUnitItem.n() == null || graphQLGroupsYouShouldCreateFeedUnitItem.a() == null || graphQLGroupsYouShouldCreateFeedUnitItem.p() == null || !(graphQLGroupsYouShouldCreateFeedUnitItem.q() == GraphQLGroupCreationSuggestionType.MESSENGER || IsValidUtil.m22948a(graphQLGroupsYouShouldCreateFeedUnitItem.o()))) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    builder.m1069c(graphQLGroupsYouShouldCreateFeedUnitItem);
                }
            }
        }
        return builder.m1068b();
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18179f = super.m9948a(this.f18179f, 1);
        return this.f18179f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18180g;
    }

    public final void mo2872a(long j) {
        this.f18180g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGroupsYouShouldCreateFeedUnitItem> m25512o() {
        this.f18181h = super.m9944a(this.f18181h, 3, GraphQLGroupsYouShouldCreateFeedUnitItem.class);
        return (ImmutableList) this.f18181h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25513p() {
        this.f18182i = (GraphQLTextWithEntities) super.m9947a(this.f18182i, 4, GraphQLTextWithEntities.class);
        return this.f18182i;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGroupsYouShouldCreateFeedUnitItem> m25514q() {
        this.f18183j = super.m9944a(this.f18183j, 5, GraphQLGroupsYouShouldCreateFeedUnitItem.class);
        return (ImmutableList) this.f18183j;
    }

    @FieldOffset
    @Nullable
    public final String m25515r() {
        this.f18184k = super.m9948a(this.f18184k, 6);
        return this.f18184k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25516s() {
        this.f18185l = (GraphQLTextWithEntities) super.m9947a(this.f18185l, 7, GraphQLTextWithEntities.class);
        return this.f18185l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18186m = super.m9948a(this.f18186m, 8);
        return this.f18186m;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return 1112886300;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        m9958h();
        if (m25512o() != null) {
            Builder a2 = ModelHelper.m23097a(m25512o(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLGroupsYouShouldCreateFeedUnit = (GraphQLGroupsYouShouldCreateFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLGroupsYouShouldCreateFeedUnit.f18181h = a2.m1068b();
                graphQLVisitableModel = graphQLGroupsYouShouldCreateFeedUnit;
                if (m25513p() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25513p());
                    if (m25513p() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGroupsYouShouldCreateFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18182i = graphQLTextWithEntities;
                    }
                }
                if (m25514q() != null) {
                    a = ModelHelper.m23097a(m25514q(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLGroupsYouShouldCreateFeedUnit = (GraphQLGroupsYouShouldCreateFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLGroupsYouShouldCreateFeedUnit.f18183j = a.m1068b();
                        graphQLVisitableModel = graphQLGroupsYouShouldCreateFeedUnit;
                    }
                }
                if (m25516s() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25516s());
                    if (m25516s() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGroupsYouShouldCreateFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18185l = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m25513p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25513p());
            if (m25513p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldCreateFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18182i = graphQLTextWithEntities;
            }
        }
        if (m25514q() != null) {
            a = ModelHelper.m23097a(m25514q(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGroupsYouShouldCreateFeedUnit = (GraphQLGroupsYouShouldCreateFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLGroupsYouShouldCreateFeedUnit.f18183j = a.m1068b();
                graphQLVisitableModel = graphQLGroupsYouShouldCreateFeedUnit;
            }
        }
        if (m25516s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25516s());
            if (m25516s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldCreateFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18185l = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGroupsYouShouldCreateFeedUnit() {
        super(10);
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25516s();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18180g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25512o());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25513p());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m25514q());
        int b3 = flatBufferBuilder.m21502b(m25515r());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25516s());
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

    public GraphQLGroupsYouShouldCreateFeedUnit(Parcel parcel) {
        super(10);
        this.f18178e = parcel.readString();
        this.f18179f = parcel.readString();
        this.f18180g = parcel.readLong();
        this.f18181h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGroupsYouShouldCreateFeedUnitItem.class.getClassLoader()));
        this.f18182i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18183j = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGroupsYouShouldCreateFeedUnitItem.class.getClassLoader()));
        this.f18184k = parcel.readString();
        this.f18185l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18186m = parcel.readString();
        this.f18187n = (GroupsYouShouldCreateFeedUnitExtra) ParcelUtil.b(parcel, GroupsYouShouldCreateFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m25512o());
        parcel.writeValue(m25513p());
        parcel.writeList(m25514q());
        parcel.writeString(m25515r());
        parcel.writeValue(m25516s());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25500u(), i);
    }

    public GraphQLGroupsYouShouldCreateFeedUnit(Builder builder) {
        super(10);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18178e = builder.d;
        this.f18179f = builder.e;
        this.f18180g = builder.f;
        this.f18181h = builder.g;
        this.f18182i = builder.h;
        this.f18183j = builder.i;
        this.f18184k = builder.j;
        this.f18185l = builder.k;
        this.f18186m = builder.l;
        this.f18188o = builder.m;
    }

    private GroupsYouShouldCreateFeedUnitExtra m25500u() {
        if (this.f18187n == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18187n = new GroupsYouShouldCreateFeedUnitExtra();
            } else {
                this.f18187n = (GroupsYouShouldCreateFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, GroupsYouShouldCreateFeedUnitExtra.class);
            }
        }
        return this.f18187n;
    }

    public final PropertyBag U_() {
        if (this.f18188o == null) {
            this.f18188o = new PropertyBag();
        }
        return this.f18188o;
    }
}
