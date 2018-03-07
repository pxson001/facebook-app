package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: locale */
public final class GraphQLAppStoreApplication extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAppStoreApplication> CREATOR = new 1();
    @Nullable
    public String f16965d;
    @Nullable
    public String f16966e;
    @Nullable
    public String f16967f;
    public List<GraphQLImage> f16968g;
    @Nullable
    public GraphQLTextWithEntities f16969h;
    public GraphQLAppStoreDownloadConnectivityPolicy f16970i;
    @Nullable
    public String f16971j;
    @Nullable
    public String f16972k;
    public GraphQLAppStoreApplicationInstallState f16973l;
    @Nullable
    public GraphQLTextWithEntities f16974m;
    public List<String> f16975n;
    public List<GraphQLImage> f16976o;
    @Nullable
    public GraphQLApplication f16977p;
    @Nullable
    public String f16978q;
    public List<GraphQLDigitalGoodStoreType> f16979r;
    @Nullable
    public GraphQLTextWithEntities f16980s;
    public int f16981t;
    @Nullable
    public String f16982u;

    @FieldOffset
    @Nullable
    public final String m23945a() {
        this.f16965d = super.m9948a(this.f16965d, 0);
        return this.f16965d;
    }

    @FieldOffset
    @Nullable
    public final String m23947j() {
        this.f16966e = super.m9948a(this.f16966e, 1);
        return this.f16966e;
    }

    @FieldOffset
    @Nullable
    public final String m23948k() {
        this.f16967f = super.m9948a(this.f16967f, 2);
        return this.f16967f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImage> m23949l() {
        this.f16968g = super.m9944a(this.f16968g, 3, GraphQLImage.class);
        return (ImmutableList) this.f16968g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23950m() {
        this.f16969h = (GraphQLTextWithEntities) super.m9947a(this.f16969h, 4, GraphQLTextWithEntities.class);
        return this.f16969h;
    }

    @FieldOffset
    public final GraphQLAppStoreDownloadConnectivityPolicy m23951n() {
        this.f16970i = (GraphQLAppStoreDownloadConnectivityPolicy) super.m9945a(this.f16970i, 5, GraphQLAppStoreDownloadConnectivityPolicy.class, GraphQLAppStoreDownloadConnectivityPolicy.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16970i;
    }

    @FieldOffset
    @Nullable
    public final String m23952o() {
        this.f16971j = super.m9948a(this.f16971j, 6);
        return this.f16971j;
    }

    @FieldOffset
    @Nullable
    public final String m23953p() {
        this.f16972k = super.m9948a(this.f16972k, 7);
        return this.f16972k;
    }

    @FieldOffset
    public final GraphQLAppStoreApplicationInstallState m23954q() {
        this.f16973l = (GraphQLAppStoreApplicationInstallState) super.m9945a(this.f16973l, 8, GraphQLAppStoreApplicationInstallState.class, GraphQLAppStoreApplicationInstallState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16973l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23955r() {
        this.f16974m = (GraphQLTextWithEntities) super.m9947a(this.f16974m, 9, GraphQLTextWithEntities.class);
        return this.f16974m;
    }

    @FieldOffset
    public final ImmutableList<String> m23956s() {
        this.f16975n = super.m9943a(this.f16975n, 10);
        return (ImmutableList) this.f16975n;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImage> m23957t() {
        this.f16976o = super.m9944a(this.f16976o, 11, GraphQLImage.class);
        return (ImmutableList) this.f16976o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m23958u() {
        this.f16977p = (GraphQLApplication) super.m9947a(this.f16977p, 12, GraphQLApplication.class);
        return this.f16977p;
    }

    @FieldOffset
    @Nullable
    public final String m23959v() {
        this.f16978q = super.m9948a(this.f16978q, 13);
        return this.f16978q;
    }

    @FieldOffset
    public final ImmutableList<GraphQLDigitalGoodStoreType> m23960w() {
        this.f16979r = super.m9953b(this.f16979r, 14, GraphQLDigitalGoodStoreType.class);
        return (ImmutableList) this.f16979r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23961x() {
        this.f16980s = (GraphQLTextWithEntities) super.m9947a(this.f16980s, 15, GraphQLTextWithEntities.class);
        return this.f16980s;
    }

    @FieldOffset
    public final int m23962y() {
        m9949a(2, 0);
        return this.f16981t;
    }

    @FieldOffset
    @Nullable
    public final String m23963z() {
        this.f16982u = super.m9948a(this.f16982u, 17);
        return this.f16982u;
    }

    public final int jK_() {
        return 1254437328;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLAppStoreApplication graphQLAppStoreApplication;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        GraphQLApplication graphQLApplication;
        m9958h();
        if (m23949l() != null) {
            Builder a2 = ModelHelper.m23097a(m23949l(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLAppStoreApplication = (GraphQLAppStoreApplication) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLAppStoreApplication.f16968g = a2.m1068b();
                graphQLVisitableModel = graphQLAppStoreApplication;
                if (m23950m() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23950m());
                    if (m23950m() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16969h = graphQLTextWithEntities;
                    }
                }
                if (m23955r() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23955r());
                    if (m23955r() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16974m = graphQLTextWithEntities;
                    }
                }
                if (m23957t() != null) {
                    a = ModelHelper.m23097a(m23957t(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLAppStoreApplication = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLAppStoreApplication.f16976o = a.m1068b();
                        graphQLVisitableModel = graphQLAppStoreApplication;
                    }
                }
                if (m23958u() != null) {
                    graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m23958u());
                    if (m23958u() != graphQLApplication) {
                        graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16977p = graphQLApplication;
                    }
                }
                if (m23961x() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23961x());
                    if (m23961x() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16980s = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23950m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23950m());
            if (m23950m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16969h = graphQLTextWithEntities;
            }
        }
        if (m23955r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23955r());
            if (m23955r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16974m = graphQLTextWithEntities;
            }
        }
        if (m23957t() != null) {
            a = ModelHelper.m23097a(m23957t(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLAppStoreApplication = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLAppStoreApplication.f16976o = a.m1068b();
                graphQLVisitableModel = graphQLAppStoreApplication;
            }
        }
        if (m23958u() != null) {
            graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m23958u());
            if (m23958u() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16977p = graphQLApplication;
            }
        }
        if (m23961x() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23961x());
            if (m23961x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAppStoreApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16980s = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLAppStoreApplication() {
        super(19);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16981t = mutableFlatBuffer.m21524a(i, 16, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23945a());
        int b2 = flatBufferBuilder.m21502b(m23947j());
        int b3 = flatBufferBuilder.m21502b(m23948k());
        int a = ModelHelper.m23094a(flatBufferBuilder, m23949l());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23950m());
        int b4 = flatBufferBuilder.m21502b(m23952o());
        int b5 = flatBufferBuilder.m21502b(m23953p());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23955r());
        int c = flatBufferBuilder.m21509c(m23956s());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m23957t());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23958u());
        int b6 = flatBufferBuilder.m21502b(m23959v());
        int e = flatBufferBuilder.m21514e(m23960w());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23961x());
        int b7 = flatBufferBuilder.m21502b(m23963z());
        flatBufferBuilder.m21510c(18);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21496a(5, m23951n() == GraphQLAppStoreDownloadConnectivityPolicy.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23951n());
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, b5);
        flatBufferBuilder.m21496a(8, m23954q() == GraphQLAppStoreApplicationInstallState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23954q());
        flatBufferBuilder.m21507b(9, a3);
        flatBufferBuilder.m21507b(10, c);
        flatBufferBuilder.m21507b(11, a4);
        flatBufferBuilder.m21507b(12, a5);
        flatBufferBuilder.m21507b(13, b6);
        flatBufferBuilder.m21507b(14, e);
        flatBufferBuilder.m21507b(15, a6);
        flatBufferBuilder.m21494a(16, m23962y(), 0);
        flatBufferBuilder.m21507b(17, b7);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAppStoreApplication(Parcel parcel) {
        super(19);
        this.f16965d = parcel.readString();
        this.f16966e = parcel.readString();
        this.f16967f = parcel.readString();
        this.f16968g = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLImage.class.getClassLoader()));
        this.f16969h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16970i = GraphQLAppStoreDownloadConnectivityPolicy.fromString(parcel.readString());
        this.f16971j = parcel.readString();
        this.f16972k = parcel.readString();
        this.f16973l = GraphQLAppStoreApplicationInstallState.fromString(parcel.readString());
        this.f16974m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16975n = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16976o = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLImage.class.getClassLoader()));
        this.f16977p = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f16978q = parcel.readString();
        this.f16979r = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLDigitalGoodStoreType.class.getClassLoader()));
        this.f16980s = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16981t = parcel.readInt();
        this.f16982u = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m23945a());
        parcel.writeString(m23947j());
        parcel.writeString(m23948k());
        parcel.writeList(m23949l());
        parcel.writeValue(m23950m());
        parcel.writeString(m23951n().name());
        parcel.writeString(m23952o());
        parcel.writeString(m23953p());
        parcel.writeString(m23954q().name());
        parcel.writeValue(m23955r());
        parcel.writeList(m23956s());
        parcel.writeList(m23957t());
        parcel.writeValue(m23958u());
        parcel.writeString(m23959v());
        parcel.writeList(m23960w());
        parcel.writeValue(m23961x());
        parcel.writeInt(m23962y());
        parcel.writeString(m23963z());
    }
}
