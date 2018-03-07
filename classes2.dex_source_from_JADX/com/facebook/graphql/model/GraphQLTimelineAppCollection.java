package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces$NewItemDefaultPrivacy;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces$SavableTimelineAppCollection;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: login_approvals_secret/ */
public final class GraphQLTimelineAppCollection extends BaseModel implements SaveDefaultsGraphQLInterfaces$SavableTimelineAppCollection, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineAppCollection> CREATOR = new 1();
    @Nullable
    GraphQLTimelineAppCollectionMembershipStateInfo f16019d;
    @Nullable
    GraphQLTimelineAppCollectionMembershipStateInfo f16020e;
    @Nullable
    GraphQLTimelineAppSection f16021f;
    @Nullable
    GraphQLApplication f16022g;
    @Nullable
    String f16023h;
    @Nullable
    String f16024i;
    @Nullable
    String f16025j;
    @Nullable
    GraphQLMediaSet f16026k;
    @Nullable
    String f16027l;
    @Nullable
    GraphQLPrivacyOption f16028m;
    @Nullable
    GraphQLTextWithEntities f16029n;
    @Nullable
    GraphQLTimelineAppCollectionMembershipStateInfo f16030o;
    @Nullable
    GraphQLSavedDashboardSection f16031p;
    List<GraphQLTimelineAppCollectionStyle> f16032q;
    boolean f16033r;
    @Nullable
    String f16034s;
    @Nullable
    String f16035t;
    @Nullable
    String f16036u;

    @FieldOffset
    @Nullable
    public final /* synthetic */ SaveDefaultsGraphQLInterfaces$NewItemDefaultPrivacy mo2917d() {
        return m22853q();
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollectionMembershipStateInfo m22846j() {
        this.f16019d = (GraphQLTimelineAppCollectionMembershipStateInfo) super.m9947a(this.f16019d, 0, GraphQLTimelineAppCollectionMembershipStateInfo.class);
        return this.f16019d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollectionMembershipStateInfo m22847k() {
        this.f16020e = (GraphQLTimelineAppCollectionMembershipStateInfo) super.m9947a(this.f16020e, 1, GraphQLTimelineAppCollectionMembershipStateInfo.class);
        return this.f16020e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppSection m22848l() {
        this.f16021f = (GraphQLTimelineAppSection) super.m9947a(this.f16021f, 2, GraphQLTimelineAppSection.class);
        return this.f16021f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m22849m() {
        this.f16022g = (GraphQLApplication) super.m9947a(this.f16022g, 3, GraphQLApplication.class);
        return this.f16022g;
    }

    @FieldOffset
    @Nullable
    public final String m22850n() {
        this.f16023h = super.m9948a(this.f16023h, 4);
        return this.f16023h;
    }

    @FieldOffset
    @Nullable
    public final String m22851o() {
        this.f16024i = super.m9948a(this.f16024i, 5);
        return this.f16024i;
    }

    @FieldOffset
    @Nullable
    public final String mo2915b() {
        this.f16025j = super.m9948a(this.f16025j, 7);
        return this.f16025j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSet m22852p() {
        this.f16026k = (GraphQLMediaSet) super.m9947a(this.f16026k, 8, GraphQLMediaSet.class);
        return this.f16026k;
    }

    @FieldOffset
    @Nullable
    public final String mo2916c() {
        this.f16027l = super.m9948a(this.f16027l, 9);
        return this.f16027l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOption m22853q() {
        this.f16028m = (GraphQLPrivacyOption) super.m9947a(this.f16028m, 10, GraphQLPrivacyOption.class);
        return this.f16028m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22854r() {
        this.f16029n = (GraphQLTextWithEntities) super.m9947a(this.f16029n, 11, GraphQLTextWithEntities.class);
        return this.f16029n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollectionMembershipStateInfo m22855s() {
        this.f16030o = (GraphQLTimelineAppCollectionMembershipStateInfo) super.m9947a(this.f16030o, 12, GraphQLTimelineAppCollectionMembershipStateInfo.class);
        return this.f16030o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSavedDashboardSection m22856t() {
        this.f16031p = (GraphQLSavedDashboardSection) super.m9947a(this.f16031p, 14, GraphQLSavedDashboardSection.class);
        return this.f16031p;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollectionStyle> m22857u() {
        this.f16032q = super.m9953b(this.f16032q, 15, GraphQLTimelineAppCollectionStyle.class);
        return (ImmutableList) this.f16032q;
    }

    @FieldOffset
    public final boolean m22858v() {
        m9949a(2, 0);
        return this.f16033r;
    }

    @FieldOffset
    @Nullable
    public final String m22859w() {
        this.f16034s = super.m9948a(this.f16034s, 17);
        return this.f16034s;
    }

    @FieldOffset
    @Nullable
    public final String m22860x() {
        this.f16035t = super.m9948a(this.f16035t, 18);
        return this.f16035t;
    }

    @FieldOffset
    @Nullable
    public final String m22861y() {
        this.f16036u = super.m9948a(this.f16036u, 19);
        return this.f16036u;
    }

    @Nullable
    public final String mo2834a() {
        return mo2915b();
    }

    public final int jK_() {
        return -1476137794;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTimelineAppCollectionMembershipStateInfo graphQLTimelineAppCollectionMembershipStateInfo;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22846j() != null) {
            graphQLTimelineAppCollectionMembershipStateInfo = (GraphQLTimelineAppCollectionMembershipStateInfo) graphQLModelMutatingVisitor.mo2928b(m22846j());
            if (m22846j() != graphQLTimelineAppCollectionMembershipStateInfo) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16019d = graphQLTimelineAppCollectionMembershipStateInfo;
            }
        }
        if (m22847k() != null) {
            graphQLTimelineAppCollectionMembershipStateInfo = (GraphQLTimelineAppCollectionMembershipStateInfo) graphQLModelMutatingVisitor.mo2928b(m22847k());
            if (m22847k() != graphQLTimelineAppCollectionMembershipStateInfo) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16020e = graphQLTimelineAppCollectionMembershipStateInfo;
            }
        }
        if (m22848l() != null) {
            GraphQLTimelineAppSection graphQLTimelineAppSection = (GraphQLTimelineAppSection) graphQLModelMutatingVisitor.mo2928b(m22848l());
            if (m22848l() != graphQLTimelineAppSection) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16021f = graphQLTimelineAppSection;
            }
        }
        if (m22849m() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m22849m());
            if (m22849m() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16022g = graphQLApplication;
            }
        }
        if (m22852p() != null) {
            GraphQLMediaSet graphQLMediaSet = (GraphQLMediaSet) graphQLModelMutatingVisitor.mo2928b(m22852p());
            if (m22852p() != graphQLMediaSet) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16026k = graphQLMediaSet;
            }
        }
        if (m22853q() != null) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.mo2928b(m22853q());
            if (m22853q() != graphQLPrivacyOption) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16028m = graphQLPrivacyOption;
            }
        }
        if (m22854r() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22854r());
            if (m22854r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16029n = graphQLTextWithEntities;
            }
        }
        if (m22855s() != null) {
            graphQLTimelineAppCollectionMembershipStateInfo = (GraphQLTimelineAppCollectionMembershipStateInfo) graphQLModelMutatingVisitor.mo2928b(m22855s());
            if (m22855s() != graphQLTimelineAppCollectionMembershipStateInfo) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16030o = graphQLTimelineAppCollectionMembershipStateInfo;
            }
        }
        if (m22856t() != null) {
            GraphQLSavedDashboardSection graphQLSavedDashboardSection = (GraphQLSavedDashboardSection) graphQLModelMutatingVisitor.mo2928b(m22856t());
            if (m22856t() != graphQLSavedDashboardSection) {
                graphQLVisitableModel = (GraphQLTimelineAppCollection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16031p = graphQLSavedDashboardSection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTimelineAppCollection() {
        super(21);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16033r = mutableFlatBuffer.m21540a(i, 16);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m22846j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22847k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m22848l());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m22849m());
        int b = flatBufferBuilder.m21502b(m22850n());
        int b2 = flatBufferBuilder.m21502b(m22851o());
        int b3 = flatBufferBuilder.m21502b(mo2915b());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m22852p());
        int b4 = flatBufferBuilder.m21502b(mo2916c());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m22853q());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m22854r());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m22855s());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m22856t());
        int e = flatBufferBuilder.m21514e(m22857u());
        int b5 = flatBufferBuilder.m21502b(m22859w());
        int b6 = flatBufferBuilder.m21502b(m22860x());
        int b7 = flatBufferBuilder.m21502b(m22861y());
        flatBufferBuilder.m21510c(20);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(7, b3);
        flatBufferBuilder.m21507b(8, a5);
        flatBufferBuilder.m21507b(9, b4);
        flatBufferBuilder.m21507b(10, a6);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21507b(14, a9);
        flatBufferBuilder.m21507b(15, e);
        flatBufferBuilder.m21498a(16, m22858v());
        flatBufferBuilder.m21507b(17, b5);
        flatBufferBuilder.m21507b(18, b6);
        flatBufferBuilder.m21507b(19, b7);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTimelineAppCollection(Parcel parcel) {
        super(21);
        this.f16019d = (GraphQLTimelineAppCollectionMembershipStateInfo) parcel.readValue(GraphQLTimelineAppCollectionMembershipStateInfo.class.getClassLoader());
        this.f16020e = (GraphQLTimelineAppCollectionMembershipStateInfo) parcel.readValue(GraphQLTimelineAppCollectionMembershipStateInfo.class.getClassLoader());
        this.f16021f = (GraphQLTimelineAppSection) parcel.readValue(GraphQLTimelineAppSection.class.getClassLoader());
        this.f16022g = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f16023h = parcel.readString();
        this.f16024i = parcel.readString();
        this.f16025j = parcel.readString();
        this.f16026k = (GraphQLMediaSet) parcel.readValue(GraphQLMediaSet.class.getClassLoader());
        this.f16027l = parcel.readString();
        this.f16028m = (GraphQLPrivacyOption) parcel.readValue(GraphQLPrivacyOption.class.getClassLoader());
        this.f16029n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16030o = (GraphQLTimelineAppCollectionMembershipStateInfo) parcel.readValue(GraphQLTimelineAppCollectionMembershipStateInfo.class.getClassLoader());
        this.f16031p = (GraphQLSavedDashboardSection) parcel.readValue(GraphQLSavedDashboardSection.class.getClassLoader());
        this.f16032q = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineAppCollectionStyle.class.getClassLoader()));
        this.f16033r = parcel.readByte() == (byte) 1;
        this.f16034s = parcel.readString();
        this.f16035t = parcel.readString();
        this.f16036u = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22846j());
        parcel.writeValue(m22847k());
        parcel.writeValue(m22848l());
        parcel.writeValue(m22849m());
        parcel.writeString(m22850n());
        parcel.writeString(m22851o());
        parcel.writeString(mo2915b());
        parcel.writeValue(m22852p());
        parcel.writeString(mo2916c());
        parcel.writeValue(m22853q());
        parcel.writeValue(m22854r());
        parcel.writeValue(m22855s());
        parcel.writeValue(m22856t());
        parcel.writeList(m22857u());
        parcel.writeByte((byte) (m22858v() ? 1 : 0));
        parcel.writeString(m22859w());
        parcel.writeString(m22860x());
        parcel.writeString(m22861y());
    }

    public GraphQLTimelineAppCollection(Builder builder) {
        super(21);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16019d = builder.d;
        this.f16020e = builder.e;
        this.f16021f = builder.f;
        this.f16022g = builder.g;
        this.f16023h = builder.h;
        this.f16024i = builder.i;
        this.f16025j = builder.j;
        this.f16026k = builder.k;
        this.f16027l = builder.l;
        this.f16028m = builder.m;
        this.f16029n = builder.n;
        this.f16030o = builder.o;
        this.f16031p = builder.p;
        this.f16032q = builder.q;
        this.f16033r = builder.r;
        this.f16034s = builder.s;
        this.f16035t = builder.t;
        this.f16036u = builder.u;
    }
}
