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
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
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
/* compiled from: login_broadcast_eligibility_check */
public final class GraphQLPagesYouMayLikeFeedUnit extends BaseModel implements FeedUnit, HideableUnit, HasProperty, ScrollableItemListFeedUnit, Sponsorable, FollowUpFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLPagesYouMayLikeFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f16003d = new GraphQLObjectType(-1396660317);
    @Nullable
    public String f16004e;
    @Nullable
    public String f16005f;
    public long f16006g;
    public List<GraphQLPagesYouMayLikeFeedUnitItem> f16007h;
    public List<GraphQLPagesYouMayLikeFeedUnitItem> f16008i;
    @Nullable
    public GraphQLPageBrowserCategoryInfo f16009j;
    @Nullable
    public GraphQLTextWithEntities f16010k;
    @Nullable
    public String f16011l;
    @Nullable
    public GraphQLTextWithEntities f16012m;
    @Nullable
    public String f16013n;
    @Nullable
    public String f16014o;
    @Nullable
    public String f16015p;
    public int f16016q;
    private PagesYouMayLikeFeedUnitExtra f16017r;
    @Nullable
    private PropertyBag f16018s = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m22810F();
    }

    public final /* synthetic */ List mo2882v() {
        return m22830r();
    }

    public final GraphQLObjectType getType() {
        return this.f16003d;
    }

    public final String mo2881q() {
        String str;
        if (m22832t() == null || ac_() >= m22832t().size()) {
            str = null;
        } else {
            str = ((GraphQLPagesYouMayLikeFeedUnitItem) m22832t().get(ac_())).t();
        }
        return str;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return VisibleItemHelper.m26981b(this);
    }

    public final StoryVisibility mo2879o() {
        return HideableUnitUtil.m26319a((HideableUnit) this);
    }

    public final int mo2880p() {
        return HideableUnitUtil.m26321b(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m22830r() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    public final boolean mo2895u() {
        return ImpressionUtil.m29324a((Sponsorable) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f16004e = super.m9948a(this.f16004e, 0);
        return this.f16004e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f16005f = super.m9948a(this.f16005f, 1);
        return this.f16005f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f16006g;
    }

    public final void mo2872a(long j) {
        this.f16006g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPagesYouMayLikeFeedUnitItem> m22831s() {
        this.f16007h = super.m9944a(this.f16007h, 3, GraphQLPagesYouMayLikeFeedUnitItem.class);
        return (ImmutableList) this.f16007h;
    }

    public final List mo2883w() {
        return m22832t();
    }

    @FieldOffset
    public final ImmutableList<GraphQLPagesYouMayLikeFeedUnitItem> m22832t() {
        this.f16008i = super.m9944a(this.f16008i, 4, GraphQLPagesYouMayLikeFeedUnitItem.class);
        return (ImmutableList) this.f16008i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageBrowserCategoryInfo m22836x() {
        this.f16009j = (GraphQLPageBrowserCategoryInfo) super.m9947a(this.f16009j, 5, GraphQLPageBrowserCategoryInfo.class);
        return this.f16009j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22837y() {
        this.f16010k = (GraphQLTextWithEntities) super.m9947a(this.f16010k, 6, GraphQLTextWithEntities.class);
        return this.f16010k;
    }

    @FieldOffset
    @Nullable
    public final String m22838z() {
        this.f16011l = super.m9948a(this.f16011l, 7);
        return this.f16011l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22811A() {
        this.f16012m = (GraphQLTextWithEntities) super.m9947a(this.f16012m, 8, GraphQLTextWithEntities.class);
        return this.f16012m;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f16013n = super.m9948a(this.f16013n, 9);
        return this.f16013n;
    }

    @FieldOffset
    @Nullable
    public final String m22812B() {
        this.f16014o = super.m9948a(this.f16014o, 10);
        return this.f16014o;
    }

    @FieldOffset
    @Nullable
    public final String m22813C() {
        this.f16015p = super.m9948a(this.f16015p, 11);
        return this.f16015p;
    }

    @FieldOffset
    public final int m22814D() {
        m9949a(1, 4);
        return this.f16016q;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -1396660317;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22831s() != null) {
            a = ModelHelper.m23097a(m22831s(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16007h = a.m1068b();
            }
        }
        if (m22832t() != null) {
            a = ModelHelper.m23097a(m22832t(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16008i = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m22836x() != null) {
            GraphQLPageBrowserCategoryInfo graphQLPageBrowserCategoryInfo = (GraphQLPageBrowserCategoryInfo) graphQLModelMutatingVisitor.mo2928b(m22836x());
            if (m22836x() != graphQLPageBrowserCategoryInfo) {
                graphQLVisitableModel2 = (GraphQLPagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f16009j = graphQLPageBrowserCategoryInfo;
            }
        }
        if (m22837y() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22837y());
            if (m22837y() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f16010k = graphQLTextWithEntities;
            }
        }
        if (m22811A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22811A());
            if (m22811A() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f16012m = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m22837y();
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m22812B();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 10;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m22813C();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 11;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m22814D());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 12;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f16014o = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 10, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f16015p = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 11, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f16016q = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 12, intValue);
            }
        }
    }

    public GraphQLPagesYouMayLikeFeedUnit() {
        super(14);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16006g = mutableFlatBuffer.m21525a(i, 2, 0);
        this.f16016q = mutableFlatBuffer.m21524a(i, 12, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m22831s());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m22832t());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m22836x());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m22837y());
        int b3 = flatBufferBuilder.m21502b(m22838z());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m22811A());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        int b5 = flatBufferBuilder.m21502b(m22812B());
        int b6 = flatBufferBuilder.m21502b(m22813C());
        flatBufferBuilder.m21510c(13);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, b3);
        flatBufferBuilder.m21507b(8, a5);
        flatBufferBuilder.m21507b(9, b4);
        flatBufferBuilder.m21507b(10, b5);
        flatBufferBuilder.m21507b(11, b6);
        flatBufferBuilder.m21494a(12, m22814D(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPagesYouMayLikeFeedUnit(Parcel parcel) {
        super(14);
        this.f16004e = parcel.readString();
        this.f16005f = parcel.readString();
        this.f16006g = parcel.readLong();
        this.f16007h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPagesYouMayLikeFeedUnitItem.class.getClassLoader()));
        this.f16014o = parcel.readString();
        this.f16015p = parcel.readString();
        this.f16016q = parcel.readInt();
        this.f16008i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPagesYouMayLikeFeedUnitItem.class.getClassLoader()));
        this.f16009j = (GraphQLPageBrowserCategoryInfo) parcel.readValue(GraphQLPageBrowserCategoryInfo.class.getClassLoader());
        this.f16010k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16011l = parcel.readString();
        this.f16012m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16013n = parcel.readString();
        this.f16017r = (PagesYouMayLikeFeedUnitExtra) ParcelUtil.b(parcel, PagesYouMayLikeFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m22831s());
        parcel.writeString(m22812B());
        parcel.writeString(m22813C());
        parcel.writeInt(m22814D());
        parcel.writeList(m22832t());
        parcel.writeValue(m22836x());
        parcel.writeValue(m22837y());
        parcel.writeString(m22838z());
        parcel.writeValue(m22811A());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m22810F(), i);
    }

    public GraphQLPagesYouMayLikeFeedUnit(Builder builder) {
        super(14);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16004e = builder.d;
        this.f16005f = builder.e;
        this.f16006g = builder.f;
        this.f16007h = builder.g;
        this.f16014o = builder.h;
        this.f16015p = builder.i;
        this.f16016q = builder.j;
        this.f16008i = builder.k;
        this.f16009j = builder.l;
        this.f16010k = builder.m;
        this.f16011l = builder.n;
        this.f16012m = builder.o;
        this.f16013n = builder.p;
        this.f16018s = builder.q;
    }

    private PagesYouMayLikeFeedUnitExtra m22810F() {
        if (this.f16017r == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f16017r = new PagesYouMayLikeFeedUnitExtra();
            } else {
                this.f16017r = (PagesYouMayLikeFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PagesYouMayLikeFeedUnitExtra.class);
            }
        }
        return this.f16017r;
    }

    public final PropertyBag U_() {
        if (this.f16018s == null) {
            this.f16018s = new PropertyBag();
        }
        return this.f16018s;
    }
}
