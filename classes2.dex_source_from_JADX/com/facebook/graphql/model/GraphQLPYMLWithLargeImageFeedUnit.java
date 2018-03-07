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
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.AutoScrollableItemListFeedUnit;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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
/* compiled from: kn_IN */
public final class GraphQLPYMLWithLargeImageFeedUnit extends BaseModel implements FeedUnit, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, ScrollableItemListFeedUnit, Sponsorable, AutoScrollableItemListFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLPYMLWithLargeImageFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18351d = new GraphQLObjectType(-659919312);
    @Nullable
    public String f18352e;
    @Nullable
    public String f18353f;
    @Deprecated
    @Nullable
    public String f18354g;
    public long f18355h;
    public List<GraphQLPYMLWithLargeImageFeedUnitItem> f18356i;
    @Deprecated
    @Nullable
    public String f18357j;
    @Nullable
    public GraphQLPYMLWithLargeImageFeedUnitsConnection f18358k;
    @Nullable
    public GraphQLTextWithEntities f18359l;
    @Nullable
    public String f18360m;
    @Nullable
    public GraphQLTextWithEntities f18361n;
    @Nullable
    public String f18362o;
    @Nullable
    public String f18363p;
    @Nullable
    public String f18364q;
    public int f18365r;
    private PYMLWithLargeImageFeedUnitExtra f18366s;
    @Nullable
    private PropertyBag f18367t = null;

    public final String mo2892r() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25728J();
    }

    public final /* synthetic */ List mo2882v() {
        return m25758x();
    }

    public final GraphQLObjectType getType() {
        return this.f18351d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final GraphQLNegativeFeedbackActionsConnection mo2894t() {
        GraphQLNegativeFeedbackActionsConnection C;
        GraphQLPYMLWithLargeImageFeedUnitItem a = PYMLWithLargeImageFeedUnitHelper.a(this);
        if (a != null) {
            C = a.C();
        } else {
            C = null;
        }
        return C;
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return VisibleItemHelper.m26981b(this);
    }

    public final String mo2881q() {
        String B;
        GraphQLPYMLWithLargeImageFeedUnitItem a = PYMLWithLargeImageFeedUnitHelper.a(this);
        if (a != null) {
            B = a.B();
        } else {
            B = null;
        }
        return B;
    }

    public final StoryVisibility mo2879o() {
        return HideableUnitUtil.m26319a((HideableUnit) this);
    }

    public final int mo2880p() {
        return HideableUnitUtil.m26321b(this);
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30143a(this);
    }

    public final GraphQLNegativeFeedbackActionType mo2893s() {
        return NegativeFeedbackActionsUnitImpl.m29497a((NegativeFeedbackActionsUnit) this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m25758x() {
        return ItemListFeedUnitImpl.m30143a(this);
    }

    public final boolean mo2895u() {
        return ImpressionUtil.m29324a((Sponsorable) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18352e = super.m9948a(this.f18352e, 0);
        return this.f18352e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18353f = super.m9948a(this.f18353f, 1);
        return this.f18353f;
    }

    @FieldOffset
    @Nullable
    public final String m25759y() {
        this.f18354g = super.m9948a(this.f18354g, 2);
        return this.f18354g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f18355h;
    }

    public final void mo2872a(long j) {
        this.f18355h = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPYMLWithLargeImageFeedUnitItem> m25760z() {
        this.f18356i = super.m9944a(this.f18356i, 4, GraphQLPYMLWithLargeImageFeedUnitItem.class);
        return (ImmutableList) this.f18356i;
    }

    @FieldOffset
    @Nullable
    public final String m25729A() {
        this.f18357j = super.m9948a(this.f18357j, 5);
        return this.f18357j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPYMLWithLargeImageFeedUnitsConnection m25730B() {
        this.f18358k = (GraphQLPYMLWithLargeImageFeedUnitsConnection) super.m9947a(this.f18358k, 6, GraphQLPYMLWithLargeImageFeedUnitsConnection.class);
        return this.f18358k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25731C() {
        this.f18359l = (GraphQLTextWithEntities) super.m9947a(this.f18359l, 7, GraphQLTextWithEntities.class);
        return this.f18359l;
    }

    @FieldOffset
    @Nullable
    public final String m25732D() {
        this.f18360m = super.m9948a(this.f18360m, 8);
        return this.f18360m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25733E() {
        this.f18361n = (GraphQLTextWithEntities) super.m9947a(this.f18361n, 9, GraphQLTextWithEntities.class);
        return this.f18361n;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18362o = super.m9948a(this.f18362o, 10);
        return this.f18362o;
    }

    @FieldOffset
    @Nullable
    public final String m25734F() {
        this.f18363p = super.m9948a(this.f18363p, 11);
        return this.f18363p;
    }

    @FieldOffset
    @Nullable
    public final String m25735G() {
        this.f18364q = super.m9948a(this.f18364q, 12);
        return this.f18364q;
    }

    @FieldOffset
    public final int m25736H() {
        m9949a(1, 5);
        return this.f18365r;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -659919312;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25731C();
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPYMLWithLargeImageFeedUnitsConnection graphQLPYMLWithLargeImageFeedUnitsConnection;
        GraphQLTextWithEntities graphQLTextWithEntities;
        m9958h();
        if (m25760z() != null) {
            Builder a = ModelHelper.m23097a(m25760z(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit = (GraphQLPYMLWithLargeImageFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLPYMLWithLargeImageFeedUnit.f18356i = a.m1068b();
                graphQLVisitableModel = graphQLPYMLWithLargeImageFeedUnit;
                if (m25730B() != null) {
                    graphQLPYMLWithLargeImageFeedUnitsConnection = (GraphQLPYMLWithLargeImageFeedUnitsConnection) graphQLModelMutatingVisitor.mo2928b(m25730B());
                    if (m25730B() != graphQLPYMLWithLargeImageFeedUnitsConnection) {
                        graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18358k = graphQLPYMLWithLargeImageFeedUnitsConnection;
                    }
                }
                if (m25731C() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25731C());
                    if (m25731C() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18359l = graphQLTextWithEntities;
                    }
                }
                if (m25733E() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25733E());
                    if (m25733E() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18361n = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m25730B() != null) {
            graphQLPYMLWithLargeImageFeedUnitsConnection = (GraphQLPYMLWithLargeImageFeedUnitsConnection) graphQLModelMutatingVisitor.mo2928b(m25730B());
            if (m25730B() != graphQLPYMLWithLargeImageFeedUnitsConnection) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18358k = graphQLPYMLWithLargeImageFeedUnitsConnection;
            }
        }
        if (m25731C() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25731C());
            if (m25731C() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18359l = graphQLTextWithEntities;
            }
        }
        if (m25733E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25733E());
            if (m25733E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18361n = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25734F();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 11;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25735G();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 12;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25736H());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 13;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18363p = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 11, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18364q = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 12, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18365r = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 13, intValue);
            }
        }
    }

    public GraphQLPYMLWithLargeImageFeedUnit() {
        super(15);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18355h = mutableFlatBuffer.m21525a(i, 3, 0);
        this.f18365r = mutableFlatBuffer.m21524a(i, 13, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25759y());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25760z());
        int b4 = flatBufferBuilder.m21502b(m25729A());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25730B());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25731C());
        int b5 = flatBufferBuilder.m21502b(m25732D());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25733E());
        int b6 = flatBufferBuilder.m21502b(mo2877k());
        int b7 = flatBufferBuilder.m21502b(m25734F());
        int b8 = flatBufferBuilder.m21502b(m25735G());
        flatBufferBuilder.m21510c(14);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        flatBufferBuilder.m21495a(3, T_(), 0);
        flatBufferBuilder.m21507b(4, a);
        flatBufferBuilder.m21507b(5, b4);
        flatBufferBuilder.m21507b(6, a2);
        flatBufferBuilder.m21507b(7, a3);
        flatBufferBuilder.m21507b(8, b5);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, b6);
        flatBufferBuilder.m21507b(11, b7);
        flatBufferBuilder.m21507b(12, b8);
        flatBufferBuilder.m21494a(13, m25736H(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPYMLWithLargeImageFeedUnit(Parcel parcel) {
        super(15);
        this.f18352e = parcel.readString();
        this.f18353f = parcel.readString();
        this.f18354g = parcel.readString();
        this.f18355h = parcel.readLong();
        this.f18356i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPYMLWithLargeImageFeedUnitItem.class.getClassLoader()));
        this.f18363p = parcel.readString();
        this.f18364q = parcel.readString();
        this.f18365r = parcel.readInt();
        this.f18357j = parcel.readString();
        this.f18358k = (GraphQLPYMLWithLargeImageFeedUnitsConnection) parcel.readValue(GraphQLPYMLWithLargeImageFeedUnitsConnection.class.getClassLoader());
        this.f18359l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18360m = parcel.readString();
        this.f18361n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18362o = parcel.readString();
        this.f18366s = (PYMLWithLargeImageFeedUnitExtra) ParcelUtil.b(parcel, PYMLWithLargeImageFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeString(m25759y());
        parcel.writeLong(T_());
        parcel.writeList(m25760z());
        parcel.writeString(m25734F());
        parcel.writeString(m25735G());
        parcel.writeInt(m25736H());
        parcel.writeString(m25729A());
        parcel.writeValue(m25730B());
        parcel.writeValue(m25731C());
        parcel.writeString(m25732D());
        parcel.writeValue(m25733E());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25728J(), i);
    }

    public GraphQLPYMLWithLargeImageFeedUnit(Builder builder) {
        super(15);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18352e = builder.d;
        this.f18353f = builder.e;
        this.f18354g = builder.f;
        this.f18355h = builder.g;
        this.f18356i = builder.h;
        this.f18363p = builder.i;
        this.f18364q = builder.j;
        this.f18365r = builder.k;
        this.f18357j = builder.l;
        this.f18358k = builder.m;
        this.f18359l = builder.n;
        this.f18360m = builder.o;
        this.f18361n = builder.p;
        this.f18362o = builder.q;
        this.f18367t = builder.r;
    }

    private PYMLWithLargeImageFeedUnitExtra m25728J() {
        if (this.f18366s == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18366s = new PYMLWithLargeImageFeedUnitExtra();
            } else {
                this.f18366s = (PYMLWithLargeImageFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PYMLWithLargeImageFeedUnitExtra.class);
            }
        }
        return this.f18366s;
    }

    public final PropertyBag U_() {
        if (this.f18367t == null) {
            this.f18367t = new PropertyBag();
        }
        return this.f18367t;
    }
}
