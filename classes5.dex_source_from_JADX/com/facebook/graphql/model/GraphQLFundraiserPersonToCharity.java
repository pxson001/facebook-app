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
import com.facebook.graphql.deserializers.GraphQLFundraiserPersonToCharityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: group_permalink_actions */
public final class GraphQLFundraiserPersonToCharity extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFundraiserPersonToCharity> CREATOR = new C03351();
    @Nullable
    public GraphQLImage f3799A;
    @Nullable
    public GraphQLImage f3800B;
    @Nullable
    public GraphQLImage f3801C;
    @Nullable
    public GraphQLImage f3802D;
    @Nullable
    public GraphQLImage f3803E;
    @Nullable
    public GraphQLPhoto f3804F;
    @Nullable
    public GraphQLImage f3805G;
    public boolean f3806H;
    @Nullable
    public GraphQLStreamingImage f3807I;
    @Nullable
    public GraphQLImage f3808J;
    @Nullable
    public String f3809d;
    @Nullable
    public String f3810e;
    @Nullable
    public String f3811f;
    @Nullable
    public GraphQLFundraiserCharity f3812g;
    @Nullable
    public GraphQLTextWithEntities f3813h;
    @Nullable
    public GraphQLImage f3814i;
    @Nullable
    public String f3815j;
    @Nullable
    public GraphQLActor f3816k;
    @Nullable
    public GraphQLPhoto f3817l;
    @Nullable
    public String f3818m;
    @Nullable
    public String f3819n;
    public boolean f3820o;
    public double f3821p;
    public boolean f3822q;
    @Nullable
    public GraphQLTextWithEntities f3823r;
    @Nullable
    public GraphQLFundraiserPersonToCharityDonorsConnection f3824s;
    @Nullable
    public String f3825t;
    @Nullable
    public GraphQLTextWithEntities f3826u;
    public boolean f3827v;
    @Nullable
    public GraphQLImage f3828w;
    @Nullable
    public GraphQLImage f3829x;
    @Deprecated
    @Nullable
    public GraphQLInlineActivitiesConnection f3830y;
    @Nullable
    public String f3831z;

    /* compiled from: group_permalink_actions */
    final class C03351 implements Creator<GraphQLFundraiserPersonToCharity> {
        C03351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFundraiserPersonToCharity(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFundraiserPersonToCharity[i];
        }
    }

    /* compiled from: group_permalink_actions */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFundraiserPersonToCharity.class, new Deserializer());
        }

        public Object m7685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFundraiserPersonToCharityDeserializer.m4982a(jsonParser, (short) 512);
            Object graphQLFundraiserPersonToCharity = new GraphQLFundraiserPersonToCharity();
            ((BaseModel) graphQLFundraiserPersonToCharity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFundraiserPersonToCharity instanceof Postprocessable) {
                return ((Postprocessable) graphQLFundraiserPersonToCharity).a();
            }
            return graphQLFundraiserPersonToCharity;
        }
    }

    /* compiled from: group_permalink_actions */
    public final class Serializer extends JsonSerializer<GraphQLFundraiserPersonToCharity> {
        public final void m7686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFundraiserPersonToCharity graphQLFundraiserPersonToCharity = (GraphQLFundraiserPersonToCharity) obj;
            GraphQLFundraiserPersonToCharityDeserializer.m4983a(graphQLFundraiserPersonToCharity.w_(), graphQLFundraiserPersonToCharity.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFundraiserPersonToCharity.class, new Serializer());
            FbSerializerProvider.a(GraphQLFundraiserPersonToCharity.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m7707j() {
        this.f3809d = super.a(this.f3809d, 0);
        return this.f3809d;
    }

    @FieldOffset
    @Nullable
    public final String m7708k() {
        this.f3810e = super.a(this.f3810e, 1);
        return this.f3810e;
    }

    @FieldOffset
    @Nullable
    public final String m7709l() {
        this.f3811f = super.a(this.f3811f, 2);
        return this.f3811f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFundraiserCharity m7710m() {
        this.f3812g = (GraphQLFundraiserCharity) super.a(this.f3812g, 3, GraphQLFundraiserCharity.class);
        return this.f3812g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7711n() {
        this.f3813h = (GraphQLTextWithEntities) super.a(this.f3813h, 4, GraphQLTextWithEntities.class);
        return this.f3813h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7712o() {
        this.f3814i = (GraphQLImage) super.a(this.f3814i, 5, GraphQLImage.class);
        return this.f3814i;
    }

    @FieldOffset
    @Nullable
    public final String m7713p() {
        this.f3815j = super.a(this.f3815j, 6);
        return this.f3815j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7714q() {
        this.f3816k = (GraphQLActor) super.a(this.f3816k, 7, GraphQLActor.class);
        return this.f3816k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m7715r() {
        this.f3817l = (GraphQLPhoto) super.a(this.f3817l, 8, GraphQLPhoto.class);
        return this.f3817l;
    }

    @FieldOffset
    @Nullable
    public final String m7716s() {
        this.f3818m = super.a(this.f3818m, 9);
        return this.f3818m;
    }

    @FieldOffset
    @Nullable
    public final String m7717t() {
        this.f3819n = super.a(this.f3819n, 10);
        return this.f3819n;
    }

    @FieldOffset
    public final boolean m7718u() {
        a(1, 3);
        return this.f3820o;
    }

    @FieldOffset
    public final double m7719v() {
        a(1, 4);
        return this.f3821p;
    }

    @FieldOffset
    public final boolean m7720w() {
        a(1, 5);
        return this.f3822q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7721x() {
        this.f3823r = (GraphQLTextWithEntities) super.a(this.f3823r, 14, GraphQLTextWithEntities.class);
        return this.f3823r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFundraiserPersonToCharityDonorsConnection m7722y() {
        this.f3824s = (GraphQLFundraiserPersonToCharityDonorsConnection) super.a(this.f3824s, 15, GraphQLFundraiserPersonToCharityDonorsConnection.class);
        return this.f3824s;
    }

    @FieldOffset
    @Nullable
    public final String m7723z() {
        this.f3825t = super.a(this.f3825t, 16);
        return this.f3825t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7687A() {
        this.f3826u = (GraphQLTextWithEntities) super.a(this.f3826u, 18, GraphQLTextWithEntities.class);
        return this.f3826u;
    }

    @FieldOffset
    public final boolean m7688B() {
        a(2, 3);
        return this.f3827v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7689C() {
        this.f3828w = (GraphQLImage) super.a(this.f3828w, 20, GraphQLImage.class);
        return this.f3828w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7690D() {
        this.f3829x = (GraphQLImage) super.a(this.f3829x, 21, GraphQLImage.class);
        return this.f3829x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m7691E() {
        this.f3830y = (GraphQLInlineActivitiesConnection) super.a(this.f3830y, 22, GraphQLInlineActivitiesConnection.class);
        return this.f3830y;
    }

    @FieldOffset
    @Nullable
    public final String m7692F() {
        this.f3831z = super.a(this.f3831z, 23);
        return this.f3831z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7693G() {
        this.f3799A = (GraphQLImage) super.a(this.f3799A, 24, GraphQLImage.class);
        return this.f3799A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7694H() {
        this.f3800B = (GraphQLImage) super.a(this.f3800B, 25, GraphQLImage.class);
        return this.f3800B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7695I() {
        this.f3801C = (GraphQLImage) super.a(this.f3801C, 26, GraphQLImage.class);
        return this.f3801C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7696J() {
        this.f3802D = (GraphQLImage) super.a(this.f3802D, 27, GraphQLImage.class);
        return this.f3802D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7697K() {
        this.f3803E = (GraphQLImage) super.a(this.f3803E, 28, GraphQLImage.class);
        return this.f3803E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m7698L() {
        this.f3804F = (GraphQLPhoto) super.a(this.f3804F, 29, GraphQLPhoto.class);
        return this.f3804F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7699M() {
        this.f3805G = (GraphQLImage) super.a(this.f3805G, 30, GraphQLImage.class);
        return this.f3805G;
    }

    @FieldOffset
    public final boolean m7700N() {
        a(3, 7);
        return this.f3806H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m7701O() {
        this.f3807I = (GraphQLStreamingImage) super.a(this.f3807I, 32, GraphQLStreamingImage.class);
        return this.f3807I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7702P() {
        this.f3808J = (GraphQLImage) super.a(this.f3808J, 33, GraphQLImage.class);
        return this.f3808J;
    }

    @Nullable
    public final String m7705a() {
        return m7707j();
    }

    public final int jK_() {
        return -1315407331;
    }

    public final GraphQLVisitableModel m7704a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLPhoto graphQLPhoto;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7710m() != null) {
            GraphQLFundraiserCharity graphQLFundraiserCharity = (GraphQLFundraiserCharity) graphQLModelMutatingVisitor.b(m7710m());
            if (m7710m() != graphQLFundraiserCharity) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(null, this);
                graphQLVisitableModel.f3812g = graphQLFundraiserCharity;
            }
        }
        if (m7722y() != null) {
            GraphQLFundraiserPersonToCharityDonorsConnection graphQLFundraiserPersonToCharityDonorsConnection = (GraphQLFundraiserPersonToCharityDonorsConnection) graphQLModelMutatingVisitor.b(m7722y());
            if (m7722y() != graphQLFundraiserPersonToCharityDonorsConnection) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3824s = graphQLFundraiserPersonToCharityDonorsConnection;
            }
        }
        if (m7689C() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7689C());
            if (m7689C() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3828w = graphQLImage;
            }
        }
        if (m7687A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7687A());
            if (m7687A() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3826u = graphQLTextWithEntities;
            }
        }
        if (m7711n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7711n());
            if (m7711n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3813h = graphQLTextWithEntities;
            }
        }
        if (m7721x() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7721x());
            if (m7721x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3823r = graphQLTextWithEntities;
            }
        }
        if (m7715r() != null) {
            graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m7715r());
            if (m7715r() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3817l = graphQLPhoto;
            }
        }
        if (m7690D() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7690D());
            if (m7690D() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3829x = graphQLImage;
            }
        }
        if (m7691E() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.b(m7691E());
            if (m7691E() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3830y = graphQLInlineActivitiesConnection;
            }
        }
        if (m7712o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7712o());
            if (m7712o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3814i = graphQLImage;
            }
        }
        if (m7714q() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7714q());
            if (m7714q() != graphQLActor) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3816k = graphQLActor;
            }
        }
        if (m7693G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7693G());
            if (m7693G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3799A = graphQLImage;
            }
        }
        if (m7694H() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7694H());
            if (m7694H() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3800B = graphQLImage;
            }
        }
        if (m7695I() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7695I());
            if (m7695I() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3801C = graphQLImage;
            }
        }
        if (m7696J() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7696J());
            if (m7696J() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3802D = graphQLImage;
            }
        }
        if (m7697K() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7697K());
            if (m7697K() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3803E = graphQLImage;
            }
        }
        if (m7698L() != null) {
            graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m7698L());
            if (m7698L() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3804F = graphQLPhoto;
            }
        }
        if (m7699M() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7699M());
            if (m7699M() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3805G = graphQLImage;
            }
        }
        if (m7701O() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.b(m7701O());
            if (m7701O() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3807I = graphQLStreamingImage;
            }
        }
        if (m7702P() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7702P());
            if (m7702P() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3808J = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFundraiserPersonToCharity() {
        super(35);
    }

    public final void m7706a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3820o = mutableFlatBuffer.a(i, 11);
        this.f3821p = mutableFlatBuffer.a(i, 12, 0.0d);
        this.f3822q = mutableFlatBuffer.a(i, 13);
        this.f3827v = mutableFlatBuffer.a(i, 19);
        this.f3806H = mutableFlatBuffer.a(i, 31);
    }

    public final int m7703a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7707j());
        int b2 = flatBufferBuilder.b(m7708k());
        int b3 = flatBufferBuilder.b(m7709l());
        int a = ModelHelper.a(flatBufferBuilder, m7710m());
        int a2 = ModelHelper.a(flatBufferBuilder, m7711n());
        int a3 = ModelHelper.a(flatBufferBuilder, m7712o());
        int b4 = flatBufferBuilder.b(m7713p());
        int a4 = ModelHelper.a(flatBufferBuilder, m7714q());
        int a5 = ModelHelper.a(flatBufferBuilder, m7715r());
        int b5 = flatBufferBuilder.b(m7716s());
        int b6 = flatBufferBuilder.b(m7717t());
        int a6 = ModelHelper.a(flatBufferBuilder, m7721x());
        int a7 = ModelHelper.a(flatBufferBuilder, m7722y());
        int b7 = flatBufferBuilder.b(m7723z());
        int a8 = ModelHelper.a(flatBufferBuilder, m7687A());
        int a9 = ModelHelper.a(flatBufferBuilder, m7689C());
        int a10 = ModelHelper.a(flatBufferBuilder, m7690D());
        int a11 = ModelHelper.a(flatBufferBuilder, m7691E());
        int b8 = flatBufferBuilder.b(m7692F());
        int a12 = ModelHelper.a(flatBufferBuilder, m7693G());
        int a13 = ModelHelper.a(flatBufferBuilder, m7694H());
        int a14 = ModelHelper.a(flatBufferBuilder, m7695I());
        int a15 = ModelHelper.a(flatBufferBuilder, m7696J());
        int a16 = ModelHelper.a(flatBufferBuilder, m7697K());
        int a17 = ModelHelper.a(flatBufferBuilder, m7698L());
        int a18 = ModelHelper.a(flatBufferBuilder, m7699M());
        int a19 = ModelHelper.a(flatBufferBuilder, m7701O());
        int a20 = ModelHelper.a(flatBufferBuilder, m7702P());
        flatBufferBuilder.c(34);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.b(3, a);
        flatBufferBuilder.b(4, a2);
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.b(6, b4);
        flatBufferBuilder.b(7, a4);
        flatBufferBuilder.b(8, a5);
        flatBufferBuilder.b(9, b5);
        flatBufferBuilder.b(10, b6);
        flatBufferBuilder.a(11, m7718u());
        flatBufferBuilder.a(12, m7719v(), 0.0d);
        flatBufferBuilder.a(13, m7720w());
        flatBufferBuilder.b(14, a6);
        flatBufferBuilder.b(15, a7);
        flatBufferBuilder.b(16, b7);
        flatBufferBuilder.b(18, a8);
        flatBufferBuilder.a(19, m7688B());
        flatBufferBuilder.b(20, a9);
        flatBufferBuilder.b(21, a10);
        flatBufferBuilder.b(22, a11);
        flatBufferBuilder.b(23, b8);
        flatBufferBuilder.b(24, a12);
        flatBufferBuilder.b(25, a13);
        flatBufferBuilder.b(26, a14);
        flatBufferBuilder.b(27, a15);
        flatBufferBuilder.b(28, a16);
        flatBufferBuilder.b(29, a17);
        flatBufferBuilder.b(30, a18);
        flatBufferBuilder.a(31, m7700N());
        flatBufferBuilder.b(32, a19);
        flatBufferBuilder.b(33, a20);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFundraiserPersonToCharity(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(35);
        this.f3818m = parcel.readString();
        this.f3819n = parcel.readString();
        this.f3811f = parcel.readString();
        this.f3822q = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3827v = z;
        this.f3812g = (GraphQLFundraiserCharity) parcel.readValue(GraphQLFundraiserCharity.class.getClassLoader());
        this.f3824s = (GraphQLFundraiserPersonToCharityDonorsConnection) parcel.readValue(GraphQLFundraiserPersonToCharityDonorsConnection.class.getClassLoader());
        this.f3828w = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3826u = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3813h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3823r = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3820o = z;
        this.f3817l = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f3809d = parcel.readString();
        this.f3829x = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3830y = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f3814i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3815j = parcel.readString();
        this.f3831z = parcel.readString();
        this.f3816k = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f3821p = parcel.readDouble();
        this.f3799A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3800B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3801C = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3802D = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3803E = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3804F = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f3805G = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f3806H = z2;
        this.f3825t = parcel.readString();
        this.f3807I = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f3808J = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3810e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m7716s());
        parcel.writeString(m7717t());
        parcel.writeString(m7709l());
        parcel.writeByte((byte) (m7720w() ? 1 : 0));
        if (m7688B()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m7710m());
        parcel.writeValue(m7722y());
        parcel.writeValue(m7689C());
        parcel.writeValue(m7687A());
        parcel.writeValue(m7711n());
        parcel.writeValue(m7721x());
        if (m7718u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m7715r());
        parcel.writeString(m7707j());
        parcel.writeValue(m7690D());
        parcel.writeValue(m7691E());
        parcel.writeValue(m7712o());
        parcel.writeString(m7713p());
        parcel.writeString(m7692F());
        parcel.writeValue(m7714q());
        parcel.writeDouble(m7719v());
        parcel.writeValue(m7693G());
        parcel.writeValue(m7694H());
        parcel.writeValue(m7695I());
        parcel.writeValue(m7696J());
        parcel.writeValue(m7697K());
        parcel.writeValue(m7698L());
        parcel.writeValue(m7699M());
        if (!m7700N()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m7723z());
        parcel.writeValue(m7701O());
        parcel.writeValue(m7702P());
        parcel.writeString(m7708k());
    }
}
