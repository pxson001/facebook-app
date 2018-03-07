package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AddressDeserializer.class)
@Immutable
/* compiled from: image_fetch_mms */
public class Address implements Parcelable {
    public static final Creator<Address> CREATOR = new C14781();
    @JsonProperty("postal_code")
    private final String mPostalCode;

    /* compiled from: image_fetch_mms */
    final class C14781 implements Creator<Address> {
        C14781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Address(parcel);
        }

        public final Object[] newArray(int i) {
            return new Address[i];
        }
    }

    public Address(String str) {
        this.mPostalCode = str;
    }

    protected Address(Parcel parcel) {
        this.mPostalCode = parcel.readString();
    }

    private Address() {
        this.mPostalCode = null;
    }

    public final String m13462a() {
        return this.mPostalCode;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("postal_code", this.mPostalCode).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPostalCode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mPostalCode.equals(((Address) obj).mPostalCode);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mPostalCode});
    }
}
