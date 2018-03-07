package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
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
/* compiled from: likers_fetch_limit */
public final class GraphQLPageCallToAction extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPageCallToAction> CREATOR = new 1();
    public GraphQLCallToActionType f17493d;
    @Nullable
    public String f17494e;
    @Nullable
    public String f17495f;
    @Nullable
    public GraphQLApplication f17496g;
    public GraphQLPageCallToActionType f17497h;
    @Nullable
    public String f17498i;
    @Nullable
    public String f17499j;
    @Nullable
    public String f17500k;
    @Nullable
    public String f17501l;
    public boolean f17502m;
    @Nullable
    public String f17503n;
    @Nullable
    public GraphQLPhoneNumber f17504o;
    @Nullable
    public String f17505p;
    @Nullable
    public String f17506q;
    public boolean f17507r;

    @FieldOffset
    public final GraphQLCallToActionType m24616j() {
        this.f17493d = (GraphQLCallToActionType) super.m9945a(this.f17493d, 0, GraphQLCallToActionType.class, GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17493d;
    }

    @FieldOffset
    @Nullable
    public final String m24617k() {
        this.f17494e = super.m9948a(this.f17494e, 1);
        return this.f17494e;
    }

    @FieldOffset
    @Nullable
    public final String m24618l() {
        this.f17495f = super.m9948a(this.f17495f, 2);
        return this.f17495f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m24619m() {
        this.f17496g = (GraphQLApplication) super.m9947a(this.f17496g, 3, GraphQLApplication.class);
        return this.f17496g;
    }

    @FieldOffset
    public final GraphQLPageCallToActionType m24620n() {
        this.f17497h = (GraphQLPageCallToActionType) super.m9945a(this.f17497h, 4, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17497h;
    }

    @FieldOffset
    @Nullable
    public final String m24621o() {
        this.f17498i = super.m9948a(this.f17498i, 5);
        return this.f17498i;
    }

    @FieldOffset
    @Nullable
    public final String m24622p() {
        this.f17499j = super.m9948a(this.f17499j, 6);
        return this.f17499j;
    }

    @FieldOffset
    @Nullable
    public final String m24623q() {
        this.f17500k = super.m9948a(this.f17500k, 7);
        return this.f17500k;
    }

    @FieldOffset
    @Nullable
    public final String m24624r() {
        this.f17501l = super.m9948a(this.f17501l, 8);
        return this.f17501l;
    }

    @FieldOffset
    public final boolean m24625s() {
        m9949a(1, 1);
        return this.f17502m;
    }

    @FieldOffset
    @Nullable
    public final String m24626t() {
        this.f17503n = super.m9948a(this.f17503n, 10);
        return this.f17503n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoneNumber m24627u() {
        this.f17504o = (GraphQLPhoneNumber) super.m9947a(this.f17504o, 11, GraphQLPhoneNumber.class);
        return this.f17504o;
    }

    @FieldOffset
    @Nullable
    public final String m24628v() {
        this.f17505p = super.m9948a(this.f17505p, 12);
        return this.f17505p;
    }

    @FieldOffset
    @Nullable
    public final String m24629w() {
        this.f17506q = super.m9948a(this.f17506q, 13);
        return this.f17506q;
    }

    @FieldOffset
    public final boolean m24630x() {
        m9949a(1, 6);
        return this.f17507r;
    }

    @Nullable
    public final String mo2834a() {
        return m24624r();
    }

    public final int jK_() {
        return 133279070;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24619m() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m24619m());
            if (m24619m() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLPageCallToAction) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17496g = graphQLApplication;
            }
        }
        if (m24627u() != null) {
            GraphQLPhoneNumber graphQLPhoneNumber = (GraphQLPhoneNumber) graphQLModelMutatingVisitor.mo2928b(m24627u());
            if (m24627u() != graphQLPhoneNumber) {
                graphQLVisitableModel = (GraphQLPageCallToAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17504o = graphQLPhoneNumber;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPageCallToAction() {
        super(16);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17502m = mutableFlatBuffer.m21540a(i, 9);
        this.f17507r = mutableFlatBuffer.m21540a(i, 14);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24617k());
        int b2 = flatBufferBuilder.m21502b(m24618l());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24619m());
        int b3 = flatBufferBuilder.m21502b(m24621o());
        int b4 = flatBufferBuilder.m21502b(m24622p());
        int b5 = flatBufferBuilder.m21502b(m24623q());
        int b6 = flatBufferBuilder.m21502b(m24624r());
        int b7 = flatBufferBuilder.m21502b(m24626t());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24627u());
        int b8 = flatBufferBuilder.m21502b(m24628v());
        int b9 = flatBufferBuilder.m21502b(m24629w());
        flatBufferBuilder.m21510c(15);
        flatBufferBuilder.m21496a(0, m24616j() == GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24616j());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21496a(4, m24620n() == GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24620n());
        flatBufferBuilder.m21507b(5, b3);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, b5);
        flatBufferBuilder.m21507b(8, b6);
        flatBufferBuilder.m21498a(9, m24625s());
        flatBufferBuilder.m21507b(10, b7);
        flatBufferBuilder.m21507b(11, a2);
        flatBufferBuilder.m21507b(12, b8);
        flatBufferBuilder.m21507b(13, b9);
        flatBufferBuilder.m21498a(14, m24630x());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPageCallToAction(Parcel parcel) {
        boolean z = true;
        super(16);
        this.f17493d = GraphQLCallToActionType.fromString(parcel.readString());
        this.f17494e = parcel.readString();
        this.f17495f = parcel.readString();
        this.f17496g = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f17507r = parcel.readByte() == (byte) 1;
        this.f17497h = GraphQLPageCallToActionType.fromString(parcel.readString());
        this.f17498i = parcel.readString();
        this.f17499j = parcel.readString();
        this.f17500k = parcel.readString();
        this.f17501l = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f17502m = z;
        this.f17503n = parcel.readString();
        this.f17504o = (GraphQLPhoneNumber) parcel.readValue(GraphQLPhoneNumber.class.getClassLoader());
        this.f17505p = parcel.readString();
        this.f17506q = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(m24616j().name());
        parcel.writeString(m24617k());
        parcel.writeString(m24618l());
        parcel.writeValue(m24619m());
        parcel.writeByte((byte) (m24630x() ? 1 : 0));
        parcel.writeString(m24620n().name());
        parcel.writeString(m24621o());
        parcel.writeString(m24622p());
        parcel.writeString(m24623q());
        parcel.writeString(m24624r());
        if (!m24625s()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m24626t());
        parcel.writeValue(m24627u());
        parcel.writeString(m24628v());
        parcel.writeString(m24629w());
    }
}
