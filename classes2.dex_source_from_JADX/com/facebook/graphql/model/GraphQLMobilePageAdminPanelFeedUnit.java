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
/* compiled from: last operation  */
public final class GraphQLMobilePageAdminPanelFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLMobilePageAdminPanelFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18192d = new GraphQLObjectType(-1528092760);
    @Nullable
    public String f18193e;
    @Nullable
    public String f18194f;
    public long f18195g;
    @Nullable
    public String f18196h;
    public List<GraphQLMobilePageAdminPanelFeedUnitItem> f18197i;
    @Nullable
    public GraphQLNegativeFeedbackActionsConnection f18198j;
    @Nullable
    public String f18199k;
    @Nullable
    public GraphQLTextWithEntities f18200l;
    @Nullable
    public String f18201m;
    private MobilePageAdminPanelFeedUnitExtra f18202n;
    @Nullable
    private PropertyBag f18203o = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25524u();
    }

    public final /* synthetic */ List mo2882v() {
        return m25534l();
    }

    public final List mo2883w() {
        return m25537p();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18192d;
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

    public final ImmutableList m25534l() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18193e = super.m9948a(this.f18193e, 0);
        return this.f18193e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18194f = super.m9948a(this.f18194f, 1);
        return this.f18194f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18195g;
    }

    public final void mo2872a(long j) {
        this.f18195g = j;
    }

    @FieldOffset
    @Nullable
    public final String m25536o() {
        this.f18196h = super.m9948a(this.f18196h, 3);
        return this.f18196h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLMobilePageAdminPanelFeedUnitItem> m25537p() {
        this.f18197i = super.m9944a(this.f18197i, 4, GraphQLMobilePageAdminPanelFeedUnitItem.class);
        return (ImmutableList) this.f18197i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m25538q() {
        this.f18198j = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18198j, 5, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18198j;
    }

    @FieldOffset
    @Nullable
    public final String m25539r() {
        this.f18199k = super.m9948a(this.f18199k, 6);
        return this.f18199k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25540s() {
        this.f18200l = (GraphQLTextWithEntities) super.m9947a(this.f18200l, 7, GraphQLTextWithEntities.class);
        return this.f18200l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18201m = super.m9948a(this.f18201m, 8);
        return this.f18201m;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -1528092760;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection;
        GraphQLTextWithEntities graphQLTextWithEntities;
        m9958h();
        if (m25537p() != null) {
            Builder a = ModelHelper.m23097a(m25537p(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit = (GraphQLMobilePageAdminPanelFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLMobilePageAdminPanelFeedUnit.f18197i = a.m1068b();
                graphQLVisitableModel = graphQLMobilePageAdminPanelFeedUnit;
                if (m25538q() != null) {
                    graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m25538q());
                    if (m25538q() != graphQLNegativeFeedbackActionsConnection) {
                        graphQLVisitableModel = (GraphQLMobilePageAdminPanelFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18198j = graphQLNegativeFeedbackActionsConnection;
                    }
                }
                if (m25540s() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25540s());
                    if (m25540s() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLMobilePageAdminPanelFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f18200l = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m25538q() != null) {
            graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m25538q());
            if (m25538q() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLMobilePageAdminPanelFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18198j = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m25540s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25540s());
            if (m25540s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLMobilePageAdminPanelFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18200l = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLMobilePageAdminPanelFeedUnit() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18195g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25536o());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25537p());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25538q());
        int b4 = flatBufferBuilder.m21502b(m25539r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25540s());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, a);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, a3);
        flatBufferBuilder.m21507b(8, b5);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLMobilePageAdminPanelFeedUnit(Parcel parcel) {
        super(10);
        this.f18193e = parcel.readString();
        this.f18194f = parcel.readString();
        this.f18195g = parcel.readLong();
        this.f18196h = parcel.readString();
        this.f18197i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLMobilePageAdminPanelFeedUnitItem.class.getClassLoader()));
        this.f18198j = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18199k = parcel.readString();
        this.f18200l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18201m = parcel.readString();
        this.f18202n = (MobilePageAdminPanelFeedUnitExtra) ParcelUtil.b(parcel, MobilePageAdminPanelFeedUnitExtra.class);
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25540s();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25536o());
        parcel.writeList(m25537p());
        parcel.writeValue(m25538q());
        parcel.writeString(m25539r());
        parcel.writeValue(m25540s());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25524u(), i);
    }

    private MobilePageAdminPanelFeedUnitExtra m25524u() {
        if (this.f18202n == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18202n = new MobilePageAdminPanelFeedUnitExtra();
            } else {
                this.f18202n = (MobilePageAdminPanelFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, MobilePageAdminPanelFeedUnitExtra.class);
            }
        }
        return this.f18202n;
    }

    public final PropertyBag U_() {
        if (this.f18203o == null) {
            this.f18203o = new PropertyBag();
        }
        return this.f18203o;
    }
}
