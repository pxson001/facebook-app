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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: load_balancing */
public final class GraphQLFundraiserPage extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFundraiserPage> CREATOR = new 1();
    @Nullable
    GraphQLFocusedPhoto f17203d;
    @Nullable
    GraphQLFundraiserCampaign f17204e;
    @Nullable
    GraphQLFocusedPhoto f17205f;
    @Nullable
    GraphQLImage f17206g;
    @Nullable
    String f17207h;
    @Nullable
    GraphQLImage f17208i;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f17209j;
    @Nullable
    String f17210k;
    @Nullable
    GraphQLImage f17211l;
    @Nullable
    GraphQLImage f17212m;
    @Nullable
    GraphQLImage f17213n;
    @Nullable
    GraphQLImage f17214o;
    @Nullable
    GraphQLImage f17215p;
    @Nullable
    GraphQLPhoto f17216q;
    @Nullable
    GraphQLImage f17217r;
    boolean f17218s;
    @Nullable
    GraphQLStreamingImage f17219t;
    @Nullable
    GraphQLImage f17220u;
    @Nullable
    String f17221v;

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m24250j() {
        this.f17203d = (GraphQLFocusedPhoto) super.m9947a(this.f17203d, 0, GraphQLFocusedPhoto.class);
        return this.f17203d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFundraiserCampaign m24251k() {
        this.f17204e = (GraphQLFundraiserCampaign) super.m9947a(this.f17204e, 1, GraphQLFundraiserCampaign.class);
        return this.f17204e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m24252l() {
        this.f17205f = (GraphQLFocusedPhoto) super.m9947a(this.f17205f, 3, GraphQLFocusedPhoto.class);
        return this.f17205f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24253m() {
        this.f17206g = (GraphQLImage) super.m9947a(this.f17206g, 5, GraphQLImage.class);
        return this.f17206g;
    }

    @FieldOffset
    @Nullable
    public final String m24254n() {
        this.f17207h = super.m9948a(this.f17207h, 7);
        return this.f17207h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24255o() {
        this.f17208i = (GraphQLImage) super.m9947a(this.f17208i, 8, GraphQLImage.class);
        return this.f17208i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m24256p() {
        this.f17209j = (GraphQLInlineActivitiesConnection) super.m9947a(this.f17209j, 9, GraphQLInlineActivitiesConnection.class);
        return this.f17209j;
    }

    @FieldOffset
    @Nullable
    public final String m24257q() {
        this.f17210k = super.m9948a(this.f17210k, 10);
        return this.f17210k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24258r() {
        this.f17211l = (GraphQLImage) super.m9947a(this.f17211l, 11, GraphQLImage.class);
        return this.f17211l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24259s() {
        this.f17212m = (GraphQLImage) super.m9947a(this.f17212m, 12, GraphQLImage.class);
        return this.f17212m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24260t() {
        this.f17213n = (GraphQLImage) super.m9947a(this.f17213n, 13, GraphQLImage.class);
        return this.f17213n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24261u() {
        this.f17214o = (GraphQLImage) super.m9947a(this.f17214o, 14, GraphQLImage.class);
        return this.f17214o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24262v() {
        this.f17215p = (GraphQLImage) super.m9947a(this.f17215p, 15, GraphQLImage.class);
        return this.f17215p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m24263w() {
        this.f17216q = (GraphQLPhoto) super.m9947a(this.f17216q, 16, GraphQLPhoto.class);
        return this.f17216q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24264x() {
        this.f17217r = (GraphQLImage) super.m9947a(this.f17217r, 17, GraphQLImage.class);
        return this.f17217r;
    }

    @FieldOffset
    public final boolean m24265y() {
        m9949a(2, 2);
        return this.f17218s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m24266z() {
        this.f17219t = (GraphQLStreamingImage) super.m9947a(this.f17219t, 19, GraphQLStreamingImage.class);
        return this.f17219t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24244A() {
        this.f17220u = (GraphQLImage) super.m9947a(this.f17220u, 20, GraphQLImage.class);
        return this.f17220u;
    }

    @FieldOffset
    @Nullable
    public final String m24245B() {
        this.f17221v = super.m9948a(this.f17221v, 21);
        return this.f17221v;
    }

    @Nullable
    public final String mo2834a() {
        return m24254n();
    }

    public final int jK_() {
        return 1147287130;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLFocusedPhoto graphQLFocusedPhoto;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24250j() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m24250j());
            if (m24250j() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17203d = graphQLFocusedPhoto;
            }
        }
        if (m24251k() != null) {
            GraphQLFundraiserCampaign graphQLFundraiserCampaign = (GraphQLFundraiserCampaign) graphQLModelMutatingVisitor.mo2928b(m24251k());
            if (m24251k() != graphQLFundraiserCampaign) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17204e = graphQLFundraiserCampaign;
            }
        }
        if (m24252l() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m24252l());
            if (m24252l() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17205f = graphQLFocusedPhoto;
            }
        }
        if (m24253m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24253m());
            if (m24253m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17206g = graphQLImage;
            }
        }
        if (m24255o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24255o());
            if (m24255o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17208i = graphQLImage;
            }
        }
        if (m24256p() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(m24256p());
            if (m24256p() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17209j = graphQLInlineActivitiesConnection;
            }
        }
        if (m24258r() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24258r());
            if (m24258r() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17211l = graphQLImage;
            }
        }
        if (m24259s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24259s());
            if (m24259s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17212m = graphQLImage;
            }
        }
        if (m24260t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24260t());
            if (m24260t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17213n = graphQLImage;
            }
        }
        if (m24261u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24261u());
            if (m24261u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17214o = graphQLImage;
            }
        }
        if (m24262v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24262v());
            if (m24262v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17215p = graphQLImage;
            }
        }
        if (m24263w() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m24263w());
            if (m24263w() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17216q = graphQLPhoto;
            }
        }
        if (m24264x() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24264x());
            if (m24264x() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17217r = graphQLImage;
            }
        }
        if (m24266z() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(m24266z());
            if (m24266z() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17219t = graphQLStreamingImage;
            }
        }
        if (m24244A() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24244A());
            if (m24244A() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserPage) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17220u = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFundraiserPage() {
        super(23);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17218s = mutableFlatBuffer.m21540a(i, 18);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24250j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24251k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24252l());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24253m());
        int b = flatBufferBuilder.m21502b(m24254n());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24255o());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24256p());
        int b2 = flatBufferBuilder.m21502b(m24257q());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24258r());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24259s());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24260t());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m24261u());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m24262v());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m24263w());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24264x());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24266z());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24244A());
        int b3 = flatBufferBuilder.m21502b(m24245B());
        flatBufferBuilder.m21510c(22);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(5, a4);
        flatBufferBuilder.m21507b(7, b);
        flatBufferBuilder.m21507b(8, a5);
        flatBufferBuilder.m21507b(9, a6);
        flatBufferBuilder.m21507b(10, b2);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21507b(13, a9);
        flatBufferBuilder.m21507b(14, a10);
        flatBufferBuilder.m21507b(15, a11);
        flatBufferBuilder.m21507b(16, a12);
        flatBufferBuilder.m21507b(17, a13);
        flatBufferBuilder.m21498a(18, m24265y());
        flatBufferBuilder.m21507b(19, a14);
        flatBufferBuilder.m21507b(20, a15);
        flatBufferBuilder.m21507b(21, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFundraiserPage(Parcel parcel) {
        super(23);
        this.f17203d = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f17204e = (GraphQLFundraiserCampaign) parcel.readValue(GraphQLFundraiserCampaign.class.getClassLoader());
        this.f17205f = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f17206g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17207h = parcel.readString();
        this.f17208i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17209j = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f17210k = parcel.readString();
        this.f17211l = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17212m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17213n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17214o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17215p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17216q = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f17217r = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17218s = parcel.readByte() == (byte) 1;
        this.f17219t = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f17220u = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17221v = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24250j());
        parcel.writeValue(m24251k());
        parcel.writeValue(m24252l());
        parcel.writeValue(m24253m());
        parcel.writeString(m24254n());
        parcel.writeValue(m24255o());
        parcel.writeValue(m24256p());
        parcel.writeString(m24257q());
        parcel.writeValue(m24258r());
        parcel.writeValue(m24259s());
        parcel.writeValue(m24260t());
        parcel.writeValue(m24261u());
        parcel.writeValue(m24262v());
        parcel.writeValue(m24263w());
        parcel.writeValue(m24264x());
        parcel.writeByte((byte) (m24265y() ? 1 : 0));
        parcel.writeValue(m24266z());
        parcel.writeValue(m24244A());
        parcel.writeString(m24245B());
    }
}
