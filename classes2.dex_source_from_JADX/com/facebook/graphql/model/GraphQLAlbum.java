package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: localsell_forsalegroupshome_story */
public final class GraphQLAlbum extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLAlbum> CREATOR = new 1();
    @Nullable
    String f16867A;
    @Nullable
    GraphQLMediaSetMediaConnection f16868B;
    @Nullable
    GraphQLPhoto f16869d;
    GraphQLPhotosAlbumAPIType f16870e;
    boolean f16871f;
    @Nullable
    GraphQLApplication f16872g;
    boolean f16873h;
    boolean f16874i;
    boolean f16875j;
    List<GraphQLActor> f16876k;
    long f16877l;
    @Nullable
    GraphQLPlace f16878m;
    @Nullable
    GraphQLFeedback f16879n;
    @Nullable
    String f16880o;
    @Nullable
    GraphQLPlace f16881p;
    @Nullable
    GraphQLMediaSetMediaConnection f16882q;
    @Nullable
    GraphQLProfile f16883r;
    @Nullable
    GraphQLTextWithEntities f16884s;
    long f16885t;
    @Deprecated
    @Nullable
    String f16886u;
    @Nullable
    GraphQLActor f16887v;
    @Nullable
    GraphQLMediaSetMediaConnection f16888w;
    @Nullable
    GraphQLPrivacyScope f16889x;
    @Nullable
    GraphQLTextWithEntities f16890y;
    @Nullable
    GraphQLTextWithEntities f16891z;

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m23831j() {
        this.f16869d = (GraphQLPhoto) super.m9947a(this.f16869d, 0, GraphQLPhoto.class);
        return this.f16869d;
    }

    @FieldOffset
    public final GraphQLPhotosAlbumAPIType m23832k() {
        this.f16870e = (GraphQLPhotosAlbumAPIType) super.m9945a(this.f16870e, 1, GraphQLPhotosAlbumAPIType.class, GraphQLPhotosAlbumAPIType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16870e;
    }

    @FieldOffset
    public final boolean m23833l() {
        m9949a(0, 2);
        return this.f16871f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m23834m() {
        this.f16872g = (GraphQLApplication) super.m9947a(this.f16872g, 3, GraphQLApplication.class);
        return this.f16872g;
    }

    @FieldOffset
    public final boolean m23835n() {
        m9949a(0, 4);
        return this.f16873h;
    }

    @FieldOffset
    public final boolean m23836o() {
        m9949a(0, 5);
        return this.f16874i;
    }

    @FieldOffset
    public final boolean m23837p() {
        m9949a(0, 6);
        return this.f16875j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m23838q() {
        this.f16876k = super.m9944a(this.f16876k, 7, GraphQLActor.class);
        return (ImmutableList) this.f16876k;
    }

    @FieldOffset
    public final long m23839r() {
        m9949a(1, 0);
        return this.f16877l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m23840s() {
        this.f16878m = (GraphQLPlace) super.m9947a(this.f16878m, 9, GraphQLPlace.class);
        return this.f16878m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m23841t() {
        this.f16879n = (GraphQLFeedback) super.m9947a(this.f16879n, 10, GraphQLFeedback.class);
        return this.f16879n;
    }

    @FieldOffset
    @Nullable
    public final String m23842u() {
        this.f16880o = super.m9948a(this.f16880o, 11);
        return this.f16880o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m23843v() {
        this.f16881p = (GraphQLPlace) super.m9947a(this.f16881p, 12, GraphQLPlace.class);
        return this.f16881p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSetMediaConnection m23844w() {
        this.f16882q = (GraphQLMediaSetMediaConnection) super.m9947a(this.f16882q, 13, GraphQLMediaSetMediaConnection.class);
        return this.f16882q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m23845x() {
        this.f16883r = (GraphQLProfile) super.m9947a(this.f16883r, 14, GraphQLProfile.class);
        return this.f16883r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23846y() {
        this.f16884s = (GraphQLTextWithEntities) super.m9947a(this.f16884s, 15, GraphQLTextWithEntities.class);
        return this.f16884s;
    }

    @FieldOffset
    public final long m23847z() {
        m9949a(2, 0);
        return this.f16885t;
    }

    @FieldOffset
    @Nullable
    public final String m23819A() {
        this.f16886u = super.m9948a(this.f16886u, 17);
        return this.f16886u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m23820B() {
        this.f16887v = (GraphQLActor) super.m9947a(this.f16887v, 18, GraphQLActor.class);
        return this.f16887v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSetMediaConnection m23821C() {
        this.f16888w = (GraphQLMediaSetMediaConnection) super.m9947a(this.f16888w, 19, GraphQLMediaSetMediaConnection.class);
        return this.f16888w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m23822D() {
        this.f16889x = (GraphQLPrivacyScope) super.m9947a(this.f16889x, 20, GraphQLPrivacyScope.class);
        return this.f16889x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23823E() {
        this.f16890y = (GraphQLTextWithEntities) super.m9947a(this.f16890y, 22, GraphQLTextWithEntities.class);
        return this.f16890y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23824F() {
        this.f16891z = (GraphQLTextWithEntities) super.m9947a(this.f16891z, 23, GraphQLTextWithEntities.class);
        return this.f16891z;
    }

    @FieldOffset
    @Nullable
    public final String m23825G() {
        this.f16867A = super.m9948a(this.f16867A, 24);
        return this.f16867A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSetMediaConnection m23826H() {
        this.f16868B = (GraphQLMediaSetMediaConnection) super.m9947a(this.f16868B, 25, GraphQLMediaSetMediaConnection.class);
        return this.f16868B;
    }

    @Nullable
    public final String mo2834a() {
        return m23842u();
    }

    public final int jK_() {
        return 63344207;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPlace graphQLPlace;
        GraphQLMediaSetMediaConnection graphQLMediaSetMediaConnection;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23831j() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m23831j());
            if (m23831j() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16869d = graphQLPhoto;
            }
        }
        if (m23834m() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m23834m());
            if (m23834m() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16872g = graphQLApplication;
            }
        }
        if (m23838q() != null) {
            Builder a = ModelHelper.m23097a(m23838q(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLAlbum graphQLAlbum = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLAlbum.f16876k = a.m1068b();
                graphQLVisitableModel = graphQLAlbum;
            }
        }
        if (m23840s() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m23840s());
            if (m23840s() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16878m = graphQLPlace;
            }
        }
        if (m23841t() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m23841t());
            if (m23841t() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16879n = graphQLFeedback;
            }
        }
        if (m23843v() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m23843v());
            if (m23843v() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16881p = graphQLPlace;
            }
        }
        if (m23844w() != null) {
            graphQLMediaSetMediaConnection = (GraphQLMediaSetMediaConnection) graphQLModelMutatingVisitor.mo2928b(m23844w());
            if (m23844w() != graphQLMediaSetMediaConnection) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16882q = graphQLMediaSetMediaConnection;
            }
        }
        if (m23826H() != null) {
            graphQLMediaSetMediaConnection = (GraphQLMediaSetMediaConnection) graphQLModelMutatingVisitor.mo2928b(m23826H());
            if (m23826H() != graphQLMediaSetMediaConnection) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16868B = graphQLMediaSetMediaConnection;
            }
        }
        if (m23845x() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(m23845x());
            if (m23845x() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16883r = graphQLProfile;
            }
        }
        if (m23846y() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23846y());
            if (m23846y() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16884s = graphQLTextWithEntities;
            }
        }
        if (m23820B() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m23820B());
            if (m23820B() != graphQLActor) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16887v = graphQLActor;
            }
        }
        if (m23821C() != null) {
            graphQLMediaSetMediaConnection = (GraphQLMediaSetMediaConnection) graphQLModelMutatingVisitor.mo2928b(m23821C());
            if (m23821C() != graphQLMediaSetMediaConnection) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16888w = graphQLMediaSetMediaConnection;
            }
        }
        if (m23822D() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m23822D());
            if (m23822D() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16889x = graphQLPrivacyScope;
            }
        }
        if (m23823E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23823E());
            if (m23823E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16890y = graphQLTextWithEntities;
            }
        }
        if (m23824F() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23824F());
            if (m23824F() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAlbum) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16891z = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAlbum() {
        super(27);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16871f = mutableFlatBuffer.m21540a(i, 2);
        this.f16873h = mutableFlatBuffer.m21540a(i, 4);
        this.f16874i = mutableFlatBuffer.m21540a(i, 5);
        this.f16875j = mutableFlatBuffer.m21540a(i, 6);
        this.f16877l = mutableFlatBuffer.m21525a(i, 8, 0);
        this.f16885t = mutableFlatBuffer.m21525a(i, 16, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23831j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23834m());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m23838q());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23840s());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23841t());
        int b = flatBufferBuilder.m21502b(m23842u());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23843v());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23844w());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23845x());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m23846y());
        int b2 = flatBufferBuilder.m21502b(m23819A());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m23820B());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m23821C());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m23822D());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m23823E());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m23824F());
        int b3 = flatBufferBuilder.m21502b(m23825G());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m23826H());
        flatBufferBuilder.m21510c(26);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21496a(1, m23832k() == GraphQLPhotosAlbumAPIType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23832k());
        flatBufferBuilder.m21498a(2, m23833l());
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21498a(4, m23835n());
        flatBufferBuilder.m21498a(5, m23836o());
        flatBufferBuilder.m21498a(6, m23837p());
        flatBufferBuilder.m21507b(7, a3);
        flatBufferBuilder.m21495a(8, m23839r(), 0);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, a5);
        flatBufferBuilder.m21507b(11, b);
        flatBufferBuilder.m21507b(12, a6);
        flatBufferBuilder.m21507b(13, a7);
        flatBufferBuilder.m21507b(14, a8);
        flatBufferBuilder.m21507b(15, a9);
        flatBufferBuilder.m21495a(16, m23847z(), 0);
        flatBufferBuilder.m21507b(17, b2);
        flatBufferBuilder.m21507b(18, a10);
        flatBufferBuilder.m21507b(19, a11);
        flatBufferBuilder.m21507b(20, a12);
        flatBufferBuilder.m21507b(22, a13);
        flatBufferBuilder.m21507b(23, a14);
        flatBufferBuilder.m21507b(24, b3);
        flatBufferBuilder.m21507b(25, a15);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAlbum(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(27);
        this.f16869d = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f16870e = GraphQLPhotosAlbumAPIType.fromString(parcel.readString());
        this.f16871f = parcel.readByte() == (byte) 1;
        this.f16872g = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16873h = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16874i = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f16875j = z2;
        this.f16876k = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f16877l = parcel.readLong();
        this.f16878m = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f16879n = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f16880o = parcel.readString();
        this.f16881p = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f16882q = (GraphQLMediaSetMediaConnection) parcel.readValue(GraphQLMediaSetMediaConnection.class.getClassLoader());
        this.f16868B = (GraphQLMediaSetMediaConnection) parcel.readValue(GraphQLMediaSetMediaConnection.class.getClassLoader());
        this.f16883r = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f16884s = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16885t = parcel.readLong();
        this.f16886u = parcel.readString();
        this.f16887v = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f16888w = (GraphQLMediaSetMediaConnection) parcel.readValue(GraphQLMediaSetMediaConnection.class.getClassLoader());
        this.f16889x = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f16890y = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16891z = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16867A = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m23831j());
        parcel.writeString(m23832k().name());
        parcel.writeByte((byte) (m23833l() ? 1 : 0));
        parcel.writeValue(m23834m());
        if (m23835n()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23836o()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m23837p()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeList(m23838q());
        parcel.writeLong(m23839r());
        parcel.writeValue(m23840s());
        parcel.writeValue(m23841t());
        parcel.writeString(m23842u());
        parcel.writeValue(m23843v());
        parcel.writeValue(m23844w());
        parcel.writeValue(m23826H());
        parcel.writeValue(m23845x());
        parcel.writeValue(m23846y());
        parcel.writeLong(m23847z());
        parcel.writeString(m23819A());
        parcel.writeValue(m23820B());
        parcel.writeValue(m23821C());
        parcel.writeValue(m23822D());
        parcel.writeValue(m23823E());
        parcel.writeValue(m23824F());
        parcel.writeString(m23825G());
    }

    public GraphQLAlbum(Builder builder) {
        super(27);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16869d = builder.d;
        this.f16870e = builder.e;
        this.f16871f = builder.f;
        this.f16872g = builder.g;
        this.f16873h = builder.h;
        this.f16874i = builder.i;
        this.f16875j = builder.j;
        this.f16876k = builder.k;
        this.f16877l = builder.l;
        this.f16878m = builder.m;
        this.f16879n = builder.n;
        this.f16880o = builder.o;
        this.f16881p = builder.p;
        this.f16882q = builder.q;
        this.f16868B = builder.r;
        this.f16883r = builder.s;
        this.f16884s = builder.t;
        this.f16885t = builder.u;
        this.f16886u = builder.v;
        this.f16887v = builder.w;
        this.f16888w = builder.x;
        this.f16889x = builder.y;
        this.f16890y = builder.z;
        this.f16891z = builder.A;
        this.f16867A = builder.B;
    }
}
