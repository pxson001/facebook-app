package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_upload_session */
public class SearchMessagesParams implements Parcelable {
    public static final Creator<SearchMessagesParams> CREATOR = new C20511();
    private final ImmutableList<String> f17283a;
    private final ImmutableMap<String, Integer> f17284b;
    private final String f17285c;

    /* compiled from: contact_upload_session */
    final class C20511 implements Creator<SearchMessagesParams> {
        C20511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchMessagesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchMessagesParams[i];
        }
    }

    public SearchMessagesParams(Parcel parcel) {
        this.f17285c = parcel.readString();
        this.f17283a = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f17284b = (ImmutableMap) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17285c);
        parcel.writeStringList(this.f17283a);
        parcel.writeSerializable(this.f17284b);
    }
}
