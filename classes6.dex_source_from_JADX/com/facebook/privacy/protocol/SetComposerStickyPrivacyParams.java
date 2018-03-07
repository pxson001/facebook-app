package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: static_disk_uri */
public final class SetComposerStickyPrivacyParams implements Parcelable {
    public static final Creator<SetComposerStickyPrivacyParams> CREATOR = new C02451();
    public final String f4189a;

    /* compiled from: static_disk_uri */
    final class C02451 implements Creator<SetComposerStickyPrivacyParams> {
        C02451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetComposerStickyPrivacyParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetComposerStickyPrivacyParams[i];
        }
    }

    public SetComposerStickyPrivacyParams(String str) {
        this.f4189a = str;
    }

    public SetComposerStickyPrivacyParams(Parcel parcel) {
        this.f4189a = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4189a);
    }

    public final String toString() {
        return Objects.toStringHelper(SetPrivacyEducationStateParams.class).add("privacyJson", this.f4189a).toString();
    }
}
