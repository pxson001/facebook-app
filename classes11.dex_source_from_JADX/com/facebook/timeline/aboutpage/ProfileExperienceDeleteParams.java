package com.facebook.timeline.aboutpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: NEWSFEED_LARGE_IMAGE */
public class ProfileExperienceDeleteParams implements Parcelable {
    public static final Creator<ProfileExperienceDeleteParams> CREATOR = new C15511();
    public final String f13050a;

    /* compiled from: NEWSFEED_LARGE_IMAGE */
    final class C15511 implements Creator<ProfileExperienceDeleteParams> {
        C15511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfileExperienceDeleteParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfileExperienceDeleteParams[i];
        }
    }

    public ProfileExperienceDeleteParams(String str) {
        this.f13050a = str;
    }

    public ProfileExperienceDeleteParams(Parcel parcel) {
        this.f13050a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13050a);
    }

    public int describeContents() {
        return 0;
    }
}
