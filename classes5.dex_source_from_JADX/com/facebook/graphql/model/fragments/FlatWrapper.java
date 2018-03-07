package com.facebook.graphql.model.fragments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.dracula.api.FlatTuple;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@com.facebook.dracula.api.FlatWrapper(implementation = FlatInterfaceMethods.class)
/* compiled from: save video file failed */
public class FlatWrapper extends FlatTuple implements MutableFlattenable, TypeModel, GraphQLVisitableModel, Cloneable {
    public static final Creator<FlatWrapper> CREATOR = new C04681();

    /* compiled from: save video file failed */
    final class C04681 implements Creator<FlatWrapper> {
        C04681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(100);
            int a = FlatInterfaceMethods.m9582a(parcel, readInt);
            flatBufferBuilder.d(a);
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new FlatWrapper(new MutableFlatBuffer(wrap, null, null, false, null), a, readInt);
        }

        public final Object[] newArray(int i) {
            return new FlatWrapper[i];
        }
    }

    public FlatWrapper(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        super(mutableFlatBuffer, i, i2);
    }

    public Object clone() {
        MutableFlatBuffer mutableFlatBuffer = this.f2927a;
        int i = this.f2928b;
        int i2 = this.f2929c;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(100);
        int a = FlatInterfaceMethods.m9581a(i, i2);
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new FlatWrapper(new MutableFlatBuffer(wrap, null, null, false, null), a, i2);
    }

    public final int jK_() {
        return this.f2929c;
    }

    public final GraphQLVisitableModel m9586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        FlatInterfaceMethods.m9584b(this.f2929c);
        return this;
    }

    @Nullable
    public final MutableFlatBuffer w_() {
        return this.f2927a;
    }

    public final int u_() {
        return this.f2928b;
    }

    public final int A_() {
        return this.f2929c;
    }

    public final int m9585a(FlatBufferBuilder flatBufferBuilder) {
        return FlatInterfaceMethods.m9581a(this.f2928b, this.f2929c);
    }

    public final void m9587a(MutableFlatBuffer mutableFlatBuffer, int i) {
        throw new UnsupportedOperationException();
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatInterfaceMethods.m9583a(this.f2928b, this.f2929c, parcel);
    }

    public int describeContents() {
        return 0;
    }
}
