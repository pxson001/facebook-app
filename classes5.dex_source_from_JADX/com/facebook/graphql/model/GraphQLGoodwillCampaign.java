package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillCampaignDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: greeting_card */
public final class GraphQLGoodwillCampaign extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillCampaign> CREATOR = new C03451();
    List<GraphQLImageOverlay> f3879A;
    @Nullable
    GraphQLObjectType f3880d;
    @Nullable
    GraphQLProfile f3881e;
    @Nullable
    GraphQLGoodwillThrowbackDataPointsConnection f3882f;
    List<GraphQLStoryAttachment> f3883g;
    @Nullable
    GraphQLTextWithEntities f3884h;
    @Nullable
    GraphQLImage f3885i;
    @Nullable
    GraphQLImage f3886j;
    @Nullable
    GraphQLTextWithEntities f3887k;
    @Nullable
    GraphQLTextWithEntities f3888l;
    @Nullable
    GraphQLUser f3889m;
    @Nullable
    String f3890n;
    List<GraphQLStoryAttachment> f3891o;
    @Nullable
    GraphQLGoodwillBirthdayCampaignPostingActorsConnection f3892p;
    @Nullable
    GraphQLTextWithEntities f3893q;
    @Nullable
    GraphQLTextWithEntities f3894r;
    @Nullable
    GraphQLImage f3895s;
    @Nullable
    GraphQLTextWithEntities f3896t;
    @Nullable
    GraphQLTextWithEntities f3897u;
    @Nullable
    String f3898v;
    @Nullable
    GraphQLTextWithEntities f3899w;
    @Nullable
    GraphQLTextWithEntities f3900x;
    @Nullable
    GraphQLTextWithEntities f3901y;
    @Nullable
    GraphQLGoodwillVideoCampaign f3902z;

    /* compiled from: greeting_card */
    final class C03451 implements Creator<GraphQLGoodwillCampaign> {
        C03451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillCampaign(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillCampaign[i];
        }
    }

    /* compiled from: greeting_card */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillCampaign.class, new Deserializer());
        }

        public Object m7820a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillCampaignDeserializer.m5009a(jsonParser, (short) 505);
            Object graphQLGoodwillCampaign = new GraphQLGoodwillCampaign();
            ((BaseModel) graphQLGoodwillCampaign).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillCampaign instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillCampaign).a();
            }
            return graphQLGoodwillCampaign;
        }
    }

    /* compiled from: greeting_card */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillCampaign> {
        public final void m7821a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillCampaign graphQLGoodwillCampaign = (GraphQLGoodwillCampaign) obj;
            GraphQLGoodwillCampaignDeserializer.m5010b(graphQLGoodwillCampaign.w_(), graphQLGoodwillCampaign.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillCampaign.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillCampaign.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m7832j() {
        if (this.b != null && this.f3880d == null) {
            this.f3880d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f3880d == null || this.f3880d.g() != 0) {
            return this.f3880d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m7833k() {
        this.f3881e = (GraphQLProfile) super.a(this.f3881e, 1, GraphQLProfile.class);
        return this.f3881e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackDataPointsConnection m7834l() {
        this.f3882f = (GraphQLGoodwillThrowbackDataPointsConnection) super.a(this.f3882f, 2, GraphQLGoodwillThrowbackDataPointsConnection.class);
        return this.f3882f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7835m() {
        this.f3883g = super.a(this.f3883g, 3, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3883g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7836n() {
        this.f3884h = (GraphQLTextWithEntities) super.a(this.f3884h, 4, GraphQLTextWithEntities.class);
        return this.f3884h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7837o() {
        this.f3885i = (GraphQLImage) super.a(this.f3885i, 5, GraphQLImage.class);
        return this.f3885i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7838p() {
        this.f3886j = (GraphQLImage) super.a(this.f3886j, 6, GraphQLImage.class);
        return this.f3886j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7839q() {
        this.f3887k = (GraphQLTextWithEntities) super.a(this.f3887k, 7, GraphQLTextWithEntities.class);
        return this.f3887k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7840r() {
        this.f3888l = (GraphQLTextWithEntities) super.a(this.f3888l, 8, GraphQLTextWithEntities.class);
        return this.f3888l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m7841s() {
        this.f3889m = (GraphQLUser) super.a(this.f3889m, 9, GraphQLUser.class);
        return this.f3889m;
    }

    @FieldOffset
    @Nullable
    public final String m7842t() {
        this.f3890n = super.a(this.f3890n, 10);
        return this.f3890n;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7843u() {
        this.f3891o = super.a(this.f3891o, 11, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3891o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillBirthdayCampaignPostingActorsConnection m7844v() {
        this.f3892p = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) super.a(this.f3892p, 12, GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class);
        return this.f3892p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7845w() {
        this.f3893q = (GraphQLTextWithEntities) super.a(this.f3893q, 13, GraphQLTextWithEntities.class);
        return this.f3893q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7846x() {
        this.f3894r = (GraphQLTextWithEntities) super.a(this.f3894r, 14, GraphQLTextWithEntities.class);
        return this.f3894r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7847y() {
        this.f3895s = (GraphQLImage) super.a(this.f3895s, 15, GraphQLImage.class);
        return this.f3895s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7848z() {
        this.f3896t = (GraphQLTextWithEntities) super.a(this.f3896t, 16, GraphQLTextWithEntities.class);
        return this.f3896t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7822A() {
        this.f3897u = (GraphQLTextWithEntities) super.a(this.f3897u, 17, GraphQLTextWithEntities.class);
        return this.f3897u;
    }

    @FieldOffset
    @Nullable
    public final String m7823B() {
        this.f3898v = super.a(this.f3898v, 18);
        return this.f3898v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7824C() {
        this.f3899w = (GraphQLTextWithEntities) super.a(this.f3899w, 19, GraphQLTextWithEntities.class);
        return this.f3899w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7825D() {
        this.f3900x = (GraphQLTextWithEntities) super.a(this.f3900x, 20, GraphQLTextWithEntities.class);
        return this.f3900x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7826E() {
        this.f3901y = (GraphQLTextWithEntities) super.a(this.f3901y, 21, GraphQLTextWithEntities.class);
        return this.f3901y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillVideoCampaign m7827F() {
        this.f3902z = (GraphQLGoodwillVideoCampaign) super.a(this.f3902z, 22, GraphQLGoodwillVideoCampaign.class);
        return this.f3902z;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImageOverlay> m7828G() {
        this.f3879A = super.a(this.f3879A, 23, GraphQLImageOverlay.class);
        return (ImmutableList) this.f3879A;
    }

    @Nullable
    public final String m7831a() {
        return m7842t();
    }

    public final int jK_() {
        return -592464801;
    }

    public final GraphQLVisitableModel m7830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7833k() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m7833k());
            if (m7833k() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(null, this);
                graphQLVisitableModel.f3881e = graphQLProfile;
            }
        }
        if (m7834l() != null) {
            GraphQLGoodwillThrowbackDataPointsConnection graphQLGoodwillThrowbackDataPointsConnection = (GraphQLGoodwillThrowbackDataPointsConnection) graphQLModelMutatingVisitor.b(m7834l());
            if (m7834l() != graphQLGoodwillThrowbackDataPointsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3882f = graphQLGoodwillThrowbackDataPointsConnection;
            }
        }
        if (m7835m() != null) {
            a = ModelHelper.a(m7835m(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillCampaign graphQLGoodwillCampaign = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillCampaign.f3883g = a.b();
                graphQLVisitableModel = graphQLGoodwillCampaign;
            }
        }
        if (m7836n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7836n());
            if (m7836n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3884h = graphQLTextWithEntities;
            }
        }
        if (m7837o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7837o());
            if (m7837o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3885i = graphQLImage;
            }
        }
        if (m7838p() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7838p());
            if (m7838p() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3886j = graphQLImage;
            }
        }
        if (m7839q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7839q());
            if (m7839q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3887k = graphQLTextWithEntities;
            }
        }
        if (m7840r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7840r());
            if (m7840r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3888l = graphQLTextWithEntities;
            }
        }
        if (m7841s() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m7841s());
            if (m7841s() != graphQLUser) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3889m = graphQLUser;
            }
        }
        if (m7828G() != null) {
            a = ModelHelper.a(m7828G(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillCampaign = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillCampaign.f3879A = a.b();
                graphQLVisitableModel = graphQLGoodwillCampaign;
            }
        }
        if (m7843u() != null) {
            a = ModelHelper.a(m7843u(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillCampaign = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillCampaign.f3891o = a.b();
                graphQLVisitableModel = graphQLGoodwillCampaign;
            }
        }
        if (m7844v() != null) {
            GraphQLGoodwillBirthdayCampaignPostingActorsConnection graphQLGoodwillBirthdayCampaignPostingActorsConnection = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) graphQLModelMutatingVisitor.b(m7844v());
            if (m7844v() != graphQLGoodwillBirthdayCampaignPostingActorsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3892p = graphQLGoodwillBirthdayCampaignPostingActorsConnection;
            }
        }
        if (m7845w() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7845w());
            if (m7845w() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3893q = graphQLTextWithEntities;
            }
        }
        if (m7846x() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7846x());
            if (m7846x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3894r = graphQLTextWithEntities;
            }
        }
        if (m7847y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7847y());
            if (m7847y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3895s = graphQLImage;
            }
        }
        if (m7848z() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7848z());
            if (m7848z() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3896t = graphQLTextWithEntities;
            }
        }
        if (m7822A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7822A());
            if (m7822A() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3897u = graphQLTextWithEntities;
            }
        }
        if (m7824C() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7824C());
            if (m7824C() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3899w = graphQLTextWithEntities;
            }
        }
        if (m7825D() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7825D());
            if (m7825D() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3900x = graphQLTextWithEntities;
            }
        }
        if (m7826E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7826E());
            if (m7826E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3901y = graphQLTextWithEntities;
            }
        }
        if (m7827F() != null) {
            GraphQLGoodwillVideoCampaign graphQLGoodwillVideoCampaign = (GraphQLGoodwillVideoCampaign) graphQLModelMutatingVisitor.b(m7827F());
            if (m7827F() != graphQLGoodwillVideoCampaign) {
                graphQLVisitableModel = (GraphQLGoodwillCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3902z = graphQLGoodwillVideoCampaign;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillCampaign() {
        super(25);
    }

    public final int m7829a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m7832j() != null ? m7832j().e() : null);
        int a2 = ModelHelper.a(flatBufferBuilder, m7833k());
        int a3 = ModelHelper.a(flatBufferBuilder, m7834l());
        int a4 = ModelHelper.a(flatBufferBuilder, m7835m());
        int a5 = ModelHelper.a(flatBufferBuilder, m7836n());
        int a6 = ModelHelper.a(flatBufferBuilder, m7837o());
        int a7 = ModelHelper.a(flatBufferBuilder, m7838p());
        int a8 = ModelHelper.a(flatBufferBuilder, m7839q());
        int a9 = ModelHelper.a(flatBufferBuilder, m7840r());
        int a10 = ModelHelper.a(flatBufferBuilder, m7841s());
        int b = flatBufferBuilder.b(m7842t());
        int a11 = ModelHelper.a(flatBufferBuilder, m7843u());
        int a12 = ModelHelper.a(flatBufferBuilder, m7844v());
        int a13 = ModelHelper.a(flatBufferBuilder, m7845w());
        int a14 = ModelHelper.a(flatBufferBuilder, m7846x());
        int a15 = ModelHelper.a(flatBufferBuilder, m7847y());
        int a16 = ModelHelper.a(flatBufferBuilder, m7848z());
        int a17 = ModelHelper.a(flatBufferBuilder, m7822A());
        int b2 = flatBufferBuilder.b(m7823B());
        int a18 = ModelHelper.a(flatBufferBuilder, m7824C());
        int a19 = ModelHelper.a(flatBufferBuilder, m7825D());
        int a20 = ModelHelper.a(flatBufferBuilder, m7826E());
        int a21 = ModelHelper.a(flatBufferBuilder, m7827F());
        int a22 = ModelHelper.a(flatBufferBuilder, m7828G());
        flatBufferBuilder.c(24);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        flatBufferBuilder.b(5, a6);
        flatBufferBuilder.b(6, a7);
        flatBufferBuilder.b(7, a8);
        flatBufferBuilder.b(8, a9);
        flatBufferBuilder.b(9, a10);
        flatBufferBuilder.b(10, b);
        flatBufferBuilder.b(11, a11);
        flatBufferBuilder.b(12, a12);
        flatBufferBuilder.b(13, a13);
        flatBufferBuilder.b(14, a14);
        flatBufferBuilder.b(15, a15);
        flatBufferBuilder.b(16, a16);
        flatBufferBuilder.b(17, a17);
        flatBufferBuilder.b(18, b2);
        flatBufferBuilder.b(19, a18);
        flatBufferBuilder.b(20, a19);
        flatBufferBuilder.b(21, a20);
        flatBufferBuilder.b(22, a21);
        flatBufferBuilder.b(23, a22);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillCampaign(Parcel parcel) {
        super(25);
        this.f3881e = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f3882f = (GraphQLGoodwillThrowbackDataPointsConnection) parcel.readValue(GraphQLGoodwillThrowbackDataPointsConnection.class.getClassLoader());
        this.f3883g = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f3884h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3885i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3886j = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3887k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3888l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3889m = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f3890n = parcel.readString();
        this.f3879A = ImmutableListHelper.a(parcel.readArrayList(GraphQLImageOverlay.class.getClassLoader()));
        this.f3891o = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f3892p = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) parcel.readValue(GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class.getClassLoader());
        this.f3893q = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3894r = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3895s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3896t = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3897u = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3898v = parcel.readString();
        this.f3899w = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3900x = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3901y = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3902z = (GraphQLGoodwillVideoCampaign) parcel.readValue(GraphQLGoodwillVideoCampaign.class.getClassLoader());
        this.f3880d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7833k());
        parcel.writeValue(m7834l());
        parcel.writeList(m7835m());
        parcel.writeValue(m7836n());
        parcel.writeValue(m7837o());
        parcel.writeValue(m7838p());
        parcel.writeValue(m7839q());
        parcel.writeValue(m7840r());
        parcel.writeValue(m7841s());
        parcel.writeString(m7842t());
        parcel.writeList(m7828G());
        parcel.writeList(m7843u());
        parcel.writeValue(m7844v());
        parcel.writeValue(m7845w());
        parcel.writeValue(m7846x());
        parcel.writeValue(m7847y());
        parcel.writeValue(m7848z());
        parcel.writeValue(m7822A());
        parcel.writeString(m7823B());
        parcel.writeValue(m7824C());
        parcel.writeValue(m7825D());
        parcel.writeValue(m7826E());
        parcel.writeValue(m7827F());
        parcel.writeParcelable(this.f3880d, i);
    }
}
