package com.facebook.payments.confirmation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import java.util.HashSet;
import java.util.Set;

/* compiled from: call_acknowledged */
public class SimpleConfirmationData implements Parcelable {
    public static final Creator<SimpleConfirmationData> CREATOR = new C21601();
    public Set<PostPurchaseActionType> f18628a = new HashSet();
    public ConfirmationParams f18629b;

    /* compiled from: call_acknowledged */
    final class C21601 implements Creator<SimpleConfirmationData> {
        C21601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleConfirmationData(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleConfirmationData[i];
        }
    }

    public SimpleConfirmationData(ConfirmationParams confirmationParams) {
        this.f18629b = confirmationParams;
    }

    public SimpleConfirmationData(Parcel parcel) {
        this.f18628a = ParcelUtil.b(parcel);
        this.f18629b = (ConfirmationParams) parcel.readParcelable(ConfirmationParams.class.getClassLoader());
    }

    public final boolean m18645b(PostPurchaseActionType postPurchaseActionType) {
        if (this.f18628a.contains(postPurchaseActionType)) {
            return true;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18628a);
        parcel.writeParcelable(this.f18629b, i);
    }
}
