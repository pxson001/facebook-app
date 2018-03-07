package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.querybuilder.common.C0676xf1a7a49c;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: m.facebook.com */
public final class GraphQLEntity extends BaseModel implements TypeModel, C0676xf1a7a49c, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLEntity> CREATOR = new C06771();
    @Nullable
    public String f15816A;
    @Nullable
    public String f15817B;
    @Nullable
    public String f15818C;
    @Nullable
    public GraphQLImage f15819D;
    @Nullable
    public GraphQLImage f15820E;
    @Nullable
    public String f15821F;
    public List<GraphQLRedirectionInfo> f15822G;
    @Nullable
    public GraphQLEntity f15823H;
    public double f15824I;
    public double f15825J;
    @Nullable
    public String f15826K;
    @Nullable
    public String f15827L;
    public int f15828M;
    public GraphQLSubscribeStatus f15829N;
    @Nullable
    public String f15830O;
    @Nullable
    public String f15831P;
    @Nullable
    public GraphQLImage f15832Q;
    public int f15833R;
    @Nullable
    public String f15834S;
    @Nullable
    public GraphQLObjectType f15835d;
    public List<String> f15836e;
    @Nullable
    public GraphQLTimelineAppSection f15837f;
    @Nullable
    public GraphQLAppStoreApplication f15838g;
    @Nullable
    public String f15839h;
    @Nullable
    public String f15840i;
    @Nullable
    public String f15841j;
    @Nullable
    public String f15842k;
    public GraphQLFriendshipStatus f15843l;
    public int f15844m;
    @Nullable
    public String f15845n;
    @Nullable
    public GraphQLImage f15846o;
    public int f15847p;
    public int f15848q;
    public int f15849r;
    @Nullable
    public GraphQLImage f15850s;
    public boolean f15851t;
    @Deprecated
    @Nullable
    public GraphQLTextWithEntities f15852u;
    @Nullable
    public String f15853v;
    @Nullable
    public GraphQLPage f15854w;
    public int f15855x;
    @Nullable
    public String f15856y;
    @Nullable
    public String f15857z;

    /* compiled from: m.facebook.com */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f15774A;
        @Nullable
        public String f15775B;
        @Nullable
        public GraphQLImage f15776C;
        @Nullable
        public GraphQLImage f15777D;
        @Nullable
        public String f15778E;
        public ImmutableList<GraphQLRedirectionInfo> f15779F;
        @Nullable
        public GraphQLEntity f15780G;
        public double f15781H;
        public double f15782I;
        @Nullable
        public String f15783J;
        @Nullable
        public String f15784K;
        @Nullable
        public String f15785L;
        public int f15786M;
        public GraphQLSubscribeStatus f15787N = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        @Nullable
        public String f15788O;
        @Nullable
        public String f15789P;
        @Nullable
        public GraphQLImage f15790Q;
        public int f15791R;
        @Nullable
        public GraphQLObjectType f15792S = null;
        public ImmutableList<String> f15793d;
        @Nullable
        public GraphQLTimelineAppSection f15794e;
        @Nullable
        public GraphQLAppStoreApplication f15795f;
        @Nullable
        public String f15796g;
        @Nullable
        public String f15797h;
        @Nullable
        public String f15798i;
        @Nullable
        public String f15799j;
        public GraphQLFriendshipStatus f15800k = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        public int f15801l;
        @Nullable
        public String f15802m;
        @Nullable
        public GraphQLImage f15803n;
        public int f15804o;
        public int f15805p;
        public int f15806q;
        @Nullable
        public GraphQLImage f15807r;
        public boolean f15808s;
        @Nullable
        public GraphQLTextWithEntities f15809t;
        @Nullable
        public String f15810u;
        @Nullable
        public GraphQLPage f15811v;
        public int f15812w;
        @Nullable
        public String f15813x;
        @Nullable
        public String f15814y;
        @Nullable
        public String f15815z;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final GraphQLEntity m22529a() {
            return new GraphQLEntity(this);
        }
    }

    /* compiled from: m.facebook.com */
    final class C06771 implements Creator<GraphQLEntity> {
        C06771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEntity(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEntity[i];
        }
    }

    @Nullable
    public final GraphQLObjectType mo2904b() {
        if (this.f5823b != null && this.f15835d == null) {
            this.f15835d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f15835d == null || this.f15835d.m22301g() != 0) {
            return this.f15835d;
        }
        return null;
    }

    @FieldOffset
    public final ImmutableList<String> mo2905c() {
        this.f15836e = super.m9943a(this.f15836e, 1);
        return (ImmutableList) this.f15836e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppSection m22557j() {
        this.f15837f = (GraphQLTimelineAppSection) super.m9947a(this.f15837f, 2, GraphQLTimelineAppSection.class);
        return this.f15837f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAppStoreApplication m22558k() {
        this.f15838g = (GraphQLAppStoreApplication) super.m9947a(this.f15838g, 3, GraphQLAppStoreApplication.class);
        return this.f15838g;
    }

    @FieldOffset
    @Nullable
    public final String m22559l() {
        this.f15839h = super.m9948a(this.f15839h, 4);
        return this.f15839h;
    }

    @FieldOffset
    @Nullable
    public final String m22560m() {
        this.f15840i = super.m9948a(this.f15840i, 5);
        return this.f15840i;
    }

    @FieldOffset
    @Nullable
    public final String m22561n() {
        this.f15841j = super.m9948a(this.f15841j, 6);
        return this.f15841j;
    }

    @FieldOffset
    @Nullable
    public final String m22562o() {
        this.f15842k = super.m9948a(this.f15842k, 7);
        return this.f15842k;
    }

    @FieldOffset
    public final GraphQLFriendshipStatus m22563p() {
        this.f15843l = (GraphQLFriendshipStatus) super.m9945a(this.f15843l, 8, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f15843l;
    }

    @FieldOffset
    public final int m22564q() {
        m9949a(1, 1);
        return this.f15844m;
    }

    @FieldOffset
    @Nullable
    public final String mo2906d() {
        this.f15845n = super.m9948a(this.f15845n, 10);
        return this.f15845n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22565r() {
        this.f15846o = (GraphQLImage) super.m9947a(this.f15846o, 11, GraphQLImage.class);
        return this.f15846o;
    }

    @FieldOffset
    public final int m22566s() {
        m9949a(1, 4);
        return this.f15847p;
    }

    @FieldOffset
    public final int m22567t() {
        m9949a(1, 5);
        return this.f15848q;
    }

    @FieldOffset
    public final int m22568u() {
        m9949a(1, 6);
        return this.f15849r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22569v() {
        this.f15850s = (GraphQLImage) super.m9947a(this.f15850s, 15, GraphQLImage.class);
        return this.f15850s;
    }

    @FieldOffset
    public final boolean m22570w() {
        m9949a(2, 0);
        return this.f15851t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22571x() {
        this.f15852u = (GraphQLTextWithEntities) super.m9947a(this.f15852u, 17, GraphQLTextWithEntities.class);
        return this.f15852u;
    }

    @FieldOffset
    @Nullable
    public final String C_() {
        this.f15853v = super.m9948a(this.f15853v, 18);
        return this.f15853v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m22572y() {
        this.f15854w = (GraphQLPage) super.m9947a(this.f15854w, 19, GraphQLPage.class);
        return this.f15854w;
    }

    @FieldOffset
    public final int m22573z() {
        m9949a(2, 4);
        return this.f15855x;
    }

    @FieldOffset
    @Nullable
    public final String m22530A() {
        this.f15856y = super.m9948a(this.f15856y, 21);
        return this.f15856y;
    }

    @FieldOffset
    @Nullable
    public final String m22531B() {
        this.f15857z = super.m9948a(this.f15857z, 22);
        return this.f15857z;
    }

    @FieldOffset
    @Nullable
    public final String m22532C() {
        this.f15816A = super.m9948a(this.f15816A, 23);
        return this.f15816A;
    }

    @FieldOffset
    @Nullable
    public final String m22533D() {
        this.f15817B = super.m9948a(this.f15817B, 24);
        return this.f15817B;
    }

    @FieldOffset
    @Nullable
    public final String m22534E() {
        this.f15818C = super.m9948a(this.f15818C, 25);
        return this.f15818C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22535F() {
        this.f15819D = (GraphQLImage) super.m9947a(this.f15819D, 26, GraphQLImage.class);
        return this.f15819D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22536G() {
        this.f15820E = (GraphQLImage) super.m9947a(this.f15820E, 27, GraphQLImage.class);
        return this.f15820E;
    }

    @FieldOffset
    @Nullable
    public final String m22537H() {
        this.f15821F = super.m9948a(this.f15821F, 28);
        return this.f15821F;
    }

    @FieldOffset
    public final ImmutableList<GraphQLRedirectionInfo> m22538I() {
        this.f15822G = super.m9944a(this.f15822G, 29, GraphQLRedirectionInfo.class);
        return (ImmutableList) this.f15822G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity m22539J() {
        this.f15823H = (GraphQLEntity) super.m9947a(this.f15823H, 30, GraphQLEntity.class);
        return this.f15823H;
    }

    @FieldOffset
    public final double m22540K() {
        m9949a(3, 7);
        return this.f15824I;
    }

    @FieldOffset
    public final double m22541L() {
        m9949a(4, 0);
        return this.f15825J;
    }

    @FieldOffset
    @Nullable
    public final String m22542M() {
        this.f15826K = super.m9948a(this.f15826K, 33);
        return this.f15826K;
    }

    @FieldOffset
    @Nullable
    public final String m22543N() {
        this.f15827L = super.m9948a(this.f15827L, 34);
        return this.f15827L;
    }

    @FieldOffset
    public final int m22544O() {
        m9949a(4, 3);
        return this.f15828M;
    }

    @FieldOffset
    public final GraphQLSubscribeStatus m22545P() {
        this.f15829N = (GraphQLSubscribeStatus) super.m9945a(this.f15829N, 36, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f15829N;
    }

    @FieldOffset
    @Nullable
    public final String mo2907g() {
        this.f15830O = super.m9948a(this.f15830O, 37);
        return this.f15830O;
    }

    @FieldOffset
    @Nullable
    public final String D_() {
        this.f15831P = super.m9948a(this.f15831P, 38);
        return this.f15831P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22546Q() {
        this.f15832Q = (GraphQLImage) super.m9947a(this.f15832Q, 39, GraphQLImage.class);
        return this.f15832Q;
    }

    @FieldOffset
    public final int m22547R() {
        m9949a(5, 0);
        return this.f15833R;
    }

    @FieldOffset
    @Nullable
    public final String m22548S() {
        this.f15834S = super.m9948a(this.f15834S, 41);
        return this.f15834S;
    }

    @Nullable
    public final String mo2834a() {
        return mo2906d();
    }

    public final int jK_() {
        return 2080559107;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22557j() != null) {
            GraphQLTimelineAppSection graphQLTimelineAppSection = (GraphQLTimelineAppSection) graphQLModelMutatingVisitor.mo2928b(m22557j());
            if (m22557j() != graphQLTimelineAppSection) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15837f = graphQLTimelineAppSection;
            }
        }
        if (m22558k() != null) {
            GraphQLAppStoreApplication graphQLAppStoreApplication = (GraphQLAppStoreApplication) graphQLModelMutatingVisitor.mo2928b(m22558k());
            if (m22558k() != graphQLAppStoreApplication) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15838g = graphQLAppStoreApplication;
            }
        }
        if (m22565r() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22565r());
            if (m22565r() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15846o = graphQLImage;
            }
        }
        if (m22569v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22569v());
            if (m22569v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15850s = graphQLImage;
            }
        }
        if (m22571x() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22571x());
            if (m22571x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15852u = graphQLTextWithEntities;
            }
        }
        if (m22572y() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m22572y());
            if (m22572y() != graphQLPage) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15854w = graphQLPage;
            }
        }
        if (m22535F() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22535F());
            if (m22535F() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15819D = graphQLImage;
            }
        }
        if (m22536G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22536G());
            if (m22536G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15820E = graphQLImage;
            }
        }
        if (m22538I() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.m23097a(m22538I(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLEntity graphQLEntity = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLEntity.f15822G = a.m1068b();
                graphQLVisitableModel = graphQLEntity;
            }
        }
        if (m22539J() != null) {
            graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.mo2928b(m22539J());
            if (m22539J() != graphQLEntity) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15823H = graphQLEntity;
            }
        }
        if (m22546Q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22546Q());
            if (m22546Q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEntity) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15832Q = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEntity() {
        super(43);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15844m = mutableFlatBuffer.m21524a(i, 9, 0);
        this.f15847p = mutableFlatBuffer.m21524a(i, 12, 0);
        this.f15848q = mutableFlatBuffer.m21524a(i, 13, 0);
        this.f15849r = mutableFlatBuffer.m21524a(i, 14, 0);
        this.f15851t = mutableFlatBuffer.m21540a(i, 16);
        this.f15855x = mutableFlatBuffer.m21524a(i, 20, 0);
        this.f15824I = mutableFlatBuffer.m21523a(i, 31, 0.0d);
        this.f15825J = mutableFlatBuffer.m21523a(i, 32, 0.0d);
        this.f15828M = mutableFlatBuffer.m21524a(i, 35, 0);
        this.f15833R = mutableFlatBuffer.m21524a(i, 40, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(mo2904b() != null ? mo2904b().m22299e() : null);
        int c = flatBufferBuilder.m21509c(mo2905c());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22557j());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m22558k());
        int b = flatBufferBuilder.m21502b(m22559l());
        int b2 = flatBufferBuilder.m21502b(m22560m());
        int b3 = flatBufferBuilder.m21502b(m22561n());
        int b4 = flatBufferBuilder.m21502b(m22562o());
        int b5 = flatBufferBuilder.m21502b(mo2906d());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m22565r());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m22569v());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m22571x());
        int b6 = flatBufferBuilder.m21502b(C_());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m22572y());
        int b7 = flatBufferBuilder.m21502b(m22530A());
        int b8 = flatBufferBuilder.m21502b(m22531B());
        int b9 = flatBufferBuilder.m21502b(m22532C());
        int b10 = flatBufferBuilder.m21502b(m22533D());
        int b11 = flatBufferBuilder.m21502b(m22534E());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22535F());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22536G());
        int b12 = flatBufferBuilder.m21502b(m22537H());
        int a10 = ModelHelper.m23094a(flatBufferBuilder, (List) m22538I());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22539J());
        int b13 = flatBufferBuilder.m21502b(m22542M());
        int b14 = flatBufferBuilder.m21502b(m22543N());
        int b15 = flatBufferBuilder.m21502b(mo2907g());
        int b16 = flatBufferBuilder.m21502b(D_());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22546Q());
        int b17 = flatBufferBuilder.m21502b(m22548S());
        flatBufferBuilder.m21510c(42);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, c);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, b3);
        flatBufferBuilder.m21507b(7, b4);
        flatBufferBuilder.m21496a(8, m22563p() == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22563p());
        flatBufferBuilder.m21494a(9, m22564q(), 0);
        flatBufferBuilder.m21507b(10, b5);
        flatBufferBuilder.m21507b(11, a4);
        flatBufferBuilder.m21494a(12, m22566s(), 0);
        flatBufferBuilder.m21494a(13, m22567t(), 0);
        flatBufferBuilder.m21494a(14, m22568u(), 0);
        flatBufferBuilder.m21507b(15, a5);
        flatBufferBuilder.m21498a(16, m22570w());
        flatBufferBuilder.m21507b(17, a6);
        flatBufferBuilder.m21507b(18, b6);
        flatBufferBuilder.m21507b(19, a7);
        flatBufferBuilder.m21494a(20, m22573z(), 0);
        flatBufferBuilder.m21507b(21, b7);
        flatBufferBuilder.m21507b(22, b8);
        flatBufferBuilder.m21507b(23, b9);
        flatBufferBuilder.m21507b(24, b10);
        flatBufferBuilder.m21507b(25, b11);
        flatBufferBuilder.m21507b(26, a8);
        flatBufferBuilder.m21507b(27, a9);
        flatBufferBuilder.m21507b(28, b12);
        flatBufferBuilder.m21507b(29, a10);
        flatBufferBuilder.m21507b(30, a11);
        flatBufferBuilder.m21492a(31, m22540K(), 0.0d);
        flatBufferBuilder.m21492a(32, m22541L(), 0.0d);
        flatBufferBuilder.m21507b(33, b13);
        flatBufferBuilder.m21507b(34, b14);
        flatBufferBuilder.m21494a(35, m22544O(), 0);
        flatBufferBuilder.m21496a(36, m22545P() == GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22545P());
        flatBufferBuilder.m21507b(37, b15);
        flatBufferBuilder.m21507b(38, b16);
        flatBufferBuilder.m21507b(39, a12);
        flatBufferBuilder.m21494a(40, m22547R(), 0);
        flatBufferBuilder.m21507b(41, b17);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEntity(Parcel parcel) {
        super(43);
        this.f15836e = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f15837f = (GraphQLTimelineAppSection) parcel.readValue(GraphQLTimelineAppSection.class.getClassLoader());
        this.f15838g = (GraphQLAppStoreApplication) parcel.readValue(GraphQLAppStoreApplication.class.getClassLoader());
        this.f15839h = parcel.readString();
        this.f15840i = parcel.readString();
        this.f15841j = parcel.readString();
        this.f15842k = parcel.readString();
        this.f15843l = GraphQLFriendshipStatus.fromString(parcel.readString());
        this.f15844m = parcel.readInt();
        this.f15845n = parcel.readString();
        this.f15846o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f15847p = parcel.readInt();
        this.f15848q = parcel.readInt();
        this.f15849r = parcel.readInt();
        this.f15850s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f15851t = parcel.readByte() == (byte) 1;
        this.f15852u = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15853v = parcel.readString();
        this.f15854w = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f15855x = parcel.readInt();
        this.f15856y = parcel.readString();
        this.f15857z = parcel.readString();
        this.f15816A = parcel.readString();
        this.f15817B = parcel.readString();
        this.f15818C = parcel.readString();
        this.f15819D = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f15820E = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f15821F = parcel.readString();
        this.f15822G = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLRedirectionInfo.class.getClassLoader()));
        this.f15823H = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.f15824I = parcel.readDouble();
        this.f15825J = parcel.readDouble();
        this.f15826K = parcel.readString();
        this.f15827L = parcel.readString();
        this.f15834S = parcel.readString();
        this.f15828M = parcel.readInt();
        this.f15829N = GraphQLSubscribeStatus.fromString(parcel.readString());
        this.f15830O = parcel.readString();
        this.f15831P = parcel.readString();
        this.f15832Q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f15833R = parcel.readInt();
        this.f15835d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(mo2905c());
        parcel.writeValue(m22557j());
        parcel.writeValue(m22558k());
        parcel.writeString(m22559l());
        parcel.writeString(m22560m());
        parcel.writeString(m22561n());
        parcel.writeString(m22562o());
        parcel.writeString(m22563p().name());
        parcel.writeInt(m22564q());
        parcel.writeString(mo2906d());
        parcel.writeValue(m22565r());
        parcel.writeInt(m22566s());
        parcel.writeInt(m22567t());
        parcel.writeInt(m22568u());
        parcel.writeValue(m22569v());
        parcel.writeByte((byte) (m22570w() ? 1 : 0));
        parcel.writeValue(m22571x());
        parcel.writeString(C_());
        parcel.writeValue(m22572y());
        parcel.writeInt(m22573z());
        parcel.writeString(m22530A());
        parcel.writeString(m22531B());
        parcel.writeString(m22532C());
        parcel.writeString(m22533D());
        parcel.writeString(m22534E());
        parcel.writeValue(m22535F());
        parcel.writeValue(m22536G());
        parcel.writeString(m22537H());
        parcel.writeList(m22538I());
        parcel.writeValue(m22539J());
        parcel.writeDouble(m22540K());
        parcel.writeDouble(m22541L());
        parcel.writeString(m22542M());
        parcel.writeString(m22543N());
        parcel.writeString(m22548S());
        parcel.writeInt(m22544O());
        parcel.writeString(m22545P().name());
        parcel.writeString(mo2907g());
        parcel.writeString(D_());
        parcel.writeValue(m22546Q());
        parcel.writeInt(m22547R());
        parcel.writeParcelable(this.f15835d, i);
    }

    public GraphQLEntity(Builder builder) {
        super(43);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15836e = builder.f15793d;
        this.f15837f = builder.f15794e;
        this.f15838g = builder.f15795f;
        this.f15839h = builder.f15796g;
        this.f15840i = builder.f15797h;
        this.f15841j = builder.f15798i;
        this.f15842k = builder.f15799j;
        this.f15843l = builder.f15800k;
        this.f15844m = builder.f15801l;
        this.f15845n = builder.f15802m;
        this.f15846o = builder.f15803n;
        this.f15847p = builder.f15804o;
        this.f15848q = builder.f15805p;
        this.f15849r = builder.f15806q;
        this.f15850s = builder.f15807r;
        this.f15851t = builder.f15808s;
        this.f15852u = builder.f15809t;
        this.f15853v = builder.f15810u;
        this.f15854w = builder.f15811v;
        this.f15855x = builder.f15812w;
        this.f15856y = builder.f15813x;
        this.f15857z = builder.f15814y;
        this.f15816A = builder.f15815z;
        this.f15817B = builder.f15774A;
        this.f15818C = builder.f15775B;
        this.f15819D = builder.f15776C;
        this.f15820E = builder.f15777D;
        this.f15821F = builder.f15778E;
        this.f15822G = builder.f15779F;
        this.f15823H = builder.f15780G;
        this.f15824I = builder.f15781H;
        this.f15825J = builder.f15782I;
        this.f15826K = builder.f15783J;
        this.f15827L = builder.f15784K;
        this.f15834S = builder.f15785L;
        this.f15828M = builder.f15786M;
        this.f15829N = builder.f15787N;
        this.f15830O = builder.f15788O;
        this.f15831P = builder.f15789P;
        this.f15832Q = builder.f15790Q;
        this.f15833R = builder.f15791R;
        this.f15835d = builder.f15792S;
    }
}
