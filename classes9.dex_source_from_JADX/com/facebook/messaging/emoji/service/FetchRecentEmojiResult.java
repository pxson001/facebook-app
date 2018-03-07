package com.facebook.messaging.emoji.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ui.emoji.model.Emoji;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: mailing_address_id */
public class FetchRecentEmojiResult implements Parcelable {
    public static final Creator<FetchRecentEmojiResult> CREATOR = new C12161();
    public final ImmutableList<Emoji> f11001a;

    /* compiled from: mailing_address_id */
    final class C12161 implements Creator<FetchRecentEmojiResult> {
        C12161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchRecentEmojiResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchRecentEmojiResult[i];
        }
    }

    public FetchRecentEmojiResult(List<Emoji> list) {
        this.f11001a = ImmutableList.copyOf(list);
    }

    public FetchRecentEmojiResult(Parcel parcel) {
        this.f11001a = ImmutableList.copyOf(parcel.readArrayList(Emoji.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f11001a);
    }
}
