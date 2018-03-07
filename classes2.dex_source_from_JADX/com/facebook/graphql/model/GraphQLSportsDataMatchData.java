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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: length= */
public final class GraphQLSportsDataMatchData extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLSportsDataMatchData> CREATOR = new 1();
    @Nullable
    String f17643A;
    @Nullable
    public String f17644B;
    long f17645C;
    @Nullable
    String f17646D;
    public boolean f17647E;
    @Nullable
    GraphQLPage f17648F;
    boolean f17649G;
    @Nullable
    GraphQLPage f17650d;
    @Deprecated
    @Nullable
    GraphQLPage f17651e;
    public int f17652f;
    @Deprecated
    @Nullable
    String f17653g;
    @Deprecated
    @Nullable
    String f17654h;
    @Nullable
    String f17655i;
    public int f17656j;
    @Nullable
    String f17657k;
    @Nullable
    String f17658l;
    @Nullable
    GraphQLSportsDataMatchToFactsConnection f17659m;
    @Nullable
    GraphQLSportsDataMatchToFanFavoriteConnection f17660n;
    @Deprecated
    @Nullable
    GraphQLPage f17661o;
    public int f17662p;
    @Deprecated
    @Nullable
    String f17663q;
    @Deprecated
    @Nullable
    String f17664r;
    @Nullable
    String f17665s;
    public int f17666t;
    @Nullable
    String f17667u;
    int f17668v;
    long f17669w;
    @Nullable
    GraphQLPhoto f17670x;
    @Nullable
    GraphQLImage f17671y;
    @Nullable
    String f17672z;

    @FieldOffset
    @Nullable
    public final GraphQLPage m24844j() {
        this.f17650d = (GraphQLPage) super.m9947a(this.f17650d, 0, GraphQLPage.class);
        return this.f17650d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m24845k() {
        this.f17651e = (GraphQLPage) super.m9947a(this.f17651e, 1, GraphQLPage.class);
        return this.f17651e;
    }

    @FieldOffset
    public final int m24846l() {
        m9949a(0, 2);
        return this.f17652f;
    }

    @FieldOffset
    @Nullable
    public final String m24847m() {
        this.f17653g = super.m9948a(this.f17653g, 3);
        return this.f17653g;
    }

    @FieldOffset
    @Nullable
    public final String m24848n() {
        this.f17654h = super.m9948a(this.f17654h, 4);
        return this.f17654h;
    }

    @FieldOffset
    @Nullable
    public final String m24849o() {
        this.f17655i = super.m9948a(this.f17655i, 5);
        return this.f17655i;
    }

    @FieldOffset
    public final int m24850p() {
        m9949a(0, 6);
        return this.f17656j;
    }

    @FieldOffset
    @Nullable
    public final String m24851q() {
        this.f17657k = super.m9948a(this.f17657k, 8);
        return this.f17657k;
    }

    @FieldOffset
    @Nullable
    public final String m24852r() {
        this.f17658l = super.m9948a(this.f17658l, 9);
        return this.f17658l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSportsDataMatchToFactsConnection m24853s() {
        this.f17659m = (GraphQLSportsDataMatchToFactsConnection) super.m9947a(this.f17659m, 10, GraphQLSportsDataMatchToFactsConnection.class);
        return this.f17659m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSportsDataMatchToFanFavoriteConnection m24854t() {
        this.f17660n = (GraphQLSportsDataMatchToFanFavoriteConnection) super.m9947a(this.f17660n, 11, GraphQLSportsDataMatchToFanFavoriteConnection.class);
        return this.f17660n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m24855u() {
        this.f17661o = (GraphQLPage) super.m9947a(this.f17661o, 12, GraphQLPage.class);
        return this.f17661o;
    }

    @FieldOffset
    public final int m24856v() {
        m9949a(1, 5);
        return this.f17662p;
    }

    @FieldOffset
    @Nullable
    public final String m24857w() {
        this.f17663q = super.m9948a(this.f17663q, 14);
        return this.f17663q;
    }

    @FieldOffset
    @Nullable
    public final String m24858x() {
        this.f17664r = super.m9948a(this.f17664r, 15);
        return this.f17664r;
    }

    @FieldOffset
    @Nullable
    public final String m24859y() {
        this.f17665s = super.m9948a(this.f17665s, 16);
        return this.f17665s;
    }

    @FieldOffset
    public final int m24860z() {
        m9949a(2, 1);
        return this.f17666t;
    }

    @FieldOffset
    @Nullable
    public final String m24825A() {
        this.f17667u = super.m9948a(this.f17667u, 19);
        return this.f17667u;
    }

    @FieldOffset
    public final int m24826B() {
        m9949a(2, 4);
        return this.f17668v;
    }

    @FieldOffset
    public final long m24827C() {
        m9949a(2, 5);
        return this.f17669w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m24828D() {
        this.f17670x = (GraphQLPhoto) super.m9947a(this.f17670x, 22, GraphQLPhoto.class);
        return this.f17670x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24829E() {
        this.f17671y = (GraphQLImage) super.m9947a(this.f17671y, 23, GraphQLImage.class);
        return this.f17671y;
    }

    @FieldOffset
    @Nullable
    public final String m24830F() {
        this.f17672z = super.m9948a(this.f17672z, 24);
        return this.f17672z;
    }

    @FieldOffset
    @Nullable
    public final String m24831G() {
        this.f17643A = super.m9948a(this.f17643A, 25);
        return this.f17643A;
    }

    @FieldOffset
    @Nullable
    public final String m24832H() {
        this.f17644B = super.m9948a(this.f17644B, 26);
        return this.f17644B;
    }

    @FieldOffset
    public final long m24833I() {
        m9949a(3, 3);
        return this.f17645C;
    }

    @FieldOffset
    @Nullable
    public final String m24834J() {
        this.f17646D = super.m9948a(this.f17646D, 28);
        return this.f17646D;
    }

    @FieldOffset
    public final boolean m24835K() {
        m9949a(3, 5);
        return this.f17647E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m24836L() {
        this.f17648F = (GraphQLPage) super.m9947a(this.f17648F, 32, GraphQLPage.class);
        return this.f17648F;
    }

    @FieldOffset
    public final boolean m24837M() {
        m9949a(4, 1);
        return this.f17649G;
    }

    @Nullable
    public final String mo2834a() {
        return m24825A();
    }

    public final int jK_() {
        return 827365670;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPage graphQLPage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24844j() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m24844j());
            if (m24844j() != graphQLPage) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17650d = graphQLPage;
            }
        }
        if (m24845k() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m24845k());
            if (m24845k() != graphQLPage) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17651e = graphQLPage;
            }
        }
        if (m24853s() != null) {
            GraphQLSportsDataMatchToFactsConnection graphQLSportsDataMatchToFactsConnection = (GraphQLSportsDataMatchToFactsConnection) graphQLModelMutatingVisitor.mo2928b(m24853s());
            if (m24853s() != graphQLSportsDataMatchToFactsConnection) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17659m = graphQLSportsDataMatchToFactsConnection;
            }
        }
        if (m24854t() != null) {
            GraphQLSportsDataMatchToFanFavoriteConnection graphQLSportsDataMatchToFanFavoriteConnection = (GraphQLSportsDataMatchToFanFavoriteConnection) graphQLModelMutatingVisitor.mo2928b(m24854t());
            if (m24854t() != graphQLSportsDataMatchToFanFavoriteConnection) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17660n = graphQLSportsDataMatchToFanFavoriteConnection;
            }
        }
        if (m24855u() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m24855u());
            if (m24855u() != graphQLPage) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17661o = graphQLPage;
            }
        }
        if (m24836L() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m24836L());
            if (m24836L() != graphQLPage) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17648F = graphQLPage;
            }
        }
        if (m24828D() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m24828D());
            if (m24828D() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17670x = graphQLPhoto;
            }
        }
        if (m24829E() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24829E());
            if (m24829E() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSportsDataMatchData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17671y = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("away_team_fan_count".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m24846l());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 2;
        } else if ("away_team_score".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m24850p());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 6;
        } else if ("home_team_fan_count".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m24856v());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 13;
        } else if ("home_team_score".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m24860z());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 17;
        } else if ("status_text".equals(str)) {
            consistencyTuple.f18727a = m24832H();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 26;
        } else if ("viewer_can_vote_fan_favorite".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m24835K());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 29;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        int intValue;
        if ("away_team_fan_count".equals(str)) {
            intValue = ((Integer) obj).intValue();
            this.f17652f = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 2, intValue);
            }
        } else if ("away_team_score".equals(str)) {
            intValue = ((Integer) obj).intValue();
            this.f17656j = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 6, intValue);
            }
        } else if ("home_team_fan_count".equals(str)) {
            intValue = ((Integer) obj).intValue();
            this.f17662p = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 13, intValue);
            }
        } else if ("home_team_score".equals(str)) {
            intValue = ((Integer) obj).intValue();
            this.f17666t = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 17, intValue);
            }
        } else if ("status_text".equals(str)) {
            String str2 = (String) obj;
            this.f17644B = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 26, str2);
            }
        } else if ("viewer_can_vote_fan_favorite".equals(str)) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.f17647E = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 29, booleanValue);
            }
        }
    }

    public GraphQLSportsDataMatchData() {
        super(35);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17652f = mutableFlatBuffer.m21524a(i, 2, 0);
        this.f17656j = mutableFlatBuffer.m21524a(i, 6, 0);
        this.f17662p = mutableFlatBuffer.m21524a(i, 13, 0);
        this.f17666t = mutableFlatBuffer.m21524a(i, 17, 0);
        this.f17668v = mutableFlatBuffer.m21524a(i, 20, 0);
        this.f17669w = mutableFlatBuffer.m21525a(i, 21, 0);
        this.f17645C = mutableFlatBuffer.m21525a(i, 27, 0);
        this.f17647E = mutableFlatBuffer.m21540a(i, 29);
        this.f17649G = mutableFlatBuffer.m21540a(i, 33);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24844j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24845k());
        int b = flatBufferBuilder.m21502b(m24847m());
        int b2 = flatBufferBuilder.m21502b(m24848n());
        int b3 = flatBufferBuilder.m21502b(m24849o());
        int b4 = flatBufferBuilder.m21502b(m24851q());
        int b5 = flatBufferBuilder.m21502b(m24852r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24853s());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24854t());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24855u());
        int b6 = flatBufferBuilder.m21502b(m24857w());
        int b7 = flatBufferBuilder.m21502b(m24858x());
        int b8 = flatBufferBuilder.m21502b(m24859y());
        int b9 = flatBufferBuilder.m21502b(m24825A());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24828D());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24829E());
        int b10 = flatBufferBuilder.m21502b(m24830F());
        int b11 = flatBufferBuilder.m21502b(m24831G());
        int b12 = flatBufferBuilder.m21502b(m24832H());
        int b13 = flatBufferBuilder.m21502b(m24834J());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24836L());
        flatBufferBuilder.m21510c(34);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21494a(2, m24846l(), 0);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, b2);
        flatBufferBuilder.m21507b(5, b3);
        flatBufferBuilder.m21494a(6, m24850p(), 0);
        flatBufferBuilder.m21507b(8, b4);
        flatBufferBuilder.m21507b(9, b5);
        flatBufferBuilder.m21507b(10, a3);
        flatBufferBuilder.m21507b(11, a4);
        flatBufferBuilder.m21507b(12, a5);
        flatBufferBuilder.m21494a(13, m24856v(), 0);
        flatBufferBuilder.m21507b(14, b6);
        flatBufferBuilder.m21507b(15, b7);
        flatBufferBuilder.m21507b(16, b8);
        flatBufferBuilder.m21494a(17, m24860z(), 0);
        flatBufferBuilder.m21507b(19, b9);
        flatBufferBuilder.m21494a(20, m24826B(), 0);
        flatBufferBuilder.m21495a(21, m24827C(), 0);
        flatBufferBuilder.m21507b(22, a6);
        flatBufferBuilder.m21507b(23, a7);
        flatBufferBuilder.m21507b(24, b10);
        flatBufferBuilder.m21507b(25, b11);
        flatBufferBuilder.m21507b(26, b12);
        flatBufferBuilder.m21495a(27, m24833I(), 0);
        flatBufferBuilder.m21507b(28, b13);
        flatBufferBuilder.m21498a(29, m24835K());
        flatBufferBuilder.m21507b(32, a8);
        flatBufferBuilder.m21498a(33, m24837M());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSportsDataMatchData(Parcel parcel) {
        boolean z = true;
        super(35);
        this.f17650d = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f17651e = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f17652f = parcel.readInt();
        this.f17653g = parcel.readString();
        this.f17654h = parcel.readString();
        this.f17655i = parcel.readString();
        this.f17656j = parcel.readInt();
        this.f17657k = parcel.readString();
        this.f17658l = parcel.readString();
        this.f17659m = (GraphQLSportsDataMatchToFactsConnection) parcel.readValue(GraphQLSportsDataMatchToFactsConnection.class.getClassLoader());
        this.f17660n = (GraphQLSportsDataMatchToFanFavoriteConnection) parcel.readValue(GraphQLSportsDataMatchToFanFavoriteConnection.class.getClassLoader());
        this.f17649G = parcel.readByte() == (byte) 1;
        this.f17661o = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f17662p = parcel.readInt();
        this.f17663q = parcel.readString();
        this.f17664r = parcel.readString();
        this.f17665s = parcel.readString();
        this.f17666t = parcel.readInt();
        this.f17667u = parcel.readString();
        this.f17648F = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f17668v = parcel.readInt();
        this.f17669w = parcel.readLong();
        this.f17670x = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f17671y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17672z = parcel.readString();
        this.f17643A = parcel.readString();
        this.f17644B = parcel.readString();
        this.f17645C = parcel.readLong();
        this.f17646D = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f17647E = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeValue(m24844j());
        parcel.writeValue(m24845k());
        parcel.writeInt(m24846l());
        parcel.writeString(m24847m());
        parcel.writeString(m24848n());
        parcel.writeString(m24849o());
        parcel.writeInt(m24850p());
        parcel.writeString(m24851q());
        parcel.writeString(m24852r());
        parcel.writeValue(m24853s());
        parcel.writeValue(m24854t());
        parcel.writeByte((byte) (m24837M() ? 1 : 0));
        parcel.writeValue(m24855u());
        parcel.writeInt(m24856v());
        parcel.writeString(m24857w());
        parcel.writeString(m24858x());
        parcel.writeString(m24859y());
        parcel.writeInt(m24860z());
        parcel.writeString(m24825A());
        parcel.writeValue(m24836L());
        parcel.writeInt(m24826B());
        parcel.writeLong(m24827C());
        parcel.writeValue(m24828D());
        parcel.writeValue(m24829E());
        parcel.writeString(m24830F());
        parcel.writeString(m24831G());
        parcel.writeString(m24832H());
        parcel.writeLong(m24833I());
        parcel.writeString(m24834J());
        if (!m24835K()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }
}
