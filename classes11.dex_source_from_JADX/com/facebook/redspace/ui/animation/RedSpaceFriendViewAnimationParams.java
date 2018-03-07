package com.facebook.redspace.ui.animation;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_ON_EXIT */
public class RedSpaceFriendViewAnimationParams implements Parcelable {
    public static final Creator<RedSpaceFriendViewAnimationParams> CREATOR = new C14731();
    public String f12435a;
    public Rect f12436b;

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_ON_EXIT */
    final class C14731 implements Creator<RedSpaceFriendViewAnimationParams> {
        C14731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RedSpaceFriendViewAnimationParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RedSpaceFriendViewAnimationParams[i];
        }
    }

    public RedSpaceFriendViewAnimationParams(String str, Rect rect) {
        this.f12435a = str;
        this.f12436b = rect;
    }

    public RedSpaceFriendViewAnimationParams(Parcel parcel) {
        this.f12435a = parcel.readString();
        this.f12436b = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12435a);
        parcel.writeParcelable(this.f12436b, i);
    }

    public int describeContents() {
        return 0;
    }
}
