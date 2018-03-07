package com.facebook.messaging.composershortcuts;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: messenger_ads_message_seen_request */
public class ComposerShortcutParam implements Parcelable {
    public static final Creator<ComposerShortcutParam> CREATOR = new C11611();
    public String f10009a;

    /* compiled from: messenger_ads_message_seen_request */
    final class C11611 implements Creator<ComposerShortcutParam> {
        C11611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerShortcutParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerShortcutParam[i];
        }
    }

    public ComposerShortcutParam(String str) {
        this.f10009a = str;
    }

    public ComposerShortcutParam(Parcel parcel) {
        this.f10009a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10009a);
    }
}
