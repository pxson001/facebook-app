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
/* compiled from: keyguard */
public final class GraphQLQuickPromotionFeedUnit extends BaseModel implements FeedUnit, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLQuickPromotionFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18402d = new GraphQLObjectType(1641611192);
    @Nullable
    public String f18403e;
    @Nullable
    public String f18404f;
    public long f18405g;
    public List<GraphQLQuickPromotionFeedUnitItem> f18406h;
    public List<GraphQLQuickPromotionFeedUnitItem> f18407i;
    @Nullable
    public String f18408j;
    @Nullable
    public GraphQLTextWithEntities f18409k;
    @Nullable
    public String f18410l;
    @Nullable
    public String f18411m;
    @Nullable
    public String f18412n;
    public int f18413o;
    private QuickPromotionFeedUnitExtra f18414p;
    @Nullable
    private PropertyBag f18415q = null;

    public final String mo2892r() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25821y();
    }

    public final GraphQLNegativeFeedbackActionsConnection mo2894t() {
        GraphQLQuickPromotionFeedUnitItem a = QuickPromotionFeedUnitHelper.a(this);
        return a != null ? a.j() : null;
    }

    public final GraphQLObjectType getType() {
        return this.f18402d;
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

    public final String mo2881q() {
        GraphQLQuickPromotionFeedUnitItem a = QuickPromotionFeedUnitHelper.a(this);
        return a != null ? a.a() : null;
    }

    public final GraphQLNegativeFeedbackActionType mo2893s() {
        return NegativeFeedbackActionsUnitImpl.m29497a((NegativeFeedbackActionsUnit) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18403e = super.m9948a(this.f18403e, 0);
        return this.f18403e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18404f = super.m9948a(this.f18404f, 1);
        return this.f18404f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18405g;
    }

    public final void mo2872a(long j) {
        this.f18405g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLQuickPromotionFeedUnitItem> m25832k() {
        this.f18406h = super.m9944a(this.f18406h, 3, GraphQLQuickPromotionFeedUnitItem.class);
        return (ImmutableList) this.f18406h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLQuickPromotionFeedUnitItem> m25833l() {
        this.f18407i = super.m9944a(this.f18407i, 4, GraphQLQuickPromotionFeedUnitItem.class);
        return (ImmutableList) this.f18407i;
    }

    @FieldOffset
    @Nullable
    public final String m25834m() {
        this.f18408j = super.m9948a(this.f18408j, 5);
        return this.f18408j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25835n() {
        this.f18409k = (GraphQLTextWithEntities) super.m9947a(this.f18409k, 6, GraphQLTextWithEntities.class);
        return this.f18409k;
    }

    @FieldOffset
    @Nullable
    public final String m25842u() {
        this.f18410l = super.m9948a(this.f18410l, 7);
        return this.f18410l;
    }

    @FieldOffset
    @Nullable
    public final String m25843v() {
        this.f18411m = super.m9948a(this.f18411m, 8);
        return this.f18411m;
    }

    @FieldOffset
    @Nullable
    public final String m25844w() {
        this.f18412n = super.m9948a(this.f18412n, 9);
        return this.f18412n;
    }

    @FieldOffset
    public final int m25845x() {
        m9949a(1, 2);
        return this.f18413o;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return 1641611192;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25832k() != null) {
            a = ModelHelper.m23097a(m25832k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLQuickPromotionFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18406h = a.m1068b();
            }
        }
        if (m25833l() != null) {
            a = ModelHelper.m23097a(m25833l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLQuickPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18407i = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m25835n() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25835n());
            if (m25835n() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLQuickPromotionFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18409k = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25843v();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 8;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25844w();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 9;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25845x());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 10;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18411m = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 8, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18412n = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 9, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18413o = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 10, intValue);
            }
        }
    }

    public GraphQLQuickPromotionFeedUnit() {
        super(12);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18405g = mutableFlatBuffer.m21525a(i, 2, 0);
        this.f18413o = mutableFlatBuffer.m21524a(i, 10, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25832k());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m25833l());
        int b3 = flatBufferBuilder.m21502b(m25834m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25835n());
        int b4 = flatBufferBuilder.m21502b(m25842u());
        int b5 = flatBufferBuilder.m21502b(m25843v());
        int b6 = flatBufferBuilder.m21502b(m25844w());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, b3);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21507b(7, b4);
        flatBufferBuilder.m21507b(8, b5);
        flatBufferBuilder.m21507b(9, b6);
        flatBufferBuilder.m21494a(10, m25845x(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLQuickPromotionFeedUnit(Parcel parcel) {
        super(12);
        this.f18403e = parcel.readString();
        this.f18404f = parcel.readString();
        this.f18405g = parcel.readLong();
        this.f18406h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLQuickPromotionFeedUnitItem.class.getClassLoader()));
        this.f18411m = parcel.readString();
        this.f18412n = parcel.readString();
        this.f18413o = parcel.readInt();
        this.f18407i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLQuickPromotionFeedUnitItem.class.getClassLoader()));
        this.f18408j = parcel.readString();
        this.f18409k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18410l = parcel.readString();
        this.f18414p = (QuickPromotionFeedUnitExtra) ParcelUtil.b(parcel, QuickPromotionFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m25832k());
        parcel.writeString(m25843v());
        parcel.writeString(m25844w());
        parcel.writeInt(m25845x());
        parcel.writeList(m25833l());
        parcel.writeString(m25834m());
        parcel.writeValue(m25835n());
        parcel.writeString(m25842u());
        parcel.writeParcelable(m25821y(), i);
    }

    private QuickPromotionFeedUnitExtra m25821y() {
        if (this.f18414p == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18414p = new QuickPromotionFeedUnitExtra();
            } else {
                this.f18414p = (QuickPromotionFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, QuickPromotionFeedUnitExtra.class);
            }
        }
        return this.f18414p;
    }

    public final PropertyBag U_() {
        if (this.f18415q == null) {
            this.f18415q = new PropertyBag();
        }
        return this.f18415q;
    }
}
