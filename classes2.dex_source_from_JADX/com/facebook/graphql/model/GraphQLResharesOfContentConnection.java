package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: lte_pci */
public final class GraphQLResharesOfContentConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLResharesOfContentConnection> CREATOR = new C06801();
    public int f15862d;

    /* compiled from: lte_pci */
    final class C06801 implements Creator<GraphQLResharesOfContentConnection> {
        C06801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResharesOfContentConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResharesOfContentConnection[i];
        }
    }

    @FieldOffset
    public final int m22588a() {
        m9949a(0, 0);
        return this.f15862d;
    }

    final void mo2908a(int i) {
        this.f15862d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    public final int jK_() {
        return -1260671207;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLResharesOfContentConnection() {
        super(2);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15862d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21494a(0, m22588a(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLResharesOfContentConnection(Parcel parcel) {
        super(2);
        this.f15862d = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22588a());
    }

    public GraphQLResharesOfContentConnection(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15862d = builder.d;
    }
}
