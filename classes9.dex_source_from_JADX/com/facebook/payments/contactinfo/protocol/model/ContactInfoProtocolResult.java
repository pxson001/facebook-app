package com.facebook.payments.contactinfo.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ContactInfoProtocolResultDeserializer.class)
@Immutable
/* compiled from: bot */
public class ContactInfoProtocolResult implements Parcelable {
    public static final Creator<ContactInfoProtocolResult> CREATOR = new C21801();
    @JsonProperty("id")
    private final String mContactInfoId;

    /* compiled from: bot */
    final class C21801 implements Creator<ContactInfoProtocolResult> {
        C21801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactInfoProtocolResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactInfoProtocolResult[i];
        }
    }

    private ContactInfoProtocolResult() {
        this.mContactInfoId = null;
    }

    public ContactInfoProtocolResult(Parcel parcel) {
        this.mContactInfoId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mContactInfoId);
    }
}
