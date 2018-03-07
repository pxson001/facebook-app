package com.facebook.graphql.model.extras;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;

/* compiled from: eglCreateWindowSurface */
public class InfoRequestFieldExtra extends BaseExtra {
    public static final Creator<InfoRequestFieldExtra> CREATOR = new C04671();
    public GraphQLInfoRequestFieldStatus f4779a = GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    /* compiled from: eglCreateWindowSurface */
    final class C04671 implements Creator<InfoRequestFieldExtra> {
        C04671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new InfoRequestFieldExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new InfoRequestFieldExtra[i];
        }
    }

    protected InfoRequestFieldExtra(Parcel parcel) {
        super((byte) 0);
        m9580a((GraphQLInfoRequestFieldStatus) ParcelUtil.m3831c(parcel, GraphQLInfoRequestFieldStatus.class));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        ParcelUtil.m3820a(parcel, this.f4779a);
    }

    public final int m9578a(FlatBufferBuilder flatBufferBuilder) {
        int a = super.a(flatBufferBuilder);
        flatBufferBuilder.c(2);
        if (a > 0) {
            flatBufferBuilder.b(0, a);
        }
        flatBufferBuilder.a(1, this.f4779a);
        return flatBufferBuilder.d();
    }

    public final void m9579a(MutableFlatBuffer mutableFlatBuffer, int i) {
        super.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 0));
        this.f4779a = (GraphQLInfoRequestFieldStatus) mutableFlatBuffer.a(i, 1, GraphQLInfoRequestFieldStatus.class);
    }

    public final void m9580a(GraphQLInfoRequestFieldStatus graphQLInfoRequestFieldStatus) {
        if (graphQLInfoRequestFieldStatus != this.f4779a) {
            this.f4779a = graphQLInfoRequestFieldStatus;
            c();
        }
    }
}
