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
/* compiled from: kn */
public final class GraphQLCreativePagesYouMayLikeFeedUnit extends BaseModel implements FeedUnit, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, ScrollableItemListFeedUnit, Sponsorable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLCreativePagesYouMayLikeFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18368d = new GraphQLObjectType(336198388);
    @Nullable
    String f18369e;
    List<GraphQLCreativePagesYouMayLikeFeedUnitItem> f18370f;
    @Nullable
    GraphQLTextWithEntities f18371g;
    @Nullable
    String f18372h;
    long f18373i;
    List<GraphQLCreativePagesYouMayLikeFeedUnitItem> f18374j;
    @Nullable
    String f18375k;
    @Nullable
    GraphQLTextWithEntities f18376l;
    @Nullable
    String f18377m;
    @Nullable
    public String f18378n;
    @Nullable
    public String f18379o;
    public int f18380p;
    private CreativePagesYouMayLikeFeedUnitExtra f18381q;
    @Nullable
    private PropertyBag f18382r = null;

    public final String mo2892r() {
        return null;
    }

    public final List mo2883w() {
        return m25788x();
    }

    public final String mo2881q() {
        String str;
        ImmutableList x = m25788x();
        if (x == null || ac_() >= x.size()) {
            str = null;
        } else {
            str = ((GraphQLCreativePagesYouMayLikeFeedUnitItem) x.get(ac_())).v();
        }
        return str;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25761H();
    }

    public final GraphQLNegativeFeedbackActionsConnection mo2894t() {
        GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection;
        ImmutableList x = m25788x();
        if (x == null || ac_() >= x.size()) {
            graphQLNegativeFeedbackActionsConnection = null;
        } else {
            graphQLNegativeFeedbackActionsConnection = ((GraphQLCreativePagesYouMayLikeFeedUnitItem) x.get(ac_())).x();
        }
        return graphQLNegativeFeedbackActionsConnection;
    }

    public final GraphQLObjectType getType() {
        return this.f18368d;
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

    public final GraphQLNegativeFeedbackActionType mo2893s() {
        return NegativeFeedbackActionsUnitImpl.m29497a((NegativeFeedbackActionsUnit) this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final List mo2882v() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    public final boolean mo2895u() {
        return ImpressionUtil.m29324a((Sponsorable) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18369e = super.m9948a(this.f18369e, 0);
        return this.f18369e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLCreativePagesYouMayLikeFeedUnitItem> m25788x() {
        this.f18370f = super.m9944a(this.f18370f, 1, GraphQLCreativePagesYouMayLikeFeedUnitItem.class);
        return (ImmutableList) this.f18370f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25789y() {
        this.f18371g = (GraphQLTextWithEntities) super.m9947a(this.f18371g, 2, GraphQLTextWithEntities.class);
        return this.f18371g;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18372h = super.m9948a(this.f18372h, 3);
        return this.f18372h;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 4);
        return this.f18373i;
    }

    public final void mo2872a(long j) {
        this.f18373i = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLCreativePagesYouMayLikeFeedUnitItem> m25790z() {
        this.f18374j = super.m9944a(this.f18374j, 5, GraphQLCreativePagesYouMayLikeFeedUnitItem.class);
        return (ImmutableList) this.f18374j;
    }

    @FieldOffset
    @Nullable
    public final String m25762A() {
        this.f18375k = super.m9948a(this.f18375k, 6);
        return this.f18375k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25763B() {
        this.f18376l = (GraphQLTextWithEntities) super.m9947a(this.f18376l, 7, GraphQLTextWithEntities.class);
        return this.f18376l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18377m = super.m9948a(this.f18377m, 8);
        return this.f18377m;
    }

    @FieldOffset
    @Nullable
    public final String m25764C() {
        this.f18378n = super.m9948a(this.f18378n, 9);
        return this.f18378n;
    }

    @FieldOffset
    @Nullable
    public final String m25765D() {
        this.f18379o = super.m9948a(this.f18379o, 10);
        return this.f18379o;
    }

    @FieldOffset
    public final int m25766E() {
        m9949a(1, 3);
        return this.f18380p;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25789y();
    }

    public final int jK_() {
        return 336198388;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        m9958h();
        if (m25788x() != null) {
            Builder a2 = ModelHelper.m23097a(m25788x(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLCreativePagesYouMayLikeFeedUnit.f18370f = a2.m1068b();
                graphQLVisitableModel = graphQLCreativePagesYouMayLikeFeedUnit;
                if (m25789y() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25789y());
                    if (m25789y() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18371g = graphQLTextWithEntities;
                    }
                }
                if (m25790z() != null) {
                    a = ModelHelper.m23097a(m25790z(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLCreativePagesYouMayLikeFeedUnit.f18374j = a.m1068b();
                        graphQLVisitableModel = graphQLCreativePagesYouMayLikeFeedUnit;
                    }
                }
                if (m25763B() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25763B());
                    if (m25763B() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18376l = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m25789y() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25789y());
            if (m25789y() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18371g = graphQLTextWithEntities;
            }
        }
        if (m25790z() != null) {
            a = ModelHelper.m23097a(m25790z(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLCreativePagesYouMayLikeFeedUnit.f18374j = a.m1068b();
                graphQLVisitableModel = graphQLCreativePagesYouMayLikeFeedUnit;
            }
        }
        if (m25763B() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25763B());
            if (m25763B() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18376l = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25764C();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 9;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25765D();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 10;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25766E());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 11;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18378n = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 9, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18379o = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 10, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18380p = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 11, intValue);
            }
        }
    }

    public GraphQLCreativePagesYouMayLikeFeedUnit() {
        super(13);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18373i = mutableFlatBuffer.m21525a(i, 4, 0);
        this.f18380p = mutableFlatBuffer.m21524a(i, 11, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25788x());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25789y());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m25790z());
        int b3 = flatBufferBuilder.m21502b(m25762A());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25763B());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        int b5 = flatBufferBuilder.m21502b(m25764C());
        int b6 = flatBufferBuilder.m21502b(m25765D());
        flatBufferBuilder.m21510c(12);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21495a(4, T_(), 0);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, b3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, b4);
        flatBufferBuilder.m21507b(9, b5);
        flatBufferBuilder.m21507b(10, b6);
        flatBufferBuilder.m21494a(11, m25766E(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLCreativePagesYouMayLikeFeedUnit(Parcel parcel) {
        super(13);
        this.f18369e = parcel.readString();
        this.f18370f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLCreativePagesYouMayLikeFeedUnitItem.class.getClassLoader()));
        this.f18371g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18372h = parcel.readString();
        this.f18373i = parcel.readLong();
        this.f18374j = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLCreativePagesYouMayLikeFeedUnitItem.class.getClassLoader()));
        this.f18378n = parcel.readString();
        this.f18379o = parcel.readString();
        this.f18380p = parcel.readInt();
        this.f18375k = parcel.readString();
        this.f18376l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18377m = parcel.readString();
        this.f18381q = (CreativePagesYouMayLikeFeedUnitExtra) ParcelUtil.b(parcel, CreativePagesYouMayLikeFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeList(m25788x());
        parcel.writeValue(m25789y());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m25790z());
        parcel.writeString(m25764C());
        parcel.writeString(m25765D());
        parcel.writeInt(m25766E());
        parcel.writeString(m25762A());
        parcel.writeValue(m25763B());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25761H(), i);
    }

    private CreativePagesYouMayLikeFeedUnitExtra m25761H() {
        if (this.f18381q == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18381q = new CreativePagesYouMayLikeFeedUnitExtra();
            } else {
                this.f18381q = (CreativePagesYouMayLikeFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, CreativePagesYouMayLikeFeedUnitExtra.class);
            }
        }
        return this.f18381q;
    }

    public final PropertyBag U_() {
        if (this.f18382r == null) {
            this.f18382r = new PropertyBag();
        }
        return this.f18382r;
    }
}
