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
import com.facebook.graphql.enums.GraphQLPYMACategory;
import com.facebook.graphql.enums.StoryVisibility;
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
/* compiled from: la_VA */
public final class GraphQLPagesYouMayAdvertiseFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HideableUnit, HasProperty, ScrollableItemListFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLPagesYouMayAdvertiseFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18262d = new GraphQLObjectType(-1889837793);
    List<GraphQLStoryActionLink> f18263e;
    @Nullable
    String f18264f;
    GraphQLPYMACategory f18265g;
    @Nullable
    String f18266h;
    long f18267i;
    @Nullable
    String f18268j;
    List<GraphQLPagesYouMayAdvertiseFeedUnitItem> f18269k;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f18270l;
    @Nullable
    GraphQLPrivacyScope f18271m;
    @Nullable
    String f18272n;
    @Nullable
    GraphQLTextWithEntities f18273o;
    @Nullable
    String f18274p;
    @Nullable
    public String f18275q;
    @Nullable
    public String f18276r;
    public int f18277s;
    private PagesYouMayAdvertiseFeedUnitExtra f18278t;
    @Nullable
    private PropertyBag f18279u = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25600F();
    }

    public final List mo2882v() {
        return m25621s();
    }

    public final GraphQLObjectType getType() {
        return this.f18262d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final List mo2883w() {
        return m25621s();
    }

    public final String mo2881q() {
        String l;
        ImmutableList s = m25621s();
        int ac_ = ac_();
        if (ac_ < s.size()) {
            l = ((GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(ac_)).l();
        } else {
            l = null;
        }
        return l;
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

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m25615l() {
        this.f18263e = super.m9944a(this.f18263e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f18263e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18264f = super.m9948a(this.f18264f, 1);
        return this.f18264f;
    }

    @FieldOffset
    public final GraphQLPYMACategory m25620r() {
        this.f18265g = (GraphQLPYMACategory) super.m9945a(this.f18265g, 2, GraphQLPYMACategory.class, GraphQLPYMACategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f18265g;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18266h = super.m9948a(this.f18266h, 3);
        return this.f18266h;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 4);
        return this.f18267i;
    }

    public final void mo2872a(long j) {
        this.f18267i = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f18268j = super.m9948a(this.f18268j, 5);
        return this.f18268j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPagesYouMayAdvertiseFeedUnitItem> m25621s() {
        this.f18269k = super.m9944a(this.f18269k, 6, GraphQLPagesYouMayAdvertiseFeedUnitItem.class);
        return (ImmutableList) this.f18269k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m25622t() {
        this.f18270l = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18270l, 7, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18270l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m25623u() {
        this.f18271m = (GraphQLPrivacyScope) super.m9947a(this.f18271m, 8, GraphQLPrivacyScope.class);
        return this.f18271m;
    }

    @FieldOffset
    @Nullable
    public final String m25626x() {
        this.f18272n = super.m9948a(this.f18272n, 9);
        return this.f18272n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25628z() {
        this.f18273o = (GraphQLTextWithEntities) super.m9947a(this.f18273o, 10, GraphQLTextWithEntities.class);
        return this.f18273o;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18274p = super.m9948a(this.f18274p, 11);
        return this.f18274p;
    }

    @FieldOffset
    @Nullable
    public final String m25601A() {
        this.f18275q = super.m9948a(this.f18275q, 12);
        return this.f18275q;
    }

    @FieldOffset
    @Nullable
    public final String m25602B() {
        this.f18276r = super.m9948a(this.f18276r, 13);
        return this.f18276r;
    }

    @FieldOffset
    public final int m25603C() {
        m9949a(1, 6);
        return this.f18277s;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25628z();
    }

    public final int jK_() {
        return -1889837793;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25615l() != null) {
            a = ModelHelper.m23097a(m25615l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPagesYouMayAdvertiseFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18263e = a.m1068b();
            }
        }
        if (m25621s() != null) {
            a = ModelHelper.m23097a(m25621s(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPagesYouMayAdvertiseFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18269k = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m25622t() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m25622t());
            if (m25622t() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel2 = (GraphQLPagesYouMayAdvertiseFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18270l = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m25623u() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m25623u());
            if (m25623u() != graphQLPrivacyScope) {
                graphQLVisitableModel2 = (GraphQLPagesYouMayAdvertiseFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18271m = graphQLPrivacyScope;
            }
        }
        if (m25628z() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25628z());
            if (m25628z() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLPagesYouMayAdvertiseFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18273o = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25601A();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 12;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25602B();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 13;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25603C());
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
            this.f18275q = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 12, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18276r = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 13, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18277s = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 14, intValue);
            }
        }
    }

    public GraphQLPagesYouMayAdvertiseFeedUnit() {
        super(16);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18267i = mutableFlatBuffer.m21525a(i, 4, 0);
        this.f18277s = mutableFlatBuffer.m21524a(i, 14, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m25615l());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m25621s());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25622t());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25623u());
        int b4 = flatBufferBuilder.m21502b(m25626x());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m25628z());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m25601A());
        int b7 = flatBufferBuilder.m21502b(m25602B());
        flatBufferBuilder.m21510c(15);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21496a(2, m25620r() == GraphQLPYMACategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m25620r());
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21495a(4, T_(), 0);
        flatBufferBuilder.m21507b(5, b3);
        flatBufferBuilder.m21507b(6, a2);
        flatBufferBuilder.m21507b(7, a3);
        flatBufferBuilder.m21507b(8, a4);
        flatBufferBuilder.m21507b(9, b4);
        flatBufferBuilder.m21507b(10, a5);
        flatBufferBuilder.m21507b(11, b5);
        flatBufferBuilder.m21507b(12, b6);
        flatBufferBuilder.m21507b(13, b7);
        flatBufferBuilder.m21494a(14, m25603C(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPagesYouMayAdvertiseFeedUnit(Parcel parcel) {
        super(16);
        this.f18263e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f18264f = parcel.readString();
        this.f18265g = GraphQLPYMACategory.fromString(parcel.readString());
        this.f18266h = parcel.readString();
        this.f18267i = parcel.readLong();
        this.f18268j = parcel.readString();
        this.f18269k = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPagesYouMayAdvertiseFeedUnitItem.class.getClassLoader()));
        this.f18275q = parcel.readString();
        this.f18276r = parcel.readString();
        this.f18277s = parcel.readInt();
        this.f18270l = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18271m = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f18272n = parcel.readString();
        this.f18273o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18274p = parcel.readString();
        this.f18278t = (PagesYouMayAdvertiseFeedUnitExtra) ParcelUtil.b(parcel, PagesYouMayAdvertiseFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m25615l());
        parcel.writeString(mo2507g());
        parcel.writeString(m25620r().name());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeList(m25621s());
        parcel.writeString(m25601A());
        parcel.writeString(m25602B());
        parcel.writeInt(m25603C());
        parcel.writeValue(m25622t());
        parcel.writeValue(m25623u());
        parcel.writeString(m25626x());
        parcel.writeValue(m25628z());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25600F(), i);
    }

    private PagesYouMayAdvertiseFeedUnitExtra m25600F() {
        if (this.f18278t == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18278t = new PagesYouMayAdvertiseFeedUnitExtra();
            } else {
                this.f18278t = (PagesYouMayAdvertiseFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PagesYouMayAdvertiseFeedUnitExtra.class);
            }
        }
        return this.f18278t;
    }

    public final PropertyBag U_() {
        if (this.f18279u == null) {
            this.f18279u = new PropertyBag();
        }
        return this.f18279u;
    }
}
