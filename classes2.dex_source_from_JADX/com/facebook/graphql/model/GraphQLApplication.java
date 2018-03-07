package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
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
/* compiled from: location */
public final class GraphQLApplication extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLApplication> CREATOR = new C08061();
    @Nullable
    GraphQLImage f16724A;
    @Nullable
    GraphQLImage f16725B;
    @Nullable
    GraphQLPhoto f16726C;
    @Nullable
    GraphQLImage f16727D;
    boolean f16728E;
    @Nullable
    String f16729F;
    @Nullable
    GraphQLTextWithEntities f16730G;
    @Nullable
    GraphQLTextWithEntities f16731H;
    @Nullable
    GraphQLImage f16732I;
    @Nullable
    GraphQLStreamingImage f16733J;
    @Nullable
    GraphQLImage f16734K;
    @Nullable
    String f16735L;
    int f16736M;
    @Nullable
    String f16737N;
    @Nullable
    String f16738O;
    @Nullable
    GraphQLAndroidAppConfig f16739d;
    @Nullable
    String f16740e;
    List<String> f16741f;
    List<String> f16742g;
    @Nullable
    GraphQLTextWithEntities f16743h;
    @Nullable
    GraphQLImage f16744i;
    @Nullable
    GraphQLTextWithEntities f16745j;
    @Deprecated
    double f16746k;
    @Nullable
    String f16747l;
    @Nullable
    GraphQLImage f16748m;
    @Nullable
    GraphQLTextWithEntities f16749n;
    @Nullable
    String f16750o;
    @Nullable
    GraphQLImage f16751p;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f16752q;
    boolean f16753r;
    @Nullable
    String f16754s;
    List<String> f16755t;
    @Nullable
    GraphQLMobileStoreObject f16756u;
    @Nullable
    GraphQLRating f16757v;
    @Nullable
    String f16758w;
    @Nullable
    GraphQLImage f16759x;
    @Nullable
    GraphQLImage f16760y;
    @Nullable
    GraphQLImage f16761z;

    /* compiled from: location */
    final class C08061 implements Creator<GraphQLApplication> {
        C08061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLApplication(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLApplication[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLAndroidAppConfig m23661j() {
        this.f16739d = (GraphQLAndroidAppConfig) super.m9947a(this.f16739d, 0, GraphQLAndroidAppConfig.class);
        return this.f16739d;
    }

    @FieldOffset
    @Nullable
    public final String m23662k() {
        this.f16740e = super.m9948a(this.f16740e, 1);
        return this.f16740e;
    }

    @FieldOffset
    public final ImmutableList<String> m23663l() {
        this.f16741f = super.m9943a(this.f16741f, 2);
        return (ImmutableList) this.f16741f;
    }

    @FieldOffset
    public final ImmutableList<String> m23664m() {
        this.f16742g = super.m9943a(this.f16742g, 3);
        return (ImmutableList) this.f16742g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23665n() {
        this.f16743h = (GraphQLTextWithEntities) super.m9947a(this.f16743h, 4, GraphQLTextWithEntities.class);
        return this.f16743h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23666o() {
        this.f16744i = (GraphQLImage) super.m9947a(this.f16744i, 5, GraphQLImage.class);
        return this.f16744i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23667p() {
        this.f16745j = (GraphQLTextWithEntities) super.m9947a(this.f16745j, 6, GraphQLTextWithEntities.class);
        return this.f16745j;
    }

    @FieldOffset
    public final double m23668q() {
        m9949a(0, 7);
        return this.f16746k;
    }

    @FieldOffset
    @Nullable
    public final String m23669r() {
        this.f16747l = super.m9948a(this.f16747l, 8);
        return this.f16747l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23670s() {
        this.f16748m = (GraphQLImage) super.m9947a(this.f16748m, 9, GraphQLImage.class);
        return this.f16748m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23671t() {
        this.f16749n = (GraphQLTextWithEntities) super.m9947a(this.f16749n, 10, GraphQLTextWithEntities.class);
        return this.f16749n;
    }

    @FieldOffset
    @Nullable
    public final String m23672u() {
        this.f16750o = super.m9948a(this.f16750o, 12);
        return this.f16750o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23673v() {
        this.f16751p = (GraphQLImage) super.m9947a(this.f16751p, 13, GraphQLImage.class);
        return this.f16751p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m23674w() {
        this.f16752q = (GraphQLInlineActivitiesConnection) super.m9947a(this.f16752q, 14, GraphQLInlineActivitiesConnection.class);
        return this.f16752q;
    }

    @FieldOffset
    public final boolean m23675x() {
        m9949a(1, 7);
        return this.f16753r;
    }

    @FieldOffset
    @Nullable
    public final String m23676y() {
        this.f16754s = super.m9948a(this.f16754s, 18);
        return this.f16754s;
    }

    @FieldOffset
    public final ImmutableList<String> m23677z() {
        this.f16755t = super.m9943a(this.f16755t, 19);
        return (ImmutableList) this.f16755t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMobileStoreObject m23636A() {
        this.f16756u = (GraphQLMobileStoreObject) super.m9947a(this.f16756u, 20, GraphQLMobileStoreObject.class);
        return this.f16756u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRating m23637B() {
        this.f16757v = (GraphQLRating) super.m9947a(this.f16757v, 21, GraphQLRating.class);
        return this.f16757v;
    }

    @FieldOffset
    @Nullable
    public final String m23638C() {
        this.f16758w = super.m9948a(this.f16758w, 22);
        return this.f16758w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23639D() {
        this.f16759x = (GraphQLImage) super.m9947a(this.f16759x, 23, GraphQLImage.class);
        return this.f16759x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23640E() {
        this.f16760y = (GraphQLImage) super.m9947a(this.f16760y, 24, GraphQLImage.class);
        return this.f16760y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23641F() {
        this.f16761z = (GraphQLImage) super.m9947a(this.f16761z, 27, GraphQLImage.class);
        return this.f16761z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23642G() {
        this.f16724A = (GraphQLImage) super.m9947a(this.f16724A, 29, GraphQLImage.class);
        return this.f16724A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23643H() {
        this.f16725B = (GraphQLImage) super.m9947a(this.f16725B, 30, GraphQLImage.class);
        return this.f16725B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m23644I() {
        this.f16726C = (GraphQLPhoto) super.m9947a(this.f16726C, 31, GraphQLPhoto.class);
        return this.f16726C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23645J() {
        this.f16727D = (GraphQLImage) super.m9947a(this.f16727D, 32, GraphQLImage.class);
        return this.f16727D;
    }

    @FieldOffset
    public final boolean m23646K() {
        m9949a(4, 1);
        return this.f16728E;
    }

    @FieldOffset
    @Nullable
    public final String m23647L() {
        this.f16729F = super.m9948a(this.f16729F, 34);
        return this.f16729F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23648M() {
        this.f16730G = (GraphQLTextWithEntities) super.m9947a(this.f16730G, 35, GraphQLTextWithEntities.class);
        return this.f16730G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23649N() {
        this.f16731H = (GraphQLTextWithEntities) super.m9947a(this.f16731H, 36, GraphQLTextWithEntities.class);
        return this.f16731H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23650O() {
        this.f16732I = (GraphQLImage) super.m9947a(this.f16732I, 37, GraphQLImage.class);
        return this.f16732I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m23651P() {
        this.f16733J = (GraphQLStreamingImage) super.m9947a(this.f16733J, 38, GraphQLStreamingImage.class);
        return this.f16733J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23652Q() {
        this.f16734K = (GraphQLImage) super.m9947a(this.f16734K, 39, GraphQLImage.class);
        return this.f16734K;
    }

    @FieldOffset
    @Nullable
    public final String m23653R() {
        this.f16735L = super.m9948a(this.f16735L, 40);
        return this.f16735L;
    }

    @FieldOffset
    public final int m23654S() {
        m9949a(5, 1);
        return this.f16736M;
    }

    @FieldOffset
    @Nullable
    public final String m23655T() {
        this.f16737N = super.m9948a(this.f16737N, 42);
        return this.f16737N;
    }

    @FieldOffset
    @Nullable
    public final String m23656U() {
        this.f16738O = super.m9948a(this.f16738O, 43);
        return this.f16738O;
    }

    @Nullable
    public final String mo2834a() {
        return m23672u();
    }

    public final int jK_() {
        return -1072845520;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23661j() != null) {
            GraphQLAndroidAppConfig graphQLAndroidAppConfig = (GraphQLAndroidAppConfig) graphQLModelMutatingVisitor.mo2928b(m23661j());
            if (m23661j() != graphQLAndroidAppConfig) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16739d = graphQLAndroidAppConfig;
            }
        }
        if (m23665n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23665n());
            if (m23665n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16743h = graphQLTextWithEntities;
            }
        }
        if (m23666o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23666o());
            if (m23666o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16744i = graphQLImage;
            }
        }
        if (m23667p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23667p());
            if (m23667p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16745j = graphQLTextWithEntities;
            }
        }
        if (m23670s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23670s());
            if (m23670s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16748m = graphQLImage;
            }
        }
        if (m23671t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23671t());
            if (m23671t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16749n = graphQLTextWithEntities;
            }
        }
        if (m23673v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23673v());
            if (m23673v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16751p = graphQLImage;
            }
        }
        if (m23674w() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(m23674w());
            if (m23674w() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16752q = graphQLInlineActivitiesConnection;
            }
        }
        if (m23636A() != null) {
            GraphQLMobileStoreObject graphQLMobileStoreObject = (GraphQLMobileStoreObject) graphQLModelMutatingVisitor.mo2928b(m23636A());
            if (m23636A() != graphQLMobileStoreObject) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16756u = graphQLMobileStoreObject;
            }
        }
        if (m23637B() != null) {
            GraphQLRating graphQLRating = (GraphQLRating) graphQLModelMutatingVisitor.mo2928b(m23637B());
            if (m23637B() != graphQLRating) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16757v = graphQLRating;
            }
        }
        if (m23639D() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23639D());
            if (m23639D() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16759x = graphQLImage;
            }
        }
        if (m23640E() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23640E());
            if (m23640E() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16760y = graphQLImage;
            }
        }
        if (m23641F() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23641F());
            if (m23641F() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16761z = graphQLImage;
            }
        }
        if (m23642G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23642G());
            if (m23642G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16724A = graphQLImage;
            }
        }
        if (m23643H() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23643H());
            if (m23643H() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16725B = graphQLImage;
            }
        }
        if (m23644I() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m23644I());
            if (m23644I() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16726C = graphQLPhoto;
            }
        }
        if (m23645J() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23645J());
            if (m23645J() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16727D = graphQLImage;
            }
        }
        if (m23648M() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23648M());
            if (m23648M() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16730G = graphQLTextWithEntities;
            }
        }
        if (m23649N() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23649N());
            if (m23649N() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16731H = graphQLTextWithEntities;
            }
        }
        if (m23650O() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23650O());
            if (m23650O() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16732I = graphQLImage;
            }
        }
        if (m23651P() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(m23651P());
            if (m23651P() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16733J = graphQLStreamingImage;
            }
        }
        if (m23652Q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23652Q());
            if (m23652Q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLApplication) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16734K = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLApplication() {
        super(45);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16746k = mutableFlatBuffer.m21523a(i, 7, 0.0d);
        this.f16753r = mutableFlatBuffer.m21540a(i, 15);
        this.f16728E = mutableFlatBuffer.m21540a(i, 33);
        this.f16736M = mutableFlatBuffer.m21524a(i, 41, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23661j());
        int b = flatBufferBuilder.m21502b(m23662k());
        int c = flatBufferBuilder.m21509c(m23663l());
        int c2 = flatBufferBuilder.m21509c(m23664m());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23665n());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23666o());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23667p());
        int b2 = flatBufferBuilder.m21502b(m23669r());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23670s());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23671t());
        int b3 = flatBufferBuilder.m21502b(m23672u());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23673v());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23674w());
        int b4 = flatBufferBuilder.m21502b(m23676y());
        int c3 = flatBufferBuilder.m21509c((List) m23677z());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23636A());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23637B());
        int b5 = flatBufferBuilder.m21502b(m23638C());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23639D());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23640E());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23641F());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23642G());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23643H());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23644I());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23645J());
        int b6 = flatBufferBuilder.m21502b(m23647L());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23648M());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23649N());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23650O());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23651P());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23652Q());
        int b7 = flatBufferBuilder.m21502b(m23653R());
        int b8 = flatBufferBuilder.m21502b(m23655T());
        int b9 = flatBufferBuilder.m21502b(m23656U());
        flatBufferBuilder.m21510c(44);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, c);
        flatBufferBuilder.m21507b(3, c2);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21492a(7, m23668q(), 0.0d);
        flatBufferBuilder.m21507b(8, b2);
        flatBufferBuilder.m21507b(9, a5);
        flatBufferBuilder.m21507b(10, a6);
        flatBufferBuilder.m21507b(12, b3);
        flatBufferBuilder.m21507b(13, a7);
        flatBufferBuilder.m21507b(14, a8);
        flatBufferBuilder.m21498a(15, m23675x());
        flatBufferBuilder.m21507b(18, b4);
        flatBufferBuilder.m21507b(19, c3);
        flatBufferBuilder.m21507b(20, a9);
        flatBufferBuilder.m21507b(21, a10);
        flatBufferBuilder.m21507b(22, b5);
        flatBufferBuilder.m21507b(23, a11);
        flatBufferBuilder.m21507b(24, a12);
        flatBufferBuilder.m21507b(27, a13);
        flatBufferBuilder.m21507b(29, a14);
        flatBufferBuilder.m21507b(30, a15);
        flatBufferBuilder.m21507b(31, a16);
        flatBufferBuilder.m21507b(32, a17);
        flatBufferBuilder.m21498a(33, m23646K());
        flatBufferBuilder.m21507b(34, b6);
        flatBufferBuilder.m21507b(35, a18);
        flatBufferBuilder.m21507b(36, a19);
        flatBufferBuilder.m21507b(37, a20);
        flatBufferBuilder.m21507b(38, a21);
        flatBufferBuilder.m21507b(39, a22);
        flatBufferBuilder.m21507b(40, b7);
        flatBufferBuilder.m21494a(41, m23654S(), 0);
        flatBufferBuilder.m21507b(42, b8);
        flatBufferBuilder.m21507b(43, b9);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLApplication(Parcel parcel) {
        boolean z = true;
        super(45);
        this.f16739d = (GraphQLAndroidAppConfig) parcel.readValue(GraphQLAndroidAppConfig.class.getClassLoader());
        this.f16740e = parcel.readString();
        this.f16741f = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16742g = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16743h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16744i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16745j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16746k = parcel.readDouble();
        this.f16747l = parcel.readString();
        this.f16748m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16749n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16750o = parcel.readString();
        this.f16751p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16752q = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f16753r = parcel.readByte() == (byte) 1;
        this.f16754s = parcel.readString();
        this.f16755t = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16756u = (GraphQLMobileStoreObject) parcel.readValue(GraphQLMobileStoreObject.class.getClassLoader());
        this.f16757v = (GraphQLRating) parcel.readValue(GraphQLRating.class.getClassLoader());
        this.f16758w = parcel.readString();
        this.f16759x = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16760y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16761z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16724A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16725B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16726C = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f16727D = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f16728E = z;
        this.f16729F = parcel.readString();
        this.f16730G = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16731H = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16732I = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16733J = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f16734K = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16735L = parcel.readString();
        this.f16736M = parcel.readInt();
        this.f16737N = parcel.readString();
        this.f16738O = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeValue(m23661j());
        parcel.writeString(m23662k());
        parcel.writeList(m23663l());
        parcel.writeList(m23664m());
        parcel.writeValue(m23665n());
        parcel.writeValue(m23666o());
        parcel.writeValue(m23667p());
        parcel.writeDouble(m23668q());
        parcel.writeString(m23669r());
        parcel.writeValue(m23670s());
        parcel.writeValue(m23671t());
        parcel.writeString(m23672u());
        parcel.writeValue(m23673v());
        parcel.writeValue(m23674w());
        parcel.writeByte((byte) (m23675x() ? 1 : 0));
        parcel.writeString(m23676y());
        parcel.writeList(m23677z());
        parcel.writeValue(m23636A());
        parcel.writeValue(m23637B());
        parcel.writeString(m23638C());
        parcel.writeValue(m23639D());
        parcel.writeValue(m23640E());
        parcel.writeValue(m23641F());
        parcel.writeValue(m23642G());
        parcel.writeValue(m23643H());
        parcel.writeValue(m23644I());
        parcel.writeValue(m23645J());
        if (!m23646K()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m23647L());
        parcel.writeValue(m23648M());
        parcel.writeValue(m23649N());
        parcel.writeValue(m23650O());
        parcel.writeValue(m23651P());
        parcel.writeValue(m23652Q());
        parcel.writeString(m23653R());
        parcel.writeInt(m23654S());
        parcel.writeString(m23655T());
        parcel.writeString(m23656U());
    }

    public GraphQLApplication(Builder builder) {
        super(45);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16739d = builder.d;
        this.f16740e = builder.e;
        this.f16741f = builder.f;
        this.f16742g = builder.g;
        this.f16743h = builder.h;
        this.f16744i = builder.i;
        this.f16745j = builder.j;
        this.f16746k = builder.k;
        this.f16747l = builder.l;
        this.f16748m = builder.m;
        this.f16749n = builder.n;
        this.f16750o = builder.o;
        this.f16751p = builder.p;
        this.f16752q = builder.q;
        this.f16753r = builder.r;
        this.f16754s = builder.s;
        this.f16755t = builder.t;
        this.f16756u = builder.u;
        this.f16757v = builder.v;
        this.f16758w = builder.w;
        this.f16759x = builder.x;
        this.f16760y = builder.y;
        this.f16761z = builder.z;
        this.f16724A = builder.A;
        this.f16725B = builder.B;
        this.f16726C = builder.C;
        this.f16727D = builder.D;
        this.f16728E = builder.E;
        this.f16729F = builder.F;
        this.f16730G = builder.G;
        this.f16731H = builder.H;
        this.f16732I = builder.I;
        this.f16733J = builder.J;
        this.f16734K = builder.K;
        this.f16735L = builder.L;
        this.f16736M = builder.M;
        this.f16737N = builder.N;
        this.f16738O = builder.O;
    }
}
