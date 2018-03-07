package com.facebook.pages.app.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer(baseDeserializer = "com.facebook.ipc.model.FacebookProfileDeserializer")
@JsonDeserialize(using = FacebookProfileDeserializer.class)
/* compiled from: tap_list_service_item */
public class FacebookProfile extends com.facebook.ipc.model.FacebookProfile {
    public static final Creator<FacebookProfile> CREATOR = new C01591();
    @JsonProperty("byLine")
    public String mByline;

    /* compiled from: tap_list_service_item */
    final class C01591 implements Creator<FacebookProfile> {
        C01591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookProfile(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookProfile[i];
        }
    }

    public FacebookProfile() {
        this.mByline = null;
    }

    protected FacebookProfile(Parcel parcel) {
        super(parcel);
        this.mByline = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mByline);
    }

    public boolean equals(Object obj) {
        return (obj instanceof FacebookProfile) && this.mId == ((FacebookProfile) obj).mId;
    }
}
