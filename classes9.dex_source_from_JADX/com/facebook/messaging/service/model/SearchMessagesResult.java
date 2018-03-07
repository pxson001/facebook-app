package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.Message;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_logs_upload_types */
public class SearchMessagesResult implements Parcelable {
    public static final Creator<SearchMessagesResult> CREATOR = new C20521();
    private final ImmutableMap<String, ImmutableList<Message>> f17286a;
    private final ImmutableMap<String, Boolean> f17287b;

    /* compiled from: contact_logs_upload_types */
    final class C20521 implements Creator<SearchMessagesResult> {
        C20521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchMessagesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchMessagesResult[i];
        }
    }

    public SearchMessagesResult(Parcel parcel) {
        this.f17286a = (ImmutableMap) parcel.readSerializable();
        this.f17287b = (ImmutableMap) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f17286a);
        parcel.writeSerializable(this.f17287b);
    }

    public String toString() {
        return "SearchMessagesResult: " + this.f17286a;
    }
}
