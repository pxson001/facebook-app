package com.facebook.megaphone.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: features_status */
public class FetchMegaphoneParams implements Parcelable {
    public static final Creator<FetchMegaphoneParams> CREATOR = new C05801();
    public final GraphQLMegaphoneLocation f11905a;
    public final int f11906b;
    public final int f11907c;

    /* compiled from: features_status */
    final class C05801 implements Creator<FetchMegaphoneParams> {
        C05801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMegaphoneParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMegaphoneParams[i];
        }
    }

    public FetchMegaphoneParams(GraphQLMegaphoneLocation graphQLMegaphoneLocation, int i, int i2) {
        this.f11905a = graphQLMegaphoneLocation;
        this.f11906b = i;
        this.f11907c = i2;
    }

    public FetchMegaphoneParams(Parcel parcel) {
        this.f11905a = (GraphQLMegaphoneLocation) parcel.readSerializable();
        this.f11906b = parcel.readInt();
        this.f11907c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f11905a);
        parcel.writeInt(this.f11906b);
        parcel.writeInt(this.f11907c);
    }
}
