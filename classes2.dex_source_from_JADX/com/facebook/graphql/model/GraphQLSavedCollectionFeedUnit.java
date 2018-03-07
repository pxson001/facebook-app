package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.ItemListFeedUnit.ItemListSeeAllModel;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
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
/* compiled from: mFbSharedPrefsLock */
public final class GraphQLSavedCollectionFeedUnit extends BaseModel implements FeedUnit, HideableUnit, HasProperty, ScrollableItemListFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLSavedCollectionFeedUnit> CREATOR = new 1();
    GraphQLObjectType f15633d = new GraphQLObjectType(-1917069369);
    List<GraphQLStoryActionLink> f15634e;
    @Nullable
    String f15635f;
    @Nullable
    String f15636g;
    long f15637h;
    List<GraphQLSavedCollectionFeedUnitItem> f15638i;
    List<GraphQLStoryActionLink> f15639j;
    @Nullable
    GraphQLTimelineAppCollection f15640k;
    List<GraphQLSavedCollectionFeedUnitItem> f15641l;
    @Nullable
    GraphQLTextWithEntities f15642m;
    @Nullable
    String f15643n;
    @Nullable
    GraphQLTextWithEntities f15644o;
    @Nullable
    String f15645p;
    @Nullable
    public String f15646q;
    @Nullable
    public String f15647r;
    public int f15648s;
    private SavedCollectionFeedUnitExtra f15649t;
    @Nullable
    private PropertyBag f15650u = null;

    public final ItemListSeeAllModel m22275r() {
        ItemListSeeAllModel itemListSeeAllModel;
        ImmutableList t = m22277t();
        if (t == null || t.isEmpty()) {
            t = m22281x();
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22938a((List) t, 1666378394);
        if (a != null) {
            if (!StringUtil.m3591a(a.aB(), a.aE())) {
                itemListSeeAllModel = new ItemListSeeAllModel(a.aB(), a.aE());
                return itemListSeeAllModel;
            }
        }
        itemListSeeAllModel = null;
        return itemListSeeAllModel;
    }

    public final String mo2881q() {
        GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem;
        ImmutableList a = ScrollableItemListFeedUnitImpl.a(this);
        int ac_ = ac_();
        if (ac_ >= a.size() || ac_ < 0) {
            graphQLSavedCollectionFeedUnitItem = null;
        } else {
            graphQLSavedCollectionFeedUnitItem = (GraphQLSavedCollectionFeedUnitItem) a.get(ac_);
        }
        GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem2 = graphQLSavedCollectionFeedUnitItem;
        return graphQLSavedCollectionFeedUnitItem2 != null ? graphQLSavedCollectionFeedUnitItem2.m() : null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m22252G();
    }

    public final /* synthetic */ List mo2882v() {
        return m22276s();
    }

    public final /* synthetic */ List mo2883w() {
        return m22270l();
    }

    public final GraphQLObjectType getType() {
        return this.f15633d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final StoryVisibility mo2879o() {
        return HideableUnitUtil.m26319a((HideableUnit) this);
    }

    public final int mo2880p() {
        return HideableUnitUtil.m26321b(this);
    }

    public final ImmutableList m22270l() {
        return SavedCollectionFeedUnitHelper.a(this);
    }

    public final GraphQLTextWithEntities mo2878m() {
        return SavedCollectionFeedUnitHelper.c(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m22276s() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m22277t() {
        this.f15634e = super.m9944a(this.f15634e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f15634e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f15635f = super.m9948a(this.f15635f, 1);
        return this.f15635f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f15636g = super.m9948a(this.f15636g, 2);
        return this.f15636g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f15637h;
    }

    public final void mo2872a(long j) {
        this.f15637h = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSavedCollectionFeedUnitItem> m22278u() {
        this.f15638i = super.m9944a(this.f15638i, 4, GraphQLSavedCollectionFeedUnitItem.class);
        return (ImmutableList) this.f15638i;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m22281x() {
        this.f15639j = super.m9944a(this.f15639j, 5, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f15639j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollection m22282y() {
        this.f15640k = (GraphQLTimelineAppCollection) super.m9947a(this.f15640k, 6, GraphQLTimelineAppCollection.class);
        return this.f15640k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSavedCollectionFeedUnitItem> m22283z() {
        this.f15641l = super.m9944a(this.f15641l, 7, GraphQLSavedCollectionFeedUnitItem.class);
        return (ImmutableList) this.f15641l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22253A() {
        this.f15642m = (GraphQLTextWithEntities) super.m9947a(this.f15642m, 8, GraphQLTextWithEntities.class);
        return this.f15642m;
    }

    @FieldOffset
    @Nullable
    public final String m22254B() {
        this.f15643n = super.m9948a(this.f15643n, 9);
        return this.f15643n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22255C() {
        this.f15644o = (GraphQLTextWithEntities) super.m9947a(this.f15644o, 10, GraphQLTextWithEntities.class);
        return this.f15644o;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f15645p = super.m9948a(this.f15645p, 11);
        return this.f15645p;
    }

    @FieldOffset
    @Nullable
    public final String m22256D() {
        this.f15646q = super.m9948a(this.f15646q, 12);
        return this.f15646q;
    }

    @FieldOffset
    @Nullable
    public final String m22257E() {
        this.f15647r = super.m9948a(this.f15647r, 13);
        return this.f15647r;
    }

    @FieldOffset
    public final int m22258F() {
        m9949a(1, 6);
        return this.f15648s;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -1917069369;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22277t() != null) {
            a = ModelHelper.m23097a(m22277t(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSavedCollectionFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15634e = a.m1068b();
            }
        }
        if (m22278u() != null) {
            a = ModelHelper.m23097a(m22278u(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSavedCollectionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15638i = a.m1068b();
            }
        }
        if (m22281x() != null) {
            a = ModelHelper.m23097a(m22281x(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSavedCollectionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15639j = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m22282y() != null) {
            GraphQLTimelineAppCollection graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) graphQLModelMutatingVisitor.mo2928b(m22282y());
            if (m22282y() != graphQLTimelineAppCollection) {
                graphQLVisitableModel2 = (GraphQLSavedCollectionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15640k = graphQLTimelineAppCollection;
            }
        }
        if (m22283z() != null) {
            Builder a2 = ModelHelper.m23097a(m22283z(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLSavedCollectionFeedUnit.f15641l = a2.m1068b();
                graphQLVisitableModel2 = graphQLSavedCollectionFeedUnit;
            }
        }
        if (m22253A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22253A());
            if (m22253A() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLSavedCollectionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15642m = graphQLTextWithEntities;
            }
        }
        if (m22255C() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22255C());
            if (m22255C() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLSavedCollectionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f15644o = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m22256D();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 12;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m22257E();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 13;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m22258F());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 14;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f15646q = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 12, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f15647r = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 13, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f15648s = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 14, intValue);
            }
        }
    }

    public GraphQLSavedCollectionFeedUnit() {
        super(16);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15637h = mutableFlatBuffer.m21525a(i, 3, 0);
        this.f15648s = mutableFlatBuffer.m21524a(i, 14, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22277t());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m22278u());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m22281x());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m22282y());
        int a5 = ModelHelper.m23094a(flatBufferBuilder, m22283z());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m22253A());
        int b3 = flatBufferBuilder.m21502b(m22254B());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m22255C());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        int b5 = flatBufferBuilder.m21502b(m22256D());
        int b6 = flatBufferBuilder.m21502b(m22257E());
        flatBufferBuilder.m21510c(15);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21495a(3, T_(), 0);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, a5);
        flatBufferBuilder.m21507b(8, a6);
        flatBufferBuilder.m21507b(9, b3);
        flatBufferBuilder.m21507b(10, a7);
        flatBufferBuilder.m21507b(11, b4);
        flatBufferBuilder.m21507b(12, b5);
        flatBufferBuilder.m21507b(13, b6);
        flatBufferBuilder.m21494a(14, m22258F(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSavedCollectionFeedUnit(Parcel parcel) {
        super(16);
        this.f15634e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f15635f = parcel.readString();
        this.f15636g = parcel.readString();
        this.f15637h = parcel.readLong();
        this.f15638i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSavedCollectionFeedUnitItem.class.getClassLoader()));
        this.f15646q = parcel.readString();
        this.f15647r = parcel.readString();
        this.f15648s = parcel.readInt();
        this.f15639j = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f15640k = (GraphQLTimelineAppCollection) parcel.readValue(GraphQLTimelineAppCollection.class.getClassLoader());
        this.f15641l = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSavedCollectionFeedUnitItem.class.getClassLoader()));
        this.f15642m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15643n = parcel.readString();
        this.f15644o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15645p = parcel.readString();
        this.f15649t = (SavedCollectionFeedUnitExtra) ParcelUtil.b(parcel, SavedCollectionFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m22277t());
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m22278u());
        parcel.writeString(m22256D());
        parcel.writeString(m22257E());
        parcel.writeInt(m22258F());
        parcel.writeList(m22281x());
        parcel.writeValue(m22282y());
        parcel.writeList(m22283z());
        parcel.writeValue(m22253A());
        parcel.writeString(m22254B());
        parcel.writeValue(m22255C());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m22252G(), i);
    }

    public GraphQLSavedCollectionFeedUnit(Builder builder) {
        super(16);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15634e = builder.d;
        this.f15635f = builder.e;
        this.f15636g = builder.f;
        this.f15637h = builder.g;
        this.f15638i = builder.h;
        this.f15646q = builder.i;
        this.f15647r = builder.j;
        this.f15648s = builder.k;
        this.f15639j = builder.l;
        this.f15640k = builder.m;
        this.f15641l = builder.n;
        this.f15642m = builder.o;
        this.f15643n = builder.p;
        this.f15644o = builder.q;
        this.f15645p = builder.r;
        this.f15650u = builder.s;
    }

    private SavedCollectionFeedUnitExtra m22252G() {
        if (this.f15649t == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f15649t = new SavedCollectionFeedUnitExtra();
            } else {
                this.f15649t = (SavedCollectionFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, SavedCollectionFeedUnitExtra.class);
            }
        }
        return this.f15649t;
    }

    public final PropertyBag U_() {
        if (this.f15650u == null) {
            this.f15650u = new PropertyBag();
        }
        return this.f15650u;
    }
}
