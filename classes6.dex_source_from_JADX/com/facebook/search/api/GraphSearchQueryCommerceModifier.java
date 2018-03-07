package com.facebook.search.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.ForSaleInputForSaleAvailability;

/* compiled from: extra_simple_picker_launcher_waterfall_id */
public class GraphSearchQueryCommerceModifier implements Parcelable {
    public static final Creator<GraphSearchQueryCommerceModifier> CREATOR = new C10981();
    public ForSaleInputForSaleAvailability f15473a;
    public boolean f15474b;
    public boolean f15475c;

    /* compiled from: extra_simple_picker_launcher_waterfall_id */
    final class C10981 implements Creator<GraphSearchQueryCommerceModifier> {
        C10981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            boolean[] zArr = new boolean[2];
            ForSaleInputForSaleAvailability valueOf = ForSaleInputForSaleAvailability.valueOf(parcel.readString());
            parcel.readBooleanArray(zArr);
            Builder builder = new Builder();
            builder.f15470a = zArr[0];
            builder = builder;
            builder.f15471b = zArr[1];
            Builder builder2 = builder;
            builder2.f15472c = valueOf;
            return builder2.m23105a();
        }

        public final Object[] newArray(int i) {
            return new GraphSearchQueryCommerceModifier[i];
        }
    }

    /* compiled from: extra_simple_picker_launcher_waterfall_id */
    public class Builder {
        public boolean f15470a;
        public boolean f15471b;
        public ForSaleInputForSaleAvailability f15472c;

        public final GraphSearchQueryCommerceModifier m23105a() {
            return new GraphSearchQueryCommerceModifier(this);
        }
    }

    public GraphSearchQueryCommerceModifier(Builder builder) {
        this.f15474b = builder.f15470a;
        this.f15475c = builder.f15471b;
        this.f15473a = builder.f15472c;
    }

    public final boolean m23106b() {
        return this.f15475c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15473a.name());
        parcel.writeBooleanArray(new boolean[]{this.f15474b, this.f15475c});
    }
}
