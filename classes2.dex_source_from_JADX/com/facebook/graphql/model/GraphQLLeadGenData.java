package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
/* compiled from: location_pin */
public final class GraphQLLeadGenData extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenData> CREATOR = new 1();
    @Nullable
    GraphQLLeadGenContextPage f16564d;
    @Nullable
    String f16565e;
    List<GraphQLLeadGenInfoFieldData> f16566f;
    @Nullable
    GraphQLLeadGenLegalContent f16567g;
    boolean f16568h;
    List<GraphQLLeadGenPage> f16569i;
    @Nullable
    String f16570j;
    @Nullable
    String f16571k;
    boolean f16572l;

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenContextPage m23408a() {
        this.f16564d = (GraphQLLeadGenContextPage) super.m9947a(this.f16564d, 0, GraphQLLeadGenContextPage.class);
        return this.f16564d;
    }

    @FieldOffset
    @Nullable
    public final String m23411j() {
        this.f16565e = super.m9948a(this.f16565e, 1);
        return this.f16565e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLeadGenInfoFieldData> m23412k() {
        this.f16566f = super.m9944a(this.f16566f, 2, GraphQLLeadGenInfoFieldData.class);
        return (ImmutableList) this.f16566f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenLegalContent m23413l() {
        this.f16567g = (GraphQLLeadGenLegalContent) super.m9947a(this.f16567g, 3, GraphQLLeadGenLegalContent.class);
        return this.f16567g;
    }

    @FieldOffset
    public final boolean m23414m() {
        m9949a(0, 4);
        return this.f16568h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLeadGenPage> m23415n() {
        this.f16569i = super.m9944a(this.f16569i, 5, GraphQLLeadGenPage.class);
        return (ImmutableList) this.f16569i;
    }

    @FieldOffset
    @Nullable
    public final String m23416o() {
        this.f16570j = super.m9948a(this.f16570j, 6);
        return this.f16570j;
    }

    @FieldOffset
    @Nullable
    public final String m23417p() {
        this.f16571k = super.m9948a(this.f16571k, 7);
        return this.f16571k;
    }

    @FieldOffset
    public final boolean m23418q() {
        m9949a(1, 0);
        return this.f16572l;
    }

    public final int jK_() {
        return -1255887874;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23408a() != null) {
            GraphQLLeadGenContextPage graphQLLeadGenContextPage = (GraphQLLeadGenContextPage) graphQLModelMutatingVisitor.mo2928b(m23408a());
            if (m23408a() != graphQLLeadGenContextPage) {
                graphQLVisitableModel = (GraphQLLeadGenData) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16564d = graphQLLeadGenContextPage;
            }
        }
        if (m23412k() != null) {
            a = ModelHelper.m23097a(m23412k(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLLeadGenData graphQLLeadGenData = (GraphQLLeadGenData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLLeadGenData.f16566f = a.m1068b();
                graphQLVisitableModel = graphQLLeadGenData;
            }
        }
        if (m23413l() != null) {
            GraphQLLeadGenLegalContent graphQLLeadGenLegalContent = (GraphQLLeadGenLegalContent) graphQLModelMutatingVisitor.mo2928b(m23413l());
            if (m23413l() != graphQLLeadGenLegalContent) {
                graphQLVisitableModel = (GraphQLLeadGenData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16567g = graphQLLeadGenLegalContent;
            }
        }
        if (m23415n() != null) {
            a = ModelHelper.m23097a(m23415n(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLLeadGenData = (GraphQLLeadGenData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLLeadGenData.f16569i = a.m1068b();
                graphQLVisitableModel = graphQLLeadGenData;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLeadGenData() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16568h = mutableFlatBuffer.m21540a(i, 4);
        this.f16572l = mutableFlatBuffer.m21540a(i, 8);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23408a());
        int b = flatBufferBuilder.m21502b(m23411j());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m23412k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23413l());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m23415n());
        int b2 = flatBufferBuilder.m21502b(m23416o());
        int b3 = flatBufferBuilder.m21502b(m23417p());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21498a(4, m23414m());
        flatBufferBuilder.m21507b(5, a4);
        flatBufferBuilder.m21507b(6, b2);
        flatBufferBuilder.m21507b(7, b3);
        flatBufferBuilder.m21498a(8, m23418q());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLLeadGenData(Parcel parcel) {
        boolean z = true;
        super(10);
        this.f16564d = (GraphQLLeadGenContextPage) parcel.readValue(GraphQLLeadGenContextPage.class.getClassLoader());
        this.f16565e = parcel.readString();
        this.f16566f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLLeadGenInfoFieldData.class.getClassLoader()));
        this.f16567g = (GraphQLLeadGenLegalContent) parcel.readValue(GraphQLLeadGenLegalContent.class.getClassLoader());
        this.f16568h = parcel.readByte() == (byte) 1;
        this.f16569i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLLeadGenPage.class.getClassLoader()));
        this.f16570j = parcel.readString();
        this.f16571k = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f16572l = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeValue(m23408a());
        parcel.writeString(m23411j());
        parcel.writeList(m23412k());
        parcel.writeValue(m23413l());
        parcel.writeByte((byte) (m23414m() ? 1 : 0));
        parcel.writeList(m23415n());
        parcel.writeString(m23416o());
        parcel.writeString(m23417p());
        if (!m23418q()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }
}
