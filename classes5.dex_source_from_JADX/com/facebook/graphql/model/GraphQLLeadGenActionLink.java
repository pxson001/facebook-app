package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLeadGenActionLinkDeserializer;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: feedback_react */
public final class GraphQLLeadGenActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenActionLink> CREATOR = new C04201();
    public GraphQLCallToActionType f4318A;
    @Nullable
    public GraphQLImage f4319B;
    @Deprecated
    @Nullable
    public String f4320C;
    @Deprecated
    @Nullable
    public String f4321D;
    @Nullable
    public GraphQLPage f4322E;
    @Nullable
    public String f4323F;
    @Deprecated
    @Nullable
    public String f4324G;
    @Nullable
    public String f4325H;
    @Nullable
    public String f4326I;
    @Nullable
    public String f4327J;
    @Nullable
    public String f4328K;
    @Nullable
    public String f4329L;
    @Nullable
    public String f4330M;
    @Nullable
    public String f4331N;
    @Nullable
    public String f4332O;
    public boolean f4333P;
    @Nullable
    public String f4334Q;
    @Nullable
    public String f4335R;
    @Nullable
    public String f4336S;
    @Nullable
    public String f4337T;
    @Nullable
    public String f4338U;
    @Nullable
    public String f4339V;
    @Nullable
    public String f4340d;
    @Nullable
    public String f4341e;
    @Deprecated
    public int f4342f;
    public int f4343g;
    @Nullable
    public String f4344h;
    @Nullable
    public String f4345i;
    public List<GraphQLLeadGenErrorNode> f4346j;
    @Nullable
    public String f4347k;
    @Nullable
    public String f4348l;
    @Nullable
    public String f4349m;
    @Nullable
    public String f4350n;
    @Nullable
    public String f4351o;
    @Nullable
    public String f4352p;
    @Nullable
    public String f4353q;
    @Nullable
    public String f4354r;
    @Nullable
    public GraphQLLeadGenData f4355s;
    @Nullable
    public String f4356t;
    @Nullable
    public GraphQLLeadGenDeepLinkUserStatus f4357u;
    @Nullable
    public GraphQLLeadGenUserStatus f4358v;
    @Nullable
    public String f4359w;
    @Nullable
    public String f4360x;
    public GraphQLCallToActionStyle f4361y;
    @Nullable
    public String f4362z;

    /* compiled from: feedback_react */
    final class C04201 implements Creator<GraphQLLeadGenActionLink> {
        C04201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLeadGenActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLeadGenActionLink[i];
        }
    }

    /* compiled from: feedback_react */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLeadGenActionLink.class, new Deserializer());
        }

        public Object m8751a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLeadGenActionLinkDeserializer.m5278a(jsonParser, (short) 529);
            Object graphQLLeadGenActionLink = new GraphQLLeadGenActionLink();
            ((BaseModel) graphQLLeadGenActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLeadGenActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLLeadGenActionLink).a();
            }
            return graphQLLeadGenActionLink;
        }
    }

    /* compiled from: feedback_react */
    public final class Serializer extends JsonSerializer<GraphQLLeadGenActionLink> {
        public final void m8752a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLeadGenActionLink graphQLLeadGenActionLink = (GraphQLLeadGenActionLink) obj;
            GraphQLLeadGenActionLinkDeserializer.m5279a(graphQLLeadGenActionLink.w_(), graphQLLeadGenActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLLeadGenActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLLeadGenActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8781a() {
        this.f4340d = super.a(this.f4340d, 0);
        return this.f4340d;
    }

    @FieldOffset
    @Nullable
    public final String m8783j() {
        this.f4341e = super.a(this.f4341e, 1);
        return this.f4341e;
    }

    @FieldOffset
    public final int m8784k() {
        a(0, 2);
        return this.f4342f;
    }

    @FieldOffset
    public final int m8785l() {
        a(0, 3);
        return this.f4343g;
    }

    @FieldOffset
    @Nullable
    public final String m8786m() {
        this.f4344h = super.a(this.f4344h, 4);
        return this.f4344h;
    }

    @FieldOffset
    @Nullable
    public final String m8787n() {
        this.f4345i = super.a(this.f4345i, 5);
        return this.f4345i;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLeadGenErrorNode> m8788o() {
        this.f4346j = super.a(this.f4346j, 6, GraphQLLeadGenErrorNode.class);
        return (ImmutableList) this.f4346j;
    }

    @FieldOffset
    @Nullable
    public final String m8789p() {
        this.f4347k = super.a(this.f4347k, 7);
        return this.f4347k;
    }

    @FieldOffset
    @Nullable
    public final String m8790q() {
        this.f4348l = super.a(this.f4348l, 8);
        return this.f4348l;
    }

    @FieldOffset
    @Nullable
    public final String m8791r() {
        this.f4349m = super.a(this.f4349m, 9);
        return this.f4349m;
    }

    @FieldOffset
    @Nullable
    public final String m8792s() {
        this.f4350n = super.a(this.f4350n, 10);
        return this.f4350n;
    }

    @FieldOffset
    @Nullable
    public final String m8793t() {
        this.f4351o = super.a(this.f4351o, 11);
        return this.f4351o;
    }

    @FieldOffset
    @Nullable
    public final String m8794u() {
        this.f4352p = super.a(this.f4352p, 12);
        return this.f4352p;
    }

    @FieldOffset
    @Nullable
    public final String m8795v() {
        this.f4353q = super.a(this.f4353q, 13);
        return this.f4353q;
    }

    @FieldOffset
    @Nullable
    public final String m8796w() {
        this.f4354r = super.a(this.f4354r, 14);
        return this.f4354r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenData m8797x() {
        this.f4355s = (GraphQLLeadGenData) super.a(this.f4355s, 15, GraphQLLeadGenData.class);
        return this.f4355s;
    }

    @FieldOffset
    @Nullable
    public final String m8798y() {
        this.f4356t = super.a(this.f4356t, 16);
        return this.f4356t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenDeepLinkUserStatus m8799z() {
        this.f4357u = (GraphQLLeadGenDeepLinkUserStatus) super.a(this.f4357u, 17, GraphQLLeadGenDeepLinkUserStatus.class);
        return this.f4357u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenUserStatus m8753A() {
        this.f4358v = (GraphQLLeadGenUserStatus) super.a(this.f4358v, 18, GraphQLLeadGenUserStatus.class);
        return this.f4358v;
    }

    @FieldOffset
    @Nullable
    public final String m8754B() {
        this.f4359w = super.a(this.f4359w, 19);
        return this.f4359w;
    }

    @FieldOffset
    @Nullable
    public final String m8755C() {
        this.f4360x = super.a(this.f4360x, 20);
        return this.f4360x;
    }

    @FieldOffset
    public final GraphQLCallToActionStyle m8756D() {
        this.f4361y = (GraphQLCallToActionStyle) super.a(this.f4361y, 21, GraphQLCallToActionStyle.class, GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4361y;
    }

    @FieldOffset
    @Nullable
    public final String m8757E() {
        this.f4362z = super.a(this.f4362z, 22);
        return this.f4362z;
    }

    @FieldOffset
    public final GraphQLCallToActionType m8758F() {
        this.f4318A = (GraphQLCallToActionType) super.a(this.f4318A, 23, GraphQLCallToActionType.class, GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4318A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8759G() {
        this.f4319B = (GraphQLImage) super.a(this.f4319B, 24, GraphQLImage.class);
        return this.f4319B;
    }

    @FieldOffset
    @Nullable
    public final String m8760H() {
        this.f4320C = super.a(this.f4320C, 25);
        return this.f4320C;
    }

    @FieldOffset
    @Nullable
    public final String m8761I() {
        this.f4321D = super.a(this.f4321D, 26);
        return this.f4321D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m8762J() {
        this.f4322E = (GraphQLPage) super.a(this.f4322E, 27, GraphQLPage.class);
        return this.f4322E;
    }

    @FieldOffset
    @Nullable
    public final String m8763K() {
        this.f4323F = super.a(this.f4323F, 28);
        return this.f4323F;
    }

    @FieldOffset
    @Nullable
    public final String m8764L() {
        this.f4324G = super.a(this.f4324G, 29);
        return this.f4324G;
    }

    @FieldOffset
    @Nullable
    public final String m8765M() {
        this.f4325H = super.a(this.f4325H, 30);
        return this.f4325H;
    }

    @FieldOffset
    @Nullable
    public final String m8766N() {
        this.f4326I = super.a(this.f4326I, 31);
        return this.f4326I;
    }

    @FieldOffset
    @Nullable
    public final String m8767O() {
        this.f4327J = super.a(this.f4327J, 32);
        return this.f4327J;
    }

    @FieldOffset
    @Nullable
    public final String m8768P() {
        this.f4328K = super.a(this.f4328K, 33);
        return this.f4328K;
    }

    @FieldOffset
    @Nullable
    public final String m8769Q() {
        this.f4329L = super.a(this.f4329L, 34);
        return this.f4329L;
    }

    @FieldOffset
    @Nullable
    public final String m8770R() {
        this.f4330M = super.a(this.f4330M, 35);
        return this.f4330M;
    }

    @FieldOffset
    @Nullable
    public final String m8771S() {
        this.f4331N = super.a(this.f4331N, 36);
        return this.f4331N;
    }

    @FieldOffset
    @Nullable
    public final String m8772T() {
        this.f4332O = super.a(this.f4332O, 37);
        return this.f4332O;
    }

    @FieldOffset
    public final boolean m8773U() {
        a(4, 6);
        return this.f4333P;
    }

    @FieldOffset
    @Nullable
    public final String m8774V() {
        this.f4334Q = super.a(this.f4334Q, 39);
        return this.f4334Q;
    }

    @FieldOffset
    @Nullable
    public final String m8775W() {
        this.f4335R = super.a(this.f4335R, 40);
        return this.f4335R;
    }

    @FieldOffset
    @Nullable
    public final String m8776X() {
        this.f4336S = super.a(this.f4336S, 41);
        return this.f4336S;
    }

    @FieldOffset
    @Nullable
    public final String m8777Y() {
        this.f4337T = super.a(this.f4337T, 42);
        return this.f4337T;
    }

    @FieldOffset
    @Nullable
    public final String m8778Z() {
        this.f4338U = super.a(this.f4338U, 43);
        return this.f4338U;
    }

    @FieldOffset
    @Nullable
    public final String aa() {
        this.f4339V = super.a(this.f4339V, 44);
        return this.f4339V;
    }

    public final int jK_() {
        return 1185006756;
    }

    public final GraphQLVisitableModel m8780a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLLeadGenData graphQLLeadGenData;
        GraphQLLeadGenDeepLinkUserStatus graphQLLeadGenDeepLinkUserStatus;
        GraphQLLeadGenUserStatus graphQLLeadGenUserStatus;
        GraphQLImage graphQLImage;
        GraphQLPage graphQLPage;
        h();
        if (m8788o() != null) {
            Builder a = ModelHelper.a(m8788o(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLLeadGenActionLink graphQLLeadGenActionLink = (GraphQLLeadGenActionLink) ModelHelper.a(null, this);
                graphQLLeadGenActionLink.f4346j = a.b();
                graphQLVisitableModel = graphQLLeadGenActionLink;
                if (m8797x() != null) {
                    graphQLLeadGenData = (GraphQLLeadGenData) graphQLModelMutatingVisitor.b(m8797x());
                    if (m8797x() != graphQLLeadGenData) {
                        graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4355s = graphQLLeadGenData;
                    }
                }
                if (m8799z() != null) {
                    graphQLLeadGenDeepLinkUserStatus = (GraphQLLeadGenDeepLinkUserStatus) graphQLModelMutatingVisitor.b(m8799z());
                    if (m8799z() != graphQLLeadGenDeepLinkUserStatus) {
                        graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4357u = graphQLLeadGenDeepLinkUserStatus;
                    }
                }
                if (m8753A() != null) {
                    graphQLLeadGenUserStatus = (GraphQLLeadGenUserStatus) graphQLModelMutatingVisitor.b(m8753A());
                    if (m8753A() != graphQLLeadGenUserStatus) {
                        graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4358v = graphQLLeadGenUserStatus;
                    }
                }
                if (m8759G() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8759G());
                    if (m8759G() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4319B = graphQLImage;
                    }
                }
                if (m8762J() != null) {
                    graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m8762J());
                    if (m8762J() != graphQLPage) {
                        graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4322E = graphQLPage;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m8797x() != null) {
            graphQLLeadGenData = (GraphQLLeadGenData) graphQLModelMutatingVisitor.b(m8797x());
            if (m8797x() != graphQLLeadGenData) {
                graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4355s = graphQLLeadGenData;
            }
        }
        if (m8799z() != null) {
            graphQLLeadGenDeepLinkUserStatus = (GraphQLLeadGenDeepLinkUserStatus) graphQLModelMutatingVisitor.b(m8799z());
            if (m8799z() != graphQLLeadGenDeepLinkUserStatus) {
                graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4357u = graphQLLeadGenDeepLinkUserStatus;
            }
        }
        if (m8753A() != null) {
            graphQLLeadGenUserStatus = (GraphQLLeadGenUserStatus) graphQLModelMutatingVisitor.b(m8753A());
            if (m8753A() != graphQLLeadGenUserStatus) {
                graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4358v = graphQLLeadGenUserStatus;
            }
        }
        if (m8759G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8759G());
            if (m8759G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4319B = graphQLImage;
            }
        }
        if (m8762J() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m8762J());
            if (m8762J() != graphQLPage) {
                graphQLVisitableModel = (GraphQLLeadGenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4322E = graphQLPage;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLLeadGenActionLink() {
        super(46);
    }

    public final void m8782a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4342f = mutableFlatBuffer.a(i, 2, 0);
        this.f4343g = mutableFlatBuffer.a(i, 3, 0);
        this.f4333P = mutableFlatBuffer.a(i, 38);
    }

    public final int m8779a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8781a());
        int b2 = flatBufferBuilder.b(m8783j());
        int b3 = flatBufferBuilder.b(m8786m());
        int b4 = flatBufferBuilder.b(m8787n());
        int a = ModelHelper.a(flatBufferBuilder, m8788o());
        int b5 = flatBufferBuilder.b(m8789p());
        int b6 = flatBufferBuilder.b(m8790q());
        int b7 = flatBufferBuilder.b(m8791r());
        int b8 = flatBufferBuilder.b(m8792s());
        int b9 = flatBufferBuilder.b(m8793t());
        int b10 = flatBufferBuilder.b(m8794u());
        int b11 = flatBufferBuilder.b(m8795v());
        int b12 = flatBufferBuilder.b(m8796w());
        int a2 = ModelHelper.a(flatBufferBuilder, m8797x());
        int b13 = flatBufferBuilder.b(m8798y());
        int a3 = ModelHelper.a(flatBufferBuilder, m8799z());
        int a4 = ModelHelper.a(flatBufferBuilder, m8753A());
        int b14 = flatBufferBuilder.b(m8754B());
        int b15 = flatBufferBuilder.b(m8755C());
        int b16 = flatBufferBuilder.b(m8757E());
        int a5 = ModelHelper.a(flatBufferBuilder, m8759G());
        int b17 = flatBufferBuilder.b(m8760H());
        int b18 = flatBufferBuilder.b(m8761I());
        int a6 = ModelHelper.a(flatBufferBuilder, m8762J());
        int b19 = flatBufferBuilder.b(m8763K());
        int b20 = flatBufferBuilder.b(m8764L());
        int b21 = flatBufferBuilder.b(m8765M());
        int b22 = flatBufferBuilder.b(m8766N());
        int b23 = flatBufferBuilder.b(m8767O());
        int b24 = flatBufferBuilder.b(m8768P());
        int b25 = flatBufferBuilder.b(m8769Q());
        int b26 = flatBufferBuilder.b(m8770R());
        int b27 = flatBufferBuilder.b(m8771S());
        int b28 = flatBufferBuilder.b(m8772T());
        int b29 = flatBufferBuilder.b(m8774V());
        int b30 = flatBufferBuilder.b(m8775W());
        int b31 = flatBufferBuilder.b(m8776X());
        int b32 = flatBufferBuilder.b(m8777Y());
        int b33 = flatBufferBuilder.b(m8778Z());
        int b34 = flatBufferBuilder.b(aa());
        flatBufferBuilder.c(45);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, m8784k(), 0);
        flatBufferBuilder.a(3, m8785l(), 0);
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, b4);
        flatBufferBuilder.b(6, a);
        flatBufferBuilder.b(7, b5);
        flatBufferBuilder.b(8, b6);
        flatBufferBuilder.b(9, b7);
        flatBufferBuilder.b(10, b8);
        flatBufferBuilder.b(11, b9);
        flatBufferBuilder.b(12, b10);
        flatBufferBuilder.b(13, b11);
        flatBufferBuilder.b(14, b12);
        flatBufferBuilder.b(15, a2);
        flatBufferBuilder.b(16, b13);
        flatBufferBuilder.b(17, a3);
        flatBufferBuilder.b(18, a4);
        flatBufferBuilder.b(19, b14);
        flatBufferBuilder.b(20, b15);
        flatBufferBuilder.a(21, m8756D() == GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8756D());
        flatBufferBuilder.b(22, b16);
        flatBufferBuilder.a(23, m8758F() == GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8758F());
        flatBufferBuilder.b(24, a5);
        flatBufferBuilder.b(25, b17);
        flatBufferBuilder.b(26, b18);
        flatBufferBuilder.b(27, a6);
        flatBufferBuilder.b(28, b19);
        flatBufferBuilder.b(29, b20);
        flatBufferBuilder.b(30, b21);
        flatBufferBuilder.b(31, b22);
        flatBufferBuilder.b(32, b23);
        flatBufferBuilder.b(33, b24);
        flatBufferBuilder.b(34, b25);
        flatBufferBuilder.b(35, b26);
        flatBufferBuilder.b(36, b27);
        flatBufferBuilder.b(37, b28);
        flatBufferBuilder.a(38, m8773U());
        flatBufferBuilder.b(39, b29);
        flatBufferBuilder.b(40, b30);
        flatBufferBuilder.b(41, b31);
        flatBufferBuilder.b(42, b32);
        flatBufferBuilder.b(43, b33);
        flatBufferBuilder.b(44, b34);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLeadGenActionLink(Parcel parcel) {
        super(46);
        this.f4340d = parcel.readString();
        this.f4341e = parcel.readString();
        this.f4342f = parcel.readInt();
        this.f4343g = parcel.readInt();
        this.f4344h = parcel.readString();
        this.f4345i = parcel.readString();
        this.f4346j = ImmutableListHelper.a(parcel.readArrayList(GraphQLLeadGenErrorNode.class.getClassLoader()));
        this.f4347k = parcel.readString();
        this.f4348l = parcel.readString();
        this.f4349m = parcel.readString();
        this.f4350n = parcel.readString();
        this.f4351o = parcel.readString();
        this.f4352p = parcel.readString();
        this.f4353q = parcel.readString();
        this.f4354r = parcel.readString();
        this.f4355s = (GraphQLLeadGenData) parcel.readValue(GraphQLLeadGenData.class.getClassLoader());
        this.f4356t = parcel.readString();
        this.f4357u = (GraphQLLeadGenDeepLinkUserStatus) parcel.readValue(GraphQLLeadGenDeepLinkUserStatus.class.getClassLoader());
        this.f4358v = (GraphQLLeadGenUserStatus) parcel.readValue(GraphQLLeadGenUserStatus.class.getClassLoader());
        this.f4359w = parcel.readString();
        this.f4360x = parcel.readString();
        this.f4361y = GraphQLCallToActionStyle.fromString(parcel.readString());
        this.f4362z = parcel.readString();
        this.f4318A = GraphQLCallToActionType.fromString(parcel.readString());
        this.f4319B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4320C = parcel.readString();
        this.f4321D = parcel.readString();
        this.f4322E = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f4323F = parcel.readString();
        this.f4324G = parcel.readString();
        this.f4325H = parcel.readString();
        this.f4326I = parcel.readString();
        this.f4327J = parcel.readString();
        this.f4328K = parcel.readString();
        this.f4329L = parcel.readString();
        this.f4330M = parcel.readString();
        this.f4331N = parcel.readString();
        this.f4332O = parcel.readString();
        this.f4333P = parcel.readByte() == (byte) 1;
        this.f4334Q = parcel.readString();
        this.f4335R = parcel.readString();
        this.f4336S = parcel.readString();
        this.f4337T = parcel.readString();
        this.f4338U = parcel.readString();
        this.f4339V = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8781a());
        parcel.writeString(m8783j());
        parcel.writeInt(m8784k());
        parcel.writeInt(m8785l());
        parcel.writeString(m8786m());
        parcel.writeString(m8787n());
        parcel.writeList(m8788o());
        parcel.writeString(m8789p());
        parcel.writeString(m8790q());
        parcel.writeString(m8791r());
        parcel.writeString(m8792s());
        parcel.writeString(m8793t());
        parcel.writeString(m8794u());
        parcel.writeString(m8795v());
        parcel.writeString(m8796w());
        parcel.writeValue(m8797x());
        parcel.writeString(m8798y());
        parcel.writeValue(m8799z());
        parcel.writeValue(m8753A());
        parcel.writeString(m8754B());
        parcel.writeString(m8755C());
        parcel.writeString(m8756D().name());
        parcel.writeString(m8757E());
        parcel.writeString(m8758F().name());
        parcel.writeValue(m8759G());
        parcel.writeString(m8760H());
        parcel.writeString(m8761I());
        parcel.writeValue(m8762J());
        parcel.writeString(m8763K());
        parcel.writeString(m8764L());
        parcel.writeString(m8765M());
        parcel.writeString(m8766N());
        parcel.writeString(m8767O());
        parcel.writeString(m8768P());
        parcel.writeString(m8769Q());
        parcel.writeString(m8770R());
        parcel.writeString(m8771S());
        parcel.writeString(m8772T());
        parcel.writeByte((byte) (m8773U() ? 1 : 0));
        parcel.writeString(m8774V());
        parcel.writeString(m8775W());
        parcel.writeString(m8776X());
        parcel.writeString(m8777Y());
        parcel.writeString(m8778Z());
        parcel.writeString(aa());
    }
}
