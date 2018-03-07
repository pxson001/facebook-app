package com.facebook.messaging.payment.value.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: excluded_ids */
public class MessengerPayAmount implements Parcelable {
    public static final Creator<MessengerPayAmount> CREATOR = new C18021();
    public final String f15442a;
    public final String f15443b;

    /* compiled from: excluded_ids */
    final class C18021 implements Creator<MessengerPayAmount> {
        C18021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessengerPayAmount(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessengerPayAmount[i];
        }
    }

    public MessengerPayAmount(String str, String str2) {
        this.f15442a = str;
        this.f15443b = str2;
    }

    public MessengerPayAmount(String str) {
        this.f15442a = str;
        this.f15443b = "USD";
    }

    public MessengerPayAmount(Parcel parcel) {
        this.f15442a = parcel.readString();
        this.f15443b = parcel.readString();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("paymentString", this.f15442a).add("currency", this.f15443b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15442a);
        parcel.writeString(this.f15443b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessengerPayAmount messengerPayAmount = (MessengerPayAmount) obj;
        if (!StringUtil.a(this.f15442a, messengerPayAmount.f15442a)) {
            return false;
        }
        if (StringUtil.a(this.f15443b, messengerPayAmount.f15443b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15442a, this.f15443b});
    }
}
