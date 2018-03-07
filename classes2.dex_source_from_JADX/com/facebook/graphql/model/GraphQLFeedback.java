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
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.BaseExtra;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultFeedbackFields.Likers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultFeedbackFields.TopLevelComments;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: logVideoException */
public final class GraphQLFeedback extends BaseModel implements HasProperty, TypeModel, CommonGraphQLInterfaces$DefaultFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLFeedback> CREATOR = new C07891();
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f16367A;
    @Deprecated
    @Nullable
    GraphQLLikersOfContentConnection f16368B;
    @Nullable
    GraphQLTopLevelCommentsConnection f16369C;
    @Nullable
    GraphQLReactorsOfContentConnection f16370D;
    @Nullable
    GraphQLFeedbackRealTimeActivityInfo f16371E;
    @Nullable
    String f16372F;
    @Nullable
    GraphQLResharesOfContentConnection f16373G;
    @Nullable
    GraphQLSeenByConnection f16374H;
    @Deprecated
    boolean f16375I;
    List<GraphQLFeedbackReaction> f16376J;
    @Nullable
    GraphQLTopLevelCommentsConnection f16377K;
    @Nullable
    GraphQLTopReactionsConnection f16378L;
    @Nullable
    String f16379M;
    @Nullable
    GraphQLPage f16380N;
    @Deprecated
    @Nullable
    String f16381O;
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f16382P;
    @Deprecated
    @Nullable
    GraphQLFeedbackReaction f16383Q;
    public int f16384R;
    @Deprecated
    @Nullable
    String f16385S;
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f16386T;
    @Nullable
    GraphQLVideoTimestampedCommentsConnection f16387U;
    @Nullable
    GraphQLImportantReactorsConnection f16388V;
    @Nullable
    GraphQLUser f16389W;
    private FeedbackExtra f16390X;
    @Nullable
    private PropertyBag f16391Y = null;
    boolean f16392d;
    public boolean f16393e;
    boolean f16394f;
    boolean f16395g;
    boolean f16396h;
    @Deprecated
    public boolean f16397i;
    boolean f16398j;
    boolean f16399k;
    @Deprecated
    @Nullable
    GraphQLCommentsConnection f16400l;
    @Nullable
    GraphQLTextWithEntities f16401m;
    @Nullable
    String f16402n;
    @Nullable
    String f16403o;
    boolean f16404p;
    @Deprecated
    public boolean f16405q;
    public boolean f16406r;
    public long f16407s;
    boolean f16408t;
    public boolean f16409u;
    @Nullable
    String f16410v;
    @Deprecated
    @Nullable
    GraphQLInteractorsConnection f16411w;
    @Deprecated
    @Nullable
    GraphQLInteractorsConnection f16412x;
    public boolean f16413y;
    @Nullable
    String f16414z;

    /* compiled from: logVideoException */
    final class C07891 implements Creator<GraphQLFeedback> {
        C07891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFeedback(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFeedback[i];
        }
    }

    /* compiled from: logVideoException */
    public class FeedbackExtra extends BaseExtra {
        public static final Creator<FeedbackExtra> CREATOR = new C09041();
        public ConsistentFeedbackTopReactionsConnection f22288a = null;

        /* compiled from: logVideoException */
        final class C09041 implements Creator<FeedbackExtra> {
            C09041() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new FeedbackExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new FeedbackExtra[i];
            }
        }

        protected FeedbackExtra(Parcel parcel) {
            super((byte) 0);
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            int a = super.mo1403a(flatBufferBuilder);
            int a2 = flatBufferBuilder.m21475a(this.f22288a);
            flatBufferBuilder.m21510c(3);
            if (a > 0) {
                flatBufferBuilder.m21507b(0, a);
            }
            flatBufferBuilder.m21507b(2, a2);
            return flatBufferBuilder.m21511d();
        }

        public final void mo1412a(MutableFlatBuffer mutableFlatBuffer, int i) {
            super.mo1412a(mutableFlatBuffer, mutableFlatBuffer.m21560g(i, 0));
            this.f22288a = (ConsistentFeedbackTopReactionsConnection) mutableFlatBuffer.m21551d(i, 2, ConsistentFeedbackTopReactionsConnection.class);
        }
    }

    public final String toString() {
        return Objects.toStringHelper(GraphQLFeedback.class).add("LikeCount", GraphQLHelper.m22520o(this).mo2914a()).add("CommentCount", GraphQLHelper.m22504f(this)).add("doesViewerLike", y_()).toString();
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ Likers mo2934k() {
        return m23209C();
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ TopLevelComments mo2935l() {
        return m23218L();
    }

    @FieldOffset
    public final boolean mo2929b() {
        m9949a(0, 1);
        return this.f16392d;
    }

    @FieldOffset
    public final boolean mo2930c() {
        m9949a(0, 2);
        return this.f16393e;
    }

    @FieldOffset
    public final boolean mo2931d() {
        m9949a(0, 3);
        return this.f16394f;
    }

    @FieldOffset
    public final boolean m23246m() {
        m9949a(0, 4);
        return this.f16395g;
    }

    @FieldOffset
    public final boolean x_() {
        m9949a(0, 5);
        return this.f16396h;
    }

    @FieldOffset
    public final boolean mo2932g() {
        m9949a(0, 6);
        return this.f16397i;
    }

    @FieldOffset
    public final boolean m23247n() {
        m9949a(0, 7);
        return this.f16398j;
    }

    @FieldOffset
    public final boolean m23248o() {
        m9949a(1, 0);
        return this.f16399k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCommentsConnection m23249p() {
        this.f16400l = (GraphQLCommentsConnection) super.m9947a(this.f16400l, 9, GraphQLCommentsConnection.class);
        return this.f16400l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23250q() {
        this.f16401m = (GraphQLTextWithEntities) super.m9947a(this.f16401m, 10, GraphQLTextWithEntities.class);
        return this.f16401m;
    }

    @FieldOffset
    @Nullable
    public final String m23251r() {
        this.f16402n = super.m9948a(this.f16402n, 11);
        return this.f16402n;
    }

    @FieldOffset
    @Nullable
    public final String m23252s() {
        this.f16403o = super.m9948a(this.f16403o, 12);
        return this.f16403o;
    }

    @FieldOffset
    public final boolean m23253t() {
        m9949a(1, 5);
        return this.f16404p;
    }

    @FieldOffset
    public final boolean y_() {
        m9949a(1, 6);
        return this.f16405q;
    }

    @FieldOffset
    public final boolean m23254u() {
        m9949a(1, 7);
        return this.f16406r;
    }

    @FieldOffset
    public final long m23255v() {
        m9949a(2, 0);
        return this.f16407s;
    }

    public final void m23235a(long j) {
        this.f16407s = j;
    }

    @FieldOffset
    public final boolean m23256w() {
        m9949a(2, 1);
        return this.f16408t;
    }

    @FieldOffset
    public final boolean m23257x() {
        m9949a(2, 2);
        return this.f16409u;
    }

    @FieldOffset
    @Nullable
    public final String z_() {
        this.f16410v = super.m9948a(this.f16410v, 19);
        return this.f16410v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInteractorsConnection m23258y() {
        this.f16411w = (GraphQLInteractorsConnection) super.m9947a(this.f16411w, 20, GraphQLInteractorsConnection.class);
        return this.f16411w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInteractorsConnection m23259z() {
        this.f16412x = (GraphQLInteractorsConnection) super.m9947a(this.f16412x, 21, GraphQLInteractorsConnection.class);
        return this.f16412x;
    }

    @FieldOffset
    public final boolean m23207A() {
        m9949a(2, 6);
        return this.f16413y;
    }

    @FieldOffset
    @Nullable
    public final String mo2933j() {
        this.f16414z = super.m9948a(this.f16414z, 23);
        return this.f16414z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23208B() {
        this.f16367A = (GraphQLTextWithEntities) super.m9947a(this.f16367A, 24, GraphQLTextWithEntities.class);
        return this.f16367A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLikersOfContentConnection m23209C() {
        this.f16368B = (GraphQLLikersOfContentConnection) super.m9947a(this.f16368B, 25, GraphQLLikersOfContentConnection.class);
        return this.f16368B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTopLevelCommentsConnection m23210D() {
        this.f16369C = (GraphQLTopLevelCommentsConnection) super.m9947a(this.f16369C, 26, GraphQLTopLevelCommentsConnection.class);
        return this.f16369C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLReactorsOfContentConnection m23211E() {
        this.f16370D = (GraphQLReactorsOfContentConnection) super.m9947a(this.f16370D, 27, GraphQLReactorsOfContentConnection.class);
        return this.f16370D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackRealTimeActivityInfo m23212F() {
        this.f16371E = (GraphQLFeedbackRealTimeActivityInfo) super.m9947a(this.f16371E, 28, GraphQLFeedbackRealTimeActivityInfo.class);
        return this.f16371E;
    }

    @FieldOffset
    @Nullable
    public final String m23213G() {
        this.f16372F = super.m9948a(this.f16372F, 30);
        return this.f16372F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResharesOfContentConnection m23214H() {
        this.f16373G = (GraphQLResharesOfContentConnection) super.m9947a(this.f16373G, 31, GraphQLResharesOfContentConnection.class);
        return this.f16373G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSeenByConnection m23215I() {
        this.f16374H = (GraphQLSeenByConnection) super.m9947a(this.f16374H, 32, GraphQLSeenByConnection.class);
        return this.f16374H;
    }

    @FieldOffset
    public final boolean m23216J() {
        m9949a(4, 1);
        return this.f16375I;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFeedbackReaction> m23217K() {
        this.f16376J = super.m9944a(this.f16376J, 34, GraphQLFeedbackReaction.class);
        return (ImmutableList) this.f16376J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTopLevelCommentsConnection m23218L() {
        this.f16377K = (GraphQLTopLevelCommentsConnection) super.m9947a(this.f16377K, 35, GraphQLTopLevelCommentsConnection.class);
        return this.f16377K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTopReactionsConnection m23219M() {
        this.f16378L = (GraphQLTopReactionsConnection) super.m9947a(this.f16378L, 36, GraphQLTopReactionsConnection.class);
        return this.f16378L;
    }

    @FieldOffset
    @Nullable
    public final String m23220N() {
        this.f16379M = super.m9948a(this.f16379M, 37);
        return this.f16379M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m23221O() {
        this.f16380N = (GraphQLPage) super.m9947a(this.f16380N, 38, GraphQLPage.class);
        return this.f16380N;
    }

    @FieldOffset
    @Nullable
    public final String m23222P() {
        this.f16381O = super.m9948a(this.f16381O, 39);
        return this.f16381O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23223Q() {
        this.f16382P = (GraphQLTextWithEntities) super.m9947a(this.f16382P, 40, GraphQLTextWithEntities.class);
        return this.f16382P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackReaction m23224R() {
        this.f16383Q = (GraphQLFeedbackReaction) super.m9947a(this.f16383Q, 41, GraphQLFeedbackReaction.class);
        return this.f16383Q;
    }

    @FieldOffset
    public final int m23225S() {
        m9949a(5, 2);
        return this.f16384R;
    }

    @FieldOffset
    @Nullable
    public final String m23226T() {
        this.f16385S = super.m9948a(this.f16385S, 43);
        return this.f16385S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23227U() {
        this.f16386T = (GraphQLTextWithEntities) super.m9947a(this.f16386T, 44, GraphQLTextWithEntities.class);
        return this.f16386T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideoTimestampedCommentsConnection m23228V() {
        this.f16387U = (GraphQLVideoTimestampedCommentsConnection) super.m9947a(this.f16387U, 45, GraphQLVideoTimestampedCommentsConnection.class);
        return this.f16387U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImportantReactorsConnection m23229W() {
        this.f16388V = (GraphQLImportantReactorsConnection) super.m9947a(this.f16388V, 46, GraphQLImportantReactorsConnection.class);
        return this.f16388V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m23230X() {
        this.f16389W = (GraphQLUser) super.m9947a(this.f16389W, 47, GraphQLUser.class);
        return this.f16389W;
    }

    @Nullable
    public final String mo2834a() {
        return mo2933j();
    }

    public final int jK_() {
        return -126857307;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLInteractorsConnection graphQLInteractorsConnection;
        GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23249p() != null) {
            GraphQLCommentsConnection graphQLCommentsConnection = (GraphQLCommentsConnection) graphQLModelMutatingVisitor.mo2928b(m23249p());
            if (m23249p() != graphQLCommentsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16400l = graphQLCommentsConnection;
            }
        }
        if (m23250q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23250q());
            if (m23250q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16401m = graphQLTextWithEntities;
            }
        }
        if (m23229W() != null) {
            GraphQLImportantReactorsConnection graphQLImportantReactorsConnection = (GraphQLImportantReactorsConnection) graphQLModelMutatingVisitor.mo2928b(m23229W());
            if (m23229W() != graphQLImportantReactorsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16388V = graphQLImportantReactorsConnection;
            }
        }
        if (m23258y() != null) {
            graphQLInteractorsConnection = (GraphQLInteractorsConnection) graphQLModelMutatingVisitor.mo2928b(m23258y());
            if (m23258y() != graphQLInteractorsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16411w = graphQLInteractorsConnection;
            }
        }
        if (m23259z() != null) {
            graphQLInteractorsConnection = (GraphQLInteractorsConnection) graphQLModelMutatingVisitor.mo2928b(m23259z());
            if (m23259z() != graphQLInteractorsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16412x = graphQLInteractorsConnection;
            }
        }
        if (m23208B() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23208B());
            if (m23208B() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16367A = graphQLTextWithEntities;
            }
        }
        if (m23209C() != null) {
            GraphQLLikersOfContentConnection graphQLLikersOfContentConnection = (GraphQLLikersOfContentConnection) graphQLModelMutatingVisitor.mo2928b(m23209C());
            if (m23209C() != graphQLLikersOfContentConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16368B = graphQLLikersOfContentConnection;
            }
        }
        if (m23210D() != null) {
            graphQLTopLevelCommentsConnection = (GraphQLTopLevelCommentsConnection) graphQLModelMutatingVisitor.mo2928b(m23210D());
            if (m23210D() != graphQLTopLevelCommentsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16369C = graphQLTopLevelCommentsConnection;
            }
        }
        if (m23211E() != null) {
            GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection = (GraphQLReactorsOfContentConnection) graphQLModelMutatingVisitor.mo2928b(m23211E());
            if (m23211E() != graphQLReactorsOfContentConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16370D = graphQLReactorsOfContentConnection;
            }
        }
        if (m23212F() != null) {
            GraphQLFeedbackRealTimeActivityInfo graphQLFeedbackRealTimeActivityInfo = (GraphQLFeedbackRealTimeActivityInfo) graphQLModelMutatingVisitor.mo2928b(m23212F());
            if (m23212F() != graphQLFeedbackRealTimeActivityInfo) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16371E = graphQLFeedbackRealTimeActivityInfo;
            }
        }
        if (m23214H() != null) {
            GraphQLResharesOfContentConnection graphQLResharesOfContentConnection = (GraphQLResharesOfContentConnection) graphQLModelMutatingVisitor.mo2928b(m23214H());
            if (m23214H() != graphQLResharesOfContentConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16373G = graphQLResharesOfContentConnection;
            }
        }
        if (m23215I() != null) {
            GraphQLSeenByConnection graphQLSeenByConnection = (GraphQLSeenByConnection) graphQLModelMutatingVisitor.mo2928b(m23215I());
            if (m23215I() != graphQLSeenByConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16374H = graphQLSeenByConnection;
            }
        }
        if (m23217K() != null) {
            Builder a = ModelHelper.m23097a(m23217K(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLFeedback.f16376J = a.m1068b();
                graphQLVisitableModel = graphQLFeedback;
            }
        }
        if (m23218L() != null) {
            graphQLTopLevelCommentsConnection = (GraphQLTopLevelCommentsConnection) graphQLModelMutatingVisitor.mo2928b(m23218L());
            if (m23218L() != graphQLTopLevelCommentsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16377K = graphQLTopLevelCommentsConnection;
            }
        }
        if (m23219M() != null) {
            GraphQLTopReactionsConnection graphQLTopReactionsConnection = (GraphQLTopReactionsConnection) graphQLModelMutatingVisitor.mo2928b(m23219M());
            if (m23219M() != graphQLTopReactionsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16378L = graphQLTopReactionsConnection;
            }
        }
        if (m23228V() != null) {
            GraphQLVideoTimestampedCommentsConnection graphQLVideoTimestampedCommentsConnection = (GraphQLVideoTimestampedCommentsConnection) graphQLModelMutatingVisitor.mo2928b(m23228V());
            if (m23228V() != graphQLVideoTimestampedCommentsConnection) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16387U = graphQLVideoTimestampedCommentsConnection;
            }
        }
        if (m23221O() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m23221O());
            if (m23221O() != graphQLPage) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16380N = graphQLPage;
            }
        }
        if (m23230X() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.mo2928b(m23230X());
            if (m23230X() != graphQLUser) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16389W = graphQLUser;
            }
        }
        if (m23223Q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23223Q());
            if (m23223Q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16382P = graphQLTextWithEntities;
            }
        }
        if (m23224R() != null) {
            GraphQLFeedbackReaction graphQLFeedbackReaction = (GraphQLFeedbackReaction) graphQLModelMutatingVisitor.mo2928b(m23224R());
            if (m23224R() != graphQLFeedbackReaction) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16383Q = graphQLFeedbackReaction;
            }
        }
        if (m23227U() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23227U());
            if (m23227U() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFeedback) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16386T = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("can_viewer_comment".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(mo2930c());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 2;
        } else if ("can_viewer_like".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(mo2932g());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 6;
        } else {
            BaseModel p;
            if ("comments.count".equals(str)) {
                p = m23249p();
                if (p != null) {
                    consistencyTuple.f18727a = Integer.valueOf(p.m22656a());
                    consistencyTuple.f18728b = p.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(y_());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 14;
                return;
            } else if ("have_comments_been_disabled".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(m23257x());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 18;
                return;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(m23207A());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 22;
                return;
            } else if ("likers.count".equals(str)) {
                p = m23209C();
                if (p != null) {
                    consistencyTuple.f18727a = Integer.valueOf(p.mo2914a());
                    consistencyTuple.f18728b = p.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("reactors.count".equals(str)) {
                p = m23211E();
                if (p != null) {
                    consistencyTuple.f18727a = Integer.valueOf(p.m22671a());
                    consistencyTuple.f18728b = p.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("reshares.count".equals(str)) {
                p = m23214H();
                if (p != null) {
                    consistencyTuple.f18727a = Integer.valueOf(p.m22588a());
                    consistencyTuple.f18728b = p.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("seen_by.count".equals(str)) {
                p = m23215I();
                if (p != null) {
                    consistencyTuple.f18727a = Integer.valueOf(p.m24792a());
                    consistencyTuple.f18728b = p.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("top_level_comments.count".equals(str)) {
                p = m23218L();
                if (p != null) {
                    consistencyTuple.f18727a = Integer.valueOf(p.mo2909a());
                    consistencyTuple.f18728b = p.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("top_level_comments.total_count".equals(str)) {
                p = m23218L();
                if (p != null) {
                    consistencyTuple.f18727a = Integer.valueOf(p.mo2910b());
                    consistencyTuple.f18728b = p.u_();
                    consistencyTuple.f18729c = 3;
                    return;
                }
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.f18727a = Integer.valueOf(m23225S());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 42;
                return;
            }
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("can_viewer_comment".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16393e = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 2, booleanValue);
            }
        } else if ("can_viewer_like".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16397i = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 6, booleanValue);
            }
        } else if ("comments.count".equals(str)) {
            r0 = m23249p();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLCommentsConnection graphQLCommentsConnection = (GraphQLCommentsConnection) r0.clone();
                graphQLCommentsConnection.mo2908a(((Integer) obj).intValue());
                this.f16400l = graphQLCommentsConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("does_viewer_like".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16405q = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 14, booleanValue);
            }
        } else if ("have_comments_been_disabled".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16409u = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 18, booleanValue);
            }
        } else if ("is_viewer_subscribed".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16413y = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 22, booleanValue);
            }
        } else if ("likers.count".equals(str)) {
            r0 = m23209C();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLLikersOfContentConnection graphQLLikersOfContentConnection = (GraphQLLikersOfContentConnection) r0.clone();
                graphQLLikersOfContentConnection.mo2908a(((Integer) obj).intValue());
                this.f16368B = graphQLLikersOfContentConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("reactors.count".equals(str)) {
            r0 = m23211E();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection = (GraphQLReactorsOfContentConnection) r0.clone();
                graphQLReactorsOfContentConnection.mo2908a(((Integer) obj).intValue());
                this.f16370D = graphQLReactorsOfContentConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("reshares.count".equals(str)) {
            r0 = m23214H();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLResharesOfContentConnection graphQLResharesOfContentConnection = (GraphQLResharesOfContentConnection) r0.clone();
                graphQLResharesOfContentConnection.mo2908a(((Integer) obj).intValue());
                this.f16373G = graphQLResharesOfContentConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("seen_by.count".equals(str)) {
            r0 = m23215I();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLSeenByConnection graphQLSeenByConnection = (GraphQLSeenByConnection) r0.clone();
                graphQLSeenByConnection.mo2908a(((Integer) obj).intValue());
                this.f16374H = graphQLSeenByConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("top_level_comments.count".equals(str)) {
            r0 = m23218L();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (GraphQLTopLevelCommentsConnection) r0.clone();
                r0.mo2908a(((Integer) obj).intValue());
                this.f16377K = r0;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("top_level_comments.total_count".equals(str)) {
            r0 = m23218L();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (GraphQLTopLevelCommentsConnection) r0.clone();
                r0.m22599b(((Integer) obj).intValue());
                this.f16377K = r0;
                return;
            }
            r0.m22599b(((Integer) obj).intValue());
        } else if ("viewer_feedback_reaction_key".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f16384R = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 42, intValue);
            }
        }
    }

    public GraphQLFeedback() {
        super(49);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16392d = mutableFlatBuffer.m21540a(i, 1);
        this.f16393e = mutableFlatBuffer.m21540a(i, 2);
        this.f16394f = mutableFlatBuffer.m21540a(i, 3);
        this.f16395g = mutableFlatBuffer.m21540a(i, 4);
        this.f16396h = mutableFlatBuffer.m21540a(i, 5);
        this.f16397i = mutableFlatBuffer.m21540a(i, 6);
        this.f16398j = mutableFlatBuffer.m21540a(i, 7);
        this.f16399k = mutableFlatBuffer.m21540a(i, 8);
        this.f16404p = mutableFlatBuffer.m21540a(i, 13);
        this.f16405q = mutableFlatBuffer.m21540a(i, 14);
        this.f16406r = mutableFlatBuffer.m21540a(i, 15);
        this.f16407s = mutableFlatBuffer.m21525a(i, 16, 0);
        this.f16408t = mutableFlatBuffer.m21540a(i, 17);
        this.f16409u = mutableFlatBuffer.m21540a(i, 18);
        this.f16413y = mutableFlatBuffer.m21540a(i, 22);
        this.f16375I = mutableFlatBuffer.m21540a(i, 33);
        this.f16384R = mutableFlatBuffer.m21524a(i, 42, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23249p());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23250q());
        int b = flatBufferBuilder.m21502b(m23251r());
        int b2 = flatBufferBuilder.m21502b(m23252s());
        int b3 = flatBufferBuilder.m21502b(z_());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23258y());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23259z());
        int b4 = flatBufferBuilder.m21502b(mo2933j());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23208B());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23209C());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23210D());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23211E());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m23212F());
        int b5 = flatBufferBuilder.m21502b(m23213G());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m23214H());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m23215I());
        int a12 = ModelHelper.m23094a(flatBufferBuilder, m23217K());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m23218L());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m23219M());
        int b6 = flatBufferBuilder.m21502b(m23220N());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m23221O());
        int b7 = flatBufferBuilder.m21502b(m23222P());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m23223Q());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m23224R());
        int b8 = flatBufferBuilder.m21502b(m23226T());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, m23227U());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, m23228V());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, m23229W());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, m23230X());
        flatBufferBuilder.m21510c(48);
        flatBufferBuilder.m21498a(1, mo2929b());
        flatBufferBuilder.m21498a(2, mo2930c());
        flatBufferBuilder.m21498a(3, mo2931d());
        flatBufferBuilder.m21498a(4, m23246m());
        flatBufferBuilder.m21498a(5, x_());
        flatBufferBuilder.m21498a(6, mo2932g());
        flatBufferBuilder.m21498a(7, m23247n());
        flatBufferBuilder.m21498a(8, m23248o());
        flatBufferBuilder.m21507b(9, a);
        flatBufferBuilder.m21507b(10, a2);
        flatBufferBuilder.m21507b(11, b);
        flatBufferBuilder.m21507b(12, b2);
        flatBufferBuilder.m21498a(13, m23253t());
        flatBufferBuilder.m21498a(14, y_());
        flatBufferBuilder.m21498a(15, m23254u());
        flatBufferBuilder.m21495a(16, m23255v(), 0);
        flatBufferBuilder.m21498a(17, m23256w());
        flatBufferBuilder.m21498a(18, m23257x());
        flatBufferBuilder.m21507b(19, b3);
        flatBufferBuilder.m21507b(20, a3);
        flatBufferBuilder.m21507b(21, a4);
        flatBufferBuilder.m21498a(22, m23207A());
        flatBufferBuilder.m21507b(23, b4);
        flatBufferBuilder.m21507b(24, a5);
        flatBufferBuilder.m21507b(25, a6);
        flatBufferBuilder.m21507b(26, a7);
        flatBufferBuilder.m21507b(27, a8);
        flatBufferBuilder.m21507b(28, a9);
        flatBufferBuilder.m21507b(30, b5);
        flatBufferBuilder.m21507b(31, a10);
        flatBufferBuilder.m21507b(32, a11);
        flatBufferBuilder.m21498a(33, m23216J());
        flatBufferBuilder.m21507b(34, a12);
        flatBufferBuilder.m21507b(35, a13);
        flatBufferBuilder.m21507b(36, a14);
        flatBufferBuilder.m21507b(37, b6);
        flatBufferBuilder.m21507b(38, a15);
        flatBufferBuilder.m21507b(39, b7);
        flatBufferBuilder.m21507b(40, a16);
        flatBufferBuilder.m21507b(41, a17);
        flatBufferBuilder.m21494a(42, m23225S(), 0);
        flatBufferBuilder.m21507b(43, b8);
        flatBufferBuilder.m21507b(44, a18);
        flatBufferBuilder.m21507b(45, a19);
        flatBufferBuilder.m21507b(46, a20);
        flatBufferBuilder.m21507b(47, a21);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedback(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(49);
        this.f16392d = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16393e = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16394f = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16395g = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16396h = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16397i = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16398j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16399k = z;
        this.f16400l = (GraphQLCommentsConnection) parcel.readValue(GraphQLCommentsConnection.class.getClassLoader());
        this.f16401m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16402n = parcel.readString();
        this.f16403o = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16404p = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16405q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16406r = z;
        this.f16407s = parcel.readLong();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16408t = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16409u = z;
        this.f16410v = parcel.readString();
        this.f16388V = (GraphQLImportantReactorsConnection) parcel.readValue(GraphQLImportantReactorsConnection.class.getClassLoader());
        this.f16411w = (GraphQLInteractorsConnection) parcel.readValue(GraphQLInteractorsConnection.class.getClassLoader());
        this.f16412x = (GraphQLInteractorsConnection) parcel.readValue(GraphQLInteractorsConnection.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16413y = z;
        this.f16414z = parcel.readString();
        this.f16367A = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16368B = (GraphQLLikersOfContentConnection) parcel.readValue(GraphQLLikersOfContentConnection.class.getClassLoader());
        this.f16369C = (GraphQLTopLevelCommentsConnection) parcel.readValue(GraphQLTopLevelCommentsConnection.class.getClassLoader());
        this.f16370D = (GraphQLReactorsOfContentConnection) parcel.readValue(GraphQLReactorsOfContentConnection.class.getClassLoader());
        this.f16371E = (GraphQLFeedbackRealTimeActivityInfo) parcel.readValue(GraphQLFeedbackRealTimeActivityInfo.class.getClassLoader());
        this.f16372F = parcel.readString();
        this.f16373G = (GraphQLResharesOfContentConnection) parcel.readValue(GraphQLResharesOfContentConnection.class.getClassLoader());
        this.f16374H = (GraphQLSeenByConnection) parcel.readValue(GraphQLSeenByConnection.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f16375I = z2;
        this.f16376J = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFeedbackReaction.class.getClassLoader()));
        this.f16377K = (GraphQLTopLevelCommentsConnection) parcel.readValue(GraphQLTopLevelCommentsConnection.class.getClassLoader());
        this.f16378L = (GraphQLTopReactionsConnection) parcel.readValue(GraphQLTopReactionsConnection.class.getClassLoader());
        this.f16379M = parcel.readString();
        this.f16387U = (GraphQLVideoTimestampedCommentsConnection) parcel.readValue(GraphQLVideoTimestampedCommentsConnection.class.getClassLoader());
        this.f16380N = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f16389W = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f16381O = parcel.readString();
        this.f16382P = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16383Q = (GraphQLFeedbackReaction) parcel.readValue(GraphQLFeedbackReaction.class.getClassLoader());
        this.f16384R = parcel.readInt();
        this.f16385S = parcel.readString();
        this.f16386T = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16390X = (FeedbackExtra) ParcelUtil.b(parcel, FeedbackExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (mo2929b() ? 1 : 0));
        if (mo2930c()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (mo2931d()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23246m()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (x_()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (mo2932g()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23247n()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23248o()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m23249p());
        parcel.writeValue(m23250q());
        parcel.writeString(m23251r());
        parcel.writeString(m23252s());
        if (m23253t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (y_()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23254u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(m23255v());
        if (m23256w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23257x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(z_());
        parcel.writeValue(m23229W());
        parcel.writeValue(m23258y());
        parcel.writeValue(m23259z());
        if (m23207A()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(mo2933j());
        parcel.writeValue(m23208B());
        parcel.writeValue(m23209C());
        parcel.writeValue(m23210D());
        parcel.writeValue(m23211E());
        parcel.writeValue(m23212F());
        parcel.writeString(m23213G());
        parcel.writeValue(m23214H());
        parcel.writeValue(m23215I());
        if (!m23216J()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeList(m23217K());
        parcel.writeValue(m23218L());
        parcel.writeValue(m23219M());
        parcel.writeString(m23220N());
        parcel.writeValue(m23228V());
        parcel.writeValue(m23221O());
        parcel.writeValue(m23230X());
        parcel.writeString(m23222P());
        parcel.writeValue(m23223Q());
        parcel.writeValue(m23224R());
        parcel.writeInt(m23225S());
        parcel.writeString(m23226T());
        parcel.writeValue(m23227U());
        parcel.writeParcelable(m23231Y(), i);
    }

    public GraphQLFeedback(Builder builder) {
        super(49);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16392d = builder.d;
        this.f16393e = builder.e;
        this.f16394f = builder.f;
        this.f16395g = builder.g;
        this.f16396h = builder.h;
        this.f16397i = builder.i;
        this.f16398j = builder.j;
        this.f16399k = builder.k;
        this.f16400l = builder.l;
        this.f16401m = builder.m;
        this.f16402n = builder.n;
        this.f16403o = builder.o;
        this.f16404p = builder.p;
        this.f16405q = builder.q;
        this.f16406r = builder.r;
        this.f16407s = builder.s;
        this.f16408t = builder.t;
        this.f16409u = builder.u;
        this.f16410v = builder.v;
        this.f16388V = builder.w;
        this.f16411w = builder.x;
        this.f16412x = builder.y;
        this.f16413y = builder.z;
        this.f16414z = builder.A;
        this.f16367A = builder.B;
        this.f16368B = builder.C;
        this.f16369C = builder.D;
        this.f16370D = builder.E;
        this.f16371E = builder.F;
        this.f16372F = builder.G;
        this.f16373G = builder.H;
        this.f16374H = builder.I;
        this.f16375I = builder.J;
        this.f16376J = builder.K;
        this.f16377K = builder.L;
        this.f16378L = builder.M;
        this.f16379M = builder.N;
        this.f16387U = builder.O;
        this.f16380N = builder.P;
        this.f16389W = builder.Q;
        this.f16381O = builder.R;
        this.f16382P = builder.S;
        this.f16383Q = builder.T;
        this.f16384R = builder.U;
        this.f16385S = builder.V;
        this.f16386T = builder.W;
        this.f16391Y = builder.X;
    }

    public final FeedbackExtra m23231Y() {
        if (this.f16390X == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f16390X = new FeedbackExtra();
            } else {
                this.f16390X = (FeedbackExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, FeedbackExtra.class);
            }
        }
        return this.f16390X;
    }

    public final PropertyBag U_() {
        if (this.f16391Y == null) {
            this.f16391Y = new PropertyBag();
        }
        return this.f16391Y;
    }
}
