package com.facebook.registration.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.growth.model.ContactpointType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ContactPointSuggestionsDeserializer.class)
/* compiled from: language_switcher */
public class ContactPointSuggestions implements Parcelable {
    public static final Creator<ContactPointSuggestions> CREATOR = new C13591();
    @JsonProperty("autocomplete")
    public final List<ContactPointSuggestion> autocompleteContactPoints;
    @JsonProperty("prefill")
    public final List<ContactPointSuggestion> prefillContactPoints;

    /* compiled from: language_switcher */
    final class C13591 implements Creator<ContactPointSuggestions> {
        C13591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactPointSuggestions(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactPointSuggestions[i];
        }
    }

    /* compiled from: language_switcher */
    public enum SuggestionType {
        PREFILL,
        AUTOCOMPLETE
    }

    public ContactPointSuggestions() {
        this.prefillContactPoints = new ArrayList();
        this.autocompleteContactPoints = new ArrayList();
    }

    public ContactPointSuggestions(Parcel parcel) {
        this.prefillContactPoints = parcel.createTypedArrayList(ContactPointSuggestion.CREATOR);
        this.autocompleteContactPoints = parcel.createTypedArrayList(ContactPointSuggestion.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.prefillContactPoints);
        parcel.writeTypedList(this.autocompleteContactPoints);
    }

    @Nullable
    public final String m8885a(SuggestionType suggestionType, ContactpointType contactpointType, int i) {
        List<ContactPointSuggestion> a = m8884a(suggestionType);
        if (a == null || a.isEmpty()) {
            return null;
        }
        int i2 = 0;
        for (ContactPointSuggestion contactPointSuggestion : a) {
            int i3;
            if (contactPointSuggestion.m8880a() != contactpointType) {
                i3 = i2;
            } else if (i2 == i) {
                return contactPointSuggestion.m8881b();
            } else {
                i3 = i2 + 1;
            }
            i2 = i3;
        }
        return null;
    }

    public final List<String> m8886a(SuggestionType suggestionType, ContactpointType contactpointType) {
        List<String> arrayList = new ArrayList();
        List<ContactPointSuggestion> a = m8884a(suggestionType);
        if (a == null || a.isEmpty()) {
            return arrayList;
        }
        for (ContactPointSuggestion contactPointSuggestion : a) {
            if (contactPointSuggestion.m8880a() == contactpointType) {
                arrayList.add(contactPointSuggestion.m8881b());
            }
        }
        return arrayList;
    }

    @Nullable
    private List<ContactPointSuggestion> m8884a(SuggestionType suggestionType) {
        switch (suggestionType) {
            case PREFILL:
                return this.prefillContactPoints;
            case AUTOCOMPLETE:
                return this.autocompleteContactPoints;
            default:
                return null;
        }
    }
}
