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
/* compiled from: local_port */
public final class GraphQLFundraiserCampaign extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFundraiserCampaign> CREATOR = new 1();
    @Nullable
    GraphQLImage f17014A;
    @Nullable
    GraphQLImage f17015B;
    @Nullable
    GraphQLTextWithEntities f17016C;
    @Nullable
    String f17017d;
    @Nullable
    GraphQLFocusedPhoto f17018e;
    @Nullable
    String f17019f;
    @Nullable
    String f17020g;
    boolean f17021h;
    @Nullable
    GraphQLFocusedPhoto f17022i;
    @Nullable
    String f17023j;
    @Nullable
    String f17024k;
    @Nullable
    String f17025l;
    @Nullable
    GraphQLFundraiserPage f17026m;
    boolean f17027n;
    @Nullable
    String f17028o;
    @Nullable
    String f17029p;
    @Nullable
    GraphQLImage f17030q;
    @Nullable
    String f17031r;
    @Nullable
    String f17032s;
    double f17033t;
    @Nullable
    String f17034u;
    @Nullable
    GraphQLTextWithEntities f17035v;
    @Nullable
    GraphQLFundraiserCharity f17036w;
    @Nullable
    GraphQLTextWithEntities f17037x;
    @Nullable
    GraphQLImage f17038y;
    @Nullable
    String f17039z;

    @FieldOffset
    @Nullable
    public final String m24019j() {
        this.f17017d = super.m9948a(this.f17017d, 0);
        return this.f17017d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m24020k() {
        this.f17018e = (GraphQLFocusedPhoto) super.m9947a(this.f17018e, 1, GraphQLFocusedPhoto.class);
        return this.f17018e;
    }

    @FieldOffset
    @Nullable
    public final String m24021l() {
        this.f17019f = super.m9948a(this.f17019f, 2);
        return this.f17019f;
    }

    @FieldOffset
    @Nullable
    public final String m24022m() {
        this.f17020g = super.m9948a(this.f17020g, 3);
        return this.f17020g;
    }

    @FieldOffset
    public final boolean m24023n() {
        m9949a(0, 4);
        return this.f17021h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m24024o() {
        this.f17022i = (GraphQLFocusedPhoto) super.m9947a(this.f17022i, 5, GraphQLFocusedPhoto.class);
        return this.f17022i;
    }

    @FieldOffset
    @Nullable
    public final String m24025p() {
        this.f17023j = super.m9948a(this.f17023j, 6);
        return this.f17023j;
    }

    @FieldOffset
    @Nullable
    public final String m24026q() {
        this.f17024k = super.m9948a(this.f17024k, 7);
        return this.f17024k;
    }

    @FieldOffset
    @Nullable
    public final String m24027r() {
        this.f17025l = super.m9948a(this.f17025l, 8);
        return this.f17025l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFundraiserPage m24028s() {
        this.f17026m = (GraphQLFundraiserPage) super.m9947a(this.f17026m, 10, GraphQLFundraiserPage.class);
        return this.f17026m;
    }

    @FieldOffset
    public final boolean m24029t() {
        m9949a(1, 3);
        return this.f17027n;
    }

    @FieldOffset
    @Nullable
    public final String m24030u() {
        this.f17028o = super.m9948a(this.f17028o, 12);
        return this.f17028o;
    }

    @FieldOffset
    @Nullable
    public final String m24031v() {
        this.f17029p = super.m9948a(this.f17029p, 13);
        return this.f17029p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24032w() {
        this.f17030q = (GraphQLImage) super.m9947a(this.f17030q, 14, GraphQLImage.class);
        return this.f17030q;
    }

    @FieldOffset
    @Nullable
    public final String m24033x() {
        this.f17031r = super.m9948a(this.f17031r, 15);
        return this.f17031r;
    }

    @FieldOffset
    @Nullable
    public final String m24034y() {
        this.f17032s = super.m9948a(this.f17032s, 16);
        return this.f17032s;
    }

    @FieldOffset
    public final double m24035z() {
        m9949a(2, 1);
        return this.f17033t;
    }

    @FieldOffset
    @Nullable
    public final String m24006A() {
        this.f17034u = super.m9948a(this.f17034u, 18);
        return this.f17034u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24007B() {
        this.f17035v = (GraphQLTextWithEntities) super.m9947a(this.f17035v, 19, GraphQLTextWithEntities.class);
        return this.f17035v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFundraiserCharity m24008C() {
        this.f17036w = (GraphQLFundraiserCharity) super.m9947a(this.f17036w, 20, GraphQLFundraiserCharity.class);
        return this.f17036w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24009D() {
        this.f17037x = (GraphQLTextWithEntities) super.m9947a(this.f17037x, 21, GraphQLTextWithEntities.class);
        return this.f17037x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24010E() {
        this.f17038y = (GraphQLImage) super.m9947a(this.f17038y, 22, GraphQLImage.class);
        return this.f17038y;
    }

    @FieldOffset
    @Nullable
    public final String m24011F() {
        this.f17039z = super.m9948a(this.f17039z, 23);
        return this.f17039z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24012G() {
        this.f17014A = (GraphQLImage) super.m9947a(this.f17014A, 24, GraphQLImage.class);
        return this.f17014A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24013H() {
        this.f17015B = (GraphQLImage) super.m9947a(this.f17015B, 25, GraphQLImage.class);
        return this.f17015B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24014I() {
        this.f17016C = (GraphQLTextWithEntities) super.m9947a(this.f17016C, 28, GraphQLTextWithEntities.class);
        return this.f17016C;
    }

    @Nullable
    public final String mo2834a() {
        return m24030u();
    }

    public final int jK_() {
        return 98695003;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLFocusedPhoto graphQLFocusedPhoto;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24020k() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m24020k());
            if (m24020k() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17018e = graphQLFocusedPhoto;
            }
        }
        if (m24008C() != null) {
            GraphQLFundraiserCharity graphQLFundraiserCharity = (GraphQLFundraiserCharity) graphQLModelMutatingVisitor.mo2928b(m24008C());
            if (m24008C() != graphQLFundraiserCharity) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17036w = graphQLFundraiserCharity;
            }
        }
        if (m24024o() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m24024o());
            if (m24024o() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17022i = graphQLFocusedPhoto;
            }
        }
        if (m24014I() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24014I());
            if (m24014I() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17016C = graphQLTextWithEntities;
            }
        }
        if (m24007B() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24007B());
            if (m24007B() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17035v = graphQLTextWithEntities;
            }
        }
        if (m24028s() != null) {
            GraphQLFundraiserPage graphQLFundraiserPage = (GraphQLFundraiserPage) graphQLModelMutatingVisitor.mo2928b(m24028s());
            if (m24028s() != graphQLFundraiserPage) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17026m = graphQLFundraiserPage;
            }
        }
        if (m24009D() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24009D());
            if (m24009D() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17037x = graphQLTextWithEntities;
            }
        }
        if (m24010E() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24010E());
            if (m24010E() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17038y = graphQLImage;
            }
        }
        if (m24032w() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24032w());
            if (m24032w() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17030q = graphQLImage;
            }
        }
        if (m24012G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24012G());
            if (m24012G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17014A = graphQLImage;
            }
        }
        if (m24013H() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24013H());
            if (m24013H() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserCampaign) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17015B = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFundraiserCampaign() {
        super(30);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17021h = mutableFlatBuffer.m21540a(i, 4);
        this.f17027n = mutableFlatBuffer.m21540a(i, 11);
        this.f17033t = mutableFlatBuffer.m21523a(i, 17, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24019j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24020k());
        int b2 = flatBufferBuilder.m21502b(m24021l());
        int b3 = flatBufferBuilder.m21502b(m24022m());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24024o());
        int b4 = flatBufferBuilder.m21502b(m24025p());
        int b5 = flatBufferBuilder.m21502b(m24026q());
        int b6 = flatBufferBuilder.m21502b(m24027r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24028s());
        int b7 = flatBufferBuilder.m21502b(m24030u());
        int b8 = flatBufferBuilder.m21502b(m24031v());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24032w());
        int b9 = flatBufferBuilder.m21502b(m24033x());
        int b10 = flatBufferBuilder.m21502b(m24034y());
        int b11 = flatBufferBuilder.m21502b(m24006A());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24007B());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24008C());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24009D());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24010E());
        int b12 = flatBufferBuilder.m21502b(m24011F());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24012G());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24013H());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24014I());
        flatBufferBuilder.m21510c(29);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21498a(4, m24023n());
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, b5);
        flatBufferBuilder.m21507b(8, b6);
        flatBufferBuilder.m21507b(10, a3);
        flatBufferBuilder.m21498a(11, m24029t());
        flatBufferBuilder.m21507b(12, b7);
        flatBufferBuilder.m21507b(13, b8);
        flatBufferBuilder.m21507b(14, a4);
        flatBufferBuilder.m21507b(15, b9);
        flatBufferBuilder.m21507b(16, b10);
        flatBufferBuilder.m21492a(17, m24035z(), 0.0d);
        flatBufferBuilder.m21507b(18, b11);
        flatBufferBuilder.m21507b(19, a5);
        flatBufferBuilder.m21507b(20, a6);
        flatBufferBuilder.m21507b(21, a7);
        flatBufferBuilder.m21507b(22, a8);
        flatBufferBuilder.m21507b(23, b12);
        flatBufferBuilder.m21507b(24, a9);
        flatBufferBuilder.m21507b(25, a10);
        flatBufferBuilder.m21507b(28, a11);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFundraiserCampaign(Parcel parcel) {
        boolean z = true;
        super(30);
        this.f17017d = parcel.readString();
        this.f17018e = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f17019f = parcel.readString();
        this.f17020g = parcel.readString();
        this.f17021h = parcel.readByte() == (byte) 1;
        this.f17036w = (GraphQLFundraiserCharity) parcel.readValue(GraphQLFundraiserCharity.class.getClassLoader());
        this.f17022i = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f17023j = parcel.readString();
        this.f17024k = parcel.readString();
        this.f17025l = parcel.readString();
        this.f17016C = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17035v = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17026m = (GraphQLFundraiserPage) parcel.readValue(GraphQLFundraiserPage.class.getClassLoader());
        this.f17037x = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f17027n = z;
        this.f17028o = parcel.readString();
        this.f17038y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17029p = parcel.readString();
        this.f17030q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17031r = parcel.readString();
        this.f17032s = parcel.readString();
        this.f17039z = parcel.readString();
        this.f17033t = parcel.readDouble();
        this.f17014A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17015B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17034u = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(m24019j());
        parcel.writeValue(m24020k());
        parcel.writeString(m24021l());
        parcel.writeString(m24022m());
        parcel.writeByte((byte) (m24023n() ? 1 : 0));
        parcel.writeValue(m24008C());
        parcel.writeValue(m24024o());
        parcel.writeString(m24025p());
        parcel.writeString(m24026q());
        parcel.writeString(m24027r());
        parcel.writeValue(m24014I());
        parcel.writeValue(m24007B());
        parcel.writeValue(m24028s());
        parcel.writeValue(m24009D());
        if (!m24029t()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m24030u());
        parcel.writeValue(m24010E());
        parcel.writeString(m24031v());
        parcel.writeValue(m24032w());
        parcel.writeString(m24033x());
        parcel.writeString(m24034y());
        parcel.writeString(m24011F());
        parcel.writeDouble(m24035z());
        parcel.writeValue(m24012G());
        parcel.writeValue(m24013H());
        parcel.writeString(m24006A());
    }
}
