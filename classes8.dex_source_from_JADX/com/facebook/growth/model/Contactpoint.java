package com.facebook.growth.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ContactpointDeserializer.class)
@Immutable
/* compiled from: eligible_call_to_actions */
public class Contactpoint implements Parcelable {
    public static final Creator<Contactpoint> CREATOR = new C16141();
    @JsonProperty("iso_country_code")
    public final String isoCountryCode;
    @JsonProperty("normalized_contactpoint")
    public final String normalized;
    @JsonProperty("contactpoint_type")
    public final ContactpointType type;

    /* compiled from: eligible_call_to_actions */
    final class C16141 implements Creator<Contactpoint> {
        C16141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Contactpoint(parcel);
        }

        public final Object[] newArray(int i) {
            return new Contactpoint[i];
        }
    }

    public static Contactpoint m17344a(String str, String str2) {
        return new Contactpoint(str, ContactpointType.PHONE, str2);
    }

    public static Contactpoint m17343a(String str) {
        return new Contactpoint(str, ContactpointType.EMAIL, null);
    }

    private Contactpoint() {
        this.normalized = null;
        this.type = ContactpointType.UNKNOWN;
        this.isoCountryCode = null;
    }

    private Contactpoint(String str, ContactpointType contactpointType, String str2) {
        this.normalized = str;
        this.type = contactpointType;
        this.isoCountryCode = str2;
    }

    public Contactpoint(Parcel parcel) {
        this.normalized = parcel.readString();
        this.type = ContactpointType.valueOf(parcel.readString());
        this.isoCountryCode = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.normalized);
        parcel.writeString(this.type.name());
        parcel.writeString(this.isoCountryCode);
    }

    public final boolean m17345a() {
        if (this.type == null || this.type == ContactpointType.UNKNOWN || StringUtil.a(this.normalized)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Contactpoint)) {
            return false;
        }
        Contactpoint contactpoint = (Contactpoint) obj;
        if (Objects.equal(this.type, contactpoint.type) && Objects.equal(this.isoCountryCode, contactpoint.isoCountryCode) && Objects.equal(this.normalized, contactpoint.normalized)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.type, this.normalized, this.isoCountryCode});
    }
}
