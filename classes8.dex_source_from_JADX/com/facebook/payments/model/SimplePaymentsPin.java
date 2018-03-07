package com.facebook.payments.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: target_album */
public class SimplePaymentsPin implements PaymentsPin {
    public static final Creator<SimplePaymentsPin> CREATOR = new C01841();
    public static final SimplePaymentsPin f1763a = new SimplePaymentsPin();
    private final String f1764b;

    /* compiled from: target_album */
    final class C01841 implements Creator<SimplePaymentsPin> {
        C01841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimplePaymentsPin(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimplePaymentsPin[i];
        }
    }

    private SimplePaymentsPin() {
        this.f1764b = null;
    }

    public SimplePaymentsPin(String str) {
        this.f1764b = (String) Preconditions.checkNotNull(str);
    }

    public SimplePaymentsPin(Parcel parcel) {
        this.f1764b = parcel.readString();
    }

    public final Optional<String> mo77a() {
        return Optional.fromNullable(this.f1764b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1764b);
    }
}
