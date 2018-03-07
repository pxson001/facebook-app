package com.facebook.registration.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.growth.model.ContactpointType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Locale;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ContactPointSuggestionDeserializer.class)
/* compiled from: language_switcher_activity_finished */
public class ContactPointSuggestion implements Parcelable {
    public static final Creator<ContactPointSuggestion> CREATOR = new C13581();
    @JsonProperty("value")
    private String contactPoint;
    @JsonProperty("type")
    private String contactPointTypeString;

    /* compiled from: language_switcher_activity_finished */
    final class C13581 implements Creator<ContactPointSuggestion> {
        C13581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactPointSuggestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactPointSuggestion[i];
        }
    }

    public ContactPointSuggestion() {
        this.contactPointTypeString = null;
        this.contactPoint = null;
    }

    public ContactPointSuggestion(Parcel parcel) {
        this.contactPointTypeString = parcel.readString();
        this.contactPoint = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.contactPointTypeString);
        parcel.writeString(this.contactPoint);
    }

    public final ContactpointType m8880a() {
        return ContactpointType.fromString(this.contactPointTypeString.toUpperCase(Locale.US));
    }

    public final String m8881b() {
        return this.contactPoint;
    }
}
