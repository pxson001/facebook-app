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
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: liger_foreground_preconnect */
public final class GraphQLSticker extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSticker> CREATOR = new 1();
    @Nullable
    GraphQLImage f17557A;
    @Nullable
    GraphQLImage f17558B;
    @Nullable
    GraphQLImage f17559C;
    @Nullable
    GraphQLImage f17560D;
    @Nullable
    String f17561E;
    @Nullable
    GraphQLImage f17562F;
    @Nullable
    String f17563G;
    @Nullable
    GraphQLImage f17564H;
    @Nullable
    GraphQLImage f17565I;
    @Nullable
    String f17566J;
    @Nullable
    String f17567K;
    int f17568L;
    int f17569M;
    @Nullable
    String f17570N;
    @Nullable
    GraphQLImage f17571O;
    @Nullable
    String f17572P;
    @Nullable
    GraphQLImage f17573Q;
    @Nullable
    GraphQLImage f17574R;
    @Nullable
    GraphQLImage f17575S;
    @Nullable
    GraphQLImage f17576T;
    @Nullable
    GraphQLImage f17577U;
    @Nullable
    GraphQLImage f17578V;
    @Nullable
    GraphQLImage f17579W;
    @Nullable
    String f17580X;
    @Nullable
    GraphQLImage f17581Y;
    @Nullable
    GraphQLImage f17582Z;
    int aa;
    @Nullable
    GraphQLImage f17583d;
    @Nullable
    GraphQLImage f17584e;
    List<GraphQLProfile> f17585f;
    int f17586g;
    int f17587h;
    int f17588i;
    int f17589j;
    @Nullable
    String f17590k;
    @Nullable
    GraphQLImage f17591l;
    @Nullable
    GraphQLImage f17592m;
    @Nullable
    GraphQLImage f17593n;
    @Nullable
    GraphQLImage f17594o;
    @Nullable
    GraphQLImage f17595p;
    @Nullable
    GraphQLImage f17596q;
    @Nullable
    GraphQLImage f17597r;
    @Nullable
    GraphQLImage f17598s;
    @Nullable
    GraphQLImage f17599t;
    @Nullable
    GraphQLImage f17600u;
    @Nullable
    GraphQLImage f17601v;
    @Nullable
    GraphQLImage f17602w;
    @Nullable
    GraphQLImage f17603x;
    boolean f17604y;
    boolean f17605z;

    @FieldOffset
    @Nullable
    public final GraphQLImage m24753j() {
        this.f17583d = (GraphQLImage) super.m9947a(this.f17583d, 0, GraphQLImage.class);
        return this.f17583d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24754k() {
        this.f17584e = (GraphQLImage) super.m9947a(this.f17584e, 1, GraphQLImage.class);
        return this.f17584e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLProfile> m24755l() {
        this.f17585f = super.m9944a(this.f17585f, 2, GraphQLProfile.class);
        return (ImmutableList) this.f17585f;
    }

    @FieldOffset
    public final int m24756m() {
        m9949a(0, 3);
        return this.f17586g;
    }

    @FieldOffset
    public final int m24757n() {
        m9949a(0, 5);
        return this.f17587h;
    }

    @FieldOffset
    public final int m24758o() {
        m9949a(0, 6);
        return this.f17588i;
    }

    @FieldOffset
    public final int m24759p() {
        m9949a(0, 7);
        return this.f17589j;
    }

    @FieldOffset
    @Nullable
    public final String m24760q() {
        this.f17590k = super.m9948a(this.f17590k, 8);
        return this.f17590k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24761r() {
        this.f17591l = (GraphQLImage) super.m9947a(this.f17591l, 9, GraphQLImage.class);
        return this.f17591l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24762s() {
        this.f17592m = (GraphQLImage) super.m9947a(this.f17592m, 10, GraphQLImage.class);
        return this.f17592m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24763t() {
        this.f17593n = (GraphQLImage) super.m9947a(this.f17593n, 11, GraphQLImage.class);
        return this.f17593n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24764u() {
        this.f17594o = (GraphQLImage) super.m9947a(this.f17594o, 12, GraphQLImage.class);
        return this.f17594o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24765v() {
        this.f17595p = (GraphQLImage) super.m9947a(this.f17595p, 13, GraphQLImage.class);
        return this.f17595p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24766w() {
        this.f17596q = (GraphQLImage) super.m9947a(this.f17596q, 14, GraphQLImage.class);
        return this.f17596q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24767x() {
        this.f17597r = (GraphQLImage) super.m9947a(this.f17597r, 15, GraphQLImage.class);
        return this.f17597r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24768y() {
        this.f17598s = (GraphQLImage) super.m9947a(this.f17598s, 16, GraphQLImage.class);
        return this.f17598s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24769z() {
        this.f17599t = (GraphQLImage) super.m9947a(this.f17599t, 17, GraphQLImage.class);
        return this.f17599t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24723A() {
        this.f17600u = (GraphQLImage) super.m9947a(this.f17600u, 18, GraphQLImage.class);
        return this.f17600u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24724B() {
        this.f17601v = (GraphQLImage) super.m9947a(this.f17601v, 19, GraphQLImage.class);
        return this.f17601v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24725C() {
        this.f17602w = (GraphQLImage) super.m9947a(this.f17602w, 20, GraphQLImage.class);
        return this.f17602w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24726D() {
        this.f17603x = (GraphQLImage) super.m9947a(this.f17603x, 21, GraphQLImage.class);
        return this.f17603x;
    }

    @FieldOffset
    public final boolean m24727E() {
        m9949a(2, 6);
        return this.f17604y;
    }

    @FieldOffset
    public final boolean m24728F() {
        m9949a(2, 7);
        return this.f17605z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24729G() {
        this.f17557A = (GraphQLImage) super.m9947a(this.f17557A, 24, GraphQLImage.class);
        return this.f17557A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24730H() {
        this.f17558B = (GraphQLImage) super.m9947a(this.f17558B, 25, GraphQLImage.class);
        return this.f17558B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24731I() {
        this.f17559C = (GraphQLImage) super.m9947a(this.f17559C, 26, GraphQLImage.class);
        return this.f17559C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24732J() {
        this.f17560D = (GraphQLImage) super.m9947a(this.f17560D, 27, GraphQLImage.class);
        return this.f17560D;
    }

    @FieldOffset
    @Nullable
    public final String m24733K() {
        this.f17561E = super.m9948a(this.f17561E, 28);
        return this.f17561E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24734L() {
        this.f17562F = (GraphQLImage) super.m9947a(this.f17562F, 29, GraphQLImage.class);
        return this.f17562F;
    }

    @FieldOffset
    @Nullable
    public final String m24735M() {
        this.f17563G = super.m9948a(this.f17563G, 30);
        return this.f17563G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24736N() {
        this.f17564H = (GraphQLImage) super.m9947a(this.f17564H, 31, GraphQLImage.class);
        return this.f17564H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24737O() {
        this.f17565I = (GraphQLImage) super.m9947a(this.f17565I, 32, GraphQLImage.class);
        return this.f17565I;
    }

    @FieldOffset
    @Nullable
    public final String m24738P() {
        this.f17566J = super.m9948a(this.f17566J, 33);
        return this.f17566J;
    }

    @FieldOffset
    @Nullable
    public final String m24739Q() {
        this.f17567K = super.m9948a(this.f17567K, 34);
        return this.f17567K;
    }

    @FieldOffset
    public final int m24740R() {
        m9949a(4, 3);
        return this.f17568L;
    }

    @FieldOffset
    public final int m24741S() {
        m9949a(4, 4);
        return this.f17569M;
    }

    @FieldOffset
    @Nullable
    public final String m24742T() {
        this.f17570N = super.m9948a(this.f17570N, 37);
        return this.f17570N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24743U() {
        this.f17571O = (GraphQLImage) super.m9947a(this.f17571O, 38, GraphQLImage.class);
        return this.f17571O;
    }

    @FieldOffset
    @Nullable
    public final String m24744V() {
        this.f17572P = super.m9948a(this.f17572P, 39);
        return this.f17572P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24745W() {
        this.f17573Q = (GraphQLImage) super.m9947a(this.f17573Q, 40, GraphQLImage.class);
        return this.f17573Q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24746X() {
        this.f17574R = (GraphQLImage) super.m9947a(this.f17574R, 41, GraphQLImage.class);
        return this.f17574R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24747Y() {
        this.f17575S = (GraphQLImage) super.m9947a(this.f17575S, 42, GraphQLImage.class);
        return this.f17575S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24748Z() {
        this.f17576T = (GraphQLImage) super.m9947a(this.f17576T, 43, GraphQLImage.class);
        return this.f17576T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aa() {
        this.f17577U = (GraphQLImage) super.m9947a(this.f17577U, 44, GraphQLImage.class);
        return this.f17577U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ab() {
        this.f17578V = (GraphQLImage) super.m9947a(this.f17578V, 45, GraphQLImage.class);
        return this.f17578V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ac() {
        this.f17579W = (GraphQLImage) super.m9947a(this.f17579W, 46, GraphQLImage.class);
        return this.f17579W;
    }

    @FieldOffset
    @Nullable
    public final String ad() {
        this.f17580X = super.m9948a(this.f17580X, 47);
        return this.f17580X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ae() {
        this.f17581Y = (GraphQLImage) super.m9947a(this.f17581Y, 48, GraphQLImage.class);
        return this.f17581Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage af() {
        this.f17582Z = (GraphQLImage) super.m9947a(this.f17582Z, 49, GraphQLImage.class);
        return this.f17582Z;
    }

    @FieldOffset
    public final int ag() {
        m9949a(6, 5);
        return this.aa;
    }

    @Nullable
    public final String mo2834a() {
        return m24760q();
    }

    public final int jK_() {
        return -225599203;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24753j() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24753j());
            if (m24753j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17583d = graphQLImage;
            }
        }
        if (m24754k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24754k());
            if (m24754k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17584e = graphQLImage;
            }
        }
        if (m24755l() != null) {
            Builder a = ModelHelper.m23097a(m24755l(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLSticker graphQLSticker = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLSticker.f17585f = a.m1068b();
                graphQLVisitableModel = graphQLSticker;
            }
        }
        if (m24761r() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24761r());
            if (m24761r() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17591l = graphQLImage;
            }
        }
        if (m24762s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24762s());
            if (m24762s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17592m = graphQLImage;
            }
        }
        if (m24763t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24763t());
            if (m24763t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17593n = graphQLImage;
            }
        }
        if (m24764u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24764u());
            if (m24764u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17594o = graphQLImage;
            }
        }
        if (m24765v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24765v());
            if (m24765v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17595p = graphQLImage;
            }
        }
        if (m24766w() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24766w());
            if (m24766w() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17596q = graphQLImage;
            }
        }
        if (m24767x() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24767x());
            if (m24767x() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17597r = graphQLImage;
            }
        }
        if (m24768y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24768y());
            if (m24768y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17598s = graphQLImage;
            }
        }
        if (ae() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17581Y = graphQLImage;
            }
        }
        if (m24769z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24769z());
            if (m24769z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17599t = graphQLImage;
            }
        }
        if (m24723A() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24723A());
            if (m24723A() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17600u = graphQLImage;
            }
        }
        if (m24724B() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24724B());
            if (m24724B() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17601v = graphQLImage;
            }
        }
        if (m24725C() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24725C());
            if (m24725C() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17602w = graphQLImage;
            }
        }
        if (m24726D() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24726D());
            if (m24726D() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17603x = graphQLImage;
            }
        }
        if (af() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17582Z = graphQLImage;
            }
        }
        if (m24729G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24729G());
            if (m24729G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17557A = graphQLImage;
            }
        }
        if (m24730H() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24730H());
            if (m24730H() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17558B = graphQLImage;
            }
        }
        if (m24731I() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24731I());
            if (m24731I() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17559C = graphQLImage;
            }
        }
        if (m24732J() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24732J());
            if (m24732J() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17560D = graphQLImage;
            }
        }
        if (m24734L() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24734L());
            if (m24734L() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17562F = graphQLImage;
            }
        }
        if (m24736N() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24736N());
            if (m24736N() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17564H = graphQLImage;
            }
        }
        if (m24737O() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24737O());
            if (m24737O() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17565I = graphQLImage;
            }
        }
        if (m24743U() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24743U());
            if (m24743U() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17571O = graphQLImage;
            }
        }
        if (m24745W() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24745W());
            if (m24745W() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17573Q = graphQLImage;
            }
        }
        if (m24746X() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24746X());
            if (m24746X() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17574R = graphQLImage;
            }
        }
        if (m24747Y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24747Y());
            if (m24747Y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17575S = graphQLImage;
            }
        }
        if (m24748Z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24748Z());
            if (m24748Z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17576T = graphQLImage;
            }
        }
        if (aa() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aa());
            if (aa() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17577U = graphQLImage;
            }
        }
        if (ab() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17578V = graphQLImage;
            }
        }
        if (ac() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSticker) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17579W = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSticker() {
        super(55);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17586g = mutableFlatBuffer.m21524a(i, 3, 0);
        this.f17587h = mutableFlatBuffer.m21524a(i, 5, 0);
        this.f17588i = mutableFlatBuffer.m21524a(i, 6, 0);
        this.f17589j = mutableFlatBuffer.m21524a(i, 7, 0);
        this.f17604y = mutableFlatBuffer.m21540a(i, 22);
        this.f17605z = mutableFlatBuffer.m21540a(i, 23);
        this.f17568L = mutableFlatBuffer.m21524a(i, 35, 0);
        this.f17569M = mutableFlatBuffer.m21524a(i, 36, 0);
        this.aa = mutableFlatBuffer.m21524a(i, 53, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24753j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24754k());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m24755l());
        int b = flatBufferBuilder.m21502b(m24760q());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24761r());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24762s());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24763t());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24764u());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24765v());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24766w());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m24767x());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m24768y());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m24769z());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m24723A());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24724B());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24725C());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24726D());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24729G());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24730H());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24731I());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24732J());
        int b2 = flatBufferBuilder.m21502b(m24733K());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24734L());
        int b3 = flatBufferBuilder.m21502b(m24735M());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24736N());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24737O());
        int b4 = flatBufferBuilder.m21502b(m24738P());
        int b5 = flatBufferBuilder.m21502b(m24739Q());
        int b6 = flatBufferBuilder.m21502b(m24742T());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24743U());
        int b7 = flatBufferBuilder.m21502b(m24744V());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24745W());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24746X());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24747Y());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24748Z());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aa());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ab());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ac());
        int b8 = flatBufferBuilder.m21502b(ad());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ae());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) af());
        flatBufferBuilder.m21510c(54);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21494a(3, m24756m(), 0);
        flatBufferBuilder.m21494a(5, m24757n(), 0);
        flatBufferBuilder.m21494a(6, m24758o(), 0);
        flatBufferBuilder.m21494a(7, m24759p(), 0);
        flatBufferBuilder.m21507b(8, b);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, a5);
        flatBufferBuilder.m21507b(11, a6);
        flatBufferBuilder.m21507b(12, a7);
        flatBufferBuilder.m21507b(13, a8);
        flatBufferBuilder.m21507b(14, a9);
        flatBufferBuilder.m21507b(15, a10);
        flatBufferBuilder.m21507b(16, a11);
        flatBufferBuilder.m21507b(17, a12);
        flatBufferBuilder.m21507b(18, a13);
        flatBufferBuilder.m21507b(19, a14);
        flatBufferBuilder.m21507b(20, a15);
        flatBufferBuilder.m21507b(21, a16);
        flatBufferBuilder.m21498a(22, m24727E());
        flatBufferBuilder.m21498a(23, m24728F());
        flatBufferBuilder.m21507b(24, a17);
        flatBufferBuilder.m21507b(25, a18);
        flatBufferBuilder.m21507b(26, a19);
        flatBufferBuilder.m21507b(27, a20);
        flatBufferBuilder.m21507b(28, b2);
        flatBufferBuilder.m21507b(29, a21);
        flatBufferBuilder.m21507b(30, b3);
        flatBufferBuilder.m21507b(31, a22);
        flatBufferBuilder.m21507b(32, a23);
        flatBufferBuilder.m21507b(33, b4);
        flatBufferBuilder.m21507b(34, b5);
        flatBufferBuilder.m21494a(35, m24740R(), 0);
        flatBufferBuilder.m21494a(36, m24741S(), 0);
        flatBufferBuilder.m21507b(37, b6);
        flatBufferBuilder.m21507b(38, a24);
        flatBufferBuilder.m21507b(39, b7);
        flatBufferBuilder.m21507b(40, a25);
        flatBufferBuilder.m21507b(41, a26);
        flatBufferBuilder.m21507b(42, a27);
        flatBufferBuilder.m21507b(43, a28);
        flatBufferBuilder.m21507b(44, a29);
        flatBufferBuilder.m21507b(45, a30);
        flatBufferBuilder.m21507b(46, a31);
        flatBufferBuilder.m21507b(47, b8);
        flatBufferBuilder.m21507b(48, a32);
        flatBufferBuilder.m21507b(49, a33);
        flatBufferBuilder.m21494a(53, ag(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSticker(Parcel parcel) {
        boolean z = true;
        super(55);
        this.f17583d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17584e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17585f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLProfile.class.getClassLoader()));
        this.f17586g = parcel.readInt();
        this.f17587h = parcel.readInt();
        this.f17588i = parcel.readInt();
        this.f17589j = parcel.readInt();
        this.f17590k = parcel.readString();
        this.f17591l = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17592m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17593n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17594o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17595p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17596q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17597r = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17598s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17581Y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17599t = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17600u = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17601v = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17602w = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17603x = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17582Z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17604y = parcel.readByte() == (byte) 1;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f17605z = z;
        this.f17557A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17558B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17559C = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17560D = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17561E = parcel.readString();
        this.f17562F = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17563G = parcel.readString();
        this.f17564H = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17565I = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17566J = parcel.readString();
        this.f17567K = parcel.readString();
        this.f17568L = parcel.readInt();
        this.f17569M = parcel.readInt();
        this.f17570N = parcel.readString();
        this.f17571O = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17572P = parcel.readString();
        this.f17573Q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17574R = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17575S = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17576T = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17577U = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17578V = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17579W = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17580X = parcel.readString();
        this.aa = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeValue(m24753j());
        parcel.writeValue(m24754k());
        parcel.writeList(m24755l());
        parcel.writeInt(m24756m());
        parcel.writeInt(m24757n());
        parcel.writeInt(m24758o());
        parcel.writeInt(m24759p());
        parcel.writeString(m24760q());
        parcel.writeValue(m24761r());
        parcel.writeValue(m24762s());
        parcel.writeValue(m24763t());
        parcel.writeValue(m24764u());
        parcel.writeValue(m24765v());
        parcel.writeValue(m24766w());
        parcel.writeValue(m24767x());
        parcel.writeValue(m24768y());
        parcel.writeValue(ae());
        parcel.writeValue(m24769z());
        parcel.writeValue(m24723A());
        parcel.writeValue(m24724B());
        parcel.writeValue(m24725C());
        parcel.writeValue(m24726D());
        parcel.writeValue(af());
        parcel.writeByte((byte) (m24727E() ? 1 : 0));
        if (!m24728F()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24729G());
        parcel.writeValue(m24730H());
        parcel.writeValue(m24731I());
        parcel.writeValue(m24732J());
        parcel.writeString(m24733K());
        parcel.writeValue(m24734L());
        parcel.writeString(m24735M());
        parcel.writeValue(m24736N());
        parcel.writeValue(m24737O());
        parcel.writeString(m24738P());
        parcel.writeString(m24739Q());
        parcel.writeInt(m24740R());
        parcel.writeInt(m24741S());
        parcel.writeString(m24742T());
        parcel.writeValue(m24743U());
        parcel.writeString(m24744V());
        parcel.writeValue(m24745W());
        parcel.writeValue(m24746X());
        parcel.writeValue(m24747Y());
        parcel.writeValue(m24748Z());
        parcel.writeValue(aa());
        parcel.writeValue(ab());
        parcel.writeValue(ac());
        parcel.writeString(ad());
        parcel.writeInt(ag());
    }
}
